package dev.euphony.java.example;

public class Expression1 extends Expression{
    public final SymbolConst sym;
    public final Expression chilled;
    public Expression1(SymbolConst sym,Expression e){
        e.parent = this;
        this.sym = sym;
        chilled = e;
    }
}
