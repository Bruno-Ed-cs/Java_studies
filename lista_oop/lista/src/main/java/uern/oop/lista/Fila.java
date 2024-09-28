package uern.oop.lista;

public class Fila {

    Lista lista = new Lista();

    public void push(int valor)
    {

        this.lista.addElemento(valor, true);

    }

    public void pop()
    {

        this.lista.removerElementoFim();

    }

    public Bloco fim()
    {

        return lista.localizarBloco(lista.tamanho() -1);
    }

    public Pilha getPilha()
    {
        Pilha pilha= new Pilha();

        pilha.lista = this.lista.copia();

        return pilha;

    }

    public void print()
    {
        System.out.print("Fila = ");

        for (int i = 1; i <= this.lista.tamanho(); i++)
        {
            System.out.print(this.lista.localizarBloco(i).valor + " ");
        }

        System.out.print("\n");
    }


}
