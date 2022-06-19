package basic05_collection;

public class ProductVO<T> {

	private T protuctName;
	public ProductVO() {
		
	}
	public T getProtuctName() {
		return protuctName;
	}
	public void setProtuctName(T protuctName) {
		this.protuctName = protuctName;
	}
	

}
