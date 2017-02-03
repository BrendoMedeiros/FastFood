package view;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import model.IngredienteModel;
import DAO.IngredienteDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class IngredienteView extends javax.swing.JFrame {

    private IngredienteDAO ingre;

    public IngredienteView() {
        initComponents();
        setLocationRelativeTo(null);
        URL url = this.getClass().getResource("/img/fast_food.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
        jTextFieldCodigo.setEnabled(false);
        carregaComboIngrediente();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxIngrediente = new javax.swing.JComboBox();
        jButtonConsultar = new javax.swing.JButton();
        jPanelDadosDaReceita = new javax.swing.JPanel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabelCodigo1 = new javax.swing.JLabel();
        jLabelDescricao1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPaneDescricao = new javax.swing.JTextPane();
        jPanelAcoes = new javax.swing.JPanel();
        jButtonAlterar = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonIncluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingrediente");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta"));

        jLabel1.setText("Ingrediente");

        jComboBoxIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxIngredienteActionPerformed(evt);
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
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonConsultar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConsultar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanelDadosDaReceita.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados de Ingrediente"));
        jPanelDadosDaReceita.setToolTipText("");
        jPanelDadosDaReceita.setName(""); // NOI18N

        jTextFieldCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoActionPerformed(evt);
            }
        });

        jLabelCodigo1.setText("Código");

        jLabelDescricao1.setText("Descrição");

        jScrollPane2.setViewportView(jTextPaneDescricao);

        javax.swing.GroupLayout jPanelDadosDaReceitaLayout = new javax.swing.GroupLayout(jPanelDadosDaReceita);
        jPanelDadosDaReceita.setLayout(jPanelDadosDaReceitaLayout);
        jPanelDadosDaReceitaLayout.setHorizontalGroup(
            jPanelDadosDaReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosDaReceitaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosDaReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDescricao1)
                    .addGroup(jPanelDadosDaReceitaLayout.createSequentialGroup()
                        .addComponent(jLabelCodigo1)
                        .addGap(19, 19, 19)
                        .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDadosDaReceitaLayout.setVerticalGroup(
            jPanelDadosDaReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosDaReceitaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosDaReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodigo1)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelDescricao1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelAcoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações do Ingrediente"));

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonIncluir.setText("Incluir");
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAcoesLayout = new javax.swing.GroupLayout(jPanelAcoes);
        jPanelAcoes.setLayout(jPanelAcoesLayout);
        jPanelAcoesLayout.setHorizontalGroup(
            jPanelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAcoesLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jButtonNovo)
                .addGap(18, 18, 18)
                .addComponent(jButtonIncluir)
                .addGap(18, 18, 18)
                .addComponent(jButtonAlterar)
                .addGap(18, 18, 18)
                .addComponent(jButtonExcluir)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanelAcoesLayout.setVerticalGroup(
            jPanelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAcoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAlterar)
                    .addComponent(jButtonIncluir)
                    .addComponent(jButtonNovo)
                    .addComponent(jButtonExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelDadosDaReceita, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelAcoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelDadosDaReceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed

        try {
            ingre = new IngredienteDAO();
            ingre.salvar(getAtributos(1)); 
            carregaComboIngrediente();
            JOptionPane.showMessageDialog(this, "Ingrediente incluido com sucesso!", "Inclusão", JOptionPane.INFORMATION_MESSAGE);
            limparTela();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Inclusão", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed

        try {
            ingre = new IngredienteDAO();
            ingre.excluir(getAtributos(0));
            carregaComboIngrediente();
            limparTela();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Falha na exclusão do ingrediente!\n" + ex.getMessage(), "Exclusão", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed

        try {
            limparTela();
        } catch (Exception ex) {
            Logger.getLogger(IngredienteView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed

        try {
            ingre = new IngredienteDAO();
            ingre.atualizar(getAtributos(0));
            JOptionPane.showMessageDialog(this, "Alteração do ingrediente realizada com sucesso!", "Alteração", JOptionPane.INFORMATION_MESSAGE);
            carregaComboIngrediente();
            limparTela();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Falha na alteração do ingrediente!\n" + ex.getMessage(), "Alteração", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jTextFieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoActionPerformed
        
    }//GEN-LAST:event_jTextFieldCodigoActionPerformed

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed

        IngredienteModel ingreModel;

        try {
            ingreModel = (IngredienteModel) jComboBoxIngrediente.getSelectedItem();

            jTextFieldCodigo.setText(String.valueOf(ingreModel.getIdIngrediente()));
            jTextPaneDescricao.setText(ingreModel.getDescricao());

        } catch (Exception ex) {
            Logger.getLogger(IngredienteView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonConsultarActionPerformed

    private void jComboBoxIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxIngredienteActionPerformed

        try {
            ingre = new IngredienteDAO();
            ArrayList<IngredienteModel> listaIng = (ArrayList<IngredienteModel>) ingre.listarTodos();

            for (IngredienteModel ingrediente : listaIng) {
                jComboBoxIngrediente.setSelectedItem(ingrediente);
            }
        } catch (Exception ex) {
            Logger.getLogger(IngredienteView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBoxIngredienteActionPerformed

    private void carregaComboIngrediente() {
        IngredienteDAO ingreD;

        jComboBoxIngrediente.removeAllItems();
        jComboBoxIngrediente.addItem("Escolha um ingrediente...");

        try {
            ingreD = new IngredienteDAO();
            ArrayList<IngredienteModel> listaIngre = (ArrayList<IngredienteModel>) ingreD.listarTodos();

            for (IngredienteModel ingrediente : listaIngre) {
                jComboBoxIngrediente.addItem(ingrediente);
            }
        } catch (Exception ex) {
            Logger.getLogger(IngredienteView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void limparTela() {

        try {
            jTextFieldCodigo.setText("");
            jTextPaneDescricao.setText("");

        } catch (Exception ex) {
            Logger.getLogger(IngredienteView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public IngredienteModel getAtributos(Integer op) {
        int idIngrediente;
        String descricao;

        if (op == 1) {
            descricao = jTextPaneDescricao.getText();

            IngredienteModel ingre1 = new IngredienteModel(descricao);
            return ingre1;

        } else {

            idIngrediente = Integer.parseInt(jTextFieldCodigo.getText());
            descricao = jTextPaneDescricao.getText();

            IngredienteModel ingre2 = new IngredienteModel(idIngrediente, descricao);
            return ingre2;
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JComboBox jComboBoxIngrediente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCodigo1;
    private javax.swing.JLabel jLabelDescricao1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelAcoes;
    private javax.swing.JPanel jPanelDadosDaReceita;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextPane jTextPaneDescricao;
    // End of variables declaration//GEN-END:variables
}
