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
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jonat
 */
public class InsertGuru {

    public InsertGuru() {
        JFrame frame = new JFrame();
        Font roboto = new Font("Roboto", Font.PLAIN, 18);
        
        JLabel nama = new JLabel ("Nama");
        nama.setBounds(60, 72, 130, 32);
        nama.setFont(roboto);
        frame.add(nama);
        
        JLabel nik = new JLabel ("Nik");
        nik.setBounds(60, 120, 130, 32);
        nik.setFont(roboto);
        frame.add(nik);
        
        JLabel password = new JLabel ("Password");
        password.setBounds(60, 155, 130, 32);
        password.setFont(roboto);
        frame.add(password);
        
        JLabel noTlp = new JLabel ("No Tlp");
        noTlp.setBounds(60, 190, 130, 32);
        noTlp.setFont(roboto);
        frame.add(noTlp);

        JTextField inputNama = new JTextField();
        inputNama.setBounds(190, 72, 200, 33);
        frame.add(inputNama);
        
        JTextField inputNik = new JTextField();
        inputNik.setBounds(190, 120, 200, 33);
        frame.add(inputNik);

        JTextField inputPassword = new JTextField();
        inputPassword.setBounds(190, 155, 200, 33);
        frame.add(inputPassword);
        
        JTextField inputTlp = new JTextField();
        inputTlp.setBounds(190, 190, 200, 33);
        frame.add(inputTlp);

        JButton create = new JButton("Add");
        create.setBounds(235, 350, 80, 36); 
        frame.add(create);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TeacherController tc = new TeacherController();
                tc.addGuru(inputNama.getText(), inputNik.getText(), inputPassword.getText(), inputTlp.getText());
                frame.setVisible(false);
                new ManageUsers();
            }
        });

        Buttons button = new Buttons();
        button.back.setLocation(130, 350);
        frame.add(button.back);
        button.back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                
            }
        });

        frame.setSize(432, 768);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}
