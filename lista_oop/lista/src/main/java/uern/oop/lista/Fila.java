package uern.oop.lista;

public class Fila {

    Lista lista = new Lista();

    public void push(int valor)
    {

        this.lista.addElemento(valor, true);

    }

    public Bloco pop()
    {

        return this.lista.removerElementoFim();

    }

    public Bloco fim()
    {

        Bloco fim = lista.localizarBloco(lista.tamanho() -1);
        return fim;
    }

    public Bloco inicio()
    {
        return this.lista.inicio;
    }

    public Pilha getPilha()
    {
        Pilha pilha= new Pilha();

        pilha.lista = this.lista.clone();

        return pilha;

    }

    public void print()
    {
        System.out.print("Fila = ");

        for (int i = 0; i < this.lista.tamanho(); i++)
        {
            System.out.print(this.lista.localizarBloco(i).valor + " ");
        }

        System.out.print("\n");
    }


}
