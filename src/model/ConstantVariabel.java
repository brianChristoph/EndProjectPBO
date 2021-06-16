/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;

/**
 *
 * @author BRCS
 */
public class ConstantVariabel {
    
//    final static int UANG_SEKOLAH = ;
    
    final static HashMap<String, String> CLASSES = new HashMap();
    
    static{
        CLASSES.put("mat", "Matematika");
        CLASSES.put("kim", "Kimia");
        CLASSES.put("bio", "Biologi");
        CLASSES.put("fis", "Fisika");
        CLASSES.put("eng", "English");
    }
    
    // Error Message
    final static String ERROR = "Error";
    
}
