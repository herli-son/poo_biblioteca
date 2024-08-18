package Biblioteca;

import java.io.Serializable;

public class Funcionario extends Usuarios implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public String funcao;

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	@Override
	public String toString() {
		return super.toString() + "[funcao=" + funcao + "]";
	}
	
}
