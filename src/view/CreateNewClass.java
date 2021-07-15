/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.TeacherController;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Guru;
import model.UserManager;

/**
 *
 * @author BRCS
 */
public class CreateNewClass {
    
    public CreateNewClass(){
        JFrame frame = new JFrame("Create Class");
        Font roboto = new Font("Roboto", Font.PLAIN, 18);
        
        JLabel identity = new JLabel("Welcome,");
        identity.setBounds(155,72,130,32);
        identity.setFont(roboto);
        frame.add(identity);
        
        JLabel judul = new JLabel("Nama : ");
        JLabel kode = new JLabel("Kode : ");
        JLabel jadwal = new JLabel("Jadwal : ");
        
        judul.setBounds(61, 250, 50, 20);
        kode.setBounds(61, 280, 50, 20);
        jadwal.setBounds(61, 310, 50, 20);
        
        JTextField namaKelas = new JTextField();
        JTextField kodeKelas = new JTextField();
        JTextField jadwalKelas = new JTextField();
        
        namaKelas.setBounds(110, 250, 150, 20);
        kodeKelas.setBounds(110, 280, 150, 20);
        jadwalKelas.setBounds(110, 310, 150, 20);
        
        frame.add(judul);
        frame.add(kode);
        frame.add(jadwal);
        frame.add(namaKelas);
        frame.add(kodeKelas);
        frame.add(jadwalKelas);
        
        JButton create = new JButton("Create");
        create.setBounds(115, 450, 190, 36);
        frame.add(create);
        create.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                TeacherController tc = new TeacherController();
                tc.createNewKelas((Guru)UserManager.getInstance().getUser(), namaKelas.getText(), kodeKelas.getText(), jadwalKelas.getText());
                frame.setVisible(false);
                new ClassMenu();
            }
        });
        
        Buttons button = new Buttons();
        button.back.setLocation(265, 660);
	frame.add(button.back);
        button.back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new ClassMenu();
            }
        });
        
        frame.setSize(432, 768);
        frame.setLayout(null);
        frame.setVisible(true);
        
    }
    
}
