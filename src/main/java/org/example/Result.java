package org.example;

public class Result {
    private double maxProfit;
    private double[] values;

    public Result() {
        values = new double[4];
    }

    public double getMaxProfit() {
        return maxProfit;
    }

    public void setMaxProfit(double maxProfit) {
        this.maxProfit = maxProfit;
    }

    public double[] getValues() {
        return values;
    }

    public void setValues(double[] values) {
        this.values = values;
    }
}
