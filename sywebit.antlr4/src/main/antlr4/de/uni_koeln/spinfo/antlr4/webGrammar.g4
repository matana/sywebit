grammar webGrammar;
					  
options{ tokenVocab = webGrammarLexer;}

startSymb : word+  dot EOF;
dot :PUNKT;
word: WORD;
