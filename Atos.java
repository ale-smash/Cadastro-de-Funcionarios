package projeto01;

import java.util.ArrayList;
import java.util.Scanner;

public class Atos {
	
	ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	ArrayList<Ponto> ponto = new ArrayList<Ponto>();
	
	Scanner ler = new Scanner(System.in);
	
	public void TelaInicial(){
		try {
		switch(perguntaInicial()) {
			case "a", "A" -> cadastrar();
			case "b", "B" -> registrarPonto();
			case "c", "C" -> consultarPonto();
			case "d", "D" -> sair();
			default ->	throw new IllegalArgumentException();	
		}
		}catch(IllegalArgumentException e){
			System.out.println("Digite uma das opções, por favor\n\n");
		}finally {
			System.out.println("----------------------------------------------------------------------\n");
			TelaInicial();
		}
	}

	private void sair() {
		System.out.println("Programa encerrado\nAdeus!");
		System.exit(0);
	}

	private String perguntaInicial() {
		System.out.println("  O que gostaria de fazer?");
		System.out.println("\ta) Cadastrar um funcionário\n\tb) Registrar o ponto de um funcionário\n\tC) Consultar o ponto do funcionário\n\tD) Sair");	 
		return ler.nextLine();
	}
	
	private void cadastrar() {
		System.out.println("Digite o nome");
		String nome = ler.nextLine();
		System.out.println("Digite a matrícula");
		String matricula = ler.nextLine();
		System.out.println("Digite o cargo");
		String cargo = ler.nextLine();
		
		verificarRepeticao(nome, matricula );
		
		criarCadastro(nome, matricula, cargo);	
	}

	private void verificarRepeticao(String nome, String matricula) {
		if(!funcionarios.isEmpty()) {
			for(int i=0; i<funcionarios.size(); i++) {
        				if(funcionarios.get(i).getMatricula().equals(matricula)) {
        					System.out.println("Número de matrícula já cadastrada. Falha em cadastrar");
        					System.out.println("----------------------------------------------------------------------\n");
        					TelaInicial();
        				}else {
        					if(funcionarios.get(i).getNome().equals(nome)) {
            					System.out.println("Esse nome já existe em um dos cadastros. Gostaria de incluí-lo assim mesmo?");
            					System.out.println("Sim ou não?");
            					if(simOuNao(ler.nextLine())){
            						System.out.println("Tudo bem. Nome incluído");
            					}else {
            						System.out.println("Falha em cadastrar");
            						System.out.println("----------------------------------------------------------------------\n");
            						TelaInicial();
            					}
            				}
        				}
        	}
        }
	}

	private boolean simOuNao(String resposta) {
		if(resposta.equalsIgnoreCase("Sim")) {
			return true;
		}
		return false;
	}

	private void criarCadastro(String nome, String matricula, String cargo) {
		funcionarios.add(new Funcionario(nome, matricula, cargo));
		ponto.add(new Ponto());
		System.out.println("Funcionário cadastrado com sucesso!\n");
	}
	
	private void registrarPonto() {
		if(funcionarios.isEmpty()) {
        	System.out.println("Não há funcionários cadastrados para bater ponto");
        }else {
        	String matricula = informarMatricula();
        	boolean te1 = true;
	        for(int i=0; i<funcionarios.size(); i++) {
	            if(comparaMatricula(matricula, i)) {
	                System.out.println(funcionarios.get(i).getNome());
	                te1 = false;
	                switch(ponto.get(i).getVez()) {
	                	case 0 -> ponto.get(i).setPontoDeEntrada();
	                	case 1 -> ponto.get(i).setPontoDeSaida();
	                	default -> System.out.println("Você já atingiu o limite de pontos batidos por dia");
	                }
	            }
	        }
	        matriculaNaoEncontrada(te1);
        }	
	}

	private boolean comparaMatricula(String matricula, int i) {
		return matricula.equalsIgnoreCase(funcionarios.get(i).getMatricula());
	}

	private void consultarPonto() {
		if(funcionarios.isEmpty()) {
        	System.out.println("Não há funcionários cadastrados para consultar ponto");
        }else {
        	String matricula = informarMatricula();
        	boolean te2 = true;
        	for(int i=0; i<funcionarios.size(); i++) {
	            if(comparaMatricula(matricula, i) && verificarPonto(i) == 1) {
	            	te2 = mostraEntrada(i);
	            	System.out.println("Saída: " + ponto.get(i).getPontoDeSaida());
	            			
	            }
	            if(comparaMatricula(matricula, i) && verificarPonto(i) == 2){
	            	te2 = mostraEntrada(i);
	            } 
	            if(comparaMatricula(matricula, i) && verificarPonto(i) == 3) {
	            	te2 = false;
	            	System.out.println("Funcionário(a) " + funcionarios.get(i).getNome() + " não bateu ponto");
	            }
        	}
        	matriculaNaoEncontrada(te2);
        }
	}

	private boolean mostraEntrada(int i) {
		boolean te2;
		te2 = false;
		System.out.println(funcionarios.get(i).getNome()+ "\n" + funcionarios.get(i).getCargo() + "\n" +
				"Entrada: " + ponto.get(i).getPontoDeEntrada());
		return te2;
	}
	
	private int verificarPonto(int i) {
		int e = 0;
		if(ponto.get(i).getPontoDeEntrada() != null && ponto.get(i).getPontoDeSaida() != null) {
			e = 1;
		}
		if(ponto.get(i).getPontoDeEntrada() != null && ponto.get(i).getPontoDeSaida() == null){
			e = 2;
		}
		if(ponto.get(i).getPontoDeEntrada() == null && ponto.get(i).getPontoDeSaida() == null){
			e = 3;
		}
		return e;
	}
	
	private String informarMatricula() {
		String matricula;		
		System.out.println("Informe a matrícula do funcionário(a): ");
        matricula = ler.nextLine(); 
        return matricula;
	}
	
	private void matriculaNaoEncontrada(boolean te) {
		if(te) {
        	System.out.println("Matrícula não encontrada");
        }
	}
	
}
