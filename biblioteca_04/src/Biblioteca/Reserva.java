package Biblioteca;

import java.io.Serializable;

public class Reserva extends Solicitacao implements Serializable {

	private static final long serialVersionUID = 1L;
	public Reserva(Solicitacao solicitacao) {
		// TODO Auto-generated constructor stub
		super.setObra(solicitacao.getObra());
		super.setUsuario(solicitacao.getUsuario());
		super.setData(solicitacao.getData());
		super.setHora(solicitacao.getHora());
		super.setId(solicitacao.getId());
	}
	public Reserva() {
		// TODO Auto-generated constructor stub
	}
}
