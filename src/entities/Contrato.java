package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato {
    private Integer numeroContrato;
    private Date dataContrato;
    private Double valor;

    private Pagamento pagamento;
    List<Pagamento> lista = new ArrayList<Pagamento>();

    public Contrato() {
    }

    public Contrato(Integer numeroContrato, Date dataContrato, Double valor) {
        this.numeroContrato = numeroContrato;
        this.dataContrato = dataContrato;
        this.valor = valor;
    }

    public Integer getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(Integer numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public Date getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(Date dataContrato) {
        this.dataContrato = dataContrato;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public List<Pagamento> getLista() {
        return lista;
    }

    public void adicionarLista(Pagamento pagamento){
        lista.add(pagamento);
    }

    @Override
    public String toString() {
        return "Contrato: " + numeroContrato + " dataContrato: " + dataContrato + " valor: " + valor + " parcelas: " + pagamento.toString();


    }
}
