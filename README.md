The project implements a Max Heap data structure using Java.
The Max Heap allows efficient insertion, extraction of the maximum element, and heap-based sorting.
All operations are tracked using a custom PerformanceTracker to measure comparisons, swaps, and array accesses.

Implementation Summary

The implementation follows the standard heap structure using an array.
It includes the main heap operations — insert, extractMax, peek, buildHeap, and heapSort.
Performance tracking is integrated into each operation to analyze efficiency.
The project also includes JUnit tests to ensure correctness and stability of the implementation.

Performance Analysis

The algorithm was tested with input sizes of 100, 1,000, and 10,000 elements.
Results confirmed the expected logarithmic growth of runtime and linearithmic behavior for heap sort.

<img width="328" height="422" alt="image" src="https://github.com/user-attachments/assets/24e915b8-dfbd-490f-9823-5b871293c6af" />

The results match theoretical expectations. Heap sort shows stable performance even for large input sizes.

Conclusion

The MaxHeap implementation is correct, efficient, and well-structured.
Benchmark results confirm the logarithmic behavior of heap operations.
The use of the PerformanceTracker provided clear insight into the algorithm’s operational cost.
The code is clean, modular, and ready for integration into further analysis or peer review.
