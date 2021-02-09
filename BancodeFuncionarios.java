package projeto01;
import java.util.HashMap;
import java.util.ArrayList;

public class BancodeFuncionarios {
	private int matricula;
	private String nome;
	HashMap<Integer, String> bancodeFuncionarios = new HashMap<Integer, String>();
	
	public BancodeFuncionarios(Funcionario funcionario){
		this.matricula = funcionario.getMatricula();
		this.nome = funcionario.getNome();
		bancodeFuncionarios.put(this.matricula, this.nome );
	}
	
	String retorna(int matricula) {
		if(bancodeFuncionarios.containsKey(matricula)){
			String atual = bancodeFuncionarios.get(nome);
			return atual;
		}else {
			System.out.println("Matrícula não encontrada");
		}
	}
	
	
	
}
