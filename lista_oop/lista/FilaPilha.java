package lista;

public class FilaPilha
{

    private Pilha pilha = new Pilha();

    public void push(int valor)
    {
        pilha.push(valor);

    }

    public void pop()
    {

        invert();

        pilha.pop();

        invert();

    }

    public int end()
    {
        return pilha.topo().valor;
    }

    public void print()
    {
        System.out.print("Fila = ");

        for (int i = 1; i < pilha.lista.tamanho(); i++)
        {
            System.out.print(pilha.lista.localizarBloco(i).valor + " ");
        }

        System.out.print("\n");
    }

    private void invert()
    {
        Pilha aux = new Pilha();

        while (!pilha.lista.isVazia())
        {
            aux.push(pilha.topo().valor);
            pilha.pop();

        }

        while (!aux.lista.isVazia())
        {
            pilha.push(aux.topo().valor);
            aux.pop();
        }

    }
}
