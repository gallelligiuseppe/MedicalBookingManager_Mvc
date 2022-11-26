package it.mbm.controller;

import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import it.mbm.common.CommonUtils;
import it.mbm.common.MessageUtils;
import it.mbm.model.storedprocedure.CallableParameter;


@Controller
public class BaseController {

	private static final Logger logger = LogManager.getLogger(BaseController.class);

	@Autowired
	private ApplicationContext messagecontext;

	public ApplicationContext getMessagecontext() {
		return messagecontext;
	}

	public void setMessagecontext(ApplicationContext messagecontext) {
		this.messagecontext = messagecontext;
	}

	/**
	 * Metodo per intercettare eccezioni generiche
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(HttpServletRequest req, Exception ex) {
		ex.printStackTrace();
		logger.error("Request: " + req.getRequestURL() + " raised " + ex);

		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.addObject("message", ex.getMessage());
		mav.addObject("url", req.getRequestURL());
		String xRequestedWith = req.getHeader("X-Requested-With"); // if this parameter is not NULL and equals to
																	// "XMLHttpRequest", the request is made from ajax
		if (!CommonUtils.isEmptyString(xRequestedWith) && "XMLHttpRequest".equals(xRequestedWith)) {
			mav.setViewName("ajaxErrorSnippet");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}

	/**
	 * Metodo per intercettare SecurityException
	 */
	@ExceptionHandler(SecurityException.class)
	public ModelAndView handleValidationException(HttpServletRequest req, Exception ex) {
		ex.printStackTrace();
		logger.error("Request: " + req.getRequestURL() + " raised " + ex);

		ModelAndView mav = new ModelAndView();
		mav.addObject("securityException", ex);
		mav.addObject("message", "Errore di sicurezza riscontrato durante l'operazione.");
		mav.addObject("url", req.getRequestURL());
		String xRequestedWith = req.getHeader("X-Requested-With"); // if this parameter is not NULL and equals to
																	// "XMLHttpRequest", the request is made from ajax
		if (!CommonUtils.isEmptyString(xRequestedWith) && "XMLHttpRequest".equals(xRequestedWith)) {
			mav.setViewName("ajaxErrorSnippet");
		} else {
			mav.setViewName("securityError");
		}

		return mav;
	}

	/**
	 * Metodo per intercettare eccezioni specifiche (in questo caso
	 * NullPointerException e NumberFormatException)
	 */
	@ExceptionHandler({ NullPointerException.class, NumberFormatException.class })
	public ModelAndView handleSpecificException(HttpServletRequest req, Exception ex) {
		ex.printStackTrace();
		logger.error("Request: " + req.getRequestURL() + " raised " + ex);

		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.addObject("message", ex.getMessage());
		mav.addObject("url", req.getRequestURL());
		String xRequestedWith = req.getHeader("X-Requested-With"); // if this parameter is not NULL and equals to
																	// "XMLHttpRequest", the request is made from ajax
		if (!CommonUtils.isEmptyString(xRequestedWith) && "XMLHttpRequest".equals(xRequestedWith)) {
			mav.setViewName("ajaxErrorSnippet");
		} else {
			mav.setViewName("error");
		}

		/*
		 * Inserire qui una logica che è specifica per l'eccezione intercettata
		 */
		return mav;
	}

	/**
	 * ===============================================================================================
	 * =========== METODO UTILIZZATO PER EFFETTUARE REDIRECT DA CONTROLLER A
	 * CONTROLLER ==============
	 * ===============================================================================================
	 */
	protected String sendRedirectToController(HttpServletRequest request, String pathToController) {
		return "redirect:" + pathToController;
	}
	
	protected String sendRedirectToControllerArgs(HttpServletRequest request, String pathToController) {
		return "redirect:"+pathToController;
	}


	// Gestione degli errori nel controller con redirect alla pagina precedente
	public void manageErrorsMessageWithRedirect(Model model, RedirectAttributes redir, CallableParameter<?> cp) {
		if (cp.getOutParam().getErroreSql() == 0) {
			MessageUtils.setSuccessMessage(model, getMessagecontext(), "messaggio.successo");
			MessageUtils.setSuccessMessage(redir, getMessagecontext(), "messaggio.successo");
		} else {
			MessageUtils.setErrorBulkMessage(model, cp.getOutParam().getErroreMsg());
			MessageUtils.setErrorBulkMessage(redir, cp.getOutParam().getErroreMsg());
		}
	}
}
