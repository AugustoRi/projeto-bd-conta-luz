package br.com.conta.model;

public class TimeRota extends GenericModel {
    private int funcionarioId;
    private int tarefaRotaId;

    public int getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public int getTarefaRotaId() {
        return tarefaRotaId;
    }

    public void setTarefaRotaId(int tarefaRotaId) {
        this.tarefaRotaId = tarefaRotaId;
    }

    public TimeRota() {}

    public TimeRota(int id, int funcionarioId, int tarefaRotaId) {
        this.setId(id);
        this.funcionarioId = funcionarioId;
        this.tarefaRotaId = tarefaRotaId;
    }

    @Override
    public String toString() {
        return "TimeRota {" + "\n'" +
                "id='" + this.getId() + "\n'" +
                "funcionarioId='" + funcionarioId + "\n'" +
                "tarefaRotaId='" + tarefaRotaId + "\n'" +
                '}';
    }
}
