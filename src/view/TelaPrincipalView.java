package view;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JOptionPane;
import model.UsuarioModel;

public class TelaPrincipalView extends javax.swing.JFrame {

    private UsuarioModel usuarioModel;

    public TelaPrincipalView(UsuarioModel user) {
        initComponents();
        setLocationRelativeTo(null);
        usuarioModel = user;
        URL url = this.getClass().getResource("/img/fast_food.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabelFundo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuItemCadastroDeUsuario = new javax.swing.JMenuItem();
        jMenuItemIngrediente = new javax.swing.JMenuItem();
        jMenuItemCadastroDeReceita = new javax.swing.JMenuItem();
        jMenuItemProduto = new javax.swing.JMenuItem();
        jMenuAbrirCaixa = new javax.swing.JMenu();
        jMenuItemAbrirCaixa = new javax.swing.JMenuItem();
        jMenuItemFecharCaixa = new javax.swing.JMenuItem();
        jMenuPedido = new javax.swing.JMenu();
        jMenuItemAbrirPedido = new javax.swing.JMenuItem();
        jMenuItemPagamento = new javax.swing.JMenuItem();
        jMenuEstoque = new javax.swing.JMenu();
        jMenuItemAbrirEstoque = new javax.swing.JMenuItem();
        jMenuItemConsutarEstoque = new javax.swing.JMenuItem();
        jMenuCozinha = new javax.swing.JMenu();
        jMenuItemListaDePedidos = new javax.swing.JMenuItem();
        jMenuLogout = new javax.swing.JMenu();
        jMenuSair = new javax.swing.JMenu();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gerenciamento de FastFood");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );

        jLabelFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.jpg"))); // NOI18N

        jMenuCadastro.setText("Cadastros");

        jMenuItemCadastroDeUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemCadastroDeUsuario.setText("Usuário");
        jMenuItemCadastroDeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroDeUsuarioActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCadastroDeUsuario);

        jMenuItemIngrediente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemIngrediente.setText("Ingrediente");
        jMenuItemIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemIngredienteActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemIngrediente);

        jMenuItemCadastroDeReceita.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemCadastroDeReceita.setText("Receita");
        jMenuItemCadastroDeReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroDeReceitaActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCadastroDeReceita);

        jMenuItemProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemProduto.setText("Produto");
        jMenuItemProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProdutoActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemProduto);

        jMenuBar1.add(jMenuCadastro);

        jMenuAbrirCaixa.setText("Caixa");

        jMenuItemAbrirCaixa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemAbrirCaixa.setText("Abrir Caixa");
        jMenuItemAbrirCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAbrirCaixaActionPerformed(evt);
            }
        });
        jMenuAbrirCaixa.add(jMenuItemAbrirCaixa);

        jMenuItemFecharCaixa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemFecharCaixa.setText("Fechar Caixa");
        jMenuItemFecharCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFecharCaixaActionPerformed(evt);
            }
        });
        jMenuAbrirCaixa.add(jMenuItemFecharCaixa);

        jMenuBar1.add(jMenuAbrirCaixa);

        jMenuPedido.setText("Pedido");

        jMenuItemAbrirPedido.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemAbrirPedido.setText("Abrir Pedido");
        jMenuItemAbrirPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAbrirPedidoActionPerformed(evt);
            }
        });
        jMenuPedido.add(jMenuItemAbrirPedido);

        jMenuItemPagamento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemPagamento.setText("Pagamento");
        jMenuItemPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPagamentoActionPerformed(evt);
            }
        });
        jMenuPedido.add(jMenuItemPagamento);

        jMenuBar1.add(jMenuPedido);

        jMenuEstoque.setText("Estoque");

        jMenuItemAbrirEstoque.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemAbrirEstoque.setText("Cadastar Estoque");
        jMenuItemAbrirEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAbrirEstoqueActionPerformed(evt);
            }
        });
        jMenuEstoque.add(jMenuItemAbrirEstoque);

        jMenuItemConsutarEstoque.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemConsutarEstoque.setText("Consultar Estoque");
        jMenuItemConsutarEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsutarEstoqueActionPerformed(evt);
            }
        });
        jMenuEstoque.add(jMenuItemConsutarEstoque);

        jMenuBar1.add(jMenuEstoque);

        jMenuCozinha.setText("Cozinha");

        jMenuItemListaDePedidos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemListaDePedidos.setText("Lista de Produtos Pedidos");
        jMenuItemListaDePedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListaDePedidosActionPerformed(evt);
            }
        });
        jMenuCozinha.add(jMenuItemListaDePedidos);

        jMenuBar1.add(jMenuCozinha);

        jMenuLogout.setText("Logout");
        jMenuLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuLogoutMouseClicked(evt);
            }
        });
        jMenuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuLogoutActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenuLogout);

        jMenuSair.setText("Sair");
        jMenuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuSairMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelFundo, javax.swing.GroupLayout.PREFERRED_SIZE, 1316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabelFundo)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCadastroDeReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroDeReceitaActionPerformed

        switch (usuarioModel.getNivel()) {
            case 1:
            case 2:
            case 4:
                ReceitaView rec = new ReceitaView();
                rec.setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(this, usuarioModel.getNome() + "\nvocê não tem permissao para entrar nesse módulo!", "Permissão", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jMenuItemCadastroDeReceitaActionPerformed

    private void jMenuItemCadastroDeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroDeUsuarioActionPerformed
        switch (usuarioModel.getNivel()) {
            case 1:
                UsuarioView user = new UsuarioView();
                user.setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(this, usuarioModel.getNome() + "\nvocê não tem permissao para entrar nesse módulo!", "Permissão", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemCadastroDeUsuarioActionPerformed

    private void jMenuItemAbrirCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAbrirCaixaActionPerformed

        switch (usuarioModel.getNivel()) {
            case 1:
            case 2:
            case 3:
                AbrirCaixaView cx = new AbrirCaixaView(usuarioModel);
                cx.setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(this, usuarioModel.getNome() + "\nvocê não tem permissao para entrar nesse módulo!", "Permissão", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemAbrirCaixaActionPerformed

    private void jMenuItemProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProdutoActionPerformed

        switch (usuarioModel.getNivel()) {
            case 1:
            case 2:
            case 3:
            case 4:
                ProdutoView pro = new ProdutoView();
                pro.setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(this, usuarioModel.getNome() + "\nvocê não tem permissao para entrar nesse módulo!", "Permissão", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemProdutoActionPerformed

    private void jMenuItemIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemIngredienteActionPerformed

        switch (usuarioModel.getNivel()) {
            case 1:
            case 2:
            case 4:
                IngredienteView ingre = new IngredienteView();
                ingre.setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(this, usuarioModel.getNome() + "\nvocê não tem permissao para entrar nesse módulo!", "Permissão", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_jMenuItemIngredienteActionPerformed

    private void jMenuItemAbrirPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAbrirPedidoActionPerformed

        switch (usuarioModel.getNivel()) {
            case 1:
            case 2:
            case 3:
                PedidoView ped = new PedidoView();
                ped.setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(this, usuarioModel.getNome() + "\nvocê não tem permissao para entrar nesse módulo!", "Permissão", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemAbrirPedidoActionPerformed

    private void jMenuItemAbrirEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAbrirEstoqueActionPerformed

        switch (usuarioModel.getNivel()) {
            case 1:
            case 2:
                EstoqueView est = new EstoqueView();
                est.setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(this, usuarioModel.getNome() + "\nvocê não tem permissao para entrar nesse módulo!", "Permissão", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemAbrirEstoqueActionPerformed

    private void jMenuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSairMouseClicked

        Object[] options = {"Sim", "Não"};
        int i = JOptionPane.showOptionDialog(null,
                "Tem certeza que deseja sair?", "ATENÇÃO",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                options, options[0]);
        if (i == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }//GEN-LAST:event_jMenuSairMouseClicked

    private void jMenuItemFecharCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFecharCaixaActionPerformed

        switch (usuarioModel.getNivel()) {
            case 1:
            case 2:
            case 3:
                FecharCaixaView fc = new FecharCaixaView();
                fc.setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(this, usuarioModel.getNome() + "\nvocê não tem permissao para entrar nesse módulo!", "Permissão", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemFecharCaixaActionPerformed

    private void jMenuItemConsutarEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsutarEstoqueActionPerformed

        switch (usuarioModel.getNivel()) {
            case 1:
            case 2:
                RelatorioEstoqueView reEs = new RelatorioEstoqueView();
                reEs.setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(this, usuarioModel.getNome() + "\nvocê não tem permissao para entrar nesse módulo!", "Permissão", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemConsutarEstoqueActionPerformed

    private void jMenuItemListaDePedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListaDePedidosActionPerformed

        switch (usuarioModel.getNivel()) {
            case 1:
            case 2:
            case 3:
                ListaPedidosAbertosView lisPed = new ListaPedidosAbertosView();
                lisPed.setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(this, usuarioModel.getNome() + "\nvocê não tem permissao para entrar nesse módulo!", "Permissão", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemListaDePedidosActionPerformed

    private void jMenuItemPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPagamentoActionPerformed

        switch (usuarioModel.getNivel()) {
            case 1:
            case 2:
            case 3:
                PagamentoView pag = new PagamentoView();
                pag.setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(this, usuarioModel.getNome() + "\nvocê não tem permissao para entrar nesse módulo!", "Permissão", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemPagamentoActionPerformed

    private void jMenuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuLogoutActionPerformed

    }//GEN-LAST:event_jMenuLogoutActionPerformed

    private void jMenuLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuLogoutMouseClicked

        Object[] options = {"Sim", "Não"};
        int i = JOptionPane.showOptionDialog(null,
                "Tem certeza que deseja fazer logout desse usuario?", "ATENÇÃO",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                options, options[0]);
        if (i == JOptionPane.YES_OPTION) {
            new LoginView().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jMenuLogoutMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JMenu jMenuAbrirCaixa;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenu jMenuCozinha;
    private javax.swing.JMenu jMenuEstoque;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemAbrirCaixa;
    private javax.swing.JMenuItem jMenuItemAbrirEstoque;
    private javax.swing.JMenuItem jMenuItemAbrirPedido;
    private javax.swing.JMenuItem jMenuItemCadastroDeReceita;
    private javax.swing.JMenuItem jMenuItemCadastroDeUsuario;
    private javax.swing.JMenuItem jMenuItemConsutarEstoque;
    private javax.swing.JMenuItem jMenuItemFecharCaixa;
    private javax.swing.JMenuItem jMenuItemIngrediente;
    private javax.swing.JMenuItem jMenuItemListaDePedidos;
    private javax.swing.JMenuItem jMenuItemPagamento;
    private javax.swing.JMenuItem jMenuItemProduto;
    private javax.swing.JMenu jMenuLogout;
    private javax.swing.JMenu jMenuPedido;
    private javax.swing.JMenu jMenuSair;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
