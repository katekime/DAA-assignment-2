package algorithm;

import org.algorithm.MaxHeap;
import org.junit.jupiter.api.Test;
import org.metrics.PerformanceTracker;

import static org.junit.jupiter.api.Assertions.*;

public class MaxHeapTest {
    @Test
    void testInsertAndExtractMax() {
        PerformanceTracker tracker = new PerformanceTracker();
        MaxHeap heap = new MaxHeap(10, tracker);
        heap.insert(5);
        heap.insert(20);
        heap.insert(15);

        assertEquals(20, heap.extractMax());
        assertEquals(15, heap.extractMax());
        assertEquals(5, heap.extractMax());
    }
    @Test
    void testPeek() {
        PerformanceTracker tracker = new PerformanceTracker();
        MaxHeap heap = new MaxHeap(5, tracker);
        heap.insert(10);
        heap.insert(20);
        assertEquals(20, heap.peek());
        assertEquals(20, heap.peek());
    }
    @Test
    void testBuildHeap() {
        PerformanceTracker tracker = new PerformanceTracker();
        int[] arr = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
        MaxHeap heap = new MaxHeap(arr.length, tracker);
        heap.buildHeap(arr);

        assertEquals(20, heap.peek());
    }
    @Test
    void testHeapSort() {
        PerformanceTracker tracker = new PerformanceTracker();
        int[] arr = {4, 10, 3, 5, 1};
        MaxHeap heap = new MaxHeap(arr.length, tracker);
        int[] sorted = heap.heapSort(arr);

        assertArrayEquals(new int[]{1, 3, 4, 5, 10}, sorted);
    }

    @Test
    void testHeapEmptyExtract() {
        PerformanceTracker tracker = new PerformanceTracker();
        MaxHeap heap = new MaxHeap(5, tracker);
        assertThrows(IllegalStateException.class, heap::extractMax);
    }
    @Test
    void testSizeAndIsEmpty() {
        PerformanceTracker tracker = new PerformanceTracker();
        MaxHeap heap = new MaxHeap(5, tracker);
        assertTrue(heap.isEmpty());
        heap.insert(7);
        assertEquals(1, heap.size());
    }
}
