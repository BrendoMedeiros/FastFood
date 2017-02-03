package model;

import java.time.LocalDate;

public class EstoqueModel {

    private int idEstoque;
    private Double quantidade;
    private String unidade;
    private LocalDate dataValidade;
    private IngredienteModel estoqueIdIngrediente;

    public EstoqueModel() {

    }

    public EstoqueModel(Double quantidade, String unidade, LocalDate dataValidade, IngredienteModel estoqueIdIngrediente) {

        this.quantidade = quantidade;
        this.unidade = unidade;
        this.dataValidade = dataValidade;
        this.estoqueIdIngrediente = estoqueIdIngrediente;

    }

    public EstoqueModel(int idEstoque, Double quantidade, String unidade, LocalDate dataValidade, IngredienteModel estoqueIdIngrediente) {

        this.idEstoque = idEstoque;
        this.quantidade = quantidade;
        this.unidade = unidade;
        this.dataValidade = dataValidade;
        this.estoqueIdIngrediente = estoqueIdIngrediente;

    }

    public int getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public IngredienteModel getEstoqueIdIngrediente() {
        return estoqueIdIngrediente;
    }

    public void setEstoqueIdIngrediente(IngredienteModel estoqueIdIngrediente) {
        this.estoqueIdIngrediente = estoqueIdIngrediente;
    }

    @Override
    public String toString() {
        return String.valueOf(idEstoque);
    }

}
