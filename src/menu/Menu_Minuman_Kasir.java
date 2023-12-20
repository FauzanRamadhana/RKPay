/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package menu;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Minuman;

/**
 *
 * @author fauzanramadhana
 */
public class Menu_Minuman_Kasir extends javax.swing.JPanel {
    
    private DefaultTableModel table;
    private Minuman mnm = new Minuman();

    /**
     * Creates new form Menu_Minuman
     */
    public Menu_Minuman_Kasir() {
        initComponents();
        table = new DefaultTableModel();
        DataMinuman.setModel(table);

        table.addColumn("Id");
        table.addColumn("Nama");
        table.addColumn("Kategori");
        table.addColumn("Stok");
        table.addColumn("Harga");
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

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        MainPanel = new javax.swing.JPanel();
        DataMenuMinuman = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DataMinuman = new javax.swing.JTable();

        jButton2.setText("jButton2");

        jLabel1.setText("jLabel1");

        setPreferredSize(new java.awt.Dimension(724, 455));
        setLayout(new java.awt.CardLayout());

        MainPanel.setLayout(new java.awt.CardLayout());

        DataMinuman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(DataMinuman);

        javax.swing.GroupLayout DataMenuMinumanLayout = new javax.swing.GroupLayout(DataMenuMinuman);
        DataMenuMinuman.setLayout(DataMenuMinumanLayout);
        DataMenuMinumanLayout.setHorizontalGroup(
            DataMenuMinumanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataMenuMinumanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(217, Short.MAX_VALUE))
        );
        DataMenuMinumanLayout.setVerticalGroup(
            DataMenuMinumanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataMenuMinumanLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        MainPanel.add(DataMenuMinuman, "card2");

        add(MainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents
    
    public void loadData() {
        table.getDataVector().removeAllElements();
        table.fireTableDataChanged();
        mnm.loadData(table);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DataMenuMinuman;
    private javax.swing.JTable DataMinuman;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
