package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Kelas;
import model.User;
import model.UserManager;
import java.util.ArrayList;

/**
 *
 * @author Axell Silvano;
 */
public class CalendarController {

    DatabaseHandler conn = new DatabaseHandler();

    public ArrayList<Kelas> getKelasFromDB() {

        ArrayList<Kelas> schedules = new ArrayList<>();
        int id = UserManager.getInstance().getUser().getId();
        conn.connect();
        String query = "SELECT * FROM murid_kelas WHERE id_murid = " + id;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                int idKelas = rs.getInt("id_kelas");
                String queryKelas = "SELECT * FROM kelas WHERE id_kelas = " + idKelas;
                ResultSet rsKelas = stmt.executeQuery(queryKelas);

                while (rsKelas.next()) {
                    Kelas kelas = new Kelas();
//                    kelas.setNama(rsKelas.getString("nama"));
//                    kelas.setJadwal(rsKelas.getString("jadwal"));
                    schedules.add(kelas);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (schedules);

    }

}
