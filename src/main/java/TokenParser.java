import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Parser
 * とりあえず分類するところまでやる
 */

public class TokenParser {
    public final static String DIGITS = "DIGITS";
    public final static String PLUS = "PLUS";
    public final static String MINUS = "MINUS";
    public final static String MULTIPLY = "MULTIPLY";
    public final static String DIVIDE = "DIVIDE";
    public final static String REMAINDER = "REMAINDER";
    public final static String EQUALS = "EQUALS";
    public final static String PLUS_EQUALS = "PLUS_EQUALS";
    public final static String MINUS_EQUALS = "MINUS_EQUALS";
    public final static String MULTIPLY_EQUALS = "MULTIPLY_EQUALS";
    public final static String DIVIDE_EQUALS = "DIVIDE_EQUALS";
    public final static String REMAINDER_EQUALS = "REMAINDER_EQUALS";
    public final static String INT = "INT";
    public final static String DOUBLE = "DOUBLE";
    public final static String BOOLEAN = "BOOLEAN";
    public final static String CHARACTER = "CHARACTER";
    public final static String FUNCTION = "FUNCTION";
    public final static String CLASS = "CLASS";
    public final static String SELF = "SELF";
    public final static String RETURN = "RETURN";
    public final static String RETURN_TYPE = "RETURN_TYPE";
    public final static String IF = "IF";
    public final static String FOR = "FOR";
    public final static String WHILE = "WHILE";
    public final static String BREAK = "BREAK";
    public final static String CONTINUE = "CONTINUE";
    public final static String NOT = "NOT";
    public final static String AND = "AND";
    public final static String OR = "OR";
    public final static String EQUALS_EQUALS = "EQUALS_AND_EQUALS";
    public final static String EQUALS_NOT_EQUALS = "EQUALS_NOT_EQUALS";
    public final static String GREATER_LEFT = "GREATER_LEFT";
    public final static String GREATER_RIGHT = "GREATER_RIGHT";
    public final static String GREATER_LEFT_EQUALS = "GREATER_LEFT_EQUALS";
    public final static String GREATER_RIGHT_EQUALS = "GREATER_RIGHT_EQUALS";
    public final static String BRACKET_LEFT = "BRACKET_LEFT";
    public final static String BRACKET_RIGHT = "BRACKET_RIGHT";
    public final static String CURLY_LEFT = "CURLY_LEFT";
    public final static String CURLY_RIGHT = "CURLY_RIGHT";
    public final static String SQUARE_LEFT = "SQUARE_LEFT";
    public final static String SQUARE_RIGHT = "SQUARE_RIGHT";

    public ArrayList<String> tokens = new ArrayList<>();
    public static ArrayList<String> parsedTokens = new ArrayList<>();

    public TokenParser(ArrayList<String> tokens) {
        this.tokens = tokens;
    }

    public ArrayList<String> parse() {
        for (String token : tokens) {
            if (
                token.indexOf("0") != -1 ||
                token.indexOf("1") != -1 ||
                token.indexOf("2") != -1 ||
                token.indexOf("3") != -1 ||
                token.indexOf("4") != -1 ||
                token.indexOf("5") != -1 ||
                token.indexOf("6") != -1 ||
                token.indexOf("7") != -1 ||
                token.indexOf("8") != -1 ||
                token.indexOf("9") != -1 ||
                token.indexOf(".") != -1
            ) {
                parsedTokens.add(DIGITS + ": " + token);
            } else if (token.equals("+")) {
                parsedTokens.add(PLUS);
            } else if (token.equals("-")) {
                parsedTokens.add(PLUS);
            } else if (token.equals("*")) {
                parsedTokens.add(MULTIPLY);
            } else if (token.equals("/")) {
                parsedTokens.add(DIVIDE);
            } else if (token.equals("%")) {
                parsedTokens.add(REMAINDER);
            } else if (token.equals("=")) {
                parsedTokens.add(EQUALS);
            } else if (token.equals("+=")) {
                parsedTokens.add(PLUS_EQUALS);
            } else if (token.equals("-=")) {
                parsedTokens.add(MINUS_EQUALS);
            }
        }
        return this.parsedTokens;
    }
}
