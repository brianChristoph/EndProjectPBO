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
            list = getListForParent(id);
        }
        return list;
    }

    private ArrayList<Kelas> getListForParent(int id) {
        ArrayList<Kelas> list = new ArrayList<>();
        String query = "SELECT `id_murid` FROM `murid` WHERE id_ortu = " + id;
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                list = getListForStudent(rs.getInt("id_murid"));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private ArrayList<Kelas> getListForStudent(int id) {
        ArrayList<Kelas> list = new ArrayList<>();

        String query = "SELECT `id_kelas` from `tugas` WHERE id_murid = " + id + " ORDER BY `id_kelas` ASC";
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);

            int prev = 0;
            while (rs.next()) {
                if (rs.getInt("id_kelas") != prev) {
                    String query2 = "SELECT `nama` FROM `kelas` WHERE id_kelas = " + rs.getInt("id_kelas");
                    Statement st2 = conn.con.createStatement();
                    ResultSet rs2 = st2.executeQuery(query2);

                    while (rs2.next()) {
                        ArrayList<Tugas> listTugas = new ArrayList<>();
                        Kelas newKelas = new Kelas();
                        newKelas.setNama(rs2.getString("nama"));
                        newKelas.setNa(hitungRataRata(listTugas));

                        String query3 = "SELECT `nilai` FROM `tugas` WHERE id_kelas = " + rs.getInt("id_kelas") + " AND id_murid = " + id;
                        Statement st3 = conn.con.createStatement();
                        ResultSet rs3 = st3.executeQuery(query3);
                        while (rs3.next()) {
                            Tugas newTugas = new Tugas();
                            newTugas.setNilai(rs3.getInt("nilai"));
                            listTugas.add(newTugas);
                        }
                        newKelas.setNa(hitungRataRata(listTugas));
                        list.add(newKelas);
                    }
                }
                prev = rs.getInt("id_kelas");
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
