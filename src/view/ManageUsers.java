/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MainController;
import java.util.ArrayList;
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
        JFrame f = new JFrame("Manage User");
        MainController c = new MainController();
        
        ArrayList<User> listUser = c.getAllParents();
        for (int i = 0; i < listUser.size(); i++) {
            OrangTua ortu = (OrangTua) listUser.get(i);
            listUser.add(ortu.getAnak());
        }
        JPanel p1 = new JPanel();
        for (int i = 0; i < listUser.size(); i++) {
            JLabel nama = new JLabel(listUser.get(i).getNama());
//            nama.setBounds();
            p1.add(nama);
        }

        ArrayList<Guru> listTeacher = c.getAllTeacher();
        JPanel p2 = new JPanel();
        for (int i = 0; i < listTeacher.size(); i++) {
            JLabel nama = new JLabel(listTeacher.get(i).getNama());
//            nama.setBounds();
            p2.add(nama);
        }

        ArrayList<Admin> listAdmin = c.getAllAdmin();
        JPanel p3 = new JPanel();
        for (int i = 0; i < listAdmin.size(); i++) {
            JLabel nama = new JLabel(listAdmin.get(i).getNama());
//            nama.setBounds();
            p3.add(nama);
        }
        
        
        JTabbedPane tp = new JTabbedPane();
        tp.setBounds(50, 50, 200, 200);
        tp.add("Murid/OrangTua", p1);
        tp.add("Guru", p2);
        tp.add("Admin", p3);
        
        f.add(tp);
        f.setLayout(null);
        f.setVisible(true);
    }

}
