package uern.oop.btree;

public class Node
{

    public Integer value = null;
    public Node right = null;
    public Node left = null;

    public Node()
    {

    }

    public Node(Integer val)
    {

        this.value = val;

    }

    public Boolean isEqual(Node target) {

        if (target.value == this.value && target.left == this.left && target.right == this.right) {

            return true;

        } else {

            return false;
        }
    }

}
