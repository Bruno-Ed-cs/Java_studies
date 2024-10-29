package uern.oop.lista;

interface List {
	public Bloco addElemento(int value, boolean posicaoInicio);

	public Bloco removerElemento();

	public void print();

	public Bloco localizarBloco(int index);

	public int tamanho();
}
