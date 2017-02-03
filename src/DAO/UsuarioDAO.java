package DAO;

import bd.ConnectionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.UsuarioModel;

public class UsuarioDAO {

    private Connection conn;
    private UsuarioModel user;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public UsuarioDAO() throws Exception {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro: \n" + e.getMessage());
        }
    }

    public void salvar(Object ob) throws Exception {

        this.user = (UsuarioModel) ob;
        if (user == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {

            String SQL = "INSERT INTO fastfood.usuario(nome, cpf, rg, enderco, telefone, nivel, usuario, senha) "
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

            ps = conn.prepareStatement(SQL);
            ps.setString(1, user.getNome());
            ps.setString(2, user.getCpf());
            ps.setString(3, user.getRg());
            ps.setString(4, user.getEndereco());
            ps.setString(5, user.getTelefonde());
            ps.setInt(6, user.getNivel());
            ps.setString(7, user.getUsuario());
            ps.setInt(8, user.getSenha());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados do usuário: \n" + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public void excluir(Object ob) throws Exception {

        this.user = (UsuarioModel) ob;
        if (user == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            ps = conn.prepareStatement("DELETE FROM fastfood.usuario WHERE id_usuario = ?;");
            ps.setInt(1, user.getIdUsuario());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Exclusão do usuário " + ob.toString() + " realizada com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados: " + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public void atualizar(Object ob) throws Exception {
        this.user = (UsuarioModel) ob;
        if (user == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            ps = conn.prepareStatement("UPDATE fastfood.usuario\n"
                    + "	SET id_usuario=?, nome=?, cpf=?, rg=?, enderco=?, telefone=?, nivel=?, usuario=?, senha=? \n"
                    + "	WHERE id_usuario = ?;");
            ps.setInt(1, user.getIdUsuario());
            ps.setString(2, user.getNome());
            ps.setString(3, user.getCpf());
            ps.setString(4, user.getRg());
            ps.setString(5, user.getEndereco());
            ps.setString(6, user.getTelefonde());
            ps.setInt(7, user.getNivel());
            ps.setString(8, user.getUsuario());
            ps.setInt(9, user.getSenha());
            ps.setInt(10, user.getIdUsuario());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Erro ao atualizar dados: " + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public List listarTodos() throws Exception {
        try {
            ps = conn.prepareStatement("SELECT id_usuario, nome, cpf, rg, enderco, telefone, nivel, usuario, senha FROM fastfood.usuario;");
            rs = ps.executeQuery();
            List<UsuarioModel> list = new ArrayList<UsuarioModel>();
            while (rs.next()) {
                int idUsuario = rs.getInt(1);
                String nome = rs.getString(2);
                String cpf = rs.getString(3);
                String rg = rs.getString(4);
                String endereco = rs.getString(5);
                String telefone = rs.getString(6);
                int nivel = rs.getInt(7);
                String usuario = rs.getString(8);
                int senha = rs.getInt(9);
                list.add(new UsuarioModel(idUsuario, nome, cpf, rg, endereco, telefone, nivel, usuario, senha));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    public ArrayList<UsuarioModel> buscarUsuario(Object ob) throws Exception {
        this.user = (UsuarioModel) ob;
        try {
            ps = conn.prepareStatement("SELECT id_usuario, nome, cpf, rg, enderco, telefone, nivel, usuario, senha FROM fastfood.usuario WHERE id_usuario=?;");
            ps.setInt(1, user.getIdUsuario());
            rs = ps.executeQuery();
            ArrayList<UsuarioModel> list = new ArrayList<UsuarioModel>();
            while (rs.next()) {
                int idUsuario = rs.getInt(1);
                String nome = rs.getString(2);
                String cpf = rs.getString(3);
                String rg = rs.getString(4);
                String endereco = rs.getString(5);
                String telefone = rs.getString(6);
                int nivel = rs.getInt(7);
                String usuario = rs.getString(8);
                int senha = rs.getInt(9);
                list.add(new UsuarioModel(idUsuario, nome, cpf, rg, endereco, telefone, nivel, usuario, senha));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    public UsuarioModel buscarUsuarioLogin(Object ob) throws Exception {
        this.user = (UsuarioModel) ob;
        UsuarioModel userModel = null; 
        try {
            ps = conn.prepareStatement("SELECT id_usuario, nome, cpf, rg, enderco, telefone, nivel, usuario, senha "
                    + " FROM fastfood.usuario "
                    + " WHERE usuario = ? AND senha = ? ;");
            ps.setString(1, user.getUsuario());
            ps.setInt(2, user.getSenha());
            rs = ps.executeQuery();
            while (rs.next()) {
                int idUsuario = rs.getInt(1);
                String nome = rs.getString(2);
                String cpf = rs.getString(3);
                String rg = rs.getString(4);
                String endereco = rs.getString(5);
                String telefone = rs.getString(6);
                int nivel = rs.getInt(7);
                String usuario = rs.getString(8);
                int senha = rs.getInt(9);
                userModel = new UsuarioModel(idUsuario, nome, cpf, rg, endereco, telefone, nivel, usuario, senha);
            }
            return userModel;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    public ArrayList<UsuarioModel> buscarClientes() throws Exception {

        try {
            ps = conn.prepareStatement(" SELECT id_usuario, nome, cpf, rg, enderco, telefone, nivel, usuario, senha "
                    + " FROM fastfood.usuario "
                    + "WHERE nivel = ? ");
            ps.setInt(1, 5);
            rs = ps.executeQuery();
            ArrayList<UsuarioModel> list = new ArrayList<UsuarioModel>();
            while (rs.next()) {
                int idUsuario = rs.getInt(1);
                String nome = rs.getString(2);
                String cpf = rs.getString(3);
                String rg = rs.getString(4);
                String endereco = rs.getString(5);
                String telefone = rs.getString(6);
                int nivel = rs.getInt(7);
                String usuario = rs.getString(8);
                int senha = rs.getInt(9);
                list.add(new UsuarioModel(idUsuario, nome, cpf, rg, endereco, telefone, nivel, usuario, senha));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

//    public List procura(Object ob) throws Exception {
//        this.user = (UsuarioModel) ob;
//        if (user == null) {
//            throw new Exception("O valor passado não pode ser nulo");
//        }
//        try {
//            String SQL = " SELECT id_usuario, nome, cpf, rg, enderco, telefone, nivel, usuario, senha FROM fastfood.usuario; ";
//            String where = "";
//            boolean checa = false;
//            if (user.getIdUsuario() != 0 || user.getNome() != null || user.getCpf() != null) {
//                where = "where ";
//                if (user.getIdUsuario() != 0) {
//                    where += "id_usuario=? ";
//                    checa = true;
//                }
//                if (user.getNome() != null) {
//                    if (checa) {
//                        where += "and";
//                    }
//                    where += " nome=? ";
//                    checa = true;
//                }
//                if (user.getCpf() != null) {
//                    if (checa) {
//                        where += "and";
//                    }
//                    where += " cpf=? ";
//                }
//            }
//            ps = conn.prepareStatement(SQL + where);
//            int contaCampos = 1;
//            if (user.getIdUsuario() != 0 || user.getNome() != null || user.getCpf() != null) {
//                if (user.getIdUsuario() != 0) {
//                    ps.setInt(contaCampos, user.getIdUsuario());
//                    contaCampos++;
//                }
//                if (user.getNome() != null) {
//                    ps.setString(contaCampos, user.getNome());
//                    contaCampos++;
//                }
//                if (user.getCpf() != null) {
//                    ps.setString(contaCampos, user.getCpf());
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
