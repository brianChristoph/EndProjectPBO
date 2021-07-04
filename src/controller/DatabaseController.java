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
}
