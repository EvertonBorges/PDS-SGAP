package modelo.tabela;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;
import modelo.Produto;
import modelo.textarea.TextAreaModelo;

public class TabelaModeloProdutosDisponiveisRenderer  implements TableCellRenderer{

    private final List<Produto> produtos;   
    private ImageIcon img= new ImageIcon();
    private JPanel painel= new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));

    public TabelaModeloProdutosDisponiveisRenderer(List<Produto> produtos) {
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
            painel.setLayout(new FlowLayout(FlowLayout.CENTER,2,2));
//            System.out.println("---"+p.getImagensProduto().get(0));
            if (p.getImagensProduto().size()>0){
                painel.add(getImagem(p));
            }
            else {
                TextAreaModelo tA= new TextAreaModelo();
                tA.setText("\n\n\nSEM IMAGEM"+"\n               ");
                tA.setBounds(1, 1, 156 , 156);
                tA.setBackground(getCor(isSelected));
                painel.add(tA);
            }
            painel.add(getTextArea(p, rowIndex, isSelected));
            painel.setBackground(getCor(isSelected));
            painel.setBorder(getBorder(isSelected));
            painel.setVisible(true);
            painel.repaint();
            
            return painel;   
        }
        else {
            JPanel panel= new JPanel();
            panel.setBackground(new Color(223, 223, 223));
            return panel;   
        }
        	
    }
    
    private Color getCor(boolean selecionada) {  
            // linhas selecionadas são azuis  
            if (selecionada) {  
                
                return Color.LIGHT_GRAY;  
            } 
            else
                return new Color(223, 223, 223);  

    }
    
    private Border getBorder(boolean selecionada){
        if (selecionada){
            return new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true);
        }
        else{
            return null;
        }
    }
        
    
    private JLabel getImagem(Produto produto){
        ImageIcon img = new ImageIcon(produto.getImagensProduto().get(0).getImagem());
        JLabel lImagem = new JLabel(new ImageIcon(img.getImage().getScaledInstance(100, 
                                          100, Image.SCALE_DEFAULT)));
        lImagem.setBounds(1, 1, 150 , 150);
        
       
        lImagem.setVisible(true); 
      
        return lImagem ;
  }
    
    private TextAreaModelo getTextArea(Produto produto, int rowIndex, boolean isSelected){
        TextAreaModelo textArea = new TextAreaModelo();
        
        textArea.setText("      "+ produto.getNome()+
                            "\n      "+produto.getCondomino().getNome()+
                            "\n      Reputação:cal%");
        textArea.setBounds(156, 3, 144 , 50);
        textArea.setBackground(getCor( isSelected));
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