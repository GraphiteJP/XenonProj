import java.util.ArrayList;

/**
 * Lexer
 * lex()メソッドで字句解析ができるようになった
 */

public class Lexer {
    public String code;
    public static String lexedString = "";
    public ArrayList<String> tokens = new ArrayList<>();

    public Lexer(String code) {
        code += " ";
        this.code = code;
    }

    public ArrayList<String> lex() {
        char[] code = this.code.toCharArray();
        boolean stringFlg = false;
        for (char c : code) {
            lexedString += c;
            if (stringFlg) {
                if (c == '\"') {
                    stringFlg = false;
                    lexedString = lexedString.replaceFirst(".$", "");
                    this.tokens.add(lexedString);
                    this.tokens.add("\"");
                    lexedString = "";
                }
                continue;
            }
            if (c == ' ') {
                lexedString = lexedString.replaceFirst(".$", "");
                if (!lexedString.equals(" ")) {
                    this.tokens.add(lexedString);
                }
                lexedString = "";
            } else if (c == '(') {
                lexedString = lexedString.replace("(", "");
                if (!lexedString.equals("")) {
                    this.tokens.add(lexedString);
                }
                this.tokens.add("(");
                lexedString = "";
            } else if (c == '{') {
                lexedString = lexedString.replace("{", "");
                if (!lexedString.equals("")) {
                    this.tokens.add(lexedString);
                }
                this.tokens.add("{");
                lexedString = "";
            } else if (c == ')') {
                if (!lexedString.equals("")) {
                    this.tokens.add(lexedString);
                }
                lexedString = "";
            } else if (c == '}') {
                if (!lexedString.equals("")) {
                    this.tokens.add(lexedString);
                }
                lexedString = "";
            } else if (c == '\"') {
                this.tokens.add(lexedString);
                stringFlg = true;
                lexedString = "";
            } else if (c == '\n') {
                lexedString.replaceAll("[\r\n]", "");
                this.tokens.add(lexedString);
                lexedString = "";
            }
        }
        tokens.remove("");
        return tokens;
    }
}