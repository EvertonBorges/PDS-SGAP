package modelo.tabela;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Apartamento;

public class TabelaModeloApartamento extends AbstractTableModel{

    private List<Apartamento> aptos;
    private String[] campos = {"Bloco", "Andar", "Numero"};

    public TabelaModeloApartamento(List<Apartamento> aptos) {
        this.aptos = aptos;
    }
    
    @Override
    public int getRowCount() {
        return aptos.size();
    }

    @Override
    public int getColumnCount() {
        return campos.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Apartamento apto = aptos.get(rowIndex);
        switch(columnIndex){
            case 0 : return apto.getBloco();
            case 1 : return apto.getAndar();
            case 2 : return apto.getNumApartamento();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int coluna){
        return campos[coluna];
    }
}
