package view;

import DAO.CaixaDAO;
import DAO.PagamentoDAO;
import DAO.PedidoDAO;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ItemPedidoModel;
import model.PagamentoModel;
import model.PedidoModel;

public class PagamentoPedidoView extends javax.swing.JFrame {

    private PedidoModel pedModel;
    private PedidoDAO pedDao;
    private CaixaDAO cxDao;

    public PagamentoPedidoView(PedidoModel pedido) {
        initComponents();
        pedModel = pedido;
        setLocationRelativeTo(null);
        URL url = this.getClass().getResource("/img/fast_food.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
        setAtributos();
        carregaComboTipoPag();
        setResizable(false);
        codigojTextField.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelCodigo = new javax.swing.JLabel();
        codigojTextField = new javax.swing.JTextField();
        DataDoPedidojLabel = new javax.swing.JLabel();
        jLabelEstadoDoPedido = new javax.swing.JLabel();
        nomejTextField = new javax.swing.JTextField();
        jLabelCaixa1 = new javax.swing.JLabel();
        DataDoPedidojTextField1 = new javax.swing.JTextField();
        statusjTextField = new javax.swing.JTextField();
        DataDoPedidojLabel1 = new javax.swing.JLabel();
        totaljTextField = new javax.swing.JTextField();
        tpPagamentojComboBox1 = new javax.swing.JComboBox<>();
        jLabelEstadoDoPedido1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        faturarjButton = new javax.swing.JButton();
        sairjButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pedido");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Pedido"));

        jLabelCodigo.setText("Código");

        codigojTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigojTextFieldActionPerformed(evt);
            }
        });

        DataDoPedidojLabel.setText("Data do Pedido");

        jLabelEstadoDoPedido.setText("Estado do Pedido");

        jLabelCaixa1.setText("Cliente");

        DataDoPedidojLabel1.setText("Valor Total");

        jLabelEstadoDoPedido1.setText("Tipo de Pagamento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codigojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelCaixa1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nomejTextField))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(DataDoPedidojLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DataDoPedidojTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabelEstadoDoPedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(statusjTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(DataDoPedidojLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totaljTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelEstadoDoPedido1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tpPagamentojComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodigo)
                    .addComponent(codigojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCaixa1)
                    .addComponent(nomejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DataDoPedidojLabel)
                    .addComponent(DataDoPedidojTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstadoDoPedido)
                    .addComponent(statusjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tpPagamentojComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstadoDoPedido1)
                    .addComponent(DataDoPedidojLabel1)
                    .addComponent(totaljTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações de Pedido"));

        faturarjButton.setText("Faturar");
        faturarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                faturarjButtonActionPerformed(evt);
            }
        });

        sairjButton.setText("Sair");
        sairjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(faturarjButton)
                .addGap(90, 90, 90)
                .addComponent(sairjButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(faturarjButton)
                    .addComponent(sairjButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void faturarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_faturarjButtonActionPerformed
        try {
            PagamentoDAO pagDao = new PagamentoDAO();

            LocalDate data = LocalDate.now();

            String tipo = (String) tpPagamentojComboBox1.getSelectedItem();

            pedModel.setStatusPedido("PG");

            pagDao.salvar(new PagamentoModel(data, tipo, pedModel));
            JOptionPane.showMessageDialog(this, "Pedido pago com sucesso!", "Pagamento de Pedido", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Inclusão do Pagamento", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_faturarjButtonActionPerformed

    private void codigojTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigojTextFieldActionPerformed

    }//GEN-LAST:event_codigojTextFieldActionPerformed

    private void sairjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairjButtonActionPerformed

        this.dispose();
    }//GEN-LAST:event_sairjButtonActionPerformed

    private void carregaComboTipoPag() {

        try {
            tpPagamentojComboBox1.addItem("DINHEIRO");
            tpPagamentojComboBox1.addItem("CARDDEBITO");
            tpPagamentojComboBox1.addItem("CARDCREDITO");
        } catch (Exception ex) {
            Logger.getLogger(EstoqueView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setAtributos() {

        try {
            codigojTextField.setText(String.valueOf(pedModel.getIdPedido()));
            nomejTextField.setText(pedModel.getCliente().getNome());
            DataDoPedidojTextField1.setText(pedModel.getDataPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            statusjTextField.setText(pedModel.getStatusPedido());
            double total = 0.0;
            PedidoDAO pedDao = new PedidoDAO();
            ArrayList<ItemPedidoModel> list = (ArrayList<ItemPedidoModel>) pedDao.buscaItensPedido(pedModel);

            for (ItemPedidoModel item : list) {

                total += item.getTotal();

            }
            totaljTextField.setText(String.valueOf(total));
        } catch (Exception ex) {
            Logger.getLogger(AbrirCaixaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DataDoPedidojLabel;
    private javax.swing.JLabel DataDoPedidojLabel1;
    private javax.swing.JTextField DataDoPedidojTextField1;
    private javax.swing.JTextField codigojTextField;
    private javax.swing.JButton faturarjButton;
    private javax.swing.JLabel jLabelCaixa1;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelEstadoDoPedido;
    private javax.swing.JLabel jLabelEstadoDoPedido1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nomejTextField;
    private javax.swing.JButton sairjButton;
    private javax.swing.JTextField statusjTextField;
    private javax.swing.JTextField totaljTextField;
    private javax.swing.JComboBox<String> tpPagamentojComboBox1;
    // End of variables declaration//GEN-END:variables
}
