package uern.oop.calculadora;
import uern.oop.lista.*;

public class Main
{
    public static void main(String[] args)
    {
        if (args.length == 0)
        {
            System.out.println("Insuficient arguments");
            return;
        }

        Pilha buffer = new Pilha();


        for (int i = 0; i < args.length; i ++)
        {

            Integer temp;

            switch (args[i])
            {
                case "/":
                {

                    temp = buffer.topo().valor;

                    buffer.pop();

                    buffer.topo().valor /= temp;

                    break;
                }

                case "*":
                {

                    temp = buffer.topo().valor;

                    buffer.pop();

                    buffer.topo().valor *= temp;

                    break;
                }

                case "+":
                {

                    temp = buffer.topo().valor;

                    buffer.pop();

                    buffer.topo().valor += temp;

                    break;
                }

                case "-":
                {

                    temp = buffer.topo().valor;

                    buffer.pop();

                    buffer.topo().valor -= temp;

                    break;
                }

                default:
                {
                    buffer.push(Integer.parseInt(args[i]));
                    break;
                }
            }

        }

        System.out.println("Resultado = " + buffer.topo().valor);
    }
}
