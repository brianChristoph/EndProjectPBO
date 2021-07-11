/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;

/**
 *
 * @author jonat
 */
public class Buttons {
    JButton manageUsers = new JButton("User Management");
    JButton manageClasses = new JButton("Class Management");
    JButton announcement = new JButton("User Management");
    JButton attandance = new JButton("Attandance");
    JButton classes = new JButton ("Classes");
    JButton payment = new JButton ("Payment");
    JButton calendar = new JButton ("Calendar");
    JButton teachers = new JButton ("Teachers");
    JButton report = new JButton ("Report");
    JButton back = new JButton ("Back");
    public Buttons() {
        manageUsers.setSize(131, 120);
        
        manageClasses.setSize(131, 120);
        
        announcement.setSize(131, 120);
        
        attandance.setSize(131, 120);
        
        classes.setSize(131, 120);
        
        payment.setSize(131, 120);
        
        calendar.setSize(131, 120);
        
        teachers.setSize(131, 120);
        
        report.setSize(131, 120);
        
        back.setSize(81,36);
    }
    
    
}
