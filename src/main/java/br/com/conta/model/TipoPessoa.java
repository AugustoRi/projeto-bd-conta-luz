package br.com.conta.model;

public class TipoPessoa extends GenericModel {
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoPessoa() {}

    public TipoPessoa(int id, String descricao) {
        this.setId(id);
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "TipoPessoa {" + "\n'" +
                "id='" + this.getId() + "\n'" +
                "descricao='" + descricao + "\n'" +
                '}';
    }
}
