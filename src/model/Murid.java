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
public class Murid extends User implements StudentInformation {
    private String NIP;
    private ArrayList<Kelas> listKelas = new ArrayList();
    private double SPP;

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public ArrayList<Kelas> getListKelas() {
        return listKelas;
    }

    public void setListKelas(ArrayList<Kelas> listKelas) {
        this.listKelas = listKelas;
    }

    public double getSPP() {
        return SPP;
    }

    public void setSPP(double SPP) {
        this.SPP = SPP;
    }

    

    public Murid(double SPP, int angkatan, ArrayList<Kelas> listKelas) {
        this.SPP = SPP;
        this.listKelas = listKelas;
        super.setTipe(TipeUser.STUDENT);
    }
    
    public Murid(){}

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
