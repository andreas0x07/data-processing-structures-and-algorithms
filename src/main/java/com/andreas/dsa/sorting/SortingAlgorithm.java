package com.andreas.dsa.sorting;

import com.andreas.dsa.model.SortingMetrics;

public interface SortingAlgorithm {
    SortingMetrics sort(int[] a);
    String getName();
}
