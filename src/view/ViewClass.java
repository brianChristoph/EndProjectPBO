/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.Kelas;
import model.Posting;
import model.Tugas;

/**
 *
 * @author BRCS
 */
public class ViewClass {
    
    public ViewClass(Kelas kls){
        JFrame f = new JFrame(kls.getNama());
        Font roboto = new Font("Roboto", Font.PLAIN, 18);
        
        JLabel identity = new JLabel("Welcome,");
        identity.setBounds(155,72,130,32);
        identity.setFont(roboto);
        f.add(identity);
        
        int i = 0;
        for (Posting post : kls.getArrPost()){
            if(post != null){
                if(post instanceof Tugas){
                    JButton newButton = new JButton(post.getJudul());
                    newButton.setBounds(148, 265+(100*i), 108, 20);
                    f.add(newButton);
                    newButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e){
//                            new ViewTugas();
                            f.setVisible(false);
                        }
                    });
                } else {
                    JLabel labelJudul = new JLabel(post.getJudul());
                    labelJudul.setBounds(148, 265+(100*i), 108, 20);
                    f.add(labelJudul);
                }
                JLabel labelDeskripsi = new JLabel();
                labelDeskripsi.setText(post.getDeskripsi());
                labelDeskripsi.setBounds(148, 290+(119*i), 235, 20);
                f.add(labelDeskripsi);
            }
            i++;
        }
        
        f.setSize(432, 768);
        f.setLayout(null);
        f.setVisible(true);
        
    }
    
    public ViewClass(){}
    
}
