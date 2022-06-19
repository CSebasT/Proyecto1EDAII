package grp7.GUI;

import grp7.archivosJSON.CargadorArchivosJSON;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.nio.charset.StandardCharsets;

import grp7.metodosDeBusqueda.*;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MainGui extends javax.swing.JFrame {

    DefaultListModel patrones = new DefaultListModel();
    BuscadorPatrones buscador = new BuscadorPatrones();
    CargadorArchivosJSON cargadorArchivosJSON = new CargadorArchivosJSON();

    /**
     * Creates new form home
     */
    public MainGui() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Busqueda de patrones");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pmnMenu1 = new java.awt.PopupMenu();
        pnlTexto = new javax.swing.JPanel();
        scrTextInputScroll = new javax.swing.JScrollPane();
        txaTextInput = new javax.swing.JTextArea();
        lblTituloTexto = new javax.swing.JLabel();
        btnLimpiarTexto = new javax.swing.JButton();
        btnCargarArchivoTexto = new javax.swing.JButton();
        pnlPatrones = new javax.swing.JPanel();
        txtInputPatron = new javax.swing.JTextField();
        scrListaPatronesScroll = new javax.swing.JScrollPane();
        lstListaPatrones = new javax.swing.JList<>();
        btnAgregarPatron = new javax.swing.JButton();
        btnRemoverPatron = new javax.swing.JButton();
        lblTituloPatron = new javax.swing.JLabel();
        lblAuxPatronesABuscar = new javax.swing.JLabel();
        lblAuxPatronesIngresar = new javax.swing.JLabel();
        btnRemoverTodosPatrones = new javax.swing.JButton();
        btnCargarPatrones = new javax.swing.JButton();
        pnlAlgoritmo = new javax.swing.JPanel();
        btnResolver = new javax.swing.JButton();
        lblTituloAlgoritmo = new javax.swing.JLabel();
        chkFuerzaBruta = new javax.swing.JCheckBox();
        chkKMP = new javax.swing.JCheckBox();
        chkBoyerMoore = new javax.swing.JCheckBox();

        pmnMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTexto.setBackground(new java.awt.Color(66, 124, 255));

        txaTextInput.setColumns(20);
        txaTextInput.setRows(5);
        scrTextInputScroll.setViewportView(txaTextInput);

        lblTituloTexto.setFont(new java.awt.Font("Candara", 0, 24)); // NOI18N
        lblTituloTexto.setText("Texto");

        btnLimpiarTexto.setBackground(new java.awt.Color(66, 255, 182));
        btnLimpiarTexto.setText("Limpiar");
        btnLimpiarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarTexto(evt);
            }
        });

        btnCargarArchivoTexto.setBackground(new java.awt.Color(66, 255, 182));
        btnCargarArchivoTexto.setText("Cargar Archivo");
        btnCargarArchivoTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarArchivoTexto(evt);
            }
        });

        javax.swing.GroupLayout pnlTextoLayout = new javax.swing.GroupLayout(pnlTexto);
        pnlTexto.setLayout(pnlTextoLayout);
        pnlTextoLayout.setHorizontalGroup(
            pnlTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTextoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblTituloTexto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 306, Short.MAX_VALUE)
                .addComponent(btnCargarArchivoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiarTexto)
                .addGap(15, 15, 15))
            .addComponent(scrTextInputScroll)
        );
        pnlTextoLayout.setVerticalGroup(
            pnlTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTextoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTituloTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLimpiarTexto)
                        .addComponent(btnCargarArchivoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrTextInputScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        getContentPane().add(pnlTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 300));

        pnlPatrones.setBackground(new java.awt.Color(60, 158, 232));

        txtInputPatron.setText("patron");
        txtInputPatron.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtInputPatronFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtInputPatronFocusLost(evt);
            }
        });

        lstListaPatrones.setModel(patrones);
        scrListaPatronesScroll.setViewportView(lstListaPatrones);

        btnAgregarPatron.setBackground(new java.awt.Color(66, 255, 182));
        btnAgregarPatron.setText("Agregar");
        btnAgregarPatron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPatron(evt);
            }
        });

        btnRemoverPatron.setBackground(new java.awt.Color(66, 255, 182));
        btnRemoverPatron.setText("Remover");
        btnRemoverPatron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerPatronesSelecionados(evt);
            }
        });

        lblTituloPatron.setFont(new java.awt.Font("Candara", 0, 24)); // NOI18N
        lblTituloPatron.setText("Patrones");

        lblAuxPatronesABuscar.setText("Patrones a buscar:");

        lblAuxPatronesIngresar.setText("Ingresar patron a buscar:");

        btnRemoverTodosPatrones.setBackground(new java.awt.Color(66, 255, 182));
        btnRemoverTodosPatrones.setText("Remover Todos");
        btnRemoverTodosPatrones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reiniciarListaPatrones(evt);
            }
        });

        btnCargarPatrones.setBackground(new java.awt.Color(66, 255, 182));
        btnCargarPatrones.setText("Cargar Patrones");
        btnCargarPatrones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarArchivoPatrones(evt);
            }
        });

        javax.swing.GroupLayout pnlPatronesLayout = new javax.swing.GroupLayout(pnlPatrones);
        pnlPatrones.setLayout(pnlPatronesLayout);
        pnlPatronesLayout.setHorizontalGroup(
            pnlPatronesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPatronesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlPatronesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPatronesLayout.createSequentialGroup()
                        .addGroup(pnlPatronesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(scrListaPatronesScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                            .addComponent(lblAuxPatronesIngresar)
                            .addComponent(lblAuxPatronesABuscar)
                            .addComponent(txtInputPatron))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPatronesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRemoverTodosPatrones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(btnRemoverPatron, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregarPatron, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCargarPatrones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlPatronesLayout.createSequentialGroup()
                        .addComponent(lblTituloPatron)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlPatronesLayout.setVerticalGroup(
            pnlPatronesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPatronesLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lblTituloPatron)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAuxPatronesIngresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPatronesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInputPatron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarPatron))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAuxPatronesABuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPatronesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlPatronesLayout.createSequentialGroup()
                        .addComponent(btnCargarPatrones)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRemoverPatron)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoverTodosPatrones))
                    .addComponent(scrListaPatronesScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        getContentPane().add(pnlPatrones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 600, 300));

        pnlAlgoritmo.setBackground(new java.awt.Color(80, 226, 255));

        btnResolver.setBackground(new java.awt.Color(66, 255, 183));
        btnResolver.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        btnResolver.setText("Resolver");
        btnResolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resolver(evt);
            }
        });

        lblTituloAlgoritmo.setFont(new java.awt.Font("Candara", 0, 24)); // NOI18N
        lblTituloAlgoritmo.setText("Algoritmo");

        chkFuerzaBruta.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        chkFuerzaBruta.setText("Fuerza Bruta");

        chkKMP.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        chkKMP.setText("KMP");

        chkBoyerMoore.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        chkBoyerMoore.setText("Boyer Moore");

        javax.swing.GroupLayout pnlAlgoritmoLayout = new javax.swing.GroupLayout(pnlAlgoritmo);
        pnlAlgoritmo.setLayout(pnlAlgoritmoLayout);
        pnlAlgoritmoLayout.setHorizontalGroup(
            pnlAlgoritmoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAlgoritmoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAlgoritmoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnResolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlAlgoritmoLayout.createSequentialGroup()
                        .addComponent(lblTituloAlgoritmo)
                        .addGap(0, 185, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnlAlgoritmoLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(pnlAlgoritmoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chkFuerzaBruta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chkBoyerMoore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chkKMP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        pnlAlgoritmoLayout.setVerticalGroup(
            pnlAlgoritmoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAlgoritmoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTituloAlgoritmo)
                .addGap(18, 18, 18)
                .addComponent(chkFuerzaBruta)
                .addGap(56, 56, 56)
                .addComponent(chkBoyerMoore)
                .addGap(54, 54, 54)
                .addComponent(chkKMP)
                .addGap(90, 90, 90)
                .addComponent(btnResolver, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(pnlAlgoritmo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 300, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarArchivoTexto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarArchivoTexto
        JFileChooser selectorArchivo = new JFileChooser();
        int elegir = selectorArchivo.showOpenDialog(this);
        if (elegir == JFileChooser.APPROVE_OPTION) {
            try {
                File archivo = selectorArchivo.getSelectedFile();
                String texto = "";
                FileInputStream fis = new FileInputStream(archivo);
                //Mediante el InputStreamReader s leen archivos en codificación UTF-8 (incluye caracteres no ASCII).
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
                String linea;
                while ((linea = br.readLine()) != null) {
                    texto += linea + "\n";
                }
                txaTextInput.setText(texto);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_cargarArchivoTexto

    private void agregarPatron(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPatron
        patrones.addElement(txtInputPatron.getText());
        txtInputPatron.setText("");
    }//GEN-LAST:event_agregarPatron

    private void txtInputPatronFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtInputPatronFocusLost
        if (txtInputPatron.getText().equals("")) {
            txtInputPatron.setText("patron");
        }
    }//GEN-LAST:event_txtInputPatronFocusLost

    private void txtInputPatronFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtInputPatronFocusGained
        if (txtInputPatron.getText().equals("patron")) {
            txtInputPatron.setText("");
        }
    }//GEN-LAST:event_txtInputPatronFocusGained

    private void removerPatronesSelecionados(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerPatronesSelecionados
        if (lstListaPatrones.isSelectionEmpty()) {
            return;
        }
        for (Object patron : lstListaPatrones.getSelectedValues()) {
            patrones.removeElement(patron);
        }
    }//GEN-LAST:event_removerPatronesSelecionados

    private void limpiarTexto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarTexto
        txaTextInput.setText("");
    }//GEN-LAST:event_limpiarTexto

    private void cargarArchivoPatrones(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarArchivoPatrones
        JFileChooser selectorArchivo = new JFileChooser();
        int elegir = selectorArchivo.showOpenDialog(this);
        if (elegir == JFileChooser.APPROVE_OPTION) {
            try {
                File archivo = selectorArchivo.getSelectedFile();
                //Comprueba la extensión del archivo.
                String nombreArchivo = archivo.getName();
                String extension = "";
                int i = nombreArchivo.lastIndexOf('.');
                if (i > 0) {
                    extension = nombreArchivo.substring(i + 1);
                }
                //Si el archivo es JSON se tendrá un procesamiento diferente.
                if (extension.equals("json")) {
                    ArrayList<String> arregloPatrones = cargadorArchivosJSON.cargarArchivoPatronesJSON(archivo);
                    if (arregloPatrones != null) {
                        for (String patron : arregloPatrones) {
                            patrones.addElement(patron);
                        }
                        return;
                    }
                }
                //Procesamiento para cualquier otro tipo de archivo.
                FileInputStream fis = new FileInputStream(archivo);
                //Mediante el InputStreamReader s leen archivos en codificación UTF-8.
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
                String valor;
                while ((valor = br.readLine()) != null) {
                    patrones.addElement(valor);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_cargarArchivoPatrones

    private void reiniciarListaPatrones(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reiniciarListaPatrones
        patrones.removeAllElements();
    }//GEN-LAST:event_reiniciarListaPatrones

    private void resolver(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resolver
        ArrayList<Resultado> resultados = new ArrayList<>();
        ArrayList<String> resumenResultados = new ArrayList<>();
        ArrayList<AlgoritmoDeCoindicencias> algoritmos = new ArrayList<>();
        //Validaciones información envia desde GUI
        if (txaTextInput.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "No se ha ingresado ningun texto");
            return;
        }
        if (patrones.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se ha ingresado ningún patrón");
            return;
        }
        if (chkFuerzaBruta.isSelected()) {
            algoritmos.add(new FuerzaBruta());
        }
        if (chkBoyerMoore.isSelected()) {
            algoritmos.add(new BoyerMoore());
        }
        if (chkKMP.isSelected()) {
            algoritmos.add(new KnuthMorrisPratt());
        }
        if (algoritmos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione almenos un algoritmo");
            return;
        }
        List<String> listaPatrones = Collections.list(patrones.elements());
        //Busca con los algoritmos seleccionados el patron indicado en el texto
        for (String patron : listaPatrones) {
            resultados.addAll(buscador.getResultado(algoritmos, txaTextInput.getText(), patron));
            VentanaResultados ventana = new VentanaResultados(resultados);
            ventana.setVisible(true);
            resultados.clear();
        }
    }//GEN-LAST:event_resolver

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPatron;
    private javax.swing.JButton btnCargarArchivoTexto;
    private javax.swing.JButton btnCargarPatrones;
    private javax.swing.JButton btnLimpiarTexto;
    private javax.swing.JButton btnRemoverPatron;
    private javax.swing.JButton btnRemoverTodosPatrones;
    private javax.swing.JButton btnResolver;
    private javax.swing.JCheckBox chkBoyerMoore;
    private javax.swing.JCheckBox chkFuerzaBruta;
    private javax.swing.JCheckBox chkKMP;
    private javax.swing.JLabel lblAuxPatronesABuscar;
    private javax.swing.JLabel lblAuxPatronesIngresar;
    private javax.swing.JLabel lblTituloAlgoritmo;
    private javax.swing.JLabel lblTituloPatron;
    private javax.swing.JLabel lblTituloTexto;
    private javax.swing.JList<String> lstListaPatrones;
    private java.awt.PopupMenu pmnMenu1;
    private javax.swing.JPanel pnlAlgoritmo;
    private javax.swing.JPanel pnlPatrones;
    private javax.swing.JPanel pnlTexto;
    private javax.swing.JScrollPane scrListaPatronesScroll;
    private javax.swing.JScrollPane scrTextInputScroll;
    private javax.swing.JTextArea txaTextInput;
    private javax.swing.JTextField txtInputPatron;
    // End of variables declaration//GEN-END:variables
}
