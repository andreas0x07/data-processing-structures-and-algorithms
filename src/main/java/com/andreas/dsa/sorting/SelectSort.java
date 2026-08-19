package com.andreas.dsa.sorting;

import com.andreas.dsa.model.SortingMetrics;
import com.andreas.dsa.util.ArrayUtils;

import java.util.Objects;

public class SelectSort extends AbstractSortingAlgorithm{

    @Override
    public String getName() {
        return "SelectionSort";
    }

    @Override
    protected SortingMetrics doSort(int[] a) {
        int arraySize = a.length;
        long moves = 0;
        long comparisons = 0;

        for (int i = 0; i < arraySize - 1; i++) {
            int minIndex = i;
            for (int k = i + 1; k < arraySize; k++) {
                if (a[k] < a[minIndex]) {
                    minIndex = k;
                }
                comparisons++;
            }
            int t = a[i];
            a[i] = a[minIndex];
            a[minIndex] = t;
            moves += 3;
        }

        long movesTheoretical = arraySize > 0 ? (arraySize - 1) * 3L : 0;
        long comparisonsTheoretical = ((long) arraySize * (arraySize-1))/2;

        return new SortingMetrics(
                getName(),
                arraySize,
                ArrayUtils.runCount(a),
                ArrayUtils.checkSum(a),
                moves,
                comparisons,
                movesTheoretical,
                comparisonsTheoretical,
                0L
        );
    }
}
