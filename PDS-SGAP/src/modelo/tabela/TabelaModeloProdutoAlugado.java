package modelo.tabela;

import java.util.Calendar;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Aluguel;

public class TabelaModeloProdutoAlugado extends AbstractTableModel{
    public List<Aluguel> produtosAlugados;
    public String[] colunas = {"Produto", "Locatário", "Situação"};

    public TabelaModeloProdutoAlugado(List<Aluguel> produtosAlugados) {
        this.produtosAlugados = produtosAlugados;
    }

    @Override
    public int getRowCount() {
        return produtosAlugados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Aluguel aluguel = produtosAlugados.get(linha);
        Calendar c = Calendar.getInstance();
        int compara = aluguel.getDataVencimento().compareTo(c);
        String mensagem = "";
        
        if(aluguel.getDataVencimento().get(Calendar.DAY_OF_YEAR) == c.get(Calendar.DAY_OF_YEAR))
            mensagem = "Último dia para devolução";
        else{
            if(compara == 1){
                mensagem = "Em dias";
            }
            else{
                mensagem = "Devolução atrasada";
            }
        }
        
        switch(coluna){
            case 0: return aluguel.getSolicitacaoAluguel().getProduto().getNome();
            case 1: return aluguel.getSolicitacaoAluguel().getLocatario().getNome();
            case 2: return mensagem;
            default: return "";
        }
    }
    
    @Override
    public String getColumnName(int coluna){
        return colunas[coluna];
    }
}