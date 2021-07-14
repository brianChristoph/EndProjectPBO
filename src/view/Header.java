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
        userName.setBounds(131, 104, 170, 32);
        section.setBounds(121, 149, 189, 36);

        header.add(welcome);
        header.add(userName);
        header.add(section);
        header.add(welcome);

        header.setSize(337, 136);
        header.setVisible(true);
        header.setLayout(null);
        header.setLocation(0,0);
        JFrame f = new JFrame("");
        f.setSize(432,768);
        f.add(header);
        f.setLayout(null);
        f.setVisible(true);
    }
  
    public JPanel getHeader() {
        return this.header;
    }
    public static void main(String[] args) {
        new Header("Test");
    }
}
