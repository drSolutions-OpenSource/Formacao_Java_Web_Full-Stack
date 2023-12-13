package tratarExcecoes.classes;

/**
 * Classe de Carros, para tratarmos exceções
 *
 * @author Diego Mendes Rodrigues
 */
public class Carro {
    String modelo;

    public Carro() {
    }

    public Carro(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "modelo='" + modelo + '\'' +
                '}';
    }
}
