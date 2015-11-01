/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.Aluguel;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
    private final String[] campos = {"Imagem", "Produto", "Quantidade", "Status (teste)"}; 
    private byte[] byteImage = null; 
    private ImageIcon  imageIcon = new ImageIcon();  
    
    
    public TabelaProdutosDisponiveis(List<Produto> produtos) {
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
            case 0: 
                
 //               byteImage = produto.getImagen();
 //               System.out.println(""+ byteImage);
//                InputStream inputStream= new ByteArrayInputStream(byteImage);  
//                return new ImageIcon(byteImage).getImage();  
                if (produto.getImagensProduto().get(0).getImagem()!= null){
                    
                    ImageIcon img= new ImageIcon(produto.getImagensProduto().get(0).getImagem());
                 //   ALabel lImagem = new ALabel(img);
                   ImageIcon imagem= new ImageIcon(produto.getImagensProduto().get(0).getImagem());
                    JLabel lImagem = new JLabel();
                 //   lImagem.setIcon(new ImageIcon(img.getImage().getScaledInstance(5, 
                   //                     5, Image.SCALE_DEFAULT)));
                  //  return lImagem; //.getIcon()+"--";
                   // return new JLabel(null);
                    
                 //    lImagem.setIcon(  );  
       
                //   JLabel label = new JLabel();
                   lImagem.setBounds(1, 1, 30, 30);
                   lImagem.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(30, 
                                        30, Image.SCALE_DEFAULT)));
                  // JPanel painel = new JPanel();
                //   painel.add(lImagem);
               /*      return new ImageIcon(imagem.getImage().getScaledInstance(30, 
                                        30, Image.SCALE_DEFAULT));*/
                   return lImagem.getIcon();
                }
                else
                    return "sem imagem";
           // return  
            case 1: return produto.getNome();
            case 2: return produto.getQuantidade();
            case 3: return produto.isStatus();
            default: return "";
                
                
                   

          
        }
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
        //retorna a classe que representa a coluna  
        switch (column){
            case 0:
            return ImageIcon.class;  
            
            default: return Object.class;  
        }
    }
   } 
    
