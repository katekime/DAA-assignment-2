package org.algorithm;

import org.metrics.PerformanceTracker;

public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;
    private PerformanceTracker tracker;

    public MaxHeap(int capacity, PerformanceTracker tracker) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
        this.tracker = tracker;
    }
    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i) { return 2 * i + 1; }
    private int rightChild(int i) { return 2 * i + 2; }

    public void insert(int value) {
        if (size == capacity) {
            throw new IllegalStateException("heap is full");
        }
        heap[size] = value;
        tracker.incrementArrayAccesses();
        size++;
        heapifyUp(size - 1);

    }

    public int extractMax() {
        if (size == 0) {
            throw new IllegalStateException("heap is empty");
        }
        int max = heap[0];
        tracker.incrementArrayAccesses();
        heap[0] = heap[size - 1];
        tracker.incrementArrayAccesses();
        size--;
        heapifyDown(0);
        return max;
    }

    private void heapifyUp(int index) {
        while (index > 0 && heap[index] > heap[parent(index)]) {
            tracker.incrementComparisons();
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void heapifyDown(int index) {
        while (index < size) {
            int left = leftChild(index);
            int right = rightChild(index);
            int largest = index;

            if (left < size && heap[left] > heap[largest]) {
                largest = left;
            }
            if (right < size && heap[right] > heap[largest]) {
                largest = right;
            }
            if (largest != index) {
                swap(index, largest);
                index = largest;
            } else {
                break;
            }
        }
    }
    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("heap is empty");
        }
        tracker.incrementArrayAccesses();
        return heap[0];
    }
    public void buildHeap(int[] arr) {
        size = arr.length;
        heap = new int[size];
        System.arraycopy(arr, 0, heap, 0, size);
        tracker.incrementArrayAccesses();

        for (int i = (size / 2) - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }
    public int[] heapSort(int[] arr) {
        buildHeap(arr);
        int[] sorted = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            sorted[i] = extractMax();
        }
        return sorted;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
        tracker.incrementSwaps();
        tracker.incrementArrayAccesses();
    }
}
