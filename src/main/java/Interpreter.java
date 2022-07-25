public class Interpreter {
    public final static String CODE = "1 + 2 * 3";

    public static void main(String[] args) {
        Lexer lexer = new Lexer(CODE);
        TokenParser parser = new TokenParser(lexer.lex());
        System.out.println(parser.parse());
    }
}