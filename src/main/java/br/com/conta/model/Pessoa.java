package br.com.conta.model;

public class Pessoa extends GenericModel {
    private String nome;
    private String cpf;
    private String cnpj;
    private int tipoPessoaId;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getTipoPessoaId() {
        return tipoPessoaId;
    }

    public void setTipoPessoaId(int tipoPessoaId) {
        this.tipoPessoaId = tipoPessoaId;
    }

    public Pessoa() {}

    public Pessoa(int id, String nome, String cpf, String cnpj, int tipoPessoaId) {
        this.setId(id);
        this.nome = nome;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.tipoPessoaId = tipoPessoaId;
    }

    @Override
    public String toString() {
        return "Pessoa {" +
                "id='" + this.getId() + "\n'" +
                "nome='" + nome + "\n'" +
                "cpf='" + cpf + "\n'" +
                "cnpj='" + cnpj + "\n'" +
                "tipoPessoaId" + tipoPessoaId + "\n'" +
                '}';
    }
}
