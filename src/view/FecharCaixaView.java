package view;

import DAO.CaixaDAO;
import DAO.UsuarioDAO;
import model.CaixaModel;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.UsuarioModel;

public class FecharCaixaView extends javax.swing.JFrame {

    private CaixaDAO cx;
    private CaixaModel caixaModel;
    private UsuarioDAO user;
    private Double valorTotal;

    public FecharCaixaView() {
        initComponents();
        setLocationRelativeTo(null);
        URL url = this.getClass().getResource("/img/fast_food.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
        jLabelCodigo.setEnabled(false);
        jTextFieldCodigo.setEnabled(false);
        jTextFieldData.setEnabled(false);
        jTextFieldHoraDeAbertura.setEnabled(false);
        jTextFieldValor.setEnabled(false);
        buscarCaixa();
        setAtributos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabelHoraDeAbertura = new javax.swing.JLabel();
        jTextFieldHoraDeAbertura = new javax.swing.JTextField();
        jLabelValor = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();
        jLabelData = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jComboBoxUsuario = new javax.swing.JComboBox();
        jTextFieldData = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButtonNovo = new javax.swing.JButton();
        jButtonIncluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Caixa");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Caixa"));

        jLabelCodigo.setText("Código");

        jLabelHoraDeAbertura.setText("Hora de Abertura");

        jLabelValor.setText("Valor Total do Faturamento");

        jTextFieldValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldValorActionPerformed(evt);
            }
        });

        jLabelData.setText("Data ");

        jLabelUsuario.setText("Usuário");

        jComboBoxUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUsuarioActionPerformed(evt);
            }
        });

        jTextFieldData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelHoraDeAbertura)
                            .addComponent(jLabelValor)
                            .addComponent(jLabelData)
                            .addComponent(jLabelCodigo))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldHoraDeAbertura, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldData, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldValor, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodigo)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelData)
                    .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelValor)
                    .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelHoraDeAbertura)
                    .addComponent(jTextFieldHoraDeAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUsuario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações do Caixa"));

        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonIncluir.setText("Fechar Caixa");
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jButtonNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jButtonIncluir)
                .addGap(45, 45, 45))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNovo)
                    .addComponent(jButtonIncluir))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDataActionPerformed

    }//GEN-LAST:event_jTextFieldDataActionPerformed

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
        try {

            cx = new CaixaDAO();
            cx.salvar(getAtributos(0));
            carregaComboUsuario();
            JOptionPane.showMessageDialog(this, "Fechamento do caixa realizada com sucesso!", "Alteração", JOptionPane.INFORMATION_MESSAGE);
            limparTela();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Falha no Fechamento do caixa!\n" + ex.getMessage(), "Inclusão", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jComboBoxUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUsuarioActionPerformed

    }//GEN-LAST:event_jComboBoxUsuarioActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed

        try {
            limparTela();
        } catch (Exception ex) {
            Logger.getLogger(FecharCaixaView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jTextFieldValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldValorActionPerformed


    }//GEN-LAST:event_jTextFieldValorActionPerformed

    private void carregaComboUsuario() {

        jComboBoxUsuario.removeAllItems();

        try {
            user = new UsuarioDAO();
            ArrayList<UsuarioModel> listaUser = (ArrayList<UsuarioModel>) user.buscarUsuario(caixaModel.getCaixaIdUsuario());

            for (UsuarioModel usuario : listaUser) {
                jComboBoxUsuario.addItem(usuario);
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public CaixaModel getAtributos(Integer op) throws ParseException {
        int idCaixa;
        LocalDate data = LocalDate.now();
        Float valor;
        LocalTime horaAbetura = LocalTime.now();
        LocalTime horaFechamento = LocalTime.of(00, 00);
        UsuarioModel caixaIdUsusario;

        if (op == 0) {

            valor = Float.parseFloat(jTextFieldValor.getText());
            caixaIdUsusario = (UsuarioModel) jComboBoxUsuario.getSelectedItem();
            CaixaModel cx1 = new CaixaModel(data, valor, horaAbetura, horaFechamento, caixaIdUsusario);
            return cx1;

        } else {

            idCaixa = Integer.parseInt(jTextFieldCodigo.getText());
            valor = Float.parseFloat(jTextFieldValor.getText());

            horaAbetura = LocalTime.parse(jTextFieldHoraDeAbertura.getText());
            horaFechamento = LocalTime.now();
            caixaIdUsusario = (UsuarioModel) jComboBoxUsuario.getSelectedItem();

            CaixaModel cx2 = new CaixaModel(idCaixa, data, valor, horaAbetura, horaFechamento, caixaIdUsusario);
            return cx2;

        }

    }

    private void setAtributos() {

        try {
            jTextFieldCodigo.setText(String.valueOf(caixaModel.getIdCaixa()));
            jTextFieldData.setText(caixaModel.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            jTextFieldValor.setText(String.valueOf(valorTotal));
            jTextFieldHoraDeAbertura.setText(caixaModel.getHoraAbertura().format(DateTimeFormatter.ISO_LOCAL_TIME));

            jComboBoxUsuario.removeAllItems();
            jComboBoxUsuario.setEnabled(false);
            user = new UsuarioDAO();
            ArrayList<UsuarioModel> listaUser = (ArrayList<UsuarioModel>) user.buscarUsuario(caixaModel.getCaixaIdUsuario());

            for (UsuarioModel usuario : listaUser) {
                jComboBoxUsuario.addItem(usuario);
            }

        } catch (Exception ex) {
            Logger.getLogger(UsuarioView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void limparTela() {

        try {
            jTextFieldCodigo.setText("");
            jTextFieldData.setText("");
            jTextFieldValor.setText("");
            jTextFieldHoraDeAbertura.setText("");

            jComboBoxUsuario.removeAllItems();
            jComboBoxUsuario.addItem("Escolha um usuário...");
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void buscarCaixa() {

        try {
            CaixaDAO caixaDao = new CaixaDAO();
            ArrayList<CaixaModel> listCaixa = (ArrayList<CaixaModel>) caixaDao.buscarCaixaCorrente();

            for (CaixaModel caixa : listCaixa) {
                if (caixa instanceof CaixaModel) {
                    caixaModel = caixa;
                }
            }
            CaixaDAO caixDao = new CaixaDAO();
            valorTotal = caixDao.buscarValorTotaldoFaturameto();
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(UsuarioView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JComboBox jComboBoxUsuario;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelHoraDeAbertura;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldHoraDeAbertura;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables
}
