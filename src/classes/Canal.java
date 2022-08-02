package classes;

import java.util.ArrayList;

public class Canal {
	
	private String nomeDoCanal;
	private long id;
	private ArrayList<ProgramaDeTV> programasCadastrados = new ArrayList<ProgramaDeTV>();
	
	

	
	public Canal(String nomeDoCanal){
		this.nomeDoCanal = nomeDoCanal;
		this.id = System.currentTimeMillis();
	}

	public String getNomeDoCanal() {
		return nomeDoCanal;
	}
	public void setNomeDoCanal(String nomeDoCanal) {
		this.nomeDoCanal = nomeDoCanal;
	}
	
	public ArrayList<ProgramaDeTV> getProgramasCadastrados() {
		return programasCadastrados;
	}

	public void setProgramasCadastrados(ArrayList<ProgramaDeTV> programasCadastrados) {
		this.programasCadastrados = programasCadastrados;
	}


	
	public String toString() {
		return "\nNome do canal: " + nomeDoCanal;
	}
	
	public boolean equals(Canal canal) {
		
		if(canal.getNomeDoCanal() != null && nomeDoCanal != null) {
			if(nomeDoCanal.equalsIgnoreCase(canal.getNomeDoCanal())) {
				return true;
		}
		}
		return false;
	}

	public long getId() {
		
		return id;
	}
}
