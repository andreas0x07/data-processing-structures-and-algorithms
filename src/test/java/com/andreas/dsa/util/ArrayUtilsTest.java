package com.andreas.dsa.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ArrayUtilsTest {
    @Nested
    @DisplayName("fillInc() Tests")
    class FillInc {
        @Test
        @DisplayName("Should fill array in ascending order")
        void shouldFillArrayInAscendingOrder() {
            // Arrange
            int[] a = new int[5];

            // Act
            ArrayUtils.fillInc(a);

            // Assert
            assertThat(a).containsExactly(1, 2, 3, 4, 5);
        }

        @Test
        @DisplayName("Should handle array of length 1")
        void shouldHandleArrayOfLengthOne() {
            // Arrange
            int[] a = new int[1];

            // Act
            ArrayUtils.fillInc(a);

            //Assert
            assertThat(a).containsExactly(1);
        }

        @Test
        @DisplayName("Should handle empty array gracefully without throwing an exception")
        void shouldHandleEmptyArrayGracefully() {
            // Arrange
            int[] a = new int[0];

            // Act
            ArrayUtils.fillInc(a);

            // Assert
            assertThat(a).isEmpty();
        }

        @Test
        @DisplayName("Should throw NullPointerException when array is null")
        void shouldThrowNullPointerExceptionWhenArrayIsNull() {
            // Arrange & Act & Assert
            assertThatThrownBy(() -> ArrayUtils.fillInc(null))
                    .isInstanceOf(NullPointerException.class)
                    .hasMessage("Array 'a' must not be null");
        }
    }

    @Nested
    @DisplayName("fillDec() Tests")
    class FillDec {
        @Test
        @DisplayName("Should fill array in descending order")
        void shouldFillArrayInDescendingOrder() {
            // Arrange
            int[] a = new int[5];

            // Act
            ArrayUtils.fillDec(a);

            // Assert
            assertThat(a).containsExactly(5, 4, 3, 2, 1);
        }

        @Test
        @DisplayName("Should handle array of length 1")
        void shouldHandleArrayOfLengthOne() {
            // Arrange
            int[] a = new int[1];

            // Act
            ArrayUtils.fillDec(a);

            //Assert
            assertThat(a).containsExactly(1);
        }

        @Test
        @DisplayName("Should handle empty array gracefully without throwing an exception")
        void shouldHandleEmptyArrayGracefully() {
            // Arrange
            int[] a = new int[0];

            // Act
            ArrayUtils.fillDec(a);

            // Assert
            assertThat(a).isEmpty();
        }

        @Test
        @DisplayName("Should throw NullPointerException when array is null")
        void shouldThrowNullPointerExceptionWhenArrayIsNull() {
            // Arrange & Act & Assert
            assertThatThrownBy(() -> ArrayUtils.fillDec(null))
                    .isInstanceOf(NullPointerException.class)
                    .hasMessage("Array 'a' must not be null");
        }
    }

    @Nested
    @DisplayName("fillRand() Tests")
    class FillRand {
        @Test
        @DisplayName("Should fill array with random numbers")
        void shouldFillArrayRandomly() {
            // Arrange & Act & Assert
            int[] a = new int[5];
            Random seededRandom = new Random(42L);
            ArrayUtils.fillRand(a, 1, 10, seededRandom);

            assertThat(a).containsExactly(1, 4, 9, 5, 1);
        }

        @Test
        @DisplayName("Should throw NullPointerException when array 'a' is null")
        void shouldThrowNullPointerExceptionWhenArrayIsNull() {
            // Arrange & Act & Assert
            assertThatThrownBy(() -> ArrayUtils.fillRand(null, 1, 10))
                    .isInstanceOf(NullPointerException.class)
                    .hasMessage("Array 'a' must not be null");
        }

        @Test
        @DisplayName("Should throw NullPointerException when Random 'random' is null")
        void shouldThrowNullPointerExceptionWhenRandomIsNull() {
            // Arrange & Act & Assert
            int[] a = new int[5];
            Random seededRandom = new Random(42L);
            assertThatThrownBy(() -> ArrayUtils.fillRand(a, 1, 10, null))
                    .isInstanceOf(NullPointerException.class)
                    .hasMessage("Random 'random' must not be null");
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException when max is less than min")
        void shouldThrowIllegalArgumentExceptionWhenMaxIsLessThanMin() {
            // Arrange & Act & Assert
            int[] a = new int[5];
            assertThatThrownBy(() -> ArrayUtils.fillRand(a, 5, 4))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("min (5) must not be greater than max (4)");
        }

        @Test
        @DisplayName("Should handle min being equal to max")
        void shouldHandleMinBeingEqualToMax() {
            // Arrange & Act & Assert
            int[] a = new int[5];
            ArrayUtils.fillRand(a, 4, 4);
            assertThat(a).containsExactly(4, 4, 4, 4, 4);
        }
    }

    @Nested
    @DisplayName("checkSum() Tests")
    class CheckSum {
        @Test
        @DisplayName("Should calculate the sum of all numbers in the array if they are positive")
        void shouldCalculateSumOfAllNumbersIfTheyArePositive() {
            // Arrange
            int[] a = {1, 2, 3, 4, 5};

            // Act
            long result = ArrayUtils.checkSum(a);

            // Assert
            assertThat(result).isEqualTo(15);
        }

        @Test
        @DisplayName("Should calculate the sum of all numbers in the array if they are negative")
        void shouldCalculateSumOfAllNumbersIfTheyAreNegative() {
            // Arrange
            int[] a = {-1, -2, -3, -4, -5};

            // Act
            long result = ArrayUtils.checkSum(a);

            // Assert
            assertThat(result).isEqualTo(-15);
        }

        @Test
        @DisplayName("Should calculate the sum of all numbers if they're both positive and negative and 0")
        void shouldCalculateSumOfAllNumbersIfTheyAreNegativeAndPositiveAndZero() {
            // Arrange
            int[] a = {0, -1, 2, -3, -4, 5};

            // Act
            long result = ArrayUtils.checkSum(a);

            // Assert
            assertThat(result).isEqualTo(-1);
        }

        @Test
        @DisplayName("Should handle single positive number")
        void shouldHandleArrayOfLengthOne() {
            // Arrange
            int[] a = {1};

            // Act
            long result = ArrayUtils.checkSum(a);

            //Assert
            assertThat(result).isEqualTo(1);
        }

        @Test
        @DisplayName("Should handle negative numbers 1")
        void shouldHandleArrayWithNegativeNumbers() {
            // Arrange
            int[] a = {-1};

            // Act
            long result = ArrayUtils.checkSum(a);

            //Assert
            assertThat(result).isEqualTo(-1);
        }

        @Test
        @DisplayName("Should handle the single number 0")
        void shouldHandleArrayWithSingularZero() {
            // Arrange
            int[] a = {0};

            // Act
            long result = ArrayUtils.checkSum(a);

            //Assert
            assertThat(result).isEqualTo(0);
        }

        @Test
        @DisplayName("Should handle empty array gracefully without throwing an exception")
        void shouldHandleEmptyArrayGracefully() {
            // Arrange
            int[] a = new int[0];

            // Act
            long result = ArrayUtils.checkSum(a);

            // Assert
            assertThat(result).isEqualTo(0);
        }

        @Test
        @DisplayName("Should throw NullPointerException when array is null")
        void shouldThrowNullPointerExceptionWhenArrayIsNull() {
            // Arrange & Act & Assert
            assertThatThrownBy(() -> ArrayUtils.checkSum(null))
                    .isInstanceOf(NullPointerException.class)
                    .hasMessage("Array 'a' must not be null");
        }
    }

    @Nested
    @DisplayName("runCount() Tests")
    class RunCount {
        @Test
        @DisplayName("Should correctly count if one single run is present")
        void shouldCountIfSingleRun() {
            // Arrange
            int[] a = {1, 2, 3, 4, 5};

            // Act
            int result = ArrayUtils.runCount(a);

            // Assert
            assertThat(result).isEqualTo(1);
        }

        @Test
        @DisplayName("Should correctly count if number of runs is equal to the amount of elements")
        void shouldCountIfNumberOfRunsEqualToElements() {
            // Arrange
            int[] a = {5, 4, 3, 2, 1};

            // Act
            int result = ArrayUtils.runCount(a);

            // Assert
            assertThat(result).isEqualTo(5);
        }

        @Test
        @DisplayName("Should correctly count if number of runs if all elements are equal")
        void shouldCountIfAllElementsEqual() {
            // Arrange
            int[] a = {5, 5, 5, 5, 5};

            // Act
            int result = ArrayUtils.runCount(a);

            // Assert
            assertThat(result).isEqualTo(1);
        }

        @Test
        @DisplayName("Should correctly count if one single element in array")
        void shouldCountIfOneElementInArray() {
            // Arrange
            int[] a = {5};

            // Act
            int result = ArrayUtils.runCount(a);

            // Assert
            assertThat(result).isEqualTo(1);
        }

        @Test
        @DisplayName("Should correctly handle negative numbers and 0's")
        void shouldHandleNegativeNumbersAndZeroes() {
            // Arrange
            int[] a = {-1, -10, -9, 0, 0, -1, 10, 8, 7};

            // Act
            int result = ArrayUtils.runCount(a);

            // Assert
            assertThat(result).isEqualTo(5);
        }

        @Test
        @DisplayName("Should throw NullPointerException when array is null")
        void shouldThrowExceptionWhenArrayIsNull() {
            // Arrange & Act & Assert
            assertThatThrownBy(() -> ArrayUtils.runCount(null))
                    .isInstanceOf(NullPointerException.class)
                    .hasMessage("Array 'a' must not be null");
        }

        @Test
        @DisplayName("Should return 0 when array is of length zero")
        void shouldReturnZeroIfArrayLengthIsZero() {
            // Arrange
            int[] a = {};

            // Act
            int result = ArrayUtils.runCount(a);

            // Assert
            assertThat(result).isEqualTo(0);
        }
    }

    @Nested
    @DisplayName("printArray() Tests")
    @ExtendWith(OutputCaptureExtension.class)
    class PrintArray {
        @Test
        @DisplayName("Should correctly print array")
        void shouldPrintArray(CapturedOutput output) {
            // Arrange
            int[] a = {-1, -10, -9, 0, 0, -1, 10, 8, 7};

            // Act
            ArrayUtils.printArray(a);

            // Assert
            assertThat(output.getOut()).contains("[-1, -10, -9, 0, 0, -1, 10, 8, 7]");
        }

        @Test
        @DisplayName("Should correctly print array consisting of one single element")
        void shouldPrintSingleElementArray(CapturedOutput output) {
            // Arrange
            int[] a = {-1};

            // Act
            ArrayUtils.printArray(a);

            // Assert
            assertThat(output.getOut()).contains("[-1]");
        }

        @Test
        @DisplayName("Should correctly print empty array")
        void shouldPrintEmptyArray(CapturedOutput output) {
            // Arrange
            int[] a = {};

            // Act
            ArrayUtils.printArray(a);

            // Assert
            assertThat(output.getOut()).contains("[]");
        }

        @Test
        @DisplayName("Should correctly print 'null' if passed array is null")
        void shouldPrintNullifArrayIsNull(CapturedOutput output) {
            // Arrange & Act
            ArrayUtils.printArray(null);

            // Assert
            assertThat(output.getOut()).contains("null");
        }
    }
}

