package uern.oop.lista;

public class ListaDupla implements List {

	public BlocoDuplo inicio;

	@Override
	public BlocoDuplo addElemento(int valor, boolean posicaoInicio) {
		BlocoDuplo novo = new BlocoDuplo(valor);

		if (posicaoInicio) {
			novo.prox = this.inicio;
			if (this.inicio != null) {
				this.inicio.prev = novo;
			}
			this.inicio = novo;
		} else {
			BlocoDuplo aux = this.inicio;

			while (aux.prox != null) {
				aux = aux.prox;
			}
			//			System.out.println(novo.valor);
			novo.prev = aux;
			aux.prox = novo;
			//			System.out.println(novo.valor);
		}

		return novo;
	}

	@Override
	public BlocoDuplo removerElemento() {
		this.inicio = this.inicio.prox;

		if (this.inicio != null) {
			this.inicio.prev = null;
		}

		return this.inicio;
	}

	@Override
	public int tamanho() {
		int count = 0;
		if (this.inicio == null) {
			return count;
		}

		BlocoDuplo aux = this.inicio;

		while (aux.prox != null) {
			count++;
			aux = aux.prox;
		}

		return count;
	}

	@Override
	public void print() {
		BlocoDuplo aux = this.inicio;

		System.out.print("Lista dupla = { ");
		while (aux != null) {
			System.out.print(aux.valor + " ");
			if (aux.prox == null) {
				break;
			}
			aux = aux.prox;
		}

		System.out.print("} \n");
	}

	@Override
	public BlocoDuplo localizarBloco(int index) {
		BlocoDuplo aux = this.inicio;

		if (aux == null) {
			return null;
		}

		if (index <= 0) {
			return aux;
		}

		for (int i = 0; i <= index; i++) {
			if (aux.prox != null) {
				aux = aux.prox;
			}
		}

		return aux;
	}
}
