package classes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Usuario {
	private String nome;
	private String telefone;
	private int idade;
	private Date dataDeNascimento;
	private String email;
	private String senha;
	
	// Construtor
	public Usuario(String nome, String telefone, Date dataDeNascimento, String email, String senha) {
		this.nome = nome;
		
		this.telefone = telefone;
		this.dataDeNascimento = dataDeNascimento;
		this.setIdade(dataDeNascimento);
		this.email = email;
		this.senha = senha;
	}
	
	// Setters
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	// Tratar dia e mês
	public void setIdade(Date dataDeNascimento) {
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		Date dataAtual = new Date();
	
		idade = dataAtual.getYear() - dataDeNascimento.getYear();
	}
	
	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	// Getters
	public String getNome() {
		return nome;
	}
	
	
	
	public String getTelefone() {
		return telefone;
	}

	public int getIdade() {
		return idade;
	}
	
	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getSenha() {
		return senha;
	}

	// Sobreescritas
	public String toString() {
		return "Nome: " + this.nome +"\nTelefone: " + this.telefone + "\nIdade: "+ this.idade + "\nE-mail: " + this.email;
	}
}
