package classes;

public class CanalTVAberta extends Canal {
	
	private int numeroDoCanal;
	
	public CanalTVAberta(int numeroDoCanal, String nomeDoCanal) {
		super(nomeDoCanal);
		this.numeroDoCanal = numeroDoCanal;
	}

	public int getNumeroDoCanal() {
		return numeroDoCanal;
	}

	public void setNumeroDoCanal(int numeroDoCanal) {
		this.numeroDoCanal = numeroDoCanal;
	}
	
	public String toString() {
		return "Nome do canal: " + getNomeDoCanal()
			   +"Numero do canal: " + numeroDoCanal;
	}
	
	

}
