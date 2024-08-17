package biblioteca_02;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {

	public static Usuarios UsuarioLogado = null;
	public static Id Id;

	public static void main(String[] args) {

		Id = new Id();
		Id = (Id) Id.ler();

		if (Id == null) {
			Id = new Id();
			Id.gravar();
		}

		while (true) {
			switch (MenuAcesso()) {
			case 1:
				CadastrarUsuarios();
				break;
			case 2:
				if (Acessar())
					MenuAcessado();
				break;
			case 3:

				return;

			default:
				System.out.println("Opção inválida!");
				break;
			}
		}

	}

	public static int MenuAcesso() {

		System.out.println("1 - Cadastrar");
		System.out.println("2 - Acessar");
		System.out.println("3 - Encerrar");

		try {
			return LerOpcao();

		} catch (Exception e) {
			System.out.println("Somente números!");
			return 0;
		}
	}

	public static void MenuAcessado() {
		while (true) {
			System.out.println("1 - Ver dados");
			if (UsuarioLogado.getClass().getSimpleName().equals("Funcionario"))
				System.out.println("2 - Cadastrar obra");
			System.out.println("3 - Criar solicitação");
			System.out.println("4 - Realizar devolução");
			System.out.println("5 - Ver obras disponíveis");
			System.out.println("6 - Ver solicitações feitas");
			if (UsuarioLogado.getClass().getSimpleName().equals("Funcionario"))
				System.out.println("7 - Listar Usuários");
			System.out.println("8 - Sair");

			try {
				switch (LerOpcao()) {
				case 1:
					break;
				case 2:
					if (!UsuarioLogado.getClass().getSimpleName().equals("Funcionario"))
						System.out.println("Não autorizado!");
					else {
						CadastrarObras();
					}
					break;
				case 3:
					CadastrarSolicitacao();
					break;
				case 4:
					if (!UsuarioLogado.getClass().getSimpleName().equals("Funcionario"))
						Devolver(UsuarioLogado);
					else {
						Usuarios usuario = SelecionarUsuario();
						if (usuario != null)
							Devolver(usuario);
					}
					break;
				case 5:
					Obras.Listar();
					break;
				case 6:
					if (!UsuarioLogado.getClass().getSimpleName().equals("Funcionario"))
						Solicitacao.ListarSolicitacoes(UsuarioLogado.getSolicitacoes());
					else
						Solicitacao.ListarSolicitacoes(Solicitacao.Solicitacoes());
						
					break;
				case 7:
					if (!UsuarioLogado.getClass().getSimpleName().equals("Funcionario"))
						System.out.println("Não autorizado!");
					else {
						Usuarios.Listar();
					}
					break;
				case 8:
					return;

				default:
					System.out.println("Opção inválida!");
					break;
				}
			} catch (Exception e) {
				System.out.println("Somente números!" + e.getMessage());
			}
		}
	}

	public static void CadastrarUsuarios() {
		while (true) {
			try {
				System.out.println("1 - Estudante");
				System.out.println("2 - Funcionario");
				System.out.println("3 - Professor");
				System.out.println("4 - Voltar");

				switch (LerOpcao()) {
				case 1:
					CadastrarEstudante(CadastrarUsuario());
					break;
				case 2:
					CadastrarFuncionario(CadastrarUsuario());
					break;
				case 3:
					CadastrarProfessor(CadastrarUsuario());
					break;
				case 4:
					return;
				default:
					System.out.println("Opção inválida!");
					break;
				}
				System.out.println(Id.toString());

			} catch (Exception e) {
				System.out.println("Somente números!");
			}
		}
	}

	private static String[] CadastrarUsuario() {

		String acesso;
		do {
			acesso = LerDado("Acesso");

			if (!Usuarios.Existe(acesso))
				break;
			else
				System.out.println("Acesso já utilizado por outro usuário!");

		} while (true);

		return new String[] { LerDado("Nome"), LerDado("Idade"), LerDado("Sexo"), LerDado("Telefone"), acesso,
				LerDado("Senha") };
	}

	private static void CadastrarEstudante(String[] usuario) {
		String[] dados = { LerDado("Curso"), LerDado("Período") };
		Estudante estudante = new Estudante();
		estudante.setNome(usuario[0]);
		estudante.setIdade(usuario[1]);
		estudante.setSexo(usuario[2]);
		estudante.setTelefone(usuario[3]);
		estudante.setAcesso(usuario[4]);
		estudante.setSenha(usuario[5]);
		estudante.setCurso(dados[0]);
		estudante.setPeriodo(dados[1]);
		estudante.setId(Id.getEstudante());
		Id.setEstudante(Id.getEstudante() + 1);
		Id.atualizar();
		estudante.gravar();
	}

	private static void CadastrarFuncionario(String[] usuario) {
		String[] dados = { LerDado("Função") };
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(usuario[0]);
		funcionario.setIdade(usuario[1]);
		funcionario.setSexo(usuario[2]);
		funcionario.setTelefone(usuario[3]);
		funcionario.setAcesso(usuario[4]);
		funcionario.setSenha(usuario[5]);
		funcionario.setFuncao(dados[0]);
		funcionario.setId(Id.getFuncionario());
		Id.setFuncionario(Id.getFuncionario() + 1);
		Id.atualizar();
		funcionario.gravar();
	}

	private static void CadastrarProfessor(String[] usuario) {
		String[] dados = { LerDado("Escola"), LerDado("Especialidade") };
		Professor professor = new Professor();
		professor.setNome(usuario[0]);
		professor.setIdade(usuario[1]);
		professor.setSexo(usuario[2]);
		professor.setTelefone(usuario[3]);
		professor.setAcesso(usuario[4]);
		professor.setSenha(usuario[5]);
		professor.setEscola(dados[0]);
		professor.setEspecialidade(dados[1]);
		professor.setId(Id.getProfessor());
		Id.setProfessor(Id.getProfessor() + 1);
		Id.atualizar();
		professor.gravar();
	}

	public static void CadastrarObras() {
		while (true) {
			try {
				System.out.println("1 - Áudio");
				System.out.println("2 - Fotografia");
				System.out.println("3 - Livro");
				System.out.println("4 - Voltar");

				switch (LerOpcao()) {
				case 1:
					CadastrarAudio(CadastrarObra());
					break;
				case 2:
					CadastrarFotografia(CadastrarObra());
					break;
				case 3:
					CadastrarLivro(CadastrarObra());
					break;
				case 4:
					return;
				default:
					System.out.println("Opção inválida!");
					break;
				}

			} catch (Exception e) {
				System.out.println("Somente números!");
			}
		}
	}

	private static String[] CadastrarObra() {
		return new String[] { LerDado("Título"), LerDado("Autor"), LerDado("Area"), LerDado("Ano") };
	}

	private static void CadastrarAudio(String[] obra) {
		String[] dados = { LerDado("Duração"), LerDado("Tipo") };
		Audio audio = new Audio();
		audio.setTitulo(obra[0]);
		audio.setAutores(obra[1]);
		audio.setArea(obra[2]);
		audio.setAno(obra[3]);
		audio.setDuracao(dados[0]);
		audio.setTipo(dados[1]);
		audio.setId(Id.getAudio());
		Id.setAudio(Id.getAudio() + 1);
		Id.atualizar();
		audio.gravar();
	}

	private static void CadastrarFotografia(String[] obra) {
		String[] dados = { LerDado("Resolução"), LerDado("Tipo") };
		Fotografia fotografia = new Fotografia();
		fotografia.setTitulo(obra[0]);
		fotografia.setAutores(obra[1]);
		fotografia.setArea(obra[2]);
		fotografia.setAno(obra[3]);
		fotografia.setResolucao(dados[0]);
		fotografia.setTipo(dados[1]);
		fotografia.setId(Id.getFotografia());
		Id.setFotografia(Id.getFotografia() + 1);
		Id.atualizar();
		fotografia.gravar();
	}

	private static void CadastrarLivro(String[] obra) {
		String[] dados = { LerDado("Editora"), LerDado("Edição"), LerDado("Número de folhas") };
		int quantidade = 1;
		Livro livro = new Livro();

		if (JOptionPane.showConfirmDialog(null, "Físico?") == JOptionPane.YES_OPTION) {

			do {

				try {
					quantidade = Integer.parseInt(LerDado("Número de cópias"));
					if (quantidade < 1)
						throw new Exception();

				} catch (Exception e) {
					System.out.println("Quantidade inválida.");
					quantidade = 0;
				}

			} while (quantidade < 1);

			livro.setFisico(true);
		}

		livro.setTitulo(obra[0]);
		livro.setAutores(obra[1]);
		livro.setArea(obra[2]);
		livro.setAno(obra[3]);
		livro.setEditora(dados[0]);
		livro.setEdicao(dados[1]);
		livro.setNumeroDeFolhas(dados[2]);

		for (int i = 0; i < quantidade; i++) {

			livro.setId(Id.getLivro());
			Id.setLivro(Id.getLivro() + 1);
			Id.atualizar();
			livro.gravar();
		}
	}

	private static boolean Acessar() {
		String[] dados = { LerDado("Acesso"), LerDado("Senha") };
		Object usuario = Usuarios.Usuario(dados[0]);

		if (usuario == null) {
			System.out.println("O usuário digitado não existe.");
		} else if (((Usuarios) usuario).getSenha().equals(dados[1])) {
			UsuarioLogado = (Usuarios) usuario;
			return true;
		} else {
			System.out.println("Senha incorreta para esse usuário.");
		}
		return false;
	}

	public static void CadastrarSolicitacao() {

		int i = 0;
		List<Livro> livros = Livro.ListarFisicos();
		for (Livro livro : livros) {
			System.out.println(
					i + " - " + livro.getTitulo() + " | " + (livro.isEmprestimo() ? "Reservável" : "Emprestável"));
			i++;
		}
		System.out.println(i + " - Cancelar");

		while (true) {
			try {

				i = Integer.parseInt(LerDado("Selecione o livro"));

				if (i > livros.size())
					System.out.println("Opção inválida!");
				else if (i == livros.size())
					return;
				else {

					Livro livro = livros.get(i);

					if (livro.isEmprestimo()) {
						if (JOptionPane.showConfirmDialog(null,
								"O livro já está emprestado, deseja reservar?") == JOptionPane.YES_OPTION) {
							Reserva reserva = new Reserva();
							reserva.setObra(livro);
							reserva.setUsuario(UsuarioLogado);
							reserva.setData(LocalDate.now().toString());
							reserva.setHora(LocalTime.now().toString());
							reserva.setId(Id.getReserva());
							livro.getSolicitacoes().add(reserva);
							livro.setEmprestimo(true);
							UsuarioLogado.getSolicitacoes().add(reserva);
							Id.setReserva(Id.getReserva() + 1);
							Id.atualizar();
							UsuarioLogado.atualizar();
							livro.atualizar();
							reserva.gravar();
							return;
						}
					} else {
						EmprestarLivro(livro, UsuarioLogado);
						return;
					}

				}

			} catch (Exception e) {
				System.out.println("Somente números!");
			}
		}
	}

	private static void EmprestarLivro(Livro livro, Usuarios usuario) {
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setObra(livro);
		emprestimo.setUsuario(usuario);
		emprestimo.setData(LocalDate.now().toString());
		emprestimo.setHora(LocalTime.now().toString());
		emprestimo.setId(Id.getEmprestimo());
		livro.getSolicitacoes().add(emprestimo);
		livro.setEmprestimo(true);
		usuario.getSolicitacoes().add(emprestimo);
		Id.setEmprestimo(Id.getEmprestimo() + 1);
		Id.atualizar();
		usuario.atualizar();
		livro.atualizar();
		emprestimo.gravar();
	}

	public static Usuarios SelecionarUsuario() {

		Usuarios.Listar();
		System.out.println("Digite um usuário inexistente para encerrar.");

		Usuarios usuario = (Usuarios) Usuarios.Usuario(LerDado("Usuario de devolução"));

		if (usuario == null)
			System.out.println("Usuário inexistente. O processo será encerrado");

		return usuario;
	}

	public static void Devolver(Usuarios usuario) {
		int i = 0;

		if (usuario.getEmprestimos().size() == 0) {
			System.out.println("Nada para devolver.");
			return;
		}

		for (Emprestimo emprestimo : usuario.getEmprestimos()) {
			System.out.println(i + " - " + emprestimo.getObra().getTitulo());
			i++;
		}

		System.out.println(i + " - Cancelar");

		while (true) {
			try {
				i = Integer.parseInt(LerDado("Selecione o empréstimo"));

				if (i > usuario.getEmprestimos().size())
					System.out.println("Opção inválida!");
				else if (i == usuario.getEmprestimos().size())
					return;
				else {
					Livro livro = new Livro();
					livro = (Livro) livro.ler();
					
					List<Solicitacao> solicitacoes = usuario.getSolicitacoes();
					Emprestimo emprestimo = usuario.getEmprestimos().get(i);
					
					solicitacoes.remove(emprestimo);
					usuario.setSolicitacoes(solicitacoes);
					
					solicitacoes = livro.getSolicitacoes();
					
					solicitacoes.remove(emprestimo);
					livro.setSolicitacoes(solicitacoes);

					usuario.atualizar();
					livro.atualizar();
					emprestimo.excluir();

					if (livro.getProximaReserva() != null) {
						EmprestarLivro((Livro) livro.getProximaReserva().getObra(),
						livro.getProximaReserva().getUsuario());
						Reserva reserva = livro.getProximaReserva();
						reserva.excluir();
						solicitacoes.remove(reserva);
					}

					return;
				}

			} catch (Exception e) {

			}
		}
	}

	public static void Funcionario() {

	}

	private static String LerDado(String mensagem) {
		Scanner In = new Scanner(System.in);
		System.out.println("--------------------");
		System.out.println(mensagem + ": ");
		return In.nextLine();
	}

	private static int LerOpcao() {
		Scanner In = new Scanner(System.in);
		return In.nextInt();

	}
}
