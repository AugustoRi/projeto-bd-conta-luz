package br.com.conta.model;

public class Classe extends GenericModel {
    private String descricao;

    private int tipoFaseId;

    public int getTipoFaseId() {
        return tipoFaseId;
    }

    public void setTipoFaseId(int tipoFaseId) {
        this.tipoFaseId = tipoFaseId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Classe() {}

    public Classe(int id, String descricao, int tipoFaseId) {
        this.setId(id);
        this.descricao = descricao;
        this.tipoFaseId = tipoFaseId;
    }

    @Override
    public String toString() {
        return "Classe {" + "\n'" +
                "id='" + this.getId() + "\n'" +
                "descricao='" + descricao + "\n'" +
                "tipoFaseId='" + tipoFaseId + "\n'" +
                '}';
    }
}