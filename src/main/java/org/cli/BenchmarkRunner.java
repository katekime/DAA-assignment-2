package org.cli;

import org.algorithm.MaxHeap;
import org.metrics.PerformanceTracker;

import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int[] sizes = {100, 1_000, 10_000};
        int runs = 5;

        for (int size : sizes) {
            System.out.println("Benchmark size");
            long totalComparisons = 0;
            long totalSwaps = 0;
            long totalAccesses = 0;
            long totalTime = 0;

            for (int r = 0; r < runs; r++) {
                int[] data = generateRandomArray(size);
                PerformanceTracker tracker = new PerformanceTracker();
                MaxHeap heap = new MaxHeap(size, tracker);

                long start = System.nanoTime();
                heap.heapSort(data);
                long end = System.nanoTime();

                totalTime += (end - start);
                totalComparisons += tracker.getComparisons();
                totalSwaps += tracker.getSwaps();
                totalAccesses += tracker.getArrayAccesses();
            }

            System.out.println("Avg time (ns): " + totalTime / runs);
            System.out.println("Avg comparisons: " + totalComparisons / runs);
            System.out.println("Avg swaps: " + totalSwaps / runs);
            System.out.println("Avg array accesses: " + totalAccesses / runs);
        }
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10_000);
        }
        return arr;
    }
}