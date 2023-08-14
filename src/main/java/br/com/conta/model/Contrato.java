package br.com.conta.model;

import java.sql.Date;

public class Contrato extends GenericModel {
    private String descricao;
    private Date dataInicio;
    private Date dataFim;
    private int medidorId;
    private int classeId;
    private int tipoFase;
    private int clienteId;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public int getMedidorId() {
        return medidorId;
    }

    public void setMedidorId(int medidorId) {
        this.medidorId = medidorId;
    }

    public int getClasseId() {
        return classeId;
    }

    public void setClasseId(int classeId) {
        this.classeId = classeId;
    }

    public int getTipoFase() {
        return tipoFase;
    }

    public void setTipoFase(int tipoFase) {
        this.tipoFase = tipoFase;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public Contrato() {}

    public Contrato(int id, String descricao, Date dataInicio, Date dataFim, int medidorId, int classeId, int tipoFase, int clienteId) {
        this.setId(id);
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.medidorId = medidorId;
        this.classeId = classeId;
        this.tipoFase = tipoFase;
        this.clienteId = clienteId;
    }

    @Override
    public String toString() {
        return "Contrato {" +
                "id='" + this.getId() + "\n'" +
                "descricao='" + descricao + "\n'" +
                "dataInicio='" + dataInicio + "\n'" +
                "dataFim='" + dataFim + "\n'" +
                "medidorId='" + medidorId + "\n'" +
                "classeId='" + classeId + "\n'" +
                "tipoFase='" + tipoFase + "\n'" +
                "clienteId='" + clienteId + "\n'" +
                '}';
    }
}
