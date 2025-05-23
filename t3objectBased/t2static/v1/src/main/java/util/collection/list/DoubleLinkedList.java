package util.collection.list;

import util.collection.list.iterator.DoubleIterator;
import util.collection.list.node.DoubleNode;
import util.values.IntegerInterval;

public class DoubleLinkedList {

    private DoubleNode head;
    private DoubleNode last;

    public DoubleLinkedList() {
        this.head = null;
        this.last = null;
    }

    public static DoubleLinkedList of(Double... elements) {
        assert elements != null : "Elements cannot be null";

        DoubleLinkedList dateLinkedList = DoubleLinkedList.empty();
        for (double element : elements) {
            dateLinkedList.add(element);
        }
        return dateLinkedList;
    }

    public static DoubleLinkedList empty(){
        return new DoubleLinkedList();
    }

    public boolean add(Double element) {
        assert element != null : "Element cannot be null";

        DoubleNode last = new DoubleNode(this.last, element);
        if (this.isEmpty()) {
            this.head = last;
        } else {
            this.last.setNext(last);
        }
        this.last = last;
        return true;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int size() {
        int size = 0;
        DoubleIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            size++;
            iterator.next();
        }
        return size;
    }

    public DoubleIterator iterator() {
        return new DoubleIterator(this.head);
    }

    public Double get(int position) {
        assert new IntegerInterval(0, this.size() - 1).includes(position) : "Position out of bounds";

        DoubleIterator iterator = this.iterator();
        double decimal = iterator.next();
        while (position > 0) {
            decimal = iterator.next();
            position--;
        }
        return decimal;
    }

    public String toString() {
        String toString = "";
        DoubleIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            toString += "," + iterator.next();
        }
        if (toString.length() > 0) {
            toString = toString.substring(1);
        }
        return "{" + toString + "}";
    }

}
