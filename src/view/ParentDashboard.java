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

/**
 *
 * @author BRCS
 */
public class ParentDashboard {

    public ParentDashboard() {
        JFrame f = new JFrame("Prantes Dashboard");
        
        Header header = new Header("Hi","Jo");
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
                f.add(Header.header);
            }
        });
        
        button.calendar.setLocation(243, 230);
        button.calendar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new CalendarMenu();
            }
        });
        
        button.teachers.setLocation(56, 384);
        button.teachers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TeachersMenu();
            }
        });
        button.report.setLocation(243, 384);
        button.report.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new ReportMenu();
            }
        });
        button.attandance.setLocation(56, 538);
        button.attandance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new AttandanceMenu();
            }
        });
        button.announcement.setLocation(243, 538);
        button.announcement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new AnnouncementMenu();
            }
        });
        
        f.add(button.payment);
        f.add(button.calendar);
        f.add(button.teachers);
        f.add(button.report);
        f.add(button.attandance);
        f.add(button.announcement);
        
        f.setSize(432, 768);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new ParentDashboard();
    }
}
