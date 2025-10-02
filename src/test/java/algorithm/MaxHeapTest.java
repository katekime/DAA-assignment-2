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
    void testPeek() {
        MaxHeap heap = new MaxHeap(5);
        heap.insert(10);
        heap.insert(20);
        assertEquals(20, heap.peek());
        assertEquals(20, heap.peek());
    }
    @Test
    void testBuildHeap() {
        int[] arr = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
        MaxHeap heap = new MaxHeap(arr.length);
        heap.buildHeap(arr);

        assertEquals(20, heap.peek());
    }

    @Test
    void testHeapEmptyExtract() {
        MaxHeap heap = new MaxHeap(5);
        assertThrows(IllegalStateException.class, heap::extractMax);
    }
}
