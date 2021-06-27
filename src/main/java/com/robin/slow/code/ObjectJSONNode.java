package com.robin.slow.code;

import java.util.HashMap;

public class ObjectJSONNode extends HashMap<String,SlowJSONNode> implements SlowJSONNode{


    public ObjectJSONNode() {
        super();

    }


    public SlowJSONNode get(String key) {
        return super.get(key);
    }

    public void set(String key, SlowJSONNode node) {
        super.put(key, node);
    }



}
