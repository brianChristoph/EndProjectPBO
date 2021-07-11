package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Pengumuman;
import model.UserManager;
import model.TipeUser;

/**
 *
 * @author BRCS
 */
public class MainController {

    DatabaseHandler conn = new DatabaseHandler();

    public ArrayList getAllAnnouncement() {
        ArrayList<Pengumuman> announcements = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM pengumuman";
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Pengumuman announcement = new Pengumuman(
                        rs.getString("judul"), 
                        rs.getString("deskripsi"));
                announcements.add(announcement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return announcements;
    }
    
}
