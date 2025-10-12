/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.MclUsuarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u42165518822
 */
public class Mcl_ControllerUsuarios extends AbstractTableModel {
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
        MclUsuarios usuarios = (MclUsuarios) lista.get(rowIndex);
        if(columnIndex == 0){
            return usuarios.getMclIdUsuarios();
        }
        if(columnIndex == 1){
            return usuarios.getMclNome();
        }
        if(columnIndex == 2){
            return usuarios.getMclApelido();
        }
        if(columnIndex == 3){
            return usuarios.getMclCpf();
        }
        return "";
    }
    
    @Override
    public String getColumnName(int column){
        if(column == 0) return "Código";
        if(column == 1) return "Nome";
        if(column == 2) return "Apelido";
        if(column == 3) return "CPF";
        return"";
    }
}
