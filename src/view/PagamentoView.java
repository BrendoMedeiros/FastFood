package view;

import DAO.PedidoDAO;
import java.util.ArrayList;
import model.PedidoModel;
import tableModel.PedidoTableModel;

public class PagamentoView extends javax.swing.JFrame {

    private PedidoDAO pedDao;
    private PedidoModel pedModel;
    private PedidoTableModel tabPedidos;

    public PagamentoView() {
        initComponents();

        tabPedidos = new PedidoTableModel();
        pedidosjTable.setModel(tabPedidos);

        buscaPedidosAbertos();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pedidosjTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pedidos para Pagamento"));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pedidosjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pedidosjTableMouseClicked
        if (evt.getClickCount() == 2) {
            int index = pedidosjTable.getSelectedRow();

            tabPedidos = (PedidoTableModel) pedidosjTable.getModel();

            PedidoModel pedido = tabPedidos.get(index);

            new PagamentoPedidoView(pedido).setVisible(true);
            tabPedidos.removeRow(index);
        }
    }//GEN-LAST:event_pedidosjTableMouseClicked

    private void buscaPedidosAbertos() {
        try {
            pedDao = new PedidoDAO();
            ArrayList<PedidoModel> listPedAbertos = (ArrayList<PedidoModel>) pedDao.buscarPedidosPronto();
            tabPedidos = new PedidoTableModel(listPedAbertos);
            pedidosjTable.setModel(tabPedidos);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable pedidosjTable;
    // End of variables declaration//GEN-END:variables
}
