package it.mbm.config;

import it.mbm.cache.CommonConfigCache;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;

import org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
import org.springframework.web.context.ContextLoaderListener;

public class ConfigListener extends ContextLoaderListener {

	private static final Logger logger = LogManager.getLogger(ConfigListener.class) ;
	
	@Resource(name=ConfigConstants.CONFIG.CONFIG_FILE_PATH)
	private String configFilePath;
	@Resource(name=ConfigConstants.CONFIG.CONFIG_FILE)
	private String configFile;
	
	
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		logger.info("ConfigListener.contextInitialized(ServletContextEvent servletContextEvent)");
		setStaticPropertyCache(servletContextEvent);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		logger.info("ConfigListener.contextDestroyed(ServletContextEvent servletContextEvent)");
	}
	
	
	private void setStaticPropertyCache(ServletContextEvent servletContextEvent){
		CommonConfigCache.setRealPathSlash(servletContextEvent.getServletContext().getRealPath(ConfigConstants.SLASH).replace(ConfigConstants.BACKSLASH, ConfigConstants.SLASH)+ConfigConstants.SLASH);
		CommonConfigCache.setConfigFilePath(configFilePath);
		CommonConfigCache.setConfigFile(configFile);
		
		try {
			//Carico il file di configurazione in con path assoluto
			CommonConfigCache.setRelativePath(false); 
			CommonConfigCache.setConfigProperties(new ConfigProperties(CommonConfigCache.getRealConfigFilePath()+configFile));
		} catch (IOException e) {
			//Carico il file di configurazione in con path relativo
			try {
				CommonConfigCache.setRelativePath(true);
				CommonConfigCache.setConfigProperties(new ConfigProperties(CommonConfigCache.getRealConfigFilePath()+configFile));
			} catch (IOException io) {
				CommonConfigCache.setRelativePath(false);
				logger.error("Non è stato possibile caricare il file di configurazione dal path: "+e.getMessage()+","+io.getMessage());
			}
		}
	}
}
