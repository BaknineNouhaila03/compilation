grammar PCF;

program : term EOF ;
term
    : term term                                 # App
    | term op=('*' | '/') term                  # BOp
    | term op=('+' | '-') term                  # BOp
    | 'let' VAR '=' term 'in' term              # Let
    | 'ifz' term 'then' term 'else' term        # IfZ
    | 'fun' VAR '->' term                       # Fun
    | 'fix' VAR term                            # Fix
    | '(' term ')'                              # Par
    | NUMBER                                    # Number
    | VAR                                       # Var
    ;

NUMBER : '0' | [1-9][0-9]* ;
VAR    : [a-z][a-z0-9]* ;
WS     : [ \t\r\n]+ -> skip ;