package uern.oop.lista;


public class Pilha {
    
    public Lista lista = new Lista();

    public void push(int valor) {

        this.lista.addElemento(valor,true);

    }

    public Bloco pop() {

        return  this.lista.removerElementoInicio();
    }

    public Bloco topo()
    {
        return this.lista.localizarBloco(0);
    }

    public Fila getFila()
    {
        Fila fila = new Fila();

        fila.lista = this.lista.clone();

        return fila;

    }

    public void invert()
    {
        if (!this.lista.isVazia())
        {
            int i = this.topo().valor;
            this.pop();

            invert();

            this.push(i);

        }
    }

    public void print()
    {
        System.out.print("Pilha = ");

        for (int i = 0; i < this.lista.tamanho(); i++)
        {
            System.out.print(this.lista.localizarBloco(i).valor + " ");
        }

        System.out.print("\n");
    }
}
