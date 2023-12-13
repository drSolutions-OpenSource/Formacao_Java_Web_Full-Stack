package usarString;

import java.nio.CharBuffer;
import java.util.Arrays;

/**
 * Usar Strings no Java, com String, StringBuilder, StringBuffer e CharBuffer no Java
 * -
 * O objeto criado com a classe String é imutável no Java.
 * -
 * StringBuilder é uma versão não-sincronizada da classe StringBuffer, ou seja, ela não possibilita a exclusividade
 * do acesso ao seu conteúdo pelas threads.
 * Já a classe StringBuffer é uma versão sincronizada, então, ela garante que somente uma instância terá acesso
 * ao objeto por vez.
 * -
 * O CharBuffer é uma classe abstrata do pacote java.nio, sendo utilizada como um buffer para caracteres.
 * Um buffer, nesse caso, pode ser definido como um espaço temporário de armazenamento, durante a transferência
 * de dados e do processamento de sua aplicação.
 * O objeto CharBuffer é criado usando o método allocate(), passando a capacidade do CharBuffer para que o
 * método possa alocar os caracteres.
 *
 * @author Diego Mendes Rodrigues
 */
public class Sistema {
    public static void main(String[] args) {
        usarClasseString();

        converterValoresParaString();

        converterStringParaTiposPrimitivos();

        String[] parametro = {"Diego Mendes", "Bruna", "Regina Marcia"};
        receberNomesComoParametros(parametro);

        String[] parametro2 = {};
        receberNomesComoParametros(parametro2);

        usarStringBuilder();
        usarStringBuffer();

        usarCharBuffer();
    }

    /**
     * Usar os principais métodos da classe String
     * Os objetos da classe String são imutáveis
     */
    public static void usarClasseString() {
        System.out.println("Métodos da Classe String\n--------------------------------");

        String nome = "Diego";
        nome += " Mendes";
        String nomeCompleto = nome.concat(" Rodrigues");

        System.out.println(nome);
        System.out.println(nomeCompleto);
        System.out.println(" ");

        System.out.println(nomeCompleto.contains("Mendes"));
        System.out.println(nomeCompleto.contains("mendes"));
        System.out.println(" ");

        System.out.println(nome.length());
        System.out.println(nomeCompleto.length());
        System.out.println(" ");

        String novoNome = nomeCompleto.replace("Rodrigues", "Lobato");
        System.out.println(novoNome);
        System.out.println(" ");

        novoNome = "Diego Mendes Lobato Rodrigues Mendes Neau";
        System.out.println(novoNome);
        novoNome = novoNome.replaceAll("Mendes", "Dior");
        System.out.println(novoNome);
        System.out.println(" ");

        novoNome = novoNome.replaceFirst("Dior", "Braga");
        System.out.println(novoNome);
        System.out.println(" ");

        System.out.println(novoNome.isEmpty());
        System.out.println(" ");

        System.out.println(novoNome.indexOf("Lobato"));
        System.out.println(novoNome.indexOf("Rodrigues"));
        System.out.println(" ");

        String[] palavras = nomeCompleto.split(" ");
        for (String palavra : palavras) {
            System.out.println(palavra);
        }
        System.out.println(" ");

        String parte = nomeCompleto.substring(3, 10);
        System.out.println(parte);
        System.out.println(" ");

        String novoNomeCompleto = "  " + nomeCompleto + "   ";
        System.out.println("|" + novoNomeCompleto + "|");
        novoNomeCompleto = novoNomeCompleto.trim();
        System.out.println("|" + novoNomeCompleto + "|");
        System.out.println(" ");

        System.out.println(nomeCompleto.toLowerCase());
        System.out.println(nomeCompleto.toUpperCase());
        System.out.println(" ");

        System.out.println(nomeCompleto.compareToIgnoreCase("Diego MENDES rodrigues"));
        System.out.println(nomeCompleto.compareToIgnoreCase("Diego Lobato"));
        System.out.println(" ");

        System.out.println(nomeCompleto.endsWith("Rodrigues"));
        System.out.println(nomeCompleto.endsWith("rodrigues"));
        System.out.println(nomeCompleto.startsWith("Diego"));
        System.out.println(nomeCompleto.startsWith("diego"));
        System.out.println(" ");

        System.out.println(nomeCompleto.hashCode());
        System.out.println(" ");
    }

    /**
     * Conversão de valores int, long, float, double, boolean e char para String
     */
    public static void converterValoresParaString() {
        System.out.println("Conversões para uma String\n--------------------------------");

        String convertido;
        int inteiro = 10;
        long longo = 20L;
        float flutuante = 19.9F;
        double duplo = 76.4;
        boolean ativo = false;
        char sexo = 'M';

        convertido = String.valueOf(inteiro);
        System.out.println(convertido);

        convertido = String.valueOf(longo);
        System.out.println(convertido);

        convertido = String.valueOf(flutuante);
        System.out.println(convertido);

        convertido = String.valueOf(duplo);
        System.out.println(convertido);

        convertido = String.valueOf(ativo);
        System.out.println(convertido);

        convertido = String.valueOf(sexo);
        System.out.println(convertido);
        System.out.println(" ");
    }

    /**
     * Conversão de uma string para os tipos primitivos, como int, long, float, double, byte, Boolean e char
     */
    public static void converterStringParaTiposPrimitivos() {
        System.out.println("Conversões de uma String para os tipos primitivos\n--------------------------------");

        String valor = "15";
        System.out.println(valor);
        System.out.println(" ");

        int inteiro = Integer.parseInt(valor);
        System.out.println(inteiro);

        long longo = Long.parseLong(valor);
        System.out.println(longo);

        float flutuante = Float.parseFloat(valor);
        System.out.println(flutuante);

        double duplo = Double.parseDouble(valor);
        System.out.println(duplo);

        byte bt = Byte.parseByte(valor);
        System.out.println(bt);

        boolean ativo = Boolean.parseBoolean("true");
        System.out.println(ativo);

        String texto = "Lorem Ipsum";
        System.out.println(texto);
        char caracter = texto.charAt(2);
        System.out.println(caracter);
        caracter = texto.charAt(8);
        System.out.println(caracter);
        System.out.println(" ");
    }

    /**
     * Receber diversas strings como parâmetros
     *
     * @param args sendo nomes de pessoas
     */
    public static void receberNomesComoParametros(String[] args) {
        System.out.println("Receber diversas Strings em um único parâmetro de um método\n--------------------------------");
        if (args.length > 0) {
            for (String nome : args) {
                System.out.println(nome);
            }
        } else {
            System.out.println("Nenhum nome foi passado como parâmetro.");
        }
        System.out.println(" ");
    }

    /**
     * StringBuilder é uma versão não-sincronizada da classe StringBuffer, ou seja, ela não
     * possibilita a exclusividade do acesso ao seu conteúdo pelas threads. Já a classe StringBuffer é
     * uma versão sincronizada, então, ela garante que somente uma instância terá acesso ao objeto por vez.
     */
    public static void usarStringBuilder() {
        System.out.println("StringBuilder\n--------------------------------");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bruna");
        stringBuilder.append(" Mendes ");
        stringBuilder.append(35);
        stringBuilder.append(false);
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.reverse());
        System.out.println(" ");
    }

    /**
     * StringBuilder é uma versão não-sincronizada da classe StringBuffer, ou seja, ela não
     * possibilita a exclusividade do acesso ao seu conteúdo pelas threads. Já a classe StringBuffer é
     * uma versão sincronizada, então, ela garante que somente uma instância terá acesso ao objeto por vez.
     */
    public static void usarStringBuffer() {
        System.out.println("StringBuffer\n--------------------------------");
        StringBuffer stringBuffer = new StringBuffer("Regina Marcia");
        stringBuffer.append(" Ruiz ");
        stringBuffer.append(false);
        System.out.println(stringBuffer);

        stringBuffer.insert(3, "!!!");
        System.out.println(stringBuffer);

        stringBuffer.delete(11, 13);
        System.out.println(stringBuffer);

        System.out.println(" ");
    }

    /**
     * O CharBuffer é uma classe abstrata do pacote java.nio, sendo utilizada como um buffer para caracteres.
     * Um buffer, nesse caso, pode ser definido como um espaço temporário de armazenamento, durante a transferência
     * de dados e do processamento de sua aplicação.
     * O objeto CharBuffer é criado usando o método allocate(), passando a capacidade do CharBuffer para que o
     * método possa alocar os caracteres.
     */
    public static void usarCharBuffer() {
        System.out.println("CharBuffer\n--------------------------------");

        char capacidade = 10;
        CharBuffer caracteresTransferencia = CharBuffer.allocate(capacidade);
        caracteresTransferencia.put('R');
        caracteresTransferencia.put('d');
        caracteresTransferencia.put('B');
        caracteresTransferencia.put('!');
        System.out.println("CharBuffer: " + Arrays.toString(caracteresTransferencia.array()));

        System.out.println(" ");
    }
}
