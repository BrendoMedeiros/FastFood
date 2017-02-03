package model;

public class PedidoDoProdutoModel {

    private PedidoModel pedidoProdutoIdPedido;
    private ProdutoModel pedidoProdutoIdProduto;
    private Float quantidade;

    public PedidoDoProdutoModel() {

    }

    public PedidoDoProdutoModel(PedidoModel pedidoProdutoIdPedido, ProdutoModel pedidoProdutoIdProduto, Float quantidade) {
        this.pedidoProdutoIdPedido = pedidoProdutoIdPedido;
        this.pedidoProdutoIdProduto = pedidoProdutoIdProduto;
        this.quantidade = quantidade;

    }

    public PedidoModel getPedidoProdutoIdPedido() {
        return pedidoProdutoIdPedido;
    }

    public void setPedidoProdutoIdPedido(PedidoModel pedidoProdutoIdPedido) {
        this.pedidoProdutoIdPedido = pedidoProdutoIdPedido;
    }

    public ProdutoModel getPedidoProdutoIdProduto() {
        return pedidoProdutoIdProduto;
    }

    public void setPedidoProdutoIdProduto(ProdutoModel pedidoProdutoIdProduto) {
        this.pedidoProdutoIdProduto = pedidoProdutoIdProduto;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "PedidoDoProdutoModel{" + "pedidoProdutoIdPedido=" + pedidoProdutoIdPedido + ", pedidoProdutoIdProduto=" + pedidoProdutoIdProduto + ", quantidade=" + quantidade + '}';
    }

}
