/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.Aluguel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import modelo.Produto;

/**
 *
* @author Ada
 */
public class TabelaProdutosDisponiveisRenderer extends JLabel implements TableCellRenderer{

   private final List<Produto> produtos;   
   
   public TabelaProdutosDisponiveisRenderer(List<Produto> produtos) {
        
       this.produtos = produtos;
  	setOpaque(true);
  }
  
   @Override
  public Component getTableCellRendererComponent(JTable table, 
     Object value, boolean isSelected, boolean hasFocus, int row, 
     int column){
    
        ImageIcon img= new ImageIcon(produtos.get(row).getImagensProduto().get(0).getImagem());
     // certifique-se da existencia da imagem "icon.gif" antes de executar
    
     if(isSelected)
       setBackground(table.getSelectionBackground());
     else
       setBackground(table.getBackground());		
     
     setIcon(new ImageIcon(img.getImage().getScaledInstance(30, 
                                        30, Image.SCALE_DEFAULT)));
     setText(value.toString());
     	
     return this;   	
  }
  
  public void validate() {}
  public void revalidate() {}
  protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {}
  public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {}  
}
