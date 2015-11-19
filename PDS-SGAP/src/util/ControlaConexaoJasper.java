/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rogeriocarmine
 */
public class ControlaConexaoJasper {
    
    public static Connection getConexao() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/bd_pds_sgap","root","root");
    }

    public static void fecharResultSet(ResultSet resultados) throws Exception{
        if(resultados!=null){
            try{
                resultados.close();
            }catch(SQLException ex){
                System.out.println("Erro: " + ex.getMessage());
            }
        }
    }
    
    
    public static void fecharInstrucao(PreparedStatement instrucao) throws Exception{
        if(instrucao!=null){
            try{
                instrucao.close();
            }catch(SQLException ex){
                System.out.println("Erro: " + ex.getMessage());
            }
        }
    }
    
    public static void fecharInstrucaoStatement(Statement instrucao) throws Exception{
        if(instrucao!=null){
            try{
                instrucao.close();
            }catch(SQLException ex){
                System.out.println("Erro: " + ex.getMessage());
            }
        }
    }
    
    public static void fecharConexao(Connection conexao) throws Exception {
        if(conexao!=null){
            try{
                conexao.close();
            }catch(SQLException ex){
                System.out.println("Erro: " + ex.getMessage());
            }
        }
    }
}