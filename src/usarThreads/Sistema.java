package usarThreads;

import usarThreads.classes.BaixarEstoque;
import usarThreads.classes.EnviarEmailsRelatorios;

/**
 * Utilizar Threads para executar diversas partes do sistema de forma concorrente (simultânea).
 * Quando utilizadas, o SO gerencia a execução das threads que estão 'concorrendo' pela execução.
 *
 * @author Diego Mendes Rodrigues
 */
public class Sistema {
    public static void main(String[] args) throws InterruptedException {
        /*
         * Executar um exemplo de Threads por vez
         */

        /* Demonstração de como inicializar duas threads simultaneamente */
        inicializarThreads();

//        organizarUsoThreads();
    }

    /**
     * Inicializar 2 threads simultaneamente
     */
    public static void inicializarThreads() {
        System.out.println("# SISTEMA PRINCIPAL");

        /* Ações e funcionalidades do sistema que serão executadas em background de forma concorrente */
        EnviarEmailsRelatorios enviarEmailsRelatorios = new EnviarEmailsRelatorios();
        BaixarEstoque baixarEstoque = new BaixarEstoque();

        System.out.println("# SISTEMA PRINCIPAL - FINALIZADO");
        System.out.println("# THREADS EXECUTADAS DE FORMA CONCORRENTE");
    }

    /**
     * Usar o Runnable para trabalhar com as threads através de objetos
     */
    public static void organizarUsoThreads() {
        EmitirNF emitirNF = new EmitirNF();
    }
}
