package biblioteca_02;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Usuarios implements DAO, Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String acesso;
	private String senha;
	private String nome;
	private String idade;
	private String sexo;
	private String telefone;
	private List<Solicitacao> solicitacoes;

	public Usuarios() {
		// TODO Auto-generated constructor stub
		solicitacoes = new ArrayList<Solicitacao>();
	}

	public int getId() {
		return id;
	}

	public List<Solicitacao> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<Solicitacao> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}

	public List<Emprestimo> getEmprestimos() {
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		for (Solicitacao solicitacao : getSolicitacoes()) {
			if (solicitacao.getClass().getSimpleName().equals("Emprestimo"))
				emprestimos.add(new Emprestimo(solicitacao));
		}
		return emprestimos;
	}
	public Emprestimo getEmprestimo(int id) {

		for (Emprestimo emprestimo : getEmprestimos()) {
			if (emprestimo.getId() == id)
				return emprestimo;
		}
		return null;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public String getAcesso() {
		return acesso;
	}

	public void setAcesso(String acesso) {
		this.acesso = acesso;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public void gravar() {
		// TODO Auto-generated method stub
		DAO.gravar(this.getAcesso(), this);
	}

	@Override
	public void excluir() {
		if (podeExcluir())
			DAO.excluir(this.getAcesso(), this.getClass().getSimpleName());
		else
			System.out.println("Usuário com empréstimos pendentes.");
	}

	@Override
	public void atualizar() {
		// TODO Auto-generated method stub
		DAO.gravar(this.getAcesso(), this);
	}

	@Override
	public Object ler() {
		// TODO Auto-generated method stub
		return DAO.ler(this.getAcesso(), this.getClass().getSimpleName());
	}

	public static Object Usuario(String acesso) {
		Object usuario = DAO.ler(acesso, "Estudante");
		if (usuario == null)
			usuario = DAO.ler(acesso, "Funcionario");
		if (usuario == null)
			usuario = DAO.ler(acesso, "Professor");
		return usuario;
	}

	public static boolean Existe(String acesso) {
		Object usuario = DAO.ler(acesso, "Estudante");
		if (usuario == null)
			usuario = DAO.ler(acesso, "Funcionario");
		if (usuario == null)
			usuario = DAO.ler(acesso, "Professor");
		return usuario != null;
	}

	public static void Listar() {
		List<Object> lista = DAO.lerTudo("Estudante");
		System.out.println("--------------------");
		System.out.println("Estudantes: ");
		System.out.println("--------------------");
		for (Object object : lista) {
			Estudante e = (Estudante) object;
			System.out.println(e.toString());
		}

		lista = DAO.lerTudo("Funcionario");
		System.out.println("--------------------");
		System.out.println("Funcionários: ");
		System.out.println("--------------------");
		for (Object object : lista) {
			Funcionario f = (Funcionario) object;
			System.out.println(f.toString());
		}

		lista = DAO.lerTudo("Professor");
		System.out.println("--------------------");
		System.out.println("Professores: ");
		System.out.println("--------------------");
		for (Object object : lista) {
			Professor p = (Professor) object;
			System.out.println(p.toString());
		}
		System.out.println("--------------------");
	}

	public boolean podeExcluir() {
		return false;
	}

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", acesso=" + acesso + ", nome=" + nome + ", idade=" + idade + ", sexo=" + sexo
				+ ", telefone=" + telefone + "]";
	}

}
