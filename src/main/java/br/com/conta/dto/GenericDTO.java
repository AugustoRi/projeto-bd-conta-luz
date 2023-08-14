package br.com.conta.dto;

public class GenericDTO {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GenericDTO {" +
                "id=" + id +
                '}';
    }
}
