package com.outseta.client_helper.parser.json;

public class TestNestedData {

    /**
     * A String field.
     */
    private String str;

    /**
     * A Double field.
     */
    private Double dbl;

    /**
     * An Integer field.
     */
    private Integer intgr;

    /**
     * A Boolean field.
     */
    private Boolean bool;

    /**
     * Constructor for the test object.
     *
     * @param pStr   A String field.
     * @param pDbl   A Double field.
     * @param pIntgr An Integer field.
     * @param pBool  A Boolean field.
     */
    public TestNestedData(final String pStr, final Double pDbl,
                          final Integer pIntgr,
                          final Boolean pBool) {
        this.str = pStr;
        this.dbl = pDbl;
        this.intgr = pIntgr;
        this.bool = pBool;
    }

    /**
     * Returns the String field.
     *
     * @return The String field.
     */
    public String getStr() {
        return str;
    }

    /**
     * Sets the String field.
     *
     * @param pStr The String field.
     */
    public void setStr(final String pStr) {
        this.str = pStr;
    }

    /**
     * Returns the Double field.
     *
     * @return The Double field.
     */
    public Double getDbl() {
        return dbl;
    }

    /**
     * Sets the Double field.
     *
     * @param pDbl The Double field.
     */
    public void setDbl(final Double pDbl) {
        this.dbl = pDbl;
    }

    /**
     * Returns the Integer field.
     *
     * @return The Integer field.
     */
    public Integer getIntgr() {
        return intgr;
    }

    /**
     * Sets the Integer field.
     *
     * @param pIntgr The Integer field.
     */
    public void setIntgr(final Integer pIntgr) {
        this.intgr = pIntgr;
    }

    /**
     * Returns the Boolean field.
     *
     * @return The Boolean field.
     */
    public Boolean getBool() {
        return bool;
    }

    /**
     * Sets the Boolean field.
     *
     * @param pBool The Boolean field.
     */
    public void setBool(final Boolean pBool) {
        this.bool = pBool;
    }

    /**
     * Overriding equals method for testing purposes.
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TestNestedData other)) {
            return false;
        }
        return this.str.equals(other.str) && this.dbl.equals(other.dbl)
                && this.intgr.equals(other.intgr)
                && this.bool.equals(other.bool);
    }

    /**
     * Overriding hashCode method for testing purposes.
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
