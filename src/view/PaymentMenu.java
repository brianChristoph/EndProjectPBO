/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ParentController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.Murid;
import java.util.Date;
import javax.swing.JPanel;
import model.UserManager;

/**
 *
 * @author jonat
 */
public class PaymentMenu {

    public PaymentMenu() {
        JFrame f = new JFrame("Payment Menu");
        ParentController c = new ParentController();
         Header header = new Header("Student Dashboard");
        JPanel head = header.getHeader();
        f.add(head);
        Murid murid = c.getAnak(UserManager.getInstance().getUser().getId());
        double spp = murid.getSPP();
        Date date = new Date();
        JLabel title = new JLabel("Tanggal" + date.getMonth());
        title.setBounds(72,253,108,20);
        JLabel detail = new JLabel("Total Tagihan : " + spp);
        detail.setBounds(72,277,235,20);
        
        Buttons button = new Buttons();
        
        f.add(title);
        f.add(detail);
        
        button.back.setLocation(204,312);

        f.add(button.back);
        button.back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new ParentDashboard();
            }
        });
        
        
        f.setSize(432,768);
        f.setLayout(null);
        f.setVisible(true);

        f.setSize(432, 768);
        f.setLayout(null);
        f.setVisible(true);
    }
}
