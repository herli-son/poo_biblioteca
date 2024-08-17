package biblioteca_01;

public class Professor extends Usuarios {

	public String acesso;
	//Utilizada sobrecarga de construtor
	public Professor(String nome, String idade, String sexo, String telefone, String acesso) {
		super(nome, idade, sexo, telefone);
		this.acesso = acesso;
		// TODO Auto-generated constructor stub
	}
	//Utilizada sobrecarga de construtor
	public Professor(Usuarios usuario, String acesso) {
		super(usuario.getNome(), usuario.getIdade(), usuario.getSexo(), usuario.getTelefone());
		this.acesso = acesso;
		// TODO Auto-generated constructor stub
	}
	//Utilizada sobrecarga de construtor
	public Professor(Usuarios usuario) {
		super(usuario.getNome(), usuario.getIdade(), usuario.getSexo(), usuario.getTelefone());
		// TODO Auto-generated constructor stub
	}

	public String getAcesso() {
		return acesso;
	}

	public void setAcesso(String acesso) {
		this.acesso = acesso;
	}

}
