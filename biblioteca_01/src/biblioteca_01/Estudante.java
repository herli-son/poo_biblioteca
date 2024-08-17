package biblioteca_01;

public class Estudante extends Usuarios {

	public String matricula;
	public String curso;
	//Utilizada sobrecarga de construtor
	public Estudante(String nome, String idade, String sexo, String telefone, String matricula, String curso) {
		super(nome, idade, sexo, telefone);
		// TODO Auto-generated constructor stub
		this.matricula = matricula;
		this.curso = curso;
	}
	//Utilizada sobrecarga de construtor
	public Estudante(Usuarios usuario, String matricula, String curso) {
		super(usuario.getNome(), usuario.getIdade(), usuario.getSexo(), usuario.getTelefone());
		this.matricula = matricula;
		this.curso = curso;
	}
	//Utilizada sobrecarga de construtor
	public Estudante(Usuarios usuario) {
		super(usuario.getNome(), usuario.getIdade(), usuario.getSexo(), usuario.getTelefone());
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

}
