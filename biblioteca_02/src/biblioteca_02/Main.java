package biblioteca_02;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static Scanner In = new Scanner(System.in);
	static List<Livro> livros = new ArrayList<Livro>();
	static List<Usuarios> usuarios = new ArrayList<Usuarios>();
	static List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (Object o : DAO.lerTudo()) {

			switch (o.getClass().getSimpleName()) {
			case "Livro":
				livros.add((Livro) o);
				break;
			case "Estudante":
			case "Professor":
			case "Funcionario":
				usuarios.add((Usuarios) o);
				break;
			case "Emprestimo":
				emprestimos.add((Emprestimo) o);
				break;
			}
		}
		sistema();
		In.close();

	}

	public static void sistema() {

		int op;

		while (true) {
			try {
				menu();

				System.out.println("Escolha a opção: ");
				op = In.nextInt();
				In.nextLine();
				switch (op) {
				case 1:
					cadastrarLivro();
					break;
				case 2:
					cadastrarUsuario();
					break;
				case 3:
					emprestar();
					break;
				case 4:
					devolver();
					break;
				case 5:
					listar();
					break;
				case 6:
					return;
				default:
					System.out.println("Inválido");
					break;
				}

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Inválido");
				In.nextLine();
			}
		}
	}

	public static void menu() {
		System.out.println("1 Cadastrar livro");
		System.out.println("2 Cadastrar usuário");
		System.out.println("3 Realizar emprestimo");
		System.out.println("4 Realizar devolucao");
		System.out.println("5 Listar emprestimos");
		System.out.println("6 Encerrar");
	}

	public static void cadastrarLivro() {
		try {
			Livro livro = new Livro();
			System.out.println("Título: ");
			livro.setTitulo(In.nextLine());
			System.out.println("Autor: ");
			livro.setAutores(In.nextLine());
			System.out.println("Área: ");
			livro.setArea(In.nextLine());
			System.out.println("Editora: ");
			livro.setEditora(In.nextLine());
			System.out.println("Ano: ");
			livro.setAno(In.nextLine());
			System.out.println("Edição: ");
			livro.setEdicao(In.nextLine());
			System.out.println("Número de páginas: ");
			livro.setNumeroDeFolhas(In.nextLine());
			livro.gravar();
			livros.add(livro);
		} catch (Exception e) {
			System.out.println("Erro no cadastro");
			return;
		}
	}

	public static void cadastrarUsuario() {
		try {

			System.out.println("Nome: ");
			String nome = In.nextLine();
			System.out.println("Idade: ");
			String idade = In.nextLine();
			System.out.println("Sexo : ");
			String sexo = In.nextLine();
			System.out.println("Telefone : ");
			String telefone = In.nextLine();

			System.out.println("1 Funcionario");
			System.out.println("2 Estudante");
			System.out.println("3 Professor");

			int op = In.nextInt();
			In.nextLine();

			switch (op) {
			case 1: {
				Funcionario funcionario = new Funcionario();
				System.out.println("Funcao : ");
				funcionario.setFuncao(In.nextLine());
				System.out.println("Matricula : ");
				funcionario.setMatricula(In.nextLine());
				funcionario.setNome(nome);
				funcionario.setIdade(idade);
				funcionario.setSexo(sexo);
				funcionario.setTelefone(telefone);
				usuarios.add(funcionario);
				funcionario.gravar();
				break;
			}
			case 2: {
				Estudante estudante = new Estudante();
				System.out.println("Matricula : ");
				estudante.setMatricula(In.nextLine());
				System.out.println("Curso : ");
				estudante.setCurso(In.nextLine());
				estudante.setNome(nome);
				estudante.setIdade(idade);
				estudante.setSexo(sexo);
				estudante.setTelefone(telefone);
				usuarios.add(estudante);
				estudante.gravar();
				break;
			}
			case 3: {
				Professor professor = new Professor();
				System.out.println("Acesso : ");
				professor.setAcesso(In.nextLine());
				professor.setNome(nome);
				professor.setIdade(idade);
				professor.setSexo(sexo);
				professor.setTelefone(telefone);
				usuarios.add(professor);
				professor.gravar();
				break;
			}
			default:
				System.out.println("Tipo de usuário inexistente");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro no cadastro");
			In.nextLine();
			return;
		}
	}

	public static void emprestar() {

		try {

			Emprestimo emprestimo = new Emprestimo();

			if (usuarios.size() == 0) {
				System.out.println("Sem uauários pra emprestar");
				return;
			}

			for (int i = 0; i < usuarios.size(); i++) {
				System.out.println(i + " - " + usuarios.get(i).getNome());
			}
			System.out.println("Escolha o Usuario para emprestar: ");
			emprestimo.setUsuario(usuarios.get(In.nextInt()));

			if (livros.size() == 0) {
				System.out.println("Sem livros pra emprestar");
				return;
			}

			boolean exibiu = false;

			for (int i = 0; i < livros.size(); i++) {
				if (livros.get(i).isEmprestimo()) {
					System.out.println(i + " - " + livros.get(i).getTitulo());
					exibiu = true;
				}
			}

			if (!exibiu) {
				System.out.println("Sem livros pra emprestar");
				return;
			}

			System.out.println("Escolha o livro para emprestar: ");
			emprestimo.setLivro(livros.get(In.nextInt()));

			emprestimo.setDataDoEmprestimo(LocalDate.now());
			emprestimo.setHoraDoEmprestimo(LocalTime.now());

			emprestimo.getLivro().setEmprestimo(false);

			emprestimos.add(emprestimo);

			emprestimo.getLivro().gravar();
			emprestimo.gravar();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro no emprestimo");
			In.nextLine();
			return;
		}

	}

	public static void devolver() {
		try {

			if (emprestimos.size() == 0) {
				System.out.println("Sem emprestimos pra devolver");
				return;
			}
			listar();
			System.out.println("Escolha o emprestimo para devolver: ");
			Emprestimo emprestimo = emprestimos.get(In.nextInt());
			emprestimo.devolverLivro();
			for (Livro livro : livros) {
				if(livro.getTitulo().equals(emprestimo.getLivro().getTitulo())) {
					livro.setEmprestimo(true);
					livro.gravar();
					break;
				}
			}
			emprestimo.excluir();
			emprestimos.remove(emprestimo);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro na devolução");
			In.nextLine();
			return;
		}
	}

	public static void listar() {
		System.out.println("--------------------");
		for (int i = 0; i < emprestimos.size(); i++) {
			System.out.println(i + " | " + emprestimos.get(i).getLivro().getTitulo() + " - "
					+ emprestimos.get(i).getUsuario().getNome());
		}
		System.out.println("--------------------");
	}
}
