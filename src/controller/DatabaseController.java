package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    
    public User takeUser(TipeUser tipe){
        String query = "";
        switch(tipe){
            case STUDENT:
                query = "SELECT * FROM murid HWERE";
                break;
            case PARENT:
                query = "SELECT * FROM orang_tua WHERE";
                break;
            case TEACHER:
                query = "SELECT * FROM guru WHERE";
                break;
            case ADMIN:
                query = "SELECT * FROM admin WHERE";
                break;
            default:
                break;
        }
        return null;
    }
    
}
