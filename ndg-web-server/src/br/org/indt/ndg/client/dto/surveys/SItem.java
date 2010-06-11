package br.org.indt.ndg.client.dto.surveys;


public class SItem {
	
	
	String otr;
	String value;
	int index;
	
	public SItem(){
		
	}
	
	public SItem(String otr, String value) {
		this.otr = otr;
		this.value = value;
	}
	
	public String getOtr() {
		return otr;
	}
	public void setOtr(String otr) {
		this.otr = otr;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
