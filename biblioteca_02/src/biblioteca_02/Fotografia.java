package biblioteca_02;

import java.io.Serializable;

public class Fotografia extends Obras implements Serializable {

	private int numeroDeFotos;
	
	public int getNumeroDeFotos() {
		return numeroDeFotos;
	}

	public void setNumeroDeFotos(int numeroDeFotos) {
		this.numeroDeFotos = numeroDeFotos;
	}

	@Override
	//Utilizado polimorfismo pela herança
	public void utilizar() {
		// TODO Auto-generated method stub
		System.out.println("Vendo fotografia");
	}

	@Override
	public void gravar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar() {
		// TODO Auto-generated method stub
		
	}

}
