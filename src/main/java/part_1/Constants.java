package part_1;

public class Constants {

    public static final int ELEMENT_COUNT = 100_000;

    enum InsertPosition {
        inTheBeginning("beginning", 0.0),
        inTheMiddle("middle", 0.5),
        inTheEnd("end", 0.999);

        String text;
        Double positin;

        InsertPosition(String text, Double positin){
            this.text = text;
            this.positin = positin;
        }
    }

    enum OperationType {
        Insert ("Inserting"),
        Sample ("Sampling"),
        Delete ("Deleting");

        String text;
        OperationType(String text){
            this.text = text;
        }
    }
}
