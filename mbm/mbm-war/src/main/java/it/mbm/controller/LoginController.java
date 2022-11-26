package it.mbm.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLogin(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException,Exception {
		
		//LoggedUser loggedUser = (LoggedUser) request.getSession().getAttribute(CommonConstants.SESSION_ATTR_LOGGED_USER);
		
		String resultValue = "login";
		
		return resultValue;
	}
}