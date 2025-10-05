package org.app;

import org.algorithm.MaxHeap;
import org.metrics.PerformanceTracker;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        PerformanceTracker tracker = new PerformanceTracker();
        MaxHeap heap = new MaxHeap(15, tracker);

        int[] data = {42, 19, 33, 7, 12, 99, 5, 3, 1};

        for (int num : data) {
            heap.insert(num);
            System.out.println("inserted: " + num);
        }

        System.out.println("peek max: " + heap.peek());
        System.out.println("extracted max: " + heap.extractMax());
        System.out.println("peek after extract: " + heap.peek());

        int[] sorted = heap.heapSort(data);
        System.out.println("sorted array: " + Arrays.toString(sorted));

        System.out.println("performance Report:");
        System.out.println(tracker);
    }
}

