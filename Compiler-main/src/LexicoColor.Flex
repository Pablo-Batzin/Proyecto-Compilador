
import compilerTools.TextColor;
import java.awt.Color;
%%
%class LexicoColor
%type TextColor
%char
%{
    private TextColor textColor(long start, int size, Color color) {
    return new TextColor((int)start, size, color);
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
Letra = [A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]
Digito = [0-9]
Identificador = {Letra}({Letra}|{Digito})*

/* Número */
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
{Comentario} { return textColor(yychar, yylength(), new Color(146, 146, 146)); }
{EspacioEnBlanco} { /*Ignorar*/ }
{Reservada} { return textColor(yychar, yylength(), new Color(17, 94, 153)); }
{Comparacion} { return textColor(yychar, yylength(), new Color(169, 155, 179)); }
{Operador} { return textColor(yychar, yylength(), new Color(169, 155, 179)); }
{Fin} { return textColor(yychar, yylength(), new Color(198, 40, 40)); }
{Relacional} { return textColor(yychar, yylength(), new Color(48, 63, 159)); }
{Logico} { return textColor(yychar, yylength(), new Color(48, 63, 159)); }
{Condicional} { return textColor(yychar, yylength(), new Color(48, 63, 159)); }
{Asignacion} { return textColor(yychar, yylength(), new Color(48, 63, 159)); }
{Suma} { return textColor(yychar, yylength(), new Color(255, 0, 80)); }
{Resta} { return textColor(yychar, yylength(), new Color(255, 0, 80)); }
{Multiplicacion} { return textColor(yychar, yylength(), new Color(255, 0, 80)); }
{Division} { return textColor(yychar, yylength(), new Color(255, 0, 80)); }
{Incremento} { return textColor(yychar, yylength(), new Color(255, 64, 129)); }
{Parentesis_I} { return textColor(yychar, yylength(), new Color(169, 155, 179)); }
{Parentesis_D} { return textColor(yychar, yylength(), new Color(169, 155, 179)); }
{Izquierdo} { return textColor(yychar, yylength(), new Color(169, 155, 179)); }
{Derecho} { return textColor(yychar, yylength(), new Color(169, 155, 179)); }
{Comillas} { return textColor(yychar, yylength(), new Color(169, 155, 179)); }
{Identificador} {/* Ignorar */}
{Numero} { return textColor(yychar, yylength(), new Color(35, 120, 147)); }
. { /* Ignorar */ }
    