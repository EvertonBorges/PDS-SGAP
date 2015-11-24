package tela;

import dao.CondominoDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Condomino;
import modelo.TipoUsuario;
import modelo.painel.PainelModeloImagens;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import tela.locatario.vitrine.AluguelPesquisarTela;
import tela.admin.apartamento.ApartamentoPesquisarTela;
import tela.admin.categoria.CategoriaPesquisarTela;
import tela.admin.condomino.CondominoPesquisarTela;
import tela.locador.meusprodutos.ProdutoPesquisarTela;
import tela.locador.aluguel.SolicitacaoPesquisarTela;
import tela.locador.produtosalugados.ProdutoAlugadoPesquisarTela;
import tela.locatario.minhassolicitacoes.aluguelconcluido.AluguelConcluidoPesquisarTela;
import tela.locatario.minhassolicitacoes.aluguelemandamento.AluguelAndamentoPesquisarTela;
import tela.locatario.minhassolicitacoes.solicitacaoaguardaconfirmacao.SolicitacaoAvaliacaoPesquisarTela;
import tela.locatario.minhassolicitacoes.alugueisConfirmados.MinhasSolicitacoesConfirmadasPesquisarTela;
import tela.locatario.minhassolicitacoes.emavaliacao.MinhasSolicitacoesEmAvaliacaoPesquisarTela;
import tela.locatario.minhassolicitacoes.expiradas.MinhasSolicitacoesExpiradasPesquisarTela;
import tela.locatario.minhassolicitacoes.todas.MinhasSolicitacoesPesquisarTela;
import tela.admin.relatorios.Inadimplentes;
import tela.admin.relatorios.MaisAlugados;
import tela.admin.relatorios.MaisSolicitados;
import util.ControlaConexaoJasper;

public class Principal extends javax.swing.JFrame {
    private Condomino condomino;
    /**
     * Creates new form Principal
     * @param condomino
     */
    public Principal(Condomino condomino) {
        initComponents();
        this.condomino = condomino;
        menuCadastro.setVisible(false);
        menuRelatorios.setVisible(false);
        miAguardandoConfirmacao.setVisible(false);
        carregarBackground();
        verificaUsuario();
    }

    private void verificaUsuario(){
        if(this.condomino.getTipoUsuario() == TipoUsuario.ADMIN){
            menuCadastro.setVisible(true);
            menuRelatorios.setVisible(true);
        }
    }
    
    private void carregarBackground(){
        painelBackground.removeAll();
        PainelModeloImagens modelo = new PainelModeloImagens();
        modelo.setBfImage("src/icon/principal.jpg");
        painelBackground.add(modelo);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        painelBackground = new javax.swing.JPanel();
        mbMenu = new javax.swing.JMenuBar();
        menuAcesso = new javax.swing.JMenu();
        miSair = new javax.swing.JMenuItem();
        menuProdutos = new javax.swing.JMenu();
        miPesquisarProdutos = new javax.swing.JMenuItem();
        miSolicitacoesProdutos = new javax.swing.JMenuItem();
        miAlugados = new javax.swing.JMenuItem();
        menuAluguel = new javax.swing.JMenu();
        miPesquisarAluguel = new javax.swing.JMenuItem();
        menuMinhasSolicitacoes = new javax.swing.JMenu();
        miTodas = new javax.swing.JMenuItem();
        miConfirmadas = new javax.swing.JMenuItem();
        miEmAvaliacao = new javax.swing.JMenuItem();
        miExpiradas = new javax.swing.JMenuItem();
        miConcluido = new javax.swing.JMenuItem();
        miAguardandoConfirmacao = new javax.swing.JMenuItem();
        miEmAndamento = new javax.swing.JMenuItem();
        menuCadastro = new javax.swing.JMenu();
        miApartamento = new javax.swing.JMenuItem();
        miCategoria = new javax.swing.JMenuItem();
        miCondomino = new javax.swing.JMenuItem();
        menuRelatorios = new javax.swing.JMenu();
        miProdutosMaisAlugados = new javax.swing.JMenuItem();
        miProdutosMaisSolicitados = new javax.swing.JMenuItem();
        miInadimplentes = new javax.swing.JMenuItem();
        miAlugueisAndamento = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SGAP - Sistema de Gerenciamento de Aluguel de Produtos");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        painelBackground.setLayout(new java.awt.BorderLayout());

        menuAcesso.setText("Acesso");

        miSair.setText("Sair");
        miSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSairActionPerformed(evt);
            }
        });
        menuAcesso.add(miSair);

        mbMenu.add(menuAcesso);

        menuProdutos.setText("Meus Produtos");

        miPesquisarProdutos.setText("Pesquisar");
        miPesquisarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPesquisarProdutosActionPerformed(evt);
            }
        });
        menuProdutos.add(miPesquisarProdutos);

        miSolicitacoesProdutos.setText("Solicitações");
        miSolicitacoesProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSolicitacoesProdutosActionPerformed(evt);
            }
        });
        menuProdutos.add(miSolicitacoesProdutos);

        miAlugados.setText("Alugados");
        miAlugados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAlugadosActionPerformed(evt);
            }
        });
        menuProdutos.add(miAlugados);

        mbMenu.add(menuProdutos);

        menuAluguel.setText("Aluguel");

        miPesquisarAluguel.setText("Pesquisar Produto");
        miPesquisarAluguel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPesquisarAluguelActionPerformed(evt);
            }
        });
        menuAluguel.add(miPesquisarAluguel);

        menuMinhasSolicitacoes.setText("Minhas Solicitações");

        miTodas.setText("Todas");
        miTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTodasActionPerformed(evt);
            }
        });
        menuMinhasSolicitacoes.add(miTodas);

        miConfirmadas.setText("Alugueis");
        miConfirmadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConfirmadasActionPerformed(evt);
            }
        });
        menuMinhasSolicitacoes.add(miConfirmadas);

        miEmAvaliacao.setText("Em avaliação");
        miEmAvaliacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEmAvaliacaoActionPerformed(evt);
            }
        });
        menuMinhasSolicitacoes.add(miEmAvaliacao);

        miExpiradas.setText("Expiradas");
        miExpiradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExpiradasActionPerformed(evt);
            }
        });
        menuMinhasSolicitacoes.add(miExpiradas);

        miConcluido.setText("Concluído");
        miConcluido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConcluidoActionPerformed(evt);
            }
        });
        menuMinhasSolicitacoes.add(miConcluido);

        miAguardandoConfirmacao.setText("Aguardando Confirmação");
        miAguardandoConfirmacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAguardandoConfirmacaoActionPerformed(evt);
            }
        });
        menuMinhasSolicitacoes.add(miAguardandoConfirmacao);

        miEmAndamento.setText("Em Andamento");
        miEmAndamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEmAndamentoActionPerformed(evt);
            }
        });
        menuMinhasSolicitacoes.add(miEmAndamento);

        menuAluguel.add(menuMinhasSolicitacoes);

        mbMenu.add(menuAluguel);

        menuCadastro.setText("Cadastrar");

        miApartamento.setText("Apartamento");
        miApartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miApartamentoActionPerformed(evt);
            }
        });
        menuCadastro.add(miApartamento);

        miCategoria.setText("Categoria");
        miCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCategoriaActionPerformed(evt);
            }
        });
        menuCadastro.add(miCategoria);

        miCondomino.setText("Condômino");
        miCondomino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCondominoActionPerformed(evt);
            }
        });
        menuCadastro.add(miCondomino);

        mbMenu.add(menuCadastro);

        menuRelatorios.setText("Relatórios");

        miProdutosMaisAlugados.setText("Produtos mais alugados");
        miProdutosMaisAlugados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miProdutosMaisAlugadosActionPerformed(evt);
            }
        });
        menuRelatorios.add(miProdutosMaisAlugados);

        miProdutosMaisSolicitados.setText("Produtos mais solicitados");
        miProdutosMaisSolicitados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miProdutosMaisSolicitadosActionPerformed(evt);
            }
        });
        menuRelatorios.add(miProdutosMaisSolicitados);

        miInadimplentes.setText("Condominos inadimplentes");
        miInadimplentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miInadimplentesActionPerformed(evt);
            }
        });
        menuRelatorios.add(miInadimplentes);

        miAlugueisAndamento.setText("Alugueis em andamento");
        miAlugueisAndamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAlugueisAndamentoActionPerformed(evt);
            }
        });
        menuRelatorios.add(miAlugueisAndamento);

        mbMenu.add(menuRelatorios);

        setJMenuBar(mbMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSairActionPerformed
        dispose();
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_miSairActionPerformed

    private void miPesquisarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPesquisarProdutosActionPerformed
        ProdutoPesquisarTela pesquisarProduto = new ProdutoPesquisarTela(condomino);
        pesquisarProduto.setVisible(true);
    }//GEN-LAST:event_miPesquisarProdutosActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        CondominoDAO condominoDAO = new CondominoDAO();
        condomino = condominoDAO.getCondominoById(condomino.getCodigo());
    }//GEN-LAST:event_formWindowGainedFocus

    private void miPesquisarAluguelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPesquisarAluguelActionPerformed
        AluguelPesquisarTela pesquisarAluguel = new AluguelPesquisarTela(this.condomino);
        pesquisarAluguel.setVisible(true);
    }//GEN-LAST:event_miPesquisarAluguelActionPerformed

    private void miApartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miApartamentoActionPerformed
        ApartamentoPesquisarTela apPesquisar = new ApartamentoPesquisarTela();
        apPesquisar.setVisible(true);
    }//GEN-LAST:event_miApartamentoActionPerformed

    private void miCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCategoriaActionPerformed
        CategoriaPesquisarTela catPesquisar = new CategoriaPesquisarTela();
        catPesquisar.setVisible(true);
    }//GEN-LAST:event_miCategoriaActionPerformed

    private void miCondominoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCondominoActionPerformed
        CondominoPesquisarTela pesCondomino = new CondominoPesquisarTela();
        pesCondomino.setVisible(true);
    }//GEN-LAST:event_miCondominoActionPerformed

    private void miSolicitacoesProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSolicitacoesProdutosActionPerformed
        SolicitacaoPesquisarTela solicitacaoPesquisarTela = new SolicitacaoPesquisarTela(condomino);
        solicitacaoPesquisarTela.setVisible(true);
    }//GEN-LAST:event_miSolicitacoesProdutosActionPerformed

    private void miEmAvaliacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEmAvaliacaoActionPerformed
        MinhasSolicitacoesEmAvaliacaoPesquisarTela emAvaliacaoPesquisarTela =  new MinhasSolicitacoesEmAvaliacaoPesquisarTela(condomino);
        emAvaliacaoPesquisarTela.setVisible(true);
    }//GEN-LAST:event_miEmAvaliacaoActionPerformed

    private void miTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTodasActionPerformed
        MinhasSolicitacoesPesquisarTela minhasSolicitacoes =  new MinhasSolicitacoesPesquisarTela(this.condomino);
        minhasSolicitacoes.setVisible(true);
    }//GEN-LAST:event_miTodasActionPerformed

    private void miConfirmadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConfirmadasActionPerformed
        // TODO add your handling code here:
        MinhasSolicitacoesConfirmadasPesquisarTela solicitacoesConfirmadasPesquisarTela = new MinhasSolicitacoesConfirmadasPesquisarTela(this.condomino);
        solicitacoesConfirmadasPesquisarTela.setVisible(true);
    }//GEN-LAST:event_miConfirmadasActionPerformed

    private void miExpiradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExpiradasActionPerformed
        MinhasSolicitacoesExpiradasPesquisarTela emAvaliacaoPesquisarTela =  new MinhasSolicitacoesExpiradasPesquisarTela(condomino);
        emAvaliacaoPesquisarTela.setVisible(true);
    }//GEN-LAST:event_miExpiradasActionPerformed

    private void miProdutosMaisAlugadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miProdutosMaisAlugadosActionPerformed
        MaisAlugados maisAlugados = new MaisAlugados();
        maisAlugados.setVisible(true);
    }//GEN-LAST:event_miProdutosMaisAlugadosActionPerformed

    private void miProdutosMaisSolicitadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miProdutosMaisSolicitadosActionPerformed
        MaisSolicitados maisSolicitados = new MaisSolicitados();
        maisSolicitados.setVisible(true);
    }//GEN-LAST:event_miProdutosMaisSolicitadosActionPerformed

    private void miInadimplentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miInadimplentesActionPerformed
        Inadimplentes inadimplentes = new Inadimplentes();
        inadimplentes.setVisible(true);
    }//GEN-LAST:event_miInadimplentesActionPerformed

    private void miAlugadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAlugadosActionPerformed
        ProdutoAlugadoPesquisarTela produtosAlugados = new ProdutoAlugadoPesquisarTela(this.condomino);
        produtosAlugados.setVisible(true);
    }//GEN-LAST:event_miAlugadosActionPerformed

    private void miEmAndamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEmAndamentoActionPerformed
        AluguelAndamentoPesquisarTela emAndamento = new AluguelAndamentoPesquisarTela(this.condomino);
        emAndamento.setVisible(true);
    }//GEN-LAST:event_miEmAndamentoActionPerformed

    private void miAguardandoConfirmacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAguardandoConfirmacaoActionPerformed
        SolicitacaoAvaliacaoPesquisarTela aguardaAvaliacao = new SolicitacaoAvaliacaoPesquisarTela(this.condomino);
        aguardaAvaliacao.setVisible(true);
    }//GEN-LAST:event_miAguardandoConfirmacaoActionPerformed

    private void miConcluidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConcluidoActionPerformed
        AluguelConcluidoPesquisarTela concluido = new AluguelConcluidoPesquisarTela(this.condomino);
        concluido.setVisible(true);
    }//GEN-LAST:event_miConcluidoActionPerformed

    private void miAlugueisAndamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAlugueisAndamentoActionPerformed
        try{
            gerarRelatorio();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatorio.", "Erro ", JOptionPane.INFORMATION_MESSAGE);
        }   
    }//GEN-LAST:event_miAlugueisAndamentoActionPerformed

    private void gerarRelatorio() throws SQLException, ClassNotFoundException {
      
        try {
            JasperPrint relatorio = JasperFillManager.fillReport("src/relatorios/AlugueisEmAndamento.jasper", null, ControlaConexaoJasper.getConexao());
            JasperViewer visualizador = new JasperViewer(relatorio, false);
            visualizador.setVisible(true);
        } catch (JRException ex) {
            System.out.println("Possível erro ao conectar ao banco, ou gerar JasperPrint:\n" + ex.getMessage());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar mbMenu;
    private javax.swing.JMenu menuAcesso;
    private javax.swing.JMenu menuAluguel;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuMinhasSolicitacoes;
    private javax.swing.JMenu menuProdutos;
    private javax.swing.JMenu menuRelatorios;
    private javax.swing.JMenuItem miAguardandoConfirmacao;
    private javax.swing.JMenuItem miAlugados;
    private javax.swing.JMenuItem miAlugueisAndamento;
    private javax.swing.JMenuItem miApartamento;
    private javax.swing.JMenuItem miCategoria;
    private javax.swing.JMenuItem miConcluido;
    private javax.swing.JMenuItem miCondomino;
    private javax.swing.JMenuItem miConfirmadas;
    private javax.swing.JMenuItem miEmAndamento;
    private javax.swing.JMenuItem miEmAvaliacao;
    private javax.swing.JMenuItem miExpiradas;
    private javax.swing.JMenuItem miInadimplentes;
    private javax.swing.JMenuItem miPesquisarAluguel;
    private javax.swing.JMenuItem miPesquisarProdutos;
    private javax.swing.JMenuItem miProdutosMaisAlugados;
    private javax.swing.JMenuItem miProdutosMaisSolicitados;
    private javax.swing.JMenuItem miSair;
    private javax.swing.JMenuItem miSolicitacoesProdutos;
    private javax.swing.JMenuItem miTodas;
    private javax.swing.JPanel painelBackground;
    // End of variables declaration//GEN-END:variables
}