package modelo.tabela;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Produto;

public class TabelaModeloProduto extends AbstractTableModel{
    private final List<Produto> produtos;
    private final String[] campos = {"Produto", "Diária"}; 

    public TabelaModeloProduto(List<Produto> produtos) {
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
            case 1: return "R$" + produto.getDiaria();
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
