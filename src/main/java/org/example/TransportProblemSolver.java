package org.example;
/*
package org.example;


import java.util.Arrays;

public class TransportProblemSolver {

    private final double[][] costs;
    private final double[] supply;
    private final double[] demand;
    private final double[][] solution;

    public TransportProblemSolver(double[][] costs, double[] supply, double[] demand) {
        this.costs = costs;
        this.supply = supply;
        this.demand = demand;
        this.solution = new double[supply.length][demand.length];
    }

    public void solve() {
        while (true) {
            int[] enteringCell = findEnteringCell();
            if (enteringCell == null) {
                break;
            }
            int i = enteringCell[0];
            int j = enteringCell[1];
            double minQuantity = Math.min(supply[i], demand[j]);
            solution[i][j] = minQuantity;
            supply[i] -= minQuantity;
            demand[j] -= minQuantity;
        }
    }

    private int[] findEnteringCell() {
        int[] result = new int[2];
        double maxReduction = Arrays.stream(costs)
                .flatMapToDouble(Arrays::stream)
                .max().orElse(0);
        for (int i = 0; i < supply.length; i++) {
            for (int j = 0; j < demand.length; j++) {
                if (supply[i] > 0 && demand[j] > 0 && solution[i][j] == 0) {
                    int finalJ = j;
                    double reduction = costs[i][j] - Arrays.stream(solution[i])
                            .sum() - Arrays.stream(solution)
                            .mapToDouble(row -> row[finalJ])
                            .sum();
                    if (reduction < maxReduction) {
                        maxReduction = reduction;
                        result[0] = i;
                        result[1] = j;
                    }
                }
            }
        }
        return maxReduction == 0 ? null : result;
    }

    public double[][] getSolution() {
        return solution;
    }
}

*/

public class TransportProblemSolver {
    private final double[][] costs;
    private final double[] supply;
    private final double[] demand;
    private final double[][] solution;

    public TransportProblemSolver(double[][] costs, double[] supply, double[] demand) {
        this.costs = costs;
        this.supply = supply;
        this.demand = demand;
        this.solution = new double[supply.length][demand.length];
    }

    public double[][] solve() {
        while (true) {
            int[] enteringCell = findEnteringCell();
            if (enteringCell == null) {
                break;
            }
            int i = enteringCell[0];
            int j = enteringCell[1];
            double minQuantity = Math.min(supply[i], demand[j]);
            solution[i][j] = minQuantity;
            supply[i] -= minQuantity;
            demand[j] -= minQuantity;
        }
        return solution;
    }

    private int[] findEnteringCell() {
        double maxCost = Double.NEGATIVE_INFINITY;
        int maxI = -1;
        int maxJ = -1;
        for (int i = 0; i < supply.length; i++) {
            for (int j = 0; j < demand.length; j++) {
                if (supply[i] > 0 && demand[j] > 0 && costs[i][j] > maxCost) {
                    maxCost = costs[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        return maxI == -1 ? null : new int[]{maxI, maxJ};
    }
}
