package biblioteca_02;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Emprestimo implements DAO, Serializable {
	private LocalDate dataDoEmprestimo;
	private LocalTime horaDoEmprestimo;
	private Livro livro;
	private Usuarios usuario;
	public Emprestimo() {}
	public Emprestimo(LocalDate dataDoEmprestimo, LocalTime horaDoEmprestimo, Livro livro, Usuarios usuario) {
		this.dataDoEmprestimo = dataDoEmprestimo;
		this.horaDoEmprestimo = horaDoEmprestimo;
		this.livro = livro;
		this.usuario = usuario;
	}
	
	public LocalDate getDataDoEmprestimo() {
		return dataDoEmprestimo;
	}
	//A verificação da regra de devolução de emprestimo poderia ser feita verificando o tipo de uauário que emprestou
	//usando a função this.getUsuario().getClass() para verificar o tipo de usuário
	public void setDataDoEmprestimo(LocalDate dataDoEmprestimo) {
		this.dataDoEmprestimo = dataDoEmprestimo;
	}
	public LocalTime getHoraDoEmprestimo() {
		return horaDoEmprestimo;
	}
	public void setHoraDoEmprestimo(LocalTime horaDoEmprestimo) {
		this.horaDoEmprestimo = horaDoEmprestimo;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Usuarios getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
	public void devolverLivro() {
		livro.setEmprestimo(true);
		System.out.println("Livro devolvido");
	}
	@Override
	public void gravar() {
		// TODO Auto-generated method stub
		DAO.gravar("Emprestimo" + this.livro.getTitulo() + this.usuario.getNome(), this);
		
	}
	@Override
	public void excluir() {
		// TODO Auto-generated method stub
		DAO.excluir("Emprestimo" + this.livro.getTitulo() + this.usuario.getNome());
	}
	public Emprestimo ler(String chave) {
		// TODO Auto-generated method stub
		return (Emprestimo) DAO.ler("Emprestimo"+chave);
	}
	@Override
	public void atualizar() {
		// TODO Auto-generated method stub
		
	}
}
