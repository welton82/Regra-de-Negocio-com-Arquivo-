package Service;

public interface PagamentoOnlineDeServico {
    public Double taxaReferenteAoMes(Double valor, Integer mesReferente);
    public Double taxaFixaMensal(Double valor);
}
