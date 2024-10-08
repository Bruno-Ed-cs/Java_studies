package uern.oop.escola;

import uern.oop.lista.ListaG;

import java.util.Random;

public class Turma
{
	ListaG<Aluno> alunos = new ListaG<Aluno>();
	Disciplina disciplina;
	Integer codigo;

	public Turma(String disciplina, Integer codigo)
	{

		this.disciplina = new Disciplina(disciplina);
		this.codigo = codigo;

	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public ListaG<Aluno> getAlunos() {
		return alunos;
	}

	public Aluno getAluno(Integer matricula)
	{
		if (!this.alunoExists(matricula))
		{
			return null;
		}


		for (int i = 0; i < this.alunos.tamanho(); i++)
		{

			Aluno aluno = this.alunos.localizarBloco(i).valor;
			if (aluno.getMatricula().equals(matricula))
			{
				return aluno;
			}


		}


		return null;

	}

	public Integer getCodigo() {
		return codigo;
	}

	public void addAluno(String nome)
	{
		Random r = new Random();
		Integer i = r.nextInt(100000);

		while (this.alunoExists(i)) 
		{
			i = r.nextInt(10000);
			
		}

		Aluno novo = new Aluno(nome, i, this.disciplina.nome);

		this.alunos.addElemento(novo, false);

	}

	public Aluno removeAluno(Integer matricula)
	{
		if (!this.alunoExists(matricula))
		{
			return null;
		}
		int pos = 0;

		for (int i = 0; i < this.alunos.tamanho(); i++)
		{
			Aluno aluno = this.alunos.localizarBloco(i).valor;
			if (aluno.getMatricula().equals(matricula))
			{
				pos = i;
			}

		}
		
		Aluno removido = this.alunos.removerElemento(pos).valor;

		return removido;

	}

	public boolean alunoExists(Integer matricula)
	{


		if (this.alunos == null || this.alunos.isVazia())
		{
			return false;
		}

		for (int i = 0; i < this.alunos.tamanho(); i++)
		{
			Aluno aluno = this.alunos.localizarBloco(i).valor;

			if (aluno.getMatricula().equals(matricula))
			{
				return true;
			}

		}

		return false;

	}

	public void printTurma()
	{
		System.out.println("Codigo: " + this.codigo);
		System.out.println("Disciplina: " + this.disciplina.nome);

		System.out.println("Alunos:");

		if (this.alunos.isVazia())
		{
			System.out.println("Nenhum aluno cadastrado");
			return;
		
		}

		for (int i = 0; i < this.alunos.tamanho(); i++)
		{
			Aluno aluno = this.alunos.localizarBloco(i).valor;

			System.out.println("Nome: " + aluno.getNome() + " Matricula: " + aluno.getMatricula());

		}

	}



}
