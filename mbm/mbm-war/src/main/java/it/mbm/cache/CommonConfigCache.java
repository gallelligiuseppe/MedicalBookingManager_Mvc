package it.mbm.cache;

import it.mbm.config.ConfigConstants;
import it.mbm.config.ConfigProperties;

import java.io.IOException;
import java.io.Serializable;

public class CommonConfigCache implements Serializable {
	private static final long serialVersionUID = -6564937973093926820L;
	private static String configFilePath;
	private static String configFile;
	private static ConfigProperties configProperties;
	private static boolean relativePath;
	private static String realPathSlash;
	

	
	public static String getConfigFilePath() {
		return configFilePath;
	}
	public static void setConfigFilePath(String configFilePath) {
		CommonConfigCache.configFilePath = configFilePath;
	}
	public static String getConfigFile() {
		return configFile;
	}
	public static void setConfigFile(String configFile) {
		CommonConfigCache.configFile = configFile;
	}
	public static ConfigProperties getConfigProperties() {
		if(configProperties!=null){
			try {
				configProperties.reload();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return configProperties;
	}
	public static void setConfigProperties(ConfigProperties configProperties) {
		CommonConfigCache.configProperties = configProperties;
	}
	public static String getRealPathSlash() {
		return realPathSlash;
	}
	public static void setRealPathSlash(String realPathSlash) {
		CommonConfigCache.realPathSlash = realPathSlash;
	}
	public static boolean isRelativePath() {
		return relativePath;
	}
	public static void setRelativePath(boolean relativePath) {
		CommonConfigCache.relativePath = relativePath;
	}
	public static String getRealConfigFilePath(){
		if(relativePath)
			return realPathSlash+ConfigConstants.CONFIG.RELATIVE_PATH_LIBRERIE+configFilePath;
		else
			return configFilePath;
	}
}