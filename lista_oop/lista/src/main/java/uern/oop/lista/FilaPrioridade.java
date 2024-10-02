package uern.oop.lista;

public class FilaPrioridade extends Lista
{

    BlocoP inicio;

    public void push(int value, int prioridade)
    {
        BlocoP novo = new BlocoP(value, prioridade);

        if (this.inicio == null)
        {
            novo.prox = this.inicio;
            this.inicio = novo;
            return;
        }

        BlocoP aux = this.inicio;

        if (novo.prioridade < aux.prioridade)
        {
            novo.prox = aux;
            this.inicio = novo;
            return;
        }

        while (aux.prox != null)
        {
            if (aux.prox.prioridade > novo.prioridade)
            {
                novo.prox = aux.prox;
                aux.prox = novo;
                return;
            }
            aux = aux.prox;
        }

        if (aux.prox == null)
        {
            aux.prox = novo;
        }

        return;

    }


    private void bSort()
    {
        BlocoP aux1 = this.inicio;
        BlocoP aux2 = aux1;
        while (true)
        {

            if (aux1.prox != null)
            {
                aux2 = aux1.prox;
            }

            while (true)
            {

                if (aux1.prioridade > aux2.prioridade)
                {
                    BlocoP temp = new BlocoP(aux1.valor, aux1.prioridade);

                    aux1.prioridade = aux2.prioridade;
                    aux1.valor = aux2.valor;

                    aux2.prioridade = temp.prioridade;
                    aux2.valor = temp.valor;

                }

                if (aux2.prox != null)
                {
                    aux2 = aux2.prox;
                } else
                {
                    break;
                }
            }

            if (aux1.prox != null)
            {
                aux1 = aux1.prox;

            } else
            {
                break;
            }
        }
    }

    public BlocoP pop()
    {
        BlocoP aux = this.inicio;

        if (aux.prox != null)
        {
            this.inicio = aux.prox;
        } else
        {
            this.inicio = null;
        }

        return aux;
    }

    private static int tamanho(int size, BlocoP bloco) {
        if (bloco.prox != null) {
            return FilaPrioridade.tamanho(size +1, bloco.prox);
        }

        return size;
    }

    public void print()
    {
        BlocoP aux = this.inicio;

        System.out.print("{ ");

        while (aux.prox != null)
        {

            System.out.print("(" + aux.valor + " P: " + aux.prioridade + ") " );
            aux = aux.prox;

        }

        System.out.print("(" + aux.valor + " P: " + aux.prioridade + ") " );

        System.out.print("}\n");
    }

}
