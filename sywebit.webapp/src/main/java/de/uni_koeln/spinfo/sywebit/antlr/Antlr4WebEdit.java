package de.uni_koeln.spinfo.sywebit.antlr;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.springframework.stereotype.Service;

import de.uni_koeln.spinfo.antlr4.webGrammarLexer;
import de.uni_koeln.spinfo.antlr4.webGrammarParser;
import de.uni_koeln.spinfo.sywebit.antlr.response.AntlrValidationResponse;

@Service
public class Antlr4WebEdit {

	public AntlrValidationResponse processEntry(final String input) {

		webGrammarLexer lexer = initLexer(input);
		ErrorListener lexerErrorListener = new ErrorListener(ErrorType.Lexer);
		lexer.addErrorListener(lexerErrorListener);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		tokens.fill();

		webGrammarParser p = new webGrammarParser(tokens);
		ErrorListener parserErrorListener = new ErrorListener(ErrorType.Parser);
		p.addErrorListener(parserErrorListener);
		p.setBuildParseTree(true);
		p.startSymb();
		p.reset();

		AntlrValidationResponse response = new AntlrValidationResponse();
		response.setDate(new Date());
		if (lexerErrorListener.hasErrors)
			response.setLexerErrorMessages(lexerErrorListener
					.getErrorMessages());
		if (parserErrorListener.hasErrors)
			response.setParserErrorMessages(parserErrorListener
					.getErrorMessages());
		return response;
	}

	private webGrammarLexer initLexer(final String input) {
		return new webGrammarLexer(new ANTLRInputStream(input));
	}

	enum ErrorType {

		Lexer("LexerError"), Parser("ParserError");

		private String name;

		ErrorType(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

	class ErrorListener extends BaseErrorListener {

		private List<String> errorMessages;
		private ErrorType errorType;
		private boolean hasErrors;

		public ErrorListener(ErrorType errorType) {
			this.errorType = errorType;
		}

		@Override
		public void syntaxError(Recognizer<?, ?> recognizer,
				Object offendingSymbol, int line, int charPositionInLine,
				String msg, RecognitionException e) {
			if (errorMessages == null) {
				this.errorMessages = new ArrayList<String>();
				this.hasErrors = true;
			}
			setErrorMessage(errorType.getName() + " @line " + line + ":"
					+ charPositionInLine + " " + msg);
		}

		private void setErrorMessage(String errorMessage) {
			this.errorMessages.add(errorMessage);
		}

		public List<String> getErrorMessages() {
			return errorMessages;
		}

		public boolean hasErrors() {
			return hasErrors;
		}

	}

}
