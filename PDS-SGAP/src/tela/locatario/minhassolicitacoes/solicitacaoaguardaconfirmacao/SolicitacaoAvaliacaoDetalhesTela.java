package tela.locatario.minhassolicitacoes.solicitacaoaguardaconfirmacao;

import dao.SolicitacaoAluguelDAO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelo.SolicitacaoAluguel;
import util.ConversorData;
import util.FormatadorTelefone;

public class SolicitacaoAvaliacaoDetalhesTela extends javax.swing.JFrame {
    private final SolicitacaoAluguel solicitacao;
    
    public SolicitacaoAvaliacaoDetalhesTela(SolicitacaoAluguel solicitacao) {
        initComponents();
        this.solicitacao = solicitacao;
        preencherCampos();
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
        painelLocador = new javax.swing.JPanel();
        lSolicitante = new javax.swing.JLabel();
        labelLocador = new javax.swing.JLabel();
        lContato = new javax.swing.JLabel();
        labelContato = new javax.swing.JLabel();
        painelSolicitacao = new javax.swing.JPanel();
        lProduto1 = new javax.swing.JLabel();
        labelDataSolicitacao = new javax.swing.JLabel();
        lDiaria2 = new javax.swing.JLabel();
        labelDiasPretendidos = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        bExcluirSolicitacao = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalhes solicitação aguardando confirmação");

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

        painelLocador.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Locador", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        lSolicitante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lSolicitante.setText("Nome:");

        labelLocador.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelLocador.setText("jLabel1");

        lContato.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lContato.setText("Contato:");

        labelContato.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelContato.setText("jLabel1");

        javax.swing.GroupLayout painelLocadorLayout = new javax.swing.GroupLayout(painelLocador);
        painelLocador.setLayout(painelLocadorLayout);
        painelLocadorLayout.setHorizontalGroup(
            painelLocadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLocadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLocadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLocadorLayout.createSequentialGroup()
                        .addComponent(lSolicitante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelLocador))
                    .addGroup(painelLocadorLayout.createSequentialGroup()
                        .addComponent(lContato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelContato)))
                .addContainerGap(363, Short.MAX_VALUE))
        );
        painelLocadorLayout.setVerticalGroup(
            painelLocadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLocadorLayout.createSequentialGroup()
                .addGroup(painelLocadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lSolicitante)
                    .addComponent(labelLocador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelLocadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lContato)
                    .addComponent(labelContato))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelSolicitacao.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Solicitação", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        lProduto1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lProduto1.setText("Data da solicitação:");

        labelDataSolicitacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelDataSolicitacao.setText("jLabel1");

        lDiaria2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lDiaria2.setText("Dias pretendidos:");

        labelDiasPretendidos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelDiasPretendidos.setText("jLabel1");

        javax.swing.GroupLayout painelSolicitacaoLayout = new javax.swing.GroupLayout(painelSolicitacao);
        painelSolicitacao.setLayout(painelSolicitacaoLayout);
        painelSolicitacaoLayout.setHorizontalGroup(
            painelSolicitacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSolicitacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelSolicitacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelSolicitacaoLayout.createSequentialGroup()
                        .addComponent(lProduto1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelDataSolicitacao))
                    .addGroup(painelSolicitacaoLayout.createSequentialGroup()
                        .addComponent(lDiaria2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelDiasPretendidos)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelSolicitacaoLayout.setVerticalGroup(
            painelSolicitacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSolicitacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelSolicitacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lProduto1)
                    .addComponent(labelDataSolicitacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelSolicitacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lDiaria2)
                    .addComponent(labelDiasPretendidos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bExcluirSolicitacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bExcluirSolicitacao.setText("Excluir solicitação");
        bExcluirSolicitacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExcluirSolicitacaoActionPerformed(evt);
            }
        });

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
                    .addComponent(painelLocador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bExcluirSolicitacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bCancelar))
                    .addComponent(painelSolicitacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(painelProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelSolicitacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(painelLocador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCancelar)
                    .addComponent(bExcluirSolicitacao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bExcluirSolicitacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluirSolicitacaoActionPerformed
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja excluir esta solicitação?", "Aviso", JOptionPane.YES_NO_OPTION);
        
        if(resposta == JOptionPane.YES_OPTION){
            SolicitacaoAluguelDAO dao = new SolicitacaoAluguelDAO();
            dao.removeSolicitacao(this.solicitacao);
            dispose();
        }
    }//GEN-LAST:event_bExcluirSolicitacaoActionPerformed
    
    private void preencherCampos(){
        labelProduto.setText(this.solicitacao.getProduto().getNome());
        labelDiaria.setText("R$ "+this.solicitacao.getProduto().getDiaria());
        labelTaxa.setText(this.solicitacao.getProduto().getTaxa()+"%");
        taDescricao.setText(this.solicitacao.getProduto().getDescricao());
        labelDataSolicitacao.setText(ConversorData.convertToString(this.solicitacao.getDataSolicitacao().getTime()));
        labelDiasPretendidos.setText(this.solicitacao.getDiasPretendidos()+" dias");
        labelLocador.setText(this.solicitacao.getProduto().getCondomino().getNome());
        FormatadorTelefone.preencherTelefones(solicitacao, labelContato);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bExcluirSolicitacao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lContato;
    private javax.swing.JLabel lDescricao;
    private javax.swing.JLabel lDiaria;
    private javax.swing.JLabel lDiaria2;
    private javax.swing.JLabel lProduto;
    private javax.swing.JLabel lProduto1;
    private javax.swing.JLabel lSolicitante;
    private javax.swing.JLabel lTaxa;
    private javax.swing.JLabel labelContato;
    private javax.swing.JLabel labelDataSolicitacao;
    private javax.swing.JLabel labelDiaria;
    private javax.swing.JLabel labelDiasPretendidos;
    private javax.swing.JLabel labelLocador;
    private javax.swing.JLabel labelProduto;
    private javax.swing.JLabel labelTaxa;
    private javax.swing.JPanel painelLocador;
    private javax.swing.JPanel painelProduto;
    private javax.swing.JPanel painelSolicitacao;
    private javax.swing.JTextArea taDescricao;
    // End of variables declaration//GEN-END:variables
}