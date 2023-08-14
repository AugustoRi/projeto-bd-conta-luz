package br.com.conta.model;

public class Rota extends GenericModel {
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Rota() {}

    public Rota(int id, String descricao) {
        this.setId(id);
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Rota {" + "\n'" +
                "id='" + this.getId() + "\n'" +
                "descricao='" + descricao + "\n'" +
                '}';
    }
}
