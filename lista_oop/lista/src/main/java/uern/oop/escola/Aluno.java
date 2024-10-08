package uern.oop.escola;

import uern.oop.lista.ListaG;

public class Aluno
{
	private String nome;
	private Integer matricula;
	private Disciplina disciplina;
	private ListaG<Double> notas = new ListaG<Double>();

	public Aluno(String nome, Integer matricula, String disciplina)
	{
		this.nome = nome;

		this.matricula = matricula;

		this.disciplina = new Disciplina(disciplina);


	}

	
	public String getNome() {
		return nome;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public ListaG<Double> getNotas() {
		return notas;
	}

	public void addNota(Double nota)
	{

		this.notas.addElemento(nota, false);

	}

	public void removeNota(int pos)
	{

		this.notas.removerElemento(pos);

	}

	public void printNotas()
	{
		if (this.notas.isVazia())
		{
			System.out.println("Este aluno nao possui notas cadrastadas");
			return;
		}

		System.out.println("Aluno: " + this.nome + "\n" + "Matricula: " + this.matricula);

		for (int i = 0; i < this.notas.tamanho(); i++)
		{
			System.out.println("n" + i +": " + this.notas.localizarBloco(i).valor);
		}

	}



}
