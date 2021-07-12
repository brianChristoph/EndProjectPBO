package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Kelas;
import model.Tugas;
import model.TipeUser;
import model.UserManager;

/**
 *
 * @author Axell Silvano;
 */
public class ReportController {

    DatabaseHandler conn = new DatabaseHandler();

    public ArrayList<Kelas> getReportsFromDB() {

        int id = UserManager.getInstance().getUser().getId();
        TipeUser tipe = UserManager.getInstance().getUser().getTipe();

        ArrayList<Kelas> list = new ArrayList<>();

        conn.connect();

        if (tipe == TipeUser.STUDENT) {
            list = getListForStudent(id);
        } else if (tipe == TipeUser.PARENT) {

        }
        return list;
    }

    private ArrayList<Kelas> getListForStudent(int id) {
        ArrayList<Kelas> list = new ArrayList<>();

        String query = "SELECT `id_kelas`, `nilai` FROM `tugas` WHERE id_murid = " + id;

        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                ArrayList<Tugas> listTugas = new ArrayList<>();
                Tugas newTugas = new Tugas();
                newTugas.setNilai(rs.getInt("nilai"));
                listTugas.add(newTugas);

                String query2 = "SELECT `nama` FROM `kelas` WHERE id_kelas = " + rs.getInt("id_kelas");
                Statement st2 = conn.con.createStatement();
                ResultSet rs2 = st2.executeQuery(query2);

                while (rs2.next()) {
                    Kelas newKelas = new Kelas();
                    newKelas.setNama(rs2.getString("nama"));
                    newKelas.setNa(hitungRataRata(listTugas));
                    list.add(newKelas);
                }

            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private double hitungRataRata(ArrayList<Tugas> tugas) {
        double rata = 0;
        for (int i = 0; i < tugas.size(); i++) {
            rata += tugas.get(i).getNilai();
        }
        rata /= tugas.size();
        return rata;
    }

}
