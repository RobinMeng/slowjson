package com.robin.slow;

import com.alibaba.fastjson.JSONObject;
import com.robin.slow.code.SlowJSONNode;
import com.robin.slow.code.SlowJSONVisitor;
import com.robin.slow.g4.JSONLexer;
import com.robin.slow.g4.JSONParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {


        String json = "\n" +
                "{\n" +
                "    \"glossary\": {\n" +
                "        \"title\": \"example glossary\",\n" +
                "\t\t\"GlossDiv\": {\n" +
                "            \"title\": \"S\",\n" +
                "\t\t\t\"GlossList\": {\n" +
                "                \"GlossEntry\": {\n" +
                "                    \"ID\": \"SGML\",\n" +
                "\t\t\t\t\t\"SortAs\": \"SGML\",\n" +
                "\t\t\t\t\t\"GlossTerm\": \"Standard Generalized Markup Language\",\n" +
                "\t\t\t\t\t\"Acronym\": \"SGML\",\n" +
                "\t\t\t\t\t\"Abbrev\": \"ISO 8879:1986\",\n" +
                "\t\t\t\t\t\"GlossDef\": {\n" +
                "                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n" +
                "\t\t\t\t\t\t\"GlossSeeAlso\": [\"GML\", \"XML\"]\n" +
                "                    },\n" +
                "\t\t\t\t\t\"GlossSee\": \"markup\"\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";


        ANTLRInputStream input = new ANTLRInputStream(json);
        JSONLexer lexer = new JSONLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JSONParser parser = new JSONParser(tokens);
        ParseTree tree = parser.json();
        SlowJSONVisitor eval = new SlowJSONVisitor();
        SlowJSONNode slowJSONNode = eval.visit(tree);



        System.out.println(slowJSONNode);
        JSONObject jsonObject = JSONObject.parseObject(json);
        System.out.println(jsonObject);
        System.out.println("Hello World!");
        System.out.println("Hello World!");
    }
}
