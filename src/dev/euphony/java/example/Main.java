package dev.euphony.java.example;

import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.SymbolFactory;

public class Main {
    public static void main(String[] args) throws Exception {
        SymbolFactory sf = new ComplexSymbolFactory();
        Lexer lexer = new Lexer("abc + 1",sf);
        Parser p = new Parser(lexer, sf);
        Object o = p.parse().value;
        System.out.println(o);
        if(o instanceof Expression2){
            System.out.println(((Expression2) o).left);
            System.out.println(((Expression2) o).right);
            Expression2 e2 = (Expression2)o;
            System.out.println(e2.sym);
            Object o1 = e2.left;
            Object o2 = e2.right;
            if(o1 instanceof Var){
                Var v = (Var) o1;
                System.out.println(v.name);
            }
            if(o2 instanceof Number){
                Number v = (Number) o2;
                System.out.println(v.val);
            }
        }
    }
}
