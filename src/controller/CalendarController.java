package controller;

import java.sql.*;
import model.Kelas;
import model.UserManager;
import java.util.ArrayList;
import model.TipeUser;

/**
 *
 * @author Axell Silvano;
 */
public class CalendarController {

    DatabaseHandler conn = new DatabaseHandler();

    public ArrayList<Kelas> getKelasFromDB() {

        ArrayList<Kelas> schedules = new ArrayList<>();
        int id = UserManager.getInstance().getUser().getId();
        TipeUser tipe = UserManager.getInstance().getUser().getTipe();
        conn.connect();

        if (tipe == TipeUser.TEACHER) {
            schedules = getQueryTeacher(id);
        } else if (tipe == TipeUser.STUDENT) {
            schedules = getQueryStudent(id);
        } else if (tipe == TipeUser.PARENT) {
            schedules = getQueryParent(id);
        }

        return (schedules);

    }

    private ArrayList<Kelas> getQueryParent(int id) {
        ArrayList<Kelas> list = new ArrayList<>();
        try {
            String query = "SELECT `id_murid` FROM murid WHERE id_ortu = " + id;
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);

            ArrayList<Integer> listIdMurids = new ArrayList<>();
            while (rs.next()) {
                listIdMurids.add(rs.getInt("id_murid"));
            }

            ArrayList<Integer> listId = new ArrayList<>();
            for (int i = 0; i < listIdMurids.size(); i++) {
                query = "SELECT `id_kelas` FROM murid_kelas WHERE id_murid = " + listIdMurids.get(i);
                rs = st.executeQuery(query);
                while (rs.next()) {
                    listId.add(rs.getInt("id_kelas"));
                }
            }

            for (int i = 0; i < listId.size(); i++) {
                query = "SELECT * FROM kelas WHERE id_kelas = " + listId.get(i);
                rs = st.executeQuery(query);
                while (rs.next()) {
                    Kelas newKelas = new Kelas(rs.getString("nama"), rs.getString("kode"), rs.getString("jadwal"));
                    list.add(newKelas);
                }
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<Kelas> getQueryStudent(int id) {
        ArrayList<Kelas> list = new ArrayList<>();
        try {
            String query = "SELECT `id_kelas` FROM murid_kelas WHERE id_murid = " + id;
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
                    Kelas newKelas = new Kelas(rs.getString("nama"), rs.getString("kode"), rs.getString("jadwal"));
                    list.add(newKelas);
                }
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<Kelas> getQueryTeacher(int id) {
        ArrayList<Kelas> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM kelas WHERE id_guru = " + id;
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Kelas newKelas = new Kelas(rs.getString("nama"), rs.getString("kode"), rs.getString("jadwal"));
                list.add(newKelas);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
