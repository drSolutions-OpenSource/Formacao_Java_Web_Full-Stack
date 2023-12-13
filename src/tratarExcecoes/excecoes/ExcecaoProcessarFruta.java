package tratarExcecoes.excecoes;

/**
 * Exceção customizada
 * Para criar uma exceção, a classe precisa extender a classe Exception
 *
 * @author Diego Mendes Rodrigues
 */
public class ExcecaoProcessarFruta extends Exception {
    public ExcecaoProcessarFruta(String erro) {
        super(erro);
    }
}
