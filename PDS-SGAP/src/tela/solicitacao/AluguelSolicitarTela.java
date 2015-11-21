package tela.solicitacao;

import dao.ProdutoDAO;
import dao.SolicitacaoAluguelDAO;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import modelo.Comentario;
import modelo.Condomino;
import modelo.ImagemProduto;
import modelo.Produto;
import modelo.SolicitacaoAluguel;
import modelo.painel.PainelModeloImagens;

public class AluguelSolicitarTela extends javax.swing.JFrame {

    /**
     * Creates new form ConsultarProdutoTela
     */
    
    private Produto produto = new Produto();
    private ProdutoDAO dao = new ProdutoDAO();
    private List<Comentario> lista = new ArrayList<>();
    private DefaultListModel listaModel = new DefaultListModel();  
    private Condomino condomino;
    private SolicitacaoAluguel solicitacaoAluguel;
    private SolicitacaoAluguelDAO sDAO;
    private JPanel img;


    public AluguelSolicitarTela(Produto produto, Condomino condomino) {
        this.produto=produto;
        this.condomino=condomino;
        initComponents();
        carregarProduto();
        //preencherComentarios();
    }
    
    public void preencherCampos(){
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        
        tfDono.setText(this.produto.getCondomino().toString());
        tfProduto.setText(this.produto.getNome());
        tfDescricao.setText(this.produto.getDescricao());
        tfContato.setText(produto.getCondomino().getTelefones().get(0));
        tfDiaria.setText("R$"+produto.getDiaria());
        tfTaxa.setText(produto.getTaxa()+"%");
        tfDataInicio.setText(formatador.format(Calendar.getInstance().getTime()));
        
        SpinnerNumberModel spModelDias = new SpinnerNumberModel(31, 1, 31, 1);
        spDias.setModel(spModelDias);
        tfReputacao.setText("calcular reputação");
        img = img1;
        mudarCorPaineis();
    }
    
    private void realizarAcao(MouseEvent evt) {
        if (evt.getButton() == MouseEvent.BUTTON1) {
            mudarCorPaineis();
        }
    }
    public void telaAlugarProduto (){
        AluguelSolicitarTela telaAlugarProduto =  new AluguelSolicitarTela(this.produto, this.condomino);
        telaAlugarProduto.setVisible(true);
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
        carregarImagens();
        preencherCampos();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bAlugar = new javax.swing.JToggleButton();
        jSeparator2 = new javax.swing.JSeparator();
        bCancelar = new javax.swing.JButton();
        tfDescricao2 = new javax.swing.JLabel();
        tfDiaria = new javax.swing.JLabel();
        tfTaxa = new javax.swing.JLabel();
        tfDescricao5 = new javax.swing.JLabel();
        tfDescricao6 = new javax.swing.JLabel();
        spDias = new javax.swing.JSpinner();
        lNome3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        tfDescricao = new javax.swing.JLabel();
        tfProduto = new javax.swing.JLabel();
        painelImagens = new javax.swing.JPanel();
        imgPrincipal = new javax.swing.JPanel();
        img1 = new javax.swing.JPanel();
        img2 = new javax.swing.JPanel();
        img3 = new javax.swing.JPanel();
        tfDataInicio = new javax.swing.JFormattedTextField();
        lNome7 = new javax.swing.JLabel();
        tfContato = new javax.swing.JLabel();
        lNome6 = new javax.swing.JLabel();
        tfDono = new javax.swing.JLabel();
        lNome4 = new javax.swing.JLabel();
        tfReputacao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Solicitar Aluguel");

        bAlugar.setText("Solicitar Alugel");
        bAlugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAlugarActionPerformed(evt);
            }
        });

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        tfDescricao2.setText("Diária:");

        tfDiaria.setText("diaria");

        tfTaxa.setText("taxa");

        tfDescricao5.setText("Taxa por dia de atraso:");

        tfDescricao6.setText("Data Início:");

        spDias.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                spDiasFocusLost(evt);
            }
        });

        lNome3.setText("Dias Pretendidos:");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel4.setToolTipText("");

        tfDescricao.setText("descricao");

        tfProduto.setText("NOME DO PRODUTO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfProduto)
                    .addComponent(tfDescricao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfProduto)
                .addGap(7, 7, 7)
                .addComponent(tfDescricao)
                .addContainerGap())
        );

        painelImagens.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Imagens", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        try {
            tfDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDataInicio.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tfDataInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDataInicioActionPerformed(evt);
            }
        });

        lNome7.setText("Contato:");

        tfContato.setText("contato");

        lNome6.setText("Dono:");

        tfDono.setText("DONO PRODUTO");

        lNome4.setText("Reputação:");

        tfReputacao.setText("calcular reptação");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(bAlugar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bCancelar)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfDescricao2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfDiaria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfDescricao5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfTaxa)
                                .addGap(37, 37, 37)
                                .addComponent(tfDescricao6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lNome3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(spDias, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lNome6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfDono, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lNome7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfContato, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lNome4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfReputacao, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(painelImagens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDescricao2)
                    .addComponent(tfDiaria)
                    .addComponent(tfDescricao5)
                    .addComponent(tfTaxa)
                    .addComponent(tfDescricao6)
                    .addComponent(tfDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spDias, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lNome3))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfDono)
                            .addComponent(lNome6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfContato)
                            .addComponent(lNome7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfReputacao)
                            .addComponent(lNome4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(painelImagens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAlugar)
                    .addComponent(bCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bAlugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAlugarActionPerformed
        // TODO add your handling code here:
        criarSolicitacao();
    }//GEN-LAST:event_bAlugarActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        // TODO add your handling code here:
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

    private void painelImagensMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelImagensMouseReleased
        img = null;
        mudarCorPaineis();
    }//GEN-LAST:event_painelImagensMouseReleased

    private void tfDataInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDataInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDataInicioActionPerformed

    private void spDiasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_spDiasFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_spDiasFocusLost
    
    private Calendar dateToCalendar(String data) throws ParseException {
        DateFormat formatador = DateFormat.getDateInstance();
        Date date = formatador.parse(data);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar;
    }
    
    public void preencherSolicitacao(){
        this.solicitacaoAluguel= new SolicitacaoAluguel();
        try{
            this.solicitacaoAluguel.setDataInicioAluguel(dateToCalendar(tfDataInicio.getText()));
        } 
        catch (ParseException ex) {
            System.out.println("Erro ao preencher solicitação(erro na data): "+ex.getMessage());
        }
        this.solicitacaoAluguel.setDataSolicitacao(Calendar.getInstance());
        this.solicitacaoAluguel.setLocatario(this.condomino);
        this.solicitacaoAluguel.setDiasPretendidos(Integer.parseInt(spDias.getValue().toString()));
        this.solicitacaoAluguel.setProduto(this.produto);
    }
    
    public void criarSolicitacao(){
        preencherSolicitacao();
        sDAO = new SolicitacaoAluguelDAO();
        sDAO.addSolicitacao(this.solicitacaoAluguel);
        JOptionPane.showMessageDialog(null, "Solicitação realizada com sucesso", "Confirmacao ", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AluguelSolicitarTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AluguelSolicitarTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AluguelSolicitarTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AluguelSolicitarTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new ConsultarProdutoTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton bAlugar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JPanel img1;
    private javax.swing.JPanel img2;
    private javax.swing.JPanel img3;
    private javax.swing.JPanel imgPrincipal;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lNome3;
    private javax.swing.JLabel lNome4;
    private javax.swing.JLabel lNome6;
    private javax.swing.JLabel lNome7;
    private javax.swing.JPanel painelImagens;
    private javax.swing.JSpinner spDias;
    private javax.swing.JLabel tfContato;
    private javax.swing.JFormattedTextField tfDataInicio;
    private javax.swing.JLabel tfDescricao;
    private javax.swing.JLabel tfDescricao2;
    private javax.swing.JLabel tfDescricao5;
    private javax.swing.JLabel tfDescricao6;
    private javax.swing.JLabel tfDiaria;
    private javax.swing.JLabel tfDono;
    private javax.swing.JLabel tfProduto;
    private javax.swing.JLabel tfReputacao;
    private javax.swing.JLabel tfTaxa;
    // End of variables declaration//GEN-END:variables
}