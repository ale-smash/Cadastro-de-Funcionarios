package projeto01;

import java.util.ArrayList;
import java.util.Scanner;

public class A��es {
	
	ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	ArrayList<Ponto> ponto = new ArrayList<Ponto>();
	
	Scanner ler = new Scanner(System.in);
	
	public void TelaInicial(){
		String esc = perguntaInicial();
		switch(esc) {
			case "a":
				cadastrar();
				break;
			case "b":
				registrarPonto();
				break;
			case "c":
				consultarPonto();
				break;
			default:
				System.out.println("Digite uma das op��es, por favor\n");
				System.out.println("----------------------------------------------------------------------\n");
				TelaInicial();
		}
	}

	private String perguntaInicial() {
		System.out.println("  O que gostaria de fazer?");
		System.out.println("\ta) Cadastrar um funcion�rio\n\tb) Registrar o ponto de um funcion�rio\n\tC) Consultar o ponto do funcion�rio");
		String esc = ler.nextLine();
		return esc;
	}
	
	private void cadastrar() {
		System.out.println("Digite o nome");
		String nome = ler.nextLine();
		System.out.println("Digite a matr�cula");
		String matricula = ler.nextLine();
		System.out.println("Digite o cargo");
		String cargo = ler.nextLine();
		
		funcionarios.add(new Funcionario(nome, matricula, cargo));
		ponto.add(new Ponto());
		System.out.println("Funcion�rio cadastrado com sucesso!\n");
		System.out.println("----------------------------------------------------------------------\n");
		TelaInicial();
	}
	
	private void registrarPonto() {
		if(funcionarios.size() == 0) {
        	System.out.println("N�o h� funcion�rios cadastrados para bater ponto");
        }else {
        	String matricula = informarMatricula();
        	boolean te1 = true;
	        for(int i=0; i<funcionarios.size(); i++) {
	            if(comparaMatricula(matricula, i)) {
	                System.out.println(funcionarios.get(i).getNome());
	                te1 = false;
	                switch(ponto.get(i).getVez()) {
	                	case 0:
	                		ponto.get(i).setPontoDeEntrada();
	                		System.out.println("Ponto batido com sucesso!");
	                		break;
	                	case 1:
	                		ponto.get(i).setPontoDeSaida();
	                		System.out.println("Ponto batido com sucesso!");
	                		break;
	                	default:
	                		System.out.println("Voc� j� atingiu o limite de pontos batidos por dia");
	                }
	            }
	        }
	        matriculaNaoEncontrada(te1);
        }
		System.out.println("----------------------------------------------------------------------\n");
		TelaInicial();
	}

	private boolean comparaMatricula(String matricula, int i) {
		return matricula.equalsIgnoreCase(funcionarios.get(i).getMatricula());
	}

	private void consultarPonto() {
		if(funcionarios.size() == 0) {
        	System.out.println("N�o h� funcion�rios cadastrados para consultar ponto");
        }else {
        	String matricula = informarMatricula();
        	boolean te2 = true;
        	for(int i=0; i<funcionarios.size(); i++) {
	            if(comparaMatricula(matricula, i) && verificarPonto(i) == 1) {
	            	te2 = false;
	            	System.out.println(funcionarios.get(i).getNome()+ "\n" + funcionarios.get(i).getCargo() + "\n" +
	            			"Entrada: " + ponto.get(i).getPontoDeEntrada() + "\n" + 
	            			"Sa�da: " + ponto.get(i).getPontoDeSaida());
	            }
	            if(comparaMatricula(matricula, i) && verificarPonto(i) == 2){
	            	te2 = false;
	            	System.out.println(funcionarios.get(i).getNome()+ "\n" + funcionarios.get(i).getCargo() + "\n" +
	            			"Entrada: " + ponto.get(i).getPontoDeEntrada());
	            } 
	            if(comparaMatricula(matricula, i) && verificarPonto(i) == 3) {
	            	te2 = false;
	            	System.out.println("Funcion�rio(a) " + funcionarios.get(i).getNome() + " n�o bateu ponto");
	            }
        	}
        	matriculaNaoEncontrada(te2);
        }
		System.out.println("----------------------------------------------------------------------\n");
		TelaInicial();
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
		System.out.println("Informe a matr�cula: ");
        matricula = ler.next(); 
        return matricula;
	}
	
	private void matriculaNaoEncontrada(boolean te) {
		if(te) {
        	System.out.println("Matr�cula n�o encontrada");
        }
	}
	
}
