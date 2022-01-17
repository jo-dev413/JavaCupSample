package dev.euphony.java.example;

public class Expression2 extends Expression{
    public final SymbolConst sym;
    public final Expression left;
    public final Expression right;
    public Expression2(SymbolConst sym, Expression e1, Expression e2) {
        e1.parent = this;
        e2.parent = this;
        left = e1;
        right = e2;
        this.sym = sym;
    }
}
