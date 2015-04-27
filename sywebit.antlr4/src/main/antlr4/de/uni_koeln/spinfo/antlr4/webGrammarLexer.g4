lexer grammar webGrammarLexer;

PUNKT : '.';

WORD  : ('a'..'z'|'A'..'Z')+;

WS  : (' '|'\t'|'\u000C'|'\u000D')+ -> skip;

//ErrorChar: . ;