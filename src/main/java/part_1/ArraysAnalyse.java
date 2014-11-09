package part_1;

import java.util.*;

public class ArraysAnalyse {

    static ArrayList arrayList;
    static List linkedList;
    static Map hashMap;
    static Map treeMap;

    public static void main(String[] args) {

        arrayList = new ArrayList<>();
        Utils.testArray(arrayList);

        linkedList = new LinkedList<>();
        Utils.testArray(linkedList);

        hashMap = new HashMap<>();
        Utils.testArray(hashMap);

        treeMap = new TreeMap<>();
        Utils.testArray(treeMap);
    }
}
