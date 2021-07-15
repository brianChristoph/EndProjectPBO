/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MainController;
import controller.ParentController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.Guru;
import model.TipeUser;
import model.UserManager;

/**
 *
 * @author BRCS
 */
public class TeachersMenu {

    public TeachersMenu() {
       JFrame f = new JFrame();
        MainController c = new MainController();
        ParentController pc = new ParentController();
        int id = 0;
        if (UserManager.getInstance().getUser().getTipe() == TipeUser.PARENT) {
            id = pc.getAnak(UserManager.getInstance().getUser().getId()).getId();
        } else if (UserManager.getInstance().getUser().getTipe() == TipeUser.STUDENT) {
            id = UserManager.getInstance().getUser().getId();
        }
        int tambah = 253;
        JLabel coloumGuru = new JLabel("Guru");
        JLabel coloumNoTlp = new JLabel("No Telepon");
        coloumGuru.setBounds(46,220,220,13);
        coloumNoTlp.setBounds(150,220,90,13);
        ArrayList<Guru> guru = c.getTeachersByMurid(id);
        for (int i = 0; i < guru.size(); i++) {
            JLabel namaGuru = new JLabel(guru.get(i).getNama() + ": ");
            JLabel noTlpGuru = new JLabel(guru.get(i).getNoTlp());
            namaGuru.setBounds(46, tambah, 108, 12);
            noTlpGuru.setBounds(150, tambah, 235, 12);
            tambah += 20;
            f.add(namaGuru);
            f.add(noTlpGuru);
        }

	Buttons button = new Buttons();
	button.back.setLocation(295, 660);
	f.add(button.back);
	button.back.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		TipeUser tipe = UserManager.getInstance().getUser().getTipe();
		f.setVisible(false);
		if (tipe == TipeUser.STUDENT) {
		    new StudentDashboard();
		} else if (tipe == TipeUser.PARENT) {
		    new ParentDashboard();
		}
	    }
	});

	f.add(coloumGuru);
	f.add(coloumNoTlp);
	f.setLayout(null);
	f.setSize(432, 768);
	f.setVisible(true);
    }

}
