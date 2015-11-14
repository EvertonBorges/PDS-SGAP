package tela.condomino;

import dao.ApartamentoDAO;
import dao.CondominoDAO;
import dao.EstadoCivilDAO;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import modelo.TipoUsuario;

public class AlterarCondomino extends javax.swing.JFrame {

    private Condomino condomino;
    private String mensagem = "";
    int indice = 0;
    int tamanho = 3;
    private JFormattedTextField fmfTelefones[] = new JFormattedTextField[tamanho];
    

    /**
     * Creates new form CadastraCondomino
     */
    public AlterarCondomino(){
        
    }
    
    public AlterarCondomino(Condomino condomino) throws ParseException {
        initComponents();
        this.condomino = condomino;
        
        painelTelefone.setLayout(new BoxLayout(painelTelefone, BoxLayout.Y_AXIS));
        painelTelefone.setSize(600, 500);
        
        preencheComboEstadoCivil();
        preencheComboBloco();
        preencheComboAndar();
        preencheComboNumero();
        dadosCondomino();
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
        
        comboBloco.getModel().setSelectedItem(this.condomino.getApartamento().getBloco());
    }

    private void preencheComboAndar(){
        comboAndar.removeAllItems();
        comboAndar.addItem("");
        
        ApartamentoDAO dao = new ApartamentoDAO();
        
        List<Integer> andares = dao.listaAndar((char) comboBloco.getSelectedItem());
        
        for (Integer andar : andares) {
            comboAndar.addItem(andar);
        }
        
        comboAndar.getModel().setSelectedItem(this.condomino.getApartamento().getAndar());
    }
    
    private void preencheComboNumero(){
        comboNumero.removeAllItems();
        comboNumero.addItem("");
        
        ApartamentoDAO dao = new ApartamentoDAO();
        
        List<String> numAps = dao.listaNumApartamento((Character) comboBloco.getSelectedItem(), (int) comboAndar.getSelectedItem());
        
        for (String numero : numAps) {
            comboNumero.addItem(numero);
        }
        
        comboNumero.getModel().setSelectedItem(this.condomino.getApartamento().getNumApartamento());
    }
    
    private void dadosCondomino() throws ParseException {
        tfNome.setText(this.condomino.getNome());
        tfCpf.setValue(this.condomino.getCpf());
        tfDataNascimento.setValue(dataFormatada(this.condomino.getDataNascimento()));
        comboEstadoCivil.getModel().setSelectedItem(this.condomino.getEstadoCivil());
        
        for (int i = 0; i < this.condomino.getTelefones().size(); i++) {
            fmfTelefones[i] = new JFormattedTextField(new DefaultFormatterFactory(new MaskFormatter("(##)#####-####")));
        
            fmfTelefones[i].setFont(new Font("Tahoma", 0, 13));
            painelTelefone.add(fmfTelefones[i]);
            fmfTelefones[i].setPreferredSize(new Dimension(140, 32));
            fmfTelefones[i].setValue(this.condomino.getTelefones().get(i));
        }
        
        tfLogin.setText(this.condomino.getLogin());
        
        if(this.condomino.getTipoUsuario() == TipoUsuario.ADMIN){
            grupoChecks.setSelected(checkAdministrador.getModel(), true); 
        }
        else
            grupoChecks. setSelected(checkCondomino.getModel(), true); 
        
        this.indice = this.condomino.getTelefones().size() -1;
    }
    
    // transforma Calendar em String
    private String dataFormatada(Calendar data){
        Calendar c = data;
        Date date = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        return sdf.format(date);
    }
    
    // retorna objeto calendar de uma string
    private Calendar dateToCalendar(String data) throws ParseException {
        DateFormat f = DateFormat.getDateInstance();
        Date date = f.parse(data);
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        return c;
    }
    
    private boolean validaCampos() {
        boolean valor = true;
        String senha = new String(tfSenha.getPassword());
        String confirmaSenha = new String(tfConfirmarSenha.getPassword());
        mensagem = "Campos não preenchidos: ";
        
        if (tfNome.getText().length() == 0) {
            mensagem = mensagem + "nome, ";
            valor = false;
        }

        if(tfCpf.getText() == "###.###.###-##"){
            mensagem = mensagem + "cpf, ";
            valor = false;
        }
        
        if (tfDataNascimento.getText() == "##/##/####") {
            mensagem = mensagem + "data de nascimento, ";
            valor = false;
        }

        if (comboEstadoCivil.getSelectedItem() == "") {
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

        if (senha.equalsIgnoreCase("")) {
            mensagem = mensagem + "senha, ";
            valor = false;
        }

        if (confirmaSenha.equalsIgnoreCase("")) {
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

        if ((!senha.equals(confirmaSenha))
                && (!senha.equals("")) && (!confirmaSenha.equals(""))) {
            mensagem = mensagem + "\nOs valores da senha não coincidem.";
            valor = false;
        }
        
        if(!checkCondomino.isSelected() && !checkAdministrador.isSelected()){
            mensagem = mensagem + "\nSelecione um tipo de usuário.";
            valor = false;
        }


        return valor;
    }

    private Apartamento apartamento() {
        Apartamento ap;

        ApartamentoDAO dao = new ApartamentoDAO();

        ap = dao.apartamento((char) comboBloco.getSelectedItem(), (int) comboAndar.getSelectedItem(), (String) comboNumero.getSelectedItem());

        return ap;
    }

    private Condomino condominoAlterado() throws ParseException {
        this.condomino.getTelefones().clear();
        
        this.condomino.setNome(tfNome.getText());
        this.condomino.setCpf(tfCpf.getText());
        this.condomino.setDataNascimento(dateToCalendar(tfDataNascimento.getText()));
        this.condomino.setEstadoCivil((EstadoCivil) comboEstadoCivil.getSelectedItem());
        
        for(int i = 0; i<=this.indice; i++){
            
            if(fmfTelefones[i].getValue() != null) {
                this.condomino.getTelefones().add(fmfTelefones[i].getText());
            }
        
        }
        
        this.condomino.setLogin(tfLogin.getText());
        //this.condomino.setSenha(tfSenha.getText());
        this.condomino.setApartamento(apartamento());
        if (checkCondomino.isSelected()) {
            this.condomino.setTipoUsuario(TipoUsuario.CONDOMINO);
        } else {
            if (checkAdministrador.isSelected()) {
                this.condomino.setTipoUsuario(TipoUsuario.ADMIN);
            }
        }
        
        return this.condomino;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoChecks = new javax.swing.ButtonGroup();
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
        lApartamento = new javax.swing.JLabel();
        comboBloco = new javax.swing.JComboBox();
        lBloco = new javax.swing.JLabel();
        lAndar = new javax.swing.JLabel();
        comboAndar = new javax.swing.JComboBox();
        lNumero = new javax.swing.JLabel();
        comboNumero = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        botaoSalvar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        tfCpf = new javax.swing.JFormattedTextField();
        tfDataNascimento = new javax.swing.JFormattedTextField();
        lConfirmarSenha = new javax.swing.JLabel();
        painelTelefone = new javax.swing.JPanel();
        botaoAdicionar = new javax.swing.JButton();
        botaoRemover = new javax.swing.JButton();
        lTipoUsuario = new javax.swing.JLabel();
        checkCondomino = new javax.swing.JRadioButton();
        checkAdministrador = new javax.swing.JRadioButton();
        tfSenha = new javax.swing.JPasswordField();
        tfConfirmarSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lNome.setText("Nome:");

        tfNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lCpf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lCpf.setText("CPF:");

        lDataNascimento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lDataNascimento.setText("Data de nascimento:");

        lEstadoCivil.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lEstadoCivil.setText("Estado Civil:");

        comboEstadoCivil.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lTelefone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lTelefone.setText("Telefone:");

        lLogin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lLogin.setText("Login:");

        tfLogin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lSenha.setText("Senha:");

        lApartamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lApartamento.setText("Apartamento:");

        comboBloco.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboBloco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBloco.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBlocoItemStateChanged(evt);
            }
        });

        lBloco.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lBloco.setText("Bloco");

        lAndar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lAndar.setText("Andar");

        comboAndar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboAndar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboAndar.setEnabled(false);
        comboAndar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboAndarItemStateChanged(evt);
            }
        });

        lNumero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lNumero.setText("Número");

        comboNumero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboNumero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboNumero.setEnabled(false);

        botaoSalvar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        botaoCancelar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
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
        tfCpf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        try {
            tfDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDataNascimento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lConfirmarSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lConfirmarSenha.setText("Confirmar senha:");

        javax.swing.GroupLayout painelTelefoneLayout = new javax.swing.GroupLayout(painelTelefone);
        painelTelefone.setLayout(painelTelefoneLayout);
        painelTelefoneLayout.setHorizontalGroup(
            painelTelefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 224, Short.MAX_VALUE)
        );
        painelTelefoneLayout.setVerticalGroup(
            painelTelefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
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

        lTipoUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lTipoUsuario.setText("Tipo de usuário:");

        grupoChecks.add(checkCondomino);
        checkCondomino.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        checkCondomino.setText("Condômino");

        grupoChecks.add(checkAdministrador);
        checkAdministrador.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        checkAdministrador.setText("Administrador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(checkCondomino)
                            .addComponent(lTipoUsuario))
                        .addGap(41, 41, 41)
                        .addComponent(checkAdministrador))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lNome)
                                        .addGap(259, 259, 259)
                                        .addComponent(lCpf))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lBloco)
                                            .addComponent(comboBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lApartamento)
                                            .addComponent(lLogin))
                                        .addGap(82, 82, 82)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboAndar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lAndar)))
                                    .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lNumero)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(98, 98, 98)
                                        .addComponent(jLabel2))
                                    .addComponent(comboNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lTelefone)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lDataNascimento)
                                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lEstadoCivil)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(painelTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botaoAdicionar)
                                    .addComponent(botaoRemover)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lSenha)
                                    .addComponent(tfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lConfirmarSenha)
                                    .addComponent(tfConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(243, 243, 243)
                                    .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNome)
                    .addComponent(lCpf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lDataNascimento)
                    .addComponent(lEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botaoRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(painelTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(lApartamento)
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lBloco)
                            .addComponent(lAndar)
                            .addComponent(lNumero))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboAndar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lLogin)
                    .addComponent(lSenha)
                    .addComponent(lConfirmarSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(lTipoUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkCondomino)
                    .addComponent(checkAdministrador))
                .addGap(30, 30, 30)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comboBlocoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBlocoItemStateChanged
        if (comboBloco.getSelectedIndex() > 0) {
            comboAndar.removeAllItems();
            comboAndar.addItem("");

            ApartamentoDAO dao = new ApartamentoDAO();

            List<Integer> andares = dao.listaAndar((char) comboBloco.getSelectedItem());

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

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        if (validaCampos() == false) {
            JOptionPane.showMessageDialog(this, mensagem, "Aviso", JOptionPane.INFORMATION_MESSAGE);
            mensagem = "";
        } 
        
        else {
            CondominoDAO dao = new CondominoDAO();
            try {
                dao.alteraCondomino(condominoAlterado());
                JOptionPane.showMessageDialog(this, "Dados do condômino alterado com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed
        if(this.indice == (tamanho-1)){
            JOptionPane.showMessageDialog(this, "Limite!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            this.indice++;
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
            painelTelefone.remove(fmfTelefones[this.indice]);
            painelTelefone.setVisible(false);
            
            this.indice--;
        }
        painelTelefone.setVisible(true);
    }//GEN-LAST:event_botaoRemoverActionPerformed

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
            java.util.logging.Logger.getLogger(AlterarCondomino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarCondomino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarCondomino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarCondomino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarCondomino().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JRadioButton checkAdministrador;
    private javax.swing.JRadioButton checkCondomino;
    private javax.swing.JComboBox comboAndar;
    private javax.swing.JComboBox comboBloco;
    private javax.swing.JComboBox comboEstadoCivil;
    private javax.swing.JComboBox comboNumero;
    private javax.swing.ButtonGroup grupoChecks;
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
    private javax.swing.JLabel lTipoUsuario;
    private javax.swing.JPanel painelTelefone;
    private javax.swing.JPasswordField tfConfirmarSenha;
    private javax.swing.JFormattedTextField tfCpf;
    private javax.swing.JFormattedTextField tfDataNascimento;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JTextField tfNome;
    private javax.swing.JPasswordField tfSenha;
    // End of variables declaration//GEN-END:variables
}
