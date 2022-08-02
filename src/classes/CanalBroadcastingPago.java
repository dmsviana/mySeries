package classes;

public class CanalBroadcastingPago extends Canal {

	private String url;
	private double mensalidade;

	public CanalBroadcastingPago(String url, double mensalidade, String nomeDoCanal) {
		super(nomeDoCanal);
		this.url = url;
		this.mensalidade = mensalidade;

	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {

		this.url = url;

	}

	public String toString() {
		return "Nome do canal: " + getNomeDoCanal() + "\nLink do canal: " + url + "\nMensalidade: " + mensalidade;
	}

	public double getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(double mensalidade) {
		this.mensalidade = mensalidade;
	}

}
