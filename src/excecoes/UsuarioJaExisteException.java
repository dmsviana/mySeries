package excecoes;

public class UsuarioJaExisteException extends Exception{

	
	public String getMessage() {
		return "Usu�rio j� existe!";
	}
	
}
