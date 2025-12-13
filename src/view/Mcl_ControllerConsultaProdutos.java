/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import bean.MclProdutos;

/**
 *
 * @author padero
 */
public class Mcl_ControllerConsultaProdutos extends Mcl_ControllerProdutos {

    
    public void addBean(MclProdutos alicemargatroid) {
        lista.add(alicemargatroid);
        fireTableDataChanged();
    }
    
    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MclProdutos clientes = (MclProdutos) lista.get(rowIndex);
        if(columnIndex == 0){
            return clientes.getMclIdProdutos();
        }
        if(columnIndex == 1){
            return clientes.getMclModelo();
        }
        if(columnIndex == 2){
            return clientes.getMclPreco();
        }
        return "";
    }
    
    @Override
    public String getColumnName(int column){
        if(column == 0) return "Código";
        if(column == 1) return "Modelo";
        if(column == 2) return "Valor unitário";
        return"";
    }
}
