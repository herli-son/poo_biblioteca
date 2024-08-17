package biblioteca_02;

import java.io.Serializable;
import java.util.List;

public abstract class Obras implements DAO, Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String titulo;
	private String autores;
	private String area;
	private String ano;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public void gravar() {
		// TODO Auto-generated method stub
		DAO.gravar(String.valueOf(getId()), this);
	}

	@Override
	public void excluir() {
		if (podeExcluir())
			DAO.excluir(String.valueOf(getId()), this.getClass().getSimpleName());
		else
			System.out.println(this.getClass().getSimpleName() + " não pode ser excluído.");
	}

	@Override
	public void atualizar() {
		// TODO Auto-generated method stub
		DAO.gravar(String.valueOf(getId()), this);
	}

	@Override
	public Object ler() {
		// TODO Auto-generated method stub
		return DAO.ler(String.valueOf(getId()), this.getClass().getSimpleName());
	}
	
	public boolean podeExcluir() {
		return false;
	}
	public static void Listar() {
		List<Object> lista = DAO.lerTudo("Audio");
		System.out.println("--------------------");
		System.out.println("Audios: ");
		System.out.println("--------------------");
		for (Object object : lista) {
			Audio a = (Audio) object;
			System.out.println(a.toString());
		}
		
		lista = DAO.lerTudo("Fotografia");
		System.out.println("--------------------");
		System.out.println("Fotografias: ");
		System.out.println("--------------------");
		for (Object object : lista) {
			Fotografia f = (Fotografia) object;
			System.out.println(f.toString());
		}
		
		lista = DAO.lerTudo("Livro");
		System.out.println("--------------------");
		System.out.println("Livros: ");
		System.out.println("--------------------");
		for (Object object : lista) {
			Livro l = (Livro) object;
			System.out.println(l.toString());
		}
		System.out.println("--------------------");
	}
	@Override
	public String toString() {
		return "[id=" + id + ", titulo=" + titulo + ", autores=" + autores + ", area=" + area + ", ano=" + ano
				+ "]";
	}
	
}
