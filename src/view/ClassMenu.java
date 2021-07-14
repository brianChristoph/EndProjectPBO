/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import model.Guru;
import model.Kelas;
import model.Murid;
import model.User;
import model.UserManager;

/**
 *
 * @author BRCS
 */
public class ClassMenu {
    
    public ClassMenu(){
        
        JFrame f = new JFrame("Class Menu");
        Font roboto = new Font("Roboto", Font.PLAIN, 18);

        JLabel identity = new JLabel("Welcome,");
        identity.setBounds(155, 72, 130, 32);
        identity.setFont(roboto);
        f.add(identity);
        
        JButton addKelas = new JButton("Create");
        addKelas.setBounds(0,0,0,0);
        f.add(addKelas);
        
        addKelas.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
//                new createNewClass();
//                f.setVisible(false);
            }
        });
        
//        f.getContentPane().setLayout(new FlowLayout());
//        JScrollPane scrollableTextArea = new JScrollPane(f); 
//        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        f.getContentPane().add(scrollableTextArea);
        
        User user = UserManager.getInstance().getUser();
        if(user instanceof Murid){
            Murid murid = (Murid) user;
            f = showListKelas(murid.getListKelas(), f);
        } else if (user instanceof Guru){
            Guru guru = (Guru) user;
            f = showListKelas(guru.getAjarKelas(), f);
        }

        f.setSize(432, 768);
        f.setLayout(null);
        f.setVisible(true);
    }
    
    private JFrame showListKelas(ArrayList<Kelas> arrKelas, JFrame frame){
        JButton[] newButton = new JButton[arrKelas.size()];
        for (int i = 0; i < arrKelas.size(); i++) {
            Kelas tempClass = arrKelas.get(i);
            if(arrKelas.get(i) != null){
                newButton[i] = new JButton(arrKelas.get(i).getNama());
                newButton[i].setBounds(148, 265+(100*i), 108, 20);
                
                JLabel newLabel = new JLabel();
                newLabel.setText(arrKelas.get(i).getJadwal());
                newLabel.setBounds(148, 290+(119*i), 235, 20);
                
                frame.add(newButton[i]);
                frame.add(newLabel);
                
                newButton[i].addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       createViewClass(tempClass);
                       frame.setVisible(false);
                   }
                });
            }
        }
        return frame;
    }
    
    private void createViewClass(Kelas kelas){
        new ViewClass(kelas);
    }
    
}
