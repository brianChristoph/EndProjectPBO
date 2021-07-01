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
public class Guru extends User implements ClassAdministrator {
    
    private ArrayList<Kelas> ajarKelas = new ArrayList();

    public ArrayList<Kelas> getAjarKelas() {
        return ajarKelas;
    }

    public void setAjarKelas(ArrayList<Kelas> ajarKelas) {
        this.ajarKelas = ajarKelas;
    }
    
    public void menambahPosting(){
        
    }
    public void menghapusPosting(){
        
    }
    public void mengeluarkanMurid(){
        
    }
    public void mengabsenMurid(){
        
    }
    public void memasukkanNilai(){
        
    }

    @Override
    public void createKelas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteKelas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void postPengumuman() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mengubahJadwalKelas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
