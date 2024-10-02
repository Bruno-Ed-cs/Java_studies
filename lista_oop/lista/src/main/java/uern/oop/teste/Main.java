package uern.oop.teste;

import uern.oop.lista.*;

public class Main {

	public static void main(String[] args) {
		Lista list = new Lista();
		Pilha pilha = new Pilha();
		FilaPilha fila = new FilaPilha();
		PilhaFila stack = new PilhaFila();

		for (int i = 0; i < 10; i++) {
			fila.push(i);
			stack.push(i);
			list.addElemento(i, true);
		}

		pilha.push(20);
		pilha.push(33);
		pilha.push(69);
		pilha.push(198);
		pilha.push(88);
		pilha.pop();
		pilha.pop();

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

		list.removerElementoFim();

		list.print();
		numerosi.print();

		overflow.print();
		System.out.println(overflow);

		System.out.println(
			"teste de add in pos --------------------------------------------------"
		);

		Lista vazio = new Lista();

		for (int i = 0; i < 6; i++) {
			vazio.addElemento(i, true);
		}

		vazio.print();
		vazio.addElemento(420, 3);
		vazio.print();

		vazio.addElemento(120, 0);
		vazio.print();

		vazio.addElemento(69, vazio.tamanho());
		vazio.print();

		vazio.addElemento(1000, 10);
		vazio.print();


		System.out.println("bloco 0 = " + vazio.localizarBloco(0).valor);
		System.out.println("bloco 4 = " + vazio.localizarBloco(4).valor);
		System.out.println("bloco fim = " + vazio.localizarBloco(vazio.tamanho() -1).valor);
		System.out.println("bloco alem = " + vazio.localizarBloco(vazio.tamanho()).valor);

		System.out.println(
			"testes de lista dupla ========================================================="
		);

		ListaDupla par = new ListaDupla();

		par.print();
		for (int i = 0; i < 10; i++) {
			par.addElemento(i, true);
		}
		par.addElemento(99, true);
		par.print();
		par.addElemento(88, true);
		par.print();
		par.addElemento(77, false);
		par.addElemento(77, false);
		par.addElemento(74, false);
		par.print();

		System.out.println(par.tamanho());

		par.removerElemento();
		par.print();

		System.out.println(par.tamanho());
		System.out.println(par.localizarBloco(9).valor);
		System.out.println(par.localizarBloco(0).valor);
		System.out.println(par.localizarBloco(par.tamanho() - 1).valor);

		while (par.inicio != null) {
			par.removerElemento();
		}
		par.print();
		System.out.println(par.tamanho());

		System.out.println(
			"Teste de arrayLista ====================================================================================="
		);

		ListaArray lArr = new ListaArray();

		lArr.print();
		lArr.addElemento(34, true);
		lArr.print();
		lArr.addElemento(69, false);
		lArr.print();

		for (int i = 0; i < 15; i++) {
			lArr.addElemento(i, true);
		}

		lArr.print();

		lArr.removerElemento();
		lArr.print();

		System.out.println("Teste de recursao ===============================================================================================");

		ListaRecursiva rec = new ListaRecursiva();

		for (int i = 0; i < 20; i++)
		{
			rec.addElemento(i, true);

		}

		rec.print();

		System.out.println("tamnho = " + rec.tamanho());

		System.out.println("localizar 4 " + rec.localizarBloco(4).valor);


		System.out.println("Teste de concatenação==================================================================================================");

		Lista l1 = new Lista();
		Lista l2 = new Lista();

		for (int i = 0; i < 10; i++)
		{
			l1.addElemento(i, true);
			l2.addElemento(i, true);
		}

		l1.print();
		l2.print();

		Lista nova = l1.concatena(l2);
		nova.print();


		System.out.println("Teste rdupli e remover ele ==============================================================================================");

		Lista dupli = new Lista();
		for (int i = 0; i < 10; i++)
		{

			dupli.addElemento(i, true);
		}


		dupli.addElemento(1, true);
		dupli.addElemento(6, true);
		dupli.addElemento(9, true);

		dupli.print();

		dupli.print();

		dupli.removeDuplicados();

		dupli.print();

		System.out.println("Teste de clone ==================================================================================================================");

		dupli.print();
		Lista clone = dupli.clone();

		clone.print();

		System.out.println("Teste de prioridade ==============================================================================================================");

		FilaPrioridade pp = new FilaPrioridade();


		pp.push(1, 6);
		pp.push(2, 2);
		pp.push(3, 2);
		pp.push(4, 9);
		pp.push(5,1);

		pp.print();

		System.out.println(pp.pop().valor);

		pp.print();
		pp.push(89, -1);
		pp.push(80, 100);
		pp.print();

		System.out.println(pp.pop().valor);

		System.out.println("Teste maiores =========================================================================================");

		dupli.print();

		dupli.addElemento(11, true);

		Lista major = dupli.localizarMaior(4);
		dupli.print();
		major.print();
	}
}
