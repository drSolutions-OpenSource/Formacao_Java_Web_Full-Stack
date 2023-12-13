package usarPOO.classes;

import java.util.Arrays;
import java.util.Objects;

/**
 * Disciplinas cursadas pelos Alunos na Escola
 *
 * @author Diego Mendes Rodrigues
 */
public class Disciplina {
    String nome;
    double[] notas;
    double media;

    /**
     * Construtor da classe Disciplina
     *
     * @param nome  sendo o nome da disciplina
     * @param notas sendo as duas notas das avaliações
     */
    public Disciplina(String nome, double[] notas) {
        this.nome = nome;
        this.notas = notas;
        this.media = calcularMedia();
    }

    /**
     * Calcular a média das notas da disciplina
     *
     * @return o valor da média
     */
    public double calcularMedia() {
        if (notas.length > 0) {
            double somaDasNotas = 0;
            for (double nota : notas) {
                somaDasNotas += nota;
            }
            return somaDasNotas / notas.length;
        } else if (0 == notas.length) {
            return notas[0];
        } else {
            return 0.0;
        }
    }

    /**
     * Retornar se o Aluno está aprovado com a média maior do que 7,0
     *
     * @return true caso esteja aprovado, false caso contrário
     */
    public boolean alunoEstaAprovado() {
        return media >= 7.0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public double getMedia() {
        return media;
    }

    @Override
    public String toString() {
        String saida = "Disciplina{" + "nome='" + nome + '\'';
        for (int posicao = 0; posicao < notas.length; posicao++) {
            saida += ", nota" + posicao + "=" + notas[posicao];
        }
        saida += ", media=" + media +
                '}';
        return saida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return Double.compare(media, that.media) == 0 && Objects.equals(nome, that.nome) && Arrays.equals(notas, that.notas);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(nome, media);
        result = 31 * result + Arrays.hashCode(notas);
        return result;
    }
}
