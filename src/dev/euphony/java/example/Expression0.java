package dev.euphony.java.example;

public class Expression0 extends Expression{
    public final Expression chilled;
    public Expression0(Expression e){
        e.parent = this;
        chilled = e;
    }
}
