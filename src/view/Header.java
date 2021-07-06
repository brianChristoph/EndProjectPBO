/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.User;
import javax.swing.*;

/**
 *
 * @author Jow
 */
public class Header {

    static JPanel header = new JPanel();

    public Header(String user, String sectionTitle) {
        String name = user;
        JLabel welcome = new JLabel("Welcome, ");
        JLabel userName = new JLabel(name);
        JLabel section = new JLabel(sectionTitle);

        welcome.setBounds(209,96,159,42);    
        userName.setBounds(174,138,227,42);    
        section.setBounds(162,198,252,48);    
        
        header.add(welcome);
        header.add(userName);
        header.add(section);
        header.add(welcome);

        header.setSize(449, 181);
        header.setVisible(true);
        header.setLayout(null);
    }


}
