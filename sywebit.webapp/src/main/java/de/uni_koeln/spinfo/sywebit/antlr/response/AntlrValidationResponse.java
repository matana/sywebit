package de.uni_koeln.spinfo.sywebit.antlr.response;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AntlrValidationResponse {
	
	private String date;
	
//	private Map<String, String> map;

	private List<String> parserErrorMessages;
	
	private List<String> lexerErrorMessages;
	

	public String getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = new SimpleDateFormat("yyyy.MM.dd - hh:mm:ss").format(date);
	}

//	public void setMap(Map<String, String> map) {
//		this.map = map;
//	}
//	
//	public Map<String, String> getMap() {
//		return map;
//	}

	public List<String> getLexerErrorMessage() {
		return lexerErrorMessages;
	}

	public void setLexerErrorMessages(List<String> lexerErrorMessages) {
		this.lexerErrorMessages = lexerErrorMessages;
	}
	
	public List<String> getParserErrorMessages() {
		return parserErrorMessages;
	}

	public void setParserErrorMessages(List<String> parserErrorMessages) {
		this.parserErrorMessages = parserErrorMessages;
		
	}
	

}
