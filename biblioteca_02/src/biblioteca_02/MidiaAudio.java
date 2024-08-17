package biblioteca_02;

import java.io.Serializable;
import java.time.LocalTime;

public class MidiaAudio extends Obras implements Serializable {
	//Utilizado polimorfismo pela herança
	private LocalTime duracao;
	
	public LocalTime getDuracao() {
		return duracao;
	}

	public void setDuracao(LocalTime duracao) {
		this.duracao = duracao;
	}

	@Override
	public void utilizar() {
		// TODO Auto-generated method stub
		System.out.println("Escutando mídia de audio");
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
