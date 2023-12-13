package usarThreads;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Classe que emite Notas Fiscais, chamada através de threads com o Runnable
 *
 * @author Diego Mendes Rodrigues
 */
public class EmitirNF {
    public EmitirNF() {
        System.out.println("# SISTEMA DE NOTAS FISCAIS");

        Thread nfFisica = new Thread(emitirNfFisica);
        nfFisica.start();

        Thread nfEletronica = new Thread(emitirNfEletronica);
        nfEletronica.start();

        System.out.println("# THREADS INICIALIZADAS");
        System.out.println("Estado NF Física: " + nfFisica.getState());
        System.out.println("Está executando: " + nfFisica.isAlive());
        System.out.println("Id: " + nfFisica.getId());
        System.out.println("É um daemon: " + nfFisica.isDaemon());
        System.out.println("Prioridade: " + nfFisica.getPriority());

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        nfFisica.stop();
        System.out.println("* Parando a emissão na NF Física");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        nfEletronica.stop();
        System.out.println("* Parando a emissão na NF Eletrônica");
    }

    /**
     * Emitir NFs Físicas a cada 1 segundo
     */
    private static Runnable emitirNfFisica = new Runnable() {
        @Override
        public void run() {
            System.out.println("Thread 1 para emitir NF Física e executando em background");

            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("- Emitindo NF Física");
            }
        }
    };

    /**
     * Emitir NFs Eletrônicas a cada 1 segundo
     */
    private static Runnable emitirNfEletronica = new Runnable() {
        @Override
        public void run() {
            System.out.println("Thread 2 para emitir NF Eletrônica iniciada e executando em background");

            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("- Emitindo NF Eletrônica - " + new SimpleDateFormat("dd/MM/yyyy HH:mm.ss")
                        .format(Calendar.getInstance().getTime()));
            }
        }
    };
}
