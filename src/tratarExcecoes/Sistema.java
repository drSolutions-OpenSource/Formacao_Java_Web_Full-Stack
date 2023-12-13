package tratarExcecoes;

import tratarExcecoes.classes.Carro;
import tratarExcecoes.classes.Fruta;
import tratarExcecoes.excecoes.ExcecaoProcessarFruta;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Sistema que demonstra o tratamento de exceções no Java.
 * Ao realizar o tratamento das exceções, podemos fazer com que os sistemas se recuperem automaticamente
 * e continuem a funcionar.
 * Caso não tratemos as exceções, teremos paradas no sistema e com isso uma empresa inteira pode ficar parada.
 * -
 * Exemplos de fatores externos (erros que não estão sob responsabilidade da equipe de desenvolvimento):
 * + Tentar abrir algo que não existe
 * + Tentar fazer uma consulta em um banco de dados que não está disponível
 * + Tentar escrever em um arquivo que não temos permissão
 * + Tentar conectar em um servidor inexistente ou fora de serviço
 * -
 * Exemplos de fatores internos (equipe de desenvolvimento consegue resolver rapidamente):
 * + Tentar manipular um objeto que está com o valor nulo
 * + Dividir um número por zero
 * + Tentar manipular um tipo de dado com se fosse outro
 * + Tentar utilizar um método ou uma classe que não existam
 * -
 * Arquitetura Java das Exceções:
 * -
 * .                                                                           Throwable
 * .                                                                               |
 * .                                                             +-----------------+-----------------------+
 * .                                                         Exception                                   Error
 * .                                                            |
 * .                                     +----------------------+----------------------------+
 * .                               RuntimeException                                       IOException
 * .                                    |                                                     |
 * .      +-----------------------------+------------------------------+              FileNotFoundException
 * NullPointerException     ArrayIndexOutOfBoundsException     ClassCastException
 * -
 * Estrutura do Tratamento de Exceções:
 * try {
 * ...
 * } catch (Exception e) {
 * e.printStackTrace(); --> Imprime a pilha de erro no console
 * ...
 * }
 * -
 * Outros exemplos:
 * <a href="http://www3.ifrn.edu.br/albalopes/wp-content/uploads/Aula-07-Tratamento-de-Exce%C3%A7%C3%A3o.pdf">Tratamento de Exceções</a>
 * <a href="http://www3.ifrn.edu.br/albalopes/?page_id=121">Alba Flores</a>
 *
 * @author Diego Mendes Rodrigues
 */
public class Sistema {
    public static void main(String[] args) {
        System.out.println("TRATAMENTO DE EXCEÇÕES NO JAVA");

        /*
         * Executar um exemplo de tratamento de exceção por vez
         */
        tratarNullPointer();

//        tratarArrayIndexOutOfBoundsException();

//        tratarArithmeticException();

//        tratarFileNotFoundException();

//        tratarNumberFormatException();

//        tratarMultiplasExcecoes();

//        try {
//            abrirArquivo();
//        } catch (FileNotFoundException e) {
//            System.out.println("Entre em contato com o suporte técnico!");
//            System.out.println("Erro ao ler o arquivo no Sistema: " + e.toString());
//        }

//        capturarQualquerExcecao();

//        entendendoClasseException();

//        criarExcecaoCustomizada();
    }

    /**
     * Gerar um NullPointerException e tratar o erro
     */
    public static void tratarNullPointer() {
        Carro carro = new Carro();
        carro = null;

        try {
            carro.setModelo("HB20");
            System.out.println(carro.toString());
        } catch (NullPointerException e) {
            System.out.println("Entre em contato com o suporte técnico!");
            System.out.println("Erro no Sistema:");
            e.printStackTrace();
        }
    }

    /**
     * Simular e tratar o ArrayIndexOutOfBoundsException
     */
    public static void tratarArrayIndexOutOfBoundsException() {
        int[] numeros = {50, 60, 20, 33};

        try {
            System.out.println(numeros[4]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Entre em contato com o suporte técnico!");
            System.out.println("Erro ao ler o array no Sistema:");
            e.printStackTrace();
        }
    }

    /**
     * Simular e corrigir uma divisão por zero
     */
    public static void tratarArithmeticException() {
        int num1 = 10, num2 = 0;

        try {
            System.out.println(num1 / num2);
        } catch (ArithmeticException e) {
            System.out.println("Entre em contato com o suporte técnico!");
            System.out.println("Erro ao dividir os números no Sistema:");
            e.printStackTrace();
        }
    }

    /**
     * Simular e tratar o erro FileNotFoundException
     */
    public static void tratarFileNotFoundException() {
        String arquivo = "arquivoNaoExiste.txt";

        try {
            File meuArquivo = new File(arquivo);
            Scanner leituraDeArquivo = new Scanner(meuArquivo);
            while (leituraDeArquivo.hasNextLine()) {
                String dadosLidos = leituraDeArquivo.nextLine();
                System.out.println(dadosLidos);
            }
            leituraDeArquivo.close();
        } catch (FileNotFoundException e) {
            System.out.println("Entre em contato com o suporte técnico!");
            System.out.println("Erro ao ler o arquivo no Sistema:");
            e.printStackTrace();
        }
    }

    /**
     * Simular um erro de conversão de uma String vazia para um número do Java
     */
    public static void tratarNumberFormatException() {
        String numeroDigitado = "100";
        numeroDigitado = "";

        try {
            int numero = Integer.parseInt(numeroDigitado);
            System.out.println("Número = " + numeroDigitado);
        } catch (NumberFormatException e) {
            System.out.println("Entre em contato com o suporte técnico!");
            System.out.println("Erro ao converter um número de uma String no Sistema:");
            e.printStackTrace();
        }

    }

    /**
     * Tratar mais de 1 tipo de exceção, utilizando o finally que é opcional
     */
    public static void tratarMultiplasExcecoes() {
        System.out.println("Entre com um número inteiro: ");
        Scanner sc = new Scanner(System.in);

        try {
            int x = sc.nextInt();
            int y = 100 / x;
            System.out.println("Resultado = " + y);
        } catch (InputMismatchException e) {
            System.out.println("Formato de dado inválido!");
            System.out.println("Detalhes do erro: " + e.toString());
        } catch (ArithmeticException e) {
            System.out.println("Operação inválida!");
            System.out.println("Detalhes do erro: " + e.toString());
        } finally {
            System.out.println("Bye!");
        }
    }

    /**
     * Transferimos o lançamento da exceção para o método
     * Essa exceção deve ser tratada no sistema principal, onde esse método é chamado
     *
     * @throws FileNotFoundException sendo a exceção quando o arquivo não existe
     */
    public static void abrirArquivo() throws FileNotFoundException {
        String arquivo = "arquivoNaoExiste.txt";

        File meuArquivo = new File(arquivo);
        if (meuArquivo == null) {
            throw new FileNotFoundException();
        }

        Scanner leituraDeArquivo = new Scanner(meuArquivo);
        while (leituraDeArquivo.hasNextLine()) {
            String dadosLidos = leituraDeArquivo.nextLine();
            System.out.println(dadosLidos);
        }
        leituraDeArquivo.close();
    }

    /**
     * Capturar qualquer exceção com Exception e
     * Nesse método, capturamos InputMismatchException, ArithmeticException, dentre outros
     */
    public static void capturarQualquerExcecao() {
        System.out.println("Entre com um número inteiro: ");
        Scanner sc = new Scanner(System.in);

        try {
            int x = sc.nextInt();
            int y = 100 / x;
            System.out.println("Resultado = " + y);
        } catch (Exception e) {
            System.out.println("Alguma exceção aconteceu!");
            System.out.println("Detalhes do erro: " + e.toString());
        }
    }

    /**
     * Entendendo as principais informações que temos em e.getStackTrace()[]....
     */
    public static void entendendoClasseException() {
        System.out.println("Entre com um número inteiro: ");
        Scanner sc = new Scanner(System.in);

        try {
            int x = sc.nextInt();
            int y = 100 / x;
            System.out.println("Resultado = " + y);
        } catch (Exception e) {
            System.out.println("Alguma exceção aconteceu!");
            System.out.println("Detalhes do erro: " + e.toString());
            System.out.println("Mensagem do erro: " + e.getMessage());
            System.out.println("Causa do erro: " + e.getCause());

            for (int posicao = 0; posicao < e.getStackTrace().length; posicao++) {
                StringBuilder saida = new StringBuilder();
                saida.append("Classe: " + e.getStackTrace()[posicao].getClassName());
                saida.append(" - Método: " + e.getStackTrace()[posicao].getMethodName());
                saida.append(" - Linha: " + e.getStackTrace()[posicao].getLineNumber());
                System.out.println(saida);
            }

            System.out.println(" ");
            for (int posicao = 0; posicao < e.getStackTrace().length; posicao++) {
                System.out.println(e.getStackTrace()[posicao]);
            }
        }
    }

    /**
     * Criar uma classe de exceção customizada, para poder tratar melhor algumas exceções
     */
    public static void criarExcecaoCustomizada() {
        Fruta fruta = new Fruta("Laranja", false);
        try {
            fruta.exibirFruta();
        } catch (ExcecaoProcessarFruta e) {
            System.out.println(" ");
            System.out.println("Exceção..: " + e.getClass());
            System.out.println("Mensagem.: " + e.getMessage());
            System.out.println("Classe...: " + e.getStackTrace()[0].getClassName());
            System.out.println("Método...: " + e.getStackTrace()[0].getMethodName());
            System.out.println("Linha....: " + e.getStackTrace()[0].getLineNumber());
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
