package tela.admin.condomino;

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

public class CondominoAtualizarTela extends javax.swing.JFrame {

    private Condomino condomino;
    private String mensagem = "";
    int indice = 0;
    int tamanho = 3;
    private JFormattedTextField fmfTelefones[] = new JFormattedTextField[tamanho];
    

    /**
     * Creates new form CadastraCondomino
     */
    public CondominoAtualizarTela(){
        
    }
    
    public CondominoAtualizarTela(Condomino condomino) throws ParseException {
        initComponents();
        this.condomino = condomino;
        
        painelTelefones.setLayout(new BoxLayout(painelTelefones, BoxLayout.Y_AXIS));
        painelTelefones.setSize(600, 500);
        
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

        for (EstadoCivil e : dao.findEstadoCivil(new EstadoCivil(""))) {
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
            painelTelefones.add(fmfTelefones[i]);
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
        painelDados = new javax.swing.JPanel();
        lNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        lCpf = new javax.swing.JLabel();
        tfCpf = new javax.swing.JFormattedTextField();
        lDataNascimento = new javax.swing.JLabel();
        tfDataNascimento = new javax.swing.JFormattedTextField();
        lEstadoCivil = new javax.swing.JLabel();
        comboEstadoCivil = new javax.swing.JComboBox();
        painelTelefone = new javax.swing.JPanel();
        painelTelefones = new javax.swing.JPanel();
        botaoAdicionar = new javax.swing.JButton();
        botaoRemover = new javax.swing.JButton();
        painelApartamento = new javax.swing.JPanel();
        lBloco = new javax.swing.JLabel();
        comboBloco = new javax.swing.JComboBox();
        lAndar = new javax.swing.JLabel();
        comboAndar = new javax.swing.JComboBox();
        lNumero = new javax.swing.JLabel();
        comboNumero = new javax.swing.JComboBox();
        painelAcesso = new javax.swing.JPanel();
        lLogin = new javax.swing.JLabel();
        tfLogin = new javax.swing.JTextField();
        lSenha = new javax.swing.JLabel();
        tfSenha = new javax.swing.JPasswordField();
        lConfirmarSenha = new javax.swing.JLabel();
        tfConfirmarSenha = new javax.swing.JPasswordField();
        lTipoUsuario = new javax.swing.JLabel();
        checkCondomino = new javax.swing.JRadioButton();
        checkAdministrador = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        botaoSalvar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atualizar Condômino");

        painelDados.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Dados Pessoais", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        lNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lNome.setText("Nome:");

        tfNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lCpf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lCpf.setText("CPF:");

        try {
            tfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCpf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lDataNascimento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lDataNascimento.setText("Data de nascimento:");

        try {
            tfDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDataNascimento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lEstadoCivil.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lEstadoCivil.setText("Estado Civil:");

        comboEstadoCivil.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        painelTelefone.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Telefones", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        javax.swing.GroupLayout painelTelefonesLayout = new javax.swing.GroupLayout(painelTelefones);
        painelTelefones.setLayout(painelTelefonesLayout);
        painelTelefonesLayout.setHorizontalGroup(
            painelTelefonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 232, Short.MAX_VALUE)
        );
        painelTelefonesLayout.setVerticalGroup(
            painelTelefonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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

        javax.swing.GroupLayout painelTelefoneLayout = new javax.swing.GroupLayout(painelTelefone);
        painelTelefone.setLayout(painelTelefoneLayout);
        painelTelefoneLayout.setHorizontalGroup(
            painelTelefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTelefoneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelTelefones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelTelefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoAdicionar)
                    .addComponent(botaoRemover))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelTelefoneLayout.setVerticalGroup(
            painelTelefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTelefoneLayout.createSequentialGroup()
                .addGroup(painelTelefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelTelefoneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(painelTelefones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelTelefoneLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(botaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addComponent(lNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lCpf)
                        .addGap(194, 194, 194))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addComponent(lDataNascimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lEstadoCivil)
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(comboEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addComponent(tfDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addComponent(painelTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNome)
                    .addComponent(lCpf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lDataNascimento)
                    .addComponent(lEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelApartamento.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Apartamento", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        lBloco.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lBloco.setText("Bloco");

        comboBloco.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboBloco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBloco.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBlocoItemStateChanged(evt);
            }
        });

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

        javax.swing.GroupLayout painelApartamentoLayout = new javax.swing.GroupLayout(painelApartamento);
        painelApartamento.setLayout(painelApartamentoLayout);
        painelApartamentoLayout.setHorizontalGroup(
            painelApartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelApartamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelApartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lBloco)
                    .addGroup(painelApartamentoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(comboBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(96, 96, 96)
                .addGroup(painelApartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelApartamentoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(comboAndar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lAndar))
                .addGap(96, 96, 96)
                .addGroup(painelApartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelApartamentoLayout.createSequentialGroup()
                        .addComponent(comboNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(painelApartamentoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lNumero)
                        .addGap(73, 73, 73))))
        );
        painelApartamentoLayout.setVerticalGroup(
            painelApartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelApartamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelApartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lBloco)
                    .addComponent(lAndar)
                    .addComponent(lNumero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelApartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboAndar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelAcesso.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Acesso", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        lLogin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lLogin.setText("Login:");

        tfLogin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lSenha.setText("Senha:");

        lConfirmarSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lConfirmarSenha.setText("Confirmar senha:");

        lTipoUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lTipoUsuario.setText("Tipo de usuário:");

        grupoChecks.add(checkCondomino);
        checkCondomino.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        checkCondomino.setText("Condômino");

        grupoChecks.add(checkAdministrador);
        checkAdministrador.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        checkAdministrador.setText("Administrador");

        javax.swing.GroupLayout painelAcessoLayout = new javax.swing.GroupLayout(painelAcesso);
        painelAcesso.setLayout(painelAcessoLayout);
        painelAcessoLayout.setHorizontalGroup(
            painelAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAcessoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelAcessoLayout.createSequentialGroup()
                        .addGroup(painelAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lLogin)
                            .addGroup(painelAcessoLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(64, 64, 64)
                        .addGroup(painelAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelAcessoLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(tfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lSenha))
                        .addGap(51, 51, 51)
                        .addGroup(painelAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelAcessoLayout.createSequentialGroup()
                                .addComponent(tfConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(painelAcessoLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lConfirmarSenha)
                                .addGap(61, 61, 61))))
                    .addGroup(painelAcessoLayout.createSequentialGroup()
                        .addGroup(painelAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lTipoUsuario)
                            .addGroup(painelAcessoLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(painelAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkAdministrador)
                                    .addComponent(checkCondomino))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        painelAcessoLayout.setVerticalGroup(
            painelAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAcessoLayout.createSequentialGroup()
                .addGroup(painelAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lLogin)
                    .addComponent(lSenha)
                    .addComponent(lConfirmarSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lTipoUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkCondomino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkAdministrador)
                .addGap(0, 4, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(painelAcesso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelDados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelApartamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelApartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            
            painelTelefones.add(fmfTelefones[this.indice]);
            painelTelefones.setVisible(false);
            fmfTelefones[this.indice].setVisible(true);
            painelTelefones.setVisible(true);
            botaoRemover.setEnabled(true);
        }
    }//GEN-LAST:event_botaoAdicionarActionPerformed

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverActionPerformed
        if(this.indice == 0)
            botaoRemover.setEnabled(false);
        else{
            painelTelefones.remove(fmfTelefones[this.indice]);
            painelTelefones.setVisible(false);
            
            this.indice--;
        }
        painelTelefones.setVisible(true);
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
            java.util.logging.Logger.getLogger(CondominoAtualizarTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CondominoAtualizarTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CondominoAtualizarTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CondominoAtualizarTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CondominoAtualizarTela().setVisible(true);
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lAndar;
    private javax.swing.JLabel lBloco;
    private javax.swing.JLabel lConfirmarSenha;
    private javax.swing.JLabel lCpf;
    private javax.swing.JLabel lDataNascimento;
    private javax.swing.JLabel lEstadoCivil;
    private javax.swing.JLabel lLogin;
    private javax.swing.JLabel lNome;
    private javax.swing.JLabel lNumero;
    private javax.swing.JLabel lSenha;
    private javax.swing.JLabel lTipoUsuario;
    private javax.swing.JPanel painelAcesso;
    private javax.swing.JPanel painelApartamento;
    private javax.swing.JPanel painelDados;
    private javax.swing.JPanel painelTelefone;
    private javax.swing.JPanel painelTelefones;
    private javax.swing.JPasswordField tfConfirmarSenha;
    private javax.swing.JFormattedTextField tfCpf;
    private javax.swing.JFormattedTextField tfDataNascimento;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JTextField tfNome;
    private javax.swing.JPasswordField tfSenha;
    // End of variables declaration//GEN-END:variables
}
