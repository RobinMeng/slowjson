package com.robin.slow.code;

public class StringJSONNode  implements SlowJSONNode {


    private String value;

    public StringJSONNode() {
    }

    public StringJSONNode(String value) {
        this.value = value;
    }


    public void set(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }

}
