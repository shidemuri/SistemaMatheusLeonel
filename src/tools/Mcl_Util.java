/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.io.BufferedInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

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
            if(componente instanceof JTextField) {
                ((JTextField) componente).setText("");
            }
            if(componente instanceof JTextArea) {
                ((JTextArea) componente).setText("");
            }
            
            if(componente instanceof JComboBox) {
                ((JComboBox) componente).setSelectedIndex(0);
            }
            if(componente instanceof JCheckBox) {
                ((JCheckBox) componente).setSelected(false);
            }
        }
    }
    public static boolean mcl_confirmar(String mensagem) {
        return JOptionPane.showConfirmDialog(null, mensagem,"Confirmação", JOptionPane.YES_NO_OPTION) == 0;
    }
    public static String mcl_perguntar(String mensagem) {
        return JOptionPane.showInputDialog(null, mensagem);
    }
    public static void mcl_mensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
    public static void tocarSom(String som){
        try {
            URL stream = new URL(som);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(stream);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    public static int strToInt(String str){
        try {
            return Integer.valueOf(str);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("Falha ao converter para número inteiro: " + str);
        }
    }
    
    public static double strToDouble(String str) {
        try {
            return Double.valueOf(str);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("Falha ao converter para número decimal: " + str);
        }
    }
    public static Date strToDate(String str) {
        try{
            return new Date(str);
        } catch(DateTimeParseException e) {
            throw new IllegalArgumentException("Falha ao converter para data: " + str);
        }
    }
    public static String intToStr(int num) {
        return String.valueOf(num);
    }
    public static String doubleToStr(double num) {
        return String.valueOf(num);
    }
    public static String dateToStr(Date num) {
        return (new SimpleDateFormat("dd/MM/yyyy")).format(num);
    }
}
