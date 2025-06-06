package app.dialog;

import util.collection.Iterator;
import util.collection.list.LinkedList;
import util.view.dialog.primitive.DoubleDialog;
import util.view.dialog.primitive.IntDialog;

public class PrimitiveApp {

    public static void main(String[] args) {
        IntDialog intDialog = new IntDialog("Entero");
        LinkedList<Integer> intList = LinkedList.of(
                intDialog.read(),
                0,
                1,
                -1);
        Iterator<Integer> intIterator = intList.iterator();
        while (intIterator.hasNext()) {
            intDialog.writeDetails(intIterator.next());
        }

        DoubleDialog doubleDialog = new DoubleDialog("Decimal");
        LinkedList<Double> doubleList = LinkedList.of(
                doubleDialog.read(),
                0.0,
                1.1,
                -1.2);
        Iterator<Double> doubleIterator = doubleList.iterator();
        while (doubleIterator.hasNext()) {
            doubleDialog.writeDetails(doubleIterator.next());
        }
    }

}
