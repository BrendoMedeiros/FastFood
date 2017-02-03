package model;

public class IngredienteModel {

    private int idIngrediente;
    private String descricao;

    public IngredienteModel() {

    }

    public IngredienteModel(String descricao) {

        this.descricao = descricao;
    }

    public IngredienteModel(int idIngrediente, String descicao) {

        this.idIngrediente = idIngrediente;
        this.descricao = descicao;
    }

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {

        return descricao;

    }

}
