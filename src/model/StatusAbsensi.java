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
public enum StatusAbsensi {
    
    HADIR(1), ALPHA(0);
    private final int value;
    
    public int getValue(){
        return this.value;
    }
    
    private StatusAbsensi(int value){
        this.value = value;
    }
    
}
