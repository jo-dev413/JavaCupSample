package dev.euphony.java.example;

public class Var extends Expression{
    public final String name;
    public Var(String name){
        System.out.println(name);
        this.name = name;
    }
}
