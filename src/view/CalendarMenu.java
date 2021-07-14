package view;

import java.util.ArrayList;
import javax.swing.*;
import model.*;
import controller.CalendarController;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Axell Silvano;
 */
public class CalendarMenu {

    public CalendarMenu() {

	CalendarController controller = new CalendarController();

	JFrame f = new JFrame("Schedules");
	f.setMinimumSize(new Dimension(432, 768));
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	try {
	    Header header = new Header("Calendar");
	    f.add(header.getHeader());

	    ArrayList<Kelas> schedules = controller.getKelasFromDB();

	    int tambah = 253;
	    int tambahJadwal = 277;
	    for (int i = 0; i < schedules.size(); i++) {
		JLabel kelas = new JLabel("Kelas " + schedules.get(i).getNama());
		JLabel jadwal = new JLabel("Jadwal " + schedules.get(i).getJadwal());
		kelas.setBounds(46, tambah, 108, 12);
		jadwal.setBounds(70, tambahJadwal, 235, 12);
		tambah += 60;
		tambahJadwal += 60;
		f.add(kelas);
		f.add(jadwal);

	    }

	    Buttons button = new Buttons();
	    button.back.setLocation(295, 660);
	    f.add(button.back);
	    button.back.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		    TipeUser tipe = UserManager.getInstance().getUser().getTipe();
		    f.setVisible(false);
		    if (tipe == TipeUser.STUDENT) {
			new StudentDashboard();
		    } else if (tipe == TipeUser.PARENT) {
			new ParentDashboard();
		    } else if (tipe == TipeUser.TEACHER) {
			new TeacherDashboard();
		    }
		}
	    });

	    f.setLayout(null);
	    f.setVisible(true);
	} catch (NullPointerException e) {
	    ErrorView.printError("no user");
	}
    }
}
