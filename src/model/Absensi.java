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
public class Absensi {
    
    private Date date;
    private StatusAbsensi hadir;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public StatusAbsensi getHadir() {
        return hadir;
    }

    public void setHadir(StatusAbsensi hadir) {
        this.hadir = hadir;
    }

    public Absensi(Date date, StatusAbsensi hadir) {
        this.date = date;
        this.hadir = hadir;
    }
    
    public Absensi(){}
    
}
