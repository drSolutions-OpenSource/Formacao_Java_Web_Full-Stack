package usarPOO;

import usarPOO.auxiliares.Autenticacao;
import usarPOO.classes.*;
import usarPOO.contantes.CredenciaisDeAcesso;
import usarPOO.contantes.DisciplinasDisponiveis;
import usarPOO.interfaces.PermitirAcesso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Sistema da Escola que demonstra a utilização de Programação Orientada a Objetos
 * -
 * Classes:
 * --------------------
 * + Pessoa: Classe abstrata para a criação de outras classes filhas, como Aluno, Diretor e Secretário (Herança)
 * .         Possui um método abstrato salario() que deve ser implementado nas filhas
 * .         Possui um método maiorDeIdade() que está definido nela, mas pode ser sobre escrito nas filhas
 * + Aluno: Estende a classe Pessoa (Herança)
 * .        Implementa um método abstrato salario()
 * .        Sobrescreve um método toString()
 * + Secretário: Estende a classe Pessoa (Herança)
 * .             Implementa um método abstrato salario()
 * .             Sobrescreve um método toString()
 * + Diretor: Estende a classe Pessoa (Herança)
 * .          Implementa um método abstrato salario()
 * .          Sobrescreve um método toString()
 * + Disciplina: Classe para armazenar as disciplinas cursadas pelos alunos
 * -
 * A utilização da classe abstrata Pessoa em Aluno, Diretor e Secretario é um exemplo de Polimorfismo
 * -
 * Pessoa pessoa = new Aluno();
 * pessoa = secretario;
 * também são exemplos de Polimorfismo.
 * -
 * Método examinar() na classe Sistema também demonstra o Polimorfismo
 * -
 * Interfaces
 * --------------------
 * Implementa um contrato, podendo, por exemplo, definir uma série de métodos que precisam ser implementados.
 * Exemplo: Apenas o Secretário e o Diretor podem acessar o sistema, então criamos a interface PermitirAcesso
 * e devemos implementa ela nas classes Secretario e Diretor.
 * + PermitirAcesso: Interface que permite a autenticação no sistema
 *
 * @author Diego Mendes Rodrigues
 */
public class Sistema {
    public static Aluno aluno;
    //    public static Diretor diretor;
    public static PermitirAcesso diretor;
    //    public static Secretario secretario;
    public static PermitirAcesso secretario;

    public static void main(String[] args) {
        /* Cadastrar o Aluno, Diretor e o Secretário na Escola */
        registrarPessoas();

        /* Exibir o Aluno, Diretor e o Secretário utilizando .toString() */
        exibirPessoas();

        /* Verificar se o Aluno e o Diretor são maiores de idade */
        verificarMaiorDeIdade();

        /* Exibir o salário do Aluno, Diretor e do Secretário */
        exibirSalarioPessoas();

        /* Examinar Pessoas utilizando Polimorfismo */
        examinarPessoas();

        /* Realizar a autenticação do Secretário no sistema usando uma Interface */
        autenticarSecretario();
    }

    /**
     * Cadastrar o Aluno, o Diretor e o Secretário no Sistema
     */
    public static void registrarPessoas() {
        List<Disciplina> alunoDisciplinas = new ArrayList<>();
        alunoDisciplinas.add(new Disciplina(DisciplinasDisponiveis.LOGICADEPROGRAMACAO, new double[]{9.0, 8.0, 7.0}));
        alunoDisciplinas.add(new Disciplina(DisciplinasDisponiveis.ORIENTACAOAOBJETOS, new double[]{7.0, 6.0}));
        alunoDisciplinas.add(new Disciplina(DisciplinasDisponiveis.CONCEITOSDEJAVA, new double[]{8.0, 7.4}));

        aluno = new Aluno("Diego Rodrigues", "220.123.234-44", new Date(1982, Calendar.JULY,
                8), 41, new Date(2023, Calendar.DECEMBER, 25), "JDev Treinamentos",
                1, alunoDisciplinas);

        diretor = new Diretor("Regina Marcia", "147.871.588-88", new Date(1962, Calendar.APRIL,
                22), 61, "7260.2389-93", 25, "Diretor Geral",
                CredenciaisDeAcesso.USUARIOACESSOGESTOR, CredenciaisDeAcesso.SENHAACESSOGESTOR);

        secretario = new Secretario("Julia Neau", "457.871.985-34", new Date(2000,
                Calendar.JULY, 2), 23, "239.2390-92", "Secretário Executivo",
                "5 anos", CredenciaisDeAcesso.USUARIOACESSOADMIN, CredenciaisDeAcesso.SENHAACESSOADMIN);
    }

    /**
     * Exibir o Aluno, Diretor e o Secretário utilizando .toString()
     */
    public static void exibirPessoas() {
        System.out.println(aluno.toString());
        System.out.println(diretor.toString());
        System.out.println(secretario.toString());
        System.out.println(" ");
    }

    /**
     * Verificar se o Aluno e o Diretor são maiores de idade
     */
    public static void verificarMaiorDeIdade() {
        System.out.println("Aluno maior de idade? " + aluno.maiorDeIdade());
        System.out.println(diretor.maiorDeIdade());
        System.out.println(" ");
    }

    /**
     * Exibir o salário do Aluno, Diretor e do Secretário
     */
    public static void exibirSalarioPessoas() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        System.out.println("Salário do Aluno é R$ 0" + df.format(aluno.salario()));
        System.out.println("Salário do Diretor é R$ " + df.format(diretor.salario()));
        System.out.println("Salário do Secretário é R$ " + df.format(secretario.salario()));
        System.out.println(" ");
    }

    /**
     * Escreve na tela uma frase de uma Pessoa e seu salário.
     * Usa o polimorfismo, definindo o parâmetro como Pessoa, e depois, passando Aluno, Diretor ou Secretário.
     *
     * @param pessoa sendo uma Pessoa (Aluno, Secretario ou Diretor)
     */
    public static void examimar(Pessoa pessoa) {
        DecimalFormat df = new DecimalFormat("#,###.00");
        System.out.println("Essa pessoa " + pessoa.getNome() + " é bacana!");
        System.out.println("O salário dela é R$ " + df.format(pessoa.salario()));
    }

    /**
     * Examinar pessoas utilizando Polimorfismo
     */
    public static void examinarPessoas() {
        examimar(aluno);
        System.out.println(" ");
    }

    /**
     * Realizar a autenticação do Secretário e do Diretor no sistema usando uma Interface
     */
    public static void autenticarSecretario() {
        /* Utilizar o método estático da interface */
        PermitirAcesso.exibirMensagem();

        /*
         * O Secretário é um PermitirAcesso, pois foi criado como:
         * PermitirAcesso secretario;
         */
        Autenticacao autenticacaoSecretario = new Autenticacao(secretario);
        Autenticacao autenticacaoDiretor = new Autenticacao(diretor);

        System.out.println("Autenticando o Secretário (" + CredenciaisDeAcesso.USUARIOACESSOADMIN + "/" +
                CredenciaisDeAcesso.SENHAACESSOADMIN + ")? " +
                (autenticacaoSecretario.autenticarPessoa() ? "Sim" : "Não"));

        System.out.println("Autenticando o Diretor (" + CredenciaisDeAcesso.USUARIOACESSOGESTOR + "/" +
                CredenciaisDeAcesso.SENHAACESSOGESTOR + ")? " +
                (autenticacaoDiretor.autenticarPessoa() ? "Sim" : "Não"));
    }
}  
