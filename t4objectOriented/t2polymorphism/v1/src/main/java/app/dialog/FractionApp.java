package app.dialog;

import util.collection.list.LinkedList;
import util.values.Fraction;
import util.view.dialog.primitive.Console;
import util.view.dialog.values.FractionDialog;

public class FractionApp {

    public static void main(String[] args) {
        FractionDialog fractionDialog = new FractionDialog("Fracción");
        LinkedList<Fraction> fractionLinkedList = LinkedList.of(
                fractionDialog.read(),
                new Fraction(2, 3),
                new Fraction(-1),
                new Fraction(),
                fractionDialog.create("1/5"),
                fractionDialog.create("-1/5"),
                fractionDialog.create("1/-5"),
                fractionDialog.create("-1/-5"));
                LinkedList<Fraction>.Iterator<Fraction> fractionIterator = fractionLinkedList.iterator();
        while (fractionIterator.hasNext()) {
            fractionDialog.writeDetails(fractionIterator.next());
        }
        Console.close("0");
    }

}