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
    
    private String id;
    private String nama;
    private String password;
    private String noTlp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public User(String id, String nama, String password, String noTlp) {
        this.id = id;
        this.nama = nama;
        this.password = password;
        this.noTlp = noTlp;
    }
    
    public User(){}
    
}
