package uern.oop.escola;

import uern.oop.lista.*;
import java.util.Scanner;
import java.awt.Insets;
import java.util.Random;

public class Main {

	public static boolean running;

	public static void main(String[] args) {

		ListaG<Turma> corpo = new ListaG<Turma>();
		Scanner scan = new Scanner(System.in);
		running = true;
		Integer opcao = 0;

		while (running)
		{
			cleanT();

			System.out.println("Bem vido aou sigap");

			System.out.println("O que deseja fazer?");

			System.out.println("1 - Criar turma");
			System.out.println("2 - Remover turma");
			System.out.println("3 - Editar turma");
			System.out.println("4 - Mostrar turmas");
			System.out.println("5 - Sair");

			opcao = scan.nextInt();

			switch (opcao) {

				case 1:
					criarTurma(corpo);
					
					break;

				case 2:
					removerTurma(corpo);
					
					break;


				case 3:
					editarTurma(corpo);
					
					break;


				case 4:
					printTurmas(corpo);
					
					break;


				case 5:
					running = false;
					
					break;



				default:
					System.out.println("Opção invalida!");
					hold();
					break;
			}






		}
		scan.close();
	}

	public static void cleanT() 
	{
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void hold()
	{

		Scanner scan = new Scanner(System.in);

		System.out.println("====================================================Pressione enter============================================================");
		scan.nextLine();

	}

	public static boolean validarCodigo(ListaG<Turma> turmas,Integer codigo)
	{


		if (turmas.isVazia())
		{
			return false;
		}

		for (int i = 0; i < turmas.tamanho(); i++)
		{
			Turma turma = turmas.localizarBloco(i).valor;

			if (turma.getCodigo() == codigo)
			{
				return true;
			}

		}

		return false;

	}
	
	public static void criarTurma(ListaG<Turma> turmas)
	{

		cleanT();
		Scanner scan = new Scanner(System.in);
		Integer codigo;
		String disciplina;

		System.out.println("Insira a disciplina:");
		disciplina = scan.nextLine();

		System.out.println("Insira o codigo:");
		codigo = scan.nextInt();

		while (validarCodigo(turmas, codigo)) {
			
			System.out.println("Codigo ja em uso, insira um outro:");
			codigo = scan.nextInt();
		}

		Turma nova = new Turma(disciplina, codigo);
		turmas.addElemento(nova, false);
		System.out.println("Turma cadastrada com sucesso");
		hold();


	}

	public static void removerTurma(ListaG<Turma> turmas)
	{
		cleanT();

		if (turmas.isVazia())
		{
			System.out.println("Nenhuma turma registrada");
			hold();
			return;
		}

		System.out.println("Insira o codigo da turma que deseja excluir:");

		Scanner scan = new Scanner(System.in);

		Integer codigo = scan.nextInt();

		if (!validarCodigo(turmas, codigo))
		{
			System.out.println("Codigo invalido, tente novamente");
			hold();
			return;
			
		}


		for (int i = 0; i < turmas.tamanho(); i++)
		{
			Turma turma = turmas.localizarBloco(i).valor;

			if (turma.codigo == codigo)
			{
				turmas.removerElemento(i);

				System.out.println("Turma removida com sucesso!");
				break;
			}

		}

		hold();


	}

	public static void printTurmas(ListaG<Turma> turmas)
	{
		if (turmas.isVazia())
		{
			System.out.println("Nenhuma turma cadastrada");
			hold();
			return;

		}
		cleanT();

		for (int i = 0;  i < turmas.tamanho(); i++)
		{
			Turma turma = turmas.localizarBloco(i).valor;

			System.out.println("Disciplina: " + turma.getDisciplina().nome);
			System.out.println("Codigo: " + turma.getCodigo());
			System.out.println();

		}
		hold();

	}

	public static Turma getTurma(Integer codigo, ListaG<Turma> turmas)
	{
		Turma turma = null;

		for (int i = 0; i < turmas.tamanho(); i++)
		{
			turma = turmas.localizarBloco(i).valor;

			if (turma.codigo == codigo)
			{
				break;
			}

		}

		return turma;

	}


	public static void editarTurma(ListaG<Turma> turmas)
	{

		cleanT();
		Scanner scan = new Scanner(System.in);
		System.out.println("Insira o codigo da turma:");
		Integer codigo = scan.nextInt();

		if (!validarCodigo(turmas, codigo))
		{
			System.out.println("Codigo invalido");
			hold();
			return;
		}

		Turma selecionada = getTurma(codigo, turmas);

		while (running)
		{
			cleanT();

			System.out.println("Turma: " + selecionada.getCodigo());
			System.out.println("Disciplina: " + selecionada.getDisciplina().nome);
			System.out.println();
			System.out.println("1 - Adicionar aluno");
			System.out.println("2 - Remover aluno");
			System.out.println("3 - Listar alunos");
			System.out.println("4 - Mostrar notas de aluno");
			System.out.println("5 - Adicionar nota de aluno");
			System.out.println("6 - Remover nota de aluno");
			System.out.println("7 - Voltar");
			System.out.println("8 - Sair");
			System.out.println("Selecione o que deseja fazer: ");

			Integer option = scan.nextInt();

			switch (option) {
				case 1:
					addAluno(selecionada);
					break;

				case 2:
					removeAluno(selecionada);
					break;

				case 3:
					cleanT();
					selecionada.printTurma();
					hold();
					break;

				case 4:
					printNotas(selecionada);
					break;

				case 5:
					addNota(selecionada);
					break;

				case 6:
					removeNota(selecionada);
					break;

				case 7:
					return;

				case 8:
					running = false;
					break;

				default:
					System.out.println("Opção inválida");
					hold();
					break;
			}

		}






	}

	public static void addAluno(Turma turma)
	{
		cleanT();

		System.out.println("Insira o nome do aluno:");
		Scanner scan = new Scanner(System.in);

		turma.addAluno(scan.nextLine());

		System.out.println("Aluno adicionado com sucesso");
		hold();

	}

	public static void removeAluno(Turma turma)
	{
		cleanT();
		System.out.println("Insira a matricula do aluno que deseja remover:");


		Scanner scan = new Scanner(System.in);

		if (scan.hasNextInt()) 
		{
			int matricula = scan.nextInt();
			System.out.println(matricula);

			scan.nextLine();

			if (turma.removeAluno(matricula) == null) 
			{
				System.out.println("Aluno não existe");
				hold();
			} else 
			{
				System.out.println("Aluno removido com sucesso");
				hold();
			}
		} else
		{
			System.out.println("Entrada inválida! Por favor, insira um número inteiro.");
			scan.nextLine();
			hold();			



		}





	}

	public static void printNotas(Turma turma)
	{
		Aluno atual = getAluno(turma);
		//System.out.println(atual);

		if (atual == null)
		{
			System.out.println("atual null");

			hold();
			return;
		} else
		{

			cleanT();
			atual.printNotas();
			hold();

		}

	}

	public static void removeNota(Turma turma)
	{

		cleanT();
		Aluno atual = getAluno(turma);

		if (atual == null)
		{
			return;
		} else
		{

			atual.printNotas();
			if (atual.getNotas().isVazia())
			{
				return;
			}

			System.out.println("Qual nota deseja remover:");

			Scanner scan = new Scanner(System.in);

			Integer qual = scan.nextInt();

			while(qual > atual.getNotas().tamanho() || qual < 0)
			{
				System.out.println("index invalido, insira um valido");
				hold();
				qual = scan.nextInt();
			}

			atual.removeNota(qual);
			System.out.println("Nota removida com sucesso");
			hold();

		}

	}

	public static void addNota(Turma turma)
	{

		cleanT();
		Aluno atual = getAluno(turma);

		if (atual == null)
		{
			return;
		} else
		{

			System.out.println("Insira a nota do aluno:");

			Scanner scan = new Scanner(System.in);

			Double nota = scan.nextDouble();

			atual.addNota(nota);


			System.out.println("Nota adicionada com sucesso");
			hold();
			

		}

	}

	public static Aluno getAluno(Turma turma)
	{
		Scanner scan = new Scanner(System.in);
		cleanT();
		System.out.println("Insira a matricula do aluno:");
		Integer matricula = scan.nextInt();

		if (!turma.alunoExists(matricula))
		{
			System.out.println("Matricula invalida");

			hold();
			return null;
		}

		System.out.println("Matricula valida");
		hold();


		return turma.getAluno(matricula);
		
	}

}
