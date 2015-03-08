package challenge201_practical;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by jon on 2/16/15.
 */
public class ArrayPriorityQueue<E extends Comparable<E>> {

    private E[] maxHeapArray;
    private Integer nextOpenIndex;

    public ArrayPriorityQueue(Class<E> clazz, int size) {
        maxHeapArray = (E[]) Array.newInstance(clazz, size);
        nextOpenIndex = 0;
    }

    public boolean insert(E element) {
        maxHeapArray[nextOpenIndex] = element;
        percolateUp(nextOpenIndex);
        nextOpenIndex++;
        return (maxHeapArray[nextOpenIndex - 1] != null);
    }

    public E dequeue() throws PriorityQueueEmptyException {
        if (count() == 0) {
            throw new PriorityQueueEmptyException();
        }
        E rootElement = maxHeapArray[0];
        if (count() > 1) {
            int lastIndexUsed = nextOpenIndex - 1;
            percolateDown(lastIndexUsed);
        }
        return rootElement;
    }

    private void percolateDown(Integer currentIndex) {
        maxHeapArray[0] = maxHeapArray[currentIndex];
        E currentElement = maxHeapArray[currentIndex];
        maxHeapArray[currentIndex] = null;
        currentIndex = 0;
        int greaterChildIndex = calculateGreaterChildIndex(currentIndex);
        E greaterChildElement = maxHeapArray[greaterChildIndex];

        while (currentElement.compareTo(greaterChildElement) == -1) {
            maxHeapArray[currentIndex] = greaterChildElement;
            maxHeapArray[greaterChildIndex] = currentElement;
            currentIndex = greaterChildIndex;
            currentElement = maxHeapArray[currentIndex];
            greaterChildIndex = calculateGreaterChildIndex(currentIndex);
            greaterChildElement = maxHeapArray[greaterChildIndex];
            if (currentElement == null) {
                break;
            }
        }
        nextOpenIndex--;
    }


    private void percolateUp(Integer currentIndex) {
        Integer parentNodeIndex = calculateParentIndex(currentIndex);
        E parentElement = maxHeapArray[parentNodeIndex];
        E currentElement = maxHeapArray[currentIndex];

        while (parentElement.compareTo(currentElement) == -1) {
            maxHeapArray[parentNodeIndex] = currentElement;
            maxHeapArray[currentIndex] = parentElement;
            currentIndex = parentNodeIndex;
            parentNodeIndex = calculateParentIndex(currentIndex);
            parentElement = maxHeapArray[parentNodeIndex];
        }
    }

    private int calculateGreaterChildIndex(int parentIndex) {
        E greaterChildElement;

        int leftChildIndex = calculateLeftChildIndex(parentIndex);
        E leftChildElement = maxHeapArray[leftChildIndex];

        int rightChildIndex = calculateRightChildIndex(parentIndex);
        E rightChildElement = maxHeapArray[rightChildIndex];

        if (leftChildElement == null && rightChildElement != null) {
            greaterChildElement = rightChildElement;
        } else if (rightChildElement == null && leftChildElement != null) {
            greaterChildElement = leftChildElement;
        } else if (leftChildElement != null && leftChildElement.compareTo(rightChildElement) == 1) {
            greaterChildElement = leftChildElement;
        } else if (rightChildElement != null && rightChildElement.compareTo(leftChildElement) == 1) {
            greaterChildElement = rightChildElement;
        } else {
            greaterChildElement = maxHeapArray[parentIndex];
        }
        return Arrays.asList(maxHeapArray).indexOf(greaterChildElement);
    }

    private Integer calculateParentIndex(Integer currentIndex) {
        Double intermediateParentNodeIndex = Math.floor((currentIndex - 1) / 2);
        return intermediateParentNodeIndex.intValue();
    }

    private int calculateLeftChildIndex(int parentIndex) {
        return (parentIndex * 2) + 1;
    }

    private int calculateRightChildIndex(int parentIndex) {
        return (parentIndex * 2) + 2;
    }

    public int count() {
        int totalElementCount = 0;
        for (int currentIndex = 0; currentIndex < maxHeapArray.length; currentIndex++) {
            if (maxHeapArray[currentIndex] != null) {
                totalElementCount++;
            }
        }
        return totalElementCount;
    }
}
