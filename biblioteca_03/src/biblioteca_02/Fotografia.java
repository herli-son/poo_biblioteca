package biblioteca_02;

import java.io.Serializable;

public class Fotografia extends Obras implements Serializable {

	private static final long serialVersionUID = 1L;
	private String resolucao;
	private String tipo;
	

	public String getResolucao() {
		return resolucao;
	}


	public void setResolucao(String resolcao) {
		this.resolucao = resolcao;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	@Override
	//Utilizado polimorfismo pela herança
	public void utilizar() {
		// TODO Auto-generated method stub
		System.out.println("Vendo fotografia.");
	}


	@Override
	public String toString() {
		return super.toString() + "[resolcao=" + resolucao + ", tipo=" + tipo + "]";
	}
	
}
