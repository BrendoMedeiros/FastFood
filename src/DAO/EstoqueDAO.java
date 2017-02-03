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
import model.EstoqueModel;
import model.IngredienteModel;

public class EstoqueDAO {

    private Connection conn = null;
    private EstoqueModel est = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public EstoqueDAO() throws Exception {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
            throw new Exception(("Erro:  \n" + e.getMessage()));
        }
    }

    public void salvar(Object ob) throws Exception {

        this.est = (EstoqueModel) ob;
        if (est == null) {
            throw new Exception("O valor passado não pode ser nulo!");
        }
        try {

            String SQL = "INSERT INTO fastfood.estoque(quantidade, unidade, data_Validade, estoque_Id_Ingrediente) "
                    + " VALUES (?, ?, ?, ?);";
            ps = conn.prepareStatement(SQL);
            ps.setDouble(1, est.getQuantidade());
            ps.setString(2, est.getUnidade());
            ps.setDate(3, Date.valueOf(est.getDataValidade()));
            ps.setInt(4, est.getEstoqueIdIngrediente().getIdIngrediente());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados ao estoque: \n" + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public void excluir(Object ob) throws Exception {
        this.est = (EstoqueModel) ob;

        if (est == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            ps = conn.prepareStatement("DELETE FROM fastfood.estoque WHERE id_estoque = ?;");
            ps.setInt(1, est.getIdEstoque());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Exclusão do estoque " + ob.toString() + " realizada com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados: " + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public void atualizar(Object ob) throws Exception {
        this.est = (EstoqueModel) ob;

        if (est == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {

            ps = conn.prepareStatement("UPDATE fastfood.estoque\n"
                    + "	SET id_estoque=?, quantidade=?, unidade=?, data_validade=?, estoque_Id_Ingrediente=? \n"
                    + "	WHERE id_estoque = ?;");
            ps.setInt(1, est.getIdEstoque());
            ps.setDouble(2, est.getQuantidade());
            ps.setString(3, est.getUnidade());
            ps.setDate(4, Date.valueOf(est.getDataValidade()));
            ps.setInt(5, est.getEstoqueIdIngrediente().getIdIngrediente());
            ps.setInt(6, est.getIdEstoque());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Erro ao atualizar estoque: " + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public List listarTodos() throws Exception {

        try {
            ps = conn.prepareStatement("SELECT id_estoque, quantidade, unidade, data_Validade, estoque_Id_Ingrediente FROM fastfood.estoque;");
            rs = ps.executeQuery();
            List<EstoqueModel> list = new ArrayList<EstoqueModel>();
            while (rs.next()) {
                int idEstoque = rs.getInt(1);
                Double quantidade = rs.getDouble(2);
                String unidade = rs.getString(3);
                LocalDate dataValidade = rs.getDate(4).toLocalDate();

                IngredienteModel est1 = new IngredienteModel();
                est1.setIdIngrediente(rs.getInt(5));
                list.add(new EstoqueModel(idEstoque, quantidade, unidade, dataValidade, est1));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    public ArrayList<EstoqueModel> buscarEstoque(Object ob) throws Exception {
        this.est = (EstoqueModel) ob;
        try {
            ps = conn.prepareStatement("SELECT id_estoque, quantidade, unidade, data_Validade, estoque_Id_Ingrediente FROM fastfood.estoqeu WHERE id_estoque=?;");
            ps.setInt(1, est.getIdEstoque());
            rs = ps.executeQuery();
            ArrayList<EstoqueModel> list = new ArrayList<EstoqueModel>();
            while (rs.next()) {
                int idEstoque = rs.getInt(1);
                Double quantidade = rs.getDouble(2);
                String unidade = rs.getString(3);
                LocalDate dataValidade = rs.getDate(4).toLocalDate();

                IngredienteModel est1 = new IngredienteModel();
                est1.setIdIngrediente(rs.getInt(5));
                list.add(new EstoqueModel(idEstoque, quantidade, unidade, dataValidade, est1));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    public ArrayList<EstoqueModel> buscarEstoqueDoIngrediente(Object ob) throws Exception {
        IngredienteModel ing = (IngredienteModel) ob;
        try {
            ps = conn.prepareStatement("SELECT id_estoque, quantidade, unidade, data_Validade, estoque_Id_Ingrediente FROM fastfood.estoque WHERE estoque_Id_Ingrediente = ?;");
            ps.setInt(1, ing.getIdIngrediente());
            rs = ps.executeQuery();
            ArrayList<EstoqueModel> list = new ArrayList<EstoqueModel>();
            while (rs.next()) {
                int idEstoque = rs.getInt(1);
                Double quantidade = rs.getDouble(2);
                String unidade = rs.getString(3);
                LocalDate dataValidade = rs.getDate(4).toLocalDate();

                IngredienteModel est1 = new IngredienteModel();
                est1.setIdIngrediente(rs.getInt(5));
                list.add(new EstoqueModel(idEstoque, quantidade, unidade, dataValidade, est1));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }
}
