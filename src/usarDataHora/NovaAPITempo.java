package usarDataHora;

import java.time.Duration;
import java.time.Instant;

/**
 * Usar a API Instant
 *
 * @author Diego Mendes Rodrigues
 */
public class NovaAPITempo {
    public static void main(String[] args) throws InterruptedException {
        Instant tempoInicial = Instant.now();

        /* Atrasando 1 munito */
        tempoInicial = tempoInicial.minusMillis(60000);

        Thread.sleep(3000);

        Instant tempoFinal = Instant.now();

        Duration duracao = Duration.between(tempoInicial, tempoFinal);
        System.out.println("Duração em nanosegundos: " + duracao.toNanos());
        System.out.println("Duração em milisegundos: " + duracao.toMillis());
        System.out.println("Duração em segundos: " + duracao.toSeconds());
        System.out.println("Duração em minutos: " + (long) duracao.toMinutes());
        System.out.println(" ");

        /* Atrasando 2 horas */
        tempoInicial = tempoFinal.minusSeconds(7200);
        duracao = Duration.between(tempoInicial, tempoFinal);
        System.out.println("Duração em horas: " + duracao.toHours());
        System.out.println(" ");

        /* Atrasando 3 dias */
        tempoInicial = tempoFinal.minusSeconds(24 * 60 * 60 * 3);
        duracao = Duration.between(tempoInicial, tempoFinal);
        System.out.println("Duração em dias: " + duracao.toDays());
        System.out.println(" ");
    }
}
