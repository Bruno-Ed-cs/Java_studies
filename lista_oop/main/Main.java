package main;
import lista.*;

/**
 * Main
 */
public class Main {

	public static void main(String[] args)
	{
		Lista list = new Lista();
		Pilha pilha = new Pilha();
		FilaPilha fila = new FilaPilha();
		PilhaFila stack = new PilhaFila();


		for (int i = 0; i < 10; i++)
		{
			fila.push(i);
			stack.push(i);
			list.addElemento(i, true);
		}

		pilha.push(20);
		pilha.push(33);
		pilha.push(69);


		fila.print();
		fila.pop();
		fila.print();

		stack.print();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.print();

		System.out.println(fila.end());

		System.out.println(pilha.topo().valor);

		System.out.println("syke");

		pilha.print();
		System.out.println(pilha.lista.tamanho());

		Fila queue = pilha.getFila();
		Pilha overflow = queue.getPilha();

		queue.print();
		queue.pop();
		queue.print();

		overflow.print();
		overflow.pop();
		overflow.print();

		list.print();
		Lista numerosi = list.inverte();
		numerosi.print();

	}
	
}
