/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author u42165518822
 */
public class Mcl_Util {
    public static void mcl_habilitar(boolean valor, JComponent ... componentes) {
        for (JComponent componente : componentes) {
            componente.setEnabled(valor);
        }
    }
    public static void mcl_limpar(JComponent ... componentes) {
        for (JComponent componente : componentes) {
            if(componente instanceof JTextField jTextField) {
                jTextField.setText("");
            }
            if(componente instanceof JComboBox jComboBox) {
                jComboBox.setSelectedIndex(0);
            }
            if(componente instanceof JCheckBox jCheckBox) {
                jCheckBox.setSelected(false);
            }
        }
    }
    public static boolean mcl_confirmar(String mensagem) {
        return JOptionPane.showConfirmDialog(null, mensagem,"Confirmação", JOptionPane.YES_NO_OPTION) == 0;
    }
    public static String mcl_perguntar(String mensagem) {
        return JOptionPane.showInputDialog(null, mensagem);
    }
}
