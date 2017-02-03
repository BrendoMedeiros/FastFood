package DAO;

import bd.ConnectionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ItemPedidoModel;
import model.PedidoModel;
import model.ProdutoModel;
import model.ReceitaModel;

public class ProdutoDAO {

    private Connection conn = null;
    private ProdutoModel pro = null;
    private ItemPedidoModel itemPedido;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ProdutoDAO() throws Exception {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
            throw new Exception(("Erro:  \n" + e.getMessage()));
        }
    }

    public void salvar(Object ob) throws Exception {

        this.pro = (ProdutoModel) ob;
        if (pro == null) {
            throw new Exception("O valor passado não pode ser nulo!");
        }
        try {

            String SQL = "INSERT INTO fastfood.produto(nome, preco, produto_id_receita) "
                    + " VALUES (?, ?, ?);";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, pro.getNome());
            ps.setFloat(2, pro.getPreco());
            ps.setInt(3, pro.getProdutoIdReceita().getIdReceita());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados ao produto: \n" + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public void excluir(Object ob) throws Exception {
        this.pro = (ProdutoModel) ob;

        if (pro == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            ps = conn.prepareStatement("DELETE FROM fastfood.produto WHERE id_produto = ?;");
            ps.setInt(1, pro.getIdProduto());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Exclusão do produto " + ob.toString() + " realizada com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados: " + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public void atualizar(Object ob) throws Exception {
        this.pro = (ProdutoModel) ob;

        if (pro == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {

            ps = conn.prepareStatement("UPDATE fastfood.produto\n"
                    + "	SET id_produto=?, nome=?, preco=?, produto_id_receita=? \n"
                    + "	WHERE id_produto = ?;");
            ps.setInt(1, pro.getIdProduto());
            ps.setString(2, pro.getNome());
            ps.setFloat(3, pro.getPreco());
            ps.setInt(4, pro.getProdutoIdReceita().getIdReceita());
            ps.setInt(5, pro.getIdProduto());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Erro ao atualizar dados: " + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public List listarTodos() throws Exception {

        try {
            ps = conn.prepareStatement("SELECT id_produto, nome, preco, produto_id_receita FROM fastfood.produto;");
            rs = ps.executeQuery();
            List<ProdutoModel> list = new ArrayList<ProdutoModel>();
            while (rs.next()) {
                int idProduto = rs.getInt(1);
                String nome = rs.getString(2);
                Float preco = rs.getFloat(3);
                ReceitaModel rec = new ReceitaModel();
                rec.setIdReceita(rs.getInt(4));
                list.add(new ProdutoModel(idProduto, nome, preco, rec));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    public ArrayList<ProdutoModel> buscarCaixa(Object ob) throws Exception {
        this.pro = (ProdutoModel) ob;
        try {
            ps = conn.prepareStatement("SELECT id_produto, nome, preco, produto_id_receita FROM fastfood.caixa WHERE id_produto=?;");
            ps.setInt(1, pro.getIdProduto());
            rs = ps.executeQuery();
            ArrayList<ProdutoModel> list = new ArrayList<ProdutoModel>();
            while (rs.next()) {
                int idProduto = rs.getInt(1);
                String nome = rs.getString(2);
                Float preco = rs.getFloat(3);
                ReceitaModel rec = new ReceitaModel();
                rec.setIdReceita(rs.getInt(4));
                list.add(new ProdutoModel(idProduto, nome, preco, rec));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    public ArrayList<ItemPedidoModel> buscaPedidoDoProduto(Object ob) throws Exception {
        PedidoModel ped = (PedidoModel) ob;
        try {
            ps = conn.prepareStatement(" SELECT id_produto, nome, item_produto_quantidade"
                    + "  FROM fastfood.pedido, fastfood.item_produto, fastfood.produto"
                    + "  WHERE fastfood.item_produto.item_produto_id_pedido = ?"
                    + "  AND fastfood.item_produto.item_produto_id_produto = fastfood.produto.id_produto; ");

            ps.setInt(1, ped.getIdPedido());
            rs = ps.executeQuery();

            ArrayList<ItemPedidoModel> list = new ArrayList<ItemPedidoModel>();
            while (rs.next()) {
                int idProduto = rs.getInt(1);
                String nome = rs.getString(2);
                Float qtde = rs.getFloat(3);
                ProdutoModel pro = new ProdutoModel();

                pro.setIdProduto(idProduto);
                pro.setNome(nome);

                list.add(new ItemPedidoModel(idProduto, ped, pro, idProduto));
            }

            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    //    public List procura(Object ob) throws Exception {
//        this.cx = (CaixaModel) ob;
//        if (cx == null) {
//            throw new Exception("O valor passado não pode ser nulo");
//        }
//        try {
//            String SQL = "SELECT id_caixa, data, valor, hora_fechamento, hora_abertura, caixa_id_usuario FROM fastfood.caixa;";
//            String where = "";
//            boolean checa = false;
//            if (cx.getIdCaixa()!= 0 || cx.getData()!= null || cx.get() != null) {
//                where = "where ";
//                if (cx.getIdUsuario() != 0) {
//                    where += "id_usuario=? ";
//                    checa = true;
//                }
//                if (cx.getNome() != null) {
//                    if (checa) {
//                        where += "and";
//                    }
//                    where += " nome=? ";
//                    checa = true;
//                }
//                if (cx.getCpf() != null) {
//                    if (checa) {
//                        where += "and";
//                    }
//                    where += " cpf=? ";
//                }
//            }
//            ps = conn.prepareStatement(SQL + where);
//            int contaCampos = 1;
//            if (cx.getIdUsuario() != 0 || cx.getNome() != null || cx.getCpf() != null) {
//                if (cx.getIdUsuario() != 0) {
//                    ps.setInt(contaCampos, cx.getIdUsuario());
//                    contaCampos++;
//                }
//                if (cx.getNome() != null) {
//                    ps.setString(contaCampos, cx.getNome());
//                    contaCampos++;
//                }
//                if (cx.getCpf() != null) {
//                    ps.setString(contaCampos, cx.getCpf());
//                }
//            }
//            rs = ps.executeQuery();
//            List<UsuarioModel> list = new ArrayList<UsuarioModel>();
//            while (rs.next()) {
//                int idUsuario = rs.getInt(1);
//                String nome = rs.getString(2);
//                String cpf = rs.getString(3);
//                String rg = rs.getString(4);
//                String endereco = rs.getString(5);
//                String telefone = rs.getString(6);
//                int nivel = rs.getInt(7);
//                String usuario = rs.getString(8);
//                int senha = rs.getInt(9);
//                list.add(new UsuarioModel(idUsuario, nome, cpf, rg, endereco, telefone, nivel, usuario, senha));
//            }
//            return list;
//        } catch (SQLException sqle) {
//            throw new Exception(sqle);
//        } finally {
//            ConnectionDAO.closeConnection(conn, ps, rs);
//        }
//    }
}
