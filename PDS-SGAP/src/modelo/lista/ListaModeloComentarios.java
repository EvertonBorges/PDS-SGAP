package modelo.lista;

import modelo.textarea.TextAreaModeloComentarios;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.AbstractListModel;
import modelo.Comentario;

public class ListaModeloComentarios extends AbstractListModel{

    private final List<Comentario> comentarios;

    public ListaModeloComentarios (List<Comentario> comentarios){
        this.comentarios= comentarios;
    }
    
    @Override
    public int getSize() {
        return this.comentarios.size();
    }

    @Override
    public Object getElementAt(int index) {
        String espaco=new String();
        TextAreaModeloComentarios textArea = new TextAreaModeloComentarios();
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