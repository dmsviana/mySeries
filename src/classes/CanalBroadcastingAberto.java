package classes;

public class CanalBroadcastingAberto extends Canal {
	
	private String url;
	
	public CanalBroadcastingAberto(String nomeDoCanal, String url) {
		super(nomeDoCanal);
		this.url = url;
		
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	
	
	
}
