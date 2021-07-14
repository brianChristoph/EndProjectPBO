/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MuridController;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.Posting;
import model.Tugas;
import model.UserManager;

/**
 *
 * @author BRCS
 */
public class ViewTugas {
    
    public ViewTugas(Posting post){
        Tugas tugas = (Tugas) post;
        JFrame frame = new JFrame("Tugas");
        Font roboto = new Font("Roboto", Font.PLAIN, 18);

        JLabel identity = new JLabel("Welcome,");
        identity.setBounds(155, 72, 130, 32);
        identity.setFont(roboto);
        frame.add(identity);
        JLabel judulTugas = new JLabel(tugas.getJudul());
        judulTugas.setBounds(149, 265, 108, 12);
        frame.add(judulTugas);
        
        if(tugas.isTerkumpulkan() == true){
            JLabel nilaiTugas = new JLabel();
            nilaiTugas.setText("Nilai : " + tugas.getNilai());
            nilaiTugas.setBounds(149, 290, 235, 13);
            frame.add(nilaiTugas);
        } else {
            JLabel deskTugas = new JLabel();
            deskTugas.setText(tugas.getDeskripsi());
            deskTugas.setBounds(149, 290, 235, 13);
            frame.add(deskTugas);
            
            JButton kumpulkan = new JButton("Submit");
            kumpulkan.setBounds(149,315,100,30);
            frame.add(kumpulkan);
            kumpulkan.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed(ActionEvent e){
                   MuridController mc = new MuridController();
                   mc.submitTugas(UserManager.getInstance().getUser().getId(), tugas);
                   frame.setVisible(false);
               }
            });
        }
        
        frame.setSize(432, 768);
        frame.setLayout(null);
        frame.setVisible(true);
        
    }
    
}
