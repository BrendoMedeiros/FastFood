package model;

import java.time.LocalDate;

public class PedidoModel {

    private int idPedido;
    private LocalDate dataPedido;
    private String statusPedido;
    private UsuarioModel cliente;
    private CaixaModel pedidoIdCaixa;

    public PedidoModel() {

    }

    public PedidoModel(int idPedido) {
        this.idPedido = idPedido;
    }

    public PedidoModel(LocalDate dataPedido, String statusPedido, UsuarioModel cliente, CaixaModel pedidoIdCaixa) {

        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
        this.cliente = cliente;
        this.pedidoIdCaixa = pedidoIdCaixa;

    }

    public PedidoModel(int idPedido, LocalDate dataPedido, String statusPedido, UsuarioModel cliente, CaixaModel pedidoIdCaixa) {

        this.idPedido = idPedido;
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
        this.cliente = cliente;
        this.pedidoIdCaixa = pedidoIdCaixa;

    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public UsuarioModel getCliente() {
        return cliente;
    }

    public void setCliente(UsuarioModel cliente) {
        this.cliente = cliente;
    }

    public CaixaModel getPedidoIdCaixa() {
        return pedidoIdCaixa;
    }

    public void setPedidoIdCaixa(CaixaModel pedidoIdCaixa) {
        this.pedidoIdCaixa = pedidoIdCaixa;
    }

    @Override
    public String toString() {
        return String.valueOf(idPedido);
    }

}
