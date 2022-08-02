package classes;

import java.time.DayOfWeek;

public class RealityShow extends ProgramaDeTV {
	
	private int qtdApresentadores;

	
	
	public RealityShow(String nome, DayOfWeek[] diasDaSemana, Canal canal, int qtdApresentadores) {
		super(nome, diasDaSemana, canal);
		this.qtdApresentadores = qtdApresentadores;
	}



	public int getQtdApresentadores() {
		return qtdApresentadores;
	}



	public void setQtdApresentadores(int qtdApresentadores) {
		this.qtdApresentadores = qtdApresentadores;
	}
	
	

	
	
	

	
	
	
}
