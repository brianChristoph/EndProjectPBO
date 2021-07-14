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

/**
 *
 * @author BRCS
 */
public class createNew {
    
    public createNew(Kelas kls){
        JFrame frame = new JFrame();
        Font roboto = new Font("Roboto", Font.PLAIN, 18);
        
        JLabel identity = new JLabel("Welcome,");
        identity.setBounds(155,72,130,32);
        identity.setFont(roboto);
        frame.add(identity);
        
        JButton createTugas = new JButton();
        createTugas.setBounds(75, 235, 260, 120);
        frame.add(createTugas);
        createTugas.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new newTugas(kls);
                frame.setVisible(false);
            }
        });
        
        JButton createPost = new JButton();
        createPost.setBounds(75, 362, 260, 120);
        frame.add(createPost);
        createPost.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new newPost(kls);
                frame.setVisible(false);
            }
        });
        
        frame.setSize(432, 768);
        frame.setLayout(null);
        frame.setVisible(true);
        
    }
    
}
