package com.andreas.dsa.sorting;

import com.andreas.dsa.model.SortingMetrics;

import java.util.Objects;

public abstract class AbstractSortingAlgorithm implements SortingAlgorithm{

    @Override
    public SortingMetrics sort(int[] a) {
        Objects.requireNonNull(a, "Array 'a' must not be null");

        long startTime = System.nanoTime();

        SortingMetrics sortingMetrics = doSort(a);

        long executionTime = System.nanoTime() - startTime;

        return sortingMetrics.withExecutionTime(executionTime);
    }

    protected abstract SortingMetrics doSort(int[] a);
}
