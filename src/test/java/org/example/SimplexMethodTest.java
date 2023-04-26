package org.example;

import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.LinearConstraintSet;
import org.apache.commons.math3.optim.linear.LinearObjectiveFunction;
import org.apache.commons.math3.optim.linear.Relationship;
import org.junit.Assert;
import org.junit.Test;

import static org.example.SimplexMethod.solve;


public class SimplexMethodTest {
    private static final double DELTA = 1e-15;

    @Test
    public void test1(){
        Result expectedResult = new Result();
        expectedResult.setMaxProfit(4634.482758620689);
        LinearObjectiveFunction f = new LinearObjectiveFunction(new double[]{900, 200, 40, 0}, 0);
        LinearConstraintSet constraints = new LinearConstraintSet(
                new LinearConstraint(new double[]{25, 8, 1, 0}, Relationship.LEQ, 300),
                new LinearConstraint(new double[]{4, 3, 1, 0}, Relationship.LEQ, 40),
                new LinearConstraint(new double[]{100, 70, 4, 0}, Relationship.LEQ, 550),
                new LinearConstraint(new double[]{1, 0, 0, 0}, Relationship.LEQ, 4),
                new LinearConstraint(new double[]{0, 1, 0, 0}, Relationship.GEQ, 0),
                new LinearConstraint(new double[]{0, 0, 1, 0}, Relationship.GEQ, 0),
                new LinearConstraint(new double[]{0, 0, 0, 1}, Relationship.GEQ, 0));

        Result actualResult = solve(f, constraints);
        Assert.assertEquals(expectedResult.getMaxProfit(), actualResult.getMaxProfit(), DELTA);
    }

    @Test
    public void test2(){
        Result expectedResult = new Result();
        expectedResult.setMaxProfit(1812.0);
        LinearObjectiveFunction f = new LinearObjectiveFunction(new double[]{6, 2, 3, 5}, 0);
        LinearConstraintSet constraints = new LinearConstraintSet(
                new LinearConstraint(new double[]{3, 1, 0, 2}, Relationship.LEQ, 900),
                new LinearConstraint(new double[]{4, 0, 1, 4}, Relationship.LEQ, 800),
                new LinearConstraint(new double[]{0, 1, 2, 1}, Relationship.LEQ, 600),
                new LinearConstraint(new double[]{1, 0, 0, 0}, Relationship.LEQ, 4),
                new LinearConstraint(new double[]{0, 1, 0, 0}, Relationship.GEQ, 0),
                new LinearConstraint(new double[]{0, 0, 1, 0}, Relationship.GEQ, 0),
                new LinearConstraint(new double[]{0, 0, 0, 1}, Relationship.GEQ, 0));

        Result actualResult = solve(f, constraints);
        Assert.assertEquals(expectedResult.getMaxProfit(), actualResult.getMaxProfit(), DELTA);
    }
}
