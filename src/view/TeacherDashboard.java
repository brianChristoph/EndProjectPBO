/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.UserManager;

/**
 *
 * @author jonat
 */
public class TeacherDashboard {

    public TeacherDashboard() {
        JFrame f = new JFrame("Teacher Dashboard");

        Header header = new Header("Teacher Dashboard");
        JPanel head = header.getHeader();
        f.add(head);

        head.setLayout(null);
        head.setVisible(true);
        Buttons button = new Buttons();

        f.add(Header.header);
        button.classes.setLocation(56, 230);
        button.classes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClassMenu();
                f.setVisible(false);
            }
        });

        button.calendar.setLocation(243, 230);
        button.calendar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CalendarMenu();
                f.setVisible(false);
            }
        });

        button.attendance.setLocation(56, 384);
        button.attendance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AttendanceView();
                f.setVisible(false);
            }
        });
        button.announcement.setLocation(243, 384);
        button.announcement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AnnouncementMenu();
                f.setVisible(false);
            }
        });
        button.logout.setLocation(286, 660);
        button.logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserManager.getInstance().setUser(null);
                new LoginScreen();
                f.setVisible(false);
            }
        });

        f.add(button.classes);
        f.add(button.calendar);
        f.add(button.attendance);
        f.add(button.announcement);
        f.add(button.logout);

        f.setSize(432, 768);
        f.setLayout(null);
        f.setVisible(true);
    }
}
