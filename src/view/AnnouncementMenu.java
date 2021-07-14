/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MainController;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.Pengumuman;
import model.TipeUser;
import model.UserManager;

/**
 *
 * @author jonat
 */
public class AnnouncementMenu {

    public AnnouncementMenu() {
	MainController c = new MainController();
	JFrame f = new JFrame("Announcement");
	ArrayList<Pengumuman> announcement = c.getAllAnnouncement();
	TipeUser tipe = UserManager.getInstance().getUser().getTipe();
	if (tipe == TipeUser.ADMIN || tipe == TipeUser.TEACHER) {
	    Button add = new Button("+");
	    add.setBounds(367, 185, 16, 16);
	    f.add(add);
	    add.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		    new AddAnnouncement();
		}
	    });
	}
	for (int i = 0; i < announcement.size(); i++) {
	    JLabel title = new JLabel(announcement.get(i).getJudul());
	    JLabel desc = new JLabel(announcement.get(i).getDeskripsi());
	    title.setBounds(61, 250, 230, 16);
	    desc.setBounds(297, 250, 65, 16);
	    f.add(title);
	    f.add(desc);
	}

	Buttons button = new Buttons();
	button.back.setLocation(295, 660);
	f.add(button.back);
	button.back.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		f.setVisible(false);
		if (tipe == TipeUser.STUDENT) {
		    new StudentDashboard();
		} else if (tipe == TipeUser.PARENT) {
		    new ParentDashboard();
		} else if (tipe == TipeUser.TEACHER) {
		    new TeacherDashboard();
		} else if (tipe == TipeUser.ADMIN) {
		    new AdminDashboard();
		}
	    }
	});

	f.setSize(437, 768);
	f.setLayout(null);
	f.setVisible(true);
    }
}
