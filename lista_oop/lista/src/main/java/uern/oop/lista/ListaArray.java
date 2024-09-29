package uern.oop.lista;

public class ListaArray implements List {

	Bloco[] array = {};

	@Override
	public Bloco addElemento(int value, boolean posicaoInicio) {
		Bloco novo = new Bloco(value);
		if (posicaoInicio) {
			this.resize(this.tamanho() + 1);
			for (int i = this.tamanho() - 1; i > 0; i--) {
				this.array[i] = this.array[i - 1];
			}
			novo.prox = this.array[0];
			this.array[0] = novo;
		} else {
			this.resize(this.tamanho() + 1);

			this.array[this.tamanho() - 2].prox = novo;
			this.array[this.tamanho() - 1] = novo;
		}

		return novo;
	}

	@Override
	public Bloco removerElemento() {
		Bloco deleted = this.array[0];
		this.array[0] = null;

		for (int i = 0; i < this.tamanho() - 1; i++) {
			this.array[i] = this.array[i + 1];
		}

		this.resize(this.tamanho() - 1);
		return deleted;
	}

	@Override
	public void print() {
		System.out.print("ListaArray = { ");
		for (int i = 0; i < this.tamanho(); i++) {
			System.out.print(this.array[i].valor + " ");
		}
		System.out.print("}\n");
	}

	@Override
	public Bloco localizarBloco(int index) {
		return this.array[index];
	}

	@Override
	public int tamanho() {
		return this.array.length;
	}

	private void resize(int size) {
		Bloco[] novo = new Bloco[size];

		for (int i = 0; i < novo.length; i++) {
			if (i < this.array.length) {
				novo[i] = this.array[i];
			} else {
				novo[i] = new Bloco();
			}
		}

		novo[novo.length - 1].prox = null;

		this.array = novo;
	}
}
