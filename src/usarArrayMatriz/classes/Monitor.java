package usarArrayMatriz.classes;

import java.util.Objects;

/**
 * Classe de Monitores
 *
 * @author Diego Mendes Rodrigues
 */
public class Monitor {
    String marca;
    float tamanho;

    public Monitor() {
    }

    public Monitor(String marca, float tamanho) {
        this.marca = marca;
        this.tamanho = tamanho;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getTamanho() {
        return tamanho;
    }

    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "marca='" + marca + '\'' +
                ", tamanho=" + tamanho +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monitor monitor = (Monitor) o;
        return tamanho == monitor.tamanho && Objects.equals(marca, monitor.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, tamanho);
    }
}
