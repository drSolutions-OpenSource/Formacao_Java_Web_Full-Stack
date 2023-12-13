package usarArrayMatriz;

import usarArrayMatriz.classes.Monitor;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Array (Vetores) e Matrizes - Estrutura de Dados em Java
 *
 * @author Diego Mendes Rodrigues
 */
public class Sistema {
    public static void main(String[] args) {
        /*
         * Executar um exemplo de array/matriz por vez
         */
        criarArrays();

//        entradaDeArrayPeloUsuario();

//        formasDeAtribuirValores();

//        descobrirMaiorMenorMediaDeNotas();

//        manipularArraysObjetos();

//        utilizarMatrizes();

//        splitStringArray();

//        converterArrayLista();
    }

    /**
     * Criar um Array (um vetor)
     * O Array pode ser de todos os tipos (ou objetos) de dados
     */
    public static void criarArrays() {
        /* Devemos sempre ter a quantidade de posições no array */
        int[] quantidades = new int[4];
        double[] notas = new double[3];

        System.out.println(quantidades.length);
        System.out.println(notas.length);
        System.out.println(" ");

        quantidades[0] = 10;
        quantidades[1] = 85;
        quantidades[2] = 65;
        quantidades[3] = 23;

        notas[0] = 8.5;
        notas[1] = 9.2;
        notas[2] = 7.5;

        for (int quantidade : quantidades) {
            System.out.println(quantidade);
        }
        System.out.println(" ");

        for (double nota : notas) {
            System.out.println(nota);
        }
        System.out.println(" ");

        for (int posicao = 0; posicao < notas.length; posicao++) {
            System.out.println("Nota " + (posicao + 1) + " = " + notas[posicao]);
        }

        System.out.println("Média das " + notas.length + " notas = " + calcularMedia(notas));
        System.out.println(" ");
    }

    /**
     * Receber um array como parâmetro e calcular e média com os valores dele
     *
     * @param valores sendo os valores recebidos para a média
     * @return média calculada com os valores de notas do array
     */
    public static String calcularMedia(double[] valores) {
        if (valores.length > 0) {
            double total = 0.0;
            for (double valor : valores) {
                total += valor;
            }
            if (total > 0) {
                DecimalFormat df = new DecimalFormat("###.00");
                return df.format(total / valores.length);
            }
        }
        return "0.00";
    }

    /**
     * O usuário irá informar quantas notas ele possui, para criarmos um Array, receber as notas,
     * e depois, calcular a média
     */
    public static void entradaDeArrayPeloUsuario() {
        int quantidadeNotas = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quantas notas serão informadas? ");
        quantidadeNotas = scanner.nextInt();

        if (quantidadeNotas < 2) {
            System.out.println("Devem ser informadas pelo menos 2 notas");
            return;
        }

        System.out.println("\nInforme as notas\n----------------");
        Scanner nota = new Scanner(System.in);
        double[] notas = new double[quantidadeNotas];
        for (int i = 0; i < quantidadeNotas; i++) {
            System.out.print("Nota " + (i + 1) + " = ");
            notas[i] = nota.nextDouble();
        }

        System.out.println(" ");
        System.out.println("Média das " + quantidadeNotas + " notas = " + calcularMedia(notas));
        System.out.println(" ");
    }

    /**
     * Diversas formas de atribuir valores aos Arrays e Matrizes
     */
    public static void formasDeAtribuirValores() {
        int[] valores = new int[2];
        valores[0] = 9;
        valores[1] = 8;

        /* Ao passarmos direto, o Java entende o tamanho do Array que será criado */
        double[] notas = {9.0, 8.5, 7.3};
        String[] pessoas = {"Ana", "Bruna", "Julia"};

        /* Vários tipos de dados no mesmo array */
        String[] informacoes = new String[4];
        informacoes[0] = "Diego";   // String - Nome
        informacoes[1] = "1.70";    // Float - Altura
        informacoes[2] = "41";      // Int - Idade
        informacoes[3] = "true";    // Boolean - Matriculado

        /*
         * Matriz com 2 vetores
         */
        String[][] alunos = {{"Bruna", "1.56", "17", "false"}, {"Diego", "1.70", "41", "true"}};

        for (String[] aluno : alunos) {
            System.out.print("O aluno " + aluno[0] + " com a altura " + aluno[1] + " metros ");
            if (Integer.parseInt(aluno[2]) >= 18) {
                System.out.print("é ");
            } else {
                System.out.print("não é ");
            }
            System.out.print("maior de idade e ");
            if (Boolean.parseBoolean(aluno[3])) {
                System.out.print("está ");
            } else {
                System.out.print("não está ");
            }
            System.out.println("matriculado.");
            System.out.println(" ");
        }
    }

    /**
     * Utilizar os métodos existentes no Java para Arrays, encontrando o maior valor, menor valor e a média
     */
    public static void descobrirMaiorMenorMediaDeNotas() {
        double[] notas = {6.9, 4.2, 8.3, 9.2, 6.3, 9.5, 7.6};

        System.out.println("Maior nota = " + Arrays.stream(notas).max().getAsDouble());
        System.out.println("Menor nota = " + Arrays.stream(notas).min().getAsDouble());
        if (Arrays.stream(notas).average().isPresent()) {
            System.out.println("Média = " + Arrays.stream(notas).average().getAsDouble());
        }
        System.out.println(" ");
    }

    /**
     * Iremos criar Arrays de objetos da classe Monitor
     */
    public static void manipularArraysObjetos() {
        Monitor[] monitores = new Monitor[3];
        monitores[0] = new Monitor("Samsung", 24.0F);
        monitores[1] = new Monitor("LG", 19.4F);
        monitores[2] = new Monitor("Acer", 21.0F);

        for (Monitor monitor : monitores) {
            System.out.println("Marca " + monitor.getMarca() + " com " + monitor.getTamanho() + " polegadas");
        }
        System.out.println(" ");
    }

    /**
     * Criar matrizes, que são vetores bidimensionais, ou multidimensionais
     */
    public static void utilizarMatrizes() {
        /* Matriz com 2 linhas e 4 colunas */
        int[][] pixelDaTela = new int[2][4];

        pixelDaTela[0][0] = 250;
        pixelDaTela[0][1] = 128;
        pixelDaTela[0][2] = 65;
        pixelDaTela[0][3] = 97;

        pixelDaTela[1] = new int[]{236, 120, 55, 3};

        for (int linha = 0; linha < pixelDaTela.length; linha++) {
            for (int coluna = 0; coluna < pixelDaTela[0].length; coluna++) {
                System.out.print(pixelDaTela[linha][coluna] + " ");
            }
            System.out.print("\n");
        }
        System.out.println(" ");
    }

    /**
     * O método split() quebra uma String, utilizando um separador, retornando um Array String[]
     */
    public static void splitStringArray() {
        String informacoes = "Diego;1.7;41;true";

        /* Quebrando a matriz com o separador ";" */
        String[] aluno = informacoes.split(";");

        /* Exibir is itens do Array na tela */
        for (String item : aluno) {
            System.out.println(item);
        }
        System.out.println(" ");

        String estaMatriculado = Boolean.parseBoolean(aluno[3]) ? "Sim!" : "Não!";
        System.out.println(aluno[0] + " está matriculado? " + estaMatriculado);
        System.out.println(" ");
    }

    /**
     * Converter um Array para uma Lista, e depois, a Lista para um Array
     */
    public static void converterArrayLista() {
        String nomes = "Ana Maria;Bruna;Diego;Julia";
        String[] nomesSeparados = nomes.split(";");

        for (String nome : nomesSeparados) {
            System.out.println(nome);
        }
        System.out.println(" ");

        List<String> listaNomes = Arrays.asList(nomesSeparados);
        System.out.println("Array convertido para Lista");
        for (String listaNome : listaNomes) {
            System.out.println(listaNome);
        }
        System.out.println(" ");

        String[] arrayNomes = listaNomes.toArray(new String[nomesSeparados.length]);
        System.out.println("Lista convertida para Array");
        for (String arrayNome : arrayNomes) {
            System.out.println(arrayNome);
        }
        System.out.println(" ");
    }
}
