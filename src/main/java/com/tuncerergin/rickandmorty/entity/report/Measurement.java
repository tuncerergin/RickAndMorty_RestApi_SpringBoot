
package com.tuncerergin.rickandmorty.entity.report;

public class Measurement {


    private String statistic;

    private double value;

    public String getStatistic() {
        return statistic;
    }

    public void setStatistic(String statistic) {
        this.statistic = statistic;
    }

    public int getValue() {
        return (int) value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "statistic='" + statistic + '\'' +
                ", value=" + value +
                '}';
    }
}
