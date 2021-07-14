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
public class StudentDashboard {

    public StudentDashboard() {
        JFrame f = new JFrame("Student Dashboard");
        
        Header header = new Header("Student Dashboard");
        JPanel head = header.getHeader();
        head.setLocation(0, 0); 
        f.add(head);
        
        head.setLayout(null);
        head.setVisible(true);
        Buttons button = new Buttons();
        
        button.classes.setLocation(56, 230);
        button.classes.addActionListener(new ActionListener() {
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
        button.attandance.setLocation(56, 538);
        button.announcement.setLocation(243, 538);
        
        
        f.add(button.classes);
        f.add(button.calendar);
        f.add(button.teachers);
        f.add(button.report);
        f.add(button.attandance);
        f.add(button.announcement);
        
        f.setSize(432, 768);
        f.setLayout(null);
        f.setVisible(true);
    }
}
