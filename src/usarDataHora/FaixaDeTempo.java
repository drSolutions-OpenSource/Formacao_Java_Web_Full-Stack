package usarDataHora;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Calcular a faixa de tempo com ChronoUnit, sendo que essa biblioteca utiliza o LocalDate nas duas datas de entrada
 * Calcular a períodos entre dadas com o Period, sendo que essa biblioteca utiliza o LocalDate nas duas datas de entrada
 *
 * @author Diego Mendes Rodrigues
 */
public class FaixaDeTempo {
    public static void main(String[] args) {
        usarChronoUnit();

        usarPeriod();
    }

    /**
     * Usar o ChronoUnit para calcular a faiza de tempo
     */
    public static void usarChronoUnit() {
        System.out.println("# ChronoUnit");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        /* Diferença de dias */
        System.out.println("Data 1: 05/12/2023");
        System.out.println("Data 2: 10/12/2023");

        long dias = ChronoUnit.DAYS.between(LocalDate.parse("2023-12-05"), LocalDate.parse("2023-12-10"));
        System.out.println("Dias: " + dias);
        System.out.println(" ");

        /* Diferença de semanas */
        System.out.println("Data 1: 05/10/2023");
        System.out.println("Data 2: 10/12/2023");

        long semanas = ChronoUnit.WEEKS.between(LocalDate.parse("2023-10-05"), LocalDate.parse("2023-12-10"));
        System.out.println("Semanas: " + semanas);
        System.out.println(" ");

        /* Diferença de meses */
        System.out.println("Data 1: 05/10/2023");
        System.out.println("Data 2: 10/12/2023");

        long meses = ChronoUnit.MONTHS.between(LocalDate.parse("2023-10-05"), LocalDate.parse("2023-12-10"));
        System.out.println("Meses: " + meses);
        System.out.println(" ");

        /* Diferença de anos */
        System.out.println("Data 1: 05/10/2020");
        System.out.println("Data 2: 10/12/2023");

        long anos = ChronoUnit.YEARS.between(LocalDate.parse("2020-10-05"), LocalDate.parse("2023-12-10"));
        System.out.println("Anos: " + anos);
        System.out.println(" ");
    }

    /**
     * Calcular a períodos entre dadas com o Period
     */
    public static void usarPeriod() {
        System.out.println("# Period");
        LocalDate dataAntiga = LocalDate.parse("2022-03-15");
        LocalDate dataRecente = LocalDate.parse("2023-10-05");

        System.out.println("Antiga.: " + dataAntiga.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Recente: " + dataRecente.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println(" ");

        System.out.println("Data antiga > Data recente: " + dataAntiga.isAfter(dataRecente));
        System.out.println("Data recente > Data antiga: " + dataRecente.isAfter(dataAntiga));
        System.out.println(" ");

        System.out.println("Data antiga < Data recente: " + dataAntiga.isBefore(dataRecente));
        System.out.println("Data recente < Data antiga: " + dataRecente.isBefore(dataAntiga));
        System.out.println(" ");

        System.out.println("Data antiga = Data recente: " + dataAntiga.isEqual(dataRecente));
        System.out.println(" ");

        /* Period */
        Period periodo = Period.between(dataAntiga, dataRecente);
        System.out.println("O período é " + periodo.getYears() + " anos, " + periodo.getMonths() +
                " meses e " + periodo.getDays() + " dias.");
        System.out.println("Total de meses: " + periodo.toTotalMonths());
        System.out.println(" ");
    }
}
