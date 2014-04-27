package model;

public class ReservasModel extends Model {
	private int id;
	private String balada;
	private String nome;
	private int telefone;
	
	public ReservasModel() {
	}
	
	public ReservasModel(int id) {
		this.id = id;
	}

	public ReservasModel(String balada, String nome, int telefone) {
		this.balada = balada;
		this.nome = nome;
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBalada() {
		return balada;
	}

	public void setBalada(String balada) {
		this.balada = balada;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
}