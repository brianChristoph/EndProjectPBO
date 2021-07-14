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
import model.UserManager;
import view.Buttons;

/**
 *
 * @author BRCS
 */
public class AdminDashboard {

    public AdminDashboard() {
        JFrame f = new JFrame("Admin Dashboard");

        Header header = new Header("Admin Dashboard");
        JPanel head = header.getHeader();
        head.setLocation(0, 0);
        f.add(head);

        head.setLayout(null);
        head.setVisible(true);
        Buttons button = new Buttons();

        button.manageUsers.setLocation(56, 230);
        button.manageUsers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new manageUser();
                f.setVisible(false);
            }
        });

        button.manageClasses.setLocation(243, 230);
        button.manageClasses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new manageClass();
                f.setVisible(false);
            }
        });

        button.announcement.setLocation(56, 384);
        button.announcement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AnnouncementMenu();
                f.setVisible(false);
            }
        });
        button.logout.setLocation(286, 660);
        button.logout.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                UserManager.getInstance().setUser(null);
                new LoginScreen();
                f.setVisible(false);
            }
        });

        f.add(button.manageUsers);
        f.add(button.manageClasses);
        f.add(button.announcement);
        f.add(button.logout);

        f.setSize(432, 768);
        f.setLayout(null);
        f.setVisible(true);
    }
    
}
