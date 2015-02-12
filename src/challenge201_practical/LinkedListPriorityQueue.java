package challenge201_practical;

import java.util.Iterator;
/**
 * Created by Jonathan on 2/11/15.
 */
public class LinkedListPriorityQueue<T, S, V> implements Iterable<LinkedListPriorityQueue.Node<T, S, V>> {

    private Node<T, S, V> root;

    public static class Node<T, S, V> {

        private V value;
        private T priorityOne;
        private S priorityTwo;


        public Node(V value, T priorityOne, S priorityTwo) {
            this.value = value;
            this.priorityOne = priorityOne;
            this.priorityTwo = priorityTwo;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public T getPriorityOne() {
            return priorityOne;
        }

        public void setPriorityOne(T priorityOne) {
            this.priorityOne = priorityOne;
        }

        public S getPriorityTwo() {
            return priorityTwo;
        }

        public void setPriorityTwo(S priorityTwo) {
            this.priorityTwo = priorityTwo;
        }
    }

    public Iterator<Node<T,S, V>> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator {

        private LinkedListPriorityQueue.Node<T, S, V> current;

        public boolean hasNext() {
            return true;
        }

        public LinkedListPriorityQueue.Node<T, S, V> next() {
            return current;
       }
    }

}
