/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.MclVendedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u42165518822
 */
public class Mcl_ControllerVendedor extends AbstractTableModel {
    List lista;
    public void setlist(List lista){
        this.lista = lista;
    }
    public Object getBean(int rowIndex){
        return lista.get(rowIndex);
    }
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MclVendedor vendedor = (MclVendedor) lista.get(rowIndex);
        if(columnIndex == 0){
            return vendedor.getMclIdVendedor();
        }
        if(columnIndex == 1){
            return vendedor.getMclNome();
        }
        if(columnIndex == 2){
            return vendedor.getMclEndereco();
        }
        if(columnIndex == 3){
            return vendedor.getMclCnpj();
        }
        return "";
    }
    
    @Override
    public String getColumnName(int column){
        if(column == 0) return "Código";
        if(column == 1) return "Nome";
        if(column == 2) return "Endereço";
        if(column == 3) return "CNPJ";
        return"";
    }
}
