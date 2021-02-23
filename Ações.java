package projeto01;

import java.util.ArrayList;
import java.util.Scanner;

public class Ações {
	
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
				System.out.println("Digite uma das opções, por favor\n");
				System.out.println("----------------------------------------------------------------------\n");
				TelaInicial();
		}
	}

	private String perguntaInicial() {
		System.out.println("  O que gostaria de fazer?");
		System.out.println("\ta) Cadastrar um funcionário\n\tb) Registrar o ponto de um funcionário\n\tC) Consultar o ponto do funcionário");
		String esc = ler.nextLine();
		return esc;
	}
	
	public void cadastrar() {
		System.out.println("Digite o nome");
		String nome = ler.nextLine();
		System.out.println("Digite a matrícula");
		String matricula = ler.nextLine();
		System.out.println("Digite o cargo");
		String cargo = ler.nextLine();
		
		funcionarios.add(new Funcionario(nome, matricula, cargo));
		ponto.add(new Ponto());
		System.out.println("Funcionário cadastrado com sucesso!\n");
		System.out.println("----------------------------------------------------------------------\n");
		TelaInicial();
	}
	
	public void registrarPonto() {
		if(funcionarios.size() == 0) {
        	System.out.println("Não há funcionários cadastrados para registrar ponto");
        }else {
        	String matricula = informarMatricula();
        	boolean te = true;
	        for(int i=0; i<funcionarios.size(); i++) {
	            if(matricula.equalsIgnoreCase(funcionarios.get(i).getMatricula())) {
	                System.out.println(funcionarios.get(i).getNome());
	                te = false;
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
	                		System.out.println("Você já atingiu o limite de pontos batidos por dia");
	                }
	            }
	        }
	        negativa(te);
        }
		System.out.println("----------------------------------------------------------------------\n");
		TelaInicial();
	}

	public void consultarPonto() {
		if(funcionarios.size() == 0) {
        	System.out.println("Não há funcionários cadastrados para consultar ponto");
        }else {
        	String matricula = informarMatricula();
        	boolean te = true;
        	for(int i=0; i<funcionarios.size(); i++) {
	            if(matricula.equalsIgnoreCase(funcionarios.get(i).getMatricula()) && ponto.get(i).getPontoDeEntrada() != null
	            		&& ponto.get(i).getPontoDeSaida() != null) {
	            	te = false;
	            	System.out.println(funcionarios.get(i).getNome()+ "\n" + funcionarios.get(i).getCargo() + "\n" +
	            			"Entrada: " + ponto.get(i).getPontoDeEntrada() + "\n" + 
	            			"Saída: " + ponto.get(i).getPontoDeSaida());
	            }
	            if(matricula.equalsIgnoreCase(funcionarios.get(i).getMatricula()) && ponto.get(i).getPontoDeEntrada() != null
	            		&& ponto.get(i).getPontoDeSaida() == null){
	            	te = false;
	            	System.out.println(funcionarios.get(i).getNome()+ "\n" + funcionarios.get(i).getCargo() + "\n" +
	            			"Entrada: " + ponto.get(i).getPontoDeEntrada());
	            } 
        	}
        	negativa(te);
        }
		System.out.println("----------------------------------------------------------------------\n");
		TelaInicial();
	}
	
	public String informarMatricula() {
		String matricula;		
		System.out.println("Informe a matrícula: ");
        matricula = ler.next(); 
        return matricula;
	}
	
	public void negativa(boolean te) {
		if(te) {
        	System.out.println("Registro não encontrado");
        }
	}
	
}
