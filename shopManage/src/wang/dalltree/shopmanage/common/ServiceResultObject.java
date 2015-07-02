package wang.dalltree.shopmanage.common;

public class ServiceResultObject {
	public static final String SUCCESS = "00";
	private String result;
	private Object object;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
}
