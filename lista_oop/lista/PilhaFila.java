package lista;

public class PilhaFila
{

    private Fila fila= new Fila();

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
        System.out.print("Pilha = ");

        for (int i = 1; i < fila.lista.tamanho(); i++)
        {
            System.out.print(fila.lista.localizarBloco(i).valor + " ");
        }

        System.out.print("\n");
    }

    private void invert()
    {
        if (!this.fila.lista.isVazia())
        {
            int value = this.fila.fim().valor;
            this.fila.pop();

            invert();

            this.fila.push(value);
        } else
        {
            return;
        }

    }

}
