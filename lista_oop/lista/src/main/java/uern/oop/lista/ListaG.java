package uern.oop.lista;

public class ListaG<T> {

	BlocoG<T> inicio = null;

	public BlocoG<T> addElemento(T valor, boolean posicaoIncio) {
		BlocoG<T> novo;

		if (posicaoIncio == true) {
			novo = this.addElementoInicio(valor);
		} else {
			novo = this.addElementoFim(valor);
		}

		return novo;
	}

	public BlocoG<T> addElemento(T valor, int pos) {
		BlocoG<T> novo = new BlocoG<T>(valor);
		BlocoG<T> aux = this.inicio;

		if (pos <= 0) {
			this.addElementoInicio(valor);
			return novo;
		}

		for (int i = 0; i <= pos; i++) {
			if (i == pos - 1) {
				novo.prox = aux.prox;
				aux.prox = novo;
				break;
			}

			if (aux.prox == null) {
				aux.prox = new BlocoG<T>();
			}

			if (aux.prox != null) {
				aux = aux.prox;
			}
		}

		return novo;
	}

	public BlocoG<T> removerElementoFim() {
		BlocoG<T> result = null;

		if (this.isVazia()) {
			return result;
		}

		if (this.tamanho() == 1) {
			result = this.removerElementoInicio();

		} else {
			BlocoG<T> target = this.localizarBloco(this.tamanho() -2);

			result = target.prox;
			target.prox = null;
		}

		return result;
	}

	public BlocoG<T> removerElementoInicio() {
		BlocoG<T> result = this.inicio;
		if (!this.isVazia()) {
			this.inicio = this.inicio.prox;
		}

		return result;
	}

	public boolean isVazia() {
		return this.inicio == null;
	}

	private BlocoG<T> addElementoInicio(T valor) {
		BlocoG<T> novo = new BlocoG<T>(valor);

		novo.prox = this.inicio;
		this.inicio = novo;

		return novo;
	}

	private BlocoG<T> addElementoFim(T valor) {
		BlocoG<T> novo = null;

		BlocoG<T> fim = this.localizarBloco(this.tamanho() -1);

		if (fim == null) {
			novo = this.addElementoInicio(valor);
		} else {
			novo = new BlocoG<T>();
			novo.valor = valor;

			fim.prox = novo;
		}

		return novo;
	}

	public BlocoG<T> localizarBloco(int pos) {
		BlocoG<T> aux = this.inicio;

		for (int i = 0; i < pos; i++)
		{
			if (aux.prox != null)
			{
				aux = aux.prox;
			}

		}
		return aux;
	}

	public int tamanho() {
		BlocoG<T> aux = this.inicio;
		int count = 0;

		while (true)
		{
			count++;

			if (aux != null && aux.prox != null)
			{
				aux = aux.prox;
			} else
			{
				break;
			}
		}

		return count;
	}

	public ListaG<T> clone() {
		ListaG<T> saida = new ListaG<T>();

		saida.inicio = clone(this.inicio);

		return saida;
	}

	public void print() {
		BlocoG<T> aux = this.inicio;
		System.out.print("Lista = { ");

		for (int i = 0; i < this.tamanho(); i++) {

			System.out.print(aux.valor + " ");
			if (aux.prox != null)
			{
				aux = aux.prox;
			} else
			{
				break;
			}
		}

		System.out.print("}\n");
	}

	public ListaG<T> inverte() {
		ListaG<T> invertida = new ListaG<T>();

		for (int i = this.tamanho() -1; i >= 0; i--) {
			invertida.addElementoFim(this.localizarBloco(i).valor);
		}

		return invertida;
	}

	private static <T> BlocoG<T> clone(BlocoG<T> bloco) {
		if (bloco.prox != null) {
			BlocoG<T> aux = new BlocoG<T>();
			aux.valor = bloco.valor;
			aux.prox = clone(bloco.prox);

			return aux;
		} else {
			return bloco;
		}
	}

	public BlocoG<T> removerElemento() {
		return this.removerElementoInicio();
	}

	public BlocoG<T> removerElemento(int pos)
	{

		BlocoG<T> aux;
		if (pos <= 0)
		{
			aux = this.removerElementoInicio();
			return aux;
		} else if (pos == this.tamanho() -1)
		{
			aux = this.removerElementoFim();
			return aux;
		}

		aux = this.localizarBloco(pos -1);

		BlocoG<T> target = this.localizarBloco(pos);

		aux.prox = target.prox;

		return target;

	}

	public ListaG<T> concatena(ListaG<T> l2)
	{
		ListaG<T> novo = new ListaG<T>();
		BlocoG<T> aux = this.inicio;

		while (aux.prox != null)
		{
			novo.addElemento(aux.valor, false);
			aux = aux.prox;
		}
		novo.addElemento(aux.valor, false);

		aux = l2.inicio;

		while (aux.prox != null)
		{
			novo.addElemento(aux.valor, false);
			aux = aux.prox;
		}
		novo.addElemento(aux.valor, false);

		return novo;
	}

	public void removeDuplicados()
	{

		for (int i = 0; i < this.tamanho(); i++)
		{
			BlocoG<T> aux = this.localizarBloco(i);

			for (int j = i +1; j < this.tamanho(); j++)
			{
				BlocoG<T> ajud = this.localizarBloco(j);

				if (aux.valor == ajud.valor)
				{
					this.removerElemento(j);
				}
			}


		}

	}


}

