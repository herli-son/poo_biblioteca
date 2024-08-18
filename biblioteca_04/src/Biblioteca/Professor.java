package Biblioteca;

import java.io.*;
public class Professor extends Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;
	private String escola;
	private String especialidade;
	public String getEscola() {
		return escola;
	}
	public void setEscola(String escola) {
		this.escola = escola;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	@Override
	public String toString() {
		return super.toString() + "[escola=" + escola + ", especialidade=" + especialidade + "]";
	}
	
}
