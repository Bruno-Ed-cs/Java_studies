package uern.oop.velha;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {

		Tabuleiro jogo = new Tabuleiro();

		Integer vencedor = -1;

		while (vencedor == -1)
		{

			System.out.print("\033[H\033[2J");
			System.out.flush();

			System.out.println("Jogo da velha:");

			jogo.print();

			if (jogo.checkVelha())
			{
				System.out.println("Deu Velha!");
				break;
			}

			jogo.turn(0);

			if (jogo.checkVictory(0) == 0)
			{
				vencedor = 0;
				break;
			}

			System.out.print("\033[H\033[2J");
			System.out.flush();

			System.out.println("Jogo da velha:");

			jogo.print();

			if (jogo.checkVelha())
			{
				System.out.println("Deu Velha!");
				break;
			}

			jogo.turn(1);

			if (jogo.checkVictory(1) == 1)
			{
				vencedor = 1;
				break;
			}
		}

		jogo.print();
		if (vencedor == 1)
		{
			System.out.println("Paraben X");
		} else if (vencedor == 0)
		{
			System.out.println("Parabens O");

		}

	}
}
