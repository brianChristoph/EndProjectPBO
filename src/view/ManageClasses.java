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
            JLabel Jadwal = new JLabel(kelas.get(i).getJadwal());
            title.setBounds(25,y,200,30);
            y += 35;
            f.add(title);
        }
        f.setLayout(null);
        f.setSize(432,768);
        f.setVisible(true);
    }
    
    
}
