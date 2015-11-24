package util;

import javax.swing.JLabel;
import modelo.Aluguel;
import modelo.Produto;
import modelo.SolicitacaoAluguel;

public class FormatadorTelefone {
    
    public static void preencherTelefones(SolicitacaoAluguel solicitacao, JLabel labelContato){
        if (!solicitacao.getProduto().getCondomino().getTelefones().isEmpty()) {
            JLabel tfTelefone = labelContato;
            String telefone = solicitacao.getProduto().getCondomino().getTelefones().get(0);
            if (telefone.length() < 10) {
                if (telefone.length() == 9) {
                    String telefoneFormatado = telefone.substring(0,5) + "-" + telefone.substring(5,9);
                    tfTelefone.setText(telefoneFormatado);
                } else {
                    String telefoneFormatado = telefone.substring(0,4) + "-" + telefone.substring(4,8);
                    tfTelefone.setText(telefoneFormatado);
                }
            } else {
                if (telefone.length() == 11) {
                    String telefoneFormatado = "(" + telefone.substring(0,2) + ") " + telefone.substring(2,7) + "-" + telefone.substring(7,11);
                    tfTelefone.setText(telefoneFormatado);
                } else {
                    String telefoneFormatado = "(" + telefone.substring(0,2) + ") " + telefone.substring(2,6) + "-" + telefone.substring(6,10);
                    tfTelefone.setText(telefoneFormatado);
                }
            }
        }
    }
    
    public static void preencherTelefones(Aluguel aluguel, JLabel labelContato){
        if (!aluguel.getSolicitacaoAluguel().getProduto().getCondomino().getTelefones().isEmpty()) {
            JLabel tfTelefone = labelContato;
            String telefone = aluguel.getSolicitacaoAluguel().getProduto().getCondomino().getTelefones().get(0);
            if (telefone.length() < 10) {
                if (telefone.length() == 9) {
                    String telefoneFormatado = telefone.substring(0,5) + "-" + telefone.substring(5,9);
                    tfTelefone.setText(telefoneFormatado);
                } else {
                    String telefoneFormatado = telefone.substring(0,4) + "-" + telefone.substring(4,8);
                    tfTelefone.setText(telefoneFormatado);
                }
            } else {
                if (telefone.length() == 11) {
                    String telefoneFormatado = "(" + telefone.substring(0,2) + ") " + telefone.substring(2,7) + "-" + telefone.substring(7,11);
                    tfTelefone.setText(telefoneFormatado);
                } else {
                    String telefoneFormatado = "(" + telefone.substring(0,2) + ") " + telefone.substring(2,6) + "-" + telefone.substring(6,10);
                    tfTelefone.setText(telefoneFormatado);
                }
            }
        }
    }
    
    public static void preencherTelefones(Produto produto, JLabel tfContato1, JLabel tfContato2, JLabel tfContato3){
        tfContato1.setText("S/ Telefone");
        tfContato2.setText("");
        tfContato3.setText("");
        if (!produto.getCondomino().getTelefones().isEmpty()) {
            int cont = 0;
            for (String telefone: produto.getCondomino().getTelefones()) {
                JLabel tfTelefone;
                switch (cont) {
                    case 0:  tfTelefone = tfContato1;
                             break;
                    case 1:  tfTelefone = tfContato2;
                             break;
                    default: tfTelefone = tfContato3;
                             break;
                }
                
                if (cont != (produto.getCondomino().getTelefones().size())) {
                    if (telefone.length() < 10) {
                        if (telefone.length() == 9) {
                            String telefoneFormatado = telefone.substring(0,5) + "-" + telefone.substring(5,9);
                            tfTelefone.setText(telefoneFormatado);
                        } else {
                            String telefoneFormatado = telefone.substring(0,4) + "-" + telefone.substring(4,8);
                            tfTelefone.setText(telefoneFormatado);
                        }
                    } else {
                        if (telefone.length() == 11) {
                            String telefoneFormatado = "(" + telefone.substring(0,2) + ") " + telefone.substring(2,7) + "-" + telefone.substring(7,11);
                            tfTelefone.setText(telefoneFormatado);
                        } else {
                            String telefoneFormatado = "(" + telefone.substring(0,2) + ") " + telefone.substring(2,6) + "-" + telefone.substring(6,10);
                            tfTelefone.setText(telefoneFormatado);
                        }
                    }
                } else {
                    if (telefone.length() < 10) {
                        if (telefone.length() == 9) {
                            String telefoneFormatado = telefone.substring(0,5) + "-" + telefone.substring(5,9) + " /";
                            tfTelefone.setText(telefoneFormatado);
                        } else {
                            String telefoneFormatado = telefone.substring(0,4) + "-" + telefone.substring(4,8) + " /";
                            tfTelefone.setText(telefoneFormatado);
                        }
                    } else {
                        if (telefone.length() == 12) {
                            String telefoneFormatado = "(" + telefone.substring(0,2) + ") " + telefone.substring(2,7) + "-" + telefone.substring(7,11) + " /";
                            tfTelefone.setText(telefoneFormatado);
                        } else {
                            String telefoneFormatado = "(" + telefone.substring(0,2) + ") " + telefone.substring(2,6) + "-" + telefone.substring(6,10) + " /";
                            tfTelefone.setText(telefoneFormatado);
                        }
                    }
                }
                cont++;
            }
        }
    }
}
