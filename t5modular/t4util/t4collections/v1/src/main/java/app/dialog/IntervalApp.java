package app.dialog;

import java.util.LinkedList;

import util.values.DoubleInterval;
import util.values.Fraction;
import util.values.FractionInterval;
import util.view.dialog.primitive.Console;
import util.view.dialog.values.DoubleIntervalDialog;
import util.view.dialog.values.FractionIntervalDialog;

public class IntervalApp {

    public static void main(String[] args) {
        DoubleIntervalDialog doubleIntervalDialog = new DoubleIntervalDialog("Intervalo de Doubles");
        IntervalApp.of(
                // doubleIntervalDialog.read(),
                new DoubleInterval(-1, 1),
                new DoubleInterval(0, 0),
                new DoubleIntervalDialog().create("[100,200]"))
                .forEach(element -> {
                    doubleIntervalDialog.writeDetails(element);
                });

        FractionIntervalDialog fractionIntervalDialog = new FractionIntervalDialog("Intervalo de Fracciones");
        IntervalApp.of(
                // fractionIntervalDialog.read(),
                new FractionInterval(new Fraction(-1), new Fraction(1)),
                new FractionInterval(new Fraction(1, 2), new Fraction(2, 1)),
                new FractionInterval(new Fraction(0), new Fraction(0)),
                new FractionIntervalDialog().create("[1/2,2/3]"))
                .forEach(element -> {
                    fractionIntervalDialog.writeDetails(element);
                });
        Console.close("0");
    }

    private static <T> LinkedList<T> of(T... elements) {
        LinkedList<T> list = new LinkedList<>();
        for (T element : elements) {
            list.add(element);
        }
        return list;
    }

}
