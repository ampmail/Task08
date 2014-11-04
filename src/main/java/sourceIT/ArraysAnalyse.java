package sourceIT;

import java.util.ArrayList;

public class ArraysAnalyse {

    static ArrayList<Integer> arrayList;

    public static void main(String[] args) {

        Utils.showMills();
        arrayList = new ArrayList<>(Constants.ELEMENT_COUNT);

        Utils.showMills();
        Utils.fillArray(arrayList, Constants.ELEMENT_COUNT, Constants.InsertPosition.inTheBeginning);

        Utils.showMills();

    }
}
