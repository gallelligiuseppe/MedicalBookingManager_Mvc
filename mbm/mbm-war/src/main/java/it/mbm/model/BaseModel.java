package it.mbm.model;

import java.io.Serializable;

public class BaseModel implements Serializable {

	private static final long serialVersionUID = -6758795776988644918L;
	
	private String encryptedId;	//parametro che deve essere utilizzato per passare l'id alle pagine JSP. In questo modo vengono mascherati gli ID al client.

	public String getEncryptedId() {
		return encryptedId;
	}
	
	public void setEncryptedId(String encryptedId) {
		this.encryptedId = encryptedId;
	}

}
