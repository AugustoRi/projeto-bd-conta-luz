package br.com.conta.dto;

import br.com.conta.model.Medidor;

import java.sql.Date;

public class ContratoMedidorResponse extends GenericContrato {
    private Medidor medidor;

    public Medidor getMedidor() {
        return medidor;
    }

    public void setMedidor(Medidor medidor) {
        this.medidor = medidor;
    }

    public ContratoMedidorResponse() {}

    public ContratoMedidorResponse(int id, String descricao, Date dataInicio, Date dataFim, int medidorId, int classeId, int tipoFase, Medidor medidor) {
        this.setId(id);
        this.setDescricao(descricao);
        this.setDataInicio(dataInicio);
        this.setDataFim(dataFim);
        this.setMedidorId(medidorId);
        this.setClasseId(classeId);
        this.setTipoFase(tipoFase);
        this.medidor = medidor;
    }

    @Override
    public String toString() {
        return "ContratoMedidorResponse {" +
                "id='" + this.getId() + "\'" +
                "descricao='" + this.getDescricao() + "\'" +
                "dataInicio='" + this.getDataInicio() + "\'" +
                "dataFim='" + this.getDataFim() + "\'" +
                "medidorId='" + this.getMedidorId() + "\'" +
                "classeId='" + this.getClasseId() + "\'" +
                "tipoFase='" + this.getTipoFase() + "\'" +
                "medidor='" + medidor + "\'" +
                '}';
    }
}
