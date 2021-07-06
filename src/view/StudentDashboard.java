/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author BRCS
 */
public class StudentDashboard {

    public StudentDashboard() {
        JFrame f = new JFrame("Student Dashboard");
        JPanel head = Header.header;
        head.setLocation(0, 0);
        f.add(head);
        head.setLayout(null);
        head.setVisible(true);
        Buttons button = new Buttons();
        
        button.classes.setLocation(75, 306);
        button.calendar.setLocation(498, 306);
        button.teachers.setLocation(75, 512);
        button.report.setLocation(498, 512);
        button.attandance.setLocation(75, 718);
        button.announcement.setLocation(498, 718);
        
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
