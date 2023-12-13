package usarArquivos;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import usarArquivos.classes.Pessoa;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Ler um arquivo CSV e escrever em uma planilha do Excel com Apache POI
 *
 * @author Diego Mendes Rodrigues
 */
public class ArquivoXLS {
    static String caminho = "C:\\Users\\diego\\IdeaProjects\\CursoJava\\src\\usarArquivos\\";

    public static void main(String[] args) throws IOException {
        escreverArquivoCSV();

        lerArquivoCsvEscreverXls();

        lerArquivoXls();

        adicionarColunaArquivoXls();

        editarCelulaExistenteXls();
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
     * Ler um arquivo CSV, colocando suas informações em um arquivo do Excel
     * CUIDADO: Várias dependências
     *
     * @throws FileNotFoundException erro quando o arquivo não for encontrado
     */
    public static void lerArquivoCsvEscreverXls() throws IOException {
        System.out.println("# Ler o Arquivo CSV");

        FileInputStream entradaDeDados = new FileInputStream(caminho + "arquivo.csv");
        Scanner lerArquivo = new Scanner(entradaDeDados, StandardCharsets.UTF_8);

        List<Pessoa> pessoas = new ArrayList<>();

        while (lerArquivo.hasNext()) {
            String linha = lerArquivo.nextLine();

            /* Não ler linhas em branco */
            if (linha != null && !linha.isEmpty()) {
                String[] dados = linha.split(",");

                Pessoa pessoa = new Pessoa(dados[0], dados[1], Integer.parseInt(dados[2]));
                pessoas.add(pessoa);
            }
        }

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.toString());
        }
        lerArquivo.close();

        /* Escrever o arquivo do Excel XLS */
        System.out.println(System.lineSeparator());
        System.out.println("# Escrever Arquivo XLS");

        File saidaDeDados = new File(caminho + "arquivo.xls");
        if (!saidaDeDados.exists()) {
            saidaDeDados.createNewFile();
        }

        /* Usado para escrever na planilha do Excel */
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet planilhaPessoa = hssfWorkbook.createSheet("Pessoas");

        /* Incluir linhas e colunas na planilha do Excel */
        int numeroLinha = 0;
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getNome());

            Row linha = planilhaPessoa.createRow(numeroLinha++);

            Cell celNome = linha.createCell(0);
            celNome.setCellValue(pessoa.getNome());
            Cell celEmail = linha.createCell(1);
            celEmail.setCellValue(pessoa.getEmail());
            Cell cellIdade = linha.createCell(2);
            cellIdade.setCellValue(pessoa.getIdade());
        }

        /* Escrever o arquivo de saída do Excel */
        FileOutputStream saida = new FileOutputStream(saidaDeDados);
        hssfWorkbook.write(saida);
        saida.flush();
        saida.close();

        System.out.println("=> Planilha do Excel criada");
        System.out.println(System.lineSeparator());
    }

    /**
     * Ler um arquivo do Excel, colocar as informações na classe Pessoa, e depois, exibir na tela
     *
     * @throws IOException erro quando o arquivo não for encontrado
     */
    public static void lerArquivoXls() throws IOException {
        System.out.println("# Ler o Arquivo XLS");

        FileInputStream dados = new FileInputStream(caminho + "arquivo.xls");

        /* Preparar a leitura do arquivo do Excel */
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(dados);

        /* Ler a planilha Pessoas */
        HSSFSheet planilha = hssfWorkbook.getSheet("Pessoas");

        /* Percorrer as linhas da planilha */
        Iterator<Row> linhaIterator = planilha.iterator();

        List<Pessoa> pessoas = new ArrayList<>();

        while (linhaIterator.hasNext()) {
            Row linha = linhaIterator.next();
            Iterator<Cell> celulas = linha.iterator();

            Pessoa pessoa = new Pessoa();
            while (celulas.hasNext()) {
                Cell celula = celulas.next();

                switch (celula.getColumnIndex()) {
                    case 0:
                        pessoa.setNome(celula.getStringCellValue());
                        break;
                    case 1:
                        pessoa.setEmail(celula.getStringCellValue());
                        break;
                    case 2:
                        pessoa.setIdade((int) celula.getNumericCellValue());
                }
            }
            pessoas.add(pessoa);
        }
        System.out.println("=> Planilha do Excel lida");

        /* Fechar o arquivo do Excel */
        dados.close();

        /* Exibir os dados na tela */
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.toString());
        }

        System.out.println(System.lineSeparator());
    }

    /**
     * Adicionar a coluna Salario na planilha do Excel
     *
     * @throws IOException erro quando o arquivo não for encontrado
     */
    public static void adicionarColunaArquivoXls() throws IOException {
        System.out.println("# Adicionar Coluna no Arquivo XLS");

        FileInputStream editarDados = new FileInputStream(caminho + "arquivo.xls");

        /* Preparar a leitura e edição do arquivo do Excel */
        HSSFWorkbook workbook = new HSSFWorkbook(editarDados);

        /* Ler e editar a planilha Pessoas */
        HSSFSheet planilha = workbook.getSheet("Pessoas");

        /* Percorrer as linhas da planilha */
        Iterator<Row> linhaPessoas = planilha.iterator();

        List<Pessoa> pessoas = new ArrayList<>();

        while (linhaPessoas.hasNext()) {
            Row linha = linhaPessoas.next();

            int quantidadeCelulas = linha.getPhysicalNumberOfCells();

            double salario = Math.abs(5000 + new Random().nextDouble() * (10000));
            Cell celula = linha.createCell(quantidadeCelulas);
            celula.setCellValue(salario);
        }

        /* Fechar o arquivo do Excel */
        editarDados.close();

        FileOutputStream saida = new FileOutputStream(new File(caminho + "arquivo.xls"));
        workbook.write(saida);
        saida.flush();
        saida.close();

        System.out.println("=> Planilha do Excel alterada sendo adicionada a coluna salário");
        System.out.println(System.lineSeparator());
    }

    /**
     * Editar uma planilha do Excel, alterando o nome das pessoas
     *
     * @throws IOException erro quando o arquivo não é encontrado
     */
    public static void editarCelulaExistenteXls() throws IOException {
        System.out.println("# Editar o Arquivo XLS");

        FileInputStream editarDados = new FileInputStream(caminho + "arquivo.xls");

        /* Preparar a leitura e edição do arquivo do Excel */
        HSSFWorkbook workbook = new HSSFWorkbook(editarDados);

        /* Ler e editar a planilha Pessoas */
        HSSFSheet planilha = workbook.getSheet("Pessoas");

        /* Percorrer as linhas da planilha */
        Iterator<Row> linhaPessoas = planilha.iterator();

        List<Pessoa> pessoas = new ArrayList<>();

        /* Alterar o nome das pessoas */
        while (linhaPessoas.hasNext()) {
            Row linha = linhaPessoas.next();
            String valorCelula = linha.getCell(0).getStringCellValue() + " Lobato";
            linha.getCell(0).setCellValue(valorCelula);
        }

        /* Fechar o arquivo do Excel */
        editarDados.close();

        FileOutputStream saida = new FileOutputStream(new File(caminho + "arquivo.xls"));
        workbook.write(saida);
        saida.flush();
        saida.close();

        System.out.println("=> Planilha do Excel alterada, onde modificamos o nome das pessoas");
        System.out.println(System.lineSeparator());
    }
}
