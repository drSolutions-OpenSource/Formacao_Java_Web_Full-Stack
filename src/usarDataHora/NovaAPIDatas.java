package usarDataHora;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Nova API de data implementada desde o Java 8, a LocalDate com o DateTimeFormater
 *
 * @author Diego Mendes Rodrigues
 */
public class NovaAPIDatas {
    static String[] diasDaSemanaLocalDate = {"Seg", "Ter", "Qua", "Qui", "Sex", "Sab", "Dom"};

    public static void main(String[] args) {
        usarLocalDate();

        usarDiasSemanasMesesAnos();
    }

    /**
     * Utilizar o LocalDate
     */
    public static void usarLocalDate() {
        System.out.println("# Usar o LocalDate");

        /* Nova API de data implementada desde o Java 8 */
        LocalDate dataAtual = LocalDate.now();
        System.out.println("Data atual: " + dataAtual);

        LocalTime horaAtual = LocalTime.now();
        System.out.println("Hora atual: " + horaAtual);

        LocalDateTime dataHoraAtual = LocalDateTime.now();
        System.out.println("Data e hora atuais: " + dataHoraAtual);
        System.out.println(" ");

        System.out.println("Data e hora atuais: " + dataHoraAtual.format(
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        System.out.println("Data atual: " + dataAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Hora atual: " + horaAtual.format(DateTimeFormatter.ofPattern("HH:mm")));
        System.out.println(" ");
    }

    /**
     * Funções que retornam dia, semana, mês e ano do LocalDate
     */
    public static void usarDiasSemanasMesesAnos() {
        System.out.println("# Calcular dias, semanas, meses e anos");
        LocalDate dataAtual = LocalDate.now();
        System.out.println("Data atual: " + dataAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println(" ");

        System.out.println("Dia da semana: " + dataAtual.getDayOfWeek());
        System.out.println("Dia da semana: " + dataAtual.getDayOfWeek().ordinal());
        System.out.println("Dia da semana: " + diasDaSemanaLocalDate[dataAtual.getDayOfWeek().ordinal()]);
        System.out.println(" ");

        System.out.println("Mês: " + dataAtual.getMonth());
        System.out.println("Mês: " + dataAtual.getMonthValue());
        System.out.println("Dia do Mês: " + dataAtual.getDayOfMonth());
        System.out.println(" ");

        System.out.println("Ano: " + dataAtual.getYear());
        System.out.println("Dia do Ano: " + dataAtual.getDayOfYear());
        System.out.println(" ");
    }
}
