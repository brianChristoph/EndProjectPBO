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
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Kelas;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author BRCS
 */
public class newTugas {
    
    public newTugas(Kelas kls){
        JFrame frame = new JFrame();
        Font roboto = new Font("Roboto", Font.PLAIN, 18);
        
        JLabel identity = new JLabel("Welcome,");
        identity.setBounds(155,72,130,32);
        identity.setFont(roboto);
        frame.add(identity);
        
        JTextField judul = new JTextField("Judul");
        judul.setBounds(63, 265, 306, 33);
        frame.add(judul);
        JTextField deskripsi = new JTextField("Desc");
        deskripsi.setBounds(63, 310, 306, 33);
        frame.add(deskripsi);
        
        UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        JDatePickerImpl deadline = new JDatePickerImpl(datePanel);
        deadline.setBounds(63, 350, 306, 33);
        frame.add(deadline);
        
        Date selectedDate = (Date) deadline.getModel().getValue();
        
        JButton create = new JButton("Post");
        create.setBounds(235, 400, 80, 36);
        frame.add(create);
        create.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                TeacherController tc = new TeacherController();
                tc.createNewTugas(kls.getId(), judul.getText(), deskripsi.getText(), selectedDate);
                frame.setVisible(false);
            }
        });
        
        Buttons button = new Buttons();
        button.back.setLocation(130, 400);
        frame.add(button.back);
        button.back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new createNew(kls);
            }
        });
        
        frame.setSize(432, 768);
        frame.setLayout(null);
        frame.setVisible(true);
        
    }
    
}
