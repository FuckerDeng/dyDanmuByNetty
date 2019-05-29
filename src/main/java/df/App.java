package df;

import df.client.DouyuClient;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            new DouyuClient().start();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
