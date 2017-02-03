package view;

import DAO.CaixaDAO;
import DAO.PedidoDAO;
import DAO.UsuarioDAO;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.CaixaModel;
import model.PedidoModel;
import model.UsuarioModel;

public class PedidoView extends javax.swing.JFrame {
    
    private PedidoModel pedModel;
    private PedidoDAO pedDao;
    private CaixaDAO cxDao;
    
    public PedidoView() {
        initComponents();
        setLocationRelativeTo(null);
        URL url = this.getClass().getResource("/img/fast_food.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
        carregaComboCaixa();
        carregaComboPedido();
        carregaComboCliente();
        carregaComboStatus();
        DataDoPedidojTextField.setVisible(false);
        DataDoPedidojLabel.setVisible(false);
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
        jLabelCaixa = new javax.swing.JLabel();
        statusjComboBox = new javax.swing.JComboBox();
        DataDoPedidojTextField = new javax.swing.JTextField();
        jLabelCaixa1 = new javax.swing.JLabel();
        clientejComboBox = new javax.swing.JComboBox();
        caixajComboBox1 = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jButtonIncluir = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxPedido = new javax.swing.JComboBox();
        jButtonConsultar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pedido");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Pedido"));

        jLabelCodigo.setText("Código");

        DataDoPedidojLabel.setText("Data do Pedido");

        jLabelEstadoDoPedido.setText("Estado do Pedido");

        jLabelCaixa.setText("Caixa");

        statusjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusjComboBoxActionPerformed(evt);
            }
        });

        jLabelCaixa1.setText("Cliente");

        clientejComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientejComboBoxActionPerformed(evt);
            }
        });

        caixajComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caixajComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCaixa)
                    .addComponent(jLabelEstadoDoPedido)
                    .addComponent(DataDoPedidojLabel)
                    .addComponent(jLabelCodigo)
                    .addComponent(jLabelCaixa1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clientejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DataDoPedidojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caixajComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodigo)
                    .addComponent(codigojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCaixa1)
                    .addComponent(clientejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DataDoPedidojLabel)
                    .addComponent(DataDoPedidojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEstadoDoPedido)
                    .addComponent(statusjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCaixa)
                    .addComponent(caixajComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações de Pedido"));

        jButtonIncluir.setText("Incluir");
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jButtonNovo)
                .addGap(18, 18, 18)
                .addComponent(jButtonIncluir)
                .addGap(18, 18, 18)
                .addComponent(jButtonAlterar)
                .addGap(18, 18, 18)
                .addComponent(jButtonExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAlterar)
                    .addComponent(jButtonNovo)
                    .addComponent(jButtonIncluir)
                    .addComponent(jButtonExcluir))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta"));

        jLabel3.setText("Pedido");

        jComboBoxPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPedidoActionPerformed(evt);
            }
        });

        jButtonConsultar.setText("Consultar");
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButtonConsultar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConsultar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPedidoActionPerformed
        
        try {
            pedDao = new PedidoDAO();
            ArrayList<PedidoModel> listaPed = (ArrayList<PedidoModel>) pedDao.listarTodos();
            
            for (PedidoModel pedido : listaPed) {
                jComboBoxPedido.setSelectedItem(pedido);
            }
        } catch (Exception ex) {
            Logger.getLogger(PedidoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBoxPedidoActionPerformed

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed
        
        try {
            CaixaDAO cx1 = new CaixaDAO();
            pedModel = (PedidoModel) jComboBoxPedido.getSelectedItem();
            
            codigojTextField.setText(String.valueOf(pedModel.getIdPedido()));
            DataDoPedidojTextField.setText(pedModel.getDataPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            statusjComboBox.setSelectedItem(pedModel.getStatusPedido());
            
            caixajComboBox1.removeAllItems();
            ArrayList<CaixaModel> list = (ArrayList<CaixaModel>) cx1.buscarCaixa(pedModel.getPedidoIdCaixa());
            
            for (CaixaModel es : list) {
                caixajComboBox1.addItem(es);
            }
            
            UsuarioDAO userDao = new UsuarioDAO();
            clientejComboBox.removeAllItems();
            
            ArrayList<UsuarioModel> listUser = (ArrayList<UsuarioModel>) userDao.buscarUsuario(pedModel.getCliente());
            
            for (UsuarioModel user : listUser) {
                clientejComboBox.addItem(user);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(AbrirCaixaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonConsultarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        
        try {
            pedDao = new PedidoDAO();
            pedDao.atualizar(getAtributos(0));
            carregaComboCaixa();
            carregaComboPedido();
            JOptionPane.showMessageDialog(this, "Alteração do pedido realizada com sucesso!", "Alteração", JOptionPane.INFORMATION_MESSAGE);
            limparTela();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Falha na alteração do pedido!\n" + ex.getMessage(), "Alteração", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        
        try {
            limparTela();
        } catch (Exception ex) {
            Logger.getLogger(PedidoView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
        
        PedidoModel pedidoModel = null;
        
        try {
            
            pedDao = new PedidoDAO();
            pedidoModel = getAtributos(1);
            Integer id = pedDao.salvar(getAtributos(1));
            pedidoModel.setIdPedido(id);
            
            JOptionPane.showMessageDialog(this, "Inclusão do pedido realizada com sucesso!", "Inclusão", JOptionPane.INFORMATION_MESSAGE);
            new ItensDoPedidoView(pedidoModel).setVisible(true);
            
            carregaComboCaixa();
            carregaComboPedido();
            limparTela();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Falha na Inclusão do pedido!\n" + ex.getMessage(), "Inclusão", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        
        try {
            pedDao = new PedidoDAO();
            pedDao.excluir(getAtributos(0));
            carregaComboCaixa();
            carregaComboPedido();
            limparTela();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Falha na exclusão do pedido!\n" + ex.getMessage(), "Exclusão", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void caixajComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caixajComboBox1ActionPerformed

    }//GEN-LAST:event_caixajComboBox1ActionPerformed

    private void statusjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusjComboBoxActionPerformed

    }//GEN-LAST:event_statusjComboBoxActionPerformed

    private void clientejComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientejComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientejComboBoxActionPerformed
    
    private void carregaComboPedido() {
        
        jComboBoxPedido.removeAllItems();
        jComboBoxPedido.addItem("Escolha um pedido...");
        
        try {
            pedDao = new PedidoDAO();
            ArrayList<PedidoModel> listaPe = (ArrayList<PedidoModel>) pedDao.listarTodos();
            
            for (PedidoModel pedido : listaPe) {
                jComboBoxPedido.addItem(pedido);
            }
        } catch (Exception ex) {
            Logger.getLogger(EstoqueView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void carregaComboCliente() {
        clientejComboBox.removeAllItems();
        clientejComboBox.addItem("Escolha um cliente ...");
        try {
            UsuarioDAO userDao = new UsuarioDAO();
            ArrayList<UsuarioModel> listUser = (ArrayList<UsuarioModel>) userDao.buscarClientes();
            
            for (UsuarioModel user : listUser) {
                clientejComboBox.addItem(user);
            }
            clientejComboBox.setEnabled(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void carregaComboStatus() {
        statusjComboBox.removeAllItems();
        statusjComboBox.addItem("Defina um status...");
        try {
            
            statusjComboBox.addItem("AB");
            statusjComboBox.addItem("FC");
            statusjComboBox.addItem("PT");
            statusjComboBox.addItem("CL");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void carregaComboCaixa() {
        
        caixajComboBox1.removeAllItems();
        caixajComboBox1.addItem("Escolha um caixa...");
        
        try {
            cxDao = new CaixaDAO();
            ArrayList<CaixaModel> listaCx = (ArrayList<CaixaModel>) cxDao.listarTodos();
            for (CaixaModel caixa : listaCx) {
                caixajComboBox1.addItem(caixa);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(AbrirCaixaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public PedidoModel getAtributos(Integer op) throws ParseException {
        int idPedido;
        String statusPedido;
        
        CaixaModel pedidoIdCaixa;
        UsuarioModel cliente;
        LocalDate dataPedido = LocalDate.now();
        
        if (op == 1) {
            
            statusPedido = (String) statusjComboBox.getSelectedItem();
            pedidoIdCaixa = (CaixaModel) caixajComboBox1.getSelectedItem();
            cliente = (UsuarioModel) clientejComboBox.getSelectedItem();
            PedidoModel ped1 = new PedidoModel(dataPedido, statusPedido, cliente, pedidoIdCaixa);
            return ped1;
            
        } else {
            
            idPedido = Integer.parseInt(codigojTextField.getText());
            statusPedido = (String) statusjComboBox.getSelectedItem();
            cliente = (UsuarioModel) clientejComboBox.getSelectedItem();
            pedidoIdCaixa = (CaixaModel) caixajComboBox1.getSelectedItem();
            
            PedidoModel ped2 = new PedidoModel(idPedido, dataPedido, statusPedido, cliente, pedidoIdCaixa);
            return ped2;
            
        }
    }
    
    private void limparTela() {
        
        try {
            codigojTextField.setText("");
            
            DataDoPedidojTextField.setText("");
            carregaComboCaixa();
            carregaComboCliente();
            carregaComboPedido();
            carregaComboStatus();
            
        } catch (Exception ex) {
            Logger.getLogger(AbrirCaixaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DataDoPedidojLabel;
    private javax.swing.JTextField DataDoPedidojTextField;
    private javax.swing.JComboBox caixajComboBox1;
    private javax.swing.JComboBox clientejComboBox;
    private javax.swing.JTextField codigojTextField;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JComboBox jComboBoxPedido;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelCaixa;
    private javax.swing.JLabel jLabelCaixa1;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelEstadoDoPedido;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox statusjComboBox;
    // End of variables declaration//GEN-END:variables
}
