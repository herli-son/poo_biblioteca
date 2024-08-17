package biblioteca_02;

import java.io.*;
public class Professor extends Usuarios implements Serializable {

	public String acesso;
	public Professor() {}
	//Utilizada sobrecarga de construtor
	public Professor(String nome, String idade, String sexo, String telefone, String acesso) {
		super(nome, idade, sexo, telefone);
		this.acesso = acesso;
		// TODO Auto-generated constructor stub
	}
	//Utilizada sobrecarga de construtor
	public Professor(Usuarios usuario, String acesso) {
		super(usuario.getNome(), usuario.getIdade(), usuario.getSexo(), usuario.getTelefone());
		this.acesso = acesso;
		// TODO Auto-generated constructor stub
	}
	//Utilizada sobrecarga de construtor
	public Professor(Usuarios usuario) {
		super(usuario.getNome(), usuario.getIdade(), usuario.getSexo(), usuario.getTelefone());
		// TODO Auto-generated constructor stub
	}

	public String getAcesso() {
		return acesso;
	}

	public void setAcesso(String acesso) {
		this.acesso = acesso;
	}
	@Override
	public void gravar() {
		// TODO Auto-generated method stub
		DAO.gravar("Professor" + this.getAcesso(), this);
	}
	@Override
	public void excluir() {
		// TODO Auto-generated method stub	
		DAO.excluir("Professor" + this.getAcesso());
	}
	public Emprestimo ler(String chave) {
		// TODO Auto-generated method stub
		return (Emprestimo)DAO.ler("Professor" +chave);
	}
	@Override
	public void atualizar() {
		// TODO Auto-generated method stub
		
	}
}
