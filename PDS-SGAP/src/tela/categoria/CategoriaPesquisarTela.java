package tela.categoria;

import dao.CategoriaDAO;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Categoria;
import modelo.tabela.TabelaModeloCategoria;

public class CategoriaPesquisarTela extends javax.swing.JFrame {
    private List<Categoria> categorias;
    private Categoria categoria;
    /**
     * Creates new form PesquisarProdutos
     */
    public CategoriaPesquisarTela() {
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
        miDetalhes = new javax.swing.JMenuItem();
        miAtualizar = new javax.swing.JMenuItem();
        miExcluir = new javax.swing.JMenuItem();
        pnCamposPesquisa = new javax.swing.JPanel();
        lNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        bPesquisar = new javax.swing.JButton();
        pnResultados = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbResultados = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        bCadastrar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();

        miDetalhes.setText("Ver Detalhes");
        miDetalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDetalhesActionPerformed(evt);
            }
        });
        menuFlutuante.add(miDetalhes);

        miAtualizar.setText("Atualizar");
        miAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAtualizarActionPerformed(evt);
            }
        });
        menuFlutuante.add(miAtualizar);

        miExcluir.setText("Excluir");
        miExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExcluirActionPerformed(evt);
            }
        });
        menuFlutuante.add(miExcluir);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisar Categoria");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        pnCamposPesquisa.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Campos de Pesquisa", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        lNome.setText("Nome");

        tfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNomeKeyPressed(evt);
            }
        });

        bPesquisar.setText("Pesquisar");
        bPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCamposPesquisaLayout = new javax.swing.GroupLayout(pnCamposPesquisa);
        pnCamposPesquisa.setLayout(pnCamposPesquisaLayout);
        pnCamposPesquisaLayout.setHorizontalGroup(
            pnCamposPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCamposPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCamposPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCamposPesquisaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(tfNome))
                    .addGroup(pnCamposPesquisaLayout.createSequentialGroup()
                        .addComponent(lNome)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCamposPesquisaLayout.createSequentialGroup()
                .addContainerGap(151, Short.MAX_VALUE)
                .addComponent(bPesquisar)
                .addGap(155, 155, 155))
        );
        pnCamposPesquisaLayout.setVerticalGroup(
            pnCamposPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCamposPesquisaLayout.createSequentialGroup()
                .addComponent(lNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bPesquisar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnResultados.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Resultados", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N

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
        jScrollPane2.setViewportView(tbResultados);

        javax.swing.GroupLayout pnResultadosLayout = new javax.swing.GroupLayout(pnResultados);
        pnResultados.setLayout(pnResultadosLayout);
        pnResultadosLayout.setHorizontalGroup(
            pnResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnResultadosLayout.setVerticalGroup(
            pnResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bCadastrar.setText("Cadastrar");
        bCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadastrarActionPerformed(evt);
            }
        });

        bCancelar.setText("Cancelar");
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
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(bCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bCancelar)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnCamposPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pnResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1)))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnCamposPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnResultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCadastrar)
                    .addComponent(bCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        carregarTabela();
    }//GEN-LAST:event_formWindowGainedFocus

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastrarActionPerformed
        CategoriaCadastrarTela categoriaCadastrarTela = new CategoriaCadastrarTela();
        categoriaCadastrarTela.setVisible(true);
    }//GEN-LAST:event_bCadastrarActionPerformed

    private void tbResultadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbResultadosMouseReleased
        selecionarCategoria(evt);
        realizarAcao(evt);
    }//GEN-LAST:event_tbResultadosMouseReleased

    private void miDetalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDetalhesActionPerformed
        verDetalhes();
    }//GEN-LAST:event_miDetalhesActionPerformed

    private void miAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAtualizarActionPerformed
        
    }//GEN-LAST:event_miAtualizarActionPerformed

    private void miExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExcluirActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir o registro: " + categoria.getDescricao() + "?", "Excluir Produto", JOptionPane.YES_NO_OPTION);
        if(resposta == JOptionPane.YES_OPTION){
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            categoriaDAO.removeCategoria(categoria);
        }
    }//GEN-LAST:event_miExcluirActionPerformed

    private void bPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPesquisarActionPerformed
        carregarTabela();
    }//GEN-LAST:event_bPesquisarActionPerformed

    private void tfNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomeKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
            carregarTabela();
        }
    }//GEN-LAST:event_tfNomeKeyPressed
    
    private void selecionarCategoria(MouseEvent evt) {
        int linha = tbResultados.rowAtPoint(evt.getPoint());
        if (linha >= 0) {
            tbResultados.setRowSelectionInterval(linha, linha);
            linha = tbResultados.getSelectedRow();
            categoria = categorias.get(linha);
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
        CategoriaDetalhesTela categoriaDetalhesTela = new CategoriaDetalhesTela(categoria);
        categoriaDetalhesTela.setVisible(true);
    }
    
    private void carregarCategorias(){
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        Categoria categoriaLocal = new Categoria();
        categoriaLocal.setDescricao(tfNome.getText());
        categorias = categoriaDAO.findCategoria(categoriaLocal);
    }
    
    private void carregarTabela() {
        carregarCategorias();
        TabelaModeloCategoria modelo = new TabelaModeloCategoria(categorias);
        tbResultados.setModel(modelo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCadastrar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bPesquisar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lNome;
    private javax.swing.JPopupMenu menuFlutuante;
    private javax.swing.JMenuItem miAtualizar;
    private javax.swing.JMenuItem miDetalhes;
    private javax.swing.JMenuItem miExcluir;
    private javax.swing.JPanel pnCamposPesquisa;
    private javax.swing.JPanel pnResultados;
    private javax.swing.JTable tbResultados;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}