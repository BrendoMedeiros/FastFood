package view;

import DAO.IngredienteDAO;
import DAO.ReceitaDAO;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ReceitaModel;

public class ReceitaView extends javax.swing.JFrame {

    private ReceitaModel recModel;
    private ReceitaDAO recDAO;
    private IngredienteDAO ingre;

    public ReceitaView() {
        initComponents();
        setLocationRelativeTo(null);
        URL url = this.getClass().getResource("/img/fast_food.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
        jTextFieldCodigo.setEnabled(false);
        carregaComboReceita();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelAcoes = new javax.swing.JPanel();
        jButtonAlterar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jButtonIncluir = new javax.swing.JButton();
        jPanelDadosDaReceita = new javax.swing.JPanel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabelCódigo = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelModoPreparo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaModoPreparo = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxReceita = new javax.swing.JComboBox();
        jButtonConsultar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Receita");

        jPanelAcoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações de Receita"));

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
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
                .addGap(68, 68, 68)
                .addComponent(jButtonNovo)
                .addGap(18, 18, 18)
                .addComponent(jButtonIncluir)
                .addGap(18, 18, 18)
                .addComponent(jButtonAlterar)
                .addGap(18, 18, 18)
                .addComponent(jButtonExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelAcoesLayout.setVerticalGroup(
            jPanelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAcoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNovo)
                    .addComponent(jButtonIncluir)
                    .addComponent(jButtonAlterar)
                    .addComponent(jButtonExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelDadosDaReceita.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da Receita"));
        jPanelDadosDaReceita.setToolTipText("");
        jPanelDadosDaReceita.setName(""); // NOI18N

        jTextFieldCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoActionPerformed(evt);
            }
        });

        jLabelCódigo.setText("Código");

        jLabelNome.setText("Nome");

        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });

        jLabelModoPreparo.setText("Modo de Preparo");

        jTextAreaModoPreparo.setColumns(20);
        jTextAreaModoPreparo.setRows(5);
        jScrollPane1.setViewportView(jTextAreaModoPreparo);

        javax.swing.GroupLayout jPanelDadosDaReceitaLayout = new javax.swing.GroupLayout(jPanelDadosDaReceita);
        jPanelDadosDaReceita.setLayout(jPanelDadosDaReceitaLayout);
        jPanelDadosDaReceitaLayout.setHorizontalGroup(
            jPanelDadosDaReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosDaReceitaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosDaReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                    .addGroup(jPanelDadosDaReceitaLayout.createSequentialGroup()
                        .addComponent(jLabelModoPreparo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosDaReceitaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanelDadosDaReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelDadosDaReceitaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanelDadosDaReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelDadosDaReceitaLayout.createSequentialGroup()
                            .addComponent(jLabelCódigo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabelNome))
                    .addContainerGap(334, Short.MAX_VALUE)))
        );
        jPanelDadosDaReceitaLayout.setVerticalGroup(
            jPanelDadosDaReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosDaReceitaLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelModoPreparo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelDadosDaReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelDadosDaReceitaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanelDadosDaReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelCódigo)
                        .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabelNome)
                    .addContainerGap(150, Short.MAX_VALUE)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta"));

        jLabel3.setText("Receita");

        jComboBoxReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxReceitaActionPerformed(evt);
            }
        });

        jButtonConsultar1.setText("Consultar");
        jButtonConsultar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultar1ActionPerformed(evt);
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
                .addComponent(jComboBoxReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jButtonConsultar1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxReceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConsultar1))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelAcoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDadosDaReceita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelDadosDaReceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed

        try {
            recDAO = new ReceitaDAO();
            recDAO.atualizar(getAtributos(0));
            carregaComboReceita();
            JOptionPane.showMessageDialog(this, "Alteração da receita realizada com sucesso!", "Alteração", JOptionPane.INFORMATION_MESSAGE);
            limparTela();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Falha na alteração da receita!\n" + ex.getMessage(), "Alteração", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed

        try {
            recDAO = new ReceitaDAO();
            recDAO.excluir(getAtributos(0));
            carregaComboReceita();
            limparTela();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Falha na exclusão da receita!\n" + ex.getMessage(), "Exclusão", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jTextFieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoActionPerformed

    }//GEN-LAST:event_jTextFieldCodigoActionPerformed

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed

    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jComboBoxReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxReceitaActionPerformed

        try {
            recDAO = new ReceitaDAO();
            ArrayList<ReceitaModel> listaRec = (ArrayList<ReceitaModel>) recDAO.listarTodos();

            for (ReceitaModel receita : listaRec) {
                jComboBoxReceita.setSelectedItem(receita);
            }
        } catch (Exception ex) {
            Logger.getLogger(ReceitaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBoxReceitaActionPerformed

    private void jButtonConsultar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultar1ActionPerformed

        try {
            recModel = (ReceitaModel) jComboBoxReceita.getSelectedItem();

            jTextFieldCodigo.setText(String.valueOf(recModel.getIdReceita()));
            jTextFieldNome.setText(recModel.getNome());
            jTextAreaModoPreparo.setText(recModel.getModoPreparo());

        } catch (Exception ex) {
            Logger.getLogger(ReceitaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonConsultar1ActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed

        try {
            limparTela();
        } catch (Exception ex) {
            Logger.getLogger(AbrirCaixaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
        
        ReceitaModel receitaModel = null;
        
        try {
            recDAO = new ReceitaDAO();
            receitaModel = getAtributos(1);
            Integer id = recDAO.salvar(getAtributos(1));
            receitaModel.setIdReceita(id);
            
            JOptionPane.showMessageDialog(this, "Inclusão da receita realizada com sucesso!", "Inclusão", JOptionPane.INFORMATION_MESSAGE);
            new IngredienteDeReceitaView(recModel).setVisible(true);
            
            
            carregaComboReceita();
            limparTela();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Inclusão", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void carregaComboReceita() {
        ReceitaDAO rec2;

        jComboBoxReceita.removeAllItems();
        jComboBoxReceita.addItem("Escolha um caixa...");

        try {
            rec2 = new ReceitaDAO();
            ArrayList<ReceitaModel> listaRec = (ArrayList<ReceitaModel>) rec2.listarTodos();

            for (ReceitaModel receita : listaRec) {
                jComboBoxReceita.addItem(receita);
            }
        } catch (Exception ex) {
            Logger.getLogger(ReceitaView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void limparTela() {

        try {
            jTextFieldCodigo.setText("");
            jTextFieldNome.setText("");

            jTextAreaModoPreparo.setText("");

        } catch (Exception ex) {
            Logger.getLogger(ReceitaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ReceitaModel getAtributos(Integer op) {
        int idReceita;
        String nome;
        String modoPreparo;

        if (op == 1) {
            nome = jTextFieldNome.getText();
            modoPreparo = jTextAreaModoPreparo.getText();
            ReceitaModel rec1 = new ReceitaModel(nome, modoPreparo);
            return rec1;
        } else {
            idReceita = Integer.parseInt(jTextFieldCodigo.getText());
            nome = jTextFieldNome.getText();
            modoPreparo = jTextAreaModoPreparo.getText();
            ReceitaModel rec2 = new ReceitaModel(idReceita, nome, modoPreparo);
            return rec2;
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonConsultar1;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JComboBox jComboBoxReceita;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelCódigo;
    private javax.swing.JLabel jLabelModoPreparo;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelAcoes;
    private javax.swing.JPanel jPanelDadosDaReceita;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaModoPreparo;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
