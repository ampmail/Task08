package part_1;

import java.util.*;

public class Utils {

    private static long prevMills;

    public static void testArray(Object array) {
        if (array != null) {
            String arrayClassName = getClassName(array);
            System.out.println("---------------------------------------------");
            System.out.print("Operate with " + Constants.ELEMENT_COUNT + " elements of ");
            System.out.println(arrayClassName);
            System.out.println("---------------------------------------------");
            showMills(); // reset mills counter

            switch (arrayClassName) {
                case "ArrayList": {
                    for (Constants.InsertPosition positionToInsert : Constants.InsertPosition.values()) {
                        List<Integer> arrayList = new ArrayList<>();
                        double indx;
                        for (Constants.OperationType operation : Constants.OperationType.values()) {
                            for (Integer i = 0; i < Constants.ELEMENT_COUNT; i++) {
                                indx = positionToInsert.positin * arrayList.size();
                                switch (operation) {
                                    case Insert: {
                                        arrayList.add((int) indx, i);
                                        break;
                                    }
                                    case Sample: {
                                        arrayList.get((int) indx);
                                        break;
                                    }
                                    case Delete: {
                                        arrayList.remove((int) indx);
                                        break;
                                    }
                                }
                            }
                            System.out.println(operation.text +" in the " + positionToInsert.text + " was spent " + showMills() + " ms");
                        }
                    }
                    System.out.println();
                    break;
                }
                case "LinkedList":
                    for (Constants.InsertPosition positionToInsert : Constants.InsertPosition.values()) {
                        List<Integer> linkedList = new LinkedList<>();
                        double indx;
                        for (Constants.OperationType operation : Constants.OperationType.values()) {
                            for (Integer i = 0; i < Constants.ELEMENT_COUNT; i++) {
                                indx = positionToInsert.positin * linkedList.size();
                                switch (operation) {
                                    case Insert: {
                                        linkedList.add((int) indx, i);
                                        break;
                                    }
                                    case Sample: {
                                        linkedList.get((int) indx);
                                        break;
                                    }
                                    case Delete: {
                                        linkedList.remove((int) indx);
                                        break;
                                    }
                                }
                            }
                            System.out.println(operation.text +" in the " + positionToInsert.text + " was spent " + showMills() + " ms");
                        }
                    }
                    System.out.println();
                    break;
                case "HashMap":
                    for (Constants.InsertPosition positionToInsert : Constants.InsertPosition.values()) {
                        Map hashMap = new HashMap<>();
                        double indx;
                        for (Constants.OperationType operation : Constants.OperationType.values()) {
                            for (Integer i = 0; i < Constants.ELEMENT_COUNT; i++) {
                                indx = positionToInsert.positin * hashMap.size();
                                switch (operation) {
                                    case Insert: {
                                        hashMap.put((int) indx, i);
                                        break;
                                    }
                                    case Sample: {
                                        hashMap.get((int) indx);
                                        break;
                                    }
                                    case Delete: {
                                        hashMap.remove((int) indx);
                                        break;
                                    }
                                }
                            }
                            System.out.println(operation.text +" in the " + positionToInsert.text + " was spent " + showMills() + " ms");
                        }
                    }
                    System.out.println();
                    break;
                case "TreeMap":
                    for (Constants.InsertPosition positionToInsert : Constants.InsertPosition.values()) {
                        Map treeMap = new TreeMap<>();
                        double indx;
                        for (Constants.OperationType operation : Constants.OperationType.values()) {
                            for (Integer i = 0; i < Constants.ELEMENT_COUNT; i++) {
                                indx = positionToInsert.positin * treeMap.size();
                                switch (operation) {
                                    case Insert: {
                                        treeMap.put((int) indx, i);
                                        break;
                                    }
                                    case Sample: {
                                        treeMap.get((int) indx);
                                        break;
                                    }
                                    case Delete: {
                                        treeMap.remove((int) indx);
                                        break;
                                    }
                                }
                            }
                            System.out.println(operation.text +" in the " + positionToInsert.text + " was spent " + showMills() + " ms");
                        }
                    }
                    System.out.println();
                    break;
                default: {
                    System.out.println(arrayClassName + " is not supported class");
//                    throw new ClassCastException("Wrong class");
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
