package persistencia;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import classes.Canal;
import classes.ProgramaDeTV;
import classes.Usuario;

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
	

	public void adicionarUsuario(Usuario usuario) throws Exception {
		if(!todosOsUsuarios.isEmpty()) {
			for(Usuario u : todosOsUsuarios) {
				if(u.getCPF().equals(usuario.getCPF())) {
					throw new Exception("Usuário já existe!");
				} else if(u.getEmail().equals(usuario.getEmail())) {
					throw new Exception("E-mail já cadastrado!");
				} 
			}
		}
		todosOsUsuarios.add(usuario);
	}
	
	
	public boolean adicionarCanal(Canal canal) {
		if(recuperarCanalPeloNome(canal.getNomeDoCanal()) == null) {
			todosOsCanais.add(canal);
			return true;
		}
		return false;
	}
	
	public Canal recuperarCanalPeloNome(String nomeDoCanal) {
		for(int i = 0; i < todosOsCanais.size(); i++) {
			if(todosOsCanais.get(i).equals(nomeDoCanal)) {
				return todosOsCanais.get(i);
			}
		}
		return null;
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
	
	public String listarProgramasDeTipoIguais(String tipo) {
		ArrayList<String> nomeDosProgramas = new ArrayList<String>();;
		for(int i = 0; i < todosOsProgramas.size(); i++) {
			if(todosOsProgramas.get(i).getTipoDePrograma().getDescricao().equals(tipo)) {
				nomeDosProgramas.add(todosOsProgramas.get(i).getNome());
			}
		}
		return nomeDosProgramas.toString();
			
			
		
	}
	
	public Usuario autenticarUsuario(String email, String senha) throws Exception {
		for(Usuario usuario : todosOsUsuarios) {
			if(usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
				return usuario;
			}
		}
		throw new Exception("Email ou senha incorretos!");
	}
	
	public Usuario autenticarEmailDoUsuario(String email) throws Exception {
		for(Usuario usuario : todosOsUsuarios) {
			if(usuario.getEmail().equals(email)) {
				return usuario;
			}
		}
		throw new Exception("O usuário não existe!");
	}
	
	public boolean validarEmail(String email) {
		boolean emailValido = false;
		
		if(email != null && email.length() > 0) {
			String caracteresValidos = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(caracteresValidos, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			
			if(matcher.matches()) {
				emailValido = true;
			}
		}
		return emailValido;
	}

}
