/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.Absensi;
import model.User;
import model.Guru;
import model.Murid;
import model.Kelas;
import model.Posting;
import model.StatusAbsensi;
import model.TipeUser;
import model.Tugas;
import model.UserManager;

/**
 *
 * @author BRCS
 */
public class TeacherController {

    DatabaseHandler conn = new DatabaseHandler();
    
    public Guru getUser(String nik, String password){
        conn.connect();
        Guru user = new Guru();
        user = getNonArrayDataType(user, nik, password);
        user.setAjarKelas(getTaughtClass(user, user.getId()));
        conn.disconnect();
        return user;
    }
    
    private String loginQuery(String nik, String password){
        return "SELECT * FROM guru WHERE nik = '" + nik + "' && password = '" + password + "'";
    }
    
    private Guru getNonArrayDataType(Guru user, String nik, String password){
        String query = loginQuery(nik, password);
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                user.setId(rs.getInt("id_guru"));
                user.setNik(rs.getString("nik"));
                user.setNama(rs.getString("nama"));
                user.setPassword(rs.getString("password"));
                user.setNoTlp(rs.getString("no_telepon"));
                user.setTipe(TipeUser.TEACHER);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }
    
    private ArrayList<Kelas> getTaughtClass(Guru user, int idGuru){
        ArrayList<Kelas> arrClasses = new ArrayList();
        String query = "SELECT * FROM kelas WHERE id_guru = " + idGuru;
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Kelas taughtClass = new Kelas();
                taughtClass.setId(rs.getInt("id_kelas"));
                taughtClass.setKode(rs.getString("kode"));
                taughtClass.setNama(rs.getString("nama"));
                taughtClass.setJadwal(rs.getString("jadwal"));
                taughtClass.setHomeRoomTeacher(user);
//                taughtClass.setArrAbsensiMurid(getAbsensiMurid(rs.getInt("id_kelas")));
                taughtClass.setArrPost(getPosts(rs.getInt("id_kelas")));
                taughtClass.setArrMurid(getStudentsInClass(rs.getInt("id_kelas")));
                arrClasses.add(taughtClass);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arrClasses;
    }
    
    private ArrayList<Posting> getPosts(int idKelas){
        ArrayList<Posting> arrPosts = new ArrayList();
        try {
            String queryPost = "SELECT * FROM post WHERE id_kelas = " + idKelas;
            Statement st = conn.con.createStatement();
            ResultSet rPost = st.executeQuery(queryPost);
            while(rPost.next()){
                Posting post = new Posting();
                post.setJudul(rPost.getString("judul"));
                post.setDeskripsi(rPost.getString("deskripsi"));
                arrPosts.add(post);
            }
            String queryTugas = "SELECT * FROM tugas WHERE id_kelas = " + idKelas;
            ResultSet rTugas = st.executeQuery(queryTugas);
            while(rTugas.next()){
                Tugas tgs = new Tugas();
                tgs.setJudul(rTugas.getString("judul"));
                tgs.setDeskripsi(rTugas.getString("deskripsi"));
                tgs.setTanggalPengumpulan(rTugas.getDate("tanggal_pengumpulan"));
                tgs.setTanggalDikumpulkan(rTugas.getDate("tanggal_dikumpulkan"));
                tgs.setTerkumpulkan(rTugas.getInt("terkumpulkan")==1?true:false);
                tgs.setNilai(rTugas.getInt("nilai"));
                arrPosts.add(tgs);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return arrPosts;
    }
    
    private ArrayList<Murid> getStudentsInClass(int idKelas){
        ArrayList<Murid> arrStudents = new ArrayList();
        String query = "SELECT * FROM murid_kelas WHERE id_kelas = " + idKelas;
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Murid student = getStudent(rs.getInt("id_murid"));
                arrStudents.add(student);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arrStudents;
    }
    
    private Murid getStudent(int idMurid){
        Murid murid = new Murid();
        String query = "SELECT * FROM murid WHERE id_murid = " + idMurid;
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                murid.setId(rs.getInt("id_murid"));
                murid.setNIP(rs.getString("nip"));
                murid.setNama(rs.getString("nama"));
                murid.setNoTlp(rs.getString("no_telepon"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return murid;
    }
    
    private ArrayList<Absensi> getAbsensiMurid(int idKelas){
        ArrayList<Absensi> arrAbsensi = new ArrayList();
        String query = "SELECT * FROM absensi WHERE id_kelas = " + idKelas;
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Absensi kehadiran = new Absensi();
                kehadiran.setDate(rs.getDate("tanggal"));
                kehadiran.setHadir(rs.getInt("hadir") == 1 ? StatusAbsensi.HADIR : StatusAbsensi.ALPHA);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arrAbsensi;
    }

    public void createNewPost(User pengguna, int idKelas, String judul, String post) {
        if (pengguna.getTipe().TEACHER == TipeUser.TEACHER) {
                String query = "INSERT INTO `post`(`judul`, `deskripsi`) VALUES (?,?)";
            try {
                PreparedStatement st = conn.con.prepareStatement(query);
                st.setString(1, judul);
                st.setString(2, post);
                st.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void updateClassData(Guru pengguna, int idKelas){
        for (int i = 0; i < pengguna.getAjarKelas().size(); i++) {
            if(pengguna.getAjarKelas().get(i) != null){
                if(pengguna.getAjarKelas().get(i).getId() == idKelas){
                    pengguna.getAjarKelas().get(i).setArrPost(getPosts(idKelas));
//                    pengguna.getAjarKelas().get(i).setArrAbsensiMurid(getAbsensiMurid(idKelas));
                    pengguna.getAjarKelas().get(i).setArrMurid(getStudentsInClass(idKelas));
                }
            }
        }
        UserManager.getInstance().setUser(pengguna);
    }

    public void deletePost(Guru pengguna, int idKelas, int idPost) {
        // Delete from database
        conn.connect();
        String query = "DELETE FROM post WHERE id_post = " + idPost;
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            updateClassData(pengguna, idKelas);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        conn.disconnect();
    }


    public void inputGrade(Guru pengguna, int idKelas, int idTugas, int idMurid, int nilai) {
        conn.connect();
        String query = "UPDATE tugas SET nilai = " + nilai + 
                "tanggal = '" + new Date() +
                "' WHERE id_tugas = " + idTugas + " && id_murid = " + idMurid;
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            updateClassData(pengguna, idKelas);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        conn.disconnect();
    }

    public void studentAttendance(Guru pengguna, int idKelas, Date tanggal, int hadir) {
        // Update Database
        conn.connect();
        String query = "UPDATE absensi SET tanggal = '" + tanggal + "' , hadir = " + hadir + " WHERE id_kelas = " + idKelas;
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            updateClassData(pengguna, idKelas);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        conn.disconnect();
    }
    
    public void kickStudent(Guru pengguna, int idKelas, int idMurid) {
        conn.connect();
        String query = "DELETE FROM murid_kelas WHERE id_kelas = " + idKelas + " && id_murid = " + idMurid;
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            updateClassData(pengguna, idKelas);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
