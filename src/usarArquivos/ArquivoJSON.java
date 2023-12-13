package usarArquivos;

import com.google.gson.*;
import usarArquivos.classes.Pessoa;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Escrever e ler arquivos JSON no computador, utilizando Gson()
 *
 * @author Diego Mendes Rodrigues
 */
public class ArquivoJSON {
    static String caminho = "C:\\Users\\diego\\IdeaProjects\\CursoJava\\src\\usarArquivos\\";

    public static void main(String[] args) throws IOException {
        escreverJSON();

        escreverJSONBoaLeitura();

        lerJSON();
    }

    /**
     * Escrever o arquivo JSON
     *
     * @throws IOException
     */
    public static void escreverJSON() throws IOException {
        System.out.println("# Escrever o arquivo JSON");
        Pessoa isis = new Pessoa("Isis Nable Valverde", "isis@fake.io", 36);
        Pessoa deborah = new Pessoa("Deborah Fialho Secco", "secco@fake.io", 44);

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(isis);
        pessoas.add(deborah);

        /* Criar o JSON com a lista de pessoas */
        String jsonPessoas = new Gson().toJson(pessoas);

        /* Exibir o JSON */
        System.out.println(jsonPessoas);

        /* Escrever o JSON em um arquivo */
        FileWriter saida = new FileWriter(caminho + "arquivo.json", StandardCharsets.UTF_8);
        saida.write(jsonPessoas);
        saida.flush();
        saida.close();

        System.out.println("Arquivo JSON criado");
        System.out.println(System.lineSeparator());
    }

    /**
     * Escrever um arquivo JSON formatado para uma melhor leitura visual
     *
     * @throws IOException
     */
    public static void escreverJSONBoaLeitura() throws IOException {
        System.out.println("# Escrever o arquivo JSON para uma boa leitura");
        Pessoa isis = new Pessoa("Isis Nable Valverde", "isis@fake.io", 36);
        Pessoa deborah = new Pessoa("Deborah Fialho Secco", "secco@fake.io", 44);

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(isis);
        pessoas.add(deborah);

        /* Criar o JSON com a lista de pessoas */
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonPessoas = gson.toJson(pessoas);

        /* Exibir o JSON */
        System.out.println(jsonPessoas);

        /* Escrever o JSON em um arquivo */
        FileWriter saida = new FileWriter(caminho + "arquivo_boa_leitura.json", StandardCharsets.UTF_8);
        saida.write(jsonPessoas);
        saida.flush();
        saida.close();

        System.out.println("Arquivo JSON para uma boa leitura criado");
        System.out.println(System.lineSeparator());
    }

    /**
     * Ler um arquivo JSON, colocando seus elementos em objetos da classe Pessoa
     */
    public static void lerJSON() throws IOException {
        System.out.println("# Ler o arquivo JSON");

        FileReader arquivoJson = new FileReader(caminho + "arquivo.json", StandardCharsets.UTF_8);
        JsonArray jsonArray = (JsonArray) JsonParser.parseReader(arquivoJson);

        List<Pessoa> pessoas = new ArrayList<>();

        for (JsonElement jsonElement : jsonArray) {
            Pessoa pessoa = new Gson().fromJson(jsonElement, Pessoa.class);
            pessoas.add(pessoa);
        }

        arquivoJson.close();

        System.out.println("Leitura do arquivo JSON:");
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }

        System.out.println(System.lineSeparator());
    }
}
