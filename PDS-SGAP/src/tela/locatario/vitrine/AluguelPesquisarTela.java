package tela.locatario.vitrine;

import dao.CategoriaDAO;
import modelo.lista.ListaModeloCategorias;
import modelo.tabela.TabelaModeloProdutosDisponiveisRenderer;
import modelo.tabela.TabelaModeloProdutosDisponiveis;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import modelo.Produto;
import dao.ProdutoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import modelo.Categoria;
import modelo.Condomino;

public class AluguelPesquisarTela extends javax.swing.JFrame {
    private List<Produto> produtos;
    private Categoria categoria;
    private List<Categoria> categorias;
    private Produto produto;
    private final Condomino condomino;
    
    public AluguelPesquisarTela(Condomino condomino) {
        initComponents();
        this.condomino = condomino;
      
        preencherCategoria(); 
        carregarMenuFlutuante();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        mPopup = new javax.swing.JPopupMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProduto = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jlCategoria = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        bPesquisar = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisar Produtos");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Categorias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jlCategoria.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jlCategoria.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlCategoriaMouseMoved(evt);
            }
        });
        jlCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlCategoriaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jlCategoria);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel1.setText("Nome");

        bPesquisar.setText("Pesquisar");
        bPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfNome, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bPesquisar)
                        .addGap(61, 61, 61))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(bPesquisar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        pesquisar();    
        preencherTabela();
    }//GEN-LAST:event_formWindowGainedFocus

    private void bPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPesquisarActionPerformed
        pesquisar();
        preencherTabela();
    }//GEN-LAST:event_bPesquisarActionPerformed

    private void tbProdutoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProdutoMouseReleased
        selecionarProduto(evt);
    }//GEN-LAST:event_tbProdutoMouseReleased

    private void jlCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCategoriaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlCategoriaMouseClicked

    private void jlCategoriaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCategoriaMouseMoved
        carregarTollTipTextLista(evt);
    }//GEN-LAST:event_jlCategoriaMouseMoved
   
    private void preencherTabelaByCategoria(Categoria categoria){
        ProdutoDAO produtoDAO = new ProdutoDAO();
        this.produtos = produtoDAO.findProduto(categoria);
        preencherTabela();
    }
    
    private void preencherCategoria(){
        CategoriaDAO cDAO = new CategoriaDAO();
        this.categorias = cDAO.allCategorias();
        jlCategoria.setModel(new ListaModeloCategorias(this.categorias, true));
        jlCategoria.addMouseListener( new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                int index = jlCategoria.locationToIndex(e.getPoint());
                
                if(jlCategoria.getModel().getElementAt(index).equals("TODOS")){
                    pesquisar();
                    preencherTabela();
                }
                else {
                    categoria = (Categoria)jlCategoria.getModel().getElementAt(index);
                    preencherTabelaByCategoria(categoria);
                }
            }
        });
    }
           
    private void selecionarProduto(MouseEvent evt) {
        int linha = tbProduto.rowAtPoint(evt.getPoint());
        int coluna = tbProduto.columnAtPoint(evt.getPoint());

        if (linha >= 0 ) {
            tbProduto.getSelectionModel().setSelectionMode( ListSelectionModel.SINGLE_SELECTION);  
            tbProduto.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
            tbProduto.setCellSelectionEnabled(true);
            
            int indice=((linha)*4)+coluna;
            
            if (indice<this.produtos.size()){
                this.produto = this.produtos.get(indice);
                realizarAcao(evt);
            }
        }
    }
    
    private void carregarMenuFlutuante(){
        JMenuItem[] itens = {new JMenuItem("Detalhes do produto"), new JMenuItem("Solicitar aluguel")};
        
        itens[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaConsultar();
            }
        });
        
        itens[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaSolicitarAluguel();
            }
        });
        
        for (JMenuItem item : itens) {
            mPopup.add(item);
        }
    }
        
    private void realizarAcao(MouseEvent evt) {
        if (evt.getButton() == MouseEvent.BUTTON1) {
            if (evt.getClickCount() > 1) { 
                telaConsultar();
            }
        } else if (evt.getButton() == MouseEvent.BUTTON3) { 
            mPopup.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }
    
    private void telaConsultar(){
        AluguelDetalhesTela telaConsultar= new AluguelDetalhesTela(this.produto, this.condomino);
        telaConsultar.setVisible(true);
    }
    
    private void telaSolicitarAluguel(){
        AluguelSolicitarTela telaSolicitarAluguel= new AluguelSolicitarTela(this.produto, this.condomino);
        telaSolicitarAluguel.setVisible(true);
    }
        
    private void preencherTabela() {
        tbProduto.setDefaultRenderer(JPanel.class, new TabelaModeloProdutosDisponiveisRenderer(this.produtos));
        tbProduto.setModel(new TabelaModeloProdutosDisponiveis(this.produtos));
        tbProduto.setRowHeight(180); 
    }
    
    private void pesquisar() {
        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            produto = new Produto();
            this.produto.setNome(tfNome.getText());
            this.produtos = produtoDAO.findProdutosDisponiveis(this.produto);
        } catch (Exception ex) {
            System.out.println("Erro ao pesquisar:" + ex.getCause()+ "\n  "+ ex.getMessage());
        }
    }
    
    private void carregarTollTipTextLista(MouseEvent evt){
        int linha = jlCategoria.locationToIndex(evt.getPoint());
        if (linha >= 0) {
            if (linha != categorias.size()) {
                Categoria categoriaLocal = categorias.get(linha);
                jlCategoria.setToolTipText(categoriaLocal.getDescricao());
            } else {
                jlCategoria.setToolTipText("TODOS");
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList jlCategoria;
    private javax.swing.JPopupMenu mPopup;
    private javax.swing.JTable tbProduto;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}
