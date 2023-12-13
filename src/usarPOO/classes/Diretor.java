package usarPOO.classes;

import usarPOO.contantes.CredenciaisDeAcesso;
import usarPOO.interfaces.PermitirAcesso;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Diretores do Sistema da Escola
 *
 * @author Diego Mendes Rodrigues
 */
public class Diretor extends Pessoa implements PermitirAcesso {
    String registroEducacao;
    int tempoDirecao;
    String titulacao;
    BigDecimal salario;
    String usuario;
    String senha;

    /**
     * Construtor da classe Diretor
     *
     * @param nome             sendo o nome do Diretor
     * @param cpf              sendo o CPF do Diretor
     * @param dataNascimento   sendo a data de nascimento
     * @param idade            sendo a idade
     * @param registroEducacao sendo o código de registro na educação
     * @param tempoDirecao     sendo o tempo de direção
     * @param titulacao        sendo a titulação
     * @param usuario          sendo o usuário para o login no Sistema
     * @param senha            sendo a senha para o login no Sistema
     */
    public Diretor(String nome, String cpf, Date dataNascimento, int idade, String registroEducacao, int tempoDirecao,
                   String titulacao, String usuario, String senha) {
        super(nome, cpf, dataNascimento, idade);
        this.registroEducacao = registroEducacao;
        this.tempoDirecao = tempoDirecao;
        this.titulacao = titulacao;
        this.salario = BigDecimal.valueOf(10000);
        this.usuario = usuario;
        this.senha = senha;
    }

    /**
     * Retorna o salário do Diretor
     *
     * @return sendo o salário do Diretor
     */
    public BigDecimal salario() {
        this.salario = BigDecimal.valueOf(10000);
        return BigDecimal.valueOf(10000);
    }

    /**
     * Retorna se o Diretor é maior de idade
     *
     * @return true caso seja maior de idade, e false caso contrário
     */
    @Override
    public boolean maiorDeIdade() {
        if (super.maiorDeIdade()) {
            System.out.println("Diretor é maior de idade");
            return true;
        }
        System.out.println("Diretor é menor de idade");
        return false;
    }

    public String getRegistroEducacao() {
        return registroEducacao;
    }

    public void setRegistroEducacao(String registroEducacao) {
        this.registroEducacao = registroEducacao;
    }

    public int getTempoDirecao() {
        return tempoDirecao;
    }

    public void setTempoDirecao(int tempoDirecao) {
        this.tempoDirecao = tempoDirecao;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    @Override
    public String toString() {
        return "Diretor{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", idade=" + idade +
                ", registroEducacao='" + registroEducacao + '\'' +
                ", tempoDirecao=" + tempoDirecao +
                ", titulacao='" + titulacao + '\'' +
                ", salario='" + salario + '\'' +
                '}';
    }

    /**
     * Permite a autenticação do Diretor no Sistema da Escola
     *
     * @param usuario sendo o usuário do sistema
     * @param senha   sendo a senha no sistema
     * @return true caso o usuário e a senha estejam corretos, false caso contrário
     */
    @Override
    public boolean autenticar(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
        return autenticar();
    }

    /**
     * Permite a autenticação do Diretor no Sistema da Escola
     *
     * @return true caso o usuário e a senha estejam corretos, false caso contrário
     */
    public boolean autenticar() {
        return (usuario.equalsIgnoreCase(CredenciaisDeAcesso.USUARIOACESSOGESTOR) &&
                senha.equalsIgnoreCase(CredenciaisDeAcesso.SENHAACESSOGESTOR));
    }
}
