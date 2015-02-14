package challenge201_practical;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jon on 2/14/15.
 */
public class PriorityQueueTest {

    public static final String SINGLE_VALUE = "testValue1";
    LinkedListPriorityQueue<Float, Float, String> linkedListPriorityQueue;

    @Before
    public void setup() {
        linkedListPriorityQueue = new LinkedListPriorityQueue<>();
    }


    @Test
    public void ensureAddingOneElementToThePriorityQueueActuallyAddsThatElement() {
        linkedListPriorityQueue.enqueue(new Float(4.5), new Float(2.5), "testValue");
        assertEquals(1, linkedListPriorityQueue.count());
    }

    @Test
    public void ensureAddingMultipleElementsToThePriorityQueueActuallyAddsThoseElements() {
        linkedListPriorityQueue.enqueue(new Float(9.3), new Float(7.4), "testValue1");
        linkedListPriorityQueue.enqueue(new Float(3.5), new Float(8.4), "testValue2");
        linkedListPriorityQueue.enqueue(new Float(0.3), new Float(1.8), "testValue3");
        linkedListPriorityQueue.enqueue(new Float(19.5), new Float(2.2), "testValue4");
        assertEquals(4, linkedListPriorityQueue.count());
    }

    @Test
    public void ensureThatCallingClearWillActuallyClearOutThePriorityQueue() {
        linkedListPriorityQueue.enqueue(new Float(9.3), new Float(7.4), "testValue1");
        linkedListPriorityQueue.enqueue(new Float(3.5), new Float(8.4), "testValue2");
        linkedListPriorityQueue.enqueue(new Float(0.3), new Float(1.8), "testValue3");
        linkedListPriorityQueue.enqueue(new Float(19.5), new Float(2.2), "testValue4");
        linkedListPriorityQueue.clear();
        assertEquals(0, linkedListPriorityQueue.count());
    }

    @Test
    public void ensureThatDequeuingAnElementFromAPriorityQueueWithOnlyOneElementWillReturnThatElementAndEffectivelyClearTheList() {
        linkedListPriorityQueue.enqueue(new Float(9.3), new Float(7.4), SINGLE_VALUE);
        String singleValue = linkedListPriorityQueue.dequeueA();
        assertEquals(SINGLE_VALUE, singleValue);
        assertEquals(0, linkedListPriorityQueue.count());
    }

    @Test
    public void ensureThatDequeuingAnElementFromAPriorityQueueWithTwoElementsProperlyDequeuesThatElement() {
        linkedListPriorityQueue.enqueue(new Float(9.3), new Float(7.4), "testValue1");
        linkedListPriorityQueue.enqueue(new Float(23.5), new Float(8.4), "testValue2");

        String valueForNodeWithHighestPriority = linkedListPriorityQueue.dequeueA();
        assertEquals("testValue2", valueForNodeWithHighestPriority);
        assertEquals(1, linkedListPriorityQueue.count());

    }
}
