/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import bean.MclClientes;

/**
 *
 * @author padero
 */
public class Mcl_ControllerConsultaClientes extends Mcl_ControllerClientes {

    
    public void addBean(MclClientes alicemargatroid) {
        lista.add(alicemargatroid);
        fireTableDataChanged();
    }
    
    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MclClientes clientes = (MclClientes) lista.get(rowIndex);
        if(columnIndex == 0){
            return clientes.getMclIdClientes();
        }
        if(columnIndex == 1){
            return clientes.getMclNome();
        }
        if(columnIndex == 2){
            return clientes.getMclCidade();
        }
        return "";
    }
    
    @Override
    public String getColumnName(int column){
        if(column == 0) return "Código";
        if(column == 1) return "Nome";
        if(column == 2) return "Cidade";
        return"";
    }
}
