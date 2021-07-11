/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author BRCS
 */
public class Tugas extends Posting {
    
    private double nilai;
    private Date tanggalPengumpulan;
    private Date tanggalDikumpulkan;
    private boolean terkumpulkan;

    public double getNilai() {
        return nilai;
    }

    public void setNilai(double nilai) {
        this.nilai = nilai;
    }

    public Date getTanggalPengumpulan() {
        return tanggalPengumpulan;
    }

    public void setTanggalPengumpulan(Date tanggalPengumpulan) {
        this.tanggalPengumpulan = tanggalPengumpulan;
    }

    public Tugas(double nilai, Date tanggalPengumpulan) {
        this.nilai = nilai;
        this.tanggalPengumpulan = tanggalPengumpulan;
    }
    
    public Tugas(){}

    public Date getTanggalDikumpulkan() {
        return tanggalDikumpulkan;
    }

    public void setTanggalDikumpulkan(Date tanggalDikumpulkan) {
        this.tanggalDikumpulkan = tanggalDikumpulkan;
    }

    public boolean isTerkumpulkan() {
        return terkumpulkan;
    }

    public void setTerkumpulkan(boolean terkumpulkan) {
        this.terkumpulkan = terkumpulkan;
    }
    
}
