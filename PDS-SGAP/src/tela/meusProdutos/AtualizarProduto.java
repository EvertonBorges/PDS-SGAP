/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.meusProdutos;

import dao.CategoriaDAO;
import dao.ProdutoDAO;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.Categoria;
import modelo.ImagemProduto;
import modelo.Produto;

/**
 *
 * @author Everton Soares
 */
public class AtualizarProduto extends javax.swing.JFrame {
    private List<Categoria> categoriasSelecionadas;
    private List<Categoria> categorias;
    private JPanel img;
    private Produto produto;
    
    /**
     * Creates new form CadastrarProduto
     * @param produto
     */
    public AtualizarProduto(Produto produto) {
        this.produto = produto;
        initComponents();
        carregarImagens();
        carregarCategorias();
        carregarSelecionados();
        carregarListCategorias();
        carregarCampos();
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
        miAddImagem = new javax.swing.JMenuItem();
        miRemoverImagem = new javax.swing.JMenuItem();
        lNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        lQtde = new javax.swing.JLabel();
        spQtde = new javax.swing.JSpinner();
        lDiaria = new javax.swing.JLabel();
        tfDiaria = new javax.swing.JTextField();
        lTaxa = new javax.swing.JLabel();
        tfTaxa = new javax.swing.JTextField();
        painelCategorias = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listCategorias = new javax.swing.JList();
        bAddCategoria = new javax.swing.JButton();
        painelImagens = new javax.swing.JPanel();
        imgPrincipal = new javax.swing.JPanel();
        img1 = new javax.swing.JPanel();
        img2 = new javax.swing.JPanel();
        img3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        bAtualizar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        painelDescricao = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();

        miAddImagem.setText("Adicionar Imagem");
        miAddImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddImagemActionPerformed(evt);
            }
        });
        menuFlutuante.add(miAddImagem);

        miRemoverImagem.setText("Remover Imagem");
        miRemoverImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRemoverImagemActionPerformed(evt);
            }
        });
        menuFlutuante.add(miRemoverImagem);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atualizar Produto");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        lNome.setText("Nome");

        lQtde.setText("Quantidade");

        spQtde.setModel(new javax.swing.SpinnerNumberModel(1, 1, 30, 1));

        lDiaria.setText("Diária");

        tfDiaria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDiariaFocusLost(evt);
            }
        });

        lTaxa.setText("Taxa por atraso");

        tfTaxa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfTaxaFocusLost(evt);
            }
        });

        painelCategorias.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Categorias", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jScrollPane1.setViewportView(listCategorias);

        bAddCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh-icon.png"))); // NOI18N
        bAddCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelCategoriasLayout = new javax.swing.GroupLayout(painelCategorias);
        painelCategorias.setLayout(painelCategoriasLayout);
        painelCategoriasLayout.setHorizontalGroup(
            painelCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCategoriasLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bAddCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelCategoriasLayout.setVerticalGroup(
            painelCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
            .addGroup(painelCategoriasLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(bAddCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelImagens.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Imagens", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        imgPrincipal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true));
        imgPrincipal.setLayout(new java.awt.BorderLayout());

        img1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        img1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                img1MouseReleased(evt);
            }
        });
        img1.setLayout(new java.awt.BorderLayout());

        img2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
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
            .addGroup(painelImagensLayout.createSequentialGroup()
                .addComponent(imgPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelImagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(img1, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(img2, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(img3, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelImagensLayout.setVerticalGroup(
            painelImagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelImagensLayout.createSequentialGroup()
                .addGroup(painelImagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelImagensLayout.createSequentialGroup()
                        .addComponent(img1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bAtualizar.setText("Atualizar");
        bAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtualizarActionPerformed(evt);
            }
        });

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        painelDescricao.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Descrição", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        taDescricao.setColumns(20);
        taDescricao.setRows(5);
        jScrollPane2.setViewportView(taDescricao);

        javax.swing.GroupLayout painelDescricaoLayout = new javax.swing.GroupLayout(painelDescricao);
        painelDescricao.setLayout(painelDescricaoLayout);
        painelDescricaoLayout.setHorizontalGroup(
            painelDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDescricaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        painelDescricaoLayout.setVerticalGroup(
            painelDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDescricaoLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNome))
                    .addComponent(painelDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(painelCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lTaxa)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfTaxa))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfDiaria))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lQtde)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(spQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelImagens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(bAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bCancelar)
                        .addGap(32, 32, 32)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNome)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lQtde)
                            .addComponent(spQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lDiaria)
                            .addComponent(tfDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lTaxa)
                            .addComponent(tfTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(painelImagens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAtualizar)
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

    private void miAddImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAddImagemActionPerformed
        addImagem();
    }//GEN-LAST:event_miAddImagemActionPerformed

    private void miRemoverImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRemoverImagemActionPerformed
        removerImagem();
    }//GEN-LAST:event_miRemoverImagemActionPerformed

    private void tfDiariaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDiariaFocusLost
        if (!tfDiaria.getText().startsWith("R$")) {
            tfDiaria.setText("R$" + tfDiaria.getText());
        }
    }//GEN-LAST:event_tfDiariaFocusLost

    private void tfTaxaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfTaxaFocusLost
        if (!tfTaxa.getText().endsWith("%")) {
            tfTaxa.setText(tfTaxa.getText() + "%");
        }
    }//GEN-LAST:event_tfTaxaFocusLost

    private void bAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtualizarActionPerformed
        atualizarProduto();
        dispose();
    }//GEN-LAST:event_bAtualizarActionPerformed

    private void bAddCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddCategoriaActionPerformed
        AdicionarCategorias adicionarCategorias = new AdicionarCategorias(categoriasSelecionadas, categorias);
        adicionarCategorias.setVisible(true);
    }//GEN-LAST:event_bAddCategoriaActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        carregarListCategorias();
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void carregarCategorias(){
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        categorias = categoriaDAO.allCategorias();
    }
    
    private void carregarSelecionados(){
        categoriasSelecionadas = new ArrayList<>();
        for (Categoria categoria1: categorias) {
            for (Categoria categoria2: produto.getCategorias()){
                if (Objects.equals(categoria1.getCodigo(), categoria2.getCodigo())){
                    categoriasSelecionadas.add(categoria1);
                }
            }
        }
    }
    
    private void carregarListCategorias(){
        ListaCategorias modelo = new ListaCategorias(categoriasSelecionadas);
        listCategorias.setModel(modelo);
    }
    
    private void carregarCampos(){
        tfNome.setText(produto.getNome());
        spQtde.setValue(produto.getQuantidade());
        tfTaxa.setText(produto.getTaxa() + "%");
        tfDiaria.setText("R$" + produto.getDiaria());
        taDescricao.setText(produto.getDescricao());
    }
    
    private void carregarImagens(){
        int cont = 1;
        for (ImagemProduto imagem: produto.getImagensProduto()) {
            PainelImagens painelImg = carregarImagem(imagem);
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
    }
    
    private PainelImagens carregarImagem(ImagemProduto imagem){
        BufferedImage img = null;
        PainelImagens painelRetorno = null;
        try {
            img = ImageIO.read(new ByteArrayInputStream(imagem.getImagem()));
            painelRetorno = new PainelImagens();
            painelRetorno.setBfImage(img);
        } catch (IOException ex) {
            painelRetorno = null;
        }
        return painelRetorno;
    }
    
    private void mostrarImagem(JPanel painel, PainelImagens imagemPainel){
        painel.add(imagemPainel);
        painel.revalidate();
    }
    
    private void realizarAcao(MouseEvent evt) {
        if (evt.getButton() == MouseEvent.BUTTON1) {
            mudarCorPaineis();
            if (evt.getClickCount() > 1){
                addImagem();
            }
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            mudarCorPaineis();
            menuFlutuante.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }
    
    private void mudarCorPaineis(){
        imgPrincipal.removeAll();
        imgPrincipal.repaint();
        img1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        img3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        img2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        if (img.getComponents().length > 0) {
            PainelImagens newImage = new PainelImagens();
            newImage.setBfImage(((PainelImagens) img.getComponent(0)).getBfImage());
            imgPrincipal.add(newImage);
            imgPrincipal.revalidate();
            img.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true));
        }
    }
    
    private void addImagem(){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, JPEG, GIF & PNG", "jpg", "gif", "jpeg", "png");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            PainelImagens newImagem = new PainelImagens();
            newImagem.setBfImage(chooser.getSelectedFile().getPath());
            if ( (newImagem.getBfImage().getWidth() + newImagem.getBfImage().getHeight()) > 2000) {
                JOptionPane.showMessageDialog(null, "Imagem deve possuir resolução igual ou inferior a 1000x1000 pixels", "Imagem Grande", JOptionPane.INFORMATION_MESSAGE);
            } else {
                carregarImagem(newImagem);
            }
        }
    }
    
    private void removerImagem(){
        img.removeAll();
        img.setName("");
        mudarCorPaineis();
        img.repaint();
    }
    
    private void carregarImagem(PainelImagens newPainel){
        img.removeAll();
        img.repaint();
        mudarCorPaineis();
        img.add(newPainel);
        img.revalidate();
    }
    
    private byte[] arrayImage(JPanel img){
        BufferedImage imagem;
        ByteArrayOutputStream bytesImg = new ByteArrayOutputStream();
        byte[] byteArray = null;
        try {
            if ((img.getComponentCount()) > 0){
                imagem = ((PainelImagens) img.getComponent(0)).getBfImage();
                ImageIO.write(imagem, "jpg", bytesImg);
                bytesImg.flush();
                byteArray = bytesImg.toByteArray();
                bytesImg.close();
            }
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        return byteArray;
    } 
    
    private void atualizarProduto(){
        byte[] byteArray1 = arrayImage(img1);
        byte[] byteArray2 = arrayImage(img2);
        byte[] byteArray3 = arrayImage(img3);
        
        produto.setNome(tfNome.getText());
        produto.setQuantidade(Integer.parseInt(spQtde.getValue().toString()));
        produto.setDescricao(taDescricao.getText());
        produto.setCategorias(categoriasSelecionadas);
        produto.setDiaria(Double.parseDouble(tfDiaria.getText().substring(2)));
        produto.setTaxa(Integer.parseInt(tfTaxa.getText().substring(0, tfTaxa.getText().length() - 1)));
        
        List<ImagemProduto> imagens = new ArrayList<>();
        
        if (byteArray1 != null){
            persistindoImagens(byteArray1, produto, imagens);
        }
        if (byteArray2 != null){
            persistindoImagens(byteArray2, produto, imagens);
        }
        if (byteArray3 != null){
            persistindoImagens(byteArray3, produto, imagens);
        }
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.alterProduto(produto, imagens);
    }
    
    private void persistindoImagens(byte[] byteArray, Produto produto, List<ImagemProduto> imagens){
        if (byteArray != null){
            ImagemProduto imagem = new ImagemProduto(byteArray, produto);
            imagens.add(imagem);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAddCategoria;
    private javax.swing.JButton bAtualizar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JPanel img1;
    private javax.swing.JPanel img2;
    private javax.swing.JPanel img3;
    private javax.swing.JPanel imgPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lDiaria;
    private javax.swing.JLabel lNome;
    private javax.swing.JLabel lQtde;
    private javax.swing.JLabel lTaxa;
    private javax.swing.JList listCategorias;
    private javax.swing.JPopupMenu menuFlutuante;
    private javax.swing.JMenuItem miAddImagem;
    private javax.swing.JMenuItem miRemoverImagem;
    private javax.swing.JPanel painelCategorias;
    private javax.swing.JPanel painelDescricao;
    private javax.swing.JPanel painelImagens;
    private javax.swing.JSpinner spQtde;
    private javax.swing.JTextArea taDescricao;
    private javax.swing.JTextField tfDiaria;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfTaxa;
    // End of variables declaration//GEN-END:variables
}