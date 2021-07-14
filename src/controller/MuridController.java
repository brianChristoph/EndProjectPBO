package controller;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Kelas;
import model.User;
import model.Guru;
import model.Murid;
import model.OrangTua;
import model.Kelas;
import model.Posting;
import model.TipeUser;
import model.Tugas;
import model.User;
import model.UserManager;

/**
 *
 * @author BRCS
 */
public class MuridController {
    
    DatabaseHandler conn = new DatabaseHandler();
    
    public Murid getUser(String nik, String password){
        conn.connect();
        Murid user = new Murid();
        user = getNonArrayDataType(user, nik, password);
        user.setListKelas(getFollowedClass(user.getId()));
        conn.disconnect();
        return user;
    }
    
    private String loginQuery(String nip, String password){
        return "SELECT * FROM murid WHERE nip = '" + nip + "' && password = '" + password + "'";
    }
    
    public Murid getNonArrayDataType(Murid user, String id, String password){
        String query = loginQuery(id, password);
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                user.setId(rs.getInt("id_murid"));
                user.setNIP(rs.getString("nip"));
                user.setNama(rs.getString("nama"));
                user.setPassword(rs.getString("password"));
                user.setNoTlp(rs.getString("no_telepon"));
                user.setSPP(rs.getInt("uang_sekolah"));
                user.setTipe(TipeUser.STUDENT);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }
    
    private ArrayList<Kelas> getFollowedClass(int idMurid){
        ArrayList<Kelas> arrClasses = new ArrayList();
        String query = "SELECT * FROM murid_kelas WHERE id_murid = " + idMurid;
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Kelas followClass = new Kelas();
                TeacherController tc = new TeacherController();
                followClass.setId(rs.getInt("id_kelas"));
                followClass.setKode(rs.getString("kode"));
                followClass.setNama(rs.getString("nama"));
                followClass.setJadwal(rs.getString("jadwal"));
                followClass.setArrPost(getPosts(rs.getInt("id_kelas")));
                arrClasses.add(followClass);
            }
        } catch(SQLException ex) {
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
    
    private void printError(){
        
    }
    
    private boolean isMurid(User pengguna){
        if(pengguna instanceof Murid){
            return true;
        }
        return false;
    }
    
    private void updateListKelas(Murid pengguna){
        pengguna.setListKelas(getFollowedClass(UserManager.getInstance().getUser().getId()));
        UserManager.getInstance().setUser(pengguna);
    }
    
    public void searchKelas(Murid pengguna, int idKelas){
        conn.connect();
        String query = "SELECT * FROM kelas WHERE id_kelas = " + idKelas;
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            gabungKelas(rs.getInt("id_kelas"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        conn.disconnect();
        updateListKelas(pengguna);
    }
    
    private void gabungKelas(int idKelas){
        String query = "INSERT INTO murid_kelas (`id_murid`, `id_kelas`) VALUES (?,?)";
        try {
            PreparedStatement st = conn.con.prepareStatement(query);
            st.setInt(1, UserManager.getInstance().getUser().getId());
            st.setInt(2, idKelas);
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void keluarKelas(Murid pengguna, int idKelas){
        conn.connect();
        String query = "DELETE FROM murid_kelas WHERE id_kelas = " + idKelas + " && id_murid = " + UserManager.getInstance().getUser().getId();
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        conn.disconnect();
        updateListKelas(pengguna);
    }

}