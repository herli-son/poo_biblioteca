package Biblioteca;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Solicitacao implements DAO, Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private Obras obra;
	private Usuarios usuario;
	private String data;
	private String hora;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Obras getObra() {
		return obra;
	}

	public void setObra(Obras obra) {
		this.obra = obra;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Override
	public void gravar() {
		// TODO Auto-generated method stub
		DAO.gravar(String.valueOf(this.getId()), this);
	}

	@Override
	public void excluir() {
		DAO.excluir(String.valueOf(this.getId()), this.getClass().getSimpleName());
	}

	@Override
	public void atualizar() {
		// TODO Auto-generated method stub
		DAO.gravar(String.valueOf(this.getId()), this);
	}

	@Override
	public Object ler() {
		// TODO Auto-generated method stub
		return DAO.ler(String.valueOf(this.getId()), this.getClass().getSimpleName());
	}
	public static List<Solicitacao> Solicitacoes(){
		List<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
		
		for (Object object : DAO.lerTudo("Emprestimo")) {
			solicitacoes.add((Emprestimo)object);
		}
		
		for (Object object : DAO.lerTudo("Reserva")) {
			solicitacoes.add((Reserva)object);
		}
		
		return solicitacoes;
	}
	public static void ListarSolicitacoes(List<Solicitacao> solicitacoes) {
		for (Solicitacao solicitacao : solicitacoes) {
			System.out.println(solicitacao.getClass().getSimpleName() + " | " + solicitacao.getObra().getTitulo()
					+ " - " + solicitacao.getUsuario().getAcesso());
		}
	}
}
