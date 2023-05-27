package com.estacio.javasacolao;

import java.util.Scanner;
import java.util.ArrayList;

/*	TODO: Não sei se vai dar tempo de fazer interface, esses métodos de entrada são pra ser placeholder
 * 	(me ajuda plmdDs)
 */

//	"Integer.parseInt(sc.nextLine())" resolve muito problema de imutabilidade! Usem isso ao invés de "s.nextInt()"

public class Entrada {
	
	//	Métodos
	public static Integer menuSelecao() {
		
		Scanner s = new Scanner(System.in);
		s.useDelimiter("\n");
		
		System.out.println("\nSelecione uma opção:\n");
		System.out.println("\t[1] | Cadastrar produto");
		System.out.println("\t[2] | Editar produto");
		System.out.println("\t[3] | Consulta");
		System.out.println("\t[4] | Consulta de lucro com multiplas unidades");
		System.out.println("\t[5] | Sair\n");
		
		Integer input = Integer.parseInt(s.nextLine());
		
		s.close();		//	Destroi objeto scanner
		
		return input;
		
	}
	public static void menuCadastro(ArrayList<Produto> lista) {
		
		Scanner s = new Scanner(System.in);
		s.useDelimiter("\n");
		
		System.out.println("Digite o nome do produto: ");
		String nome = s.nextLine();
		System.out.println("Digite o preço de compra de uma unidade do produto: R$");
		Double precoCompra = Double.parseDouble(s.nextLine());
		System.out.println("Digite o lucro desejado (%): ");
		Double lucro = Double.parseDouble(s.nextLine());
		lucro /= 100;
		
		Produto produto = new Produto(nome, precoCompra, lucro);
		lista.add(produto);
		
		s.close();
		
	}
	public static void menuEditarCadastro(ArrayList<Produto> lista) {
		
		Scanner s = new Scanner(System.in);
		s.useDelimiter("\n");
		
		System.out.println("[n] | Nome:\t\t| PreçoCompra:\t| Lucro:\n| PreçoVenda: ");
		for (int i = 0; i < lista.size(); i++) {
		    Produto p = lista.get(i);
		    System.out.printf(
		    	"[%d] | %s\t| R$%2f\t\t| %2f\t%| R$%2f%n",
		    	i + 1,
		    	p.getNome(),
		    	p.getPrecoCompra(),
		    	p.getLucro(),
		    	p.getPrecoCompra() * (p.getLucro() + 1)
		    );
		}
		
		System.out.print("\nDigite o índice do produto à ser editado: ['numero']");
		
		Integer index = Integer.parseInt(s.nextLine());
			if (index <= lista.size()) {
				System.out.println("\nSelecione uma opção:\n");
				System.out.println("\t[1] | Editar preço");
				System.out.println("\t[2] | Editar lucro");
				System.out.println("\t[3] | Excluir");
				System.out.println("\t[4] | Cancelar\n");
				
				Integer input = Integer.parseInt(s.nextLine());
				
				switch(input) {
				
					case 1:{
						
						System.out.println("Digite o novo preço: ");
						Double novoPreco = Double.parseDouble(s.nextLine());
						lista.get(index).setPrecoCompra(novoPreco);
						System.out.println("Preço editado.");
						
					}break;
					
					case 2:{
						
						System.out.println("Digite o novo lucro: (%)");
						Double novoLucro = Double.parseDouble(s.nextLine());
						lista.get(index).setLucro(novoLucro);
						System.out.println("Lucro editado.");
						
					}break;
					
					case 3:{
						
						lista.remove(index - 1);	//	Warning ta aki mas o Eclipse só ta surtando msm
						System.out.println("Removido com sucesso!");
						
					}break;
					
					case 4: System.out.println("Operação cancelada."); break;
					
					default: System.out.println("Opção inválida.");
					
				}
		} else System.out.println("Índice inválido.");
		
		s.close();
	}
	public static void menuConsulta(ArrayList<Produto> lista) {
		
		System.out.println("[n] | Nome:\t\t| PreçoCompra:\t| Lucro:\n| PreçoVenda: ");
		for (int i = 0; i < lista.size(); i++) {
		    Produto p = lista.get(i);
		    System.out.printf(
		    	"[%d] | %s\t| R$%2f\t\t| %2f\t%| R$%2f%n",
		    	i + 1,
		    	p.getNome(),
		    	p.getPrecoCompra(),
		    	p.getLucro(),
		    	p.getPrecoCompra() * (p.getLucro() + 1)
		    );
		}
		
	}
	public static void menuConsultaPlus(ArrayList<Produto> lista) {
		
		Scanner s = new Scanner(System.in);
		s.useDelimiter("\n");
		
		System.out.println("[n] | Nome:\t\t| PreçoCompra:\t| Lucro:\n| PreçoVenda: ");
		for (int i = 0; i < lista.size(); i++) {
		    Produto p = lista.get(i);
		    System.out.printf(
		    		"[%d] | %s\t| R$%2f\t\t| %2f\t%| R$%2f%n",
		    	i + 1,
		    	p.getNome(),
		    	p.getPrecoCompra(),
		    	p.getLucro(),
		    	p.getPrecoCompra() * (p.getLucro() + 1)
		    );
		}
		
		System.out.println("Digite o índice do produto à ser calculado: ['numero']");
		Integer index = Integer.parseInt(s.nextLine()) - 1;
		System.out.println("Digite o numero de unidades à serem calculadas: ");
		Integer q = Integer.parseInt(s.nextLine());
		
		System.out.printf(
			"\n%d unidades de %s com lucro de %2f são R$%2f.",
			q,
			lista.get(index).getNome(),
			lista.get(index).getLucro() * 100,
			(lista.get(index).getLucro() + 1) * lista.get(index).getPrecoCompra() * q
		);
		
		s.close();
	}

}
