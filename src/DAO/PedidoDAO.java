package DAO;

import bd.ConnectionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.CaixaModel;
import model.ItemPedidoModel;
import model.PedidoModel;
import model.ProdutoModel;
import model.UsuarioModel;

public class PedidoDAO {

    private Connection conn;
    private PedidoModel ped;
    private ItemPedidoModel itemPed;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public PedidoDAO() throws Exception {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro: \n" + e.getMessage());
        }
    }

    public Integer salvar(Object ob) throws Exception {
        
        Integer idPedido = 0;
        this.ped = (PedidoModel) ob;
        if (ped == null) {
            throw new Exception("O valor passado não pode ser nulo!");
        }
        try {

            String SQL = " INSERT INTO fastfood.pedido(data_pedido, estado_pedido, pedido_id_caixa, pedido_id_usuario) "
                    + " VALUES (?, ?, ?, ?) RETURNING id_pedido; ";
            ps = conn.prepareStatement(SQL);
            ps.setDate(1, Date.valueOf(ped.getDataPedido()));
            ps.setString(2, ped.getStatusPedido());
            ps.setInt(3, ped.getPedidoIdCaixa().getIdCaixa());
            ps.setInt(4, ped.getCliente().getIdUsuario());
            rs = ps.executeQuery();
            while (rs.next()) {
                idPedido = rs.getInt(1);
            }

        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados ao pedido: \n" + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
        return idPedido;
    }

    public void salvarItensPedido(Object ob) throws Exception {

        this.itemPed = (ItemPedidoModel) ob;
        System.out.println(itemPed.getItemProdutoIdPedido().getIdPedido());
        if (itemPed == null) {
            throw new Exception("O valor passado não pode ser nulo!");
        }
        try {

            String SQL = " INSERT INTO fastfood.item_produto(item_produto_id_pedido, item_produto_id_produto, item_produto_quantidade) "
                    + " VALUES (?, ?, ?) ;";
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, itemPed.getItemProdutoIdPedido().getIdPedido());
            ps.setInt(2, itemPed.getItemProdutoIdProduto().getIdProduto());
            ps.setInt(3, itemPed.getItemProdutoQuantidade());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados ao item do pedido: \n" + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public void excluir(Object ob) throws Exception {
        this.ped = (PedidoModel) ob;

        if (ped == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            ps = conn.prepareStatement("DELETE FROM fastfood.pedido WHERE id_pedido = ?;");
            ps.setInt(1, ped.getIdPedido());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Exclusão do pedido " + ob.toString() + " realizada com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados: " + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public void excluirItensPedido(Object ob) throws Exception {
        this.itemPed = (ItemPedidoModel) ob;

        if (itemPed == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            ps = conn.prepareStatement("DELETE FROM fastfood.item_produto WHERE fastfood.item_produto.id_item_produto = ?;");
            ps.setInt(1, itemPed.getIdItemProduto());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Exclusão do item do pedido " + ob.toString() + " realizada com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados: " + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public void atualizar(Object ob) throws Exception {
        this.ped = (PedidoModel) ob;

        if (ped == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {

            ps = conn.prepareStatement("UPDATE fastfood.pedido "
                    + "	SET id_pedido=?, data_pedido=?, estado_pedido=?, pedido_id_caixa=?, pedido_id_usuario = ? "
                    + "	WHERE id_pedido = ?;");
            ps.setInt(1, ped.getIdPedido());
            ps.setDate(2, Date.valueOf(ped.getDataPedido()));
            ps.setString(3, ped.getStatusPedido());
            ps.setInt(4, ped.getPedidoIdCaixa().getIdCaixa());
            ps.setInt(5, ped.getCliente().getIdUsuario());
            ps.setInt(6, ped.getIdPedido());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Erro ao atualizar pedido: " + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public List listarTodos() throws Exception {

        try {
            ps = conn.prepareStatement("SELECT id_pedido, data_pedido, estado_pedido, pedido_id_caixa, pedido_id_usuario"
                    + " FROM fastfood.pedido;");
            rs = ps.executeQuery();
            List<PedidoModel> list = new ArrayList<PedidoModel>();
            while (rs.next()) {
                int idPedido = rs.getInt(1);
                LocalDate dataPedido = rs.getDate(2).toLocalDate();
                String estadoPedido = rs.getString(3);

                CaixaModel cx1 = new CaixaModel();
                cx1.setIdCaixa(rs.getInt(4));
                list.add(new PedidoModel(idPedido, dataPedido, estadoPedido, new UsuarioModel(rs.getInt(5)), cx1));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    public ArrayList<PedidoModel> buscarPedido(Object ob) throws Exception {
        this.ped = (PedidoModel) ob;
        try {
            ps = conn.prepareStatement("SELECT id_pedido, data_pedido, estado_pedido, pedido_id_caixa "
                    + " FROM fastfood.pedido "
                    + " WHERE id_pedido=?;");
            ps.setInt(1, ped.getIdPedido());
            rs = ps.executeQuery();
            ArrayList<PedidoModel> list = new ArrayList<PedidoModel>();
            while (rs.next()) {
                int idPedido = rs.getInt(1);
                LocalDate dataPedido = rs.getDate(2).toLocalDate();
                String estadoPedido = rs.getString(3);

                CaixaModel cx1 = new CaixaModel();
                cx1.setIdCaixa(rs.getInt(4));
                list.add(new PedidoModel(idPedido, dataPedido, estadoPedido, new UsuarioModel(rs.getInt(5)), cx1));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    public ArrayList<PedidoModel> buscarPedidosAbertos() throws Exception {
        try {
            ps = conn.prepareStatement("SELECT id_pedido, data_pedido, estado_pedido, pedido_id_caixa, pedido_id_usuario, nome "
                    + " FROM fastfood.pedido, fastfood.usuario "
                    + " WHERE estado_pedido = 'AB'"
                    + " AND fastfood.pedido.pedido_id_usuario = fastfood.usuario.id_usuario;");
            rs = ps.executeQuery();
            ArrayList<PedidoModel> list = new ArrayList<PedidoModel>();
            while (rs.next()) {
                int idPedido = rs.getInt(1);
                LocalDate dataPedido = rs.getDate(2).toLocalDate();
                String estadoPedido = rs.getString(3);
                CaixaModel cx1 = new CaixaModel();
                cx1.setIdCaixa(rs.getInt(4));
                list.add(new PedidoModel(idPedido, dataPedido, estadoPedido, new UsuarioModel(rs.getInt(5), rs.getString(6)), cx1));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    public ArrayList<PedidoModel> buscarPedidosPronto() throws Exception {
        try {
            ps = conn.prepareStatement("SELECT id_pedido, data_pedido, estado_pedido, pedido_id_caixa, pedido_id_usuario, nome "
                    + " FROM fastfood.pedido, fastfood.usuario "
                    + " WHERE estado_pedido = 'FC'"
                    + " AND fastfood.pedido.pedido_id_usuario = fastfood.usuario.id_usuario;");
            rs = ps.executeQuery();
            ArrayList<PedidoModel> list = new ArrayList<PedidoModel>();
            while (rs.next()) {
                int idPedido = rs.getInt(1);
                LocalDate dataPedido = rs.getDate(2).toLocalDate();
                String estadoPedido = rs.getString(3);
                CaixaModel cx1 = new CaixaModel();
                cx1.setIdCaixa(rs.getInt(4));
                list.add(new PedidoModel(idPedido, dataPedido, estadoPedido, new UsuarioModel(rs.getInt(5), rs.getString(6)), cx1));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    public ArrayList<ItemPedidoModel> buscaItensPedido(Object ob) throws Exception {
        PedidoModel ped = (PedidoModel) ob;
        try {
            ps = conn.prepareStatement("SELECT fastfood.item_produto.id_item_produto, fastfood.pedido.id_pedido, fastfood.produto.id_produto, "
                    + " fastfood.item_produto.item_produto_quantidade, fastfood.produto.nome, fastfood.produto.preco \n"
                    + "    FROM fastfood.pedido, fastfood.item_produto, fastfood.produto\n"
                    + "    WHERE fastfood.item_produto.item_produto_id_pedido = ?\n"
                    + "    AND fastfood.item_produto.item_produto_id_produto = fastfood.produto.id_produto\n"
                    + "    AND fastfood.item_produto.item_produto_id_pedido = fastfood.pedido.id_pedido; ");

            ps.setInt(1, ped.getIdPedido());
            rs = ps.executeQuery();

            ArrayList<ItemPedidoModel> list = new ArrayList<ItemPedidoModel>();
            while (rs.next()) {
                int idItemProduto = rs.getInt(1);
                int IdPedido = rs.getInt(2);
                int IdProduto = rs.getInt(3);
                int Quantidade = rs.getInt(4);
                String descricao = rs.getString(5);

                ProdutoModel pro = new ProdutoModel(IdProduto, descricao, rs.getFloat(6), null);

                list.add(new ItemPedidoModel(idItemProduto, ped, pro, Quantidade));
            }

            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }
}
