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

        for (int i = 0; i < list.tamanho(); i++) {

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



}
