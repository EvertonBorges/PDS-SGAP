package tela.locatario.minhassolicitacoes.aluguelconcluido;

import dao.ComentarioDAO;
import java.util.Calendar;
import javax.swing.JOptionPane;
import modelo.Aluguel;
import modelo.Avaliacao;
import modelo.Comentario;

public class ComentarioAdicionarTela extends javax.swing.JFrame {
    private final Aluguel aluguel;
    
    
    public ComentarioAdicionarTela(Aluguel aluguel) {
        this.aluguel = aluguel;
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

        grupoRadio = new javax.swing.ButtonGroup();
        jSeparator1 = new javax.swing.JSeparator();
        bCadastrar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        painelDescricao = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taComentario = new javax.swing.JTextArea();
        painelRequerente = new javax.swing.JPanel();
        rbPositiva = new javax.swing.JRadioButton();
        rbNeutra = new javax.swing.JRadioButton();
        rbNegativa = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar Comentario");
        setResizable(false);

        bCadastrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bCadastrar.setText("Salvar");
        bCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadastrarActionPerformed(evt);
            }
        });

        bCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        painelDescricao.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Comentário", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        taComentario.setColumns(20);
        taComentario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        taComentario.setRows(5);
        jScrollPane2.setViewportView(taComentario);

        javax.swing.GroupLayout painelDescricaoLayout = new javax.swing.GroupLayout(painelDescricao);
        painelDescricao.setLayout(painelDescricaoLayout);
        painelDescricaoLayout.setHorizontalGroup(
            painelDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDescricaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelDescricaoLayout.setVerticalGroup(
            painelDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDescricaoLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        painelRequerente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Avaliação", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        grupoRadio.add(rbPositiva);
        rbPositiva.setText("Positiva");

        grupoRadio.add(rbNeutra);
        rbNeutra.setText("Neutra");

        grupoRadio.add(rbNegativa);
        rbNegativa.setText("Negativa");

        javax.swing.GroupLayout painelRequerenteLayout = new javax.swing.GroupLayout(painelRequerente);
        painelRequerente.setLayout(painelRequerenteLayout);
        painelRequerenteLayout.setHorizontalGroup(
            painelRequerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRequerenteLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(rbPositiva)
                .addGap(106, 106, 106)
                .addComponent(rbNeutra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbNegativa)
                .addGap(17, 17, 17))
        );
        painelRequerenteLayout.setVerticalGroup(
            painelRequerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRequerenteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelRequerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbPositiva)
                    .addComponent(rbNeutra)
                    .addComponent(rbNegativa))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(bCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bCancelar)
                        .addGap(32, 32, 32))
                    .addComponent(painelRequerente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelRequerente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastrarActionPerformed
        adicionarComentario();
    }//GEN-LAST:event_bCadastrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCadastrar;
    private javax.swing.JButton bCancelar;
    private javax.swing.ButtonGroup grupoRadio;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel painelDescricao;
    private javax.swing.JPanel painelRequerente;
    private javax.swing.JRadioButton rbNegativa;
    private javax.swing.JRadioButton rbNeutra;
    private javax.swing.JRadioButton rbPositiva;
    private javax.swing.JTextArea taComentario;
    // End of variables declaration//GEN-END:variables

    private void adicionarComentario() {
        Comentario comentario =  new Comentario();
        comentario.setAluguel(aluguel);
        comentario.setDataComentario(Calendar.getInstance());
        comentario.setComentario(taComentario.getText());
        
        if(rbPositiva.isSelected()){
            comentario.setAvaliacao(Avaliacao.POSITIVA);
        } else {
            if(rbNeutra.isSelected()){
                comentario.setAvaliacao(Avaliacao.NEUTRA);
            } else {
                comentario.setAvaliacao(Avaliacao.NEGATIVA);
            }
        }
        
        ComentarioDAO dao = new ComentarioDAO();
        dao.addComentario(comentario);
        
        JOptionPane.showMessageDialog(null, "Comentario adicionado");
        
        dispose();
        
    }
}