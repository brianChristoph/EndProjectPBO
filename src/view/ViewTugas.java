/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import model.Posting;
import model.Tugas;

/**
 *
 * @author BRCS
 */
public class ViewTugas {
    
    public ViewTugas(Posting post){
        System.out.println("fuck");
        Tugas tugas = (Tugas) post;
        JFrame frame = new JFrame("Tugas");
        Font roboto = new Font("Roboto", Font.PLAIN, 18);

        JLabel identity = new JLabel("Welcome,");
        identity.setBounds(155, 72, 130, 32);
        identity.setFont(roboto);
        frame.add(identity);
        
        if(tugas.isTerkumpulkan() == true){
            JLabel judulTugas = new JLabel(tugas.getJudul());
//            judulTugas.setBounds();
            frame.add(judulTugas);
            JLabel nilaiTugas = new JLabel("Nilai : " + tugas.getNilai());
//            judulTugas.setBounds();
            frame.add(nilaiTugas);
        } else {
            JMenuItem open = new JMenuItem("Open File");
            open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    
                    frame.setVisible(false);
                }
            });
            JMenu file = new JMenu("File");
            file.add(open);
            JMenuBar mBar = new JMenuBar();
            mBar.setBounds(0,0,0,0);
            mBar.add(file);
            JTextArea ta = new JTextArea();
            ta.setBounds(0,0,0,0);
            frame.add(mBar);
            frame.add(ta);   
        }
        
        frame.setSize(432, 768);
        frame.setLayout(null);
        frame.setVisible(true);
        
    }
    
}
