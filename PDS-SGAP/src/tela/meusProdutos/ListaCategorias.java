/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.meusProdutos;

import java.util.List;
import javax.swing.AbstractListModel;
import modelo.Categoria;

/**
 *
 * @author Everton Soares
 */
public class ListaCategorias extends AbstractListModel{
    private final List<Categoria> categorias;

    public ListaCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
    
    @Override
    public int getSize() {
        return categorias.size();
    }

    @Override
    public Object getElementAt(int index) {
        return categorias.get(index).getDescricao();
    }
}
