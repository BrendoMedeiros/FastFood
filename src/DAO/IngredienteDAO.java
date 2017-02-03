package DAO;

import bd.ConnectionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.IngredienteModel;
import model.IngredienteDaReceitaModel;
import model.ReceitaModel;

public class IngredienteDAO {

    private Connection conn;
    private IngredienteModel ingre;
    private IngredienteDaReceitaModel ingRec;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public IngredienteDAO() throws Exception {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro: \n" + e.getMessage());
        }
    }

    public void salvar(Object ob) throws Exception {

        this.ingre = (IngredienteModel) ob;
        if (ingre == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {

            String SQL = "INSERT INTO fastfood.ingrediente(descricao) "
                    + " VALUES (?);";

            ps = conn.prepareStatement(SQL);
            ps.setString(1, ingre.getDescricao());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados do ingrediente: \n" + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public void salvarIngredienteDaReceita(Object ob) throws Exception {

        this.ingRec = (IngredienteDaReceitaModel) ob;
        if (ingRec == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {

            String SQL = "INSERT INTO fastfood.receita_ingrediente("
                    + " receita_ingrediente_id_receita, receita_ingrediente_id_ingrediente, "
                    + " receita_ingrediente_quantidade) "
                    + "    VALUES (?, ?, ?);";

            ps = conn.prepareStatement(SQL);
            ps.setInt(1, ingRec.getReceitaIngredienteIdReceita().getIdReceita());
            ps.setInt(2, ingRec.getReceitaIngredienteIdIngrediente().getIdIngrediente());
            ps.setDouble(3, ingRec.getQuantidade());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados do ingrediente: \n" + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public void excluirIngredienteDaReceita(Object ob) throws Exception {

        this.ingRec = (IngredienteDaReceitaModel) ob;
        if (ingRec == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {

            String SQL = "DELETE FROM fastfood.receita_ingrediente WHERE receita_ingrediente.id_receita_ingrediente = ?";

            ps = conn.prepareStatement(SQL);
            ps.setInt(1, ingRec.getIdIngredienteReceita());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao remover o ingrediente: \n" + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public void excluir(Object ob) throws Exception {

        this.ingre = (IngredienteModel) ob;
        if (ingre == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            ps = conn.prepareStatement("DELETE FROM fastfood.ingrediente WHERE id_ingrediente = ?;");
            ps.setInt(1, ingre.getIdIngrediente());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Exclusão do ingrediente " + ob.toString() + " realizada com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados: " + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public void atualizar(Object ob) throws Exception {
        this.ingre = (IngredienteModel) ob;
        if (ingre == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            ps = conn.prepareStatement("UPDATE fastfood.ingrediente\n"
                    + "	SET id_ingrediente=?, descricao=? \n"
                    + "	WHERE id_ingrediente = ?;");
            ps.setInt(1, ingre.getIdIngrediente());
            ps.setString(2, ingre.getDescricao());
            ps.setInt(3, ingre.getIdIngrediente());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Erro ao atualizar dados: " + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public List listarTodos() throws Exception {
        try {
            ps = conn.prepareStatement("SELECT id_ingrediente, descricao FROM fastfood.ingrediente;");
            rs = ps.executeQuery();
            List<IngredienteModel> list = new ArrayList<IngredienteModel>();
            while (rs.next()) {
                int idIngrediente = rs.getInt(1);
                String descricao = rs.getString(2);
                list.add(new IngredienteModel(idIngrediente, descricao));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    public ArrayList<IngredienteModel> buscarIngrediente(Object ob) throws Exception {
        this.ingre = (IngredienteModel) ob;
        try {
            ps = conn.prepareStatement("SELECT id_ingrediente, descricao FROM fastfood.ingrediente WHERE id_ingrediente=?;");
            ps.setInt(1, ingre.getIdIngrediente());
            rs = ps.executeQuery();
            ArrayList<IngredienteModel> list = new ArrayList<IngredienteModel>();
            while (rs.next()) {
                int idIngrediente = rs.getInt(1);
                String descricao = rs.getString(2);
                list.add(new IngredienteModel(idIngrediente, descricao));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    public ArrayList<IngredienteDaReceitaModel> buscaIngredientesDaReceita(Object ob) throws Exception {
        ReceitaModel rec = (ReceitaModel) ob;
        try {
            ps = conn.prepareStatement(" SELECT id_ingrediente, descricao, receita_ingrediente_quantidade, receita_ingrediente.id_receita_ingrediente"
                    + "  FROM fastfood.receita, fastfood.receita_ingrediente, fastfood.ingrediente"
                    + "  WHERE fastfood.receita_ingrediente.receita_ingrediente_id_receita = ?"
                    + "  AND fastfood.receita_ingrediente.receita_ingrediente_id_ingrediente = fastfood.ingrediente.id_ingrediente; ");

            ps.setInt(1, rec.getIdReceita());
            rs = ps.executeQuery();

            ArrayList<IngredienteDaReceitaModel> list = new ArrayList<IngredienteDaReceitaModel>();
            while (rs.next()) {
                int idIngrediente = rs.getInt(1);
                String descricao = rs.getString(2);
                Double qtde = rs.getDouble(3);
                int idReceitaIngrediente = rs.getInt(4);
                IngredienteModel ingModel = new IngredienteModel();

                ingModel.setIdIngrediente(idIngrediente);
                ingModel.setDescricao(descricao);

                list.add(new IngredienteDaReceitaModel(idReceitaIngrediente, new ReceitaModel(rec.getIdReceita()), ingModel, qtde));
            }

            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

//    public List procura(Object ob) throws Exception {
//        this.ingre = (IngredienteModel) ob;
//        if (ingre == null) {
//            throw new Exception("O valor passado não pode ser nulo");
//        }
//        try {
//            String SQL = " SELECT id_ingrediente, descricao FROM fastfood.ingrediente; ";
//            String where = "";
//            boolean checa = false;
//            if (ingre.getIdIngrediente() != 0 || ingre.getDescricao() != null) {
//                where = "where ";
//                if (ingre.getIdIngrediente() != 0) {
//                    where += "id_ingrediente=? ";
//                    checa = true;
//                }
//                if (ingre.getDescricao() != null) {
//                    if (checa) {
//                        where += "and";
//                    }
//                    where += " descricao=? ";
//                    checa = true;
//                }
//            }
//            ps = conn.prepareStatement(SQL + where);
//            int contaCampos = 1;
//            if (ingre.getIdIngrediente() != 0 || ingre.getDescricao() != null) {
//                if (ingre.getIdIngrediente() != 0) {
//                    ps.setInt(contaCampos, ingre.getIdIngrediente());
//                    contaCampos++;
//                }
//                if (ingre.getDescricao() != null) {
//                    ps.setString(contaCampos, ingre.getDescricao());
//                    contaCampos++;
//                }
//            }
//            rs = ps.executeQuery();
//            List<IngredienteModel> list = new ArrayList<IngredienteModel>();
//            while (rs.next()) {
//                int idIngrediente = rs.getInt(1);
//                String descricao = rs.getString(2);
//                list.add(new IngredienteModel(idIngrediente, descricao));
//            }
//            return list;
//        } catch (SQLException sqle) {
//            throw new Exception(sqle);
//        } finally {
//            ConnectionDAO.closeConnection(conn, ps, rs);
//        }
//    }
}
