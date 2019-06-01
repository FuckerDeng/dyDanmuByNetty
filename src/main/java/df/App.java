package df;

import df.client.DouyuClient;
import df.dyutil.MyUtil;
import df.dyutil.OS;

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
//            System.out.println(MyUtil.getOs().equals(OS.WINDOWS));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
