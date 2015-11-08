/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import dao.AdministradorDAO;
import modelo.Administrador;

/**
 *
 * @author Wilson
 */
public class ExcluirAdmin {
    public static void main(String[] args){
        Administrador admin = new Administrador();
        //admin.setCodigo(1l);
        admin.setNome("Jorge");
        
        AdministradorDAO dao = new AdministradorDAO();
        dao.remover(admin);
        
    }
}
