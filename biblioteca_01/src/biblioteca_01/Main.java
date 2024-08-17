package biblioteca_01;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static Scanner In = new Scanner(System.in);
	static List<Livros> livros = new ArrayList<Livros>();
	static List<Usuarios> usuarios = new ArrayList<Usuarios>();
	static List<Emprestimos> emprestimos = new ArrayList<Emprestimos>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuarios user = new Usuarios("Usuario", "32", "Masculino", "64952357854");
		Livros livro = new Livros("O teste", "Herlison", "Tecnologia", "IFGoiano", "2024", "1", "30");

		Emprestimos emprestimo = new Emprestimos(LocalDate.now(), LocalTime.now(), livro, user);

		System.out.println("-----EMPRESTIMO-----");
		System.out.println("Livro: " + livro.getTitulo());
		System.out.println("Usuário: " + user.getNome());
		System.out.println("Data: " + emprestimo.getDataDoEmprestimo());
		emprestimo.getLivro().abrirLivro();
		emprestimo.getUsuario().lerLivro();
		emprestimo.getLivro().fecharLivro();
		emprestimo.devolverLivro();

		sistema();
		In.close();

	}

	public static void sistema() {

		int op;

		while (true) {

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
		}
	}

	public static void menu() {
		System.out.println("1 Cadastrar livro");
		System.out.println("2 Cadastrar usuário");
		System.out.println("3 Realizar emprestimo");
		System.out.println("4 Realizar devolucao");
		System.out.println("5 listar emprestimos");
		System.out.println("6 encerrar");
	}

	public static void cadastrarLivro() {
		try {
			Livros livro = new Livros();
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
			livros.add(livro);
		} catch (Exception e) {
			System.out.println("Erro no cadastro");
			return;
		}
	}

	public static void cadastrarUsuario() {
		try {

			Usuarios usuario = new Usuarios();
			System.out.println("Nome: ");
			usuario.setNome(In.nextLine());
			System.out.println("Idade: ");
			usuario.setIdade(In.nextLine());
			System.out.println("Sexo : ");
			usuario.setSexo(In.nextLine());
			System.out.println("Telefone : ");
			usuario.setTelefone(In.nextLine());

			System.out.println("1 Funcionario");
			System.out.println("2 Estudante");
			System.out.println("3 Professor");

			int op = In.nextInt();
			In.nextLine();

			switch (op) {
			case 1: {
				Funcionario funcionario = new Funcionario(usuario);
				System.out.println("Funcao : ");
				funcionario.setFuncao(In.nextLine());
				usuarios.add(funcionario);
				break;
			}
			case 2: {
				Estudante estudante = new Estudante(usuario);
				System.out.println("Matricula : ");
				estudante.setMatricula(In.nextLine());
				System.out.println("Curso : ");
				estudante.setCurso(In.nextLine());
				usuarios.add(estudante);
				break;
			}
			case 3: {
				Professor professor = new Professor(usuario);
				System.out.println("Acesso : ");
				professor.setAcesso(In.nextLine());
				usuarios.add(professor);
				break;
			}
			default:
				throw new IllegalArgumentException("Valor não esperado: " + In.nextInt());
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro no cadastro");
			return;
		}
	}

	public static void emprestar() {

		try {

			Emprestimos emprestimo = new Emprestimos();

			if (usuarios.size() == 0) {
				System.out.println("Sem uauários pra emprestar");
				return;
			}

			for (int i = 0; i < usuarios.size(); i++) {
				System.out.println(i + " - " + usuarios.get(i).getNome());
				System.out.println(usuarios.get(i).getClass());
			}
			System.out.println("Escolha o Usuario para emprestar: ");
			emprestimo.setUsuario(usuarios.get(In.nextInt()));

			if (livros.size() == 0) {
				System.out.println("Sem livros pra emprestar");
				return;
			}

			for (int i = 0; i < livros.size(); i++) {
				System.out.println(i + " - " + livros.get(i).getTitulo());
			}
			System.out.println("Escolha o livro para emprestar: ");
			emprestimo.setLivro(livros.get(In.nextInt()));

			emprestimo.setDataDoEmprestimo(LocalDate.now());
			emprestimo.setHoraDoEmprestimo(LocalTime.now());
			emprestimos.add(emprestimo);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro no emprestimo");
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
			Emprestimos emprestimo = emprestimos.get(In.nextInt());
			emprestimo.devolverLivro();
			emprestimos.remove(emprestimo);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro na devolução");
			return;
		}
	}

	public static void listar() {
		for (int i = 0; i < emprestimos.size(); i++) {
			System.out.println(i + " | " + emprestimos.get(i).getLivro().getTitulo() + " - "
					+ emprestimos.get(i).getUsuario().getNome());
		}

	}
}
