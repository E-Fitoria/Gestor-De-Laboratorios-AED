/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Laboratorio3;

import static Laboratorio3.AlgoritmosRecursivos.Calculo;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class PanelLab3Ejercicio5 extends javax.swing.JPanel {
    
    DefaultTableModel modelo =  new DefaultTableModel();
    /**
     * Creates new form PanelLab3Ejercicio5
     */
    public PanelLab3Ejercicio5() {
        initComponents();
        CrearColumnas();
        CrearFilas();
    }
    
    public void CrearColumnas()
    {
        modelo.addColumn("Año");
        modelo.addColumn("Cuenta Pedro");
        modelo.addColumn("Cuenta Juan");
        
        jTable1.setModel(modelo);
    }
    
    public void CrearFilas(){
            
            double cuentaPedro = 400.0;
            double interesPedro = 4.0;

            double cuentaJuan = 500.0;
            double interesJuan = 2.3;

            int year = 2021;

            String arreglo[][] = new String[6][3];

            arreglo[0][0] = "Año";
            arreglo[0][1] = "Pedro";
            arreglo[0][2] = "Juan";

            arreglo = Calculo(cuentaPedro, interesPedro, cuentaJuan, interesJuan, year, 1.0, 1, 0, arreglo);
            
            
            ArrayList<Object[]>info = new ArrayList<Object[]>();
            
            Object[] fila1 = new Object[]{arreglo[1][0],arreglo[1][1],arreglo[1][2]};
            Object[] fila2 = new Object[]{arreglo[2][0],arreglo[2][1],arreglo[2][2]};
            Object[] fila3 = new Object[]{arreglo[3][0],arreglo[3][1],arreglo[3][2]};
            Object[] fila4 = new Object[]{arreglo[4][0],arreglo[4][1],arreglo[4][2]}; 
            Object[] fila5 = new Object[]{arreglo[5][0],arreglo[5][1],arreglo[5][2]};
                     
            info.add(fila1);
            info.add(fila2);
            info.add(fila3);
            info.add(fila4);
            info.add(fila5);
            
            for (Object[] informacion: info)
            {
                modelo.addRow(informacion);
            }
         
            jTable1.setModel(modelo);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(232, 232, 232));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
