package modelo.textarea;

import javax.swing.JTextArea;

public class ATextArea  extends JTextArea {
    
    public ATextArea() {
        
    }
    
    public ATextArea(String text){
        super(text);
    }
    
    @Override
    public String toString() {
        return getText();
    }
}