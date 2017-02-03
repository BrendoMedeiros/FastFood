package view;

import DAO.ProdutoDAO;
import DAO.ReceitaDAO;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ProdutoModel;
import model.ReceitaModel;

public class ProdutoView extends javax.swing.JFrame {

    private ProdutoDAO pro;
    private ReceitaDAO rec;

    public ProdutoView() {
        initComponents();
        setLocationRelativeTo(null);
        URL url = this.getClass().getResource("/img/fast_food.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
        carregaComboProduto();
        carregaComboReceita();
        jTextFieldCodigo.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelReceita = new javax.swing.JLabel();
        jComboBoxReceita = new javax.swing.JComboBox();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jLabelCódigo = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldPreco = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButtonAlterar = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonIncluir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxProduto = new javax.swing.JComboBox();
        jButtonConsultar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produto");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Produto"));

        jLabelReceita.setText("Receita");

        jComboBoxReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxReceitaActionPerformed(evt);
            }
        });

        jLabelNome.setText("Nome");

        jLabelCódigo.setText("Código");

        jLabel1.setText("Preço");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelReceita)
                    .addComponent(jLabelCódigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBoxReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCódigo)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNome)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelReceita)
                    .addComponent(jComboBoxReceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações do Produto"));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jButtonNovo)
                .addGap(56, 56, 56)
                .addComponent(jButtonIncluir)
                .addGap(61, 61, 61)
                .addComponent(jButtonAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonExcluir)
                .addGap(39, 39, 39))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExcluir)
                    .addComponent(jButtonAlterar)
                    .addComponent(jButtonIncluir)
                    .addComponent(jButtonNovo))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta"));

        jLabel2.setText("Produto");

        jComboBoxProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProdutoActionPerformed(evt);
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
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jButtonConsultar)
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConsultar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxReceitaActionPerformed

    }//GEN-LAST:event_jComboBoxReceitaActionPerformed

    private void jComboBoxProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProdutoActionPerformed

        try {
            pro = new ProdutoDAO();
            ArrayList<ProdutoModel> listaPro = (ArrayList<ProdutoModel>) pro.listarTodos();

            for (ProdutoModel produto : listaPro) {
                jComboBoxProduto.setSelectedItem(produto);
            }
        } catch (Exception ex) {
            Logger.getLogger(ProdutoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBoxProdutoActionPerformed

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed

        ProdutoModel proModel;

        try {
            ReceitaDAO rec1 = new ReceitaDAO();
            proModel = (ProdutoModel) jComboBoxProduto.getSelectedItem();

            jTextFieldCodigo.setText(String.valueOf(proModel.getIdProduto()));
            jTextFieldNome.setText(proModel.getNome());
            jTextFieldPreco.setText(String.valueOf(proModel.getPreco()));

            jComboBoxReceita.removeAllItems();
            ArrayList<ReceitaModel> list = (ArrayList<ReceitaModel>) rec1.buscaReceita(proModel.getProdutoIdReceita());

            for (ReceitaModel re : list) {
                jComboBoxReceita.addItem(re);
            }
            jComboBoxReceita.setEnabled(false);
        } catch (Exception ex) {
            Logger.getLogger(ReceitaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonConsultarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed

        try {
            limparTela();
        } catch (Exception ex) {
            Logger.getLogger(ProdutoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed

        try {

            pro = new ProdutoDAO();
            pro.salvar(getAtributos(1));
            carregaComboProduto();
            carregaComboReceita();
            //JOptionPane.showMessageDialog(this, "Inclusão do produto realizada com sucesso!", "Alteração", JOptionPane.INFORMATION_MESSAGE);
            limparTela();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Falha na Inclusão do produto!\n" + ex.getMessage(), "Inclusão", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed

        try {
            pro = new ProdutoDAO();
            pro.atualizar(getAtributos(0));
            carregaComboProduto();
            carregaComboReceita();
            JOptionPane.showMessageDialog(this, "Alteração do produto realizada com sucesso!", "Alteração", JOptionPane.INFORMATION_MESSAGE);
            limparTela();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Falha na alteração do produto!\n" + ex.getMessage(), "Alteração", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        try {
            pro = new ProdutoDAO();
            pro.excluir(getAtributos(0));
            carregaComboProduto();
            carregaComboReceita();
            limparTela();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Falha na exclusão do produto!\n" + ex.getMessage(), "Exclusão", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void carregaComboProduto() {

        jComboBoxProduto.removeAllItems();
        jComboBoxProduto.addItem("Escolha um produto...");

        try {
            pro = new ProdutoDAO();
            ArrayList<ProdutoModel> listaPro = (ArrayList<ProdutoModel>) pro.listarTodos();

            for (ProdutoModel caixa : listaPro) {
                jComboBoxProduto.addItem(caixa);
            }
        } catch (Exception ex) {
            Logger.getLogger(ProdutoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void carregaComboReceita() {

        jComboBoxReceita.removeAllItems();
        jComboBoxReceita.addItem("Escolha um receita...");

        try {
            rec = new ReceitaDAO();
            ArrayList<ReceitaModel> listaRec = (ArrayList<ReceitaModel>) rec.listarTodos();

            for (ReceitaModel receita : listaRec) {
                jComboBoxReceita.addItem(receita);
            }
        } catch (Exception ex) {
            Logger.getLogger(ReceitaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ProdutoModel getAtributos(Integer op) throws ParseException {
        int idProduto;
        String nome;
        Float preco;
        ReceitaModel produtoIdReceita;

        if (op == 1) {

            nome = jTextFieldNome.getText();
            preco = Float.parseFloat(jTextFieldPreco.getText());
            produtoIdReceita = (ReceitaModel) jComboBoxReceita.getSelectedItem();

            ProdutoModel pro1 = new ProdutoModel(nome, preco, produtoIdReceita);
            return pro1;

        } else {

            idProduto = Integer.parseInt(jTextFieldCodigo.getText());
            nome = jTextFieldNome.getText();
            preco = Float.parseFloat(jTextFieldPreco.getText());
            produtoIdReceita = (ReceitaModel) jComboBoxReceita.getSelectedItem();

            ProdutoModel pro2 = new ProdutoModel(idProduto, nome, preco, produtoIdReceita);
            return pro2;

        }
    }

    private void limparTela() {

        try {
            jTextFieldCodigo.setText("");
            jTextFieldNome.setText("");
            jTextFieldPreco.setText("");

            jComboBoxReceita.removeAllItems();
            jComboBoxReceita.addItem("Escolha um receita...");
            jComboBoxReceita.setEnabled(true);
            rec = new ReceitaDAO();
            ArrayList<ReceitaModel> listaRec = (ArrayList<ReceitaModel>) rec.listarTodos();

            for (ReceitaModel receita : listaRec) {
                jComboBoxReceita.addItem(receita);
            }

        } catch (Exception ex) {
            Logger.getLogger(ReceitaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JComboBox jComboBoxProduto;
    private javax.swing.JComboBox jComboBoxReceita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCódigo;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelReceita;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPreco;
    // End of variables declaration//GEN-END:variables
}
