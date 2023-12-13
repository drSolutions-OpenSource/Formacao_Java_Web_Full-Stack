package usarThreads.classes;

/**
 * Realizar baixas no estoque
 *
 * @author Diego Mendes Rodrigues
 */
public class BaixarEstoque {
    public BaixarEstoque() {
        System.out.println("## MÓDULO PARA BAIXAR O ESTOQUE");

        new Thread() {
            @Override
            public void run() {
                try {
                    realizarBaixa();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }.start();

        System.out.println("## MÓDULO PARA BAIXAR O ESTOQUE - FINALIZADO");
    }

    /**
     * Código que será executado em uma thread, para realizar a baixa no estoque 6 vezes, parando 4,0s
     * antes de cada baixa
     *
     * @throws InterruptedException
     */
    public void realizarBaixa() throws InterruptedException {
        System.out.println("Thread para a baixa de estoque executando em background");

        for (int i = 0; i < 6; i++) {
            Thread.sleep(4000);
            System.out.println("+ Baixando o estoque");
        }
    }
}
