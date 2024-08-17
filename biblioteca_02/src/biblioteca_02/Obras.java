package biblioteca_02;

import java.io.Serializable;

public abstract class Obras implements DAO, Serializable {
	private String titulo;
	private String autores;
	private String area;
	private String ano;
	public Obras() {}
	public Obras(String titulo, String autores, String area, String ano) {
		super();
		this.titulo = titulo;
		this.autores = autores;
		this.area = area;
		this.ano = ano;
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

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public abstract void utilizar();
}
