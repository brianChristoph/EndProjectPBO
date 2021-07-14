/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MainController;
import java.util.ArrayList;
import javax.swing.JFrame;
import model.Kelas;

/**
 *
 * @author jonat
 */
public class ManageClasses {

    public ManageClasses() {
        MainController c = new MainController();
        JFrame f = new JFrame("List Kelas");
        ArrayList <Kelas> kelas = c.getAllKelas();
        for (int i = 0; i < kelas.size(); i++) {
        }
    }
    
    
}
