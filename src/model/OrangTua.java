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
public class OrangTua extends User implements StudentInformation {
    
    private ArrayList<Murid> anak = new ArrayList<Murid>();

    public ArrayList<Murid> getAnak() {
        return anak;
    }

    public void setAnak(ArrayList<Murid> anak) {
        this.anak = anak;
    }
    
    public void bayarSPP(){
        
    }

    @Override
    public void cekJadwal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cekAbsensi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void lihatRapor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void lihatGuruPengajar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
