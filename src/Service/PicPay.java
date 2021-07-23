package Service;

public class PicPay implements PagamentoOnlineDeServico{

    @Override
    public Double taxaReferenteAoMes(Double valor, Integer mesReferente) {
        return valor*1/100*mesReferente + valor;
    }

    @Override
    public Double taxaFixaMensal(Double valor) {
        return valor*2/100+valor;
    }
}
