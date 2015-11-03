package tela.condomino;

import dao.ApartamentoDAO;
import dao.CondominoDAO;
import dao.EstadoCivilDAO;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import modelo.Apartamento;
import modelo.Condomino;
import modelo.EstadoCivil;

/**
 *
 * @author Bruna
 */
public class CadastraCondomino extends javax.swing.JFrame {

    private String mensagem;
    int indice = 0;
    int tamanho = 3;
    private JFormattedTextField fmfTelefones[] = new JFormattedTextField[tamanho]; 
    

    /**
     * Creates new form CadastraCondomino
     */
    public CadastraCondomino() throws ParseException {
        initComponents();
        preencheComboEstadoCivil();
        preencheComboBloco();
        comboAndar.removeAllItems();
        comboNumero.removeAllItems();
        
        painelTelefone.setLayout(new BoxLayout(painelTelefone, BoxLayout.Y_AXIS));
        painelTelefone.setSize(600, 500);
        
        fmfTelefones[this.indice] = new JFormattedTextField(new DefaultFormatterFactory(new MaskFormatter("(##)#####-####")));
        
        fmfTelefones[this.indice].setFont(new Font("Tahoma", 0, 13));
        painelTelefone.add(fmfTelefones[this.indice]);
        fmfTelefones[this.indice].setPreferredSize(new Dimension(140, 32));
    }

    private void preencheComboEstadoCivil() {
        comboEstadoCivil.removeAllItems();
        comboEstadoCivil.addItem("");

        EstadoCivilDAO dao = new EstadoCivilDAO();

        for (EstadoCivil e : dao.listaEstadoCivil()) {
            comboEstadoCivil.addItem(e);
        }
    }

    private void preencheComboBloco() {
        ApartamentoDAO dao = new ApartamentoDAO();
        comboBloco.removeAllItems();
        comboBloco.addItem("");
        for (Character bloco : dao.listaBloco()) {
            comboBloco.addItem(bloco);
        }
    }

    private boolean validaCampos() {
        boolean valor = true;
        mensagem = "Campos não preenchidos: ";

        if (tfNome.getText().equalsIgnoreCase("")) {
            mensagem = mensagem + "nome, ";
            valor = false;
        }

        if (tfCpf.getValue() == null) {
            mensagem = mensagem + "cpf, ";
            valor = false;
        }

        if (tfDataNascimento.getValue() == null) {
            mensagem = mensagem + "data de nascimento, ";
            valor = false;
        }

        if (comboEstadoCivil.getSelectedIndex() < 1) {
            mensagem = mensagem + "estado civil, ";
            valor = false;
        }

        if(fmfTelefones[0].getValue() == null){
            mensagem = mensagem+"telefone, ";
            valor = false;
        }
        
        if (tfLogin.getText().equalsIgnoreCase("")) {
            mensagem = mensagem + "login, ";
            valor = false;
        }

        if (tfSenha.getText().equalsIgnoreCase("")) {
            mensagem = mensagem + "senha, ";
            valor = false;
        }

        if (tfConfirmarSenha.getText().equalsIgnoreCase("")) {
            mensagem = mensagem + "confirmar senha, ";
            valor = false;
        }

        if (comboBloco.getSelectedIndex() < 1) {
            mensagem = mensagem + "bloco, ";
            valor = false;
        }

        if (comboAndar.getSelectedIndex() < 1) {
            mensagem = mensagem + "andar, ";
            valor = false;
        }

        if (comboNumero.getSelectedIndex() < 1) {
            mensagem = mensagem + "número do apartamento.";
            valor = false;
        }

        if ((!tfSenha.getText().equals(tfConfirmarSenha.getText()))
                && (!tfSenha.getText().equals("")) && (!tfConfirmarSenha.getText().equals(""))) {
            mensagem = mensagem + "\nOs valores da senha não coincidem.";
            valor = false;
        }

        return valor;
    }

    // retorna objeto calendar de uma string
    private Calendar dateToCalendar(String data) throws ParseException {
        DateFormat f = DateFormat.getDateInstance();
        Date date = f.parse(data);
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        return c;
    }

    private Apartamento apartamento() {
        Apartamento ap = new Apartamento();

        ApartamentoDAO dao = new ApartamentoDAO();

        ap = dao.apartamento((char) comboBloco.getSelectedItem(), (int) comboAndar.getSelectedItem(), (String) comboNumero.getSelectedItem());

        return ap;
    }

    private Condomino novoCondomino() throws ParseException {
        Condomino condomino = new Condomino();
        List<String> telefones = new ArrayList<>();

        for(int i = 0; i<=this.indice; i++){
            if(fmfTelefones[i].getValue() != null) {
                telefones.add(fmfTelefones[i].getText());
            }
        }
        
        condomino.setNome(tfNome.getText());
        condomino.setCpf(tfCpf.getText());
        condomino.setDataNascimento(dateToCalendar(tfDataNascimento.getText()));
        condomino.setEstadoCivil((EstadoCivil) comboEstadoCivil.getSelectedItem());
        condomino.setTelefones(telefones);
        condomino.setLogin(tfLogin.getText());
        condomino.setSenha(tfSenha.getText());
        condomino.setApartamento(apartamento());

        return condomino;
    }

    private void limparCampos() {
        tfNome.setText("");
        tfCpf.setText("");
        tfCpf.setValue("");
        tfDataNascimento.setText("");
        tfDataNascimento.setValue("");
        comboEstadoCivil.setSelectedItem("");
        
        for(int i = 0; i<=this.indice; i++){
            if(i == 0){
                fmfTelefones[i].setText("");
                fmfTelefones[i].setValue("");
            }
            
            else{
                painelTelefone.setVisible(false);
                fmfTelefones[i].setVisible(false);
                painelTelefone.remove(fmfTelefones[i]);
                painelTelefone.setVisible(true);
            }
        }
        
        tfLogin.setText("");
        tfSenha.setText("");
        tfConfirmarSenha.setText("");
        comboBloco.setSelectedItem("");
        this.indice = 0;
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
        tfNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lCpf = new javax.swing.JLabel();
        lDataNascimento = new javax.swing.JLabel();
        lEstadoCivil = new javax.swing.JLabel();
        comboEstadoCivil = new javax.swing.JComboBox();
        lTelefone = new javax.swing.JLabel();
        lLogin = new javax.swing.JLabel();
        tfLogin = new javax.swing.JTextField();
        lSenha = new javax.swing.JLabel();
        tfSenha = new javax.swing.JTextField();
        lApartamento = new javax.swing.JLabel();
        comboBloco = new javax.swing.JComboBox();
        lBloco = new javax.swing.JLabel();
        lAndar = new javax.swing.JLabel();
        comboAndar = new javax.swing.JComboBox();
        lNumero = new javax.swing.JLabel();
        comboNumero = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        botaoCadastrar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        tfCpf = new javax.swing.JFormattedTextField();
        tfDataNascimento = new javax.swing.JFormattedTextField();
        lConfirmarSenha = new javax.swing.JLabel();
        tfConfirmarSenha = new javax.swing.JTextField();
        painelTelefone = new javax.swing.JPanel();
        botaoAdicionar = new javax.swing.JButton();
        botaoRemover = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lNome.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lNome.setText("Nome:");

        tfNome.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        lCpf.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lCpf.setText("CPF:");

        lDataNascimento.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lDataNascimento.setText("Data de nascimento:");

        lEstadoCivil.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lEstadoCivil.setText("Estado Civil:");

        comboEstadoCivil.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        comboEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lTelefone.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lTelefone.setText("Telefone:");

        lLogin.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lLogin.setText("Login:");

        tfLogin.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        lSenha.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lSenha.setText("Senha:");

        tfSenha.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        lApartamento.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lApartamento.setText("Apartamento:");

        comboBloco.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        comboBloco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBloco.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBlocoItemStateChanged(evt);
            }
        });

        lBloco.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lBloco.setText("Bloco");

        lAndar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lAndar.setText("Andar");

        comboAndar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        comboAndar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboAndar.setEnabled(false);
        comboAndar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboAndarItemStateChanged(evt);
            }
        });

        lNumero.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lNumero.setText("Número");

        comboNumero.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        comboNumero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboNumero.setEnabled(false);

        botaoCadastrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });

        botaoCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        try {
            tfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCpf.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        try {
            tfDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDataNascimento.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        lConfirmarSenha.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lConfirmarSenha.setText("Confirmar senha:");

        tfConfirmarSenha.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        javax.swing.GroupLayout painelTelefoneLayout = new javax.swing.GroupLayout(painelTelefone);
        painelTelefone.setLayout(painelTelefoneLayout);
        painelTelefoneLayout.setHorizontalGroup(
            painelTelefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 224, Short.MAX_VALUE)
        );
        painelTelefoneLayout.setVerticalGroup(
            painelTelefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );

        botaoAdicionar.setText("Adicionar");
        botaoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarActionPerformed(evt);
            }
        });

        botaoRemover.setText("Remover");
        botaoRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lLogin)
                            .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lSenha)
                                .addGap(150, 150, 150))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfSenha)
                                .addGap(63, 63, 63)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lConfirmarSenha))
                        .addGap(133, 133, 133))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lTelefone)
                            .addComponent(lApartamento)
                            .addComponent(comboEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lEstadoCivil)
                            .addComponent(lNome)
                            .addComponent(lCpf)
                            .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lDataNascimento)
                            .addComponent(tfDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botaoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(painelTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(botaoRemover)
                                            .addComponent(botaoAdicionar))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lBloco)
                                        .addGap(134, 134, 134)
                                        .addComponent(lAndar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(comboBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(70, 70, 70)
                                        .addComponent(comboAndar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lNumero))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(lCpf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lDataNascimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lTelefone)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel2)
                        .addGap(18, 52, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lConfirmarSenha)
                            .addComponent(lSenha)
                            .addComponent(lLogin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botaoRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(painelTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lApartamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNumero)
                    .addComponent(lAndar)
                    .addComponent(lBloco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboAndar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBlocoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBlocoItemStateChanged
        if (comboBloco.getSelectedIndex() > 0) {
            comboAndar.removeAllItems();
            comboAndar.addItem("");

            ApartamentoDAO dao = new ApartamentoDAO();

            List<Integer> andares = dao.listaAndar((Character) comboBloco.getSelectedItem());

            for (Integer andar : andares) {
                comboAndar.addItem(andar);
            }

            comboAndar.setEnabled(true);
        } else {
            comboAndar.setEnabled(false);
            comboNumero.setEnabled(false);
            comboAndar.removeAllItems();
            comboNumero.removeAllItems();
        }
    }//GEN-LAST:event_comboBlocoItemStateChanged

    private void comboAndarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboAndarItemStateChanged
        if (comboAndar.getSelectedIndex() > 0) {
            comboNumero.removeAllItems();
            comboNumero.addItem("");

            ApartamentoDAO dao = new ApartamentoDAO();

            List<String> numApartamentos = dao.listaNumApartamento((Character) comboBloco.getSelectedItem(), (int) comboAndar.getSelectedItem());

            for (String numApartamento : numApartamentos) {
                comboNumero.addItem(numApartamento);
            }

            comboNumero.setEnabled(true);
        } else {
            comboNumero.setEnabled(false);
            comboNumero.removeAllItems();

        }
    }//GEN-LAST:event_comboAndarItemStateChanged

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
        if (validaCampos() == false) {
            JOptionPane.showMessageDialog(this, mensagem, "Aviso", JOptionPane.INFORMATION_MESSAGE);
            mensagem = "";
        } else {
            CondominoDAO dao = new CondominoDAO();
            try {
                dao.insereCondomino(novoCondomino());
                JOptionPane.showMessageDialog(this, "Condômino cadastrado com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);

                int resposta = JOptionPane.showConfirmDialog(this, "Deseja continuar cadastrando condôminos?", "Aviso", JOptionPane.YES_NO_OPTION);

                if (resposta == JOptionPane.YES_OPTION) {
                    limparCampos();
                } else {
                    dispose();
                }
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_botaoCadastrarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed
        if(this.indice == (tamanho-1)){
            JOptionPane.showMessageDialog(this, "Limite!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            indice++;
            try{
                fmfTelefones[this.indice] = new JFormattedTextField(new DefaultFormatterFactory(new MaskFormatter("(##)#####-####")));
                fmfTelefones[this.indice].setFont(new Font("Tahoma", 0, 13));
                fmfTelefones[this.indice].setPreferredSize(new Dimension(140, 32));
            } catch(ParseException e){
                e.getMessage();
            }
            
            painelTelefone.add(fmfTelefones[this.indice]);
            painelTelefone.setVisible(false);
            fmfTelefones[this.indice].setVisible(true);
            painelTelefone.setVisible(true);
            botaoRemover.setEnabled(true);
        }
    }//GEN-LAST:event_botaoAdicionarActionPerformed

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverActionPerformed
        if(this.indice == 0)
            botaoRemover.setEnabled(false);
        else{
            painelTelefone.setVisible(false);
            fmfTelefones[this.indice].setVisible(false);
            painelTelefone.setVisible(true);
            painelTelefone.remove(fmfTelefones[this.indice]);
            this.indice--;
        }
    }//GEN-LAST:event_botaoRemoverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JComboBox comboAndar;
    private javax.swing.JComboBox comboBloco;
    private javax.swing.JComboBox comboEstadoCivil;
    private javax.swing.JComboBox comboNumero;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lAndar;
    private javax.swing.JLabel lApartamento;
    private javax.swing.JLabel lBloco;
    private javax.swing.JLabel lConfirmarSenha;
    private javax.swing.JLabel lCpf;
    private javax.swing.JLabel lDataNascimento;
    private javax.swing.JLabel lEstadoCivil;
    private javax.swing.JLabel lLogin;
    private javax.swing.JLabel lNome;
    private javax.swing.JLabel lNumero;
    private javax.swing.JLabel lSenha;
    private javax.swing.JLabel lTelefone;
    private javax.swing.JPanel painelTelefone;
    private javax.swing.JTextField tfConfirmarSenha;
    private javax.swing.JFormattedTextField tfCpf;
    private javax.swing.JFormattedTextField tfDataNascimento;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfSenha;
    // End of variables declaration//GEN-END:variables
}
