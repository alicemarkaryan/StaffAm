package UrlSetter;

public class UrlSetter {
    private static String url;
    public static void setUrl(){
        String Test_Run=System.getProperty("env");
        if(Test_Run==null)
            throw new RuntimeException("ERROR: no env is set");
        url=switch (Test_Run){
            case "sas"-> "https://www.sas.am";
            case "stf" ->"https://www.staff.am";
            default -> throw new RuntimeException("ERROR WRONG ENV"+Test_Run);
        };

    }

    public static String getUrl(){
        return url;
    }
}
