/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jonat
 */
public class Pengumuman {
    private String judul;
    private String deskripsi;

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Pengumuman(String judul, String deskripsi) {
        this.judul = judul;
        this.deskripsi = deskripsi;
    }
    
}
