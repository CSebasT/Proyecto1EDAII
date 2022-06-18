package grp7.GUI;

/**
 *
 * @author Nicolas Burbano
 * @author Jhon Maiza
 * @author Cesar Tufino
 */
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import grp7.metodosDeBusqueda.*;

public class Main_gui extends javax.swing.JFrame {

    /**
     * Creates new form home
     */
    DefaultListModel patrones = new DefaultListModel();
    BuscadorPatrones buscador = new BuscadorPatrones();

    public Main_gui() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        TextPanel = new javax.swing.JPanel();
        TextInputScroll = new javax.swing.JScrollPane();
        TextInput = new javax.swing.JTextArea();
        TituloTexto = new javax.swing.JLabel();
        LimpiarTexto = new javax.swing.JButton();
        CargarArchivoTexto = new javax.swing.JButton();
        PatronesPanel = new javax.swing.JPanel();
        InputPatron = new javax.swing.JTextField();
        ListaPatronesScroll = new javax.swing.JScrollPane();
        ListaPatrones = new javax.swing.JList<>();
        AgregarPatron = new javax.swing.JButton();
        RemoverPatron = new javax.swing.JButton();
        TituloPatron = new javax.swing.JLabel();
        AuxPatronesABuscar = new javax.swing.JLabel();
        AuxPatronesIngresar = new javax.swing.JLabel();
        RemoverTodosPatrones = new javax.swing.JButton();
        CargarPatrones = new javax.swing.JButton();
        AlgoritmoPanel = new javax.swing.JPanel();
        Resolver = new javax.swing.JButton();
        TituloAlgoritmo = new javax.swing.JLabel();
        cb_FuerzaBruta = new javax.swing.JCheckBox();
        cb_KMP = new javax.swing.JCheckBox();
        cb_BoyerMoore = new javax.swing.JCheckBox();

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TextPanel.setBackground(new java.awt.Color(66, 124, 255));

        TextInput.setBackground(new java.awt.Color(255, 255, 255));
        TextInput.setColumns(20);
        TextInput.setRows(5);
        TextInputScroll.setViewportView(TextInput);

        TituloTexto.setFont(new java.awt.Font("Candara", 0, 24)); // NOI18N
        TituloTexto.setForeground(new java.awt.Color(0, 0, 0));
        TituloTexto.setText("Texto");

        LimpiarTexto.setBackground(new java.awt.Color(66, 255, 182));
        LimpiarTexto.setForeground(new java.awt.Color(0, 0, 0));
        LimpiarTexto.setText("Limpiar");
        LimpiarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarTexto(evt);
            }
        });

        CargarArchivoTexto.setBackground(new java.awt.Color(66, 255, 182));
        CargarArchivoTexto.setForeground(new java.awt.Color(0, 0, 0));
        CargarArchivoTexto.setText("Cargar Archivo");
        CargarArchivoTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarArchivoTexto(evt);
            }
        });

        javax.swing.GroupLayout TextPanelLayout = new javax.swing.GroupLayout(TextPanel);
        TextPanel.setLayout(TextPanelLayout);
        TextPanelLayout.setHorizontalGroup(
            TextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TextPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(TituloTexto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 306, Short.MAX_VALUE)
                .addComponent(CargarArchivoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LimpiarTexto)
                .addGap(15, 15, 15))
            .addComponent(TextInputScroll)
        );
        TextPanelLayout.setVerticalGroup(
            TextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TextPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(TextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TituloTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LimpiarTexto)
                        .addComponent(CargarArchivoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextInputScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        getContentPane().add(TextPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 300));

        PatronesPanel.setBackground(new java.awt.Color(60, 158, 232));

        InputPatron.setBackground(new java.awt.Color(255, 255, 255));
        InputPatron.setForeground(new java.awt.Color(0, 0, 0));
        InputPatron.setText("patron");
        InputPatron.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                InputPatronFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                InputPatronFocusLost(evt);
            }
        });

        ListaPatrones.setBackground(new java.awt.Color(255, 255, 255));
        ListaPatrones.setForeground(new java.awt.Color(0, 0, 0));
        ListaPatrones.setModel(patrones);
        ListaPatronesScroll.setViewportView(ListaPatrones);

        AgregarPatron.setBackground(new java.awt.Color(66, 255, 182));
        AgregarPatron.setForeground(new java.awt.Color(0, 0, 0));
        AgregarPatron.setText("Agregar");
        AgregarPatron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarPatron(evt);
            }
        });

        RemoverPatron.setBackground(new java.awt.Color(66, 255, 182));
        RemoverPatron.setForeground(new java.awt.Color(0, 0, 0));
        RemoverPatron.setText("Remover");
        RemoverPatron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoverPatronesSelecionados(evt);
            }
        });

        TituloPatron.setFont(new java.awt.Font("Candara", 0, 24)); // NOI18N
        TituloPatron.setForeground(new java.awt.Color(0, 0, 0));
        TituloPatron.setText("Patrones");

        AuxPatronesABuscar.setForeground(new java.awt.Color(0, 0, 0));
        AuxPatronesABuscar.setText("Patrones a buscar:");

        AuxPatronesIngresar.setForeground(new java.awt.Color(0, 0, 0));
        AuxPatronesIngresar.setText("Ingresar patron a buscar:");

        RemoverTodosPatrones.setBackground(new java.awt.Color(66, 255, 182));
        RemoverTodosPatrones.setForeground(new java.awt.Color(0, 0, 0));
        RemoverTodosPatrones.setText("Remover Todos");
        RemoverTodosPatrones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReiniciarListaPatrones(evt);
            }
        });

        CargarPatrones.setBackground(new java.awt.Color(66, 255, 182));
        CargarPatrones.setForeground(new java.awt.Color(0, 0, 0));
        CargarPatrones.setText("Cargar Patrones");
        CargarPatrones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarPatronesDeArchivo(evt);
            }
        });

        javax.swing.GroupLayout PatronesPanelLayout = new javax.swing.GroupLayout(PatronesPanel);
        PatronesPanel.setLayout(PatronesPanelLayout);
        PatronesPanelLayout.setHorizontalGroup(
            PatronesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatronesPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(PatronesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PatronesPanelLayout.createSequentialGroup()
                        .addGroup(PatronesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ListaPatronesScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                            .addComponent(AuxPatronesIngresar)
                            .addComponent(AuxPatronesABuscar)
                            .addComponent(InputPatron))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PatronesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RemoverTodosPatrones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(RemoverPatron, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AgregarPatron, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CargarPatrones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(PatronesPanelLayout.createSequentialGroup()
                        .addComponent(TituloPatron)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PatronesPanelLayout.setVerticalGroup(
            PatronesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatronesPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(TituloPatron)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AuxPatronesIngresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PatronesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InputPatron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgregarPatron))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AuxPatronesABuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PatronesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PatronesPanelLayout.createSequentialGroup()
                        .addComponent(CargarPatrones)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RemoverPatron)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RemoverTodosPatrones))
                    .addComponent(ListaPatronesScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        getContentPane().add(PatronesPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 600, 300));

        AlgoritmoPanel.setBackground(new java.awt.Color(80, 226, 255));

        Resolver.setBackground(new java.awt.Color(66, 255, 183));
        Resolver.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        Resolver.setForeground(new java.awt.Color(0, 0, 0));
        Resolver.setText("Resolver");
        Resolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Resolver(evt);
            }
        });

        TituloAlgoritmo.setFont(new java.awt.Font("Candara", 0, 24)); // NOI18N
        TituloAlgoritmo.setForeground(new java.awt.Color(0, 0, 0));
        TituloAlgoritmo.setText("Algoritmo");

        cb_FuerzaBruta.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        cb_FuerzaBruta.setForeground(new java.awt.Color(0, 0, 0));
        cb_FuerzaBruta.setText("Fuerza Bruta");

        cb_KMP.setBackground(new java.awt.Color(66, 255, 183));
        cb_KMP.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        cb_KMP.setForeground(new java.awt.Color(0, 0, 0));
        cb_KMP.setText("KMP");
        cb_KMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_KMPActionPerformed(evt);
            }
        });

        cb_BoyerMoore.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        cb_BoyerMoore.setForeground(new java.awt.Color(0, 0, 0));
        cb_BoyerMoore.setText("Boyer Moore");

        javax.swing.GroupLayout AlgoritmoPanelLayout = new javax.swing.GroupLayout(AlgoritmoPanel);
        AlgoritmoPanel.setLayout(AlgoritmoPanelLayout);
        AlgoritmoPanelLayout.setHorizontalGroup(
            AlgoritmoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AlgoritmoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AlgoritmoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Resolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(AlgoritmoPanelLayout.createSequentialGroup()
                        .addComponent(TituloAlgoritmo)
                        .addGap(0, 185, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(AlgoritmoPanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(AlgoritmoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_FuerzaBruta)
                    .addComponent(cb_BoyerMoore)
                    .addComponent(cb_KMP, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AlgoritmoPanelLayout.setVerticalGroup(
            AlgoritmoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AlgoritmoPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(TituloAlgoritmo)
                .addGap(18, 18, 18)
                .addComponent(cb_FuerzaBruta)
                .addGap(56, 56, 56)
                .addComponent(cb_BoyerMoore)
                .addGap(54, 54, 54)
                .addComponent(cb_KMP)
                .addGap(90, 90, 90)
                .addComponent(Resolver, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        getContentPane().add(AlgoritmoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 300, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CargarArchivoTexto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarArchivoTexto
        JFileChooser selectorArchivo = new JFileChooser();
        int elegir = selectorArchivo.showOpenDialog(this);
        if (elegir == JFileChooser.APPROVE_OPTION) {
            File archivo = selectorArchivo.getSelectedFile();
            try ( FileReader fr = new FileReader(archivo)) {
                String texto = "";
                int valor = fr.read();
                while (valor != -1) {
                    texto = texto + (char) valor;
                    valor = fr.read();
                }
                TextInput.setText(texto);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_CargarArchivoTexto

    private void AgregarPatron(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarPatron
        patrones.addElement(InputPatron.getText());
        InputPatron.setText("");
    }//GEN-LAST:event_AgregarPatron

    private void InputPatronFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InputPatronFocusLost
        if (InputPatron.getText().equals("")) {
            InputPatron.setText("patron");
        }
    }//GEN-LAST:event_InputPatronFocusLost

    private void InputPatronFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InputPatronFocusGained
        if (InputPatron.getText().equals("patron")) {
            InputPatron.setText("");
        }
    }//GEN-LAST:event_InputPatronFocusGained

    private void RemoverPatronesSelecionados(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverPatronesSelecionados
        if (ListaPatrones.isSelectionEmpty()) {
            return;
        }
        for (Object patron : ListaPatrones.getSelectedValues()) {
            patrones.removeElement(patron);
        }
    }//GEN-LAST:event_RemoverPatronesSelecionados

    private void LimpiarTexto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarTexto
        TextInput.setText("");
    }//GEN-LAST:event_LimpiarTexto

    private void CargarPatronesDeArchivo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarPatronesDeArchivo
        JFileChooser selectorArchivo = new JFileChooser();
        int elegir = selectorArchivo.showOpenDialog(this);
        if (elegir == JFileChooser.APPROVE_OPTION) {
            File archivo = selectorArchivo.getSelectedFile();
            try ( FileReader fr = new FileReader(archivo)) {
                BufferedReader br = new BufferedReader(fr);
                String valor;
                while ((valor = br.readLine()) != null) {
                    patrones.addElement(valor);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_CargarPatronesDeArchivo

    private void ReiniciarListaPatrones(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReiniciarListaPatrones
        patrones.removeAllElements();
    }//GEN-LAST:event_ReiniciarListaPatrones

    private void Resolver(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Resolver
        ArrayList<Algoritmo> algoritmos = new ArrayList<>();
        ArrayList<Resultado> resultados = new ArrayList<>();
        //Validaciones información envia desde GUI
        if (TextInput.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "No se ha ingresado ningun texto");
            return;
        }
        if (patrones.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se ha ingresado ningún patrón");
            return;
        }
        if (cb_FuerzaBruta.isSelected()) {
            algoritmos.add(new FuerzaBruta());
        }
        if (cb_BoyerMoore.isSelected()) {
            algoritmos.add(new BoyerMoore());
        }
        if (cb_KMP.isSelected()) {
            algoritmos.add(new KnuthMorrisPratt());
        }
        if (algoritmos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione almenos un algoritmo");
            return;
        }
        List<String> listaPatrones = Collections.list(patrones.elements());
        //Busca con los algoritmos seleccionados el patron indicado en el texto
        for (Algoritmo algoritmo : algoritmos) {
            resultados.addAll(buscador.getResultado(algoritmo, TextInput.getText(), listaPatrones));
        }
        //Mostrar resultados obtenidos en nuevas ventanas
        for (Resultado resultado : resultados) {
            VentanaResultado ventana = new VentanaResultado(resultado);
            ventana.setVisible(true);
        }
        if (algoritmos.size() <= 1) {return;}
        //Ordenar resultados
        Collections.sort(resultados);
        //Imprime el resumen
        for (String patron : listaPatrones) {
            for (Resultado resultado : resultados) {
                if (resultado.getPatron().equals(patron)) {
                    VentanaResultado ventana = new VentanaResultado(resultado, true);
                    ventana.setVisible(true);
                    break;
                }

            }
        }
    }//GEN-LAST:event_Resolver


    private void cb_KMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_KMPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_KMPActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarPatron;
    private javax.swing.JPanel AlgoritmoPanel;
    private javax.swing.JLabel AuxPatronesABuscar;
    private javax.swing.JLabel AuxPatronesIngresar;
    private javax.swing.JButton CargarArchivoTexto;
    private javax.swing.JButton CargarPatrones;
    private javax.swing.JTextField InputPatron;
    private javax.swing.JButton LimpiarTexto;
    private javax.swing.JList<String> ListaPatrones;
    private javax.swing.JScrollPane ListaPatronesScroll;
    private javax.swing.JPanel PatronesPanel;
    private javax.swing.JButton RemoverPatron;
    private javax.swing.JButton RemoverTodosPatrones;
    private javax.swing.JButton Resolver;
    private javax.swing.JTextArea TextInput;
    private javax.swing.JScrollPane TextInputScroll;
    private javax.swing.JPanel TextPanel;
    private javax.swing.JLabel TituloAlgoritmo;
    private javax.swing.JLabel TituloPatron;
    private javax.swing.JLabel TituloTexto;
    private javax.swing.JCheckBox cb_BoyerMoore;
    private javax.swing.JCheckBox cb_FuerzaBruta;
    private javax.swing.JCheckBox cb_KMP;
    private java.awt.PopupMenu popupMenu1;
    // End of variables declaration//GEN-END:variables
}
