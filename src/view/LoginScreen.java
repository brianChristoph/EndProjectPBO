/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Jow
 */
public class LoginScreen {

    public LoginScreen() {
        JFrame f = new JFrame("Login Frame");
        Font roboto = new Font("Roboto", Font.PLAIN, 18);

        JLabel identity = new JLabel("Who are you ?");
        identity.setBounds(63, 303, 150, 16);
        identity.setFont(roboto);

        JRadioButton option1 = new JRadioButton("Student");
        JRadioButton option2 = new JRadioButton("Parent");
        JRadioButton option3 = new JRadioButton("Teacher");
        JRadioButton option4 = new JRadioButton("Admin");

        option1.setBounds(63, 330, 75, 16);
        option2.setBounds(147, 330, 75, 16);
        option3.setBounds(230, 330, 75, 16);
        option4.setBounds(313, 330, 75, 16);

        ButtonGroup bg = new ButtonGroup();

        bg.add(option1);
        bg.add(option2);
        bg.add(option3);
        bg.add(option4);

        f.add(option1);
        f.add(option2);
        f.add(option3);
        f.add(option4);

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

        login.addActionListener((ActionListener) this);

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

    public void actionPerformed(ActionEvent e) {
        System.out.println("test");
    }
}
