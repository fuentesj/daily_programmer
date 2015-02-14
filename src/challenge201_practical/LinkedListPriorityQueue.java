package challenge201_practical;

import java.util.Iterator;
/**
 * Created by Jonathan on 2/11/15.
 */
public class LinkedListPriorityQueue<T extends Comparable, S extends Comparable, V> {

    private Node<T, S, V> root;

    public static class Node<T extends Comparable, S extends Comparable, V> {
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
        if (root == null) {
           return null;
        } else if (root != null && root.next == null) {
            V onlyValue = root.getValue();
            root = null;
            return onlyValue;
        } else {
            Node<T, S, V> currentNode = root;
            T currentPriority = currentNode.getPriorityOne();
            V currentValueWithMaxPriority = currentNode.getValue();

            Node<T, S, V> nextNode = currentNode.next;
            T nextPriority = nextNode.getPriorityOne();

            Node<T, S, V> previousNode = null;

            while (nextNode != null) {
                if (nextPriority.compareTo(currentPriority) == 1) {
                    currentValueWithMaxPriority = nextNode.getValue();
                    previousNode = currentNode;
                }

                if (nextNode.next == null) {
                    break;
                } else {
                    currentNode = nextNode;
                    nextNode = currentNode.next;
                    currentPriority = currentNode.getPriorityOne();
                    nextPriority = nextNode.getPriorityOne();
                }
            }
            if (previousNode != null) {
                previousNode.next = previousNode.next.next;
            } else {
                if (currentValueWithMaxPriority.equals(currentNode.getValue())) {
                    root = currentNode.next;
                } else {
                    root = currentNode;
                }
            }
            return currentValueWithMaxPriority;
        }
    }

    public V dequeueB() {
        return root.getValue();
    }
    public int count() {if (root == null) {
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

   public void clear() {
        root = null;
    }
}
