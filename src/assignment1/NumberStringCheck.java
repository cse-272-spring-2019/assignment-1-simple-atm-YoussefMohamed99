/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

/**
 *
 * @author YOUSSEF
 */
public class NumberStringCheck {
    
    public boolean validate(String str){
        
        return str.matches("[0-9.]+");
    }
    
}
