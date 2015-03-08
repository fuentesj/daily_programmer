package challenge201_practical;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jon on 2/17/15.
 */
public class ArrayPriorityQueueTest {

    ArrayPriorityQueue<Integer> priorityQueue;

    @Before
    public void setup() {
        priorityQueue = new ArrayPriorityQueue<>(Integer.class, 100);
    }


    @Test
    public void ensureOneElementCanBeAddedToPriorityQueue() {
        priorityQueue.insert(1);
        assertEquals(1, priorityQueue.count());
    }

    @Test
    public void ensureMultipleElementsCanBeProperlyAddedToPriorityQueue() {
        priorityQueue.insert(4);
        priorityQueue.insert(2);
        priorityQueue.insert(9);
        priorityQueue.insert(0);
        priorityQueue.insert(15);

        Integer greatestElement = priorityQueue.dequeue();
        assertEquals(new Integer(15), greatestElement);

        Integer secondGreatestElement = priorityQueue.dequeue();
        assertEquals(new Integer(9), secondGreatestElement);

        Integer thirdGreatestElement = priorityQueue.dequeue();
        assertEquals(new Integer(4), thirdGreatestElement);

        Integer fourthGreatestElement = priorityQueue.dequeue();
        assertEquals(new Integer(2), fourthGreatestElement);

        Integer lastElement = priorityQueue.dequeue();
        assertEquals(new Integer(0), lastElement);
    }

    @Test(expected = PriorityQueueEmptyException.class)
    public void ensurePriorityQueueThrowsExceptionWhenEmptyAndDequeued() {
        priorityQueue.dequeue();
    }

}
