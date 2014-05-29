package de.uni_koeln.spinfo.sywebit.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping("/")
	public String index(Map<String, Object> model) {
		logger.info("index called");
		return "index";
	}

	@RequestMapping(value = "/editor/validate", method = RequestMethod.POST, produces = { "application/json" })
	public String validate(@RequestParam String token, HttpServletRequest request, HttpServletResponse response, Model model) {
		
		logger.info("/editor/validate [data=" + token + "]");
		
		// TODO: Validate token...
		
		return "index";
	}
}
