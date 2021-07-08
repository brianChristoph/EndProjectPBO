package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import model.*;
import controller.CalendarController;

/**
 *
 * @author Axell Silvano;
 */
public class Calendar {

    Calendar() {

        CalendarController controller = new CalendarController();

        JFrame f = new JFrame("Schedules");
        f.setLayout(null);

        JLabel label = new JLabel("Label");

        label.setBounds(0, 0, 75, 16);

        Header header = new Header(UserManager.getInstance().getUser().getNama(), "Calendar");

        f.add(header.getHeader());

        f.add(label);
        f.setSize(432, 768);

        f.setVisible(true);

        ArrayList<Kelas> schedules = new ArrayList<>();

        schedules = controller.getKelasFromDB();

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

    public static void main(String[] args) {
        new Calendar();
    }

}
