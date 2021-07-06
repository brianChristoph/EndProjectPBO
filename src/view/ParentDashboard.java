/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JFrame;

/**
 *
 * @author BRCS
 */
public class ParentDashboard {

    public ParentDashboard() {
        JFrame f = new JFrame("Parent Dashboard");
        Buttons button = new Buttons();
        f.add(button.classes);
        f.add(button.calendar);
        f.add(button.teachers);
        f.add(button.report);
        f.add(button.attandance);
        f.add(button.announcement);
    }

}
