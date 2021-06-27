package com.robin.slow.code;


import com.robin.slow.g4.JSONBaseVisitor;
import com.robin.slow.g4.JSONParser;

public class SlowJSONVisitor extends JSONBaseVisitor<SlowJSONNode> {

    public SlowJSONVisitor() {
    }

    @Override
    public SlowJSONNode visitJson(JSONParser.JsonContext ctx) {

        return super.visitJson(ctx);
    }

    @Override
    public SlowJSONNode visitObj(JSONParser.ObjContext ctx) {

        ObjectJSONNode node = new ObjectJSONNode();
        for (JSONParser.PairContext pairContext : ctx.pair()) {
            node.set(pairContext.STRING().getText(), visit(pairContext.value()));
        }

        return node;
    }

    @Override
    public SlowJSONNode visitPair(JSONParser.PairContext ctx) {

        ObjectJSONNode node = new ObjectJSONNode();
        node.set(ctx.STRING().getText(), visit(ctx.value()));
        return node;
    }

    @Override
    public SlowJSONNode visitArr(JSONParser.ArrContext ctx) {
        ArrayJSONNode list = new ArrayJSONNode();
        for (JSONParser.ValueContext valueContext : ctx.value()) {
            list.add(visit(valueContext));
        }
        return list;
    }

    @Override
    public SlowJSONNode visitValue(JSONParser.ValueContext ctx) {

        if (null != ctx.STRING()) {
            return new StringJSONNode(ctx.STRING().getText().replace("\"", ""));
        }

        if (null != ctx.NUMBER()) {
            return new NumberJSONNode(Integer.parseInt(ctx.NUMBER().toString()));
        }

        if (null != ctx.obj()) {
            return visitObj(ctx.obj());
        }

        if (null != ctx.arr()) {
            return visitArr(ctx.arr());
        }

        return super.visitValue(ctx);
    }
}
