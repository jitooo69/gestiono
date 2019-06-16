/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.OyenteVista;
import Model.Contenedor;
import Model.Tramite;
import Model.Tupla;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author J_ARANDA
 */
public class ListaTramitesView extends Vista {

    private final OyenteVista oyenteVista;
    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;
    private int pdfCount;
    private String[] listaPdfs;
    private ArrayList<Tramite> listaTramites;
    
    /**
     * Creates new form TramiteView
     */
    public ListaTramitesView(OyenteVista oyenteVista) {
        listaTramites = new ArrayList<>();
        listaPdfs = new String[4];
        pdfCount = 0;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
	this.oyenteVista = oyenteVista;
        
        initComponents();
        //construirTabla();//Construimos la tabla
        setLocationRelativeTo(null);
        setResizable(false);
        //setVisible(true);
    }
    
        public void construirTabla(ArrayList tramites) {
            //this.listaTramites = tramites; //Recibimos la lista desde el servidor
            //contentPane = new JPanel();
            //tabla = new JTable();
            //Contenedor tramites = new Contenedor(1);
            //tramites.introducir(new Tramite(0, "dni1", "o", null, "planes",
            //new Date().toString(), 0, null));
            //String[] cabecera = {"ID","Asunto","Departamento","Fecha","Estado" };
            //DefaultTableModel dtm = new DefaultTableModel(null, columnNames);
            //DefaultTableModel dtm = new DefaultTableModel();
            //dtm.setColumnIdentifiers(cabecera);
        //tabla.setModel(dtm);
            
            //tabla = new JTable(dtm);
            Object[] fila = null;
            ArrayList<Tramite> tramitesEnviados = new ArrayList<>();
            
            //if (tramites != null) {
               //tramites.iniciarRecorrido();
               //while (tramites.haySiguiente()) {
            //Tramite auxTramite = (Tramite) tramites.siguiente();

             /* fila = new Object[]{auxTramite.getId_tramite(),
                                       auxTramite.getAsunto(),
                                       auxTramite.getDepartamento(),
                                       auxTramite.getFecha(),
                                       auxTramite.getEstado()};*/
                   
                   //fila = new Object[]{"1","2","3","4","5"};
                   //tramitesEnviados.add(new Tramite(1, "A", "A", "A", 0));
                   
                   //Object[] datos = new Object[dtm.getColumnCount()];
                   
                    //int i=1;
                    //dtm.setRowCount(0);
                    //for (Pais pais : listaPaises) {
                        /*datos[0] = 0;
                        datos[1] = "Q";
                        datos[2] = "Q";
                        datos[3] = "Q";
                        datos[4] = "Q";*/
                        //i++;
                        //dtm.addRow(datos);            
                    //}
                    //tabla.setModel(dtm);
                   
              //((DefaultTableModel) tabla.getModel()).insertRow(tabla.getRowCount(),fila);
               //}
               
               DefaultTableModel model = (DefaultTableModel) tabla.getModel();
               model.setRowCount(0);
               
               for (Object tramite : tramites) {
                    model.addRow(new Object[]{ ((Tramite)tramite).getId_tramite(), 
                                               ((Tramite)tramite).getAsunto(), 
                                               ((Tramite)tramite).getDepartamento(),
                                               ((Tramite)tramite).getFecha(),
                                               ((Tramite)tramite).getEstado()});
               }
              

                       
               //add(tabla);  
               //tabla.setPreferredScrollableViewportSize(new Dimension(480, 100));
               //tabla.setFillsViewportHeight(true);
               //contentPane.add(new JScrollPane(tabla));


            /*} else {
              JLabel label1 = new JLabel("No posees préstamos");
              label1.setFont(new Font(label1.getFont().getName(), label1.getFont().getStyle(), 20));
              label1.setPreferredSize(new Dimension(400, 60));
              contentPane.add(label1);
            }*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(57, 62, 70));

        jPanel1.setBackground(new java.awt.Color(57, 62, 70));
        jPanel1.setForeground(new java.awt.Color(57, 62, 70));
        jPanel1.setToolTipText("");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoNew.png"))); // NOI18N
        jLabel1.setToolTipText("");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/divider.png"))); // NOI18N

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Asunto", "Departamento", "Fecha", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Login");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setText("Registrar nuevo trámite");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        oyenteVista.notificacion(OyenteVista.Evento.PANTALLA_LOGIN, null);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       oyenteVista.notificacion(OyenteVista.Evento.EXIT, null);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        oyenteVista.notificacion(OyenteVista.Evento.REGISTRAR_TRAMITE, null);
    }//GEN-LAST:event_jMenuItem3ActionPerformed
 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaTramitesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaTramitesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaTramitesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaTramitesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new TramiteView().setVisible(true);
            }
        });
    }
    
    public void ocultar() {
        setVisible(false);
    }
    public void mostrar() {
        setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables


}
