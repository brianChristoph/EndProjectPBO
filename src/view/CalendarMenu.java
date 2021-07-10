package view;

import java.util.ArrayList;
import javax.swing.*;
import model.*;
import controller.CalendarController;
import java.awt.Dimension;

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
            Header header = new Header(UserManager.getInstance().getUser().getNama(), "Calendar");
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
            
            f.setLayout(null);
            f.setVisible(true);
        } catch (NullPointerException e) {
            ErrorView.printError("no user");
        }

//        JButton button1 = new JButton("Button1");
//
//        button1.setBounds(100, 200, 150, 16);
//        f.add(button1);
//
//        button1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                
//            }
//        });
    }
    
}
