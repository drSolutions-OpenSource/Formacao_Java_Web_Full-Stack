package usarArquivos;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Escrever e ler arquivos TXT
 *
 * @author Diego Mendes Rodrigues
 */
public class ArquivoTXT {
    static String caminho = "C:\\Users\\diego\\IdeaProjects\\CursoJava\\src\\usarArquivos\\";

    public static void main(String[] args) throws IOException {
        escreverArquivoTxt();

        lerArquivoTxt();
    }

    /**
     * Escrever um arquivo TXT
     *
     * @throws IOException sendo o erro na abertura e criação do arquivo
     */
    public static void escreverArquivoTxt() throws IOException {
        String[] pessoas = {"Diego Rodrigues", "Natalia Neau", "Bruna Mendes", "", "Jerome Neau", "Regina Marcia"};
        File arquivo = new File(caminho + "arquivo.txt");

        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }

        FileWriter escreverTxt = new FileWriter(arquivo);

        for (String pessoa : pessoas) {
            escreverTxt.write(pessoa + System.lineSeparator());
        }

        escreverTxt.flush();
        escreverTxt.close();

        System.out.println("Arquivo TXT criado" + System.lineSeparator());
    }

    /**
     * Ler um arquivo TXT e exibir suas linhas na tela
     *
     * @throws FileNotFoundException erro quando o arquivo não for encontrado
     */
    public static void lerArquivoTxt() throws FileNotFoundException {
        System.out.println("# Ler Arquivo TXT");

        FileInputStream entradaDeDados = new FileInputStream(caminho + "arquivo.txt");

        Scanner lerArquivo = new Scanner(entradaDeDados, StandardCharsets.UTF_8);

        while (lerArquivo.hasNext()) {
            String linha = lerArquivo.nextLine();

            /* Não imprimir linha em branco */
            if (linha != null && !linha.isEmpty()) {
                System.out.println(linha);
            }
        }

        lerArquivo.close();
        System.out.println(System.lineSeparator());
    }
}
