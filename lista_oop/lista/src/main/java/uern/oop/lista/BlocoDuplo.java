package uern.oop.lista;

public class BlocoDuplo extends Bloco {

	public int valor;
	BlocoDuplo prox = null;
	BlocoDuplo prev = null;

	public BlocoDuplo() {
		this.valor = 0;
	}

	public BlocoDuplo(int valor) {
		this.valor = valor;
	}
}
