package model;

import java.time.LocalDate;

public class PagamentoModel {

    private Integer idPagamento;
    private LocalDate data;
    private String tipoPagamento;
    PedidoModel pedido;

    public PagamentoModel() {
    }

    public PagamentoModel(Integer idPagamento, PedidoModel pedido) {
        this.idPagamento = idPagamento;
        this.pedido = pedido;
    }

    public PagamentoModel(LocalDate data, String tipoPagamento, PedidoModel pedido) {
        this.data = data;
        this.tipoPagamento = tipoPagamento;
        this.pedido = pedido;
    }

    public PagamentoModel(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }

    public PagamentoModel(Integer idPagamento, LocalDate data, String tipoPagamento, PedidoModel pedido) {
        this.idPagamento = idPagamento;
        this.data = data;
        this.tipoPagamento = tipoPagamento;
        this.pedido = pedido;
    }

    public Integer getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public PedidoModel getPedido() {
        return pedido;
    }

    public void setPedido(PedidoModel pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return idPagamento + " - " + tipoPagamento;
    }

}
