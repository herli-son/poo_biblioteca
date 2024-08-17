package biblioteca_02;

import java.io.Serializable;

public class Audio extends Obras implements Serializable {
	private static final long serialVersionUID = 1L;
	//Utilizado polimorfismo pela herança
	private String duracao;
	private String tipo;
	
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public void utilizar() {
		// TODO Auto-generated method stub
		System.out.println("Escutando mídia de áudio");
	}
	@Override
	public String toString() {
		return super.toString() + "[duracao=" + duracao + ", tipo=" + tipo + "]";
	}
	
}
