package Biblioteca;

import java.io.Serializable;

public class Estudante extends Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;
	public String periodo;
	public String curso;

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	@Override
	public String toString() {
		return super.toString() + "[periodo=" + periodo + ", curso=" + curso + "]";
	}
	
}
