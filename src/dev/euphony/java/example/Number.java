package dev.euphony.java.example;

public class Number extends Expression{
    public Integer val;
    public Number(Integer i){
        System.out.println(i);
        this.val = i;
    }
}
