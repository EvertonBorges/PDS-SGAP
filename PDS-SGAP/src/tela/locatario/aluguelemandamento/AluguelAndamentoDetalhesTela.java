package tela.locatario.aluguelemandamento;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import modelo.Aluguel;

public class AluguelAndamentoDetalhesTela extends javax.swing.JFrame {
    private final Aluguel aluguel;

    /**
     * Creates new form ConsultarProdutoTela
     * @param solicitacaoAluguel
     */
    
    public AluguelAndamentoDetalhesTela(Aluguel aluguel) {
        this.aluguel = aluguel;
        initComponents();
        preencherCampos();
    }
    
    private void preencherCampos(){
        labelProduto.setText(this.aluguel.getSolicitacaoAluguel().getProduto().getNome());
        labelDiaria.setText("R$ "+this.aluguel.getSolicitacaoAluguel().getProduto().getDiaria());
        labelTaxa.setText(this.aluguel.getSolicitacaoAluguel().getProduto().getTaxa()+"%");
        taDescricao.setText(this.aluguel.getSolicitacaoAluguel().getProduto().getDescricao());
        labelDataSolicitacao.setText(dataFormatada(this.aluguel.getSolicitacaoAluguel().getDataSolicitacao()));
        labelDataInicialAluguel.setText(dataFormatada(this.aluguel.getSolicitacaoAluguel().getDataInicioAluguel()));
        labelDataDevolucao.setText(dataFormatada(this.aluguel.getDataVencimento()));
        labelDiasPretendidos.setText(this.aluguel.getSolicitacaoAluguel().getDiasPretendidos()+"");
        labelDiasRestantes.setText(calculaDiasRestantes(this.aluguel.getDataVencimento()));
        labelDiasExcedidos.setText(diasExcedidos(this.aluguel.getDataVencimento())+"");
        labelValorAPagar.setText(calculaValor());
        labelLocador.setText(this.aluguel.getSolicitacaoAluguel().getProduto().getCondomino().getNome());
        labelContato.setText(contato(this.aluguel.getSolicitacaoAluguel().getProduto().getCondomino().getTelefones()));
        labelReputacao.setText("calcular");
    }
    
    private String contato(List<String> telefones){
        String mensagem = "";
        for(String tel : telefones)
            mensagem = mensagem + tel + " ";
        
        return mensagem;
    }
    
    // transforma Calendar em String
    private String dataFormatada(Calendar data){
        Calendar c = data;
        Date date = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        return sdf.format(date);
    }
    
    // calcular dias excedidos
    private int diasExcedidos(Calendar dataVencimento){
        Calendar dataAtual = Calendar.getInstance();
        int diasExcedidos = (dataAtual.get(Calendar.DAY_OF_YEAR) - dataVencimento.get(Calendar.DAY_OF_YEAR));
        
        if(diasExcedidos <=0){
            return 0;
        }
        else
            return diasExcedidos;
    }
    
    // calcular dias restantes
    private String calculaDiasRestantes(Calendar data){
        Calendar c = Calendar.getInstance();
        String mensagem = "";
        int diasRestantes = 0;
        int compara = data.compareTo(c);
        
        if(compara == 0){ // datas iguais
            mensagem = "0";
        }
        else{
            if(compara == 1){ // data para devolução é maior que a data atual
                diasRestantes = this.aluguel.getDataVencimento().get(Calendar.DAY_OF_YEAR) - c.get(Calendar.DAY_OF_YEAR);
                mensagem = diasRestantes+"";
            }
            else{
                mensagem = "0";
            }
        }
        
        return mensagem;
    }
    
    private String calculaValor(){
        int diasPretendidos = this.aluguel.getSolicitacaoAluguel().getDiasPretendidos();
        Calendar dataAtual = Calendar.getInstance();
        int dias = (dataAtual.get(Calendar.DAY_OF_YEAR) - this.aluguel.getSolicitacaoAluguel().getDataInicioAluguel().get(Calendar.DAY_OF_YEAR))+1;
        double valor = 0;
        String mensagem = "";
        
        if(dataAtual.compareTo(this.aluguel.getSolicitacaoAluguel().getDataInicioAluguel()) == -1){ // verifica se a data atual é menor que a data da inicial, ou seja o aluguel ainda não começou
            mensagem = "R$ 0";
        }
        else{
            if(dataAtual.compareTo(this.aluguel.getSolicitacaoAluguel().getDataInicioAluguel()) == 0) {// verifica se a data inicial do aluguel é igual a data atual
                valor = this.aluguel.getSolicitacaoAluguel().getProduto().getDiaria();
                mensagem = "R$ "+valor;
            }
            else{
                if(dias <= diasPretendidos){ // se ainda não estiver passado da data de devolução do produto
                    valor = this.aluguel.getSolicitacaoAluguel().getProduto().getDiaria()*dias;
                    mensagem = "R$ "+valor;
                }
                else{// calcula juros
                    double diaria = this.aluguel.getSolicitacaoAluguel().getProduto().getDiaria();
                    int diasExcedidos = diasExcedidos(this.aluguel.getDataVencimento());
                    double taxa = this.aluguel.getSolicitacaoAluguel().getProduto().getTaxa();
                    valor = (diaria*diasPretendidos)+(diaria*diasExcedidos*taxa);
                    mensagem = "R$ "+valor;
                }
            }
        }
 
        return mensagem;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelProduto = new javax.swing.JPanel();
        lProduto = new javax.swing.JLabel();
        labelProduto = new javax.swing.JLabel();
        lDiaria = new javax.swing.JLabel();
        labelDiaria = new javax.swing.JLabel();
        lTaxa = new javax.swing.JLabel();
        labelTaxa = new javax.swing.JLabel();
        lDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();
        painelRequerente = new javax.swing.JPanel();
        lSolicitante = new javax.swing.JLabel();
        labelLocador = new javax.swing.JLabel();
        lContato = new javax.swing.JLabel();
        labelContato = new javax.swing.JLabel();
        lReputacao = new javax.swing.JLabel();
        labelReputacao = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        bCancelar = new javax.swing.JButton();
        painelAluguel = new javax.swing.JPanel();
        lProduto1 = new javax.swing.JLabel();
        labelDataSolicitacao = new javax.swing.JLabel();
        lDiaria1 = new javax.swing.JLabel();
        labelDataInicialAluguel = new javax.swing.JLabel();
        lTaxa1 = new javax.swing.JLabel();
        labelDiasRestantes = new javax.swing.JLabel();
        lDiaria2 = new javax.swing.JLabel();
        labelDiasPretendidos = new javax.swing.JLabel();
        lTaxa2 = new javax.swing.JLabel();
        labelValorAPagar = new javax.swing.JLabel();
        lTaxa3 = new javax.swing.JLabel();
        labelDiasExcedidos = new javax.swing.JLabel();
        lDiaria3 = new javax.swing.JLabel();
        labelDataDevolucao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalhes Aluguel em Andamento");

        painelProduto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Produto", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        lProduto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lProduto.setText("Nome:");

        labelProduto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelProduto.setText("jLabel1");

        lDiaria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lDiaria.setText("Diária:");

        labelDiaria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelDiaria.setText("jLabel1");

        lTaxa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lTaxa.setText("Taxa por dia de atraso:");

        labelTaxa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelTaxa.setText("jLabel1");

        lDescricao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lDescricao.setText("Descrição:");

        taDescricao.setEditable(false);
        taDescricao.setBackground(new java.awt.Color(240, 240, 240));
        taDescricao.setColumns(20);
        taDescricao.setRows(5);
        jScrollPane1.setViewportView(taDescricao);

        javax.swing.GroupLayout painelProdutoLayout = new javax.swing.GroupLayout(painelProduto);
        painelProduto.setLayout(painelProdutoLayout);
        painelProdutoLayout.setHorizontalGroup(
            painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelProdutoLayout.createSequentialGroup()
                        .addGroup(painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelProdutoLayout.createSequentialGroup()
                                .addComponent(lProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelProduto))
                            .addGroup(painelProdutoLayout.createSequentialGroup()
                                .addComponent(lDiaria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelDiaria))
                            .addGroup(painelProdutoLayout.createSequentialGroup()
                                .addComponent(lTaxa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelTaxa)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painelProdutoLayout.createSequentialGroup()
                        .addComponent(lDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelProdutoLayout.setVerticalGroup(
            painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lProduto)
                    .addComponent(labelProduto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lDiaria)
                    .addComponent(labelDiaria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lTaxa)
                    .addComponent(labelTaxa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lDescricao)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        painelRequerente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Locador", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        lSolicitante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lSolicitante.setText("Nome:");

        labelLocador.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelLocador.setText("jLabel1");

        lContato.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lContato.setText("Contato:");

        labelContato.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelContato.setText("jLabel1");

        lReputacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lReputacao.setForeground(new java.awt.Color(0, 0, 255));
        lReputacao.setText("Reputação:");

        labelReputacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelReputacao.setForeground(new java.awt.Color(0, 0, 255));
        labelReputacao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelReputacao.setText("jLabel1");

        javax.swing.GroupLayout painelRequerenteLayout = new javax.swing.GroupLayout(painelRequerente);
        painelRequerente.setLayout(painelRequerenteLayout);
        painelRequerenteLayout.setHorizontalGroup(
            painelRequerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRequerenteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelRequerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelRequerenteLayout.createSequentialGroup()
                        .addComponent(lSolicitante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelLocador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lReputacao))
                    .addGroup(painelRequerenteLayout.createSequentialGroup()
                        .addComponent(lContato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelContato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelReputacao)))
                .addContainerGap())
        );
        painelRequerenteLayout.setVerticalGroup(
            painelRequerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRequerenteLayout.createSequentialGroup()
                .addGroup(painelRequerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lSolicitante)
                    .addComponent(labelLocador)
                    .addComponent(lReputacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelRequerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lContato)
                    .addComponent(labelContato)
                    .addComponent(labelReputacao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bCancelar.setText("Voltar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        painelAluguel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Aluguel", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        lProduto1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lProduto1.setText("Data da solicitação:");

        labelDataSolicitacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelDataSolicitacao.setText("jLabel1");

        lDiaria1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lDiaria1.setText("Data inicial do aluguel:");

        labelDataInicialAluguel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelDataInicialAluguel.setText("jLabel1");

        lTaxa1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lTaxa1.setText("Dias restantes:");

        labelDiasRestantes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelDiasRestantes.setText("jLabel1");

        lDiaria2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lDiaria2.setText("Dias pretendidos:");

        labelDiasPretendidos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelDiasPretendidos.setText("jLabel1");

        lTaxa2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lTaxa2.setText("Valor a ser pago:");

        labelValorAPagar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelValorAPagar.setText("jLabel1");

        lTaxa3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lTaxa3.setText("Dias excedidos:");

        labelDiasExcedidos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelDiasExcedidos.setText("jLabel1");

        lDiaria3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lDiaria3.setText("Data prevista para devolução:");

        labelDataDevolucao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelDataDevolucao.setText("jLabel1");

        javax.swing.GroupLayout painelAluguelLayout = new javax.swing.GroupLayout(painelAluguel);
        painelAluguel.setLayout(painelAluguelLayout);
        painelAluguelLayout.setHorizontalGroup(
            painelAluguelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAluguelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelAluguelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelAluguelLayout.createSequentialGroup()
                        .addComponent(lProduto1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelDataSolicitacao))
                    .addGroup(painelAluguelLayout.createSequentialGroup()
                        .addComponent(lDiaria1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelDataInicialAluguel))
                    .addGroup(painelAluguelLayout.createSequentialGroup()
                        .addComponent(lDiaria3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelDataDevolucao))
                    .addGroup(painelAluguelLayout.createSequentialGroup()
                        .addComponent(lDiaria2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelDiasPretendidos))
                    .addGroup(painelAluguelLayout.createSequentialGroup()
                        .addComponent(lTaxa1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelDiasRestantes))
                    .addGroup(painelAluguelLayout.createSequentialGroup()
                        .addComponent(lTaxa3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelDiasExcedidos))
                    .addGroup(painelAluguelLayout.createSequentialGroup()
                        .addComponent(lTaxa2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelValorAPagar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelAluguelLayout.setVerticalGroup(
            painelAluguelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAluguelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelAluguelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lProduto1)
                    .addComponent(labelDataSolicitacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelAluguelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lDiaria1)
                    .addComponent(labelDataInicialAluguel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelAluguelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lDiaria3)
                    .addComponent(labelDataDevolucao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelAluguelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lDiaria2)
                    .addComponent(labelDiasPretendidos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelAluguelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lTaxa1)
                    .addComponent(labelDiasRestantes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelAluguelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lTaxa3)
                    .addComponent(labelDiasExcedidos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelAluguelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lTaxa2)
                    .addComponent(labelValorAPagar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(painelProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelRequerente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bCancelar))
                    .addComponent(painelAluguel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(painelProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(painelRequerente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bCancelar)
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_bCancelarActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lContato;
    private javax.swing.JLabel lDescricao;
    private javax.swing.JLabel lDiaria;
    private javax.swing.JLabel lDiaria1;
    private javax.swing.JLabel lDiaria2;
    private javax.swing.JLabel lDiaria3;
    private javax.swing.JLabel lProduto;
    private javax.swing.JLabel lProduto1;
    private javax.swing.JLabel lReputacao;
    private javax.swing.JLabel lSolicitante;
    private javax.swing.JLabel lTaxa;
    private javax.swing.JLabel lTaxa1;
    private javax.swing.JLabel lTaxa2;
    private javax.swing.JLabel lTaxa3;
    private javax.swing.JLabel labelContato;
    private javax.swing.JLabel labelDataDevolucao;
    private javax.swing.JLabel labelDataInicialAluguel;
    private javax.swing.JLabel labelDataSolicitacao;
    private javax.swing.JLabel labelDiaria;
    private javax.swing.JLabel labelDiasExcedidos;
    private javax.swing.JLabel labelDiasPretendidos;
    private javax.swing.JLabel labelDiasRestantes;
    private javax.swing.JLabel labelLocador;
    private javax.swing.JLabel labelProduto;
    private javax.swing.JLabel labelReputacao;
    private javax.swing.JLabel labelTaxa;
    private javax.swing.JLabel labelValorAPagar;
    private javax.swing.JPanel painelAluguel;
    private javax.swing.JPanel painelProduto;
    private javax.swing.JPanel painelRequerente;
    private javax.swing.JTextArea taDescricao;
    // End of variables declaration//GEN-END:variables
}