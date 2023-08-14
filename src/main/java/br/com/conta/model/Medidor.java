package br.com.conta.model;

public class Medidor extends GenericModel {
    private String descricao;
    private int idPoste;
    private int idRota;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdPoste() {
        return idPoste;
    }

    public void setIdPoste(int idPoste) {
        this.idPoste = idPoste;
    }

    public int getIdRota() {
        return idRota;
    }

    public void setIdRota(int idRota) {
        this.idRota = idRota;
    }

    public Medidor() {}

    public Medidor(int id, String descricao, int idPoste, int idRota) {
        this.setId(id);
        this.descricao = descricao;
        this.idPoste = idPoste;
        this.idRota = idRota;
    }

    @Override
    public String toString() {
        return "Medidor {" +
                "id='" + this.getId() + "\n'" +
                "descricao='" + descricao + "\n'" +
                "idPoste='" + idPoste + "\n'" +
                "idRota='" + idRota + "\n'" +
                '}';
    }
}
