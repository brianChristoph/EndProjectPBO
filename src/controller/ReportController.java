package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Tugas;
import model.TipeUser;
import model.UserManager;

/**
 *
 * @author Axell Silvano;
 */
public class ReportController {

    DatabaseHandler conn = new DatabaseHandler();

    public ArrayList<Tugas> getReportsFromDB() {

        int id = UserManager.getInstance().getUser().getId();
        TipeUser tipe = UserManager.getInstance().getUser().getTipe();

        ArrayList<Tugas> list = new ArrayList<>();

        conn.connect();

        if (tipe == TipeUser.STUDENT) {
            list = getListForStudent(id);
        } else if (tipe == TipeUser.PARENT) {

        }
        return null;
    }

    private ArrayList<Tugas> getListForStudent(int id) {
        ArrayList<Tugas> list = new ArrayList<>();

        String query = "GET `id_kelas` FROM `tugas` WHERE id_murid = " + id;

        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);

            ArrayList<Integer> listIdKelas = new ArrayList<>();
            while (rs.next()) {
                Tugas newTugas = new Tugas();
                newTugas.setNilai(rs.getInt("id_kelas"));
                list.add(newTugas);
            }
            
            query = "GET `id_kelas` FROM `nilai` WHERE id_murid = " + id;
            rs = st.executeQuery(query);
            for (int i = 0; i < list.size(); i++) {
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
