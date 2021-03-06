package challenge201_practical;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by jon on 2/14/15.
 */
public class LinkedListPriorityQueueTest {

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
    public void ensureAddingOneElementOfTypeAToThePriorityQueueActuallyAddsThatElement() {
        linkedListPriorityQueue.enqueue(new Float(4.5), new Float(2.5), TEST_VALUE_1);
        assertEquals(1, linkedListPriorityQueue.count());
    }

    @Test
    public void ensureAddingMultipleElementsOfTypeAToThePriorityQueueActuallyAddsThoseElements() {
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
    public void ensureThatDequeuingAnElementOfTypeAFromThePriorityQueueWithOnlyOneElementWillReturnThatElementAndEffectivelyClearTheList() {
        linkedListPriorityQueue.enqueue(new Float(9.3), new Float(7.4), TEST_VALUE_1);
        String singleValue = linkedListPriorityQueue.dequeueA();
        assertEquals(TEST_VALUE_1, singleValue);
        assertEquals(0, linkedListPriorityQueue.count());
    }

    @Test
    public void ensureThatDequeuingAnElementOfTypeAFromThePriorityQueueWithTwoElementsProperlyDequeuesThatElement() {
        linkedListPriorityQueue.enqueue(new Float(9.3), new Float(7.4), TEST_VALUE_1);
        linkedListPriorityQueue.enqueue(new Float(23.5), new Float(8.4), TEST_VALUE_2);

        String valueForNodeWithHighestPriority = linkedListPriorityQueue.dequeueA();
        assertEquals(TEST_VALUE_2, valueForNodeWithHighestPriority);
        assertEquals(1, linkedListPriorityQueue.count());

    }

    @Test
    public void ensureThatDequeuingAnElementOfTypeAThatIsInTheMiddleOfThePriorityQueueWithMultipleElementsOfTypeAProperlyDequeuesThatElement() {
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
    public void ensureThatDequeuingAnElementOfTypeAFromTheEndOfThePriorityQueueWithMultipleElementsOfOnlyTypeAProperlyDequeuesThatElement() {
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
    public void ensureThatDequeuingAnElementOfTypeAFromTheMiddleOfThePriorityQueueProperlyDequeuesThatSingleElement() {

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
    public void ensureThatDequeuingMultipleElementsOfTypeARemovesAndReturnsThoseElementsInTheProperOrder() {
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

    @Test
    public void ensureThatDequeuingAnEmptyPriorityQueueResultsInNullBeingReturned() {
        String nullReference = linkedListPriorityQueue.dequeueA();
        assertNull(nullReference);
    }

    @Test
    public void ensureDequeuingElementsWithDifferentPrioritiesWorksAsExpected() {
        linkedListPriorityQueue.enqueue(new Float(99.8), new Float(6.3), TEST_VALUE_1);
        linkedListPriorityQueue.enqueue(new Float(189.4), new Float(227.1), TEST_VALUE_2);
        linkedListPriorityQueue.enqueue(new Float(29.3), new Float(7.7), TEST_VALUE_3);
        linkedListPriorityQueue.enqueue(new Float(69.4), new Float(1093.4), TEST_VALUE_4);
        linkedListPriorityQueue.enqueue(new Float(999.5), new Float(214.9), TEST_VALUE_5);
        linkedListPriorityQueue.enqueue(new Float(449.6), new Float(1.2), TEST_VALUE_6);
        linkedListPriorityQueue.enqueue(new Float(9.1), new Float(7.4), TEST_VALUE_7);

        String valueForNodeWithHighestPriorityOfTypeB = linkedListPriorityQueue.dequeueB();
        assertEquals(TEST_VALUE_4, valueForNodeWithHighestPriorityOfTypeB);
        assertEquals(6, linkedListPriorityQueue.count());

        String valueForNodeWithHighestPriorityOfTypeA = linkedListPriorityQueue.dequeueA();
        assertEquals(TEST_VALUE_5, valueForNodeWithHighestPriorityOfTypeA);
        assertEquals(5, linkedListPriorityQueue.count());

        String valueForNodeWithSecondHighestPriorityOfTypeB = linkedListPriorityQueue.dequeueB();
        assertEquals(TEST_VALUE_2, valueForNodeWithSecondHighestPriorityOfTypeB);
        assertEquals(4, linkedListPriorityQueue.count());

        String valueForNodeWithSecondHighestPriorityOfTypeA = linkedListPriorityQueue.dequeueA();
        assertEquals(TEST_VALUE_6, valueForNodeWithSecondHighestPriorityOfTypeA);
        assertEquals(3, linkedListPriorityQueue.count());

    }
}
