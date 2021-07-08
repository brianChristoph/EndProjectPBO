/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author BRCS
 */
public class Tugas extends Posting {
    
    private double nilai;
    private LocalDate tanggalPengumpulan;
    private LocalDate tanggalDikumpulkan;
    private boolean terkumpulkan;
    

    public double getNilai() {
        return nilai;
    }

    public void setNilai(double nilai) {
        this.nilai = nilai;
    }

    public LocalDate getTanggalPengumpulan() {
        return tanggalPengumpulan;
    }

    public void setTanggalPengumpulan(LocalDate tanggalPengumpulan) {
        this.tanggalPengumpulan = tanggalPengumpulan;
    }

    public Tugas(double nilai, LocalDate tanggalPengumpulan) {
        this.nilai = nilai;
        this.tanggalPengumpulan = tanggalPengumpulan;
    }
    
    public Tugas(){}

    public LocalDate getTanggalDikumpulkan() {
        return tanggalDikumpulkan;
    }

    public void setTanggalDikumpulkan(LocalDate tanggalDikumpulkan) {
        this.tanggalDikumpulkan = tanggalDikumpulkan;
    }

    public boolean isTerkumpulkan() {
        return terkumpulkan;
    }

    public void setTerkumpulkan(boolean terkumpulkan) {
        this.terkumpulkan = terkumpulkan;
    }
    
}
