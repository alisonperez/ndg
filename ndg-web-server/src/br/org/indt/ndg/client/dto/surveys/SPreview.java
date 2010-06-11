package br.org.indt.ndg.client.dto.surveys;

public class SPreview {
	
	String htmlText;
	Boolean isImage;
	
	public SPreview(String htmlText, Boolean image) {
		this.htmlText = htmlText;
		this.isImage = image;
	}

	public String getHtmlText() {
		return htmlText;
	}

	public void setHtmlText(String htmlText) {
		this.htmlText = htmlText;
	}

	public Boolean getIsImage() {
		return isImage;
	}

	public void setIsImage(Boolean isImage) {
		this.isImage = isImage;
	}

}
