package br.com.conta.model;

public class TipoFase extends GenericModel {
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoFase() {}

    public TipoFase(int id, String descricao) {
        this.setId(id);
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "TipoFase {" + "\n'" +
                "id='" + this.getId() + "\n'" +
                "descricao='" + descricao + "\n'" +
                '}';
    }
}
