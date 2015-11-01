/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.Aluguel;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modelo.Comentario;
import modelo.Produto;

/**
 *
 * @author Ada
 */
public class ListaComentarios extends AbstractListModel{

    private final List<Comentario> comentarios;

    public ListaComentarios (List<Comentario> comentarios){
        this.comentarios= comentarios;
    }
    
    @Override
    public int getSize() {
        return this.comentarios.size();
    }

    @Override
    public Object getElementAt(int index) {
        String espaco=new String();
        ATextArea textArea = new ATextArea();
        Comentario comentario= comentarios.get(index);
        
        SimpleDateFormat formatador= new SimpleDateFormat("dd/MM/yyyy");
   
        for (int i = 0; i<60; i++){
            espaco=espaco+"&nbsp";
        }
        
        textArea.setText("<html>Data: "+ formatador.format(comentario.getData().getTime())+espaco+" "+
                "Avaliação: "+ comentario.getAvaliacao()+
                "<br>Autor: "+ comentario.getComentarista() +
                "<br>"+ comentario.getComentario() +
                "<br>" );
        
        textArea.setEditable(false);  
        textArea.setLineWrap(true);
       
        return textArea;
    }
   
}
