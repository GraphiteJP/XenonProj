import java.util.ArrayList;

/**
 * Lexer
 * lex()メソッドで字句解析ができるようになった
 */

public class Lexer {
    public final static String PLUS = "+";
    public final static String PLUS_PLUS = "++";
    public final static String PLUS_EQUALS = "+=";
    public final static String MINUS = "-";
    public final static String MINUS_MINUS = "--";
    public final static String MINUS_EQUALS = "-=";
    public final static String MULT = "*";
    public final static String MULT_EQUALS = "*=";
    public final static String DIV = "/";
    public final static String DIV_EQUALS = "/=";
    public final static String REMAINDER = "%";
    public final static String REMAINDER_EQUALS = "%=";
    public final static String EQUALS = "=";
    public final static String AND = "&&";
    public final static String OR = "||";
    public final static String GREATER_BIG = ">";
    public final static String GREATER_BIG_EQUALS = ">=";
    public final static String GREATER_SMALL = "<";
    public final static String GREATER_SMALL_EQUALS = "<=";
    public final static String EQUALS_EQUALS = "==";
    public final static String EQUALS_NOT_EQUALS = "!=";
    public final static String DOT = ".";
    public final static String COMMA = ",";
    public final static String INT = "int";
    public final static String DOUBLE = "double";
    public final static String BOOL = "bool";
    public final static String IMPORT = "import";
    public final static String FUNCTION = "fn";
    public final static String RETURN = "return";
    public final static String CLASS = "class";
    public final static String PUBLIC = "pub";
    public final static String SELF = "self";
    public final static String RETURN_TYPE = "->";
    public final static String COMMENT_ONE_LINE = "//";
    public final static String COMMENT_TWO_LINE_LEFT = "/*";
    public final static String COMMENT_TWO_LINE_RIGHT = "*/";
    public final static String BRACKET_LEFT = "(";
    public final static String BRACKET_RIGHT = ")";
    public final static String SQUARE_BRACKET_LEFT = "[";
    public final static String SQUARE_BRACKET_RIGHT = "]";
    public final static String CURLY_BRACKET_LEFT = "{";
    public final static String CURLY_BRACKET_RIGHT = "}";
    public final static String AT = "@";
    public final static String QUOTE = "\"";
    public final static String SPACE = " ";
    public String code;
    public String lexedString = "";
    public ArrayList<String> tokens = new ArrayList<>();

    public Lexer(String code) {
        this.code = code;
    }

    public ArrayList<String> lex() {
        char[] code = this.code.toCharArray();
        boolean stringFlg = false;
        for (char c : code) {
            this.lexedString += c;
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
                this.tokens.add(BRACKET_LEFT);
                lexedString = "";
            } else if (c == '{') {
                lexedString = lexedString.replace("{", "");
                if (!lexedString.equals("")) {
                    this.tokens.add(lexedString);
                }
                this.tokens.add(CURLY_BRACKET_LEFT);
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