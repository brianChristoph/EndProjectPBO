package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Guru;
import model.Pengumuman;
import model.Kelas;
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

    public void AddPengumuman(String judul, String deskripsi) {
        
        String query = "INSERT INTO `pengumuman`"
                + " (`judul`, `deskripsi`) "
                + "VALUES "
                + "('" + judul + "', '" + deskripsi + "')";

      
        conn.connect();
        try {
            PreparedStatement preparedStmt = conn.con.prepareStatement(query);
            preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public ArrayList getTeachersByMurid(int id_murid) {
        ArrayList<Guru> guru = new ArrayList<>();
        ArrayList<Kelas> listKelas = new ArrayList<>();
        conn.connect();
        String query = "SELECT `id_kelas` FROM `murid_kelas` WHERE `id_murid` = " + id_murid;
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList<Integer> listIdKelas = new ArrayList<>();
            while (rs.next()) {
                listIdKelas.add(rs.getInt("id_kelas"));
            }

            for (int i = 0; i < listIdKelas.size(); i++) {
                query = "SELECT * FROM kelas WHERE id_kelas = " + listIdKelas.get(i);
                rs = st.executeQuery(query);
                while (rs.next()) {
                    Kelas newKelas = new Kelas(
                            rs.getString("nama"),
                            rs.getString("kode"),
                            rs.getString("jadwal"));
                    query = "SELECT * FROM guru WHERE id_guru = " + (rs.getInt("id_guru"));
                    rs = st.executeQuery(query);
                    while (rs.next()) {
                        Guru newGuru = new Guru();
                        newGuru.setNama(rs.getString("nama"));
                        newGuru.setNik(rs.getString("NIK"));
                        newGuru.setNoTlp(rs.getString("no_telepon"));
                        newKelas.setHomeRoomTeacher(newGuru);
                        guru.add(newGuru);
                    }
                    listKelas.add(newKelas);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guru;
    }

}
