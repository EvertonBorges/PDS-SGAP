/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.lista;

import java.util.List;
import javax.swing.AbstractListModel;
import modelo.Categoria;

/**
 *
 * @author Everton Soares
 */
public class ListaModeloCategorias extends AbstractListModel{
    private final List<Categoria> categorias;
    private boolean todos = false;
    
    public ListaModeloCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
    
    public ListaModeloCategorias(List<Categoria> categorias, boolean  todos) {
        this.categorias = categorias;
        this.todos=todos;
    }
    @Override
    public int getSize() {
        if (todos)
            return categorias.size()+1;
        else{
            return categorias.size();
        }
    }

    @Override
    public Object getElementAt(int index) {
        if (todos) {
            if (index<categorias.size()){
                return categorias.get(index);
            }
            else{
                return "TODOS";
            }
        } else
            return categorias.get(index);
    }
}