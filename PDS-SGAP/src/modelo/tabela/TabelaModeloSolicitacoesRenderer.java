package modelo.tabela;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;
import modelo.Produto;
import modelo.SolicitacaoAluguel;
import modelo.textarea.TextAreaModelo;

public class TabelaModeloSolicitacoesRenderer  implements TableCellRenderer{
    private final List<SolicitacaoAluguel> solicitacoes;
    private JPanel painel= new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
    
    public TabelaModeloSolicitacoesRenderer(List<SolicitacaoAluguel> solicitacoes) {
        painel=new JPanel();
        this.solicitacoes = solicitacoes;
  	painel.setOpaque(true);
    }
  
   @Override
    public Component getTableCellRendererComponent(JTable tbSolicitacoes, Object value, boolean isSelected, 
                                                    boolean hasFocus, int rowIndex,  int columnIndex){
        
         tbSolicitacoes.setRowSelectionAllowed(false);


        SolicitacaoAluguel s;
        int indice = (rowIndex*4)+columnIndex;
        if(solicitacoes.size()<4){
            indice=((rowIndex*solicitacoes.size())+columnIndex);
        }
        tbSolicitacoes.getSelectionModel().setSelectionMode( ListSelectionModel.SINGLE_SELECTION);  
        tbSolicitacoes.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
        tbSolicitacoes.setCellSelectionEnabled(true);
        
        if (indice < solicitacoes.size()){
            painel.removeAll();
            s= solicitacoes.get(indice);
            painel.setLayout(new FlowLayout(FlowLayout.CENTER,2,2));
//            System.out.println("---"+p.getImagensProduto().get(0));
            
            painel.add(getTextArea(s, rowIndex, isSelected));
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
     
    private String dataFormatada(Calendar data){
        Calendar c = data;
        Date date = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        return sdf.format(date);
    }

    
    private TextAreaModelo getTextArea(SolicitacaoAluguel solicitacaoAluguel, int rowIndex, boolean isSelected){
        TextAreaModelo textArea = new TextAreaModelo();
        
        textArea.setText("Solicitante: "+solicitacaoAluguel.getLocatario()+
                    "\nDevendo: " +"sempre"+
                    "\nInicio: " + dataFormatada(solicitacaoAluguel.getDataInicioAluguel()) +
            "\nDias: " + solicitacaoAluguel.getDiasPretendidos());
       
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