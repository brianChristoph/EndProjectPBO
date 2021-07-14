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
import model.Guru;
import model.Kelas;
import model.Posting;
import model.Tugas;
import model.UserManager;

/**
 *
 * @author BRCS
 */
public class ViewClass {
    
    public ViewClass(Kelas kls){
        JFrame frame = new JFrame(kls.getNama());
        Font roboto = new Font("Roboto", Font.PLAIN, 18);
        
        JLabel identity = new JLabel("Welcome,");
        identity.setBounds(155,72,130,32);
        identity.setFont(roboto);
        frame.add(identity);
        
        if(UserManager.getInstance().getUser() instanceof Guru){
            JButton create = new JButton("Add");
            create.setBounds(358, 157, 36, 36);
            frame.add(create);
            create.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    new createNew(kls);
                    frame.setVisible(false);
                }
            });
        }
        
        int i = 0;
        for (Posting post : kls.getArrPost()){
            if(post != null){
                JLabel labelDeskripsi = new JLabel();
                if(post instanceof Tugas){
                    Tugas tgs = (Tugas) post;
                    JButton newButton = new JButton(post.getJudul());
                    newButton.setBounds(148, 265+(100*i), 108, 20);
                    frame.add(newButton);
                    newButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e){
                            new ViewTugas(tgs);
                            frame.setVisible(false);
                        }
                    });
                    MuridController mc = new MuridController();
                    if(UserManager.getInstance().getUser() instanceof Guru){
                        labelDeskripsi.setText(post.getDeskripsi() + " by : " + mc.getUserById(tgs.getIdMurid()).getNama());
                    } else {
                        labelDeskripsi.setText(post.getDeskripsi());
                    }
                } else {
                    JLabel labelJudul = new JLabel(post.getJudul());
                    labelJudul.setBounds(148, 265+(100*i), 108, 20);
                    frame.add(labelJudul);
                    labelDeskripsi.setText(post.getDeskripsi());
                }
                labelDeskripsi.setBounds(148, 290+(119*i), 235, 20);
                frame.add(labelDeskripsi);
            }
            i++;
        }
        
        frame.setSize(432, 768);
        frame.setLayout(null);
        frame.setVisible(true);
        
    }
    
}
