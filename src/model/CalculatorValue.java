package model;

import enumv.Origin;

public class CalculatorValue {

    private Integer value;
    private Origin origin;

    public CalculatorValue(Integer value, Origin origin) {
        this.value = value;
        this.origin = origin;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }
}
