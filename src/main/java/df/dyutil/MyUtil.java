package df.dyutil;

public class MyUtil {
    public static OS getOs(){
        String osName = System.getProperty("os.name").toLowerCase();
        if(osName.contains("windows")){
            return OS.WINDOWS;
        }else if(osName.contains("linux")){
            return OS.LINUX;
        }else {
            return OS.UNIDENTIFIED;
        }
    }
}
