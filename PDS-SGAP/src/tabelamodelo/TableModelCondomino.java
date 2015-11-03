package tabelamodelo;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Condomino;

/**
 *
 * @author Bruna
 */
public class TableModelCondomino extends AbstractTableModel{
    public List<Condomino> condominos;
    public String[] colunas = {"Nome", "CPF", "Apartamento"};

    public TableModelCondomino(List<Condomino> condominos) {
        this.condominos = condominos;
    }

    @Override
    public int getRowCount() {
        return condominos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        
        Condomino condomino = condominos.get(linha);
        
        switch(coluna){
            case 0: return condomino.getNome();
            case 1: return condomino.getCpf();
            case 2: return "Bloco "+condomino.getApartamento().getBloco()+
                           " Andar "+condomino.getApartamento().getAndar()+
                           " Nº "+condomino.getApartamento().getNumApartamento();
            
            default: return "";
        }
    }
    
    @Override
    public String getColumnName(int coluna){
        switch(coluna){
            case 0: return colunas[0];
            case 1: return colunas[1];
            case 2: return colunas[2];
            
            default: return super.getColumnName(coluna);
        }
    }

}