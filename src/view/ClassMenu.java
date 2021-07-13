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
import model.VisitedClass;

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
        
        // HardCode Cuz Dbase is not functioning
//        ArrayList<Kelas> arrKelas = new ArrayList();
//        Kelas k1 = new Kelas();
//        k1.setNama("mat");
//        k1.setJadwal("Senin, 1-2");
//        Kelas k2 = new Kelas();
//        k2.setNama("fis");
//        k2.setJadwal("Selasa, 1-2");
//        arrKelas.add(k1);
//        arrKelas.add(k2);
        
        User user = UserManager.getInstance().getUser();
        if(user instanceof Murid){
            Murid murid = (Murid) user;
//            murid.setListKelas(arrKelas);
            f = showListKelas(murid.getListKelas(), f);
        } else if (user instanceof Guru){
            System.out.println("hello");
            Guru guru = (Guru) user;
//            guru.setAjarKelas(arrKelas);
            f = showListKelas(guru.getAjarKelas(), f);
        }

        f.setSize(432, 768);
        f.setLayout(null);
        f.setVisible(true);
    }
    
    private JFrame showListKelas(ArrayList<Kelas> arrKelas, JFrame frame){
        for (int i = 0; i < arrKelas.size(); i++) {
            if(arrKelas.get(i) != null){
                JButton newButton = new JButton(arrKelas.get(i).getNama());
                newButton.setBounds(148, 265+(100*i), 108, 20);
                
                JLabel newLabel = new JLabel();
                newLabel.setText(arrKelas.get(i).getJadwal());
                newLabel.setBounds(148, 290+(119*i), 235, 20);
                
                frame.add(newButton);
                frame.add(newLabel);
                
                newButton.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       new ViewClass();
//                       new ViewClass(arrKelas.get(i));
                       frame.setVisible(false);
                   }
                });
            }
        }
        return frame;
    }
    
}
