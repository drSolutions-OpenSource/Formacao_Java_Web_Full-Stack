package usarArquivos;

import usarArquivos.classes.Pessoa;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Escrever e ler arquivos CSV
 *
 * @author Diego Mendes Rodrigues
 */
public class ArquivoCSV {
    static String caminho = "C:\\Users\\diego\\IdeaProjects\\CursoJava\\src\\usarArquivos\\";

    public static void main(String[] args) throws IOException {
        escreverArquivoCSV();

        lerArquivoCsv();
    }

    /**
     * Escrever um arquivo CSV utilizando os atributos da Classe Pessoa
     *
     * @throws IOException sendo o erro na abertura e criação do arquivo
     */
    public static void escreverArquivoCSV() throws IOException {
        Pessoa pessoa1 = new Pessoa("Diego Rodrigues", "diego@fake.io", 41);
        Pessoa pessoa2 = new Pessoa("Natalia Neau", "natalia@fake.io", 38);
        Pessoa pessoa3 = new Pessoa("Bruna Mendes", "bruna@fake.io", 35);
        Pessoa pessoa4 = new Pessoa("Ingrid Bittar", "ingrid@fake.io", 26);
        Pessoa pessoa5 = new Pessoa("Regina Marcia", "regina@fake.io", 61);

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);
        pessoas.add(pessoa4);
        pessoas.add(pessoa5);

        File arquivo = new File(caminho + "arquivo.csv");

        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }

        FileWriter escreverCsv = new FileWriter(arquivo);

        for (Pessoa pessoa : pessoas) {
            escreverCsv.write(pessoa.toCSV());
        }

        escreverCsv.flush();
        escreverCsv.close();

        System.out.println("Arquivo CSV criado" + System.lineSeparator());
    }

    /**
     * Ler um arquivo CSV, colocando suas informações em uma instância de classe
     *
     * @throws FileNotFoundException erro quando o arquivo não for encontrado
     */
    public static void lerArquivoCsv() throws FileNotFoundException {
        System.out.println("# Ler Arquivo CSV");

        FileInputStream entradaDeDados = new FileInputStream(caminho + "arquivo.csv");
        Scanner lerArquivo = new Scanner(entradaDeDados, StandardCharsets.UTF_8);

        List<Pessoa> pessoas = new ArrayList<>();

        while (lerArquivo.hasNext()) {
            String linha = lerArquivo.nextLine();

            /* Não ler linhas em branco */
            if (linha != null && !linha.isEmpty()) {
                System.out.println(linha);

                String[] dados = linha.split(",");

                Pessoa pessoa = new Pessoa(dados[0], dados[1], Integer.parseInt(dados[2]));
                pessoas.add(pessoa);
            }
        }

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.toString());
        }

        lerArquivo.close();
        System.out.println(System.lineSeparator());
    }
}
