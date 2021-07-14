package view;

import java.util.ArrayList;
import javax.swing.*;
import model.*;
import controller.AttendanceController;
import java.awt.Dimension;

/**
 *
 * @author Axell Silvano;
 */
public class AttendanceView {

    public AttendanceView() {

	AttendanceController controller = new AttendanceController();

	JFrame f = new JFrame("Absensi");
	f.setMinimumSize(new Dimension(432, 768));
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	try {
	    Header header = new Header("Absensi");
	    f.add(header.getHeader());

	    ArrayList<Absensi> listAbsensi = controller.getAbsensiFromDB();

	    JLabel titleKelas = new JLabel("Kelas");
	    titleKelas.setBounds(60, 226, 68, 16);
	    f.add(titleKelas);

	    JLabel titleAbsensi = new JLabel("Kehadiran");
	    titleAbsensi.setBounds(295, 226, 120, 16);
	    f.add(titleAbsensi);

	    int tambah = 226;
	    int tambahAbsensi = 226;
	    for (int i = 0; i < listAbsensi.size(); i++) {
		tambah += 25;
		tambahAbsensi += 25;
		JLabel kelas = new JLabel(listAbsensi.get(i).getClassName());
		JLabel absensi = new JLabel("" + listAbsensi.get(i).getPresensi());
		kelas.setBounds(60, tambah, 108, 12);
		absensi.setBounds(295, tambahAbsensi, 235, 12);
		f.add(kelas);
		f.add(absensi);
	    }

	    f.setLayout(null);
	    f.setVisible(true);
	} catch (NullPointerException e) {
	    e.printStackTrace();
	}

    }
    
}
