package usarPOO.classes;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Pessoas do Sistema da Escola (Superclasse)
 * Essa classe é Abstrata, ou seja, não podemos instanciar a classe Pessoa
 * Deixar os atributos com 'protected' para poder utilizá-los nessa classe e nas suas subclasses
 *
 * @author Diego Mendes Rodrigues
 */
public abstract class Pessoa {
    protected String nome;
    protected String cpf;
    protected Date dataNascimento;
    protected int idade;

    /**
     * Construtor padrão.
     * Utilizado na invocação das subclasses.
     */
    public Pessoa() {
    }

    /**
     * Construtor da classe Pessoa.
     *
     * @param nome           sendo o nome da Pessoa
     * @param cpf            sendo o CPF da Pessoa
     * @param dataNascimento sendo a data de nascimento
     * @param idade          sendo a idade
     */
    public Pessoa(String nome, String cpf, Date dataNascimento, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
    }

    /**
     * Método abstrato que precisa ser escrito nas classes filhas, informando o salário de cada Pessoa
     */
    public abstract BigDecimal salario();

    /**
     * Retorna se a pessoa é maior de idade
     *
     * @return retorna true caso seja maior de idade e false, caso contrário
     */
    public boolean maiorDeIdade() {
        return this.idade >= 18;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", idade=" + idade +
                '}';
    }
}
