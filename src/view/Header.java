/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.User;
import javax.swing.*;
import model.UserManager;

/**
 *
 * @author Jow
 */
public class Header {

    static JPanel header = new JPanel();

    public Header(String sectionTitle) {
        JLabel welcome = new JLabel("Welcome, ");
        JLabel userName = new JLabel(UserManager.getInstance().getUser().getNama());
        JLabel section = new JLabel(sectionTitle);
      
        welcome.setBounds(156, 72, 120, 32);
        welcome.setHorizontalAlignment(SwingConstants.CENTER);
        userName.setBounds(156, 104, 120, 32);
        userName.setHorizontalAlignment(SwingConstants.CENTER);
        section.setBounds(156, 149, 120, 36);
        section.setHorizontalAlignment(SwingConstants.CENTER);

        header.add(welcome);
        header.add(userName);
        header.add(section);
        header.add(welcome);

        header.setSize(337, 136);
        header.setVisible(true);
        header.setLayout(null);
        header.setLocation(0,0);
    }
  
    public JPanel getHeader() {
        return this.header;
    }
    
}
