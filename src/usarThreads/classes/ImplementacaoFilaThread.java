package usarThreads.classes;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Implementar filas de Threads no Java
 *
 * @author Diego Mendes Rodrigues
 */
public class ImplementacaoFilaThread extends Thread {
    private static ConcurrentLinkedQueue<Pessoa> pilhaFila = new ConcurrentLinkedQueue<Pessoa>();

    public static void add(Pessoa pessoa) {
        pilhaFila.add(pessoa);
    }

    @Override
    public void run() {
        System.out.println("Fila rodando...");

        /*
         * A sincronização bloqueia o acesso a esta lista por outras Threads, enquanto estamos processando
         */
        while (true) {
            Iterator iteracao = pilhaFila.iterator();

            synchronized (iteracao) {
                /* Processamos enquanto tivermos dados na lista */
                while (iteracao.hasNext()) {
                    Pessoa processar = (Pessoa) iteracao.next();

                    /*
                     * Agora processamos o objeto da lista
                     * Exemplo: Gerar 1000 arquivos PDF, enviar 1000 e-mails, etc
                     * Aqui demora!
                     */
                    System.out.println(processar.getNome());
                    System.out.println(processar.getEmail());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    /*
                     * Remover o item da lista que contem a pilha
                     * Depois, precisamos de um sleep de pelo menos 500ms, para a descarga da memória do SO
                     */
                    iteracao.remove();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.println("- Acabaram os registros da pilha");
            
            /*
             * Após processar toda a lista, precisamos de mais um tempo para a para a descarga da memória do SO
             */
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
