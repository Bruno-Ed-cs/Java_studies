package uern.oop.singles;

public class Singleton
{
    private static Singleton instance = null;
    public static String test = null;

    private Singleton()
    {

        test = "this is not test";

    }


    public static Singleton getInstace()
    {

        if (instance == null)
        {
            instance = new Singleton();
        }

        return instance;
    }
    
    public static String getTest() {

        return Singleton.test;
        
    }


}
