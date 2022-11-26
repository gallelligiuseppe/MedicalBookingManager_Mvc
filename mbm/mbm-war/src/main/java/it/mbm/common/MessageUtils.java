package it.mbm.common;



import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.mbm.components.Message;
import it.mbm.components.MessageLevelEnum;



public class MessageUtils {
	
	private static final String MESSAGES = "messages";
	
	
	/**
	 * ==================================================================
	 * ============================= MODEL ==============================
	 * ================================================================== 
	 */
	public static void setSuccessMessage(Model model, ApplicationContext messagecontext, String messageProperty){
    	setMessageToModelInternal(model, null, messagecontext, null, messageProperty, MessageLevelEnum.SUCCESS);
    }
	
	public static void setInfoMessage(Model model, ApplicationContext messagecontext, String messageProperty){
    	setMessageToModelInternal(model, null, messagecontext, null, messageProperty, MessageLevelEnum.INFO);
    }
	
	public static void setErrorMessage(Model model, ApplicationContext messagecontext, String messageProperty){
    	setMessageToModelInternal(model, null, messagecontext, null, messageProperty, MessageLevelEnum.ERROR);
    }
	
	public static void setWarningMessage(Model model, ApplicationContext messagecontext, String messageProperty){
    	setMessageToModelInternal(model, null, messagecontext, null, messageProperty, MessageLevelEnum.WARNING);
    }
	
	public static void setSuccessMessage(Model model, ApplicationContext messagecontext, Object[] params, String messageProperty){
    	setMessageToModelInternal(model, null, messagecontext, params, messageProperty, MessageLevelEnum.SUCCESS);
    }
	
	public static void setInfoMessage(Model model, ApplicationContext messagecontext, Object[] params, String messageProperty){
    	setMessageToModelInternal(model, null, messagecontext, params, messageProperty, MessageLevelEnum.INFO);
    }
	
	public static void setErrorMessage(Model model, ApplicationContext messagecontext, Object[] params, String messageProperty){
    	setMessageToModelInternal(model, null, messagecontext, params, messageProperty, MessageLevelEnum.ERROR);
    }
	
	public static void setWarningMessage(Model model, ApplicationContext messagecontext, Object[] params, String messageProperty){
    	setMessageToModelInternal(model, null, messagecontext, params, messageProperty, MessageLevelEnum.WARNING);
    }
	
	/**
	 * ========================================================================================
	 * ============================= REDIRECTATTRIBUTES =======================================
	 * ========================================================================================
	 */
	public static void setSuccessMessage(RedirectAttributes redirectAttributes, ApplicationContext messagecontext, String messageProperty){
		setMessageToModelInternal(null, redirectAttributes, messagecontext, null, messageProperty, MessageLevelEnum.SUCCESS);
    }
	
	public static void setInfoMessage(RedirectAttributes redirectAttributes, ApplicationContext messagecontext, String messageProperty){
		setMessageToModelInternal(null, redirectAttributes, messagecontext, null, messageProperty, MessageLevelEnum.INFO);
    }
	
	public static void setErrorMessage(RedirectAttributes redirectAttributes, ApplicationContext messagecontext, String messageProperty){
		setMessageToModelInternal(null, redirectAttributes, messagecontext, null, messageProperty, MessageLevelEnum.ERROR);
    }
	
	public static void setWarningMessage(RedirectAttributes redirectAttributes, ApplicationContext messagecontext, String messageProperty){
		setMessageToModelInternal(null, redirectAttributes, messagecontext, null, messageProperty, MessageLevelEnum.WARNING);
    }
	
	public static void setSuccessMessage(RedirectAttributes redirectAttributes, ApplicationContext messagecontext, Object[] params, String messageProperty){
		setMessageToModelInternal(null, redirectAttributes, messagecontext, params, messageProperty, MessageLevelEnum.SUCCESS);
    }
	
	public static void setInfoMessage(RedirectAttributes redirectAttributes, ApplicationContext messagecontext, Object[] params, String messageProperty){
		setMessageToModelInternal(null, redirectAttributes, messagecontext, params, messageProperty, MessageLevelEnum.INFO);
    }
	
	public static void setErrorMessage(RedirectAttributes redirectAttributes, ApplicationContext messagecontext, Object[] params, String messageProperty){
		setMessageToModelInternal(null, redirectAttributes, messagecontext, params, messageProperty, MessageLevelEnum.ERROR);
    }
	
	public static void setWarningMessage(RedirectAttributes redirectAttributes, ApplicationContext messagecontext, Object[] params, String messageProperty){
		setMessageToModelInternal(null, redirectAttributes, messagecontext, params, messageProperty, MessageLevelEnum.WARNING);
    }
	
	@SuppressWarnings("unchecked")
	private static void setMessageToModelInternal(Model model, RedirectAttributes redirectAttributes, ApplicationContext messagecontext, Object[] params, String messageProperty, MessageLevelEnum level) {

		List<Message> messages = new ArrayList<Message>();
		
		String message = messagecontext.getMessage(messageProperty, params, Locale.ITALY);
		if(CommonUtils.isEmptyString(message)) {
			message = "message property ["+message+"] non trovata nel file messages.properties!";
		}
		
		if(model!=null) {
    		boolean isPresent = model.containsAttribute(MESSAGES);
    		if(isPresent) {
    			Map<String, Object> attributesMap = model.asMap();
    			for(String key : attributesMap.keySet()) {
    				if(key.equalsIgnoreCase(MESSAGES)) {
    					messages = (List<Message>)attributesMap.get(MESSAGES);
    				}
    			}
    		} else {
    			messages = new ArrayList<Message>();
    			model.addAttribute(MESSAGES, messages);
    		}
    	}
		
		if(redirectAttributes!=null) {
    		boolean isPresent = redirectAttributes.containsAttribute(MESSAGES);
    		if(isPresent) {
    			Map<String, Object> attributesMap = redirectAttributes.asMap();
    			for(String key : attributesMap.keySet()) {
    				if(key.equalsIgnoreCase(MESSAGES)) {
    					messages = (List<Message>)attributesMap.get(MESSAGES);
    				}
    			}
    		} else {
    			messages = new ArrayList<Message>();
    			redirectAttributes.addFlashAttribute(MESSAGES, messages);
    		}
    	}
		
		Message messageObj = new Message();
		messageObj.setMessage(message);
		messageObj.setLevel(level);
		messages.add(messageObj);
	}
	
	
	
	/**
	 * ==================================================================
	 * ============================= MODEL ==============================
	 * ================================================================== 
	 * Scrittura dei messaggi senza file di properties
	 */
	public static void setSuccessBulkMessage(Model model, String message){
    	setBulkMessageToModelInternal(model, null, message, MessageLevelEnum.SUCCESS);
    }
	
	public static void setInfoBulkMessage(Model model, String message){
    	setBulkMessageToModelInternal(model, null, message, MessageLevelEnum.INFO);
    }
	
	public static void setErrorBulkMessage(Model model, String message){
    	setBulkMessageToModelInternal(model, null, message, MessageLevelEnum.ERROR);
    }
	
	public static void setWarningBulkMessage(Model model, String message){
    	setBulkMessageToModelInternal(model, null, message, MessageLevelEnum.WARNING);
    }
	
	
	
	/**
	 * ===============================================================================
	 * ============================= REDIRECTATTRIBUTES ==============================
	 * =============================================================================== 
	 * Scrittura dei messaggi senza file di properties
	 */
	public static void setSuccessBulkMessage(RedirectAttributes redirectAttributes, String message){
    	setBulkMessageToModelInternal(null, redirectAttributes, message, MessageLevelEnum.SUCCESS);
    }
	
	public static void setInfoBulkMessage(RedirectAttributes redirectAttributes, String message){
    	setBulkMessageToModelInternal(null, redirectAttributes, message, MessageLevelEnum.INFO);
    }
	
	public static void setErrorBulkMessage(RedirectAttributes redirectAttributes, String message){
    	setBulkMessageToModelInternal(null, redirectAttributes, message, MessageLevelEnum.ERROR);
    }
	
	public static void setWarningBulkMessage(RedirectAttributes redirectAttributes, String message){
    	setBulkMessageToModelInternal(null, redirectAttributes, message, MessageLevelEnum.WARNING);
    }
	
	
	
	@SuppressWarnings("unchecked")
	private static void setBulkMessageToModelInternal(Model model, RedirectAttributes redirectAttributes,String message, MessageLevelEnum level) {
		List<Message> messages = new ArrayList<Message>();
		
		if(model!=null) {
    		boolean isPresent = model.containsAttribute(MESSAGES);
    		if(isPresent) {
    			Map<String, Object> attributesMap = model.asMap();
    			for(String key : attributesMap.keySet()) {
    				if(key.equalsIgnoreCase(MESSAGES)) {
    					messages = (List<Message>)attributesMap.get(MESSAGES);
    				}
    			}
    		} else {
    			messages = new ArrayList<Message>();
    			model.addAttribute(MESSAGES, messages);
    		}
    	}
		
		if(redirectAttributes!=null) {
    		boolean isPresent = redirectAttributes.containsAttribute(MESSAGES);
    		if(isPresent) {
    			Map<String, Object> attributesMap = redirectAttributes.asMap();
    			for(String key : attributesMap.keySet()) {
    				if(key.equalsIgnoreCase(MESSAGES)) {
    					messages = (List<Message>)attributesMap.get(MESSAGES);
    				}
    			}
    		} else {
    			messages = new ArrayList<Message>();
    			redirectAttributes.addFlashAttribute(MESSAGES, messages);
    		}
    	}
		
		Message messageObj = new Message();
		messageObj.setMessage(message);
		messageObj.setLevel(level);
		messages.add(messageObj);
	}
	
	
	
	@SuppressWarnings("unchecked")
	public static String getMessageFromProperties(ApplicationContext messagecontext, Object[] params, String messageProperty) {
		String message = messagecontext.getMessage(messageProperty, params, Locale.ITALIAN);
		if(CommonUtils.isEmptyString(message)) {
			message = "message property ["+message+"] non trovata nel file messages.properties!";
		}
		return message;
	}
}
