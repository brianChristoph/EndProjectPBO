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

    public Buttons() {
        manageUsers.setSize(175, 159);
        
        manageClasses.setSize(175, 159);
        
        announcement.setSize(175, 159);
        
        attandance.setSize(175, 159);
        
        classes.setSize(175, 159);
        
        payment.setSize(175, 159);
        
        calendar.setSize(175, 159);
        
        teachers.setSize(175, 159);
        
        report.setSize(175, 159);
    }
    
    
}
