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
        initializeAdmin();
    }
    
    public Kelas takeKelas(int idKelas){
        String query = "SELECT * FROM kelas WHERE id_kelas = " + idKelas;
        conn.connect();
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            Kelas dBaseKelas = new Kelas();
            /**
             * dBaseKelas.setHomeRoomTeacher
             * dBaseKelas.setArrMurid
             * dBaseKelas.setArrPost
             * dBaseKelas.setArrAbsensi
             */
        } catch (Exception e) {
            System.out.println("eror" + e);
        }
        return null;
    }
    
    public String makeQuery(TipeUser tipe){
        switch(tipe){
            case STUDENT:
                return "SELECT * FROM murid";
           case PARENT:
                return "SELECT * FROM orang_tua";
            case TEACHER:
                return "SELECT * FROM guru";
            case ADMIN:
                return "SELECT * FROM admin";
            default:
                return null;
        }
    }
    
    public User takeUser(TipeUser tipe, String id, String pass){
        String query = "";
        switch(tipe){
            case STUDENT:
                query = "SELECT * FROM murid WHERE nip = '" + id +  "' AND password = '" + pass + "'";
                break;
            case PARENT:
                query = "SELECT * FROM murid WHERE nip = '" + id +  "' AND password = '" + pass + "'";
                break;
            case TEACHER:
                query = "SELECT * FROM murid WHERE nik = '" + id +  "' AND password = '" + pass + "'";
                break;
            case ADMIN:
                query = "SELECT * FROM admin WHERE nik = '" + id +  "' AND password = '" + pass + "'";
                break;
            default:
                break;
        }
        conn.connect();
        try{
            String nama, password, noTlp, id_user;
            int uang_sekolah, id_ortu;
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            switch(tipe){
                case STUDENT:
                    Murid m = new Murid();
//                    m.setId(rs.getString("nip"));
                    m.setNama(rs.getString("nama"));
                    m.setPassword(rs.getString("password"));
                    m.setSPP(rs.getInt("uang_sekolah"));
                    m.setNoTlp("no_tlp");
                    m.setTipe(TipeUser.STUDENT);
                    return m;
                case PARENT:
                    OrangTua ot = new OrangTua();
                    ot.setNama(rs.getString("nama"));
                    ot.setPassword(rs.getString("password"));
                    ot.setNoTlp("no_tlp");
                    ot.setTipe(TipeUser.PARENT);
                case TEACHER:
                    Guru g = new Guru();
                    g.setNama(rs.getString("nama"));
                    g.setPassword(rs.getString("password"));
                    g.setNoTlp("no_tlp");
                    g.setTipe(TipeUser.TEACHER);
                    
                    ArrayList<Kelas> arrKelas = new ArrayList();
                    int id_guru = rs.getInt("id_guru");
                    
                    String queryKelas = "SELECT * FROM kelas";
                    rs = st.executeQuery(queryKelas);
                    
                    while (rs.next()) {
                        if(rs.getInt("id_guru") == id_guru){
                            Kelas ajarKelas = new Kelas();
                            ajarKelas.setHomeRoomTeacher(g);
                            // absensi
                            // post
                            // murid
                        }
                    }
                    
                case ADMIN:
                    Admin a = new Admin();
                    a.setNama(rs.getString("nama"));
                    a.setPassword(rs.getString("password"));
                    a.setNoTlp(rs.getString("no_tlp"));
                    a.setNik(rs.getString("nik"));
                    a.setTipe(TipeUser.ADMIN);
                default:
                    break;
            }
        } catch(Exception e){
            
        }
        return null;
    }
    
    private ArrayList<Posting> makeArrayListPost(Statement st){
        ArrayList<Posting> arrP = new ArrayList();
        
        return arrP;
    }
    
    private ArrayList<Murid> makeArrayListMurid(Statement st){
        ArrayList<Murid> arrM = new ArrayList();
        return arrM;
    }
    
    private ArrayList<Absensi> makeArrayListAbsensi(Statement st){
        ArrayList<Absensi> arrA = new ArrayList();
        return arrA;
    }
    
}
