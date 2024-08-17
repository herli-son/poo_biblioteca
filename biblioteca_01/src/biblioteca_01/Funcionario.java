package biblioteca_01;

public class Funcionario extends Usuarios {
	
	public String funcao;
	//Utilizada sobrecarga de construtor
	public Funcionario(String nome, String idade, String sexo, String telefone, String funcao) {
		super(nome, idade, sexo, telefone);
		this.funcao = funcao;
		// TODO Auto-generated constructor stub
	}
	//Utilizada sobrecarga de construtor
	public Funcionario(Usuarios usuario, String funcao) {
		super(usuario.getNome(), usuario.getIdade(), usuario.getSexo(), usuario.getTelefone());
		this.funcao = funcao;
		// TODO Auto-generated constructor stub
	}
	//Utilizada sobrecarga de construtor
	public Funcionario(Usuarios usuario) {
		super(usuario.getNome(), usuario.getIdade(), usuario.getSexo(), usuario.getTelefone());
		// TODO Auto-generated constructor stub
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

}
