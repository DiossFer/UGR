
package irrgarten.UI;

import irrgarten.modelo.Directions;


public class Cursors extends javax.swing.JDialog {

    private Directions direction;
    
    public Cursors(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
    }

    public Directions getDirection(){
        setVisible(true);
        return direction;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        arriba = new javax.swing.JButton();
        Izquierda = new javax.swing.JButton();
        Derecha = new javax.swing.JButton();
        Abajo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        arriba.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        arriba.setText("↑");
        arriba.setBorderPainted(false);
        arriba.setContentAreaFilled(false);
        arriba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arribaActionPerformed(evt);
            }
        });

        Izquierda.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Izquierda.setText("←");
        Izquierda.setBorderPainted(false);
        Izquierda.setContentAreaFilled(false);
        Izquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IzquierdaActionPerformed(evt);
            }
        });

        Derecha.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Derecha.setText("→");
        Derecha.setBorderPainted(false);
        Derecha.setContentAreaFilled(false);
        Derecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DerechaActionPerformed(evt);
            }
        });

        Abajo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Abajo.setText("↓");
        Abajo.setBorderPainted(false);
        Abajo.setContentAreaFilled(false);
        Abajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbajoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Izquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Derecha, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Abajo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arriba, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 131, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(arriba, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Izquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Derecha, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Abajo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void arribaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arribaActionPerformed
        direction = Directions.UP;
        dispose();
    }//GEN-LAST:event_arribaActionPerformed

    private void IzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IzquierdaActionPerformed
        direction = Directions.LEFT;
        dispose();
    }//GEN-LAST:event_IzquierdaActionPerformed

    private void DerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DerechaActionPerformed
        direction = Directions.RIGHT;
        dispose();
    }//GEN-LAST:event_DerechaActionPerformed

    private void AbajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbajoActionPerformed
        direction = Directions.DOWN;
        dispose();
    }//GEN-LAST:event_AbajoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Abajo;
    private javax.swing.JButton Derecha;
    private javax.swing.JButton Izquierda;
    private javax.swing.JButton arriba;
    // End of variables declaration//GEN-END:variables
}
