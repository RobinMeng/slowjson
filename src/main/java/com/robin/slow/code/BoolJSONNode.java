package com.robin.slow.code;

public class BoolJSONNode implements SlowJSONNode {

    Boolean bool;


    public BoolJSONNode() {
        bool = null;
    }

    public BoolJSONNode(Boolean bool) {
        bool = bool;
    }

    public boolean get() {
        return bool;
    }

    public void set(Boolean bool) {
        this.bool = bool;
    }

}
