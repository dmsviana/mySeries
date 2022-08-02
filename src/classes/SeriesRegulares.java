package classes;

import java.time.DayOfWeek;

public class SeriesRegulares extends ProgramaDeTV {

	private String genero;
	private String estilo;

	public SeriesRegulares(String nome, DayOfWeek[] diasDaSemana, Canal canal, String genero, String estilo) {
		super(nome, diasDaSemana, canal);
		this.genero = genero;
		this.estilo = estilo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

}
