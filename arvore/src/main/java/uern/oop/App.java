package uern.oop;
import uern.oop.singles.Singleton;
import uern.oop.btree.*;
import uern.oop.lista.*;

/**
 * Hello world!
 */
public class App 
{
    public static void main(String[] args) 
{
        System.out.println("Hello World!");

        Singleton single = Singleton.getInstace();

        System.out.println(single.test);

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
    }
}
