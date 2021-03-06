/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author BRCS
 */
public abstract class User {

    private int id;
    private String nama;
    private String password;
    private String noTlp;
    private TipeUser tipe;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNoTlp() {
        return noTlp;
    }

    public void setNoTlp(String noTlp) {
        this.noTlp = noTlp;
    }
    
    public TipeUser getTipe() {
        return tipe;
    }

    public void setTipe(TipeUser tipe) {
        this.tipe = tipe;
    }

    public User(int id, String nama, String password, String noTlp) {
        this.id = id;
        this.nama = nama;
        this.password = password;
        this.noTlp = noTlp;
    }

    public User(int id, String nama, String password, String noTlp, TipeUser tipe) {
        this.id = id;
        this.nama = nama;
        this.password = password;
        this.noTlp = noTlp;
        this.tipe = tipe;
    }

    public User() {
    }


}
