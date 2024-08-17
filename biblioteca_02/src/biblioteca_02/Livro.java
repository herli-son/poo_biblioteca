package biblioteca_02;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Livro extends Obras implements DAO, Serializable {
	private String editora;
	private String edicao;
	private String numeroDeFolhas;
	private boolean emprestimo;

	public Livro() {
		emprestimo = true;
	}

	public Livro(String titulo, String autores, String area, String editora, String ano, String edicao,
			String numeroDeFolhas) {
		super(titulo, autores, area, ano);
		this.editora = editora;
		this.edicao = edicao;
		this.numeroDeFolhas = numeroDeFolhas;
		emprestimo = true;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getNumeroDeFolhas() {
		return numeroDeFolhas;
	}

	public void setNumeroDeFolhas(String numeroDeFolhas) {
		this.numeroDeFolhas = numeroDeFolhas;
	}

	public void setEmprestimo(boolean emprestimo) {
		this.emprestimo = emprestimo;
	}

	public boolean isEmprestimo() {
		return emprestimo;
	}

	public void abrirLivro() {
		System.out.println("O livro está aberto para leitura");
	}

	public void fecharLivro() {
		System.out.println("O livro está fechado para leitura");
	}
	//Utilizado polimorfismo pela herança
	@Override
	public void utilizar() {
		System.out.println("Lendo livro");

	}

	@Override
	public void gravar() {
		// TODO Auto-generated method stub
		DAO.gravar("Livro" + this.getTitulo(), this);
	}

	@Override
	public void excluir() {
		// TODO Auto-generated method stub
		DAO.excluir("Livro" + this.getTitulo());
	}

	public Livro ler(String chave) {
		// TODO Auto-generated method stub
		return (Livro)DAO.ler("Livro"+chave);
	}

	@Override
	public void atualizar() {
		// TODO Auto-generated method stub
		
	}
}
