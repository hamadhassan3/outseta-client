package com.outseta.client_helper.parser.json;

import com.outseta.model.DataComponent;

import java.util.Objects;

public class TestDataComponent implements DataComponent {

    /**
     * A string field of the test object.
     */
    private String str;

    /**
     * A double field of the test object.
     */
    private Double dbl;

    /**
     * An integer field of the test object.
     */
    private Integer integer;

    /**
     * A boolean field of the test object.
     */
    private Boolean bool;

    /**
     * A nested object field of the test object.
     */
    private TestNestedData testNestedData;

    /**
     * Constructor for the test object.
     *
     * @param pStr            A string field of the test object.
     * @param pDbl            A double field of the test object.
     * @param pInteger        An integer field of the test object.
     * @param pBool           A boolean field of the test object.
     * @param pTestNestedData A nested object field of the test object.
     */
    public TestDataComponent(final String pStr, final Double pDbl,
                             final Integer pInteger,
                             final Boolean pBool,
                             final TestNestedData pTestNestedData) {
        this.str = pStr;
        this.dbl = pDbl;
        this.integer = pInteger;
        this.bool = pBool;
        this.testNestedData = pTestNestedData;
    }

    /**
     * Returns the string field of the test object.
     * @return The string field of the test object.
     */
    public String getStr() {
        return str;
    }

    /**
     * Sets the string field of the test object.
     * @param pStr The string field of the test object.
     */
    public void setStr(final String pStr) {
        this.str = pStr;
    }

    /**
     * Returns the double field of the test object.
     * @return The double field of the test object.
     */
    public Double getDbl() {
        return dbl;
    }

    /**
     * Sets the double field of the test object.
     * @param pDbl The double field of the test object.
     */
    public void setDbl(final Double pDbl) {
        this.dbl = pDbl;
    }

    /**
     * Returns the integer field of the test object.
     * @return The integer field of the test object.
     */
    public Integer getInteger() {
        return integer;
    }

    /**
     * Sets the integer field of the test object.
     * @param pInteger The integer field of the test object.
     */
    public void setInteger(final Integer pInteger) {
        this.integer = pInteger;
    }

    /**
     * Returns the boolean field of the test object.
     * @return The boolean field of the test object.
     */
    public Boolean getBool() {
        return bool;
    }

    /**
     * Sets the boolean field of the test object.
     * @param pBool The boolean field of the test object.
     */
    public void setBool(final Boolean pBool) {
        this.bool = pBool;
    }

    /**
     * Returns the nested object field of the test object.
     * @return The nested object field of the test object.
     */
    public TestNestedData getTestNestedData() {
        return testNestedData;
    }

    /**
     * Sets the nested object field of the test object.
     * @param pTestNestedData The nested object field of the test object.
     */
    public void setTestNestedData(final TestNestedData pTestNestedData) {
        this.testNestedData = pTestNestedData;
    }

    /**
     * Overriding equals method for testing purposes.
     */
    @Override
    public boolean equals(final Object other) {

        if (other == this) {
            return true;
        }
        if (other instanceof TestDataComponent) {

            TestDataComponent otherTestDataComponent =
                    (TestDataComponent) other;

            return this.str.equals(otherTestDataComponent.str)
                    && this.dbl.equals(otherTestDataComponent.dbl)
                    && this.integer.equals(otherTestDataComponent.integer)
                    && this.bool.equals(otherTestDataComponent.bool)
                    && this.testNestedData.equals(
                    otherTestDataComponent.testNestedData);
        }

        return false;
    }

    /**
     * Overriding hashCode method for testing purposes.
     */
    @Override
    public int hashCode() {
        return Objects.hash(str, dbl, integer, bool, testNestedData);
    }
}
