package br.com.conta.model;

public class Cliente extends GenericModel {
    private String numDocumento;

    private String numCliente;

    private int pessoaId;

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getNumCliente() {
        return numCliente;
    }

    public void setNumCliente(String numCliente) {
        this.numCliente = numCliente;
    }

    public int getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Cliente() {}

    public Cliente(int id, String numDocumento, String numCliente, int pessoaId) {
        this.setId(id);
        this.numDocumento = numDocumento;
        this.numCliente = numCliente;
        this.pessoaId = pessoaId;
    }

    @Override
    public String toString() {
        return "Cliente {" + "\n'" +
                "id='" + this.getId() + "\n'" +
                "numDocumento='" + numDocumento + "\n'" +
                "numCliente='" + numCliente + "\n'" +
                "pessoaId='" + pessoaId + "\n'" +
                '}';
    }

}
