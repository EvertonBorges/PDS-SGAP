package tela.minhassolicitacoes.emavaliacao;

import dao.SolicitacaoAluguelDAO;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import modelo.Condomino;
import modelo.Produto;
import modelo.SolicitacaoAluguel;
import modelo.tabela.TabelaModeloRenderer;
import modelo.tabela.TabelaModeloSolicitacoes;

public class SolicitacoesProdutoEmAvaliacaoTela extends javax.swing.JFrame {
    
    private SolicitacaoAluguelDAO sDAO = new SolicitacaoAluguelDAO();
    private  SolicitacaoAluguel solicitacaoAluguel;
    private Condomino condomino;
    private List<SolicitacaoAluguel> solicitacaoAluguels;
    /**
     * Creates new form SolicitacaoRequerentesTela
     * @param produto
     */
    public SolicitacoesProdutoEmAvaliacaoTela(Produto produto, Condomino condomino) {
        this.solicitacaoAluguels = sDAO.findSolicitacaoProdutoEmAvaliacao( condomino, produto);
        initComponents();
        preencherTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelRequerentes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProduto = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        bSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelRequerentes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Solicitações", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        tbProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbProdutoMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbProduto);

        javax.swing.GroupLayout painelRequerentesLayout = new javax.swing.GroupLayout(painelRequerentes);
        painelRequerentes.setLayout(painelRequerentesLayout);
        painelRequerentesLayout.setHorizontalGroup(
            painelRequerentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
            .addGroup(painelRequerentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelRequerentesLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        painelRequerentesLayout.setVerticalGroup(
            painelRequerentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
            .addGroup(painelRequerentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelRequerentesLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        bSair.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bSair.setText("Sair");
        bSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(painelRequerentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(bSair, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelRequerentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bSair)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbProdutoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProdutoMouseReleased
        // TODO add your handling code

        selecionarProduto(evt);
        //    realizarAcao(evt);
    }//GEN-LAST:event_tbProdutoMouseReleased

    private void bSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSairActionPerformed
        dispose();
    }//GEN-LAST:event_bSairActionPerformed
    
    private void selecionarProduto(MouseEvent evt) {

        int linha = tbProduto.rowAtPoint(evt.getPoint());
        int coluna = tbProduto.columnAtPoint(evt.getPoint());

        if (linha >= 0 ) { 
            
            tbProduto.getSelectionModel().setSelectionMode( ListSelectionModel.SINGLE_SELECTION);  
            tbProduto.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
            tbProduto.setCellSelectionEnabled(true);
            
            int indice=((linha)*4)+coluna;
            
            if (indice<this.solicitacaoAluguels.size()){
                this.solicitacaoAluguel = this.solicitacaoAluguels.get(indice);
                realizarAcao(evt);
            }
        }

    }
    
    private void realizarAcao(MouseEvent evt) {

        if (evt.getButton() == MouseEvent.BUTTON1) { 

            if (evt.getClickCount() > 1) { 
                telaConsultar();
            }

        } else if (evt.getButton() == MouseEvent.BUTTON3) { 
         //   mPopup.show(evt.getComponent(), evt.getX(), evt.getY());

        }

    }
    private void telaConsultar(){
        MinhaSolicitacaoEmAvaliacaoDetalhesTela telaConsultar = new MinhaSolicitacaoEmAvaliacaoDetalhesTela(this.solicitacaoAluguel);
        telaConsultar.setVisible(true);
    }
    
    private void preencherTabela() {
        
        //tbProduto.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
        
        tbProduto.setDefaultRenderer(JPanel.class, new TabelaModeloRenderer(this.solicitacaoAluguels, 1));
        
        tbProduto.setModel(new TabelaModeloSolicitacoes(this.solicitacaoAluguels));

        tbProduto.setRowHeight(100); 
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bSair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel painelRequerentes;
    private javax.swing.JTable tbProduto;
    // End of variables declaration//GEN-END:variables
}