package projeto01;



public class Funcionario extends Ponto {
	private String nome;
	private int matricula;
	private String cargo;
	public int vez;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	void registraFuncionario(String nome,int matricula,String cargo) {
		setNome(nome);
		setMatricula(matricula);
		setCargo(cargo);
	}
	
	
	void registraPonto() {
		vez++;
		if(vez>2) {
			System.out.println("Já registrou duas vezes! Não pode mais hoje");
		}else {
			registra(vez);
			
		}
	}
	
	
	
	

}
