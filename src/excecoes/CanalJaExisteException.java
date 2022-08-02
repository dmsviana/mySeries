package excecoes;

public class CanalJaExisteException extends Exception {
    
    public String getMessage(){
        return "O canal já existe!";
    }

}
