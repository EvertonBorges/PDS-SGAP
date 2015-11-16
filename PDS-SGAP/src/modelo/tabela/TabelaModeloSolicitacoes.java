package modelo.tabela;

import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;

import modelo.SolicitacaoAluguel;
import modelo.textarea.TextAreaModelo;

public class TabelaModeloSolicitacoes  extends AbstractTableModel {
    
    private final List<SolicitacaoAluguel> solicitacoes;
    private final String[] campos = {"", "", "", ""};
    
    public TabelaModeloSolicitacoes(List<SolicitacaoAluguel> solicitacoes) {
        this.solicitacoes = solicitacoes;
    }
    
    @Override
    public int getRowCount() {
        double d = (this.solicitacoes.size()/campos.length)+1;
        return (int) Math.round(d);
    }
    
    @Override
    public int getColumnCount() {
         return campos.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        int indice = (rowIndex*(campos.length))+columnIndex;
        if(solicitacoes.size()<4){
            indice = ((rowIndex*(solicitacoes.size()))+columnIndex);
        }
        SolicitacaoAluguel solicitacaoAluguel;
        if (indice < solicitacoes.size()){
            solicitacaoAluguel = solicitacoes.get(indice);
            return solicitacaoAluguel.getCodigo();
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