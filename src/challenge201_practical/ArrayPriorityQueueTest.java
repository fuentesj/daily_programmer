package challenge201_practical;

import org.junit.Before;

/**
 * Created by jon on 2/17/15.
 */
public class ArrayPriorityQueueTest {

    ArrayPriorityQueue<Integer> priorityQueue;

    @Before
    public void setup() {
        priorityQueue = new ArrayPriorityQueue<>(Integer.class, 100);
    }


}
