package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.*;
import view.ErrorView;

/**
 *
 * @author BRCS
 */
public class MainController {

    DatabaseHandler conn = new DatabaseHandler();

    public boolean isRegisteredUser(User user) {
	String query = "";
	try {
	    TipeUser userType = user.getTipe();
	    if (userType == TipeUser.STUDENT) {
		Murid m = (Murid) user;
		query = "SELECT * FROM `murid` WHERE nip = " + m.getNIP() + " AND password = '" + user.getPassword() + "'";
	    } else if (userType == TipeUser.PARENT) {
		OrangTua o = (OrangTua) user;
		query = "SELECT * FROM `orang_tua` WHERE nip = " + o.getNIP() + " AND password = '" + user.getPassword() + "'";
	    } else if (userType == TipeUser.TEACHER) {
		Guru g = (Guru) user;
		query = "SELECT * FROM `guru` WHERE nik = " + g.getNik() + " AND password = '" + user.getPassword() + "'";
	    } else if (userType == TipeUser.ADMIN) {
		Admin a = (Admin) user;
		query = "SELECT * FROM `admin` WHERE nik = " + a.getNik() + " AND password = '" + user.getPassword() + "'";
	    }

	    conn.connect();
	    Statement st = conn.con.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    while (rs.next()) {
		return true;
	    }
	} catch (SQLException ex) {
	    ex.printStackTrace();
	    ErrorView.printError("NO USER FOUND");
	}
	return false;
    }

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
		String query2 = "SELECT * FROM `murid_kelas` WHERE id_murid = " + rs.getInt("id_murid");
		Statement st2 = conn.con.createStatement();
		ResultSet rs2 = st2.executeQuery(query2);
		ArrayList<Kelas> listKelas = new ArrayList<>();
		ArrayList<Integer> listIdKelas = new ArrayList<>();
		while (rs2.next()) {
		    listIdKelas.add(rs2.getInt("id_kelas"));
		}

		for (int i = 0; i < listIdKelas.size(); i++) {
		    query = "SELECT * FROM kelas WHERE id_kelas = " + listIdKelas.get(i);
		    rs = st.executeQuery(query);
		    while (rs.next()) {
			Kelas newKelas = new Kelas(
				rs.getString("nama"),
				rs.getString("kode"),
				rs.getString("jadwal"));
			listKelas.add(newKelas);
		    }
		}
		newMurid.setListKelas(listKelas);
		listMurid.add(newMurid);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return listMurid;
    }

    public ArrayList getAllTeacher() {
	ArrayList<Guru> listGuru = new ArrayList<>();
	conn.connect();
	String query = "SELECT * FROM guru";
	try {
	    Statement st = conn.con.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    while (rs.next()) {
		Guru newGuru = new Guru();
		newGuru.setId(rs.getInt("id_guru"));
		newGuru.setNik(rs.getString("nik"));
		newGuru.setNama(rs.getString("nama"));
		newGuru.setNoTlp("no_telepon");
		String query2 = "SELECT * FROM `kelas` WHERE id_guru = " + rs.getInt("id_guru");
		Statement st2 = conn.con.createStatement();
		ResultSet rs2 = st2.executeQuery(query2);
		ArrayList<Kelas> listKelas = new ArrayList<>();
		while (rs2.next()) {
		    Kelas newKelas = new Kelas();
		    newKelas.setJadwal(rs2.getString("jadwal"));
		    newKelas.setNama(rs2.getString("nama"));
		    newKelas.setKode(rs2.getString("kode"));
		    listKelas.add(newKelas);
		}
		listGuru.add(newGuru);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return listGuru;
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
    public ArrayList getAllParents() {
        ParentController pc = new ParentController();
        ArrayList<OrangTua> ortu = new ArrayList<>();
        conn.connect();
	String query = "SELECT * FROM orang_tua";
        try {
	    Statement st = conn.con.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    while (rs.next()) {
		OrangTua newOrtu = new OrangTua();
                newOrtu.setAnak(pc.getAnak(rs.getInt("id_ortu")));
                newOrtu.setNama(rs.getString("nama"));
                newOrtu.setId(rs.getInt("id_ortu"));
                newOrtu.setNIP(rs.getString("nip"));
                newOrtu.setNoTlp(rs.getString("no_telepon"));
                newOrtu.setTipe(TipeUser.PARENT);
                ortu.add(newOrtu);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
        return ortu;
    }
    
    public ArrayList getAllAdmin() {
        ArrayList<Admin> admin = new ArrayList<>();
        conn.connect();
	String query = "SELECT * FROM admin";
        try {
	    Statement st = conn.con.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    while (rs.next()) {
		Admin newAdmin = new Admin();
                newAdmin.setNama(rs.getString("nama"));
                newAdmin.setId(rs.getInt("id_admin"));
                newAdmin.setPassword(rs.getString("password"));
                newAdmin.setNik(rs.getString("nik"));
                newAdmin.setNoTlp(rs.getString("noTelp"));
                newAdmin.setTipe(TipeUser.PARENT);
                admin.add(newAdmin);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
        return admin;
    }
    public ArrayList getAllKelas() {
        ArrayList<Kelas> kelas = new ArrayList<>();
        conn.connect();
	String query = "SELECT * FROM kelas";
        try {
	    Statement st = conn.con.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    while (rs.next()) {
		Kelas newKelas = new Kelas();
                newKelas.setNama(rs.getString("nama"));
                newKelas.setId(rs.getInt("id_kelas"));
                newKelas.setJadwal(rs.getString("jadwal"));
                newKelas.setKode(rs.getString("kode"));
                kelas.add(newKelas);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
        return kelas;
    }
}
