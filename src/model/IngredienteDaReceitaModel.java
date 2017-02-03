package model;

public class IngredienteDaReceitaModel {

    private int idIngredienteReceita;
    private ReceitaModel receitaIngredienteIdReceita;
    private IngredienteModel receitaIngredienteIdIngrediente;
    private Double quantidade;

    public IngredienteDaReceitaModel() {
    }

    public IngredienteDaReceitaModel(int idIngredienteReceita) {
        this.idIngredienteReceita = idIngredienteReceita;
    }

    public IngredienteDaReceitaModel(int idIngredenteReceita, ReceitaModel receitaIngredienteIdReceita, IngredienteModel receitaIngredienteIdIngrediente, Double quantidade) {
        this.idIngredienteReceita = idIngredenteReceita;
        this.receitaIngredienteIdReceita = receitaIngredienteIdReceita;
        this.receitaIngredienteIdIngrediente = receitaIngredienteIdIngrediente;
        this.quantidade = quantidade;
    }

    public IngredienteDaReceitaModel(ReceitaModel receitaIngredienteIdReceita, IngredienteModel receitaIngredienteIdIngrediente, Double quantidade) {
        this.receitaIngredienteIdReceita = receitaIngredienteIdReceita;
        this.receitaIngredienteIdIngrediente = receitaIngredienteIdIngrediente;
        this.quantidade = quantidade;
    }

    public int getIdIngredienteReceita() {
        return idIngredienteReceita;
    }

    public void setIdIngredienteReceita(int idIngredienteReceita) {
        this.idIngredienteReceita = idIngredienteReceita;
    }

    public ReceitaModel getReceitaIngredienteIdReceita() {
        return receitaIngredienteIdReceita;
    }

    public void setReceitaIngredienteIdReceita(ReceitaModel receitaIngredienteIdReceita) {
        this.receitaIngredienteIdReceita = receitaIngredienteIdReceita;
    }

    public IngredienteModel getReceitaIngredienteIdIngrediente() {
        return receitaIngredienteIdIngrediente;
    }

    public void setReceitaIngredienteIdIngrediente(IngredienteModel receitaIngredienteIdIngrediente) {
        this.receitaIngredienteIdIngrediente = receitaIngredienteIdIngrediente;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "IngredienteDaReceitaModel{" + "receitaIngredienteIdReceita=" + receitaIngredienteIdReceita + ", receitaIngredienteIdIngrediente=" + receitaIngredienteIdIngrediente + ", quantidade=" + quantidade + '}';
    }

}
