import java.util.ArrayList;

/**
 * インタプリタ
 */

public class Interpreter {
    private static final String CODE = "fn main() {println(\"hello world\")}";
    public static void main(String[] args) {

    }
}

/**
 * 字句解析器(レキサー)
 */

record Lexer(String code) {
    private static String tokensString = "";
    private static ArrayList<String> tokens = new ArrayList<>();
    public ArrayList<String> lex() throws Exception {
        boolean stringFlg = false;
        for (int i = 0; i < code.length(); i++) {
            if (stringFlg) {
                if (code.charAt(i) == '\"') {
                    tokensString.replace("\"", "");
                    tokens.add(tokensString);
                    tokens.add("\"");
                    stringFlg = false;
                } else {
                    if (i == code.length() - 1) {
                        throw new Exception("引用符がありません。");
                    } else {
                        continue;
                    }
                }
            }
            if (code.charAt(i) == ' ' || code.charAt(i) == '\n') {
                continue;
            } else if (code.charAt(i) == '(') {
                tokensString.replace("(", "");
                tokens.add(tokensString);
                tokens.add("(");
            } else if (code.charAt(i) == ')') {
                tokensString.replace(")", "");
                tokens.add(tokensString);
                tokens.add(")");
            } else if (code.charAt(i) == '{') {
                tokensString.replace("{", "");
                tokens.add(tokensString);
                tokens.add("{");
            } else if (code.charAt(i) == '}') {
                tokensString.replace("}", "");
                tokens.add(tokensString);
                tokens.add("}");
            } else if (code.charAt(i) == '\"') {
                tokensString.replace("\"", "");
                tokens.add(tokensString);
                tokens.add("\"");
                stringFlg = true;
            }
        }
        return new ArrayList<String>();
    }
}