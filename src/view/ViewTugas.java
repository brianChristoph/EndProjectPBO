/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MuridController;
import controller.TeacherController;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;
import model.Guru;
import model.Kelas;
import model.Murid;
import model.Posting;
import model.Tugas;
import model.UserManager;

/**
 *
 * @author BRCS
 */
public class ViewTugas {
    
    public ViewTugas(Kelas kls, Posting post){
        Tugas tugas = (Tugas) post;
        JFrame frame = new JFrame("Tugas");
        Font roboto = new Font("Roboto", Font.PLAIN, 18);

        JLabel identity = new JLabel("Welcome,");
        identity.setBounds(155, 72, 130, 32);
        identity.setFont(roboto);
        frame.add(identity);
        JLabel judulTugas = new JLabel(tugas.getJudul());
        judulTugas.setBounds(149, 265, 108, 12);
        frame.add(judulTugas);
        
        JButton back = new JButton("Back");
        
        if(UserManager.getInstance().getUser() instanceof Murid){
            if(tugas.isTerkumpulkan() == true){
                JLabel nilaiTugas = new JLabel();
                nilaiTugas.setText("Nilai : " + tugas.getNilai());
                nilaiTugas.setBounds(149, 290, 235, 13);
                frame.add(nilaiTugas);
            } else {
                JLabel deskTugas = new JLabel();
                deskTugas.setText(tugas.getDeskripsi());
                deskTugas.setBounds(149, 290, 235, 13);
                frame.add(deskTugas);

                JButton kumpulkan = new JButton("Submit");
                kumpulkan.setBounds(235,350,80,36);
                frame.add(kumpulkan);
                kumpulkan.addActionListener(new ActionListener(){
                   @Override
                   public void actionPerformed(ActionEvent e){
                       MuridController mc = new MuridController();
                       mc.submitTugas(UserManager.getInstance().getUser().getId(), tugas);
                       frame.setVisible(false);
                       new ViewClass(kls);
                   }
                });
            }
            back.setBounds(130, 350, 80, 36);
        } else {
            if(tugas.getNilai() == 0){
                JLabel deskTugas = new JLabel();
                deskTugas.setText(tugas.getDeskripsi());
                deskTugas.setBounds(149, 290, 235, 13);
                frame.add(deskTugas);
                
                JLabel mark = new JLabel();
                mark.setText("Mark : ");
                mark.setBounds(149, 312, 33, 16);
                frame.add(mark);
                
                NumberFormat format = NumberFormat.getInstance();
                NumberFormatter formatter = new NumberFormatter(format);
                formatter.setValueClass(Integer.class);
                formatter.setMinimum(0);
                formatter.setMaximum(Integer.MAX_VALUE);
                formatter.setAllowsInvalid(false);
                formatter.setCommitsOnValidEdit(true);
                
                JFormattedTextField nilai = new JFormattedTextField(formatter);
                nilai.setBounds(188, 315, 108, 20);
                frame.add(nilai);
                
                JLabel inputNilai = new JLabel();
                inputNilai.setText("INPUT NILAI");
                inputNilai.setBounds(307, 312, 77, 16);
                frame.add(inputNilai);
                
                JButton confirm = new JButton("Mark");
                confirm.setBounds(235, 400, 80, 36);
                frame.add(confirm);
                
                confirm.addActionListener(new ActionListener(){
                   @Override
                   public void actionPerformed(ActionEvent e){
                       TeacherController tc = new TeacherController();
                       tc.inputGrade(kls.getId(), tugas.getId(), tugas.getIdMurid(), (int) nilai.getValue());
                       frame.setVisible(false);
                   }
                });
                
                back.setBounds(130, 400, 80, 36);
            } else {
                JLabel nilaiTugas = new JLabel();
                nilaiTugas.setText("Nilai : " + tugas.getNilai());
                nilaiTugas.setBounds(149, 290, 235, 13);
                frame.add(nilaiTugas);
            }
        }
        
        frame.add(back);
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new ViewClass(kls);
            }
        });
        
        frame.setSize(432, 768);
        frame.setLayout(null);
        frame.setVisible(true);
        
    }
    
}
