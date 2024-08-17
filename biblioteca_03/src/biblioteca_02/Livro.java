package biblioteca_02;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Livro extends Obras implements DAO, Serializable {

	private static final long serialVersionUID = 1L;
	private String editora;
	private String edicao;
	private String numeroDeFolhas;
	private boolean emprestimo;
	private boolean fisico;
	private List<Solicitacao> solicitacoes;

	public Livro() {
		emprestimo = false;
		solicitacoes = new ArrayList<Solicitacao>();
	}
	public List<Emprestimo> getEmprestimos() {
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		for (Solicitacao solicitacao : getSolicitacoes()) {
			if (solicitacao.getClass().getSimpleName().equals("Emprestimo"))
				emprestimos.add(new Emprestimo(solicitacao));
		}
		return emprestimos;
	}
	public Reserva getProximaReserva() {
		for (Solicitacao solicitacao : getSolicitacoes()) {
			if (solicitacao.getClass().getSimpleName().equals("Reserva"))
				return new Reserva(solicitacao);
		}
		return null;
	}
	public Emprestimo getEmprestimo(int id) {

		for (Emprestimo emprestimo : getEmprestimos()) {
			if (emprestimo.getId() == id)
				return emprestimo;
		}
		return null;
	}
	public boolean isFisico() {
		return fisico;
	}

	public List<Solicitacao> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<Solicitacao> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}

	public void setFisico(boolean fisico) {
		this.fisico = fisico;
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

	public static List<Livro> ListarFisicos() {
		List<Livro> livros = new ArrayList<Livro>();
		List<Object> o = DAO.lerTudo("Livro");

		if (o == null)
			return livros;

		for (Object object : o) {
			Livro livro = (Livro) object;
			if (livro.isFisico())
				livros.add(livro);
		}
		return livros;
	}

	@Override
	public void utilizar() {
		System.out.println("Lendo livro.");
	}

	@Override
	public String toString() {
		return super.toString() + "[editora=" + editora + ", edicao=" + edicao + ", numeroDeFolhas=" + numeroDeFolhas
				+ ", emprestimo=" + emprestimo + ", fisico=" + fisico + "]";
	}

}
