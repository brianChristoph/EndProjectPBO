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
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.Kelas;

/**
 *
 * @author jonat
 */
public class ManageClasses {

    public ManageClasses() {
        MainController c = new MainController();
        JFrame f = new JFrame("List Kelas");
        ArrayList <Kelas> kelas = c.getAllKelas();
        int y = 100;
        for (int i = 0; i < kelas.size(); i++) {
            JLabel title = new JLabel(kelas.get(i).getNama());
            JLabel jadwal = new JLabel(kelas.get(i).getJadwal());
            title.setBounds(25,y,200,30);
            jadwal.setBounds(50,y,200,30);
            y += 35;
            f.add(title);
            f.add(jadwal);
        }
        Buttons button = new Buttons();
        button.back.setLocation(295, 660);
        f.add(button.back);
        button.back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                f.setVisible(false);
                new AdminDashboard();
            }
        });
        f.setLayout(null);
        f.setSize(432,768);
        f.setVisible(true);
    }
    
    
}
