package tela.locador.meusprodutos;

import dao.AluguelDAO;
import modelo.painel.PainelModeloImagens;
import modelo.lista.ListaModeloCategorias;
import dao.ProdutoDAO;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.ImagemProduto;
import modelo.Produto;
import util.JPAUtil;

public class ProdutoDetalhesTela extends javax.swing.JFrame {
    private Produto produto;
    private JPanel img;
    
    /**
     * Creates new form ConsultarProduto
     * @param produto
     */
    public ProdutoDetalhesTela(Produto produto) {
        this.produto = produto;
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
        lDiária = new javax.swing.JLabel();
        lTaxaAtraso = new javax.swing.JLabel();
        lStatus = new javax.swing.JLabel();
        tfNome = new javax.swing.JLabel();
        tfTaxaAtraso = new javax.swing.JLabel();
        tfDiaria = new javax.swing.JLabel();
        tfStatus = new javax.swing.JLabel();
        painelCategorias = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaCategorias = new javax.swing.JList();
        painelImagens = new javax.swing.JPanel();
        imgPrincipal = new javax.swing.JPanel();
        img1 = new javax.swing.JPanel();
        img2 = new javax.swing.JPanel();
        img3 = new javax.swing.JPanel();
        painelDescricao = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        bAlterar = new javax.swing.JButton();
        bExcluir = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalhes do Produto");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        lNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lNome.setText("Nome:");

        lDiária.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lDiária.setText("Diária:");

        lTaxaAtraso.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lTaxaAtraso.setText("Taxa de atraso:");

        lStatus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lStatus.setText("Status:");

        tfNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfNome.setText("jLabel6");

        tfTaxaAtraso.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfTaxaAtraso.setText("jLabel8");

        tfDiaria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfDiaria.setText("jLabel9");

        tfStatus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfStatus.setText("jLabel10");

        painelCategorias.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Categorias", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        listaCategorias.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        listaCategorias.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaCategorias);

        javax.swing.GroupLayout painelCategoriasLayout = new javax.swing.GroupLayout(painelCategorias);
        painelCategorias.setLayout(painelCategoriasLayout);
        painelCategoriasLayout.setHorizontalGroup(
            painelCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCategoriasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelCategoriasLayout.setVerticalGroup(
            painelCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );

        painelImagens.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Imagens", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 0, 0))); // NOI18N
        painelImagens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                painelImagensMouseReleased(evt);
            }
        });

        imgPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        imgPrincipal.setLayout(new java.awt.BorderLayout());

        img1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        img1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                img1MouseReleased(evt);
            }
        });
        img1.setLayout(new java.awt.BorderLayout());

        img2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        img2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                img2MouseReleased(evt);
            }
        });
        img2.setLayout(new java.awt.BorderLayout());

        img3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        img3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                img3MouseReleased(evt);
            }
        });
        img3.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout painelImagensLayout = new javax.swing.GroupLayout(painelImagens);
        painelImagens.setLayout(painelImagensLayout);
        painelImagensLayout.setHorizontalGroup(
            painelImagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelImagensLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelImagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelImagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(img3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(img1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(img2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        painelImagensLayout.setVerticalGroup(
            painelImagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(painelImagensLayout.createSequentialGroup()
                .addComponent(img1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(img2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(img3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        painelDescricao.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Descrição", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        taDescricao.setBackground(new java.awt.Color(240, 240, 240));
        taDescricao.setColumns(20);
        taDescricao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        taDescricao.setRows(5);
        taDescricao.setEnabled(false);
        jScrollPane2.setViewportView(taDescricao);

        javax.swing.GroupLayout painelDescricaoLayout = new javax.swing.GroupLayout(painelDescricao);
        painelDescricao.setLayout(painelDescricaoLayout);
        painelDescricaoLayout.setHorizontalGroup(
            painelDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        painelDescricaoLayout.setVerticalGroup(
            painelDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );

        bAlterar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bAlterar.setText("Alterar");
        bAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAlterarActionPerformed(evt);
            }
        });

        bExcluir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bExcluir.setText("Excluir");
        bExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExcluirActionPerformed(evt);
            }
        });

        bCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
                    .addComponent(painelDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bExcluir)
                        .addGap(132, 132, 132)
                        .addComponent(bCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfNome))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lDiária)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfDiaria))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lTaxaAtraso)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfTaxaAtraso))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lStatus)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfStatus))
                                    .addComponent(painelCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(painelImagens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(painelImagens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lTaxaAtraso)
                            .addComponent(tfTaxaAtraso))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lDiária)
                            .addComponent(tfDiaria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lStatus)
                            .addComponent(tfStatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(painelCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void img1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img1MouseReleased
        img = img1;
        realizarAcao(evt);
    }//GEN-LAST:event_img1MouseReleased

    private void img2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img2MouseReleased
        img = img2;
        realizarAcao(evt);
    }//GEN-LAST:event_img2MouseReleased

    private void img3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img3MouseReleased
        img = img3;
        realizarAcao(evt);
    }//GEN-LAST:event_img3MouseReleased

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        carregarProduto();
    }//GEN-LAST:event_formWindowGainedFocus

    private void bAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAlterarActionPerformed
        ProdutoAtualizarTela atualizarProduto = new ProdutoAtualizarTela(produto);
        atualizarProduto.setVisible(true);
    }//GEN-LAST:event_bAlterarActionPerformed

    private void bExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluirActionPerformed
        AluguelDAO aluguelDAO = new AluguelDAO();
        boolean produtoAlugado = aluguelDAO.isAlugado(produto);
        if (produtoAlugado) {
            JOptionPane.showMessageDialog(null, "Produto não pode ser excluido, pois esta sendo alugado no momento", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir o registro: " + produto.getNome() + "?", "Excluir Produto", JOptionPane.YES_NO_OPTION);
            if(resposta == JOptionPane.YES_OPTION){
                ProdutoDAO produtoDAO = new ProdutoDAO();
                produtoDAO.removeProduto(produto);
                JOptionPane.showMessageDialog(null, "Produto excluido com sucesso", "Produto Excluido", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        }
    }//GEN-LAST:event_bExcluirActionPerformed

    private void painelImagensMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelImagensMouseReleased
        img = null;
        mudarCorPaineis();
    }//GEN-LAST:event_painelImagensMouseReleased
    
    private void realizarAcao(MouseEvent evt) {
        if (evt.getButton() == MouseEvent.BUTTON1) {
            mudarCorPaineis();
        }
    }
    
    private void mudarCorPaineis(){
        imgPrincipal.removeAll();
        imgPrincipal.repaint();
        img1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        img3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        img2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        if (img != null) {
            if (img.getComponents().length > 0) {
                PainelModeloImagens newImage = new PainelModeloImagens();
                newImage.setBfImage(((PainelModeloImagens) img.getComponent(0)).getBfImage());
                imgPrincipal.add(newImage);
                imgPrincipal.revalidate();
                img.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true));
            }
        }
    }
    
    private void carregarProduto(){
        atualizarReferencia();
        carregarCampos();
        carregarCategorias();
        carregarImagens();
    }
    
    private void atualizarReferencia() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produto = produtoDAO.findProduto(produto.getCodigo(), JPAUtil.getEntityManager());
    }
    
    private void carregarCampos(){
        tfNome.setText(produto.getNome());
        tfTaxaAtraso.setText(produto.getTaxa() + "%");
        tfDiaria.setText("R$" + produto.getDiaria());
        taDescricao.setText(produto.getDescricao());
    }
    
    private void carregarCategorias(){
        ListaModeloCategorias modelo = new ListaModeloCategorias(produto.getCategorias());
        listaCategorias.setModel(modelo);
    }
    
    private void carregarImagens(){
        img1.removeAll();
        img2.removeAll();
        img3.removeAll();
        int cont = 1;
        for (ImagemProduto imagem: produto.getImagensProduto()) {
            PainelModeloImagens painelImg = carregarImagem(imagem);
            switch(cont){
                case 1: mostrarImagem(img1, painelImg);
                        break;
                case 2: mostrarImagem(img2, painelImg);
                        break;
                case 3: mostrarImagem(img3, painelImg);
                        break;
            }
            cont ++;
        }
        img = img1;
        if (img.getComponentCount() > 0) {
            mudarCorPaineis();
        }
    }
    
    private PainelModeloImagens carregarImagem(ImagemProduto imagem){
        BufferedImage imagemLocal;
        PainelModeloImagens painelRetorno;
        try {
            imagemLocal = ImageIO.read(new ByteArrayInputStream(imagem.getImagem()));
            painelRetorno = new PainelModeloImagens();
            painelRetorno.setBfImage(imagemLocal);
        } catch (IOException ex) {
            painelRetorno = null;
        }
        return painelRetorno;
    }
    
    private void mostrarImagem(JPanel painel, PainelModeloImagens imagemPainel){
        painel.add(imagemPainel);
        painel.revalidate();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAlterar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bExcluir;
    private javax.swing.JPanel img1;
    private javax.swing.JPanel img2;
    private javax.swing.JPanel img3;
    private javax.swing.JPanel imgPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lDiária;
    private javax.swing.JLabel lNome;
    private javax.swing.JLabel lStatus;
    private javax.swing.JLabel lTaxaAtraso;
    private javax.swing.JList listaCategorias;
    private javax.swing.JPanel painelCategorias;
    private javax.swing.JPanel painelDescricao;
    private javax.swing.JPanel painelImagens;
    private javax.swing.JTextArea taDescricao;
    private javax.swing.JLabel tfDiaria;
    private javax.swing.JLabel tfNome;
    private javax.swing.JLabel tfStatus;
    private javax.swing.JLabel tfTaxaAtraso;
    // End of variables declaration//GEN-END:variables
}
