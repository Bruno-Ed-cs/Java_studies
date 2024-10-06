package uern.oop.lista;

public class BlocoG<T>
{

	public T valor;
	public BlocoG prox;

	public BlocoG() {
		this.valor = null;
		this.prox = null;
	}

	public BlocoG(T valor) {
		this.valor = (T) valor;
	}
}
