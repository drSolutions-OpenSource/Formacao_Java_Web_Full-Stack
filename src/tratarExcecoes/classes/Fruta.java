package tratarExcecoes.classes;

import tratarExcecoes.excecoes.ExcecaoProcessarFruta;

/**
 * Classe de Frutas, para tratarmos exceções
 *
 * @author Diego Mendes Rodrigues
 */
public class Fruta {
    String nome;
    boolean madura = false;

    public Fruta() {
    }

    public Fruta(String nome, boolean madura) {
        this.nome = nome;
        this.madura = madura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isMadura() {
        return madura;
    }

    public void setMadura(boolean madura) {
        this.madura = madura;
    }

    @Override
    public String toString() {
        return "Fruta{" +
                "nome='" + nome + '\'' +
                ", madura=" + madura +
                '}';
    }

    /**
     * Método que lança uma exceção customizada
     *
     * @throws ExcecaoProcessarFruta sendo a exceção personalizada
     */
    public void exibirFruta() throws ExcecaoProcessarFruta {
        System.out.println("Fruta: " + this.nome);
        throw new ExcecaoProcessarFruta("Fruta não existe nessa época do ano");
    }
}
