package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Pengumuman;
import model.User;
import model.UserManager;
import model.TipeUser;
import model.Murid;

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
    public ArrayList getAllMurid() {
        ArrayList<Murid> listMurid = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM murid";
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Murid newMurid = new Murid();
                newMurid.setId(rs.getInt("id_murid"));
                newMurid.setNIP(rs.getString("nip"));
                newMurid.setNama(rs.getString("nama"));
                newMurid.setSPP(rs.getDouble("uang_sekolah"));
                listMurid.add(newMurid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMurid;
    }
}
