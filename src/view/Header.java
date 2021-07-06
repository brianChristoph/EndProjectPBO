/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import model.User;
import javax.swing.*;
/**
 *
 * @author Jow
 */
public class Header {

    public Header(User user, String sectionTitle) {
        String name = user.getNama();
        
        JLabel welcome = new JLabel("Welcom, ");
        JLabel userName = new JLabel (name);
        JLabel section = new JLabel (sectionTitle);
        
        
    }
    
}
