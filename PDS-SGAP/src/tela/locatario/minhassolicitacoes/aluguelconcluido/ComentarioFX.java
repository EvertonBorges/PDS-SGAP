package tela.locatario.minhassolicitacoes.aluguelconcluido;

import dao.ComentarioDAO;
import java.util.Calendar;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modelo.Aluguel;
import modelo.Avaliacao;
import modelo.Comentario;

public class ComentarioFX extends Application {
    private Pane painelComentario, painelAvaliacao, painelPrincipal;
    private Label tituloPainelComentario, tituloPainelAvaliacao;
    private TextArea taComentario;
    private Button bComentar, bVoltar;
    private RadioButton rbNegativo, rbNeutro, rbPositivo;
    private ToggleGroup radiosButtons;
    //private final Aluguel aluguel;
    private static Stage stage;

    /*
    public ComentarioFX(Aluguel aluguel) {
        this.aluguel = aluguel;
    }
    */
    
    @Override
    public void start(Stage stage) {
        ComentarioFX.stage = stage;
        stage.setTitle("SGAP - Login");
        
        painelPrincipal = new Pane();
        painelPrincipal.setPrefSize(440, 450);
        painelPrincipal.setStyle("-fx-background-color:linear-gradient(from 0% 0% to 100% 100%, silver 0%, gold 100%);");
        
        painelComentario = new Pane();
        painelComentario.setPrefSize(400, 200);
        painelComentario.setLayoutX(20);
        painelComentario.setLayoutY(20);
        painelComentario.setStyle("-fx-border-style: solid; -fx-border-width: 2px;");
        
        painelAvaliacao = new Pane();
        painelAvaliacao.setPrefSize(400, 80);
        painelAvaliacao.setLayoutX(painelComentario.getLayoutX());
        painelAvaliacao.setLayoutY(painelComentario.getPrefHeight() + 60);
        painelAvaliacao.setStyle("-fx-border-style: solid; -fx-border-width: 2px;");
        
        bComentar = new Button("Comentar");
        bComentar.setPrefSize(80, 30);
        bComentar.setLayoutX((painelPrincipal.getPrefWidth() - bComentar.getPrefWidth())/2 - 120);
        bComentar.setLayoutY((painelAvaliacao.getLayoutY() + painelAvaliacao.getPrefHeight() + 40));
        bComentar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                adicionarComentario();
            }
        });
        
        bVoltar = new Button("Voltar");
        bVoltar.setPrefSize(80, 30);
        bVoltar.setLayoutX((painelPrincipal.getPrefWidth() - bVoltar.getPrefWidth())/2 + 120);
        bVoltar.setLayoutY((painelAvaliacao.getLayoutY() + painelAvaliacao.getPrefHeight() + 40));
        
        taComentario = new TextArea();
        taComentario.setPrefSize(painelComentario.getPrefWidth() - 40, painelComentario.getPrefHeight() - 40);
        taComentario.setLayoutX((painelComentario.getPrefWidth() - taComentario.getPrefWidth())/2);
        taComentario.setLayoutY((painelComentario.getPrefHeight() - taComentario.getPrefHeight())/2);
        taComentario.setPromptText("Faça algum comentário sobre o produto");
        
        tituloPainelComentario = new Label("Comentário");
        tituloPainelComentario.setLayoutX(10);
        tituloPainelComentario.setLayoutY(-14);
        
        rbNeutro = new RadioButton("Neutro");
        rbNeutro.setPrefSize(80, rbNeutro.getText().length() + 5);
        rbNeutro.setLayoutX((painelAvaliacao.getPrefWidth() - rbNeutro.getPrefWidth())/2);
        rbNeutro.setLayoutY((painelAvaliacao.getPrefHeight() - rbNeutro.getPrefHeight())/2);
        
        rbPositivo = new RadioButton("Positivo");
        rbPositivo.setLayoutX((painelAvaliacao.getPrefWidth() - rbNeutro.getPrefWidth())/2 - 120);
        rbPositivo.setLayoutY(rbNeutro.getLayoutY());
        
        rbNegativo = new RadioButton("Positivo");
        rbNegativo.setLayoutX((painelAvaliacao.getPrefWidth() - rbNeutro.getPrefWidth())/2 + 120);
        rbNegativo.setLayoutY(rbNeutro.getLayoutY());
        
        radiosButtons = new ToggleGroup();
        rbNeutro.setToggleGroup(radiosButtons);
        rbPositivo.setToggleGroup(radiosButtons);
        rbNegativo.setToggleGroup(radiosButtons);
        rbPositivo.setSelected(true);
        
        tituloPainelAvaliacao = new Label("Avaliação");
        tituloPainelAvaliacao.setLayoutX(10);
        tituloPainelAvaliacao.setLayoutY(-14);
        
        painelComentario.getChildren().addAll(taComentario, tituloPainelComentario);
        painelAvaliacao.getChildren().addAll(rbNeutro, rbPositivo, rbNegativo, tituloPainelAvaliacao);
        painelPrincipal.getChildren().addAll(painelComentario, painelAvaliacao, bComentar, bVoltar);
        
        Scene cena = new Scene(painelPrincipal);
        stage.setScene(cena);
        stage.show();
    }

    public static Stage getStage() {
        return stage;
    }
    
    private void adicionarComentario() {
        Comentario comentario =  new Comentario();
        //comentario.setAluguel(aluguel);
        comentario.setDataComentario(Calendar.getInstance());
        comentario.setComentario(taComentario.getText());
        
        if(rbPositivo.isSelected()){
            comentario.setAvaliacao(Avaliacao.POSITIVA);
        } else {
            if(rbNeutro.isSelected()){
                comentario.setAvaliacao(Avaliacao.NEUTRA);
            } else {
                comentario.setAvaliacao(Avaliacao.NEGATIVA);
            }
        }
        
        ComentarioDAO dao = new ComentarioDAO();
        dao.addComentario(comentario);
        
        JOptionPane.showMessageDialog(null, "Comentario adicionado");
        
        stage.close();
    }
    
    public static void main(String[] args){
        launch(args);
    }
}