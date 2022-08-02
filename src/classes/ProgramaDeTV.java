package classes;

import java.time.DayOfWeek;

import enums.FaixaEtaria;
import enums.TipoDePrograma;

public abstract class ProgramaDeTV {
	private long id;
	private String nome;
	private DayOfWeek[] diasDaSemana;
	private FaixaEtaria faixaEtaria;
	private Canal canal;

	public ProgramaDeTV(String nome, DayOfWeek[] diasDaSemana, Canal canal) {
		this.id = System.currentTimeMillis();
		this.nome = nome;
		this.diasDaSemana = new DayOfWeek[6];
		this.canal = canal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public DayOfWeek[] getDiasDaSemana() {
		return diasDaSemana;
	}

	public void setDiasDaSemana(DayOfWeek[] diasDaSemana) {
		this.diasDaSemana = diasDaSemana;
	}

	public long getId() {
		return id;
	}

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

	public void setId(long id) {
		this.id = id;
	}


	public FaixaEtaria getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(FaixaEtaria faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	public String toString() {
		return "Nome do programa: " + nome;
	}

}
