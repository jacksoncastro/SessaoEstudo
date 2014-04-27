package model;

public class AlunoModel extends Model {
	private int id;
	private int matricula;
	private String nome;
	
	public AlunoModel() {
	}
	
	public AlunoModel(int id) {
		this.id = id;
	}
	
	public AlunoModel(String nome) {
		this.nome = nome;
	}
	
	public AlunoModel(String aluno, int matricula) {
		this.nome = aluno;
		this.matricula = matricula;
	}

	public AlunoModel(int id, String aluno, int matricula) {
		super();
		this.id = id;
		this.nome = aluno;
		this.matricula = matricula;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}