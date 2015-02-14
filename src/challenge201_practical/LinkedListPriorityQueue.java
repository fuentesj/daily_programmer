package challenge201_practical;

import java.util.Iterator;
/**
 * Created by Jonathan on 2/11/15.
 */
public class LinkedListPriorityQueue<T, S, V> implements Iterable<LinkedListPriorityQueue.Node<T, S, V>> {

    private Node<T, S, V> root;

    public static class Node<T, S, V> {

        private T priorityOne;
        private S priorityTwo;
        private V value;
        private Node<T, S, V> next;

        public Node(T priorityOne, S priorityTwo, V value, Node<T, S, V> next) {
            this.value = value;
            this.priorityOne = priorityOne;
            this.priorityTwo = priorityTwo;
            this.next = next;
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

        public Node<T, S, V> getNext() {
            return next;
        }

        public void setNext(Node<T, S, V> next) {
            this.next = next;
        }
    }

    public boolean enqueue(T firstPriority, S secondPriority, V value) {
        root = new Node<>(firstPriority,secondPriority, value, root);
        return (root != null);
    }

    public V dequeueA() {
        return root.getValue();
    }

    public V dequeueB() {
        return root.getValue();
    }

    public int count() {
        if (root == null) {
            return 0;
        } else {
            int counter = 0;
            Node<T, S, V> counterReference = root;
            while (counterReference != null) {
                counter++;
                counterReference = counterReference.next;
            }
            return counter;
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
