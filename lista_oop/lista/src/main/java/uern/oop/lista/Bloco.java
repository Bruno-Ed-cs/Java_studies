package uern.oop.lista;

public class Bloco{

	public int valor;
	public Bloco prox;

	public Bloco() {
		this.valor = 0;
		this.prox = null;
	}

	public Bloco(int valor) {
		this.valor = valor;
	}
}
