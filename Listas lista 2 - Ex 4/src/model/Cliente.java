package model;

public class Cliente {

	private long cpf;
	private String nome;
	private int idade;
	private double limitecredito;
	
	/*public Cliente(long cpf, String nome, int idade, double limitecredito) {
		cpf = this.cpf;
		nome = this.nome;
		idade = this.idade;
		limitecredito = this.limitecredito;
	}*/

	@Override
	public String toString() {
		return cpf + ";" + nome + ";" + idade + ";" + limitecredito;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getLimitecredito() {
		return limitecredito;
	}

	public void setLimitecredito(double limitecredito) {
		this.limitecredito = limitecredito;
	}
	
	
	
}
