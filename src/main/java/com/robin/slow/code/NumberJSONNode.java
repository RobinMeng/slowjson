package com.robin.slow.code;

public class NumberJSONNode implements SlowJSONNode {

    public Number number;

    public NumberJSONNode(){}

    public NumberJSONNode(Number number){
        this.number=number;
    }

    public Number get() {

        return number;
    }

    public void set(Number number) {
        this.number = number;
    }

}
