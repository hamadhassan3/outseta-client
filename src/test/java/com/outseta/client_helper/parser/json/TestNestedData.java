package com.outseta.client_helper.parser.json;

public class TestNestedData {
    private String str;
    private Double dbl;
    private Integer intgr;
    private Boolean bool;

    public TestNestedData(String str, Double dbl, Integer intgr, Boolean bool) {
        this.str = str;
        this.dbl = dbl;
        this.intgr = intgr;
        this.bool = bool;
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

    public Integer getIntgr() {
        return intgr;
    }

    public void setIntgr(Integer intgr) {
        this.intgr = intgr;
    }

    public Boolean getBool() {
        return bool;
    }

    public void setBool(Boolean bool) {
        this.bool = bool;
    }

    /** Overriding equals method for testing purposes */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof TestNestedData)) return false;
        TestNestedData other = (TestNestedData) obj;
        return this.str.equals(other.str) && this.dbl.equals(other.dbl) && this.intgr.equals(other.intgr) && this.bool.equals(other.bool);
    }
}
