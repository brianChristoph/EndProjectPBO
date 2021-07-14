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
    
    private String className;
    private Date date;
    private StatusAbsensi hadir;
    private double presensi;

    public double getPresensi() {
        return presensi;
    }

    public void setPresensi(double presensi) {
        this.presensi = presensi;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    
    

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
