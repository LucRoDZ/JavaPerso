package fr.epita.assistants.maths;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MatrixTests {

    // Matrix constructor 4 tests
    @Test
    void testConstructor_Valid() {
        int[][] data = {{1, 2}, {3, 4}};
        Matrix matrix = new Matrix(data);
        assertArrayEquals(data, matrix.getMatrix(), "should store the matrix correctly");
    }

    @Test
    void testConstructor_Empty() {
        int[][] emptyData = {};
        Matrix emptyMatrix = new Matrix(emptyData);
        assertArrayEquals(emptyData, emptyMatrix.getMatrix(), "should handle empty matrices.");
    }

    @Test
    void testConstructor_Null() {
        assertThrows(NullPointerException.class, () -> new Matrix(null), "should raise an exception for null");
    }

    @Test
    void testConstructor_Inconsistent() {
        int[][] inconsistentData = {{1, 2}, {3}};
        Matrix inconsistentMatrix = new Matrix(inconsistentData);
        assertArrayEquals(inconsistentData, inconsistentMatrix.getMatrix(), "should store the array.");
    }

    // equals 4 tests
    @Test
    void testEquals_Same() {
        int[][] data = {{1, 2}, {3, 4}};
        Matrix matrix1 = new Matrix(data);
        Matrix matrix2 = new Matrix(data);
        assertTrue(matrix1.equals(matrix2), "should return true for same matrice");
    }

    @Test
    void testEquals_Different() {
        int[][] data1 = {{1, 2}, {3, 4}};
        int[][] data2 = {{4, 3}, {2, 1}};
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);
        assertFalse(matrix1.equals(matrix2), "should return false for two different matrices");
    }

    @Test
    void testEquals_Null() {
        int[][] data = {{1, 2}, {3, 4}};
        Matrix matrix = new Matrix(data);
        assertFalse(matrix.equals(null), "should return false for a null");
    }

    @Test
    void testEquals_DifferentType() {
        int[][] data = {{1, 2}, {3, 4}};
        Matrix matrix = new Matrix(data);
        assertFalse(matrix.equals("Not a Matrix"), "should return false for a non Matrix");
    }

    // multiply 2 tests
    @Test
    void testMultiply_Valid() {
        int[][] data1 = {{1, 2}, {3, 4}};
        int[][] data2 = {{2, 0}, {1, 2}};
        int[][] expected = {{4, 4}, {10, 8}};

        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);
        Matrix result = matrix1.multiply(matrix2);

        assertArrayEquals(expected, result.getMatrix(), "result is incorrect");
    }

    @Test
    void testMultiply_Incompatible() {
        int[][] data1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] data2 = {{1, 2}, {3, 4}};
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);

        assertThrows(IllegalArgumentException.class, () -> matrix1.multiply(matrix2), "should throw an exception for " +
                "incompatible matrices");
    }
}
