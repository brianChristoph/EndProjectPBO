/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author BRCS
 */
public class ClassMenu {
    
    public ClassMenu(){
        
        JFrame f = new JFrame("Class Menu");
        Font roboto = new Font("Roboto", Font.PLAIN, 18);

        JLabel identity = new JLabel("Welcome,");
        identity.setBounds(155, 72, 157, 665);
        identity.setFont(roboto);

//        ArrayList<Kelas>
        
        for (int i = 0; i < 10; i++) {
            JRadioButton newButton = new JRadioButton("");
        }

        ButtonGroup bg = new ButtonGroup();

        JLabel id = new JLabel("ID");
        id.setBounds(63, 370, 20, 16);
        id.setFont(roboto);

        JTextField inputID = new JTextField();
        inputID.setBounds(63, 386, 306, 33);

        JLabel password = new JLabel("Password");
        password.setBounds(63, 439, 100, 16);
        password.setFont(roboto);

        JPasswordField inputPassword = new JPasswordField();
        inputPassword.setBounds(63, 455, 306, 33);

        Button login = new Button("Login");
        login.setBounds(121, 524, 189, 36);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Login Controller
            }
        });

        f.add(identity);
        f.add(id);
        f.add(inputID);
        f.add(password);
        f.add(inputPassword);
        f.add(login);

        f.setSize(432, 768);
        f.setLayout(null);
        f.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new ClassMenu();
    }
    
}
