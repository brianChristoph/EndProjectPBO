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
public class OrangTua extends User{
    
    private ArrayList<Murid> anak = new ArrayList<Murid>();

    public ArrayList<Murid> getAnak() {
        return anak;
    }

    public void setAnak(ArrayList<Murid> anak) {
        this.anak = anak;
    }
    
    public void bayarSPP(){
        
    }
    
}
