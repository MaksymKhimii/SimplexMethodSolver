package org.example;

public class Main {
    public static void main(String[] args) {
        double[][] costs = {
                {21, 17, 12, 24, 30},
                {6, 11, 9, 5, 9},
                {7, 8, 24, 6, 13},
                {29, 22, 21, 5, 7}};
        double[] supply = {19, 19, 17, 21};
        double[] demand = {15, 14, 16, 15, 15};
        TransportProblemSolver solver = new TransportProblemSolver(costs, supply, demand);
        double[][] solution = solver.solve();
        for (int i = 0; i < supply.length; i++) {
            for (int j = 0; j < demand.length; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }
}
