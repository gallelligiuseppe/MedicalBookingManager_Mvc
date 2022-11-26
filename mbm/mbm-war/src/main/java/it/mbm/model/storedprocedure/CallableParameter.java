package it.mbm.model.storedprocedure;

public class CallableParameter<O>  {
	Object inParam;
	OutParam<O> outParam = new OutParam<O>();
	
	public CallableParameter(Object inParam) {
		super();
		this.inParam = inParam;
	}
	public Object getInParam() {
		return inParam;
	}
	public void setInParam(Object inParam) {
		this.inParam = inParam;
	}
	public OutParam<O> getOutParam() {
		return outParam;
	}
	public void setOutParam(OutParam<O> outParam) {
		this.outParam = outParam;
	}
}