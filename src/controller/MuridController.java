/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Kelas;
import model.Murid;
import model.User;

/**
 *
 * @author BRCS
 */
public class MuridController {
    
    ArrayList<Kelas> arrKelas = new ArrayList();
    
    private boolean isMurid(User pengguna){
        if(pengguna instanceof Murid){
            return true;
        }
        return false;
    }
    private int indexKelas(int idKelas){
        for (int i = 0; i < arrKelas.size(); i++) {
            if(arrKelas.get(i) != null){
                // if id arrKelas dri database == idKelas
                // return i
            }
        }
        return -1;
    }
    private void printError(){
        // show Error Message
    }
    
    public void gabungKelas(User pengguna, int idKelas){
        if(isMurid(pengguna) == true){
            int idxKelas = indexKelas(idKelas);
            if(idxKelas != -1){
                // add pengguna ke arrayList student yang ada di model Kelas
            } else {
                printError();
            }
        }
    }
    
    public void keluarKelas(User pengguna, int idKelas){
        if(isMurid(pengguna) == true){
            int idxKelas = indexKelas(idKelas);
            if(idxKelas != -1){
                // remove pengguna dari arrayList student yang ada di model kelas
            } else {
                printError();
            }
        }
    }
    
    public void kumpulkanTugas(User pengguna){
        if(isMurid(pengguna) == true){
            // mengganti status tugas menjadi submited
        }
    }
    
}
