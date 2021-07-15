/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MainController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import model.Admin;
import model.Guru;
import model.Murid;
import model.OrangTua;
import model.User;

/**
 *
 * @author jonat
 */
public class ManageUsers {

    public ManageUsers() {
        JFrame f = new JFrame("List User");
        MainController c = new MainController();

        ArrayList<User> listUser = c.getAllMurid();

        int startp1 = 100;
        JPanel p1 = new JPanel();
        for (int i = 0; i < listUser.size(); i++) {
            JLabel nama = new JLabel(listUser.get(i).getNama());
            nama.setBounds(25, startp1, 200, 30);
            startp1 += 35;
            p1.add(nama);
        }
        int startp2 = 100;
        ArrayList<Guru> listTeacher = c.getAllTeacher();
        JPanel p2 = new JPanel();
        JButton addGuru = new JButton("+");
        addGuru.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new InsertGuru();
            }
        });
        p2.add(addGuru);
        for (int i = 0; i < listTeacher.size(); i++) {
            JLabel nama = new JLabel(listTeacher.get(i).getNama());
            nama.setBounds(25, startp2, 200, 30);
            startp2 += 35;
            p2.add(nama);
        }
        int startp3 = 100;
        ArrayList<Admin> listAdmin = c.getAllAdmin();
        JPanel p3 = new JPanel();
        for (int i = 0; i < listAdmin.size(); i++) {
            JLabel nama = new JLabel(listAdmin.get(i).getNama());
            nama.setBounds(25, startp3, 200, 100);
            startp3 += 35;
            p3.add(nama);
        }

        JTabbedPane tp = new JTabbedPane();
        tp.setBounds(50, 50, 200, 200);
        tp.add("Murid/OrangTua", p1);
        tp.add("Guru", p2);
        tp.add("Admin", p3);
        Buttons button = new Buttons();
        button.back.setLocation(295, 660);
        f.add(button.back);
        button.back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new AdminDashboard();
            }
        });
        f.setSize(432, 768);
        f.add(tp);
        f.setLayout(null);
        f.setVisible(true);
    }

}
