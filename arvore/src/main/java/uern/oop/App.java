package uern.oop;
import uern.oop.singles.Singleton;

import java.net.SocketTimeoutException;

import uern.oop.btree.*;
import uern.oop.lista.*;

/**
 * Hello world!
 */
public class App 
{
    public static void main(String[] args) {

        System.out.println("Hello World!");

        Singleton single = Singleton.getInstace();

        System.out.println(Singleton.getTest());

        BTree flora = new BTree(5);

        Lista numeros = new Lista();

        numeros.addElemento(1, true);
        numeros.addElemento(2, true);        
        numeros.addElemento(3, true);        
        numeros.addElemento(4, true);        
        numeros.addElemento(5, true);        
        numeros.addElemento(6, true);

        numeros.print();

        flora.addBlind(30);
        flora.addBlind(40);
        flora.addBlind(50);
        flora.addBlind(10);
        flora.addBlind(20);
        flora.addBlind(100);
        flora.print();
        flora.printPre();
        flora.printPos();
        flora.printSim();

        flora.addNo(true, 69, flora.root);
        flora.print();
        flora.printPre();


        System.out.println(flora.localizarNoIncompleto());

        flora.print();

        flora.addLista(numeros);

        flora.print();

        System.out.println(flora.getHeight());
        System.out.println(flora.numNo());
        Integer arr[] = {69, 4, 6, 10};
        ListaG<Node> querry = flora.getArrayNodes(arr);

        querry.print();

        querry = flora.getLeaves();

        querry.print();

        System.out.println(querry.localizarBloco(0).valor.value);

        flora.removeNode(querry.localizarBloco(0).valor);
        flora.print();

        flora.removeNode(flora.root);

        flora.print();

        flora.addLista(numeros);
        flora.print();

        BTree fauna = new BTree(20);

        fauna.addLista(numeros);

        fauna.print();

        flora.concat(fauna, flora.root, true);

        flora.print();

        flora.removeSub(flora.root, false);

        flora.print();
    }
}
