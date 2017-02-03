package model;

import java.io.Serializable;

public class ReceitaModel implements Serializable {

    private int idReceita;
    private String nome;
    private String modoPreparo;

    public ReceitaModel() {

    }

    public ReceitaModel(int idReceita) {
        this.idReceita = idReceita;
    }

    public ReceitaModel(String nome, String modoPreparo) {

        this.nome = nome;
        this.modoPreparo = modoPreparo;
    }

    public ReceitaModel(int idReceita, String nome, String modoPreparo) {

        this.idReceita = idReceita;
        this.nome = nome;
        this.modoPreparo = modoPreparo;
    }

    public int getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    @Override
    public String toString() {
        return nome;
    }
}
