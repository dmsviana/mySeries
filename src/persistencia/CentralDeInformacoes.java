package persistencia;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import classes.Canal;
import classes.ProgramaDeTV;
import classes.Usuario;
import excecoes.CanalJaExisteException;
import excecoes.UsuarioJaExisteException;

public class CentralDeInformacoes {
	private ArrayList<Usuario> todosOsUsuarios = new ArrayList<Usuario>();
	private ArrayList<ProgramaDeTV> todosOsProgramas = new ArrayList<ProgramaDeTV>();
	private ArrayList<Canal> todosOsCanais = new ArrayList<Canal>();
	
	
	public ArrayList<Usuario> getTodosOsUsuarios() {
		return todosOsUsuarios;
	}


	public ArrayList<Canal> getTodosOsCanais(){
		return todosOsCanais;
	}
	
	public ArrayList<ProgramaDeTV> getTodosOsProgramas() {
		return todosOsProgramas;
	}
	

	public void adicionarUsuario(Usuario usuario) throws UsuarioJaExisteException{
		if(!todosOsUsuarios.isEmpty()) {
			for(Usuario u : todosOsUsuarios) {
				if(u.getEmail().equalsIgnoreCase(usuario.getEmail())) {
					throw new UsuarioJaExisteException();
				}
			}
		}
		todosOsUsuarios.add(usuario);
	}
	
	
	public void adicionarCanal(Canal canal) throws CanalJaExisteException{
		if(recuperarCanalPeloNome(canal.getNomeDoCanal()) == null) {
			todosOsCanais.add(canal);
			
		} else {
			throw new CanalJaExisteException();
		}
	}
	
	public Canal recuperarCanalPeloNome(String nomeDoCanal) {
		for(Canal canalCadastrado : todosOsCanais) {
			if(canalCadastrado.getNomeDoCanal().equalsIgnoreCase(nomeDoCanal)) {
				return canalCadastrado;
			}
		}
		return null;
	}
	
	public boolean deletarCanal(long id) {
		for(Canal canal : todosOsCanais) {
			if(canal.getId() == id) {
				todosOsCanais.remove(canal);
				return true;				
			}
		}
		return false;
	}

	public boolean adicionarPrograma(ProgramaDeTV programa) {
		if (recuperarProgramaPorId(programa.getId()) == null) {
			todosOsProgramas.add(programa);
			return true;
		}
		return false;
	}


	public ProgramaDeTV recuperarProgramaPorId(long id) {
		for (int i = 0; i < todosOsProgramas.size(); i++) {
			if (id == todosOsProgramas.get(i).getId()) {
				return todosOsProgramas.get(i);
			}
		}
		return null;
	}
	

	
	
	public Usuario autenticarUsuario(String email, String senha) throws Exception {
		for(Usuario usuario : todosOsUsuarios) {
			if(usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
				return usuario;
			}
		}
		throw new Exception("Email ou senha incorretos!");
	}
	

}