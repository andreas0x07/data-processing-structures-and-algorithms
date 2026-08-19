package com.andreas.dsa.sorting;

import com.andreas.dsa.model.SortingMetrics;
import com.andreas.dsa.sorting.SelectSort;
import com.andreas.dsa.util.ArrayUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class SelectSortTest {

    private SelectSort selectSort;

    @BeforeEach
    void setUp() {
        selectSort = new SelectSort();
    }

    @Test
    @DisplayName("Should throw exception when passed array is null")
    void shouldThrowExceptionWhenArrayNull() {
        // Arrange & Act & Assert
        assertThatThrownBy(() -> selectSort.sort(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Array 'a' must not be null");
    }

    @Test
    @DisplayName("Should correctly handle empty arrays")
    void shouldCorrectlyHandleEmptyArrays() {
        // Arrange
        int[] a = {};
        long expectedM = 0;
        long expectedC = 0;

        // Act
        SortingMetrics metrics = selectSort.sort(a);

        // Assert
        assertThat(metrics.runCount()).isEqualTo(0);
        assertThat(metrics.checkSum()).isEqualTo(0);
        assertThat(metrics.moves()).isEqualTo(expectedM);
        assertThat(metrics.comparisons()).isEqualTo(expectedC);
        assertThat(metrics.movesTheoretical()).isEqualTo(expectedM);
        assertThat(metrics.comparisonsTheoretical()).isEqualTo(expectedC);
    }

    @Test
    @DisplayName("Should correctly handle array of length 1")
    void shouldCorrectlyHandleArraysOfLengthOne() {
        // Arrange
        int[] a = {-34};
        long expectedM = 0;
        long expectedC = 0;

        // Act
        SortingMetrics metrics = selectSort.sort(a);

        // Assert
        assertThat(metrics.runCount()).isEqualTo(1);
        assertThat(metrics.checkSum()).isEqualTo(-34);
        assertThat(metrics.moves()).isEqualTo(expectedM);
        assertThat(metrics.comparisons()).isEqualTo(expectedC);
        assertThat(metrics.movesTheoretical()).isEqualTo(expectedM);
        assertThat(metrics.comparisonsTheoretical()).isEqualTo(expectedC);
    }

    @Test
    @DisplayName("Should correctly handle array, filled in ascending order")
    void shouldCorrectlyHandleAlreadyFilledInAscendingOrder() {
        // Arrange
        int[] a = new int[100];
        ArrayUtils.fillInc(a);
        long expectedCheckSum = ArrayUtils.checkSum(a);
        long expectedM = 297;
        long expectedC = 4950;

        // Act
        SortingMetrics metrics = selectSort.sort(a);

        // Assert
        assertThat(metrics.runCount()).isEqualTo(1);
        assertThat(metrics.checkSum()).isEqualTo(expectedCheckSum);
        assertThat(metrics.moves()).isEqualTo(expectedM);
        assertThat(metrics.comparisons()).isEqualTo(expectedC);
        assertThat(metrics.movesTheoretical()).isEqualTo(expectedM);
        assertThat(metrics.comparisonsTheoretical()).isEqualTo(expectedC);
    }

    @Test
    @DisplayName("Should correctly handle array, filled in descending order")
    void shouldCorrectlyHandleAlreadyFilledInDescendingOrder() {
        // Arrange
        int[] a = new int[100];
        ArrayUtils.fillDec(a);
        long expectedCheckSum = ArrayUtils.checkSum(a);
        long expectedM = 297;
        long expectedC = 4950;

        // Act
        SortingMetrics metrics = selectSort.sort(a);

        // Assert
        assertThat(metrics.runCount()).isEqualTo(1);
        assertThat(metrics.checkSum()).isEqualTo(expectedCheckSum);
        assertThat(metrics.moves()).isEqualTo(expectedM);
        assertThat(metrics.comparisons()).isEqualTo(expectedC);
        assertThat(metrics.movesTheoretical()).isEqualTo(expectedM);
        assertThat(metrics.comparisonsTheoretical()).isEqualTo(expectedC);
    }

    @Test
    @DisplayName("Should correctly sort array")
    void shouldCorrectlySortArray() {
        // Arrange
        int[] a = {9, -1, 3, 3, 0, -34, 12, 0, -2, 4, 20};

        // Act
        selectSort.sort(a);

        // Assert
        assertThat(a).containsExactly(-34, -2, -1, 0, 0, 3, 3, 4, 9, 12, 20);
    }
}
