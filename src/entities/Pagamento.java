package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pagamento {
    private Double valor;
    private Date data;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Pagamento() {
    }

    public Pagamento(Double valor, Date data) {
        this.valor = valor;
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Data do Pagamento: " + sdf.format(data) + ".....Valor: " + String.format("%.2f", valor));
        s.append("\n");
        return s.toString();
    }
}














