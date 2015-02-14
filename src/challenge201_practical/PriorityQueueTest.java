package challenge201_practical;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jon on 2/14/15.
 */
public class PriorityQueueTest {

    public static final String TEST_VALUE_1 = "testValue1";
    public static final String TEST_VALUE_2 = "testValue2";
    public static final String TEST_VALUE_3 = "testValue3";
    public static final String TEST_VALUE_4 = "testValue4";
    public static final String TEST_VALUE_5 = "testValue5";
    public static final String TEST_VALUE_6 = "testValue6";
    public static final String TEST_VALUE_7 = "testValue7";
    LinkedListPriorityQueue<Float, Float, String> linkedListPriorityQueue;

    @Before
    public void setup() {
        linkedListPriorityQueue = new LinkedListPriorityQueue<>();
    }

    @Test
    public void ensureAddingOneElementToThePriorityQueueActuallyAddsThatElement() {
        linkedListPriorityQueue.enqueue(new Float(4.5), new Float(2.5), TEST_VALUE_1);
        assertEquals(1, linkedListPriorityQueue.count());
    }

    @Test
    public void ensureAddingMultipleElementsToThePriorityQueueActuallyAddsThoseElements() {
        linkedListPriorityQueue.enqueue(new Float(9.3), new Float(7.4), TEST_VALUE_1);
        linkedListPriorityQueue.enqueue(new Float(3.5), new Float(8.4), TEST_VALUE_2);
        linkedListPriorityQueue.enqueue(new Float(0.3), new Float(1.8), TEST_VALUE_3);
        linkedListPriorityQueue.enqueue(new Float(19.5), new Float(2.2), TEST_VALUE_4);
        assertEquals(4, linkedListPriorityQueue.count());
    }

    @Test
    public void ensureThatCallingClearWillActuallyClearOutThePriorityQueue() {
        linkedListPriorityQueue.enqueue(new Float(9.3), new Float(7.4), TEST_VALUE_1);
        linkedListPriorityQueue.enqueue(new Float(3.5), new Float(8.4), TEST_VALUE_2);
        linkedListPriorityQueue.enqueue(new Float(0.3), new Float(1.8), TEST_VALUE_3);
        linkedListPriorityQueue.enqueue(new Float(19.5), new Float(2.2), TEST_VALUE_4);
        linkedListPriorityQueue.clear();
        assertEquals(0, linkedListPriorityQueue.count());
    }

    @Test
    public void ensureThatDequeuingAnElementFromAPriorityQueueWithOnlyOneElementWillReturnThatElementAndEffectivelyClearTheList() {
        linkedListPriorityQueue.enqueue(new Float(9.3), new Float(7.4), TEST_VALUE_1);
        String singleValue = linkedListPriorityQueue.dequeueA();
        assertEquals(TEST_VALUE_1, singleValue);
        assertEquals(0, linkedListPriorityQueue.count());
    }

    @Test
    public void ensureThatDequeuingAnElementFromAPriorityQueueWithTwoElementsProperlyDequeuesThatElement() {
        linkedListPriorityQueue.enqueue(new Float(9.3), new Float(7.4), TEST_VALUE_1);
        linkedListPriorityQueue.enqueue(new Float(23.5), new Float(8.4), TEST_VALUE_2);

        String valueForNodeWithHighestPriority = linkedListPriorityQueue.dequeueA();
        assertEquals(TEST_VALUE_2, valueForNodeWithHighestPriority);
        assertEquals(1, linkedListPriorityQueue.count());

    }

    @Test
    public void ensureThatDequeuingAnElementThatIsInTheMiddleOfThePriorityQueueWithMultipleElementsProperlyDequeuesThatElement() {
        linkedListPriorityQueue.enqueue(new Float(9.3), new Float(7.4), TEST_VALUE_1);
        linkedListPriorityQueue.enqueue(new Float(23.5), new Float(8.4), TEST_VALUE_2);
        linkedListPriorityQueue.enqueue(new Float(67.0), new Float(8.4), TEST_VALUE_3);
        linkedListPriorityQueue.enqueue(new Float(17.4), new Float(8.4), TEST_VALUE_4);
        linkedListPriorityQueue.enqueue(new Float(21.3), new Float(8.4), TEST_VALUE_5);

        String valueForNodeWithHighestPriority = linkedListPriorityQueue.dequeueA();
        assertEquals(TEST_VALUE_3, valueForNodeWithHighestPriority);
        assertEquals(4, linkedListPriorityQueue.count());
    }

    @Test
    public void ensureThatDequeuingAnElementFromTheEndOfThePriorityQueueWithMultipleElementsProperlyDequeuesThatElement() {
        linkedListPriorityQueue.enqueue(new Float(99.3), new Float(7.4), TEST_VALUE_1);
        linkedListPriorityQueue.enqueue(new Float(89.3), new Float(7.4), TEST_VALUE_2);
        linkedListPriorityQueue.enqueue(new Float(79.3), new Float(7.4), TEST_VALUE_3);
        linkedListPriorityQueue.enqueue(new Float(69.3), new Float(7.4), TEST_VALUE_4);
        linkedListPriorityQueue.enqueue(new Float(59.3), new Float(7.4), TEST_VALUE_5);
        linkedListPriorityQueue.enqueue(new Float(49.3), new Float(7.4), TEST_VALUE_6);
        linkedListPriorityQueue.enqueue(new Float(39.3), new Float(7.4), TEST_VALUE_7);

        String valueForNodeWithHighestPriority = linkedListPriorityQueue.dequeueA();
        assertEquals(TEST_VALUE_1, valueForNodeWithHighestPriority);
        assertEquals(6, linkedListPriorityQueue.count());
    }

    @Test
    public void ensureThatDequeuingAnElementFromTheMiddleOfThePriorityQueueProperlyDequeuesThatElement() {

        linkedListPriorityQueue.enqueue(new Float(99.3), new Float(7.4), TEST_VALUE_1);
        linkedListPriorityQueue.enqueue(new Float(189.3), new Float(7.4), TEST_VALUE_2);
        linkedListPriorityQueue.enqueue(new Float(29.3), new Float(7.4), TEST_VALUE_3);
        linkedListPriorityQueue.enqueue(new Float(69.3), new Float(7.4), TEST_VALUE_4);
        linkedListPriorityQueue.enqueue(new Float(999.3), new Float(7.4), TEST_VALUE_5);
        linkedListPriorityQueue.enqueue(new Float(449.3), new Float(7.4), TEST_VALUE_6);
        linkedListPriorityQueue.enqueue(new Float(9.3), new Float(7.4), TEST_VALUE_7);

        String valueForNodeWithHighestPriority = linkedListPriorityQueue.dequeueA();
        assertEquals(TEST_VALUE_5, valueForNodeWithHighestPriority);
        assertEquals(6, linkedListPriorityQueue.count());

    }

    @Test
    public void ensureThatDequeuingMultipleElementsRemovesAndReturnsElementsInTheProperOrder() {
        linkedListPriorityQueue.enqueue(new Float(99.3), new Float(7.4), TEST_VALUE_1);
        linkedListPriorityQueue.enqueue(new Float(189.3), new Float(7.4), TEST_VALUE_2);
        linkedListPriorityQueue.enqueue(new Float(29.3), new Float(7.4), TEST_VALUE_3);
        linkedListPriorityQueue.enqueue(new Float(69.3), new Float(7.4), TEST_VALUE_4);
        linkedListPriorityQueue.enqueue(new Float(999.3), new Float(7.4), TEST_VALUE_5);
        linkedListPriorityQueue.enqueue(new Float(449.3), new Float(7.4), TEST_VALUE_6);
        linkedListPriorityQueue.enqueue(new Float(9.3), new Float(7.4), TEST_VALUE_7);

        String valueForNodeWithHighestPriority = linkedListPriorityQueue.dequeueA();
        assertEquals(TEST_VALUE_5, valueForNodeWithHighestPriority);
        assertEquals(6, linkedListPriorityQueue.count());

        String valueForNodeWithSecondHighestPriority = linkedListPriorityQueue.dequeueA();
        assertEquals(TEST_VALUE_6, valueForNodeWithSecondHighestPriority);
        assertEquals(5, linkedListPriorityQueue.count());

        String valueForNodeWithThirdHighestPriority = linkedListPriorityQueue.dequeueA();
        assertEquals(TEST_VALUE_2, valueForNodeWithThirdHighestPriority);
        assertEquals(4, linkedListPriorityQueue.count());

        String valueForNodeWithFourthHighestPriority = linkedListPriorityQueue.dequeueA();
        assertEquals(TEST_VALUE_1, valueForNodeWithFourthHighestPriority);
        assertEquals(3, linkedListPriorityQueue.count());

        String valueForNodeWithFifthHighestPriority = linkedListPriorityQueue.dequeueA();
        assertEquals(TEST_VALUE_4, valueForNodeWithFifthHighestPriority);
        assertEquals(2, linkedListPriorityQueue.count());

        String valueForNodeWithSixthHighestPriority = linkedListPriorityQueue.dequeueA();
        assertEquals(TEST_VALUE_3, valueForNodeWithSixthHighestPriority);
        assertEquals(1, linkedListPriorityQueue.count());

        String valueForNodeWithSeventhHighestPriority = linkedListPriorityQueue.dequeueA();
        assertEquals(TEST_VALUE_7, valueForNodeWithSeventhHighestPriority);
        assertEquals(0, linkedListPriorityQueue.count());
    }
}
