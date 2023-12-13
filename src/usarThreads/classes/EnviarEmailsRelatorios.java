package usarThreads.classes;

/**
 * Enviar e-mails com os relatórios
 *
 * @author Diego Mendes Rodrigues
 */
public class EnviarEmailsRelatorios {
    public EnviarEmailsRelatorios() {
        System.out.println("## MÓDULO DE E-MAILS E RELATÓRIOS");

        new Thread(() -> {
            try {
                enviarEmails();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread() {
            @Override
            public void run() {
                try {
                    gerarRelatorios();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }.start();

        System.out.println("## MÓDULO DE E-MAILS E RELATÓRIOS - FINALIZADO");
    }

    /**
     * Código que será executado em uma thread, enviando 20 e-mails, parando 1,0s antes de cada envio
     *
     * @throws InterruptedException
     */
    public void enviarEmails() throws InterruptedException {
        System.out.println("Thread de e-mail iniciada e executando em background");

        for (int i = 0; i < 20; i++) {
            Thread.sleep(1000);
            System.out.println("- Enviando um e-mail");
        }
    }

    /**
     * Código que será executado em uma thread, gerando 8 relatórios, parando 2s antes de gerar cada um
     *
     * @throws InterruptedException
     */
    public void gerarRelatorios() throws InterruptedException {
        System.out.println("Thread de gerar relatórios iniciada e executando em background");

        for (int i = 0; i < 8; i++) {
            Thread.sleep(2000);
            System.out.println("= Gerando um relatório");
        }
    }
}
