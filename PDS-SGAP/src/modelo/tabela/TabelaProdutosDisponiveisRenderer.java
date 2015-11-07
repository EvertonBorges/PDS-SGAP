/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.tabela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import modelo.Produto;
import modelo.textarea.ATextArea;

/**
 *
* @author Ada
 */
/*public class TabelaProdutosDisponiveisRenderer extends JLabel implements TableCellRenderer{

   private final List<Produto> produtos;   
   
   public TabelaProdutosDisponiveisRenderer(List<Produto> produtos) {
        
       this.produtos = produtos;
  	setOpaque(true);
  }
  
   @Override
  public Component getTableCellRendererComponent(JTable table, 
     Object value, boolean isSelected, boolean hasFocus, int row, 
     int column){
    
        ImageIcon img= new ImageIcon(produtos.get(row).getImagen());
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
}*/
/*
public class TabelaProdutosDisponiveisRenderer extends JPanel implements TableCellRenderer{

   private final List<Produto> produtos;   
   private ImageIcon img= new ImageIcon();
   
   public TabelaProdutosDisponiveisRenderer(List<Produto> produtos) {
        
        this.produtos = produtos;
  	setOpaque(true);
  }
  
   @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, 
                                                    boolean hasFocus, int rowIndex,  int columnIndex){
        
        Produto p = produtos.get((rowIndex*4)+columnIndex);
        
        img= new ImageIcon(p.getImagen());

        //if(isSelected)
         //   setBackground(table.getSelectionBackground());
        //else
           // setBackground(table.getBackground());		
 
        JLabel lImagem = new JLabel(new ImageIcon(img.getImage().getScaledInstance(30, 
                                          30, Image.SCALE_DEFAULT)));
        
        lImagem.setBounds(1, 1, 30 , 30);
        lImagem.setVisible(true);
        add(lImagem);
        setVisible(true);
              
        return this;   	
    }
  
   @Override
    public void validate() {}
    public void revalidate() {}
    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {}
    public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {}  
}*/

public class TabelaProdutosDisponiveisRenderer  implements TableCellRenderer{

   private final List<Produto> produtos;   
   private ImageIcon img= new ImageIcon();
   private JPanel painel= new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
   
   public TabelaProdutosDisponiveisRenderer(List<Produto> produtos) {
        painel=new JPanel();
        this.produtos = produtos;
  	painel.setOpaque(true);
  }
  
   @Override
    public Component getTableCellRendererComponent(JTable tbProduto, Object value, boolean isSelected, 
                                                    boolean hasFocus, int rowIndex,  int columnIndex){
        
         tbProduto.setRowSelectionAllowed(false);


        Produto p;
        int indice = (rowIndex*4)+columnIndex;
        if(produtos.size()<4){
            indice=((rowIndex*produtos.size())+columnIndex);
        }
        tbProduto.getSelectionModel().setSelectionMode( ListSelectionModel.SINGLE_SELECTION);  
        tbProduto.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
        tbProduto.setCellSelectionEnabled(true);
        
        if (indice < produtos.size()){
            painel.removeAll();
            p= produtos.get(indice);
            
            painel.add(getImagem(p));
            painel.add(getTextArea(p, rowIndex, isSelected));
            painel.setVisible(true);
            painel.repaint();
            painel.setBackground(getCor(rowIndex,isSelected));
            
            
            return painel;   
        }
        else {
            JPanel panel= new JPanel();
            panel.setBackground(new Color(223, 223, 223));
            return panel;   
        }
        	
    }
      // escolhe a cor a partir da linha  
        private Color getCor(int linha, boolean selecionada) {  
            // linhas selecionadas são azuis  
            if (selecionada) {  
                
                return Color.LIGHT_GRAY;  
            } 
            else
                return new Color(223, 223, 223);  

        }
    
    public JLabel getImagem(Produto produto){
        ImageIcon img = new ImageIcon(produto.getImagensProduto().get(0).getImagem());
        JLabel lImagem = new JLabel(new ImageIcon(img.getImage().getScaledInstance(100, 
                                          100, Image.SCALE_DEFAULT)));
        lImagem.setBounds(1, 1, 150 , 150);
        
       
        lImagem.setVisible(true); 
      
        return lImagem ;
  }
    
    public ATextArea getTextArea(Produto produto, int rowIndex, boolean isSelected){
        ATextArea textArea = new ATextArea();
       /* textArea.setText("<html>Produto "+ produto.getNome()+" "+
                "<br>"+ " "+ produto.getCondomino()+
                "<br>Reputação: calcular "+
                "<br> </html>" );*/
        
        textArea.setText("      "+ produto.getNome()+
                "\n      "+produto.getCondomino().getNome()+
                "\n      Reputação:cal%");
        textArea.setBounds(156, 3, 145 , 50);
        textArea.setBackground(getCor(rowIndex, isSelected));
        textArea.setEditable(false);  
        textArea.setLineWrap(true);
        textArea.setVisible(true);
        
        return textArea;
    }
   
    public void validate() {}
    public void revalidate() {}
    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {}
    public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {}  
}