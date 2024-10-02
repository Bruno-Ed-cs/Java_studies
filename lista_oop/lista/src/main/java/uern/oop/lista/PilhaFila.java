package uern.oop.lista;

public class PilhaFila
{

    private Fila fila = new Fila();

    public void push(int valor)
    {
        this.fila.push(valor);

    }

    public void pop()
    {

        this.invert();

        fila.pop();

        this.invert();

    }

    public Bloco topo()
    {
        Bloco topo;

        this.invert();
        topo = this.fila.fim();
        this.invert();

        return topo;
    }

    public void print()
    {
        this.fila.lista.print();
    }

    private void invert()
    {

        Lista invertida = this.fila.lista.inverte();

        this.fila.lista = invertida;

    }

}
