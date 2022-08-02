package enums;

public enum Status {
	HIATO("Hiato"), FINALIZADO("Finalizado"), CANCELADO("Cancelado");
	
	
	private String status;
	
	private Status(String status) {
		this.status = status;
	}
	
	
	public String getStatus() {
		return status;
	}
}
