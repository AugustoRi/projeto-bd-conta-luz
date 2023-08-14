package br.com.conta.model;

import java.sql.Date;

public class Fatura {
    private int pessoaId;
    private String pessoaNome;
    private String pessoaCpf;
    private String pessoaCnpj;
    private String numCliente;
    private String numDocumento;
    private Date contratoDataInicio;
    private Date contratoDataFim;
    private String contratoDescricao;
    private String rotaDescricao;
    private String medidorDescricao;
    private int tipoPessoaId;

    public int getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getPessoaNome() {
        return pessoaNome;
    }

    public void setPessoaNome(String pessoaNome) {
        this.pessoaNome = pessoaNome;
    }

    public String getPessoaCpf() {
        return pessoaCpf;
    }

    public void setPessoaCpf(String pessoaCpf) {
        this.pessoaCpf = pessoaCpf;
    }

    public String getPessoaCnpj() {
        return pessoaCnpj;
    }

    public void setPessoaCnpj(String pessoaCnpj) {
        this.pessoaCnpj = pessoaCnpj;
    }

    public String getNumCliente() {
        return numCliente;
    }

    public void setNumCliente(String numCliente) {
        this.numCliente = numCliente;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public Date getContratoDataInicio() {
        return contratoDataInicio;
    }

    public void setContratoDataInicio(Date contratoDataInicio) {
        this.contratoDataInicio = contratoDataInicio;
    }

    public Date getContratoDataFim() {
        return contratoDataFim;
    }

    public void setContratoDataFim(Date contratoDataFim) {
        this.contratoDataFim = contratoDataFim;
    }

    public String getContratoDescricao() {
        return contratoDescricao;
    }

    public void setContratoDescricao(String contratoDescricao) {
        this.contratoDescricao = contratoDescricao;
    }

    public String getRotaDescricao() {
        return rotaDescricao;
    }

    public void setRotaDescricao(String rotaDescricao) {
        this.rotaDescricao = rotaDescricao;
    }

    public String getMedidorDescricao() {
        return medidorDescricao;
    }

    public void setMedidorDescricao(String medidorDescricao) {
        this.medidorDescricao = medidorDescricao;
    }

    public int getTipoPessoaId() {
        return tipoPessoaId;
    }

    public void setTipoPessoaId(int tipoPessoaId) {
        this.tipoPessoaId = tipoPessoaId;
    }

    public Fatura () {}

    public Fatura(int pessoaId, String pessoaNome, String pessoaCpf, String pessoaCnpj, String numCliente, String numDocumento, Date contratoDataInicio, Date contratoDataFim, String contratoDescricao, String rotaDescricao, String medidorDescricao, int tipoPessoaId) {
        this.pessoaId = pessoaId;
        this.pessoaNome = pessoaNome;
        this.pessoaCpf = pessoaCpf;
        this.pessoaCnpj = pessoaCnpj;
        this.numCliente = numCliente;
        this.numDocumento = numDocumento;
        this.contratoDataInicio = contratoDataInicio;
        this.contratoDataFim = contratoDataFim;
        this.contratoDescricao = contratoDescricao;
        this.rotaDescricao = rotaDescricao;
        this.medidorDescricao = medidorDescricao;
        this.tipoPessoaId = tipoPessoaId;
    }

    @Override
    public String toString() {
        return "Fatura {" + "\n'" +
                "id='" + pessoaId + "\n'" +
                "nome='" + pessoaNome + "\n'" +
                "cpf='" + pessoaCpf + "\n'" +
                "cnpj='" + pessoaCnpj + "\n'" +
                "numCliente='" + numCliente + "\n'" +
                "numDocumento='" + numDocumento + "\n'" +
                "contratoDataInicio='" + contratoDataInicio + "\n'" +
                "contratoDataFim='" + contratoDataFim + "\n'" +
                "contratoDescricao='" + contratoDescricao + "\n'" +
                "rotaDescricao='" + rotaDescricao + "\n'" +
                "medidorDescricao='" + medidorDescricao + "\n'" +
                "tipoPessoaId='" + tipoPessoaId + "\n'" +
                '}';
    }
}
