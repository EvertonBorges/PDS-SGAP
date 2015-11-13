package modelo.tabela;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Categoria;

public class TabelaModeloCategoria extends AbstractTableModel{
    private final List<Categoria> categorias;
    private final String[] campos = {"Codigo", "Descricao"}; 

    public TabelaModeloCategoria(List<Categoria> categorias) {
        this.categorias = categorias;
    }
    
    @Override
    public int getRowCount() {
        return categorias.size();
    }

    @Override
    public int getColumnCount() {
        return campos.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Categoria categoria = categorias.get(rowIndex);
        switch(columnIndex){
            case 0: return categoria.getCodigo();
            case 1: return categoria.getDescricao();
            default: return null;
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
