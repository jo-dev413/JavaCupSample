package dev.euphony.java.example;
import java_cup.runtime.SymbolFactory;
import java.io.StringReader;

%%

%public
%class Lexer
%unicode
%cupsym ParserSym
%cup

%{
    SymbolFactory sf;

    public Lexer(String line, SymbolFactory sf) {
        this(new StringReader(line));
        this.sf = sf;
    }
%}

%eofval{
    return sf.newSymbol("EOF", ParserSym.EOF);
%eofval}

Var = [a-z0-9]+

%%
"&"         { return sf.newSymbol("&"   , ParserSym.AND);               }
"|"         { return sf.newSymbol("|"   , ParserSym.OR);                }
"~"         { return sf.newSymbol("~"   , ParserSym.NOT);               }
"T"         { return sf.newSymbol("T"   , ParserSym.TRUE);              }
"F"         { return sf.newSymbol("F"   , ParserSym.FALSE);             }
"->"        { return sf.newSymbol("->"   , ParserSym.IMP);              }

">"         { return sf.newSymbol(">"   , ParserSym.GREATER_THAN);      }
">="        { return sf.newSymbol(">="   , ParserSym.GREATER_THAN_EQ);  }
"<"         { return sf.newSymbol("<"   , ParserSym.LESS_THAN);         }
"<="        { return sf.newSymbol("<="   , ParserSym.LESS_THAN_EQ);     }
"="         { return sf.newSymbol("="   , ParserSym.EQ);                }

"+"         { return sf.newSymbol("+"   , ParserSym.PLUS);              }
"-"         { return sf.newSymbol("-"   , ParserSym.MINUS);             }
"*"         { return sf.newSymbol("*"   , ParserSym.TIMES);             }
"("         { return sf.newSymbol("("   , ParserSym.LPAREN);            }
")"         { return sf.newSymbol(")"   , ParserSym.RPAREN);            }

{Var}       { return sf.newSymbol("Var" , ParserSym.VAR);               }

.           { /* ignore */ }