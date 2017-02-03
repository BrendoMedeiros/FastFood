package DAO;

import bd.ConnectionDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.PagamentoModel;
import model.PedidoModel;

public class PagamentoDAO {

    private Connection conn = null;
    private PagamentoModel pagModel = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public PagamentoDAO() throws Exception {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
            throw new Exception(("Erro:  \n" + e.getMessage()));
        }
    }

    public void salvar(Object ob) throws Exception {

        this.pagModel = (PagamentoModel) ob;
        if (pagModel == null) {
            throw new Exception("O valor passado não pode ser nulo!");
        }
        try {
            conn.setAutoCommit(false);
            String SQL = "INSERT INTO fastfood.pagamento(data, tipo_pagamento, id_pedido) "
                    + "VALUES (?, ?, ?);";
            ps = conn.prepareStatement(SQL);
            ps.setDate(1, Date.valueOf(pagModel.getData()));
            ps.setString(2, pagModel.getTipoPagamento());
            ps.setInt(3, pagModel.getPedido().getIdPedido());
            ps.executeUpdate();

            ps = conn.prepareStatement("UPDATE fastfood.pedido "
                    + " SET estado_pedido = ? "
                    + " WHERE fastfood.pedido.id_pedido = ?;");
            ps.setString(1, pagModel.getPedido().getStatusPedido());
            ps.setInt(2, pagModel.getPedido().getIdPedido());

            ps.executeUpdate();
            conn.commit();
        } catch (SQLException sqle) {
            conn.rollback();
            throw new Exception("Erro ao inserir dados ao pagamento: \n" + sqle);
        } finally {
            conn.setAutoCommit(true);
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public void excluir(Object ob) throws Exception {
        this.pagModel = (PagamentoModel) ob;

        if (pagModel == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            ps = conn.prepareStatement("DELETE FROM fastfood.pagamento  WHERE fastfood.pagamento.id_pagamento = ?;");
            ps.setInt(1, pagModel.getIdPagamento());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Exclusão do pagamento " + ob.toString() + " realizada com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados: " + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public void atualizar(Object ob) throws Exception {
        this.pagModel = (PagamentoModel) ob;

        if (pagModel == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            conn.setAutoCommit(false);

            ps = conn.prepareStatement(" UPDATE fastfood.pagamento "
                    + " SET  data=?, tipo_pagamento=?, id_pedido=? "
                    + " WHERE fastfood.pagamento.id_pagamento = ?;");
            ps.setDate(1, Date.valueOf(pagModel.getData()));
            ps.setString(2, pagModel.getTipoPagamento());
            ps.setInt(3, pagModel.getPedido().getIdPedido());
            ps.setInt(7, pagModel.getIdPagamento());
            ps.executeUpdate();

            ps = conn.prepareStatement("UPDATE fastfood.pedido "
                    + " SET   estado_pedido = ?, "
                    + " WHERE fastfood.pedido.id_pedido = ?;");
            ps.setString(1, pagModel.getPedido().getStatusPedido());
            ps.setInt(2, pagModel.getPedido().getIdPedido());

            ps.executeUpdate();

            conn.commit();
        } catch (SQLException sqle) {
            conn.rollback();
            throw new Exception("Erro ao atualizar dados: " + sqle);
        } finally {
            conn.setAutoCommit(true);
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public List listarTodos() throws Exception {

        try {
            ps = conn.prepareStatement("SELECT id_pagamento, data, tipo_pagamento, id_pedido  FROM fastfood.pagamento;");
            rs = ps.executeQuery();
            List<PagamentoModel> list = new ArrayList<PagamentoModel>();
            while (rs.next()) {
                int idPagamento = rs.getInt(1);
                LocalDate data = rs.getDate(2).toLocalDate();
                String tpPag = rs.getString(3);
                PedidoModel ped = new PedidoModel(rs.getInt(4));

                list.add(new PagamentoModel(idPagamento, data, tpPag, ped));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    public ArrayList<PagamentoModel> buscarCaixaCorrente(Object ob) throws Exception {
        this.pagModel = (PagamentoModel) ob; 
        try {
            ps = conn.prepareStatement("SELECT id_pagamento, data, tipo_pagamento, id_pedido "
                    + " FROM fastfood.pagamento"
                    + " WHERE fastfood.pagamento.id_pagamento = ? ;");
            ps.setInt(1, pagModel.getIdPagamento());
            rs = ps.executeQuery();
            ArrayList<PagamentoModel> list = new ArrayList<PagamentoModel>();
            while (rs.next()) {
                int idPagamento = rs.getInt(1);
                LocalDate data = rs.getDate(2).toLocalDate();
                String tpPag = rs.getString(3);
                PedidoModel ped = new PedidoModel(rs.getInt(4));

                list.add(new PagamentoModel(idPagamento, data, tpPag, ped));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }
}