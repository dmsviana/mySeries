package classes;

public class CanalBroadcasting extends Canal{
	
	private String url;
	
	public CanalBroadcasting(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String toString() {
		return 	"Nome do canal: " + getNomeDoCanal()
				+"Link do canal: " + url;
	}
	
	
	
	
	
	
}
