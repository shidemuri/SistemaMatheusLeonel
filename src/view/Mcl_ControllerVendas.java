/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.MclVendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class Mcl_ControllerVendas extends AbstractTableModel {
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
        MclVendas vendas = (MclVendas) lista.get(rowIndex);
        if(columnIndex == 0){
            return vendas.getMclIdVendas();
        }
        if(columnIndex == 1){
            return vendas.getMclDataVenda();
        }
        if(columnIndex == 2){
            return vendas.getMclClientes().toString();
        }
        if(columnIndex == 3){
            return vendas.getMclTotal();
        }
        return "";
    }
    
    @Override
    public String getColumnName(int column){
        if(column == 0) return "Código";
        if(column == 1) return "Data da venda";
        if(column == 2) return "Cliente";
        if(column == 3) return "Total";
        return"";
    }
}
