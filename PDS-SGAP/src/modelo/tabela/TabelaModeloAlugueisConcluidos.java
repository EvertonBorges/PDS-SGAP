package modelo.tabela;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Aluguel;

public class TabelaModeloAlugueisConcluidos extends AbstractTableModel{
    public List<Aluguel> alugueis;
    public String[] colunas = {"Produto", "Data de devolução", "Locador"};

    public TabelaModeloAlugueisConcluidos(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }

    @Override
    public int getRowCount() {
        return alugueis.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Aluguel aluguel = alugueis.get(linha);
        
        switch(coluna){
            case 0: return aluguel.getSolicitacaoAluguel().getProduto();
            case 1: return dataFormatada(aluguel.getDataDevolucao());
            case 2: return aluguel.getSolicitacaoAluguel().getProduto().getCondomino().getNome();   
            default: return "";
        }
    }
    
    @Override
    public String getColumnName(int coluna){
        return colunas[coluna];
    }
    
    // transforma Calendar em String
    private String dataFormatada(Calendar data){
        Calendar c = data;
        Date date = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        return sdf.format(date);
    }
}