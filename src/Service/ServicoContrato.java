package Service;

import entities.Contrato;
import entities.Pagamento;

import java.util.Calendar;
import java.util.Date;

public class ServicoContrato {

    PagamentoOnlineDeServico pagamentoOnlineDeServico;

    public ServicoContrato(PagamentoOnlineDeServico pagamentoOnlineDeServico) {
        this.pagamentoOnlineDeServico = pagamentoOnlineDeServico;
    }


    public Date gerarData(Date data, Integer mesReferente){
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.MONTH,mesReferente);

        return cal.getTime();
    }
    public void gerarParcelasDoContrato(Contrato contrato, Integer mesesAPagar){
        int n = 1;
        Double valorTotal =  contrato.getValor() / mesesAPagar;
        while(n <= mesesAPagar){
            Date date = gerarData(contrato.getDataContrato(),n);
            Double taxMensal = pagamentoOnlineDeServico.taxaReferenteAoMes(valorTotal, n);
            Double taxFixa = pagamentoOnlineDeServico.taxaFixaMensal(taxMensal);
            contrato.adicionarLista(new Pagamento(taxFixa, date));
            n++;
        }





    }


}
