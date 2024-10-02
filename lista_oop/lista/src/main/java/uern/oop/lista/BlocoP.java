package uern.oop.lista;

public class BlocoP extends Bloco
{
    public int prioridade;
    public BlocoP prox;

    public BlocoP(int value, int prioridade)
    {
        this.prioridade = prioridade;
        this.prox = null;
        this.valor = value;
    }


}
