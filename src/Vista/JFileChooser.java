package Vista;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jorgearanda
 */
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
 
public class JFileChooser extends JFrame {
 
    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;
 
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFileChooser frame = new JFileChooser();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
 
    /**
     * Create the frame.
     */
    public JFileChooser() {
 
        //Parametros asociados a la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);
 
        textField = new JTextField();
        textField.setToolTipText("Inserta la ruta del fichero de audio");
        textField.setBounds(52, 26, 209, 20);
        contentPane.add(textField);
        textField.setColumns(10);
 
        JButton btnSeleccionar = new JButton("Seleccionar...");
        btnSeleccionar.setBounds(288, 25, 109, 23);
        contentPane.add(btnSeleccionar);
 
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBounds(52, 76, 360, 156);
 
        JScrollPane scroll=new JScrollPane(textArea);
        scroll.setBounds(52, 76, 360, 156);
        contentPane.add(scroll);
 
        btnSeleccionar.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
 
            }
        });
 
    }
}
