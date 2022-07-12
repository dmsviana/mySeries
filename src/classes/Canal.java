package classes;

public abstract class Canal {
	
	private String nomeDoCanal;
	private String tipoDoCanal;
	

	public String getNomeDoCanal() {
		return nomeDoCanal;
	}
	public void setNomeDoCanal(String nomeDoCanal) {
		this.nomeDoCanal = nomeDoCanal;
	}
	public String getTipoDoCanal() {
		return tipoDoCanal;
	}
	public void setTipoDoCanal(String tipoDoCanal) {
		this.tipoDoCanal = tipoDoCanal;
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
}
