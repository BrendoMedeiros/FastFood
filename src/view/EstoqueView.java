package view;

import DAO.EstoqueDAO;
import DAO.IngredienteDAO;
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
import model.EstoqueModel;
import model.IngredienteModel;

public class EstoqueView extends javax.swing.JFrame {

    private EstoqueDAO est;
    private IngredienteDAO ingre;

    public EstoqueView() {
        initComponents();
        setLocationRelativeTo(null);
        URL url = this.getClass().getResource("/img/fast_food.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
        carregaComboEstoque();
        carregaComboIngrediente();
        jTextFieldCodigo.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabelCodigo = new javax.swing.JLabel();
        jLabelQuantidade = new javax.swing.JLabel();
        jLabelUnidade = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxIngrediente = new javax.swing.JComboBox();
        jTextFieldUnidade = new javax.swing.JTextField();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jTextFieldDataValidade = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("##/##/####");
            jTextFieldDataValidade = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxEstoque = new javax.swing.JComboBox();
        jButtonConsultar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButtonIncluir1 = new javax.swing.JButton();
        jButtonExcluir1 = new javax.swing.JButton();
        jButtonNovo1 = new javax.swing.JButton();
        jButtonAlterar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Estoque");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados de Estoque"));

        jLabelCodigo.setText("Código");

        jLabelQuantidade.setText("Quantidade");

        jLabelUnidade.setText("Unidade");

        jLabel1.setText("Data Validade");

        jLabel2.setText("Ingrediente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCodigo)
                    .addComponent(jLabelQuantidade)
                    .addComponent(jLabelUnidade)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDataValidade, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodigo)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelQuantidade)
                    .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUnidade)
                    .addComponent(jTextFieldUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldDataValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Consuta"));

        jLabel3.setText("Estoque");

        jComboBoxEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEstoqueActionPerformed(evt);
            }
        });

        jButtonConsultar.setText("Consultar");
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButtonConsultar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jButtonConsultar))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações de Estoque"));

        jButtonIncluir1.setText("Incluir");
        jButtonIncluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluir1ActionPerformed(evt);
            }
        });

        jButtonExcluir1.setText("Excluir");
        jButtonExcluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluir1ActionPerformed(evt);
            }
        });

        jButtonNovo1.setText("Novo");
        jButtonNovo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovo1ActionPerformed(evt);
            }
        });

        jButtonAlterar1.setText("Alterar");
        jButtonAlterar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jButtonNovo1)
                .addGap(18, 18, 18)
                .addComponent(jButtonIncluir1)
                .addGap(18, 18, 18)
                .addComponent(jButtonAlterar1)
                .addGap(18, 18, 18)
                .addComponent(jButtonExcluir1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonIncluir1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAlterar1)
                        .addComponent(jButtonNovo1)
                        .addComponent(jButtonExcluir1)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEstoqueActionPerformed

        try {
            est = new EstoqueDAO();
            ArrayList<EstoqueModel> listaEst = (ArrayList<EstoqueModel>) est.listarTodos();

            for (EstoqueModel estoque : listaEst) {
                jComboBoxEstoque.setSelectedItem(estoque);
            }
        } catch (Exception ex) {
            Logger.getLogger(EstoqueView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBoxEstoqueActionPerformed

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed

        EstoqueModel estModel;

        try {
            IngredienteDAO est1 = new IngredienteDAO();
            estModel = (EstoqueModel) jComboBoxEstoque.getSelectedItem();

            jTextFieldCodigo.setText(String.valueOf(estModel.getIdEstoque()));
            jTextFieldQuantidade.setText(estModel.getQuantidade().toString());
            jTextFieldUnidade.setText(String.valueOf(estModel.getUnidade()));
            jTextFieldDataValidade.setText(estModel.getDataValidade().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            jComboBoxIngrediente.removeAllItems();

            ArrayList<IngredienteModel> list = (ArrayList<IngredienteModel>) est1.buscarIngrediente(estModel.getEstoqueIdIngrediente());

            for (IngredienteModel es : list) {
                jComboBoxIngrediente.addItem(es);
            }
          
        } catch (Exception ex) {
            Logger.getLogger(IngredienteView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonConsultarActionPerformed

    private void jButtonIncluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluir1ActionPerformed

        try {

            est = new EstoqueDAO();
            est.salvar(getAtributos(1));
            JOptionPane.showMessageDialog(this, "Estoque Incluido com sucesso!\n", "Inclusão", JOptionPane.INFORMATION_MESSAGE);
            carregaComboEstoque();
            carregaComboIngrediente();
            limparTela();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Falha na Inclusão do Estoque!\n" + ex.getMessage(), "Inclusão", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonIncluir1ActionPerformed

    private void jButtonExcluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluir1ActionPerformed
        try {

            est = new EstoqueDAO();
            est.excluir(getAtributos(0));
            limparTela();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Falha na Inclusão do Estoque!\n" + ex.getMessage(), "Inclusão", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonExcluir1ActionPerformed

    private void jButtonNovo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovo1ActionPerformed
        limparTela();
    }//GEN-LAST:event_jButtonNovo1ActionPerformed

    private void jButtonAlterar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterar1ActionPerformed
        try {

            est = new EstoqueDAO();
            est.atualizar(getAtributos(0));
            JOptionPane.showMessageDialog(this, "Estoque alterado com sucesso!\n", "Alteração", JOptionPane.INFORMATION_MESSAGE);
            limparTela();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Falha na Inclusão do Estoque!\n" + ex.getMessage(), "Inclusão", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAlterar1ActionPerformed

    private void carregaComboEstoque() {

        jComboBoxEstoque.removeAllItems();
        jComboBoxEstoque.addItem("Escolha um estoque...");

        try {
            est = new EstoqueDAO();
            ArrayList<EstoqueModel> listaEs = (ArrayList<EstoqueModel>) est.listarTodos();

            for (EstoqueModel estoque : listaEs) {
                jComboBoxEstoque.addItem(estoque);
            }
        } catch (Exception ex) {
            Logger.getLogger(EstoqueView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void carregaComboIngrediente() {

        jComboBoxIngrediente.removeAllItems();
        jComboBoxIngrediente.addItem("Escolha um Ingrediente...");

        try {
            ingre = new IngredienteDAO();
            ArrayList<IngredienteModel> listaIngre = (ArrayList<IngredienteModel>) ingre.listarTodos();

            for (IngredienteModel ingrediente : listaIngre) {
                jComboBoxIngrediente.addItem(ingrediente);
            }
        } catch (Exception ex) {
            Logger.getLogger(IngredienteView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public EstoqueModel getAtributos(Integer op) throws ParseException {
        int idEstoque;
        Double quantidade;
        String unidade;

        int dia = Integer.parseInt(jTextFieldDataValidade.getText().substring(0, 2));
        int mes = Integer.parseInt(jTextFieldDataValidade.getText().substring(3, 5));
        int ano = Integer.parseInt(jTextFieldDataValidade.getText().substring(6, 10));

        LocalDate dataValidade = LocalDate.of(ano, mes, dia);
        IngredienteModel estoqueIdIngrediente;

        if (op == 1) {

            quantidade = Double.parseDouble(jTextFieldQuantidade.getText());
            unidade = jTextFieldUnidade.getText();

            estoqueIdIngrediente = (IngredienteModel) jComboBoxIngrediente.getSelectedItem();

            EstoqueModel est1 = new EstoqueModel(quantidade, unidade, dataValidade, estoqueIdIngrediente);
            return est1;

        } else {

            idEstoque = Integer.parseInt(jTextFieldCodigo.getText());
            quantidade = Double.parseDouble(jTextFieldQuantidade.getText());
            unidade = jTextFieldUnidade.getText();

            estoqueIdIngrediente = (IngredienteModel) jComboBoxIngrediente.getSelectedItem();

            EstoqueModel est2 = new EstoqueModel(idEstoque, quantidade, unidade, dataValidade, estoqueIdIngrediente);
            return est2;

        }
    }

    private void limparTela() {

        try {
            jTextFieldCodigo.setText("");
            jTextFieldQuantidade.setText("");
            jTextFieldUnidade.setText("");
            jTextFieldDataValidade.setText("");

            jComboBoxIngrediente.removeAllItems();
            carregaComboIngrediente();
            carregaComboEstoque();
        } catch (Exception ex) {
            Logger.getLogger(IngredienteView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar1;
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonExcluir1;
    private javax.swing.JButton jButtonIncluir1;
    private javax.swing.JButton jButtonNovo1;
    private javax.swing.JComboBox jComboBoxEstoque;
    private javax.swing.JComboBox jComboBoxIngrediente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelQuantidade;
    private javax.swing.JLabel jLabelUnidade;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldDataValidade;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTextField jTextFieldUnidade;
    // End of variables declaration//GEN-END:variables
}
