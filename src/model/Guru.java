/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author BRCS
 */
public class Guru extends User {
    
    private ArrayList<Kelas> ajarKelas = new ArrayList();

    public ArrayList<Kelas> getAjarKelas() {
        return ajarKelas;
    }

    public void setAjarKelas(ArrayList<Kelas> ajarKelas) {
        this.ajarKelas = ajarKelas;
    }
    
}
