package modelo.tabela;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.SolicitacaoAluguel;

public class TabelaModeloSolicitacoesAvaliacao extends AbstractTableModel{
    public List<SolicitacaoAluguel> solicitacoes;
    
    public String[] colunas = {"Produto", "Locador", "Data da solicitação"};

    public TabelaModeloSolicitacoesAvaliacao(List<SolicitacaoAluguel> solicitacoes) {
        this.solicitacoes = solicitacoes;
    }

    @Override
    public int getRowCount() {
        return solicitacoes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        SolicitacaoAluguel solicitacao = solicitacoes.get(linha);
        
        switch(coluna){
            case 0: return solicitacao.getProduto().getNome();
            case 1: return solicitacao.getProduto().getCondomino().getNome();
            case 2: return dataFormatada(solicitacao.getDataSolicitacao());
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