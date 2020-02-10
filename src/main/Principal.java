package main;

import java.util.Scanner;

import mecanica.FabricaMecanicaDoJogo;
import mecanica.MecanicaDoJogo;

public class Principal {
	private static Scanner scanner;	
	public static void main(String[] args) {		
		FabricaMecanicaDoJogo fabrica = new FabricaMecanicaDoJogo();
		scanner = new Scanner(System.in);
		display_menu();
		int opcao = scanner.nextInt();
		while(opcao != 3) {
			fabrica.setMecanica(opcao);
			MecanicaDoJogo jogo = fabrica.getMecanica();
			
			if(jogo != null) {
				System.out.println(jogo.getModo() + "\n" + jogo.getDescricao() + "\n\n" +jogo.getInstrucao());
				
				do{
					String embaralhada = jogo.getEmbaralhada();
					System.out.println("\n"+jogo.getHead());
			        System.out.println("Advinhe a Palavra: " + embaralhada); 
			        System.out.print("> ");
			        String resposta = scanner.next().toUpperCase();
			        boolean resultado = jogo.isAcertou(resposta);
			        
			        if(resultado == true) {
			        	System.out.println("Parabéns você acertou!");
			        }else {
			        	System.out.println("Que pena você errou!");
			        	while(jogo.getTentativas() != 0 && resultado != true) {
				        	System.out.println("nao desista continue tentando!"
				        			+ "\nrestam "+ jogo.getTentativas() + " tentativas");
				        	System.out.println("\n"+jogo.getHead());
				        	System.out.println("Advinhe a Palavra: " + embaralhada + "\n> ");
					        resposta = scanner.next().toUpperCase();
					        resultado = jogo.isAcertou(resposta);
					        
					        if(resultado == true) {
					        	System.out.println("\nParabéns você acertou!");
					        }
				        }
			        }
				}while(!jogo.isTerminou());
				
				System.out.println(jogo.getResultado());
			}
			System.out.println("\ncontinuar jogando ou voltar ao menu? \n[1=continuar | 2=menu]");
			System.out.print("> ");
			int temp = scanner.nextInt();
			
			if(temp == 2) {
				display_menu();
				opcao = scanner.nextInt();
			}				
		}
		scanner.close();
	}
	
	public static void display_menu() {		
		System.out.println("Jogo das Palavras Embalharadas"
				+ "\nEscolha uma opcao para Jogar!"
				+ "\n\nOPCAO:"
				+ "\n1 - Modo Morte Subita"
				+ "\n2 - Modo Aventura"
				+ "\n3 - Sair");
		System.out.print("> ");
	}
}