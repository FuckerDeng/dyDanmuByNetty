package df.dyutil;

public enum OS {
    WINDOWS("windows"),LINUX("linux"),UNIDENTIFIED("undentified");
    private  String osName;
    private OS(String osName){
        this.osName = osName;
    }

    public String getOsName() {
        return osName;
    }
}
