/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.aluguel;

import dao.SolicitacaoAluguelDAO;
import java.awt.event.MouseEvent;
import java.util.List;
import modelo.Condomino;
import modelo.Produto;
import modelo.tabela.TabelaModeloProduto;

/**
 *
 * @author Borges
 */
public class SolicitacaoPesquisarTela extends javax.swing.JFrame {
    private final Condomino condomino;
    private List<Produto> produtos;
    private Produto produtoSelecionado;
    
    /**
     * Creates new form SolicitacaoPesquisarTela
     * @param condomino
     */
    public SolicitacaoPesquisarTela(Condomino condomino) {
        this.condomino = condomino;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuFlutuante = new javax.swing.JPopupMenu();
        miDetalhesProduto = new javax.swing.JMenuItem();
        miRequerentes = new javax.swing.JMenuItem();
        painelPesquisa = new javax.swing.JPanel();
        lProduto = new javax.swing.JLabel();
        tfProduto = new javax.swing.JTextField();
        bProduto = new javax.swing.JButton();
        painelResultados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbResultados = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        bSair = new javax.swing.JButton();

        miDetalhesProduto.setText("jMenuItem1");
        miDetalhesProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDetalhesProdutoActionPerformed(evt);
            }
        });
        menuFlutuante.add(miDetalhesProduto);

        miRequerentes.setText("Requerentes");
        miRequerentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRequerentesActionPerformed(evt);
            }
        });
        menuFlutuante.add(miRequerentes);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisar Solicitações");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        painelPesquisa.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pesquisar", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        lProduto.setText("Produto");

        tfProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfProdutoKeyPressed(evt);
            }
        });

        bProduto.setText("Pesquisar");
        bProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelPesquisaLayout = new javax.swing.GroupLayout(painelPesquisa);
        painelPesquisa.setLayout(painelPesquisaLayout);
        painelPesquisaLayout.setHorizontalGroup(
            painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPesquisaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(tfProduto))
                    .addGroup(painelPesquisaLayout.createSequentialGroup()
                        .addComponent(lProduto)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(painelPesquisaLayout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(bProduto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelPesquisaLayout.setVerticalGroup(
            painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPesquisaLayout.createSequentialGroup()
                .addComponent(lProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bProduto)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        painelResultados.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Resultados", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        tbResultados.setModel(new javax.swing.table.DefaultTableModel(
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
        tbResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbResultadosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbResultados);

        javax.swing.GroupLayout painelResultadosLayout = new javax.swing.GroupLayout(painelResultados);
        painelResultados.setLayout(painelResultadosLayout);
        painelResultadosLayout.setHorizontalGroup(
            painelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelResultadosLayout.setVerticalGroup(
            painelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelResultadosLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addContainerGap())
        );

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(painelResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bSair)
                .addGap(194, 194, 194))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelResultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        preencherTabela();
    }//GEN-LAST:event_formWindowGainedFocus

    private void bProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bProdutoActionPerformed
        preencherTabela();
    }//GEN-LAST:event_bProdutoActionPerformed

    private void bSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSairActionPerformed
        dispose();
    }//GEN-LAST:event_bSairActionPerformed

    private void tfProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfProdutoKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            preencherTabela();
        }
    }//GEN-LAST:event_tfProdutoKeyPressed

    private void tbResultadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbResultadosMouseReleased
        selecionarProduto(evt);
        realizarAcao(evt);
    }//GEN-LAST:event_tbResultadosMouseReleased

    private void miDetalhesProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDetalhesProdutoActionPerformed
        verDetalhes();
    }//GEN-LAST:event_miDetalhesProdutoActionPerformed

    private void miRequerentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRequerentesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miRequerentesActionPerformed

    private void selecionarProduto(MouseEvent evt) {
        int linha = tbResultados.rowAtPoint(evt.getPoint());
        if (linha >= 0) {
            tbResultados.setRowSelectionInterval(linha, linha);
            linha = tbResultados.getSelectedRow();
            this.produtoSelecionado = produtos.get(linha);
        }
    }
    
    private void realizarAcao(MouseEvent evt) {
        if (evt.getButton() == MouseEvent.BUTTON1) { // Botão Esquerdo do Mouse
            if (evt.getClickCount() > 1) { // Se for mais de 2 cliques
                verDetalhes();
            }
        } else if (evt.getButton() == MouseEvent.BUTTON3) { //Botão Direito do Mouse
            menuFlutuante.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }
    
    private void verDetalhes(){
        ProdutoDetalhesTela produtoDetalhesTela = new ProdutoDetalhesTela(produtoSelecionado);
        produtoDetalhesTela.setVisible(true);
    }
    
    private void preencherTabela(){
        SolicitacaoAluguelDAO solicitacaoAluguelDAO = new SolicitacaoAluguelDAO();
        Produto produto = new Produto();
        produto.setNome(tfProduto.getText());
        produto.setCondomino(condomino);
        produtos = solicitacaoAluguelDAO.findProdutos(produto);
        TabelaModeloProduto modelo = new TabelaModeloProduto(produtos);
        tbResultados.setModel(modelo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bProduto;
    private javax.swing.JButton bSair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lProduto;
    private javax.swing.JPopupMenu menuFlutuante;
    private javax.swing.JMenuItem miDetalhesProduto;
    private javax.swing.JMenuItem miRequerentes;
    private javax.swing.JPanel painelPesquisa;
    private javax.swing.JPanel painelResultados;
    private javax.swing.JTable tbResultados;
    private javax.swing.JTextField tfProduto;
    // End of variables declaration//GEN-END:variables
}