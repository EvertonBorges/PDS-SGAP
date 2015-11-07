/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.tabela;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Administrador;

/**
 *
 * @author Wilson
 */
public class TabelaModeloAdministrador extends AbstractTableModel{

    private List<Administrador> admins;
    private String[] campos = {"codigo", "Nome", "Login"};

    public TabelaModeloAdministrador(List<Administrador> admins) {
        this.admins = admins;
    }
    
    @Override
    public int getRowCount() {
        return admins.size();
    }

    @Override
    public int getColumnCount() {
        return campos.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Administrador admin = admins.get(rowIndex);
        switch(columnIndex){
            case 0 : return admin.getCodigo();
            case 1 : return admin.getNome();
            case 2 : return admin.getLogin();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int coluna){
        return campos[coluna];
    }
}
