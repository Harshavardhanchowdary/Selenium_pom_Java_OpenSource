package helper.resource;

public class ResourceHelper {

     private static String BASE_PATH = System.getProperty("user.dir");

    public static String getResourcePath(String path){
        return BASE_PATH+"/"+path;
    }


    /**
     * Unit test
     */

    /*public static void main(String[] args) {

        System.out.println(getResourcePath("src/main"));
    }*/

}
