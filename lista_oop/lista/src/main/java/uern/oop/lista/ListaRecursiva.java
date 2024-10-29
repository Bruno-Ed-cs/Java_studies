package uern.oop.lista;

public class ListaRecursiva extends Lista 
{


	@Override
	public Bloco localizarBloco(int pos) 
	{
		return ListaRecursiva.localizar(pos, this.inicio, 0);
	}

	@Override
	public int tamanho() 
	{
		if (this.inicio == null)
		{
			return 0;
		} else
		{
			return ListaRecursiva.tamanho(1, this.inicio);
		}
	}

	private static Bloco localizar(int pos, Bloco bloco, int atual) 
	{
		if (atual != pos) {
			if (bloco.prox != null) {
				return ListaRecursiva.localizar(pos, bloco.prox, atual +1);
			} else {
				return bloco;
			}
		}

		return bloco;
	}

	private static int tamanho(int size, Bloco bloco) 
	{
		if (bloco.prox != null) {
			return ListaRecursiva.tamanho(size +1, bloco.prox);
		}

		return size;
	}
}
