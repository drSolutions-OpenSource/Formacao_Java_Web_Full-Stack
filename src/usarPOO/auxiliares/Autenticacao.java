package usarPOO.auxiliares;

import usarPOO.interfaces.PermitirAcesso;

/**
 * Interface criada para viabilizar a autenticação no sistema
 * Receber quem possua o contrato da interface de CredenciaisDeAcesso 100% implantado, e depois, chamar o autenticar()
 *
 * @author Diego Mendes Rodrigues
 */
public class Autenticacao {
    PermitirAcesso permitirAcesso;

    public Autenticacao(PermitirAcesso acesso) {
        this.permitirAcesso = acesso;
    }

    public boolean autenticarPessoa() {
        return permitirAcesso.autenticar();
    }
}
