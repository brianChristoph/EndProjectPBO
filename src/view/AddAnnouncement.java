/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
/**
 *
 * @author jonat
 */
public class AddAnnouncement {

    public AddAnnouncement() {
        JFrame f = new JFrame("Add Announcement");
        
        JLabel titleLabel = new JLabel("Title");
        titleLabel.setBounds(63,230,45,16);
        
        JTextField titleInput = new JTextField();
        titleInput.setBounds(63, 247, 306, 33);   
        
        JLabel descriptionLabel = new JLabel("Description");
        descriptionLabel.setBounds(63,290,90,16);
        
        TextArea descriptionInput = new TextArea();
        descriptionInput.setBounds(63, 306, 306, 123);   
        
        JButton add = new JButton("Add");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AnnouncementMenu();
                
                f.setVisible(false);
            }
        });
        
        add.setBounds(224,451,81,36);
        
        
        f.add(titleLabel);
        f.add(titleInput);
        f.add(descriptionLabel);
        f.add(descriptionInput);
        f.add(add);
        
        f.setSize(432,768);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new AddAnnouncement();
    }
    
}
