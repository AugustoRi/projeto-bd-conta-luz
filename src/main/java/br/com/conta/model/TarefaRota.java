package br.com.conta.model;

import java.sql.Date;

public class TarefaRota extends GenericModel {
    private String observacao;
    private Date dataInicio;
    private Date dataFim;
    private int rotaId;

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public int getRotaId() {
        return rotaId;
    }

    public void setRotaId(int rotaId) {
        this.rotaId = rotaId;
    }

    public TarefaRota() {}

    public TarefaRota(int id, String observacao, Date dataInicio, Date dataFim, int rotaId) {
        this.setId(id);
        this.observacao = observacao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.rotaId = rotaId;
    }

    @Override
    public String toString() {
        return "TarefaRota {" +
                "id='" + this.getId() + "\n'" +
                "observacao='" + observacao + "\n'" +
                "dataInicio='" + dataInicio + "\n'" +
                "dataFim='" + dataFim + "\n'" +
                "rotaId='" + rotaId + "\n'" +
                '}';
    }
}
