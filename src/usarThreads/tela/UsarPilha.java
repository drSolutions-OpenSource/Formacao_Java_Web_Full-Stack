package usarThreads.tela;

import usarThreads.classes.ImplementacaoFilaThread;
import usarThreads.classes.Pessoa;

/**
 * Fila/pilha de execução em Thread
 * Através de uma tela, ou processo, pode-se adicionar uma lista, por exemplo, gerar um arquivo PDF, ou enviar
 * um e-mail, ou gerar 10000 notas discais, integração do sistema central com os das filiais, dentre outros
 * Usar: ConcurredLinkedQueue
 *
 * @author Diego Mendes Rodrigues
 */
public class UsarPilha {
    private static ImplementacaoFilaThread fila = new ImplementacaoFilaThread();

    public static void main(String[] args) {
//        exemplo1();

        exemplo2();
    }

    /**
     * Exemplo 1: Uso de fila
     */
    public static void exemplo1() {
        System.out.println("Sistema para o envio de e-mails");

        fila.start();
        System.out.println("Envios foram solicitados através da fila");

        Pessoa pessoa1 = new Pessoa("Ana Maria", "ana@fake.io");
        Pessoa pessoa2 = new Pessoa("Bruna Mendes", "bruna@fake.io");
        Pessoa pessoa3 = new Pessoa("Bartolomeu", "bart@fake.io");
        Pessoa pessoa4 = new Pessoa("Regina Marcia", "regina@fake.io");
        Pessoa pessoa5 = new Pessoa("Diego Rodrigues", "diego@fake.io");
        Pessoa pessoa6 = new Pessoa("Ingrid Bittar", "ingrid@fake.io");
        Pessoa pessoa7 = new Pessoa("Natalia Neau", "natalia@fake.io");
        Pessoa pessoa8 = new Pessoa("Jerome Neau", "jerome@fake.io");
        Pessoa pessoa9 = new Pessoa("Julia Neau", "julia@fake.io");
        Pessoa pessoa10 = new Pessoa("Gabriela Neau", "gabriela@fake.io");

        fila.add(pessoa1);
        fila.add(pessoa2);
        fila.add(pessoa3);
        fila.add(pessoa4);
        fila.add(pessoa5);

        /* Adicionar mais 5 pessoas */
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("## Mais 5 pessoas na lista");
        fila.add(pessoa6);
        fila.add(pessoa7);
        fila.add(pessoa8);
        fila.add(pessoa9);
        fila.add(pessoa10);

        System.out.println("# Sistema continua executando");
    }

    /**
     * Exemplo 2: Controlando a Thread, parando e continuando ela
     */
    public static void exemplo2() {
        System.out.println("Sistema para o envio de e-mails");

        fila.start();
        System.out.println("Envios foram solicitados através da fila");

        /* Adicionar 100 pessoas na fila */
        adicionar100PessoasFila();
        System.out.println("# Sistema continua executando");

        /* Depois de 10s, parar a fila */
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        /* Encerrar a fila */
        fila.stop();
        fila = null;
        System.out.println("## Fila não existe mais");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        /* Iniciar uma nova fila */
        System.out.println("# Criando uma nova fila");
        /* Adicionar 100 pessoas na fila */
        adicionar100PessoasFila();
        System.out.println("# Sistema continua executando");
    }

    /**
     * Adicionar 100 pessoas na fila
     */
    public static void adicionar100PessoasFila() {
        if (fila == null) {
            fila = new ImplementacaoFilaThread();
            fila.start();
        }
        /* Adicionar 100 pessoas */
        System.out.println("## 100 pessoas na lista");
        for (int i = 0; i < 10; i++) {
            Pessoa pessoa1 = new Pessoa("Ana Maria " + i, "ana@fake.io");
            Pessoa pessoa2 = new Pessoa("Bruna Mendes " + i, "bruna@fake.io");
            Pessoa pessoa3 = new Pessoa("Bartolomeu " + i, "bart@fake.io");
            Pessoa pessoa4 = new Pessoa("Regina Marcia " + i, "regina@fake.io");
            Pessoa pessoa5 = new Pessoa("Diego Rodrigues " + i, "diego@fake.io");
            Pessoa pessoa6 = new Pessoa("Ingrid Bittar " + i, "ingrid@fake.io");
            Pessoa pessoa7 = new Pessoa("Natalia Neau " + i, "natalia@fake.io");
            Pessoa pessoa8 = new Pessoa("Jerome Neau " + i, "jerome@fake.io");
            Pessoa pessoa9 = new Pessoa("Julia Neau " + i, "julia@fake.io");
            Pessoa pessoa10 = new Pessoa("Gabriela Neau " + i, "gabriela@fake.io");

            fila.add(pessoa1);
            fila.add(pessoa2);
            fila.add(pessoa3);
            fila.add(pessoa4);
            fila.add(pessoa5);
            fila.add(pessoa6);
            fila.add(pessoa7);
            fila.add(pessoa8);
            fila.add(pessoa9);
            fila.add(pessoa10);
        }
    }
}
