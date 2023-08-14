package br.com.conta.dto;

import br.com.conta.model.Cliente;

import java.sql.Date;

public class ContratoClienteResponse extends GenericContrato {
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ContratoClienteResponse() {}

    public ContratoClienteResponse(int id, String descricao, Date dataInicio, Date dataFim, int medidorId, int classeId, int tipoFase, Cliente cliente) {
        this.setId(id);
        this.setDescricao(descricao);
        this.setDataInicio(dataInicio);
        this.setDataFim(dataFim);
        this.setMedidorId(medidorId);
        this.setClasseId(classeId);
        this.setTipoFase(tipoFase);
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "ContratoClienteResponse {" +
                "id='" + this.getId() + "\'" +
                "descricao='" + this.getDescricao() + "\'" +
                "dataInicio='" + this.getDataInicio() + "\'" +
                "dataFim='" + this.getDataFim() + "\'" +
                "medidorId='" + this.getMedidorId() + "\'" +
                "classeId='" + this.getClasseId() + "\'" +
                "tipoFase='" + this.getTipoFase() + "\'" +
                "cliente='" + cliente + "\'" +
                '}';
    }
}