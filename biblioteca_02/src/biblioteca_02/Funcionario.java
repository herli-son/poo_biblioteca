package biblioteca_02;

import java.io.Serializable;

public class Funcionario extends Usuarios implements Serializable {
	
	public String funcao;
	public String matricula;
	public Funcionario() {}
	//Utilizada sobrecarga de construtor
	public Funcionario(String nome, String idade, String sexo, String telefone, String funcao) {
		super(nome, idade, sexo, telefone);
		this.funcao = funcao;
		// TODO Auto-generated constructor stub
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	@Override
	public void gravar() {
		// TODO Auto-generated method stub
		DAO.gravar("Funcionario" + this.getMatricula(), this);
		
	}
	@Override
	public void excluir() {
		// TODO Auto-generated method stub
		DAO.excluir("Funcionario" + this.getMatricula());
	}
	public Funcionario ler(String chave) {
		// TODO Auto-generated method stub
		return (Funcionario)DAO.ler("Funcionario" +chave);
	}
	@Override
	public void atualizar() {
		// TODO Auto-generated method stub
		
	}

}
