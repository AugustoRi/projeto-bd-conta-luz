package br.com.conta.model;

import java.sql.Date;

public class Medicao extends GenericModel {
    private String mes;
    private String ano;
    private Date dataMedicao;
    private String consumo;
    private int medidorId;
    private int timeRotaId;

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Date getDataMedicao() {
        return dataMedicao;
    }

    public void setDataMedicao(Date dataMedicao) {
        this.dataMedicao = dataMedicao;
    }

    public String getConsumo() {
        return consumo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }

    public int getMedidorId() {
        return medidorId;
    }

    public void setMedidorId(int medidorId) {
        this.medidorId = medidorId;
    }

    public int getTimeRotaId() {
        return timeRotaId;
    }

    public void setTimeRotaId(int timeRotaId) {
        this.timeRotaId = timeRotaId;
    }

    public Medicao() {}

    public Medicao(int id, String mes, String ano, Date dataMedicao, String consumo, int medidorId, int timeRotaId) {
        this.setId(id);
        this.mes = mes;
        this.ano = ano;
        this.dataMedicao = dataMedicao;
        this.consumo = consumo;
        this.medidorId = medidorId;
        this.timeRotaId = timeRotaId;
    }

    @Override
    public String toString() {
        return "Medicao {" + "\n'" +
                "id='" + this.getId() + "\n'" +
                "mes='" + mes + "\n'" +
                "ano='" + ano + "\n'" +
                "dataMedicao='" + dataMedicao + "\n'" +
                "consumo='" + consumo + "\n'" +
                "medidorId='" + medidorId + "\n'" +
                "timeRotaId='" + timeRotaId + "\n'" +
                '}';
    }
}
