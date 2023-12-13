package usarArquivos.classes;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe de Pessoas utilizada para os arquivos
 *
 * @author Diego Mendes Rodrigues
 */
public class Pessoa implements Serializable {
    String nome;
    String email;
    int idade;

    public Pessoa() {
    }

    public Pessoa(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String toCSV() {
        return nome + ',' + email + ',' + idade + System.lineSeparator();
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", idade=" + idade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return idade == pessoa.idade && Objects.equals(nome, pessoa.nome) && Objects.equals(email, pessoa.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email, idade);
    }
}
