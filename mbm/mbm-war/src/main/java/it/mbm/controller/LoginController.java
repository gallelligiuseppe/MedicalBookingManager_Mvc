package it.mbm.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.mbm.model.Utente;


@Controller
@SessionAttributes("user")
public class LoginController extends BaseController{

	@RequestMapping(value="/")
	public String getLogin(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		
		//LoggedUser loggedUser = (LoggedUser) request.getSession().getAttribute(CommonConstants.SESSION_ATTR_LOGGED_USER);
		
		String resultValue = "/login";
		model.addAttribute("user", new Utente());
		return resultValue;
	}
	
	@RequestMapping(value="/checkLogin", method=RequestMethod.POST)
	public String checkLogin(HttpServletRequest request, HttpServletResponse response, Model model,
			@ModelAttribute ("user") Utente utente) throws IOException,Exception {
		
		//LoggedUser loggedUser = (LoggedUser) request.getSession().getAttribute(CommonConstants.SESSION_ATTR_LOGGED_USER);
		
		String resultValue = "login";
		model.addAttribute("user", new Utente());
		return resultValue;
	}
}