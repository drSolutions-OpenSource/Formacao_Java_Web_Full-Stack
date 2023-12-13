package usarDataHora;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * Criar parcelas mensais, como utilizadas no vencimento de parcelas de pagamentos
 *
 * @author Diego Mendes Rodrigues
 */
public class CriarParcelasMensais {
    public static void main(String[] args) throws ParseException {
        criarParcelasComCalendar();

        criarParcelasComLocalDate();
    }

    /**
     * Criar parcelas com Calendar()
     *
     * @throws ParseException sendo a exceção ao realizar o parse de uma sata no formato String
     */
    public static void criarParcelasComCalendar() throws ParseException {
        System.out.println("# Calendar()");

        Date dataDaCompra = new SimpleDateFormat("dd/MM/yyyy").parse("10/12/2023");
        System.out.println("Data da compra: " +
                new SimpleDateFormat("dd/MM/yyyy").format(dataDaCompra.getTime()));

        Calendar parcelas = Calendar.getInstance();
        parcelas.setTime(dataDaCompra);

        /* Gerar 10 parcelas mensais */
        for (int parcela = 1; parcela <= 10; parcela++) {
            parcelas.add(Calendar.MONTH, 1);
            System.out.println("Parcela de número " + parcela + " com o vencimento em " +
                    new SimpleDateFormat("dd/MM/yyyy").format(parcelas.getTime()));
        }
        System.out.println(" ");
    }

    /**
     * Criar parcelas com Period()
     */
    public static void criarParcelasComLocalDate() {
        System.out.println("# Period() / LocalDate()");

        LocalDate dataDaCompra = LocalDate.parse("2023-12-10");
        System.out.println("Data da compra: " + dataDaCompra.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        LocalDate novaData = dataDaCompra.plusDays(5);
        System.out.println("Nova data.....: " + novaData.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        novaData = dataDaCompra.plusMonths(1);
        System.out.println("Nova data.....: " + novaData.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println(" ");

        /* Gerar 10 parcelas */
        for (int parcela = 1; parcela <= 10; parcela++) {
            novaData = dataDaCompra.plusMonths(parcela);
            System.out.println("Parcela número " + parcela + " com vencimento em " +
                    novaData.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
        System.out.println(" ");
    }
}
