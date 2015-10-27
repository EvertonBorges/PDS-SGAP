/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.meusProdutos;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Produto;

/**
 *
 * @author Everton Soares
 */
public class TabelaProduto extends AbstractTableModel{
    private final List<Produto> produtos;
    private String[] campos = {"Produto", "Quantidade"}; 

    public TabelaProduto(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    @Override
    public int getRowCount() {
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
        return campos.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto produto = produtos.get(rowIndex);
        switch(columnIndex){
            case 0: return produto.getNome();
            case 1: return produto.getQuantidade();
            default: return "";
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return campos[0];
            case 1: return campos[1];
            default: return super.getColumnName(column);
        }
    }
}
