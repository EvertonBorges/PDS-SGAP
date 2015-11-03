/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.admin;

import modelo.Administrador;
import tela.*;
import modelo.Condomino;
import tela.Apartamento.ApartamentoPesquisarTela;
import tela.condomino.PesquisaCondomino;
import tela.meusProdutos.CadastrarProduto;
import tela.meusProdutos.PesquisarProduto;

/**
 *
 * @author Borges
 */
public class AdministradorPrincipalTela extends javax.swing.JFrame {
    private final Administrador administrador;
    /**
     * Creates new form Principal
     */
    public AdministradorPrincipalTela(Administrador administrador) {
        this.administrador = administrador;
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

        mbMenu = new javax.swing.JMenuBar();
        mConta = new javax.swing.JMenu();
        imAlterarSenha = new javax.swing.JMenuItem();
        imSair = new javax.swing.JMenuItem();
        mCadastros = new javax.swing.JMenu();
        mAdministrador = new javax.swing.JMenuItem();
        imCondomino = new javax.swing.JMenuItem();
        imApartamento = new javax.swing.JMenuItem();
        imCategoria = new javax.swing.JMenuItem();
        mApartamento = new javax.swing.JMenu();
        imCadastrarApartamento = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SGAP - Sistema de Gerenciamento de Aluguel de Produtos - ADMINISTRADOR");

        mConta.setText("Conta");
        mConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mContaActionPerformed(evt);
            }
        });

        imAlterarSenha.setText("Alterar senha");
        mConta.add(imAlterarSenha);

        imSair.setText("Sair");
        imSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imSairActionPerformed(evt);
            }
        });
        mConta.add(imSair);

        mbMenu.add(mConta);

        mCadastros.setText("Cadastros");

        mAdministrador.setText("Administrador");
        mAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mAdministradorActionPerformed(evt);
            }
        });
        mCadastros.add(mAdministrador);

        imCondomino.setText("Condomino");
        imCondomino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imCondominoActionPerformed(evt);
            }
        });
        mCadastros.add(imCondomino);

        imApartamento.setText("Apartamento");
        imApartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imApartamentoActionPerformed(evt);
            }
        });
        mCadastros.add(imApartamento);

        imCategoria.setText("Categoria");
        mCadastros.add(imCategoria);

        mbMenu.add(mCadastros);

        mApartamento.setText("Produto");

        imCadastrarApartamento.setText("Pesquisar Produtos");
        mApartamento.add(imCadastrarApartamento);

        mbMenu.add(mApartamento);

        jMenu1.setText("Aluguel");
        mbMenu.add(jMenu1);

        jMenu2.setText("Relatórios");

        jMenuItem1.setText("Aluguéis realizado por período");
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Condôminos inadimplentes");
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Produtos mais procurados");
        jMenu2.add(jMenuItem3);

        mbMenu.add(jMenu2);

        setJMenuBar(mbMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mAdministradorActionPerformed
        AdministradorPesquisarTela administradorPesquisarTela = new AdministradorPesquisarTela();
        administradorPesquisarTela.setVisible(true);
    }//GEN-LAST:event_mAdministradorActionPerformed

    private void imCondominoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imCondominoActionPerformed
        PesquisaCondomino pesquisaCondomino = new PesquisaCondomino();
        pesquisaCondomino.setVisible(true);
    }//GEN-LAST:event_imCondominoActionPerformed

    private void mContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mContaActionPerformed
        dispose();
    }//GEN-LAST:event_mContaActionPerformed

    private void imSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_imSairActionPerformed

    private void imApartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imApartamentoActionPerformed
        ApartamentoPesquisarTela apartamentoPesquisarTela = new ApartamentoPesquisarTela();
        apartamentoPesquisarTela.setVisible(true);
    }//GEN-LAST:event_imApartamentoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem imAlterarSenha;
    private javax.swing.JMenuItem imApartamento;
    private javax.swing.JMenuItem imCadastrarApartamento;
    private javax.swing.JMenuItem imCategoria;
    private javax.swing.JMenuItem imCondomino;
    private javax.swing.JMenuItem imSair;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem mAdministrador;
    private javax.swing.JMenu mApartamento;
    private javax.swing.JMenu mCadastros;
    private javax.swing.JMenu mConta;
    private javax.swing.JMenuBar mbMenu;
    // End of variables declaration//GEN-END:variables
}
