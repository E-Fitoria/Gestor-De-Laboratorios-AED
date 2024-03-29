
package Laboratorio4;

//import Clases.Cola;

import java.awt.Color;
import javax.swing.JOptionPane;


/**
 *
 * @author Usuario
 */
public class PanelLab4Colas extends javax.swing.JPanel {
    
    Cola cola1 = new Cola();
    /**
     * Creates new form PanelColas
     */
    public PanelLab4Colas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtextIngresa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textCola = new javax.swing.JList<>();
        btn_Encolar = new javax.swing.JButton();
        btn_DesColar = new javax.swing.JButton();

        setBackground(new java.awt.Color(232, 232, 232));

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel1.setText("Ingrese: ");

        textCola.setFont(new java.awt.Font("Consolas", 2, 12)); // NOI18N
        jScrollPane1.setViewportView(textCola);

        btn_Encolar.setBackground(new java.awt.Color(216, 216, 216));
        btn_Encolar.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        btn_Encolar.setText("Encolar");
        btn_Encolar.setBorderPainted(false);
        btn_Encolar.setContentAreaFilled(false);
        btn_Encolar.setFocusable(false);
        btn_Encolar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Encolar.setOpaque(true);
        btn_Encolar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_EncolarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_EncolarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_EncolarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_EncolarMouseReleased(evt);
            }
        });
        btn_Encolar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EncolarActionPerformed(evt);
            }
        });

        btn_DesColar.setBackground(new java.awt.Color(216, 216, 216));
        btn_DesColar.setFont(new java.awt.Font("Consolas", 1, 15)); // NOI18N
        btn_DesColar.setText("DesColar");
        btn_DesColar.setBorderPainted(false);
        btn_DesColar.setContentAreaFilled(false);
        btn_DesColar.setFocusable(false);
        btn_DesColar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_DesColar.setOpaque(true);
        btn_DesColar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_DesColarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_DesColarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_DesColarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_DesColarMouseReleased(evt);
            }
        });
        btn_DesColar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DesColarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtextIngresa, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btn_Encolar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_DesColar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtextIngresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btn_Encolar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_DesColar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_EncolarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EncolarMouseEntered
        btn_Encolar.setBackground(new Color(59, 89, 152));
    }//GEN-LAST:event_btn_EncolarMouseEntered

    private void btn_EncolarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EncolarMouseExited
        btn_Encolar.setBackground(new Color(226,226,226));
    }//GEN-LAST:event_btn_EncolarMouseExited

    private void btn_EncolarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EncolarMousePressed
        btn_Encolar.setBackground(new Color(1,50,170));
    }//GEN-LAST:event_btn_EncolarMousePressed

    private void btn_EncolarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EncolarMouseReleased
        btn_Encolar.setBackground(new Color(226,226,226));
    }//GEN-LAST:event_btn_EncolarMouseReleased

    private void btn_EncolarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EncolarActionPerformed

        // TODO add your handling code here:
        String cadena = jtextIngresa.getText();
        
        if(cadena.isEmpty())
        {
            JOptionPane.showMessageDialog(null,"No ingrese valores vacíos");
            return;
        }
        
        jtextIngresa.setText(null);
        cola1.Insertar(cadena);
        
        String colaCadena = cola1.mostrarCola();
        
            String[] colaArr = colaCadena.split("-");
        
            textCola.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = colaArr;

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
    }//GEN-LAST:event_btn_EncolarActionPerformed

    private void btn_DesColarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DesColarMouseEntered
        btn_DesColar.setBackground(new Color(59, 89, 152));
    }//GEN-LAST:event_btn_DesColarMouseEntered

    private void btn_DesColarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DesColarMouseExited
        btn_DesColar.setBackground(new Color(226,226,226));
    }//GEN-LAST:event_btn_DesColarMouseExited

    private void btn_DesColarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DesColarMousePressed
        btn_DesColar.setBackground(new Color(1,50,170));
    }//GEN-LAST:event_btn_DesColarMousePressed

    private void btn_DesColarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DesColarMouseReleased
        btn_DesColar.setBackground(new Color(226,226,226));
    }//GEN-LAST:event_btn_DesColarMouseReleased

    private void btn_DesColarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DesColarActionPerformed
        
        try{
        
            cola1.Quitar();
            String colaCadena = cola1.mostrarCola();

            String[] colaArr = colaCadena.split("-");

            textCola.setModel(new javax.swing.AbstractListModel<String>() {
                String[] strings = colaArr;

                public int getSize() {
                    return strings.length;
                }

                public String getElementAt(int i) {
                    return strings[i];
                }
            });
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"La cola está vacía, encole valores");
        }
    }//GEN-LAST:event_btn_DesColarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_DesColar;
    private javax.swing.JButton btn_Encolar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtextIngresa;
    private javax.swing.JList<String> textCola;
    // End of variables declaration//GEN-END:variables
}
