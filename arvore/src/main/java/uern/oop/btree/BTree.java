package uern.oop.btree;
import java.util.Random;

import uern.oop.lista.*;

public class BTree {

    public Node root;

    public BTree() {

        this.root = new Node();

    }

    public BTree(Integer initial) {


        this.root = new Node(initial);
    }


    public void addBlind(Integer value) {


        BTree.addBlind(value, this.root);

    }

    public Integer getHeight() {

        return BTree.getHeight(this.root);
        
    }

    private static Integer getHeight(Node no) {

        if (no == null) { 

            return 0;
        }

        Integer dir = 0;
        Integer esq = 0;

        if (no.left != null) {

            esq = BTree.getHeight(no.left);
        }

        if (no.right != null) {

            dir = BTree.getHeight(no.right);
        }

        if (dir > esq) {

            return dir +1;
        } else {

            return esq +1;
        }


        
    }


    private static int addBlind(Integer value, Node target) {

        if (target.left == null) {

            target.left = new Node(value);
            return 0;
        }

        if (target.right == null) {

            target.right = new Node(value);
            return 0;
        }


        if (BTree.addBlind(value, target.right) == 1 ) {
        

            if (BTree.addBlind(value, target.left) == 1) {

                return 1;


            }

            return 1;
        }

        return 0;
    }

    public void addNo(Boolean dir, Integer valor, Node no_reff) {

        Node novo = new Node(valor);

        if (dir) {

            no_reff.right = novo;

        } else {

            no_reff.left = novo;

        }

    }


    public Node localizarNoIncompleto() {

        return getIncomplete(this.root);

    }

    private static Node getIncomplete(Node no) {

        if (no.left == null || no.right == null) {

            return no;

        } else {

            Random random = new Random();

            Boolean next = random.nextBoolean();

            if (next) {

                return getIncomplete(no.left);

            } else {
                  return getIncomplete(no.right);
            }



        }

    }

    public void print() {

        printTree(this.root, "", true);

    }

    private static void printTree(Node node, String indent, Boolean isLeft) {

        if (node == null) {
            return;
        }

        String buff;

        // Right child first, for a top-down visualization
        if (isLeft)  {
            buff = "│   ";
        } else {
            buff = "    ";
        }

        printTree(node.right, indent + buff, false);

        // Print current node
        if (isLeft)  {
            buff = "└── ";
        } else {
            buff = "┌── ";
        }
        System.out.println(indent + buff + node.value);

        // Left child next
        if (isLeft)  {
            buff = "    ";
        } else {
            buff = "│   ";
        }

        printTree(node.left, indent + buff, true);
    }

    public void addLista(Lista list){

        int i = 0;
        if (this.root == null) {

            this.root = new Node(list.localizarBloco(0).valor);
            i = 1;
        }

        for (; i < list.tamanho(); i++) {

            Node node = this.localizarNoIncompleto();

            if (node.left == null) {

                this.addNo(false, list.localizarBloco(i).valor, node);

            } else {

                 this.addNo(true, list.localizarBloco(i).valor, node);                 
            }



        }

    }

    public void printPre() {

        System.out.println("Pre order =");
        BTree.printPre(this.root);
        System.out.println();
        
    }

    private static void printPre(Node node) {


        if (node != null){
            System.out.printf("%d ",node.value);
        }

        if (node.left != null) {

            BTree.printPre(node.left);

        }

        if (node.right != null) {


            BTree.printPre(node.right);

        }

    }

    public void printPos() {

        System.out.println("Pos order =");
        BTree.printPos(this.root);
        System.out.println();
        
    }

    private static void printPos(Node node) {

        if (node.left != null) {

            BTree.printPos(node.left);

        }

        if (node.right != null) {


            BTree.printPos(node.right);

        }

        if (node != null){
            System.out.printf("%d ",node.value);
        }


    }

    public void printSim() {

        System.out.println("Simetry order =");
        BTree.printSim(this.root);
        System.out.println();
        
    }

    private static void printSim(Node node) {

        if (node.left != null) {

            BTree.printSim(node.left);

        }

        if (node != null){
            System.out.printf("%d ",node.value);
        }


        if (node.right != null) {


            BTree.printSim(node.right);

        }

    }

    public Integer numNo() {

        return BTree.numNo(this.root);
        
    }

    private static Integer numNo(Node no) {

        if (no == null) {

            return 0;
        }

        Integer esq = BTree.numNo(no.left);
        Integer dir = BTree.numNo(no.right);

        return dir + esq + 1;
    }

    public ListaG<Node> getArrayNodes(Integer valores[]) {

        ListaG<Node> list = new ListaG<Node>();

        BTree.getArrayNodes(this.root, list, valores);

        return list;
        
    }

    private static void getArrayNodes(Node no, ListaG<Node> lista, Integer valores[]) {

        for (int i = 0; i < valores.length; i++) {

            if (valores[i] == no.value) {

                lista.addElemento(no , true);
            }
        }

        if (no.left != null) {

            BTree.getArrayNodes(no.left, lista, valores);
        }

        if (no.right != null) {

            BTree.getArrayNodes(no.right, lista, valores);
        }
        
    }

    public ListaG<Node> getLeaves() {

        ListaG<Node> list = new ListaG<Node>();

        BTree.getLeaves(this.root, list);

        return list;

    }

    public static void getLeaves(Node no, ListaG<Node> list) {



        if (no.left == null && no.right == null){

            list.addElemento(no, true);
            return;

        }

        if (no.left != null){
            BTree.getLeaves(no.left, list);
        }

        if (no.right != null){
            BTree.getLeaves(no.right, list);
        }

        return;

        
    }

    public void removeNode(Node target) {

        if (target == this.root){

            this.root = null;
        } else {

            BTree.removeNode(target, this.root);

        }
        
    }

    private static void removeNode(Node target, Node no) {


        if (no.left != null) {


            BTree.removeNode(target, no.left);
            if (no.left == target) {

                no.left = null;


            }


        }

        if (no.right != null) {


            BTree.removeNode(target, no.right);
            if (no.right == target){

                no.right = null;


            } 


        }


    }

    public void removeSub(Node ref, Boolean dir) {

        if (dir){

            ref.right = null;
        } else {

            ref.left = null;
        }
        
    }

    public void concat(BTree tree, Node noReff, Boolean dir) {

        Node end = tree.localizarNoIncompleto();

        if (dir){


            if (end.left == null){

                end.left = noReff.right;

            } else if (end.right == null){


                end.right = noReff.right;
            }

            noReff.right = tree.root;

        } else {


            if (end.left == null){

                end.left = noReff.left;

            } else if (end.right == null){


                end.right= noReff.left;
            }

            noReff.left = tree.root;

        }


    }



}
