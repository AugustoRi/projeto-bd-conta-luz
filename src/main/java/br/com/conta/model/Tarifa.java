package br.com.conta.model;

import java.sql.Date;

public class Tarifa extends GenericModel {
    private String taxa;
    private int classeId;
    private String lei;
    private Date dataInicio;
    private Date dataFim;
    private String aliquotaIcms;

    public String getTaxa() {
        return taxa;
    }

    public void setTaxa(String taxa) {
        this.taxa = taxa;
    }

    public int getClasseId() {
        return classeId;
    }

    public void setClasseId(int classeId) {
        this.classeId = classeId;
    }

    public String getLei() {
        return lei;
    }

    public void setLei(String lei) {
        this.lei = lei;
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

    public String getAliquotaIcms() {
        return aliquotaIcms;
    }

    public void setAliquotaIcms(String aliquotaIcms) {
        this.aliquotaIcms = aliquotaIcms;
    }

    public Tarifa() {}

    public Tarifa(int id, String taxa, int classeId, String lei, Date dataInicio, Date dataFim, String aliquotaIcms) {
        this.setId(id);
        this.taxa = taxa;
        this.classeId = classeId;
        this.lei = lei;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.aliquotaIcms = aliquotaIcms;
    }

    @Override
    public String toString() {
        return "Tarifa {" + "\n'" +
                "id='" + this.getId() + "\n'" +
                "taxa='" + taxa + "\n'" +
                "classeId='" + classeId + "\n'" +
                "lei='" + lei + "\n'" +
                "dataInicio='" + dataInicio + "\n'" +
                "dataFim='" + dataFim + "\n'" +
                "aliquotaIcms='" + aliquotaIcms + "\n'" +
                '}';
    }
}
