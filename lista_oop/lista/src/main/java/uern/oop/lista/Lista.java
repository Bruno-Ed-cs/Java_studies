package uern.oop.lista;

public class Lista {

    Bloco inicio;

    public Bloco addElemento(int valor,boolean posicaoIncio) {

        Bloco novo = null;

        if(posicaoIncio == true) {

            novo = this.addElementoInicio(valor);

        } else {

            novo = this.addElementoFim(valor);
        }

        return novo;
    }


    public Bloco removerElementoFim() {

        Bloco result = null;

        if(this.isVazia()) {
            return result;
        }

        if(this.tamanho() == 1) {
            //this.inicio = null;
            result = this.removerElementoInicio();
        } else {

            Bloco target = this.localizarBloco(this.tamanho()-1);
    
            result = target.prox;
            target.prox = null;
        }

        return result;
    }

    public Bloco removerElementoInicio() {

        Bloco result = this.inicio;
        if(!this.isVazia()) {

            this.inicio = this.inicio.prox;
        }

        return result;
    }

    public boolean isVazia() {

        return this.inicio == null;
    }

    private Bloco addElementoInicio(int valor) {

        Bloco novo = new Bloco();
        novo.valor = valor;
        
        novo.prox = this.inicio;
        this.inicio = novo;

        return novo;
    }

    private Bloco addElementoFim(int valor) {

        Bloco novo = null;

        Bloco fim = this.localizarBloco(this.tamanho());

        if(fim == null) {

            novo = this.addElementoInicio(valor);
        } else {

            novo = new Bloco();
            novo.valor = valor;
    
            fim.prox = novo; 
        }

        return novo;
    }

    public Bloco localizarBloco(int pos) {

        Bloco aux = this.inicio;
        int cont =0;

        while(aux!= null && cont < pos -1) {

            cont++;
            aux = aux.prox;
        }

        return aux;
    }

    public int tamanho() {

        Bloco aux = this.inicio;
        int cont =0;

        while(aux!= null) {

            cont++;
            aux = aux.prox;
        }

        return cont;
    }

    public Lista copia()
    {
        Lista saida = new Lista();

        saida.inicio = copia(this.inicio);

        return saida;

    }

    public void print()
    {
        System.out.print("Lista= ");

        for (int i = 1; i <= this.tamanho(); i++)
        {
            System.out.print(this.localizarBloco(i).valor + " ");
        }

        System.out.print("\n");
    }

    public Lista inverte()
    {
        Lista invertida = new Lista();

        for (int i = this.tamanho(); i > 0; i--)
        {
            invertida.addElementoFim(this.localizarBloco(i).valor);
        }

        return invertida;

    }

    private static Bloco copia(Bloco bloco)
    {

        if (bloco.prox != null)
        {
            Bloco aux = new Bloco();
            aux.valor = bloco.valor;
            aux.prox = copia(bloco.prox);

            return aux;

        } else
        {
            return bloco;
        }
    }

}
