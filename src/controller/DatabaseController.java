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
    
    public ArrayList<Posting> getPosts(int idKelas){
        ArrayList<Posting> arrPosts = new ArrayList();
        try {
            String queryPost = "SELECT * FROM post WHERE id_kelas = " + idKelas;
            Statement stmtPost = conn.con.createStatement();
            ResultSet rPost = stmtPost.executeQuery(queryPost);
            while(rPost.next()){
                Posting post = new Posting();
                post.setJudul(rPost.getString("judul"));
                post.setDeskripsi(rPost.getString("deskripsi"));
                arrPosts.add(post);
            }
            String queryTugas = "SELECT * FROM tugas WHERE id_kelas = " + idKelas;
            Statement stmtTugas = conn.con.createStatement();
            ResultSet rTugas = stmtTugas.executeQuery(queryTugas);
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
            
        }
        return arrPosts;
    }
    
}
