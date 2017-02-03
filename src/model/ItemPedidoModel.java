package model;

public class ItemPedidoModel {

    private int idItemProduto;
    private PedidoModel itemProdutoIdPedido;
    private ProdutoModel itemProdutoIdProduto;
    private int itemProdutoQuantidade;

    public ItemPedidoModel(PedidoModel itemProdutoIdPedido, ProdutoModel itemProdutoIdProduto, int itemProdutoQuantidade) {
        this.itemProdutoIdPedido = itemProdutoIdPedido;
        this.itemProdutoIdProduto = itemProdutoIdProduto;
        this.itemProdutoQuantidade = itemProdutoQuantidade;
    }

    public ItemPedidoModel(int idItemProduto, PedidoModel itemProdutoIdPedido, ProdutoModel itemProdutoIdProduto, int itemProdutoQuantidade) {

        this.idItemProduto = idItemProduto;
        this.itemProdutoIdPedido = itemProdutoIdPedido;
        this.itemProdutoIdProduto = itemProdutoIdProduto;
        this.itemProdutoQuantidade = itemProdutoQuantidade;

    }

    public int getIdItemProduto() {
        return idItemProduto;
    }

    public void setIdItemProduto(int idItemProduto) {
        this.idItemProduto = idItemProduto;
    }

    public PedidoModel getItemProdutoIdPedido() {
        return itemProdutoIdPedido;
    }

    public void setItemProdutoIdPedido(PedidoModel itemProdutoIdPedido) {
        this.itemProdutoIdPedido = itemProdutoIdPedido;
    }

    public ProdutoModel getItemProdutoIdProduto() {
        return itemProdutoIdProduto;
    }

    public void setItemProdutoIdProduto(ProdutoModel itemProdutoIdProduto) {
        this.itemProdutoIdProduto = itemProdutoIdProduto;
    }

    public int getItemProdutoQuantidade() {
        return itemProdutoQuantidade;
    }

    public void setItemProdutoQuantidade(int itemProdutoQuantidade) {
        this.itemProdutoQuantidade = itemProdutoQuantidade;
    }

    public Float getTotal() {

        return itemProdutoIdProduto.getPreco() * itemProdutoQuantidade;

    }
}
