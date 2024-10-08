package uern.oop.lista;

public class Lista implements List {

	Bloco inicio = null;

	public Bloco addElemento(int valor, boolean posicaoIncio) {
		Bloco novo;

		if (posicaoIncio == true) {
			novo = this.addElementoInicio(valor);
		} else {
			novo = this.addElementoFim(valor);
		}

		return novo;
	}

	public Bloco addElemento(int valor, int pos) {
		Bloco novo = new Bloco(valor);
		Bloco aux = this.inicio;

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
				aux.prox = new Bloco();
			}

			if (aux.prox != null) {
				aux = aux.prox;
			}
		}

		return novo;
	}

	public Bloco removerElementoFim() {
		Bloco result = null;

		if (this.isVazia()) {
			return result;
		}

		if (this.tamanho() == 1) {
			//this.inicio = null;
			result = this.removerElementoInicio();
		} else {
			Bloco target = this.localizarBloco(this.tamanho() -2);

			result = target.prox;
			target.prox = null;

			return result;
		}

		return result;
	}

	public Bloco removerElementoInicio() {
		Bloco result = this.inicio;
		if (!this.isVazia()) {
			this.inicio = this.inicio.prox;
		}

		return result;
	}

	public boolean isVazia() {
		return this.inicio == null;
	}

	private Bloco addElementoInicio(int valor) {
		Bloco novo = new Bloco(valor);

		novo.prox = this.inicio;
		this.inicio = novo;

		return novo;
	}

	private Bloco addElementoFim(int valor) {
		Bloco novo = null;

		Bloco fim = this.localizarBloco(this.tamanho() -1);

		if (fim == null) {
			novo = this.addElementoInicio(valor);
		} else {
			novo = new Bloco();
			novo.valor = valor;

			fim.prox = novo;
		}

		return novo;
	}

	public Bloco localizarBloco(int pos) {
		Bloco aux = this.inicio;
		for (int i = 0; i < pos && aux != null; i++) {
			aux = aux.prox;
		}
		return aux;
	}

	public int tamanho() {
		Bloco aux = this.inicio;
		int count = 0;

		if (aux == null)
		{
			return 0;
		}	

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

	public Lista clone() {
		Lista saida = new Lista();

		saida.inicio = clone(this.inicio);

		return saida;
	}

	public void print() {
		Bloco aux = this.inicio;
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

	public Lista inverte() {
		Lista invertida = new Lista();

		for (int i = this.tamanho() -1; i >= 0; i--) {
			invertida.addElementoFim(this.localizarBloco(i).valor);
		}

		return invertida;
	}

	private static Bloco clone(Bloco bloco) {
		if (bloco.prox != null) {
			Bloco aux = new Bloco();
			aux.valor = bloco.valor;
			aux.prox = clone(bloco.prox);

			return aux;
		} else {
			return bloco;
		}
	}

	@Override
	public Bloco removerElemento() {
		this.removerElementoInicio();
		return this.localizarBloco(this.tamanho() - 1);
	}

	public Bloco removerElemento(int pos)
	{

		if (this.isVazia())
		{
			return null;
		}

		Bloco aux;
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

		Bloco target = this.localizarBloco(pos);

		aux.prox = target.prox;

		return aux;

	}

	public Lista concatena(Lista l2)
	{
		Lista novo = new Lista();
		Bloco aux = this.inicio;

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
			Bloco aux = this.localizarBloco(i);

			for (int j = i +1; j < this.tamanho(); j++)
			{
				Bloco ajud = this.localizarBloco(j);

				if (aux.valor == ajud.valor)
				{
					this.removerElemento(j);
				}
			}


		}

	}

	public Lista localizarMaior(int valor)
	{
		Bloco aux;
		Lista maiores = new Lista();

		for (int i = 0; i < this.tamanho(); i++)
		{
			aux = this.localizarBloco(i);
			if (aux.valor > valor)
			{
				maiores.addElementoInicio(aux.valor);
			}

		}

		return maiores;
	}

}

