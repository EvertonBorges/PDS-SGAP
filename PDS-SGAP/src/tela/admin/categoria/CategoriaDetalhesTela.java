package tela.admin.categoria;

import dao.CategoriaDAO;
import javax.swing.JOptionPane;
import modelo.Categoria;

public class CategoriaDetalhesTela extends javax.swing.JFrame {
    private final Categoria categoria;
    
    /**
     * Creates new form ConsultarProduto
     * @param categoria
     */
    public CategoriaDetalhesTela(Categoria categoria) {
        this.categoria = categoria;
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

        lNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        bAlterar = new javax.swing.JButton();
        bExcluir = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalhes da Categoria");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        lNome.setText("Descrição:");

        tfNome.setText("jLabel6");

        bAlterar.setText("Alterar");
        bAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAlterarActionPerformed(evt);
            }
        });

        bExcluir.setText("Excluir");
        bExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExcluirActionPerformed(evt);
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
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(bExcluir)
                        .addGap(77, 77, 77)
                        .addComponent(bCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNome)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNome)
                    .addComponent(tfNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAlterar)
                    .addComponent(bExcluir)
                    .addComponent(bCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        preencherCampos();
    }//GEN-LAST:event_formWindowGainedFocus

    private void bAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAlterarActionPerformed
        CategoriaAtualizarTela atualizarProduto = new CategoriaAtualizarTela(categoria);
        atualizarProduto.setVisible(true);
    }//GEN-LAST:event_bAlterarActionPerformed

    private void bExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluirActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir o registro: " + categoria.getDescricao() + "?", "Excluir Produto", JOptionPane.YES_NO_OPTION);
        if(resposta == JOptionPane.YES_OPTION){
            dispose();
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            categoriaDAO.removeCategoria(categoria);
        }
    }//GEN-LAST:event_bExcluirActionPerformed
    
    private void preencherCampos(){
        tfNome.setText(categoria.getDescricao());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAlterar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bExcluir;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lNome;
    private javax.swing.JLabel tfNome;
    // End of variables declaration//GEN-END:variables
}
