/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.Aluguel;

import javax.swing.JTextArea;

/**
 *
 * @author Ada
 */
public class ATextArea  extends JTextArea {
    
    public ATextArea(String text){
        super(text);
    }

    public ATextArea() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   

    @Override
    public String toString() {
        return getText();
    }
    
    //public 
    
    
    
}