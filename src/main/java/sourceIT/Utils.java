package sourceIT;

public class Utils {

    private static long currentMills;

    public static void fillArray(Object array, int quantity, Constants.InsertPosition position){
        if (array != null && quantity > 0){
            String arrayClassName = getClassName(array);
            System.out.println (arrayClassName);

            switch (arrayClassName){
                case "ArrayList":{

                    break;
                }
                case "LinkedList":
                    break;
                case "HashMap":
                    break;
                case "TreeMap":
                    break;
            }
        }
    }

    private static String getClassName (Object c){
        String className = c.getClass().toString ();
        int lastDotPosition = className.lastIndexOf (".") + 1;
        className = className.substring (lastDotPosition, className.length ());
        return className;
    }

    public static void showMills(){
        long newMills = System.currentTimeMillis();
        if (currentMills != 0){
            System.out.println (newMills - currentMills);
        }
        currentMills = newMills;
    }
}
