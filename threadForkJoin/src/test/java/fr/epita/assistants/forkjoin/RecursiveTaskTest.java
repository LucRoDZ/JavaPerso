package fr.epita.assistants.forkjoin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Timeout(1)
public class RecursiveTaskTest {
    @Test
    void exampleTest() {
        double[][] matrix = new double[][]{
                new double[]{10, 52, 100, 50, 74, 25},
                new double[]{10, 52, 100, 50, 74, 25},
                new double[]{10, 52, 100, 50, 74, 25},
                new double[]{10, 52, 100, 50, 74, 25},
                new double[]{10, 52, 100, 50, 74, 25},
                new double[]{10, 52, 100, 50, 74, 25}
        };
        double expected = 51.83;

        MyRecursiveTask mrt = new MyRecursiveTask(matrix, 0, matrix[0].length, 0, matrix.length);

        mrt.fork();
        double got = mrt.join();

        assertEquals(expected, got, 0.01);
    }

    @Test
    void testUniformMatrix() {
        double[][] matrix = new double[][]{
                {5, 5, 5},
                {5, 5, 5},
                {5, 5, 5}
        };
        double expected = 5.0;
        MyRecursiveTask mrt = new MyRecursiveTask(matrix, 0, matrix[0].length, 0, matrix.length);
        mrt.fork();
        double got = mrt.join();
        assertEquals(expected, got, 0.01);
    }

    @Test
    void testNonUniformMatrix() {
        double[][] matrix = new double[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        double expected = 5.0;
        MyRecursiveTask mrt = new MyRecursiveTask(matrix, 0, matrix[0].length, 0, matrix.length);
        mrt.fork();
        double got = mrt.join();
        assertEquals(expected, got, 0.01);
    }

    @Test
    void testSingleElementMatrix() {
        double[][] matrix = new double[][]{{42}};
        double expected = 42.0;
        MyRecursiveTask mrt = new MyRecursiveTask(matrix, 0, matrix[0].length, 0, matrix.length);
        mrt.fork();
        double got = mrt.join();
        assertEquals(expected, got, 0.01);
    }

    @Test
    void testEmptyMatrix() {
        double[][] matrix = new double[][]{};
        double expected = 0.0;
        MyRecursiveTask mrt = new MyRecursiveTask(matrix, 0, 0, 0, 0);
        mrt.fork();
        double got = mrt.join();
        assertEquals(expected, got, 0.01);
    }

    @Test
    void testLargeMatrix() {
        double[][] matrix = new double[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matrix[i][j] = i + j;
            }
        }
        double expected = 9.0;
        MyRecursiveTask mrt = new MyRecursiveTask(matrix, 0, matrix[0].length, 0, matrix.length);
        mrt.fork();
        double got = mrt.join();
        assertEquals(expected, got, 0.01);
    }
}
