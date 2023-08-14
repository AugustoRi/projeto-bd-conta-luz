package br.com.conta.model;

public class Funcionario extends GenericModel {
    private String codigoFuncional;
    private int pessoaId;

    public String getCodigoFuncional() {
        return codigoFuncional;
    }

    public void setCodigoFuncional(String codigoFuncional) {
        this.codigoFuncional = codigoFuncional;
    }

    public int getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Funcionario() {}

    public Funcionario(int id, String codigoFuncional, int pessoaId) {
        this.setId(id);
        this.codigoFuncional = codigoFuncional;
        this.pessoaId = pessoaId;
    }

    @Override
    public String toString() {
        return "Funcionario {" + "\n'" +
                "id='" + this.getId() + "\n'" +
                "codigoFuncional='" + codigoFuncional + "\n'" +
                "pessoaId='" + pessoaId + "\n'" +
                '}';
    }
}
