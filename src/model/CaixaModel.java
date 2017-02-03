package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CaixaModel {

    private int idCaixa;
    private LocalDate data;
    private float valor;
    private LocalTime horaAbertura;
    private LocalTime horaFechamento;
    private UsuarioModel caixaIdUsuario;

    public CaixaModel() {

    }

    public CaixaModel(int idcaixa, LocalDate data, float valor, LocalTime horaAbertura, LocalTime horaFechamento, UsuarioModel caixaIDUsuario) {

        this.idCaixa = idcaixa;
        this.data = data;
        this.valor = valor;
        this.horaAbertura = horaAbertura;
        this.horaFechamento = horaFechamento;
        this.caixaIdUsuario = caixaIDUsuario;

    }

    public CaixaModel(LocalDate data, float valor, LocalTime horaAbertura, LocalTime horaFechamento, UsuarioModel caixaIDUsuario) {

        this.data = data;
        this.valor = valor;
        this.horaAbertura = horaAbertura;
        this.horaFechamento = horaFechamento;
        this.caixaIdUsuario = caixaIDUsuario;

    }

    public int getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(int idCaixa) {
        this.idCaixa = idCaixa;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public LocalTime getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(LocalTime horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public LocalTime getHoraFechamento() {
        return horaFechamento;
    }

    public void setHoraFechamento(LocalTime horaFechamento) {
        this.horaFechamento = horaFechamento;
    }

    public UsuarioModel getCaixaIdUsuario() {
        return caixaIdUsuario;
    }

    public void setCaixaIdUsuario(UsuarioModel caixaIdUsuario) {
        this.caixaIdUsuario = caixaIdUsuario;
    }

    @Override
    public String toString() {
        return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

}
