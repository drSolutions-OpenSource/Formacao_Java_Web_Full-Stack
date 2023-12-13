package usarPOO.interfaces;

import java.math.BigDecimal;

/**
 * Interface que permite a autenticação de usuários no Sistema da Escola (Secretário - Admin e o Diretor - Gestor)
 * 'Contrato' de autenticação
 * Outras informações de interfaces:
 * https://www.freecodecamp.org/portuguese/news/interfaces-em-java-explicadas-com-exemplos/
 *
 * @author Diego Mendes Rodrigues
 */
public interface PermitirAcesso {
    /**
     * Exibe uma mensagem na tela
     * Esse é um método estático na Interface, sendo que esse tipo de método DEVE ser implementado dentro da
     * interface e ele NÃO É HERDADO pela classe que implementa a interface!
     */
    public static void exibirMensagem() {
        System.out.println("### Autenticação de Usuário ###");
    }

    public boolean autenticar();

    public boolean autenticar(String usuario, String senha);

    public BigDecimal salario();

    public boolean maiorDeIdade();
}
