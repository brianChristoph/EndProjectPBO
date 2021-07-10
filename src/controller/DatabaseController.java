package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author Axell Silvano;
 */
public class DatabaseController {

    DatabaseHandler conn = new DatabaseHandler();

    private void initializeAdmin() {
        Admin newAdmin = new Admin("112233", 1, "admin", "admin", "01234", TipeUser.ADMIN);

        String query = "SELECT * FROM admin WHERE id_admin= '" + newAdmin.getId() + "'";
        conn.connect();
        try {
            boolean admin = false;
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                admin = true;
            }

            if (admin == false) {
                query = "INSERT INTO `admin`(`id_admin`, `nik`, `nama`, `password`, `noTelp`) VALUES (?,?,?,?,?)";
                PreparedStatement stmt = conn.con.prepareStatement(query);
                stmt.setInt(1, newAdmin.getId());
                stmt.setString(2, newAdmin.getNik());
                stmt.setString(3, newAdmin.getNama());
                stmt.setString(4, newAdmin.getPassword());
                stmt.setString(5, newAdmin.getNoTlp());
                stmt.executeUpdate();
                System.out.println("new admin added");
            } else {
                System.out.println("Admin alr exists");
            }
        } catch (SQLException e) {
            System.out.println("eror" + e);
        }
    }

    public DatabaseController() {
//        initializeAdmin();
//        User user = getUser(TipeUser.TEACHER, "123", "pass");
//        User user = getUser(TipeUser.ADMIN, "112233", "admin");
//        System.out.println(user.getNama());
    }
    
    public Kelas takeKelas(int idKelas){
        conn.connect();
        String query = "SELECT * FROM kelas WHERE id_kelas = " + idKelas;
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList<Kelas> arrKelas = makeArrayListKelas(st, 0, true);
            Kelas dBaseKelas = new Kelas();
            /**
             * dBaseKelas.setHomeRoomTeacher
             * dBaseKelas.setArrMurid
             * dBaseKelas.setArrPost
             * dBaseKelas.setArrAbsensi
             */
        } catch (SQLException e) {
            System.out.println("eror" + e);
        }
        return null;
    }
    
    public String makeQuery(TipeUser tipe, String id, String pass){
        switch(tipe){
            case STUDENT:
                return "SELECT * FROM murid WHERE nip = '" + id + "' && password = '" + pass + "'";
            case PARENT:
                return "SELECT * FROM orang_tua WHERE nip = '" + id + "' && password = '" + pass + "'";
            case TEACHER:
                return "SELECT * FROM guru WHERE nik = '" + id + "' && password = '" + pass + "'";
            case ADMIN:
                return "SELECT * FROM admin WHERE nik='" + id + "' && password='" + pass + "'";
            default:
                return null;
        }
    }
    
    public User getUser(TipeUser tipe, String id, String pass){
        conn.connect();
        String query = makeQuery(tipe, id, pass);
        System.out.println(query);
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                switch(tipe){
                    case STUDENT:
                        Murid murid = new Murid();
    //                    murid.setId(rs.getInt("ID/"));
                        murid.setNama(rs.getString("nama"));
                        murid.setPassword(rs.getString("password"));
                        murid.setNoTlp(rs.getString("no_telepon"));
                        murid.setSPP(rs.getInt("uang_sekolah"));
                        murid.setTipe(TipeUser.STUDENT);
                        return murid;
                    case PARENT:
                        OrangTua orangTua = new OrangTua();
                        orangTua.setNama(rs.getString("nama"));
                        orangTua.setPassword(rs.getString("password"));
                        orangTua.setNoTlp("no_tlp");
                        orangTua.setTipe(TipeUser.PARENT);
                        return orangTua;
                    case TEACHER:
                        Guru guru = new Guru();
                        guru.setNama(rs.getString("nama"));
                        guru.setPassword(rs.getString("password"));
                        guru.setNoTlp("no_tlp");
                        guru.setTipe(TipeUser.TEACHER);
                        guru.setAjarKelas(makeArrayListKelas(st, rs.getInt("id_guru"), false));
                        return guru;
                    case ADMIN:
                        Admin admin = new Admin();
    //                    admin.setId(rs.getInt("ID"));
                        admin.setNama(rs.getString("nama"));
                        admin.setPassword(rs.getString("password"));
                        admin.setNoTlp(rs.getString("noTelp"));
                        admin.setNik(rs.getString("nik"));
                        admin.setTipe(TipeUser.ADMIN);
                        return admin;
                    default:
                        break;
                }
            }
        } catch(SQLException e){
            System.out.println("error");
        }
        return null;
    }
    
    private ArrayList<Kelas> makeArrayListKelas(Statement st, int idGuru, boolean allClass){
        ArrayList<Kelas> arrK = new ArrayList();
        String query;
        if(allClass == true)
            query = "SELECT * FROM kelas";
        else
            query = "SELECT * FROM kelas WHERE id_guru = " + idGuru;
        try{
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Kelas k = new Kelas();
                k.setHomeRoomTeacher(getGuru(st, rs.getInt("id_guru")));
                k.setArrAbsensiMurid(makeArrayListAbsensi(st, rs.getInt("id_kelas")));
                k.setArrPost(makeArrayListPost(st, rs.getInt("id_kelas")));
                k.setArrMurid(makeArrayListMurid(st, rs.getInt("id_kelas")));
                arrK.add(k);
            }
        } catch (SQLException ex) {
            // error message
        }
        return arrK;
    }
    
    private Guru getGuru(Statement st, int idGuru){
        Guru g = new Guru();
        String query = "SELECT * FROM guru WHERE id_guru = " + idGuru;
        try {
            ResultSet rs = st.executeQuery(query);
            g.setId(rs.getInt("id_guru"));
            g.setNama(rs.getString("nama"));
            g.setPassword(rs.getString("password"));
            g.setNoTlp(rs.getString("no_telepon"));
            g.setTipe(TipeUser.TEACHER);
        } catch(SQLException e) {
            
        }
        return g;
    }
    
    private ArrayList<Posting> makeArrayListPost(Statement st, int idKelas){
        ArrayList<Posting> arrP = new ArrayList();
        String query = "SELECT * FROM post WHERE id_kelas = " + idKelas;
        try{
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Posting p = new Posting();
                p.setDeskripsi(rs.getString("deskripsi"));
                p.setJudul(rs.getString("judul"));
                arrP.add(p);
            }
        } catch (SQLException e) {
            // error message
        }
        return arrP;
    }
    
    private ArrayList<Murid> makeArrayListMurid(Statement st, int idKelas){
        ArrayList<Murid> arrM = new ArrayList();
        String query = "SELECT * FROM murid_kelas WHERE id_kelas = " + idKelas;
        try{
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Murid m = new Murid();
                m.setId(rs.getInt("id_murid"));
                m.setNama(rs.getString("nama"));
                m.setPassword(rs.getString("password"));
                m.setNoTlp(rs.getString("no_telepon"));
                m.setSPP(rs.getInt("uang_sekolah"));
                m.setTipe(TipeUser.STUDENT);
                arrM.add(m);
            }
        } catch (SQLException e) {
            // error message
        }
        return arrM;
    }
    
    private ArrayList<Absensi> makeArrayListAbsensi(Statement st, int idKelas){
        ArrayList<Absensi> arrA = new ArrayList();
        String query = "SELECT * FROM absensi WHERE id_kelas = " + idKelas;
        try{
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Absensi a = new Absensi();
                a.setDate(rs.getDate("tanggal"));
                a.setHadir((rs.getInt("hadir") == 1)? StatusAbsensi.HADIR : StatusAbsensi.ALPHA);
                arrA.add(a);
            }
        } catch (SQLException e) {
            // error message
        }
        return arrA;
    }
    
    private ArrayList<Tugas> makeArrayListTugas(Statement st, int idKelas){
        ArrayList<Tugas> arrT = new ArrayList();
        String query = "SELECT * FROM tugas WHERE id_kelas = " + idKelas;
        try {
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Tugas t = new Tugas();
                t.setJudul(rs.getString("judul"));
                t.setTanggalPengumpulan(rs.getDate("tanggal_pengumpulan"));
                arrT.add(t);
            }
        } catch (SQLException e) {
            
        }
        return arrT;
    }
    
}
