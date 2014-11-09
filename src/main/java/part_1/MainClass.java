package part_1;

import java.util.*;

public class MainClass {

    public static void main(String[] args) {

        Constants.setELEMENT_COUNT(50_000);
        ArrayList arrayList = new ArrayList();
        ArraysAnalyse.testArray(arrayList);

        List linkedList = new LinkedList();
        ArraysAnalyse.testArray(linkedList);

        Constants.setELEMENT_COUNT(5_000_000);
        Map hashMap = new HashMap();
        ArraysAnalyse.testArray(hashMap);

        Map treeMap = new TreeMap();
        ArraysAnalyse.testArray(treeMap);
    }
}
