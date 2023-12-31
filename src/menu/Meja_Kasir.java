/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package menu;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Model_Meja;

/**
 *
 * @author fauzanramadhana
 */
public class Meja_Kasir extends javax.swing.JPanel {
    
    private DefaultTableModel table = new DefaultTableModel();
    private Model_Meja mj = new Model_Meja();
    /**
     * Creates new form Menu_Meja
     */
    public Meja_Kasir() {
        initComponents();
        DataMeja.setModel(table);
        
        table.addColumn("No Meja");
        table.addColumn("Status");
        loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        DataMenuMeja = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DataMeja = new javax.swing.JTable();

        setLayout(new java.awt.CardLayout());

        MainPanel.setLayout(new java.awt.CardLayout());

        DataMeja.setAutoCreateRowSorter(true);
        DataMeja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(DataMeja);

        javax.swing.GroupLayout DataMenuMejaLayout = new javax.swing.GroupLayout(DataMenuMeja);
        DataMenuMeja.setLayout(DataMenuMejaLayout);
        DataMenuMejaLayout.setHorizontalGroup(
            DataMenuMejaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataMenuMejaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(217, Short.MAX_VALUE))
        );
        DataMenuMejaLayout.setVerticalGroup(
            DataMenuMejaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataMenuMejaLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        MainPanel.add(DataMenuMeja, "card2");

        add(MainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    public void loadData() {
        table.getDataVector().removeAllElements();
        table.fireTableDataChanged();
        mj.loadData(table);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DataMeja;
    private javax.swing.JPanel DataMenuMeja;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
