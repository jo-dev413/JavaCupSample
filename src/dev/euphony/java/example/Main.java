package dev.euphony.java.example;

import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.SymbolFactory;

public class Main {
    public static void main(String[] args) throws Exception {
        SymbolFactory sf = new ComplexSymbolFactory();
        Lexer lexer = new Lexer("((abc >= 1) && (x + y) = 0) || !apple",sf);
        Parser p = new Parser(lexer, sf);
        System.out.println(search(p.parse().value));
    }

    public static String search(Object root){
        while (true){
            if(root instanceof Var){
                return ((Var) root).name;
            }
            if(root instanceof Number){
                return ((Number) root).val.toString();
            }
            if(root instanceof BoolSym){
                return ((BoolSym) root).val.toString();
            }
            if(root instanceof Expression0){
                return "(" + search(((Expression0) root).chilled) + ")";
            }
            if(root instanceof Expression1){
                String tmp = search(((Expression1) root).chilled);
                return ((Expression1) root).sym.name() + "(" + tmp + ")";
            }
            if(root instanceof Expression2){
                String left = search(((Expression2) root).left);
                String right = search(((Expression2) root).right);
                return ((Expression2) root).sym.name() + "(" + left + ", " + right + ")";
            }
        }
    }
}
