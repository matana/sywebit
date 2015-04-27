package de.uni_koeln.spinfo.sywebit.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.uni_koeln.spinfo.sywebit.antlr.Antlr4WebEdit;
import de.uni_koeln.spinfo.sywebit.antlr.response.AntlrValidationResponse;

@Controller
public class WebController {

	@Autowired
	Antlr4WebEdit antlr;

	Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping("/")
	public String index(Map<String, Object> model) {
		return "index";
	}

	@RequestMapping(value = "/editor/validate", method = RequestMethod.POST, produces = { "application/json" })
	public @ResponseBody AntlrValidationResponse validate(@RequestParam String entry,
			HttpServletRequest request, HttpServletResponse response) {
		return antlr.processEntry(entry);
	}

}
