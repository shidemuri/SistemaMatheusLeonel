/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.MclVendasProdutos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import tools.Mcl_Util;

/**
 *
 * @author u42165518822
 */

// https://www.youtube.com/watch?v=f4ZWbDJWtT0

public class Mcl_ControllerVendasProdutos extends AbstractTableModel {
    
    private List<MclVendasProdutos> lista;
    
    public JTextField total;
    
    public void atualizarTotal() {
        double totalnumero = 0;
        for (int i = 0; i < lista.size(); i++) {
            MclVendasProdutos vendaprod = lista.get(i);
            totalnumero = totalnumero + vendaprod.getMclQuantidade() * vendaprod.getMclValorunit();
        }
        total.setText(Mcl_Util.doubleToStr(totalnumero));
    }
    
    public void setList(List<MclVendasProdutos> lista) {
        this.lista = lista;
        atualizarTotal();
    }
    
    public void setTotal(JTextField total) {
        this.total = total;
    }
    
    public void limparLista() {
        setList(new ArrayList());
        fireTableDataChanged();
    }
    
    public MclVendasProdutos getBean(int rowIndex){
        return lista.get(rowIndex);
    }
    public void addBean(MclVendasProdutos bean) {
        lista.add(bean);
        atualizarTotal();
        fireTableDataChanged();
    }
    public void removeBean(int rowIndex) {
        lista.remove(rowIndex);
        atualizarTotal();
        fireTableDataChanged();
    }
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MclVendasProdutos vendas = (MclVendasProdutos) lista.get(rowIndex);
        if(columnIndex == 0){
            return vendas.getMclIdVendasProdutos();
        }
        if(columnIndex == 1){
            return vendas.getMclProdutos().toString();
        }
        if(columnIndex == 2){
            return vendas.getMclQuantidade();
        }
        if(columnIndex == 3){
            return vendas.getMclValorunit();
        }
        if(columnIndex == 4) {
            return vendas.getMclQuantidade() * vendas.getMclValorunit();
        }
        return "";
    }
    
    @Override
    public String getColumnName(int column){
        if(column == 0) return "Código";
        if(column == 1) return "Produto";
        if(column == 2) return "Quantidade";
        if(column == 3) return "Valor Unitário";
        if(column == 4) return "Total";
        return "";
    }
}
