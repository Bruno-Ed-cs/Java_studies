package uern.oop.baralho;

import uern.oop.lista.*;
import java.util.Random;

public class Main
{
	public static void main(String[] args) 
	{

		Lista baralho = new Lista();

		for (int i = 1; i <= 13 ; i++)
		{

			baralho.addElemento(i, false);

		}

		Lista jogador1 = baralho.clone();
		jogador1.print();
		Lista jogador2 = baralho.clone();
		jogador2.print();

		shufle(jogador1);
		shufle(jogador2);
		

		System.out.println("Jogador 1 :");
		printDeck(jogador1);

		System.out.println();

		System.out.println("Jogador 2 :");
		printDeck(jogador2);

		Integer t1 = 0;
		Integer t2 = 0;

		for (int i = 0; i < 5; i++)
		{
			t1 += jogador1.localizarBloco(i).valor;
			t2 += jogador2.localizarBloco(i).valor;
		}

		if (t1 > t2)
		{
			System.out.println("O jogador 1 ganhou com " + t1);
		} else if (t1 < t2)
		{

			System.out.println("O jogador 2 ganhou com " + t2);
		} else
		{
			System.out.println("Empate");

		}


		
	}

	private static void shufle(Lista deque)
	{

		Random r = new Random();

		for (int i = 0; i < deque.tamanho(); i++)
		{

			int carta = deque.removerElemento(deque.tamanho() -1).valor;

			deque.addElemento(carta, r.nextInt(deque.tamanho()));

		}

	}

	private static void printDeck(Lista deque)
	{
		for (int i = 0; i < deque.tamanho(); i++)
		{

			System.out.print(translateCard(deque.localizarBloco(i).valor) + " ");

		}

		System.out.print("\n");

	}

	private static String translateCard(int card)
	{

		Integer value = card;

		switch (value) {
			case 1:
				return "as";

			case 11:
				return "J";

			case 12:

				return "Q";

			case 13:
				return "K";
				

			default:
				return value.toString();
		}

		

	}

}
