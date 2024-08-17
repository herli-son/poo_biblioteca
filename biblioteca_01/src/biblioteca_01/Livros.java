package biblioteca_01;

public class Livros extends Obras {
	private String titulo;
	private String autores;
	private String area;
	private String editora;
	private String ano;
	private String edicao;
	private String numeroDeFolhas;
	private boolean emprestimo;

	public Livros() {
	}

	public Livros(String titulo, String autores, String area, String editora, String ano, String edicao,
			String numeroDeFolhas) {
		super();
		this.titulo = titulo;
		this.autores = autores;
		this.area = area;
		this.editora = editora;
		this.ano = ano;
		this.edicao = edicao;
		this.numeroDeFolhas = numeroDeFolhas;
		emprestimo = false;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
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

	public void setEmpresatimo(boolean emprestimo) {
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
}
