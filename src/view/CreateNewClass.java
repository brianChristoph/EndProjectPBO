/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author BRCS
 */
public class CreateNewClass {
    
    public CreateNewClass(){
        JFrame f = new JFrame("Create Class");
        Font roboto = new Font("Roboto", Font.PLAIN, 18);
        
        JLabel identity = new JLabel("Welcome,");
        identity.setBounds(155,72,130,32);
        identity.setFont(roboto);
        f.add(identity);
        
        JTextField namaKelas = new JTextField();
//        namaKelas.setBounds();

        // createKode random/input
        
        
        
    }
    
}
