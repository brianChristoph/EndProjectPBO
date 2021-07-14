package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Absensi;
import model.StatusAbsensi;
import model.TipeUser;
import model.UserManager;

/**
 *
 * @author Axell Silvano;
 */
public class AttendanceController {

    DatabaseHandler conn = new DatabaseHandler();

    public ArrayList<Absensi> getAbsensiFromDB() {

	int id = UserManager.getInstance().getUser().getId();
	TipeUser tipe = UserManager.getInstance().getUser().getTipe();

	ArrayList<Absensi> listAbsensi = new ArrayList<>();

	conn.connect();

	if (tipe == TipeUser.STUDENT) {
	    listAbsensi = getListAbsensi(id);
	} else if (tipe == TipeUser.PARENT) {
	    listAbsensi = getListAbsensi(id);
	} else if (tipe == TipeUser.TEACHER) {
	    listAbsensi = getListAbsensi(id);
	}

	return listAbsensi;

    }

    private ArrayList<Absensi> getListAbsensi(int id) {
	ArrayList<Absensi> list = new ArrayList<>();

	String query = "SELECT * FROM `absensi` WHERE id_user = " + id + " ORDER BY `id_kelas` ASC";
	try {
	    Statement st = conn.con.createStatement();
	    ResultSet rs = st.executeQuery(query);

	    int last = 0;
	    while (rs.next()) {
		if (rs.getInt("id_kelas") != last) {
		    String query2 = "SELECT `nama` FROM `kelas` WHERE id_kelas = " + rs.getInt("id_kelas");
		    Statement st2 = conn.con.createStatement();
		    ResultSet rs2 = st2.executeQuery(query2);

		    while (rs2.next()) {
			ArrayList<Absensi> listAbsensi = new ArrayList<>();
			Absensi newAbsensi = new Absensi();
			newAbsensi.setClassName(rs2.getString("nama"));

			String query3 = "SELECT `hadir` FROM `absensi` WHERE id_kelas = " + rs.getInt("id_kelas") + " AND id_user = " + id;
			Statement st3 = conn.con.createStatement();
			ResultSet rs3 = st3.executeQuery(query3);
			while (rs3.next()) {
			    if (rs3.getInt("hadir") == 1) {
				newAbsensi.setHadir(StatusAbsensi.HADIR);
			    } else {
				newAbsensi.setHadir(StatusAbsensi.ALPHA);
			    }
			    listAbsensi.add(newAbsensi);
			}
			newAbsensi.setPresensi(hitungRataRata(listAbsensi));
			list.add(newAbsensi);
		    }
		}
		last = rs.getInt("id_kelas");
	    }
	    return list;
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return null;
    }

    private double hitungRataRata(ArrayList<Absensi> list) {
	double rata = 0;
	for (int i = 0; i < list.size(); i++) {
	    if (list.get(i).getHadir() == StatusAbsensi.HADIR) {
		rata++;
	    }
	}
	rata = (rata / list.size()) * 100;
	return rata;
    }

}
