package tela;

import dao.CondominoDAO;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modelo.Condomino;

public class LoginFX extends Application {
    private Pane pane;
    private TextField tfLogin;
    private PasswordField tfSenha;
    private Button bEntrar, bSair;
    private static Stage stage;
    private static String[] args;
    
    @Override
    public void start(Stage stage) {
        LoginFX.stage = stage;
        stage.setTitle("SGAP - Login");
        pane = new Pane();
        pane.setPrefSize(400, 120);
        pane.setStyle("-fx-background-color:linear-gradient(from 0% 0% to 100% 100%, silver 0%, gold 100%);");
        
        tfLogin = new TextField();
        tfLogin.setPromptText("Digite aqui seu login");
        tfLogin.setPrefSize(200, tfLogin.getFont().getSize());
        tfSenha = new PasswordField();
        tfSenha.setPromptText("Digite aqui a senha");
        tfSenha.setPrefSize(200, tfSenha.getFont().getSize());
        tfSenha.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER){
                    botaoLogar();
                }
                
            }
        });
        
        bEntrar = new Button("Entrar");
        bEntrar.setPrefSize(100, bEntrar.getFont().getSize() + 5);
        bEntrar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                botaoLogar();
            }
        });
        bSair = new Button("Sair");
        bSair.setPrefSize(100, bSair.getFont().getSize() + 5);
        bSair.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                botaoSair();
            }
        });
        
        tfLogin.setLayoutX((pane.getPrefWidth() - 1.5*bEntrar.getPrefWidth() - tfLogin.getPrefWidth())/2);
        tfSenha.setLayoutX((pane.getPrefWidth() - 1.5*bEntrar.getPrefWidth() - tfLogin.getPrefWidth())/2);
        bEntrar.setLayoutX((pane.getPrefWidth() + 3.5*bEntrar.getPrefWidth() - tfLogin.getPrefWidth())/2);
        bSair.setLayoutX((pane.getPrefWidth() + 3.5*bEntrar.getPrefWidth() - tfLogin.getPrefWidth())/2);
        tfLogin.setLayoutY((pane.getPrefHeight()-tfLogin.getPrefHeight())/2 - 20);
        tfSenha.setLayoutY((pane.getPrefHeight()-tfLogin.getPrefHeight())/2 + 20);
        bEntrar.setLayoutY((pane.getPrefHeight()-tfLogin.getPrefHeight())/2 - 20);
        bSair.setLayoutY((pane.getPrefHeight()-tfLogin.getPrefHeight())/2 + 20);
        
        pane.getChildren().addAll(tfLogin, tfSenha, bEntrar, bSair);
        Scene cena = new Scene(pane);
        stage.setScene(cena);
        stage.show();
    }
    
    private Condomino condominoConsulta(){
        String senha = tfSenha.getText();
        
        Condomino c = new Condomino() ;
        c.setLogin(tfLogin.getText());
        c.setSenha(senha);
        
        return c;
    }
    
    private void botaoLogar(){
        CondominoDAO dao = new CondominoDAO();
        Condomino condomino = dao.validarLogin(condominoConsulta());
        
        if(condomino != null){
            Principal principal = new Principal(condomino);
            principal.setVisible(true);
            stage.close();
        } else {
            JOptionPane.showMessageDialog(null, "Login ou senha incorreta", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void botaoSair(){
        stage.close();
    }

    public static Stage getStage() {
        return stage;
    }
    
    public static void main(String[] args) {
        LoginFX.args = args;
        launch(args);
    }
}