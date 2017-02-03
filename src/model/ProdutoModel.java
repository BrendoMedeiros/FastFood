package model;

public class ProdutoModel {

    private int idProduto;
    private String nome;
    private float preco;
    private ReceitaModel produtoIdReceita;

    public ProdutoModel() {

    }

    public ProdutoModel(int idProduto) {
        this.idProduto = idProduto;
    }

    public ProdutoModel(String nome, float preco, ReceitaModel produtoIdReceita) {

        this.nome = nome;
        this.preco = preco;
        this.produtoIdReceita = produtoIdReceita;

    }

    public ProdutoModel(int idProduto, String nome, float preco, ReceitaModel produtoIdReceita) {

        this.idProduto = idProduto;
        this.nome = nome;
        this.preco = preco;
        this.produtoIdReceita = produtoIdReceita;

    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public ReceitaModel getProdutoIdReceita() {
        return produtoIdReceita;
    }

    public void setProdutoIdReceita(ReceitaModel produtoIdReceita) {
        this.produtoIdReceita = produtoIdReceita;
    }

    @Override
    public String toString() {
        return nome;
    }

}
