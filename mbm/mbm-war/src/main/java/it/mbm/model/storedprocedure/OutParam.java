package it.mbm.model.storedprocedure;

import java.util.Date;

public class OutParam<T> {
	private T estraz;
	private Integer tot;
	
	private Integer intParam01;
	private Integer intParam02;
	private Integer intParam03;
	private Integer intParam04;
	
	private Integer erroreSql;
	private String erroreMsg;

	private String stringParam01;
	private String stringParam02;
	private String stringParam03;
	private String stringParam04;
	private String stringParam05;
	private String stringParam06;
	
	private Date dateParam01;
	private Date dateParam02;
	private Date dateParam03;

	public T getEstraz() {
		return estraz;
	}

	public void setEstraz(T estraz) {
		this.estraz = estraz;
	}

	public Integer getTot() {
		return tot;
	}

	public void setTot(Integer tot) {
		this.tot = tot;
	}

	public Integer getIntParam01() {
		return intParam01;
	}

	public void setIntParam01(Integer intParam01) {
		this.intParam01 = intParam01;
	}
	
	public Integer getIntParam02() {
		return intParam02;
	}

	public void setIntParam02(Integer intParam02) {
		this.intParam02 = intParam02;
	}

	public Integer getIntParam03() {
		return intParam03;
	}

	public void setIntParam03(Integer intParam03) {
		this.intParam03 = intParam03;
	}

	public Integer getIntParam04() {
		return intParam04;
	}

	public void setIntParam04(Integer intParam04) {
		this.intParam04 = intParam04;
	}

	public Integer getErroreSql() {
		return erroreSql;
	}

	public void setErroreSql(Integer erroreSql) {
		this.erroreSql = erroreSql;
	}

	public String getErroreMsg() {
		return erroreMsg;
	}

	public void setErroreMsg(String erroreMsg) {
		this.erroreMsg = erroreMsg;
	}

	public String getStringParam01() {
		return stringParam01;
	}

	public void setStringParam01(String stringParam01) {
		this.stringParam01 = stringParam01;
	}

	public String getStringParam02() {
		return stringParam02;
	}

	public void setStringParam02(String stringParam02) {
		this.stringParam02 = stringParam02;
	}
	
	public String getStringParam03() {
		return stringParam03;
	}

	public void setStringParam03(String stringParam03) {
		this.stringParam03 = stringParam03;
	}

	public String getStringParam04() {
		return stringParam04;
	}

	public void setStringParam04(String stringParam04) {
		this.stringParam04 = stringParam04;
	}

	public String getStringParam05() {
		return stringParam05;
	}

	public void setStringParam05(String stringParam05) {
		this.stringParam05 = stringParam05;
	}

	public String getStringParam06() {
		return stringParam06;
	}

	public void setStringParam06(String stringParam06) {
		this.stringParam06 = stringParam06;
	}

	@Override
	public String toString() {
		return "OutParam [estraz=" + estraz + ", tot=" + tot + ", intParam01=" + intParam01 + ", erroreSql=" + erroreSql + ", erroreMsg=" + erroreMsg + ", stringParam01=" + stringParam01 + ", stringParam02=" + stringParam02 + "]";
	}

	public Date getDateParam01() {
		return dateParam01;
	}

	public void setDateParam01(Date dateParam01) {
		this.dateParam01 = dateParam01;
	}

	public Date getDateParam02() {
		return dateParam02;
	}

	public void setDateParam02(Date dateParam02) {
		this.dateParam02 = dateParam02;
	}

	public Date getDateParam03() {
		return dateParam03;
	}

	public void setDateParam03(Date dateParam03) {
		this.dateParam03 = dateParam03;
	}

}
