package challenge201_practical;

/**
 * Created by Jonathan on 2/11/15.
 */
public class LinkedListPriorityQueue<V, P1, P2> implements Iterable<V, P1, P2> {

    private Node<P1, P2, V> root;

    private static class Node<P1, P2, V> {

        private V value;
        private P1 priorityOne;
        private P2 priorityTwo;


        public Node(V value, P1 priorityOne, P2 priorityTwo) {
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

        public P1 getPriorityOne() {
            return priorityOne;
        }

        public void setPriorityOne(P1 priorityOne) {
            this.priorityOne = priorityOne;
        }

        public P2 getPriorityTwo() {
            return priorityTwo;
        }

        public void setPriorityTwo(P2 priorityTwo) {
            this.priorityTwo = priorityTwo;
        }
    }

}
