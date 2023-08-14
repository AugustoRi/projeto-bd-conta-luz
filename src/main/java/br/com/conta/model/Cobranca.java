package br.com.conta.model;

public class Cobranca extends GenericModel {
    private String mesReferencia;
    private String anoReferencia;
    private int tarifaId;
    private int medicaoId;

    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public String getAnoReferencia() {
        return anoReferencia;
    }

    public void setAnoReferencia(String anoReferencia) {
        this.anoReferencia = anoReferencia;
    }

    public int getTarifaId() {
        return tarifaId;
    }

    public void setTarifaId(int tarifaId) {
        this.tarifaId = tarifaId;
    }

    public int getMedicaoId() {
        return medicaoId;
    }

    public void setMedicaoId(int medicaoId) {
        this.medicaoId = medicaoId;
    }

    public Cobranca() {}

    public Cobranca(int id, String mesReferencia, String anoReferencia, int tarifaId, int medicaoId) {
        this.setId(id);
        this.mesReferencia = mesReferencia;
        this.anoReferencia = anoReferencia;
        this.tarifaId = tarifaId;
        this.medicaoId = medicaoId;
    }

    @Override
    public String toString() {
        return "Cobranca {" +
                "id='" + this.getId() + "\n'" +
                "mesReferencia='" + mesReferencia + "\n'" +
                "anoReferencia='" + anoReferencia + "\n'" +
                "tarifaId='" + tarifaId + "\n'" +
                "medicaoId='" + medicaoId + "\n'" +
                '}';
    }

}
