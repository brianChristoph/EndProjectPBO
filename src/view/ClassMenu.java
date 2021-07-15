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
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import model.Guru;
import model.Kelas;
import model.Murid;
import model.TipeUser;
import model.User;
import model.UserManager;

/**
 *
 * @author BRCS
 */
public class ClassMenu {

    public ClassMenu() {

	JFrame frame = new JFrame("Class Menu");
	Font roboto = new Font("Roboto", Font.PLAIN, 18);

	JLabel identity = new JLabel("Welcome,");
	identity.setBounds(155, 72, 130, 32);
	identity.setFont(roboto);
	frame.add(identity);

	if (UserManager.getInstance().getUser() instanceof Guru) {

	    JButton addKelas = new JButton("+");
	    addKelas.setBounds(358, 157, 36, 36);
	    frame.add(addKelas);

	    addKelas.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		    frame.setVisible(false);
		    new CreateNewClass();
		}
	    });

	}

	ArrayList<Kelas> arrKelas = new ArrayList();
	User user = UserManager.getInstance().getUser();
	if (user instanceof Murid) {
	    Murid murid = (Murid) user;
	    arrKelas = murid.getListKelas();
	} else if (user instanceof Guru) {
	    Guru guru = (Guru) user;
	    arrKelas = guru.getAjarKelas();
	}

	JButton[] newButton = new JButton[arrKelas.size()];
	for (int i = 0; i < arrKelas.size(); i++) {
	    Kelas tempClass = arrKelas.get(i);
	    if (arrKelas.get(i) != null) {
		newButton[i] = new JButton(arrKelas.get(i).getNama());
		newButton[i].setBounds(148, 265 + (100 * i), 108, 20);

		JLabel newLabel = new JLabel();
		newLabel.setText(arrKelas.get(i).getJadwal());
		newLabel.setBounds(148, 290 + (119 * i), 235, 20);

		frame.add(newButton[i]);
		frame.add(newLabel);

		newButton[i].addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			createViewClass(tempClass);
		    }
		});
	    }
	}

	Buttons button = new Buttons();
	button.back.setLocation(295, 660);
	frame.add(button.back);
	button.back.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		frame.setVisible(false);
		TipeUser tipe = UserManager.getInstance().getUser().getTipe();
		if (tipe == TipeUser.STUDENT) {
		    new StudentDashboard();
		} else if (tipe == TipeUser.TEACHER) {
		    new TeacherDashboard();
		}
	    }
	});

	frame.setSize(432, 768);
	frame.setLayout(null);
	frame.setVisible(true);

    }

    private void createViewClass(Kelas kelas) {
	new ViewClass(kelas);
    }

}
