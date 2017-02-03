package DAO;

import bd.ConnectionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ReceitaModel;

public class ReceitaDAO {

    private Connection conn;
    private ReceitaModel rec;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ReceitaDAO() throws Exception {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro: \n" + e.getMessage());
        }
    }

    public Integer salvar(Object ob) throws Exception {

        Integer idReceita = 0;
        this.rec = (ReceitaModel) ob;

        if (rec == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {

            String SQL = "INSERT INTO fastfood.receita(nome, modo_de_preparo) "
                    + "VALUES (?, ?) RETURNING id_receita;";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, rec.getNome());
            ps.setString(2, rec.getModoPreparo());
            rs = ps.executeQuery();
            while(rs.next()){
                idReceita = rs.getInt(1);
            }

        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados da Receita: \n" + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
        return idReceita;
    }

    public void excluir(Object ob) throws Exception {
        this.rec = (ReceitaModel) ob;

        if (rec == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            ps = conn.prepareStatement("DELETE FROM fastfood.receita WHERE id_receita = ?;");
            ps.setInt(1, rec.getIdReceita());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Exclusão da receita realizada com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados: " + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public void atualizar(Object ob) throws Exception {

        this.rec = (ReceitaModel) ob;
        if (rec == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            ps = conn.prepareStatement("UPDATE fastfood.receita\n"
                    + "	SET id_receita=?, nome=?, modo_de_preparo=?\n"
                    + "	WHERE id_receita = ?;");
            ps.setInt(1, rec.getIdReceita());
            ps.setString(2, rec.getNome());
            ps.setString(3, rec.getModoPreparo());
            ps.setInt(4, rec.getIdReceita());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Erro ao atualizar dados: " + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public List listarTodos() throws Exception {
        try {
            ps = conn.prepareStatement("SELECT id_receita, nome, modo_de_Preparo FROM fastfood.receita;");
            rs = ps.executeQuery();
            List<ReceitaModel> list = new ArrayList<ReceitaModel>();
            while (rs.next()) {
                int idreceita = rs.getInt(1);
                String nome = rs.getString(2);
                String modoPreparo = rs.getString(3);
                list.add(new ReceitaModel(idreceita, nome, modoPreparo));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    public ArrayList<ReceitaModel> buscaReceita(Object ob) throws Exception {
        this.rec = (ReceitaModel) ob;

        try {
            ps = conn.prepareStatement("SELECT id_receita, nome, modo_de_Preparo FROM fastfood.receita WHERE id_receita=?;");
            ps.setInt(1, rec.getIdReceita());
            rs = ps.executeQuery();
            ArrayList<ReceitaModel> list = new ArrayList<ReceitaModel>();
            while (rs.next()) {
                int idReceita = rs.getInt(1);
                String nome = rs.getString(2);
                String modoPreparo = rs.getString(3);
                list.add(new ReceitaModel(idReceita, nome, modoPreparo));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }
}