package tela.locatario.minhassolicitacoes.expiradas;

import dao.AluguelDAO;
import dao.SolicitacaoAluguelDAO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import modelo.Aluguel;
import modelo.SolicitacaoAluguel;

public class MinhaSolicitacaoExpiradaDetalhesTela extends javax.swing.JFrame {
    private final SolicitacaoAluguel solicitacaoAluguel;

    /**
     * Creates new form ConsultarProdutoTela
     * @param solicitacaoAluguel
     */
    
    private SolicitacaoAluguelDAO sDAO = new SolicitacaoAluguelDAO();
  
    public MinhaSolicitacaoExpiradaDetalhesTela(SolicitacaoAluguel solicitacaoAluguel) {
        this.solicitacaoAluguel = solicitacaoAluguel;
        initComponents();
        carregarProduto();
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
        tfProduto = new javax.swing.JLabel();
        lDiaria = new javax.swing.JLabel();
        tfDiaria = new javax.swing.JLabel();
        lTaxa = new javax.swing.JLabel();
        tfTaxa = new javax.swing.JLabel();
        painelSolicitacao = new javax.swing.JPanel();
        lDataInicio = new javax.swing.JLabel();
        tfDataInicio = new javax.swing.JLabel();
        lDiasPretendidos = new javax.swing.JLabel();
        tfDiasPretendidos = new javax.swing.JLabel();
        lQtde = new javax.swing.JLabel();
        tfQtde = new javax.swing.JLabel();
        lDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();
        painelRequerente = new javax.swing.JPanel();
        lSolicitante = new javax.swing.JLabel();
        tfSolicitante = new javax.swing.JLabel();
        lContato = new javax.swing.JLabel();
        tfContato = new javax.swing.JLabel();
        lReputacao = new javax.swing.JLabel();
        tfReputacao = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        bCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Confirmação de Aluguel");

        painelProduto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Detalhes do Produto", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        lProduto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lProduto.setText("Nome:");

        tfProduto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfProduto.setText("jLabel1");

        lDiaria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lDiaria.setText("Diária:");

        tfDiaria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfDiaria.setText("jLabel1");

        lTaxa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lTaxa.setText("Taxa por dia de atraso:");

        tfTaxa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfTaxa.setText("jLabel1");

        painelSolicitacao.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Solicitação", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 255))); // NOI18N

        lDataInicio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lDataInicio.setForeground(new java.awt.Color(0, 0, 255));
        lDataInicio.setText("Data Início:");

        tfDataInicio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfDataInicio.setForeground(new java.awt.Color(0, 0, 255));
        tfDataInicio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tfDataInicio.setText("jLabel1");

        lDiasPretendidos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lDiasPretendidos.setForeground(new java.awt.Color(0, 0, 255));
        lDiasPretendidos.setText("Dias Pretendidos:");

        tfDiasPretendidos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfDiasPretendidos.setForeground(new java.awt.Color(0, 0, 255));
        tfDiasPretendidos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tfDiasPretendidos.setText("jLabel1");

        lQtde.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lQtde.setForeground(new java.awt.Color(0, 0, 255));
        lQtde.setText("Quantidade:");

        tfQtde.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfQtde.setForeground(new java.awt.Color(0, 0, 255));
        tfQtde.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tfQtde.setText("jLabel1");

        javax.swing.GroupLayout painelSolicitacaoLayout = new javax.swing.GroupLayout(painelSolicitacao);
        painelSolicitacao.setLayout(painelSolicitacaoLayout);
        painelSolicitacaoLayout.setHorizontalGroup(
            painelSolicitacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelSolicitacaoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelSolicitacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelSolicitacaoLayout.createSequentialGroup()
                        .addComponent(lQtde)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfQtde))
                    .addGroup(painelSolicitacaoLayout.createSequentialGroup()
                        .addGroup(painelSolicitacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lDiasPretendidos)
                            .addComponent(lDataInicio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelSolicitacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDiasPretendidos, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfDataInicio, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        painelSolicitacaoLayout.setVerticalGroup(
            painelSolicitacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSolicitacaoLayout.createSequentialGroup()
                .addGroup(painelSolicitacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lDataInicio)
                    .addComponent(tfDataInicio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelSolicitacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lDiasPretendidos)
                    .addComponent(tfDiasPretendidos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelSolicitacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lQtde)
                    .addComponent(tfQtde))
                .addGap(0, 13, Short.MAX_VALUE))
        );

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
                                .addComponent(tfProduto))
                            .addGroup(painelProdutoLayout.createSequentialGroup()
                                .addComponent(lDiaria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfDiaria))
                            .addGroup(painelProdutoLayout.createSequentialGroup()
                                .addComponent(lTaxa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfTaxa)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addComponent(painelSolicitacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelProdutoLayout.createSequentialGroup()
                        .addComponent(lDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        painelProdutoLayout.setVerticalGroup(
            painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelProdutoLayout.createSequentialGroup()
                .addGroup(painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelSolicitacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelProdutoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lProduto)
                            .addComponent(tfProduto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lDiaria)
                            .addComponent(tfDiaria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lTaxa)
                            .addComponent(tfTaxa))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lDescricao)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelRequerente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Detalhes do Requerente", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        lSolicitante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lSolicitante.setText("Solicitante:");

        tfSolicitante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfSolicitante.setText("jLabel1");

        lContato.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lContato.setText("Contato:");

        tfContato.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfContato.setText("jLabel1");

        lReputacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lReputacao.setForeground(new java.awt.Color(0, 0, 255));
        lReputacao.setText("Reputação:");

        tfReputacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfReputacao.setForeground(new java.awt.Color(0, 0, 255));
        tfReputacao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tfReputacao.setText("jLabel1");

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
                        .addComponent(tfSolicitante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lReputacao))
                    .addGroup(painelRequerenteLayout.createSequentialGroup()
                        .addComponent(lContato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfContato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfReputacao)))
                .addContainerGap())
        );
        painelRequerenteLayout.setVerticalGroup(
            painelRequerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRequerenteLayout.createSequentialGroup()
                .addGroup(painelRequerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lSolicitante)
                    .addComponent(tfSolicitante)
                    .addComponent(lReputacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelRequerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lContato)
                    .addComponent(tfContato)
                    .addComponent(tfReputacao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bCancelar.setText("Voltar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

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
                        .addComponent(bCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelRequerente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_bCancelarActionPerformed
    
    private void excluirSolicitacao(){
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente cancelar solicitação??", "Confirmar cancelamento", JOptionPane.YES_NO_OPTION);
        
        if(resposta == JOptionPane.YES_OPTION){
            try {            
                sDAO.removeSolicitacao(solicitacaoAluguel);
            }

            catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Erro: "+ ex.getMessage(), "Erro ao cancelar!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    private String stringToCalendar(Calendar date){
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return formatador.format(date.getTime());
    }
    
    public void preencherCampos(){
        //Preenchendo painel Produto.
        tfProduto.setText(this.solicitacaoAluguel.getProduto().getNome());
        tfDiaria.setText("R$"+this.solicitacaoAluguel.getProduto().getDiaria());
        tfTaxa.setText(this.solicitacaoAluguel.getProduto().getTaxa()+"%");
        taDescricao.setText(this.solicitacaoAluguel.getProduto().getDescricao());
        
        //Preenchendo painel Solicitão
        tfDataInicio.setText(stringToCalendar(this.solicitacaoAluguel.getDataInicioAluguel()));
        tfDiasPretendidos.setText(this.solicitacaoAluguel.getDiasPretendidos() + " dias.");
        tfQtde.setText("" + this.solicitacaoAluguel.getQuantidade());
        
        //Preenchendo painel Requerente.
        tfSolicitante.setText(this.solicitacaoAluguel.getLocatario().getNome());
        tfContato.setText(this.solicitacaoAluguel.getLocatario().getTelefones().get(0));
        tfReputacao.setText("Calcular ainda...");
    }
    
    private void carregarProduto(){
        preencherCampos();
    }
    
    public void criarAluguel(){
        Aluguel aluguel = new Aluguel();
        aluguel.setDataDevolucao(Calendar.getInstance());
        aluguel.setSolicitacaoAluguel(solicitacaoAluguel);
        
        AluguelDAO aluguelDAO = new AluguelDAO();
        aluguelDAO.addAluguel(aluguel);
        
        JOptionPane.showMessageDialog(null, "Aluguel confirmado", "Confirmacao de Aluguel", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lContato;
    private javax.swing.JLabel lDataInicio;
    private javax.swing.JLabel lDescricao;
    private javax.swing.JLabel lDiaria;
    private javax.swing.JLabel lDiasPretendidos;
    private javax.swing.JLabel lProduto;
    private javax.swing.JLabel lQtde;
    private javax.swing.JLabel lReputacao;
    private javax.swing.JLabel lSolicitante;
    private javax.swing.JLabel lTaxa;
    private javax.swing.JPanel painelProduto;
    private javax.swing.JPanel painelRequerente;
    private javax.swing.JPanel painelSolicitacao;
    private javax.swing.JTextArea taDescricao;
    private javax.swing.JLabel tfContato;
    private javax.swing.JLabel tfDataInicio;
    private javax.swing.JLabel tfDiaria;
    private javax.swing.JLabel tfDiasPretendidos;
    private javax.swing.JLabel tfProduto;
    private javax.swing.JLabel tfQtde;
    private javax.swing.JLabel tfReputacao;
    private javax.swing.JLabel tfSolicitante;
    private javax.swing.JLabel tfTaxa;
    // End of variables declaration//GEN-END:variables
}