package usarPOO.classes;

import usarPOO.contantes.CredenciaisDeAcesso;
import usarPOO.interfaces.PermitirAcesso;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Secretários do Sistema da Escola
 *
 * @author Diego Mendes Rodrigues
 */
public class Secretario extends Pessoa implements PermitirAcesso {
    String registro;
    String nivelCargo;
    String experiencia;
    BigDecimal salario;
    String usuario;
    String senha;

    /**
     * Construtor da classe Secretário
     *
     * @param nome           sendo o nome
     * @param cpf            sendo o CPF
     * @param dataNascimento sendo a data de nascimento
     * @param idade          sendo a idade
     * @param registro       sendo o código do registro
     * @param nivelCargo     sendo o nível do cargo
     * @param experiencia    sendo o tempo de experiência
     * @param usuario        sendo o usuário para o login no Sistema
     * @param senha          sendo a senha para o login no Sistema
     */
    public Secretario(String nome, String cpf, Date dataNascimento, int idade, String registro, String nivelCargo,
                      String experiencia, String usuario, String senha) {
        super(nome, cpf, dataNascimento, idade);
        this.registro = registro;
        this.nivelCargo = nivelCargo;
        this.experiencia = experiencia;
        this.salario = BigDecimal.valueOf(6000);
        this.usuario = usuario;
        this.senha = senha;
    }

    /**
     * Retorna o salário do Secretário
     *
     * @return sendo o salário do Secretário
     */
    public BigDecimal salario() {
        this.salario = BigDecimal.valueOf(6000);
        return BigDecimal.valueOf(6000);
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getNivelCargo() {
        return nivelCargo;
    }

    public void setNivelCargo(String nivelCargo) {
        this.nivelCargo = nivelCargo;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Secretario{" + "registro='" + registro + '\'' + ", nivelCargo='" + nivelCargo + '\'' +
                ", experiencia='" + experiencia + '\'' + ", nome='" + nome + '\'' + ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento + ", idade=" + idade +
                ", salario='" + salario + '\'' +
                '}';
    }

    /**
     * Permite a autenticação do Secretário no Sistema da Escola
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
     * Permite a autenticação do Secretário no Sistema da Escola
     *
     * @return true caso o usuário e a senha estejam corretos, false caso contrário
     */
    public boolean autenticar() {
        return (usuario.equalsIgnoreCase(CredenciaisDeAcesso.USUARIOACESSOADMIN) &&
                senha.equalsIgnoreCase(CredenciaisDeAcesso.SENHAACESSOADMIN));
    }
}
