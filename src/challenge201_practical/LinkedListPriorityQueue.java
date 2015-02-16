package challenge201_practical;

import java.util.function.Supplier;

/**
 * Created by Jonathan on 2/11/15.
 */
public class LinkedListPriorityQueue<T extends Comparable, S extends Comparable, V> {

    private Node<T, S, V> root;

    private enum PriorityType {
        PRIORITY_TYPE_A,
        PRIORITy_TYPE_B
    }

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
        return generalDequeue(PriorityType.PRIORITY_TYPE_A);
    }

    public V dequeueB() {
        return generalDequeue(PriorityType.PRIORITy_TYPE_B);
    }

    private V generalDequeue(PriorityType priorityType) {
        if (root == null) {
            return null;
        } else if (root != null && root.next == null) {
            V onlyValue = root.getValue();
            root = null;
            return onlyValue;
        } else {
            Node<T, S, V> currentNode = root;
            Node<T, S, V> currentMaxNode = currentNode;
            Node<T, S, V> nextNode = currentNode.next;
            if (priorityType == PriorityType.PRIORITY_TYPE_A) {
                return findElementWithHighestPriority(currentNode, currentMaxNode, nextNode, currentNode::getPriorityOne, nextNode::getPriorityOne);
            } else {
                return findElementWithHighestPriority(currentNode, currentMaxNode, nextNode, currentNode::getPriorityTwo, nextNode::getPriorityTwo);
            }
        }
    }

    private V findElementWithHighestPriority(Node<T, S, V> currentNode, Node<T, S, V> currentMaxNode, Node<T, S, V> nextNode, Supplier<? extends Comparable> currentNodeSupplier, Supplier<? extends Comparable> nextNodeSupplier) {
        Comparable nextPriority = nextNodeSupplier.get();
        Node<T, S, V> previousNode = null;
        while (nextNode != null) {
            if (nextPriority.compareTo(currentMaxNode.getPriorityOne()) == 1) {
                currentMaxNode = nextNode;
                previousNode = currentNode;
            }

            if (nextNode.next == null) {
                break;
            } else {
                currentNode = nextNode;
                nextNode = currentNode.next;
                nextPriority = nextNode.getPriorityOne();
            }
        }
        if (previousNode != null) {
            previousNode.next = previousNode.next.next;
        } else {
            if (currentMaxNode.getValue().equals(currentNode.getValue())) {
                root = currentNode.next;
            } else {
                root = currentNode;
            }
        }
        return currentMaxNode.getValue();
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
