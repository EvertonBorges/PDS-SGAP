package modelo.tabela;

import java.util.Calendar;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Aluguel;

public class TabelaModeloAlugueisAndamento extends AbstractTableModel{
    public List<Aluguel> alugueis;
    public String[] colunas = {"Produto", "Dias restantes"};

    public TabelaModeloAlugueisAndamento(List<Aluguel> alugueis) {
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
        Calendar c = Calendar.getInstance();
        int diasRestantes = 0;
        int compara = aluguel.getDataVencimento().compareTo(c);
        String mensagem = "";
        
        if(aluguel.getDataDevolucao() == null){
            if(compara == 0)
                mensagem = "Último dia para devolução";
            else{
                if(compara == 1){
                    diasRestantes = aluguel.getDataVencimento().get(Calendar.DAY_OF_YEAR) - c.get(Calendar.DAY_OF_YEAR);
                    mensagem = diasRestantes+" dias";
                }
                else{
                    diasRestantes = c.get(Calendar.DAY_OF_YEAR) - aluguel.getDataVencimento().get(Calendar.DAY_OF_YEAR);
                    mensagem = diasRestantes+" dia(s) ultrapassado(s) da data de devolução";
                }
            }
        }
        
        switch(coluna){
            case 0: return aluguel.getSolicitacaoAluguel().getProduto();
            case 1: return mensagem;
            default: return "";
        }
    }
    
    @Override
    public String getColumnName(int coluna){
        return colunas[coluna];
    }
}