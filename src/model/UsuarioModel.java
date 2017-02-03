package model;

public class UsuarioModel {

    private int idUsuario;
    private String nome;
    private String cpf;
    private String rg;
    private String endereco;
    private String telefone;
    private int nivel;
    private String usuario;
    private int senha;

    public UsuarioModel() {

    }

    public UsuarioModel(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UsuarioModel(int idUsuario, String nome) {
        this.idUsuario = idUsuario;
        this.nome = nome;
    }

    public UsuarioModel(String usuario, int senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public UsuarioModel(int idUsuario, String nome, String cpf, String rg, String endereco, String telefone, int nivel, String usuario, int senha) {

        this.idUsuario = idUsuario;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.telefone = telefone;
        this.nivel = nivel;
        this.usuario = usuario;
        this.senha = senha;

    }

    public UsuarioModel(String nome, String cpf, String rg, String endereco, String telefone, int nivel, String usuario, int senha) {

        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.telefone = telefone;
        this.nivel = nivel;
        this.usuario = usuario;
        this.senha = senha;

    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefonde() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return nome;
    }

}
