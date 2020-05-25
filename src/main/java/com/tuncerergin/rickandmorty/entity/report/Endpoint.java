
package com.tuncerergin.rickandmorty.entity.report;

import java.util.List;

public class Endpoint {


    private String name;

    private Object description;

    private String baseUnit;

    private List<Measurement> measurements = null;

    private List<AvailableTag> availableTags = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public String getBaseUnit() {
        return baseUnit;
    }

    public void setBaseUnit(String baseUnit) {
        this.baseUnit = baseUnit;
    }

    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<Measurement> measurements) {
        this.measurements = measurements;
    }

    public List<AvailableTag> getAvailableTags() {
        return availableTags;
    }

    public void setAvailableTags(List<AvailableTag> availableTags) {
        this.availableTags = availableTags;
    }

    @Override
    public String toString() {
        return "Endpoint{" +
                "name='" + name + '\'' +
                ", description=" + description +
                ", baseUnit='" + baseUnit + '\'' +
                ", measurements=" + measurements +
                ", availableTags=" + availableTags +
                '}';
    }
}
