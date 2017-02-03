package DAO;

import bd.ConnectionDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.CaixaModel;
import model.UsuarioModel;

public class CaixaDAO {

    private Connection conn = null;
    private CaixaModel cx = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private double total = 0.0;
    private double valorAbertura = 0.0;

    public CaixaDAO() throws Exception {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
            throw new Exception(("Erro:  \n" + e.getMessage()));
        }
    }

    public void salvar(Object ob) throws Exception {

        this.cx = (CaixaModel) ob;
        if (cx == null) {
            throw new Exception("O valor passado não pode ser nulo!");
        }
        try {

            String SQL = "INSERT INTO fastfood.caixa(data, valor, hora_fechamento, hora_abertura, caixa_id_usuario) "
                    + " VALUES (?, ?, ?, ?, ?);";
            ps = conn.prepareStatement(SQL);
            ps.setDate(1, Date.valueOf(cx.getData()));
            ps.setFloat(2, cx.getValor());
            ps.setTime(3, Time.valueOf(cx.getHoraFechamento()));
            ps.setTime(4, Time.valueOf(cx.getHoraAbertura()));
            ps.setInt(5, cx.getCaixaIdUsuario().getIdUsuario());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados ao caixa: \n" + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public void excluir(Object ob) throws Exception {
        this.cx = (CaixaModel) ob;

        if (cx == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            ps = conn.prepareStatement("DELETE FROM fastfood.caixa WHERE id_caixa = ?;");
            ps.setInt(1, cx.getIdCaixa());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Exclusão do caixa " + ob.toString() + " realizada com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados: " + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public void atualizar(Object ob) throws Exception {
        this.cx = (CaixaModel) ob;

        if (cx == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {

            ps = conn.prepareStatement("UPDATE fastfood.caixa\n"
                    + "	SET id_caixa=?, data=?, valor=?, hora_fechamento=?, hora_abertura=?, caixa_id_usuario=? \n"
                    + "	WHERE id_caixa = ?;");
            ps.setInt(1, cx.getIdCaixa());
            ps.setDate(2, Date.valueOf(cx.getData()));
            ps.setFloat(3, cx.getValor());
            ps.setTime(4, Time.valueOf(cx.getHoraAbertura()));
            ps.setTime(5, Time.valueOf(cx.getHoraFechamento()));
            ps.setInt(6, cx.getCaixaIdUsuario().getIdUsuario());
            ps.setInt(7, cx.getIdCaixa());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Erro ao atualizar dados: " + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public List listarTodos() throws Exception {

        try {
            ps = conn.prepareStatement("SELECT id_caixa, data, valor, hora_fechamento, hora_abertura, caixa_id_usuario FROM fastfood.caixa;");
            rs = ps.executeQuery();
            List<CaixaModel> list = new ArrayList<CaixaModel>();
            while (rs.next()) {
                int idCaixa = rs.getInt(1);
                LocalDate data = rs.getDate(2).toLocalDate();
                Float valor = rs.getFloat(3);
                LocalTime horaFechamento = rs.getTime(4).toLocalTime();
                LocalTime horaAbertura = rs.getTime(5).toLocalTime();
                UsuarioModel user = new UsuarioModel();
                user.setIdUsuario(rs.getInt(6));
                list.add(new CaixaModel(idCaixa, data, valor, horaFechamento, horaAbertura, user));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    public Double buscarValorTotaldoFaturameto() throws Exception {
        try {
            ps = conn.prepareStatement("SELECT fastfood.caixa.valor, (item_produto_quantidade * preco) as total "
                    + "  FROM  fastfood.caixa, fastfood.pedido, fastfood.item_produto, fastfood.produto "
                    + "  WHERE fastfood.pedido.id_pedido = fastfood.item_produto.item_produto_id_pedido "
                    + "  AND fastfood.item_produto.item_produto_id_produto = fastfood.produto.id_produto "
                    + "  AND fastfood.caixa.hora_fechamento = '00:00:00'  AND fastfood.pedido.estado_pedido = 'AB' ");
            rs = ps.executeQuery();

            while (rs.next()) {
                valorAbertura = rs.getDouble(1);
                total += rs.getDouble(2);
            }
            return total + valorAbertura;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    public ArrayList<CaixaModel> buscarCaixa(Object ob) throws Exception {
        this.cx = (CaixaModel) ob;
        try {
            ps = conn.prepareStatement("SELECT id_caixa, data, valor, hora_fechamento, hora_abertura, caixa_id_usuario "
                    + "FROM fastfood.caixa "
                    + "WHERE id_caixa=?;");
            ps.setInt(1, cx.getIdCaixa());
            rs = ps.executeQuery();
            ArrayList<CaixaModel> list = new ArrayList<CaixaModel>();
            while (rs.next()) {
                int idCaixa = rs.getInt(1);
                LocalDate data = rs.getDate(2).toLocalDate();
                float valor = rs.getFloat(3);
                LocalTime horaFechamento = rs.getTime(4).toLocalTime();
                LocalTime horaAbertura = rs.getTime(5).toLocalTime();
                UsuarioModel user = new UsuarioModel();
                user.setIdUsuario(rs.getInt(6));
                list.add(new CaixaModel(idCaixa, data, valor, horaAbertura, horaFechamento, user));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    public ArrayList<CaixaModel> buscarCaixaCorrente() throws Exception {
        try {
            ps = conn.prepareStatement("SELECT id_caixa, data, valor, hora_fechamento, hora_abertura, caixa_id_usuario "
                    + "FROM fastfood.caixa "
                    + " WHERE fastfood.caixa.hora_fechamento = '00:00:00' ;");
            rs = ps.executeQuery();
            ArrayList<CaixaModel> list = new ArrayList<CaixaModel>();
            while (rs.next()) {
                int idCaixa = rs.getInt(1);
                LocalDate data = rs.getDate(2).toLocalDate();
                float valor = rs.getFloat(3);
                LocalTime horaFechamento = rs.getTime(4).toLocalTime();
                LocalTime horaAbertura = rs.getTime(5).toLocalTime();
                UsuarioModel user = new UsuarioModel();
                user.setIdUsuario(rs.getInt(6));
                list.add(new CaixaModel(idCaixa, data, valor, horaAbertura, horaFechamento, user));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }
}