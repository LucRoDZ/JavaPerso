package fr.epita.assistants.forkjoin;

import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Double> {
    private final double[][] matrix;
    final private int xLowerBound;
    final private int xUpperBound;
    final private int yLowerBound;
    final private int yUpperBound;

    public MyRecursiveTask(double[][] matrix, int xLowerBound, int xUpperBound,
                           int yLowerBound, int yUpperBound) {
        this.matrix = matrix;
        this.xLowerBound = xLowerBound;
        this.xUpperBound = xUpperBound;
        this.yLowerBound = yLowerBound;
        this.yUpperBound = yUpperBound;
    }

    @Override
    protected Double compute() {
        int width = xUpperBound - xLowerBound;
        int height = yUpperBound - yLowerBound;

        if (width <= 5 && height <= 5) {
            return computeDirectly();
        } else {
            int midX = xLowerBound + width / 2;
            int midY = yLowerBound + height / 2;

            MyRecursiveTask topLeft = new MyRecursiveTask(matrix, xLowerBound, midX, yLowerBound, midY);
            MyRecursiveTask topRight = new MyRecursiveTask(matrix, midX, xUpperBound, yLowerBound, midY);
            MyRecursiveTask bottomLeft = new MyRecursiveTask(matrix, xLowerBound, midX, midY, yUpperBound);
            MyRecursiveTask bottomRight = new MyRecursiveTask(matrix, midX, xUpperBound, midY, yUpperBound);

            topLeft.fork();
            topRight.fork();
            bottomLeft.fork();
            double bottomRightResult = bottomRight.compute();

            double sum = bottomRightResult + topLeft.join() + topRight.join() + bottomLeft.join();
            return sum / 4;
        }
    }

    private Double computeDirectly() {
        double sum = 0;
        int count = 0;
        for (int i = yLowerBound; i < yUpperBound; i++) {
            for (int j = xLowerBound; j < xUpperBound; j++) {
                sum += matrix[i][j];
                count++;
            }
        }
        return count == 0 ? 0 : sum / count;
    }
}
