package modelo.textarea;

import javax.swing.JTextArea;

public class TextAreaModelo  extends JTextArea {
    
    public TextAreaModelo() {
        
    }
    
    public TextAreaModelo(String text){
        super(text);
    }
    
    @Override
    public String toString() {
        return getText();
    }
}