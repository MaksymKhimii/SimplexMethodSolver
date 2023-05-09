package org.example;

import org.apache.commons.math3.optim.linear.*;
import org.apache.commons.math3.optim.*;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

public class SimplexMethod {

    public static void main(String[] args) {
        LinearObjectiveFunction f = new LinearObjectiveFunction(new double[]{900, 200, 40, 0}, 0);
        LinearConstraintSet constraints = new LinearConstraintSet(
                new LinearConstraint(new double[]{25, 8, 1, 0}, Relationship.LEQ, 300),
                new LinearConstraint(new double[]{4, 3, 1, 0}, Relationship.LEQ, 40),
                new LinearConstraint(new double[]{100, 70, 4, 0}, Relationship.LEQ, 550),
                new LinearConstraint(new double[]{1, 0, 0, 0}, Relationship.LEQ, 4),
                new LinearConstraint(new double[]{0, 1, 0, 0}, Relationship.GEQ, 0),
                new LinearConstraint(new double[]{0, 0, 1, 0}, Relationship.GEQ, 0),
                new LinearConstraint(new double[]{0, 0, 0, 1}, Relationship.GEQ, 0));

        Result result = solve(f, constraints);
        System.out.println("Решение найдено:");
        System.out.println("x1 = " + result.getValues()[0]);
        System.out.println("x2 = " + result.getValues()[1]);
        System.out.println("x3 = " + result.getValues()[2]);
        System.out.println("x4 = " + result.getValues()[3]);
        System.out.println("Значение целевой функции = " + result.getMaxProfit());
    }

    public static Result solve(LinearObjectiveFunction f, LinearConstraintSet constraints) {
        Result result = new Result();
        SimpleBounds bounds = new SimpleBounds(
                new double[]{0, 0, 0, 0},
                new double[]{
                        Double.MAX_VALUE,
                        Double.MAX_VALUE,
                        Double.MAX_VALUE,
                        Double.MAX_VALUE});
        PointValuePair solution;
        try {
            solution = new SimplexSolver().optimize(
                    new MaxIter(100),
                    f,
                    constraints,
                    bounds,
                    GoalType.MAXIMIZE
            );
        } catch (NoFeasibleSolutionException e) {
           throw new NegativeArraySizeException("Error");
        }
        if (solution != null) {
            result.setValues(solution.getPoint());
            result.setMaxProfit(solution.getValue());
        } else {
            result.setValues(null);
            result.setMaxProfit(0);
        }
        return result;
    }
}