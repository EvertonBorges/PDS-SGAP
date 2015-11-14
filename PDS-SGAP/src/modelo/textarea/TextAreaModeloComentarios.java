package modelo.textarea;

import javax.swing.JTextArea;

public class TextAreaModeloComentarios  extends JTextArea {
    
    public TextAreaModeloComentarios() {
        
    }
    
    public TextAreaModeloComentarios(String text){
        super(text);
    }
    
    @Override
    public String toString() {
        return getText();
    }
}