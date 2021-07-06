/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;

/**
 *
 * @author BRCS
 */
public class AdminDashboard {
    
    public AdminDashboard(){
        JFrame f = new JFrame("Admin Dashboard");
        Buttons button = new Buttons();
        
        f.add(button.manageUsers);
        f.add (button.manageClasses);
        f.add (button.announcement);
        f.setVisible(true);
    }
    
}
