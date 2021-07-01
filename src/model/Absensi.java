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
public class Absensi {
    
    private LocalDate date;
    private StatusAbsensi hadir;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public StatusAbsensi getHadir() {
        return hadir;
    }

    public void setHadir(StatusAbsensi hadir) {
        this.hadir = hadir;
    }

    public Absensi(LocalDate date, StatusAbsensi hadir) {
        this.date = date;
        this.hadir = hadir;
    }
    
    public Absensi(){}
    
}
