package excecoes;

public class UsuarioJaExisteException extends Exception{

	
	public String getMessage() {
		return "Usuário já existe!";
	}
	
}
