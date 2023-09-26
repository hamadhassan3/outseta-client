package com.outseta.client_helper.parser.json;

import com.outseta.model.DataComponent;

public class TestDataComponent implements DataComponent {
    private String str;
    private Double dbl;
    private Integer integer;
    private Boolean bool;
    private TestNestedData testNestedData;

    public TestDataComponent(String str, Double dbl, Integer integer,
                             Boolean bool, TestNestedData testNestedData) {
        this.str = str;
        this.dbl = dbl;
        this.integer = integer;
        this.bool = bool;
        this.testNestedData = testNestedData;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Double getDbl() {
        return dbl;
    }

    public void setDbl(Double dbl) {
        this.dbl = dbl;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public Boolean getBool() {
        return bool;
    }

    public void setBool(Boolean bool) {
        this.bool = bool;
    }

    public TestNestedData getTestNestedData() {
        return testNestedData;
    }

    public void setTestNestedData(TestNestedData testNestedData) {
        this.testNestedData = testNestedData;
    }

    /**
     * Overriding equals method for testing purposes
     */
    @Override
    public boolean equals(Object other) {

        if (other == this) {
            return true;
        }
        if (other instanceof TestDataComponent otherTestDataComponent) {

            if (this.str.equals(otherTestDataComponent.str) &&
                    this.dbl.equals(otherTestDataComponent.dbl) &&
                    this.integer.equals(otherTestDataComponent.integer) &&
                    this.bool.equals(otherTestDataComponent.bool) &&
                    this.testNestedData.equals(
                            otherTestDataComponent.testNestedData)) {
                return true;
            }
        }

        return false;
    }
}
