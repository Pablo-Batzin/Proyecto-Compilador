
import compilerTools.Token;
%%
%class Lexico
%type Token
%line
%column
%{
    private Token token(String lexeme, String lexicalComp, int line, int column) {
        return new Token(lexeme, lexicalComp, line+1, column+1);
    }
%}
/* Variables básicas de comentarios y espacios */
TerminadorDeLinea = \r|\n|\r\n
EntradaDeCaracter = [^\r\n]
EspacioEnBlanco = {TerminadorDeLinea} | [ \t\f]
ComentarioTradicional = "/*" [^*] ~"*/" | "/*" "*"+ "/"
FinDeLineaComentario = "//" {EntradaDeCaracter}* {TerminadorDeLinea}?
ContenidoComentario = ( [^*] | \*+ [^/*] )*
ComentarioDeDocumentacion = "/**" {ContenidoComentario} "*"+ "/"

/* Comentario */
Comentario = {ComentarioTradicional} | {FinDeLineaComentario} | {ComentarioDeDocumentacion}

/* Identificador */
Letra = [a-zA-Z_]
Digito = [0-9]
Identificador = {Letra}({Letra}|{Digito})*
/* Números */
Numero = 0 | [1-9][0-9]*
/* Reservadas */
Reservada = boolean | else | if | int | main | void | while | for | switch | void main | Booleano 
/* Comparacion */
Comparacion = "<" | "<=" | ">" | "=>" | "=="
/* Operador */
Operador = ,
/* Fin */
Fin = ;
/* Relacional */
Relacional = "!="
/* Logico */
Logico = && | "|"
/* Condicional */
Condicional = "!"
/* Asignacion */
Asignacion = "="
/* Suma */
Suma = "+"
/* Resta */
Resta = "-"
/* Multiplicacion */
Multiplicacion = "*"
/* Division */
Division = "/"
/* Incremento */
Incremento = [+]+
/* Parentesis_I */
Parentesis_I = "("
/* Parentesis_D */
Parentesis_D = ")"
/* Izquierdo */
Izquierdo = "{" | "["
/* Derecho */
Derecho = "}" | "]"
/* Comillas */
Comillas = "\""

%%
/* Comentarios o espacios en blanco */
{Comentario}|{EspacioEnBlanco} { /*Ignorar*/ }
{Reservada} {return token(yytext(), "PALABRA_RESERVADA", yyline, yycolumn);}
{Comparacion} {return token(yytext(), "OP_COMPARACION", yyline, yycolumn);}
{Operador} {return token(yytext(), "OPERADOR", yyline, yycolumn);}
{Fin} {return token(yytext(), "OP_FIN_DE_LINEA", yyline, yycolumn);}
{Relacional} {return token(yytext(), "OP_RELACIONAL", yyline, yycolumn);}
{Logico} {return token(yytext(), "OP_LOGICO", yyline, yycolumn);}
{Condicional} {return token(yytext(), "OP_CONDICIONAL", yyline, yycolumn);}
{Asignacion} {return token(yytext(), "OP_ASIGNACION", yyline, yycolumn);}
{Suma} {return token(yytext(), "SIMB_SUMA", yyline, yycolumn);}
{Resta} {return token(yytext(), "SIMB_RESTA", yyline, yycolumn);}
{Multiplicacion} {return token(yytext(), "SIMB_MULTIPLICACION", yyline, yycolumn);}
{Division} {return token(yytext(), "SIMB_DIVISION", yyline, yycolumn);}
{Incremento} {return token(yytext(), "SIMB_INCREMENTO", yyline, yycolumn);}
{Parentesis_I} {return token(yytext(), "PARENT_IZQUIERDO", yyline, yycolumn);}
{Parentesis_D} {return token(yytext(), "PARENT_DERECHO", yyline, yycolumn);}
{Izquierdo} {return token(yytext(), "LLAVE_ABRE", yyline, yycolumn);}
{Derecho} {return token(yytext(), "LLAVE_CIERRA", yyline, yycolumn);}
{Comillas} {return token(yytext(), "COMILLAS", yyline, yycolumn);}
{Identificador} {return token(yytext(), "IDENTIFICADOR", yyline, yycolumn);}
{Numero} {return token(yytext(), "NUMERO", yyline, yycolumn);}
. { return token(yytext(), "ERROR", yyline, yycolumn); }
    