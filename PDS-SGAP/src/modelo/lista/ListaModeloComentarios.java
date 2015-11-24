package modelo.lista;

import modelo.textarea.TextAreaModelo;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.AbstractListModel;
import modelo.Aluguel;
import modelo.Comentario;

public class ListaModeloComentarios extends AbstractListModel{
    private final List<Comentario> comentarios;

    public ListaModeloComentarios (List<Comentario> comentarios){
        this.comentarios = comentarios;
    }
    
    @Override
    public int getSize() {
        return this.comentarios.size();
    }

    @Override
    public Object getElementAt(int index) {
        String espaco = new String();
        TextAreaModelo textArea = new TextAreaModelo();
        Comentario comentario = comentarios.get(index);
        
        SimpleDateFormat formatador= new SimpleDateFormat("dd/MM/yyyy");
        
        for (int i = 0; i<45; i++){
            espaco = espaco + "&nbsp";
        }
        
        textArea.setText("<html>Data: "+ formatador.format(comentario.getDataComentario().getTime()) + espaco + " "+
                         "Avaliação: "+ comentario.getAvaliacao()+
                         "<br>Autor: "+ comentario.getAluguel().getSolicitacaoAluguel().getLocatario() +
                         "<br>"+ comentario.getComentario() +
                         "<br>" );
        
        textArea.setEditable(false);  
        textArea.setLineWrap(true);
       
        return textArea;
    }   
}