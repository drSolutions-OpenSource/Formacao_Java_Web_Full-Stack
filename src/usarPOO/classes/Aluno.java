package usarPOO.classes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Alunos do Sistema da Escola
 *
 * @author Diego Mendes Rodrigues
 */
public class Aluno extends Pessoa {
    Date dataMatricula;
    String nomeEscola;
    int serieMatriculado;
    List<Disciplina> disciplinas = new ArrayList<>();

    /**
     * Construtor da classe Aluno
     *
     * @param nome             sendo o nome do Aluno
     * @param cpf              sendo o CPF do Aluno
     * @param dataNascimento   sendo a data de nascimento
     * @param idade            sendo a idade
     * @param dataMatricula    sendo a data de matrícula na Escola
     * @param nomeEscola       sendo o nome da Escola
     * @param serieMatriculado sendo a série que o Aluno está matriculado
     * @param disciplinas      sendo uma lista com as disciplinas do Aluno
     */
    public Aluno(String nome, String cpf, Date dataNascimento, int idade, Date dataMatricula, String nomeEscola,
                 int serieMatriculado, List<Disciplina> disciplinas) {
        super(nome, cpf, dataNascimento, idade);
        this.dataMatricula = dataMatricula;
        this.nomeEscola = nomeEscola;
        this.serieMatriculado = serieMatriculado;
        this.disciplinas = disciplinas;
    }

    /**
     * Calcular o salário do Aluno
     *
     * @return o valor zero, pois o Aluno não possui salário
     */
    public BigDecimal salario() {
        return BigDecimal.valueOf(0.0);
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public String getNomeEscola() {
        return nomeEscola;
    }

    public void setNomeEscola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    public int getSerieMatriculado() {
        return serieMatriculado;
    }

    public void setSerieMatriculado(int serieMatriculado) {
        this.serieMatriculado = serieMatriculado;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", idade=" + idade +
                ", dataMatricula=" + dataMatricula +
                ", nomeEscola='" + nomeEscola + '\'' +
                ", serieMatriculado=" + serieMatriculado +
                ", disciplinas=" + disciplinas +
                '}';
    }
}
