package part_1;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    private static long prevMills;

    public static void testArray(Object array) {
        if (array != null) {
            String arrayClassName = getClassName(array);
            System.out.print("Operate with " + Constants.ELEMENT_COUNT + " elements of ");
            switch (arrayClassName) {
                case "ArrayList": {
                    showMills();
                    System.out.println(arrayClassName);

                    for (Constants.InsertPosition positionToInsert : Constants.InsertPosition.values()) {
                        System.out.println("---------------------------------------------");
                        List<Integer> testingArrayList = new ArrayList<>();
                        double indx;
                        for (Constants.OperationType operation : Constants.OperationType.values()) {
                            for (Integer i = 0; i < Constants.ELEMENT_COUNT; i++) {
                                indx = positionToInsert.positin * testingArrayList.size();
                                switch (operation) {
                                    case Insert: {
                                        testingArrayList.add((int) indx, i);
                                        break;
                                    }
                                    case Sample: {
                                        testingArrayList.get((int) indx);
                                        break;
                                    }
                                    case Delete: {
                                        testingArrayList.remove((int) indx);
                                        break;
                                    }
                                }
                            }
                            System.out.println(operation.text +" in the " + positionToInsert.text + " was spent " + showMills() + " ms");
                        }
                    }
                    break;
                }
                case "LinkedList":
                    break;
                case "HashMap":
                    break;
                case "TreeMap":
                    break;
                default: {
                    throw new ClassCastException("Wrong class");
                }
            }
        } else {
            throw new NullPointerException("Array not defined");
        }
    }

    private static String getClassName(Object c) {
        String className = c.getClass().toString();
        int lastDotPosition = className.lastIndexOf(".") + 1;
        className = className.substring(lastDotPosition, className.length());
        return className;
    }

    public static long showMills() {
        long currMills = System.currentTimeMillis();
        if (prevMills == 0) {
            prevMills = currMills;
            return 0;
        }
        long Mills = currMills - prevMills;
        prevMills = currMills;
        return Mills;
    }
}
