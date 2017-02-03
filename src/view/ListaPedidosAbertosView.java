package view;

import DAO.PedidoDAO;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.PedidoModel;
import tableModel.PedidoTableModel;

public class ListaPedidosAbertosView extends javax.swing.JFrame {

    private PedidoDAO pedDao;
    private PedidoModel pedModel;
    private PedidoTableModel tabPedidos;

    public ListaPedidosAbertosView() {
        initComponents();
        
        tabPedidos = new PedidoTableModel();
        pedidosjTable.setModel(tabPedidos);
        LocalDate data = LocalDate.now();
        datajLabel.setText(data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        buscaPedidosAbertos();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        datajLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pedidosjTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel2.setText("FILA DE PEDIDOS PARA PRODUÇÃO ");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel3.setText("DATA:");

        datajLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        datajLabel.setText("DATA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(datajLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(datajLabel))
                .addGap(22, 22, 22))
        );

        pedidosjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cliente", "Status"
            }
        ));
        pedidosjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pedidosjTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(pedidosjTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pedidosjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pedidosjTableMouseClicked
       if (evt.getClickCount() == 2){
           int index = pedidosjTable.getSelectedRow(); 
           
           tabPedidos = (PedidoTableModel) pedidosjTable.getModel();
           
           PedidoModel pedido = tabPedidos.get(index); 
           
           new ItensDoPedidoProducaoView(pedido).setVisible(true);
           tabPedidos.removeRow(index);
       }
    }//GEN-LAST:event_pedidosjTableMouseClicked

    private void buscaPedidosAbertos(){
        try {
            pedDao = new PedidoDAO();
            ArrayList<PedidoModel> listPedAbertos = (ArrayList<PedidoModel>) pedDao.buscarPedidosAbertos(); 
            tabPedidos = new PedidoTableModel(listPedAbertos);
            pedidosjTable.setModel(tabPedidos);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel datajLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable pedidosjTable;
    // End of variables declaration//GEN-END:variables
}
