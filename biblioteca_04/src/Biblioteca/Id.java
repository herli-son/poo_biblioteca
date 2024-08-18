package Biblioteca;

import java.io.Serializable;

public class Id implements DAO, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int livro;
	private int fotografia;
	private int audio;
	
	private int funcionario;
	private int estudante;
	private int professor;
	
	private int reserva;
	private int emprestimo;
	
	
	
	public int getLivro() {
		return livro;
	}
	public void setLivro(int livro) {
		this.livro = livro;
	}
	public int getFotografia() {
		return fotografia;
	}
	public void setFotografia(int fotografia) {
		this.fotografia = fotografia;
	}
	public int getAudio() {
		return audio;
	}
	public void setAudio(int audio) {
		this.audio = audio;
	}
	public int getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(int funcionario) {
		this.funcionario = funcionario;
	}
	public int getEstudante() {
		return estudante;
	}
	public void setEstudante(int estudante) {
		this.estudante = estudante;
	}
	public int getProfessor() {
		return professor;
	}
	public void setProfessor(int professor) {
		this.professor = professor;
	}
	public int getReserva() {
		return reserva;
	}
	public void setReserva(int reserva) {
		this.reserva = reserva;
	}
	public int getEmprestimo() {
		return emprestimo;
	}
	public void setEmprestimo(int emprestimo) {
		this.emprestimo = emprestimo;
	}
	@Override
	public void gravar() {
		// TODO Auto-generated method stub
		DAO.gravar(this.getClass().getSimpleName(), this);
	}
	@Override
	public void excluir() {
		// TODO Auto-generated method stub
		System.out.println("Registro de ID não excluível");
		
	}
	@Override
	public void atualizar() {
		// TODO Auto-generated method stub
		gravar();
	}
	@Override
	public Object ler() {
		// TODO Auto-generated method stub
		return DAO.ler(this.getClass().getSimpleName(), this.getClass().getSimpleName());
	}
	@Override
	public String toString() {
		return "Id [livro=" + livro + ", fotografia=" + fotografia + ", audio=" + audio + ", funcionario=" + funcionario
				+ ", estudante=" + estudante + ", professor=" + professor + ", reserva=" + reserva + ", emprestimo="
				+ emprestimo + "]";
	}
	
}
