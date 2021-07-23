package aplication;

import Service.PicPay;
import Service.ServicoContrato;
import entities.Contrato;
import entities.Pagamento;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner scan = new Scanner(System.in);

        sistema(scan);


    }
    public static Integer menu(Scanner scan){
        System.out.println("=================== MENU DE OPERAÇÕES DO SISTEMA ============================");
        System.out.println("1 - Gerar Pagamento e Gravar arquivo.txt");
        System.out.println("2 - Ler Arquivo Gerado");
        System.out.println("5 - Sair");
        System.out.print("Operação: ");
        return scan.nextInt();
    }

    public static void sistema(Scanner scan) throws ParseException {
        int op=0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        while(op != 5) {
             op = menu(scan);
             switch(op)
             {
                 case 1:
                     System.out.println("------- INSIRA OS DADOS DO PAGAMENTO ------");
                     System.out.print("Valor Total do Pagamento: ");
                     double valor = scan.nextDouble();
                     System.out.print("Data da Compra: ");
                     String dt = scan.next();
                     Date data = sdf.parse(dt);
                     System.out.print("Informe a Quantidade que Deseja parcelar: ");
                     int qdeParcelas = scan.nextInt();
                     System.out.print("Informe o Numero do Contrato: ");
                     int numContrato = scan.nextInt();

                     Contrato contrato = new Contrato(numContrato,data, valor);
                     ServicoContrato servicoContrato = new ServicoContrato(new PicPay());

                     servicoContrato.gerarParcelasDoContrato(contrato,qdeParcelas);
                     System.out.println("-------- LISTANDO PAGAMENTO ---------------");
                     for(Pagamento p: contrato.getLista()){
                         System.out.println(p);
                     }
                     System.out.println("--------GERANDO ARQUIVO FILE -------------");
                     System.out.print("Informe o Caminho e nome do Arquivo para salvar ex:(c:\\pasta\\arquivo.txt): ");
                     String caminho = scan.next();

                     String lines[] = {String.valueOf(contrato.getLista())};
                     try(BufferedWriter bf = new BufferedWriter(new FileWriter(caminho, true))){

                         for (String l:lines){
                             bf.write(l);
                             bf.newLine();
                         }
                         System.out.println("Sucess!!!");

                     } catch (IOException e) {
                         e.printStackTrace();
                     }

                     break;
                 case 2:

                     System.out.print("Informe o nome do Arquivo para Leitura: ");
                     String path = scan.next();

                     FileReader fr = null;
                     BufferedReader br = null;
                     try {
                         fr = new FileReader(path);
                         br = new BufferedReader(fr);

                     } catch (FileNotFoundException e) {
                         e.printStackTrace();
                     }


                     String line = null;
                     try {
                         line = br.readLine();
                     } catch (IOException e) {
                         e.printStackTrace();
                         System.out.println(e.getMessage());
                     }
                     while(line != null){
                         System.out.println(line);
                         try {
                             line = br.readLine();
                         } catch (IOException e) {
                             e.printStackTrace();
                             System.out.println(e.getMessage());
                         }
                     }
                     System.out.println();
                     break;
             }

        }

    }


}
