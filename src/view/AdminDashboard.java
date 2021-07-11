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
import view.Buttons;

/**
 *
 * @author BRCS
 */
public class AdminDashboard {

    public AdminDashboard() {
        JFrame f = new JFrame("Admin Dashboard");

        Header header = new Header("Hi", "Jo");
        JPanel head = header.getHeader();
        head.setLocation(0, 0);
        f.add(head);

        head.setLayout(null);
        head.setVisible(true);
        Buttons button = new Buttons();

        button.payment.setLocation(56, 230);
        button.payment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new PaymentMenu();
                f.setVisible(false);
            }
        });

        button.calendar.setLocation(243, 230);
        button.calendar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new CalendarMenu();
                f.setVisible(false);
            }
        });

        button.teachers.setLocation(56, 384);
        button.teachers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TeachersMenu();
                f.setVisible(false);
            }
        });

        f.add(button.payment);
        f.add(button.calendar);
        f.add(button.teachers);

        f.setSize(432, 768);
        f.setLayout(null);
        f.setVisible(true);
    }

}
