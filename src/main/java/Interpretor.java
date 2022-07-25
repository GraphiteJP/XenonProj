public class Interpretor {
    public final static String CODE = "fn main() {println(\"hello world\")}";

    public static void main(String[] args) {
        Lexer lexer = new Lexer(CODE);
        System.out.println(lexer.lex());
    }
}