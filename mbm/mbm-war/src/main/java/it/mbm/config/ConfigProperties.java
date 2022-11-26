package it.mbm.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


@SuppressWarnings("pmd:AvoidSynchronizedAtMethodLevel")
public class ConfigProperties extends Properties{
	private static final long serialVersionUID = 1505790219461282436L;
	private String file;
	
	public ConfigProperties(InputStream is) throws IOException {
		load(is);
	} 
	public ConfigProperties(String file) throws IOException {
		this.file = file; 
		reload();
	} 
	public synchronized void reload() throws IOException {
		if(file != null){
			InputStream is = new FileInputStream(new File(file));
			load(is);
			is.close();
		} else 
			throw new IOException("Property 'file' is required");
	}
	
	public synchronized void reload(InputStream is) throws IOException {
		if(is != null){
			load(is);
		} else 
			throw new IOException("Arguments 'is' is null");
	}
	
	public Integer getIntegerProperty(String name) {
		try{
			return Integer.parseInt(getProperty(name).trim());
		} catch (Exception e) {
			return null;
		}
	}
	public Integer getIntegerProperty(String name, Integer defaultValue) {
		Integer property = getIntegerProperty(name);
		if (property == null) {
            return defaultValue;
        }
		return property;
	}
	public boolean getBooleanProperty(String name) {
		try{
			return Boolean.parseBoolean(getProperty(name).trim());
		} catch (Exception e) {
			return false;
		}
	}
	public Boolean getBooleanProperty(String name, Boolean defaultValue) {
		Boolean property = getBooleanProperty(name);
		if (property == null) {
            return defaultValue;
        }
		return property;
	}
}
