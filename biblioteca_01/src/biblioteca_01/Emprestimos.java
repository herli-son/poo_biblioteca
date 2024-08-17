package biblioteca_01;

import java.time.LocalDate;
import java.time.LocalTime;

public class Emprestimos {
	private LocalDate dataDoEmprestimo;
	private LocalTime horaDoEmprestimo;
	private Livros livro;
	private Usuarios usuario;
	public Emprestimos() {}
	public Emprestimos(LocalDate dataDoEmprestimo, LocalTime horaDoEmprestimo, Livros livro, Usuarios usuario) {
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
	public Livros getLivro() {
		return livro;
	}
	public void setLivro(Livros livro) {
		this.livro = livro;
	}
	public Usuarios getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
	public void devolverLivro() {
		livro.setEmpresatimo(true);
		System.out.println("Livro devolvido");
	}
}
