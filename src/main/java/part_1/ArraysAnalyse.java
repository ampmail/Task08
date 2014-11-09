package part_1;

import java.util.*;

public class ArraysAnalyse {

    private static long prevMills;
    private static List<Object> testArray;
    private static Map<Object, Object> testMap;
    private static double indx;

    public static void testArray(Object array) {
        if (array != null) {
            String arrayClassName = getClassName(array);
            System.out.println("---------------------------------------------");
            System.out.println("Operate with " + Constants.ELEMENT_COUNT + " elements of " + arrayClassName);
            System.out.println("---------------------------------------------");

            switch (arrayClassName) {
                case "ArrayList":
                    testArray = new ArrayList<>();
                    break;
                case "LinkedList":
                    testArray = new LinkedList<>();
                    break;
                case "HashMap":
                    testMap = new HashMap();
//                    testMap = new HashMap_hashCode();
                    break;
                case "TreeMap":
                    testMap = new TreeMap();
                    testMap = new TreeMap_compare();
                    break;
                default: {
                    System.out.println(arrayClassName + " is not supported class");
                    throw new ClassCastException("Wrong class");
                }
            }
            showMills(); // reset mills counter
            for (Constants.InsertPosition positionToInsert : Constants.InsertPosition.values()) {
                for (Constants.OperationType operation : Constants.OperationType.values()) {
                    for (Integer i = 0; i < Constants.ELEMENT_COUNT; i++) {
                        switch (arrayClassName) {
                            case "ArrayList":
                            case "LinkedList":
                                indx = positionToInsert.positin * testArray.size();
                                break;
                            case "HashMap":
                            case "TreeMap":
                                indx = positionToInsert.positin * testMap.size();
                                break;
                        }
                        switch (operation) {
                            case Insert:
                                switch (arrayClassName) {
                                    case "ArrayList":
                                    case "LinkedList":
                                        testArray.add((int) indx, i);
                                        break;
                                    case "HashMap":
                                    case "TreeMap":
                                        testMap.put(i, i);
                                        break;
                                }
                                break;
                            case Sample:
                                switch (arrayClassName) {
                                    case "ArrayList":
                                    case "LinkedList":
                                        testArray.get((int) indx);
                                        break;
                                    case "HashMap":
                                    case "TreeMap":
                                        testMap.get((int) indx);
                                        break;
                                }
                                break;
                            case Delete:
                                switch (arrayClassName) {
                                    case "ArrayList":
                                    case "LinkedList":
                                        testArray.remove((int) indx);
                                        break;
                                    case "HashMap":
                                    case "TreeMap":
                                        testMap.remove(i);
                                        break;
                                }
                                break;
                        }
                    }
                    System.out.println(operation.text + " in the " + positionToInsert.text + " was spent " + showMills() + " ms");
                }
            }
            System.out.println();
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
