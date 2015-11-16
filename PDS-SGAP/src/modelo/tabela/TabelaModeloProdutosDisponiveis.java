package modelo.tabela;

import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;
import modelo.Produto;

public class TabelaModeloProdutosDisponiveis  extends AbstractTableModel {
    
    private final List<Produto> produtos;
    private final String[] campos = {"", "", "", ""};
    
    public TabelaModeloProdutosDisponiveis(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    @Override
    public int getRowCount() {
        double d = (this.produtos.size()/campos.length)+1;
        return (int) Math.round(d);
    }
    
    @Override
    public int getColumnCount() {
         return campos.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        int indice = (rowIndex*(campos.length))+columnIndex;
        if(produtos.size()<4){
            indice = ((rowIndex*(produtos.size()))+columnIndex);
        }
        Produto produto;
        if (indice < produtos.size()){
            produto = produtos.get(indice);
            return produto.getNome();
        } else {
            return "";
        }
    }
    
    @Override
    public String getColumnName(int column){
        return null;
    }
    
   @Override
    public Class<?> getColumnClass(int column) {
        return JPanel.class;
    }
}