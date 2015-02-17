package challenge201_practical;

import java.lang.reflect.Array;

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
        nextOpenIndex++;
        return (maxHeapArray[nextOpenIndex -1] != null);
    }

    private void percolateUp(E element, Integer currentIndex) {
        Integer parentNodeIndex = calculateParentIndex(currentIndex);
        E parentElement = maxHeapArray[parentNodeIndex];

        while (parentElement.compareTo(element) == -1) {
            maxHeapArray[parentNodeIndex] = element;
            maxHeapArray[currentIndex] = parentElement;
            currentIndex = parentNodeIndex;
            parentNodeIndex = calculateParentIndex(currentIndex);
            parentElement = maxHeapArray[parentNodeIndex];
        }
    }

    private Integer calculateParentIndex(Integer currentIndex) {
        Double intermediateParentNodeIndex = Math.floor((currentIndex-1)/2);
        return intermediateParentNodeIndex.intValue();
    }

    public int count() {
        return maxHeapArray.length;
    }


}
