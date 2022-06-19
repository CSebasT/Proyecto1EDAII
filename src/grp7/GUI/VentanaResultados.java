package grp7.GUI;

import grp7.metodosDeBusqueda.Resultado;
import java.util.ArrayList;
import java.util.Collections;

public class VentanaResultados extends javax.swing.JFrame {

    /**
     * Creates new form VentanaResultados
     */
    public VentanaResultados(ArrayList<Resultado> resultados) {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Resultado \"" + resultados.get(0).getPatron() + "\"");
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        String textoDeLaVentana = "";
        for (Resultado resultado : resultados) {
            textoDeLaVentana += resultado.getResultado() + "\n\n";
        }
        if (resultados.size()>1) {
            Collections.sort(resultados);
            textoDeLaVentana += resultados.get(0).toString();
        }
        txpResultado.setText(textoDeLaVentana);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlResultado = new javax.swing.JPanel();
        scrResultado = new javax.swing.JScrollPane();
        txpResultado = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlResultado.setBackground(new java.awt.Color(60, 158, 232));

        txpResultado.setEditable(false);
        scrResultado.setViewportView(txpResultado);

        javax.swing.GroupLayout pnlResultadoLayout = new javax.swing.GroupLayout(pnlResultado);
        pnlResultado.setLayout(pnlResultadoLayout);
        pnlResultadoLayout.setHorizontalGroup(
            pnlResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrResultado, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlResultadoLayout.setVerticalGroup(
            pnlResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrResultado, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pnlResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlResultado;
    private javax.swing.JScrollPane scrResultado;
    private javax.swing.JTextPane txpResultado;
    // End of variables declaration//GEN-END:variables
}
