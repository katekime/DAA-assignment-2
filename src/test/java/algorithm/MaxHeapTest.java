package algorithm;

import org.algorithm.MaxHeap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MaxHeapTest {
    @Test
    void testInsertAndExtractMax() {
        MaxHeap heap = new MaxHeap(10);
        heap.insert(5);
        heap.insert(20);
        heap.insert(15);

        assertEquals(20, heap.extractMax());
        assertEquals(15, heap.extractMax());
        assertEquals(5, heap.extractMax());
    }

    @Test
    void testHeapEmptyExtract() {
        MaxHeap heap = new MaxHeap(5);
        assertThrows(IllegalStateException.class, heap::extractMax);
    }
}
