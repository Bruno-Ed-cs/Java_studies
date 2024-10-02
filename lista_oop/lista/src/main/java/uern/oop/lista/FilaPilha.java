package uern.oop.lista;

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
        this.pilha.lista.print();
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
