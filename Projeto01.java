package projeto01;
import java.util.Scanner; 
import java.util.HashMap;
import java.util.ArrayList;

public class Projeto01 {

	public static void main(String[] args) {
		boolean sistema = true;
		while(sistema) {
			System.out.println("  O que gostaria de fazer?");
			System.out.println("\ta) Cadastrar um funcionário\n\tb) Registrar o ponto de um funcionário\n\tC) Consultar o ponto do funcionário\n\td) Sair ");
			Scanner ler = new Scanner(System.in);
			String esc = ler.nextLine();
			
			Funcionario funcionario = new Funcionario();
			System.out.println(funcionario.getNome());
			
			switch(esc) {
				case "a":
					System.out.println("Digite o nome, em seguida a matrícula e o cargo do funcionário");
					String nome = ler.nextLine();
					int matricula = ler.nextInt();
					ler.nextLine();    // para esvaziar o buffer do teclado pq está usando String depois de int
					String cargo = ler.nextLine();
					funcionario.registraFuncionario(nome, matricula, cargo);
					BancodeFuncionarios guarda = new BancodeFuncionarios(funcionario);
					System.out.println("Cadastro do funcionário(a) "+funcionario.getNome() +
							" realizado com sucesso");
					break;
				case "b":
					System.out.println("Digite a matrícula do funcionário");
					matricula = ler.nextInt();
					
					
					break;
				case "d":
					sistema = false;
					System.out.println("Adeus");
					break;
				default:
					System.out.println("Digite uma das opções, por favor");
			}
		}
	}

}
