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
        Header header = new Header("Hi","Jo");
        JPanel head = header.getHeader();
        head.setLocation(0, 0);
        f.add(head);
        head.setLayout(null);
        head.setVisible(true);
        Buttons button = new Buttons();
        
        button.classes.setLocation(56, 229);
        button.calendar.setLocation(246, 229);
        button.teachers.setLocation(56, 384);
        button.report.setLocation(246, 384);
        button.attandance.setLocation(56, 574);
        button.announcement.setLocation(246, 574);
        
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
