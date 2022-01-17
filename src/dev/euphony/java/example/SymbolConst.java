package dev.euphony.java.example;

enum SymbolConst {
    AND(0),
    OR(1),
    IMP(2),
    NOT(3),
    GREATER_THAN(4),
    GREATER_THAN_EQ(5),
    LESS_THAN(6),
    LESS_THAN_EQ(7),
    EQ(8),
    PLUS(9),
    MINUS(10),
    TIMES(11);

    private final int op;

    private SymbolConst(int op) {
        this.op = op;
    }

    int getCode() {
        return op;
    }
}
