package uern.oop.velha;
import uern.oop.lista.*;

import java.util.Scanner;

public class Tabuleiro{

	private Lista lista;



	public Tabuleiro()
	{

		this.lista = new Lista();
		for (int i = 0; i < 9; i++)
		{
			this.lista.addElemento(-1, true);
		}
	}

	public Integer getPos(Integer y, Integer x)
	{
		int position = x + (y * 3);
		Integer valor = (Integer) this.lista.localizarBloco(position).valor;

		return valor;

	}

	public void print()
	{
		System.out.println("      0   1   2");
		System.out.println();
		System.out.println("        |   |");


		System.out.print("  0   ");
		this.printTile(getPos(0, 0));
		System.out.print(" | ");
		this.printTile(getPos(0, 1));
		System.out.print(" | ");
		this.printTile(getPos(0, 2));
		System.out.print("\n");

		System.out.println("     ---+---+---");

		System.out.print("  1   ");
		this.printTile(getPos(1, 0));
		System.out.print(" | ");
		this.printTile(getPos(1, 1));
		System.out.print(" | ");
		this.printTile(getPos(1, 2));
		System.out.print("\n");

		System.out.println("     ---+---+---");

		System.out.print("  2   ");
		this.printTile(getPos(2, 0));
		System.out.print(" | ");
		this.printTile(getPos(2, 1));
		System.out.print(" | ");
		this.printTile(getPos(2, 2));
		System.out.print("\n");

		System.out.println("        |   |");



	}

	private void printTile(Integer valor)
	{
		switch (valor)
		{
			case -1:
				System.out.print(" ");
				break;

			case 0:
				System.out.print("O");
				break;

			case 1:
				System.out.print("X");
				break;
		}

	}

	public Integer checkVictory(Integer target)
	{
		Integer counter = 0;

		for (int i = 0; i < 3; i++)
		{
			if (this.getPos(i, 0) == target)
			{
				counter++;
			}

			if (this.getPos(i, 1) == target)
			{
				counter++;
			}

			if (this.getPos(i, 2) == target)
			{
				counter++;
			}
			if (counter >= 3)
			{
				return target;
			}

			counter = 0;
		}

		counter = 0;
		for (int i = 0; i < 3; i++)
		{
			if (this.getPos(0, i) == target)
			{
				counter++;
			}

			if (this.getPos(1, i) == target)
			{
				counter++;
			}

			if (this.getPos(2, i) == target)
			{
				counter++;
			}

			if (counter >= 3)
			{
				return target;
			}

			counter = 0;
		}


		for (int i = 0; i < 3; i++)
		{
			if (this.getPos(i, i) == target)
			{
				counter++;
			}

			if (counter >= 3)
			{
				return target;
			}

			counter = 0;
		}

		for (int i = 0, p = 2; i < 3; i++, p--)
		{
			if (this.getPos(p, i) == target)
			{
				counter++;
			}

			if (counter >= 3)
			{
				return target;
			}

			counter = 0;
		}

		return -1;


	}

	public void turn(Integer player)
	{
		System.out.print("Jogador ");

		if (player == 1)
		{
			System.out.print("X");
		} else
		{
			System.out.print("O");
		}

		System.out.print(" insira sua jogada [Y X]\n");

		boolean valido = false;
		Scanner s = new Scanner(System.in);
		Integer x = 0, y = 0;

		while (!valido)
		{
			y = s.nextInt();
			x = s.nextInt();

			if (x > 2 || x < 0)
			{

				System.out.println("Posição x invalida, mantenha no intervalo ");
				System.out.println("Tente novamente");
			} else if (y > 2 || y < 0)
			{
				System.out.println("Posição y invalida, mantenha no intervalo ");
				System.out.println("Tente novamente");

			} else if (this.getPos(y, x) != -1)
			{
				System.out.println("O quadrado ja está marcado!");
				System.out.println("Tente novamente");
			} else
			{
				valido = true;
				this.insert(y, x, player);
			}


		}

	}

	private void insert(Integer y, Integer x, Integer value)
	{
		this.lista.localizarBloco(x + (y *3)).valor = value;

	}

	public boolean checkVelha()
	{
		boolean velha = true;

		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (this.getPos(i, j) == -1)
				{
					velha = false;
					return velha;
				}
			}
		}

		return velha;
	}

}
