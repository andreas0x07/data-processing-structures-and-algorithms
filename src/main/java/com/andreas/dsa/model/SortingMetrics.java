package com.andreas.dsa.model;

public record SortingMetrics (
        String algorithmName,
        int arraySize,

        int runCount,
        long checkSum,

        long moves,
        long comparisons,
        long movesTheoretical,
        long comparisonsTheoretical,

        long executionTimeNanos
) {
    public boolean isSortedCorrectly() {
        return arraySize == 0 || runCount == 1;
    }

    public SortingMetrics withExecutionTime(long executionTime) {
        return new SortingMetrics(
                this.algorithmName,
                this.arraySize,
                this.runCount,
                this.checkSum,
                this.moves,
                this.comparisons,
                this.movesTheoretical,
                this.comparisonsTheoretical,
                executionTime
        );
    }
}
