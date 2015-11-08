/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.tabela;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;
import modelo.Produto;

/**
 *
* @author Ada
 */
public class TabelaProdutosDisponiveis  extends AbstractTableModel  {

    private final List<Produto> produtos;
    private final String[] campos = {"", "", "", ""}; 
    private byte[] byteImage = null; 
    private ImageIcon  imageIcon = new ImageIcon();  
    
    
    public TabelaProdutosDisponiveis(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    @Override
    public int getRowCount() {
        double d= (this.produtos.size()/campos.length)+1;
        return (int)Math.round(d);
    }
    @Override
    public int getColumnCount() {
    
         return campos.length;
    }
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        int indice =(rowIndex*(campos.length))+columnIndex;
        if(produtos.size()<4){
            indice=((rowIndex*(produtos.size()))+columnIndex);
        }
        Produto produto;
        if (indice <produtos.size()){
            produto = produtos.get(indice);
            return produto.getNome();
        }
        else
            return "";
          
    }
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return campos[0];
            case 1: return campos[1];
            case 2: return campos[2];
            case 3: return campos[3];
            default: return super.getColumnName(column);
        }
    }
    
   @Override  
    public Class<?> getColumnClass(int column) {  
        return JPanel.class;
    }
}
 