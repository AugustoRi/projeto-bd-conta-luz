package br.com.conta.dto;

import java.sql.Date;

public class GenericContrato extends GenericDTO {
    private String descricao;
    private Date dataInicio;
    private Date dataFim;
    private int medidorId;
    private int classeId;
    private int tipoFase;

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
}
