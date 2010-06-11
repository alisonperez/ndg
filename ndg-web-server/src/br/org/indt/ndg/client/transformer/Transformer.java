package br.org.indt.ndg.client.transformer;

import br.org.indt.ndg.common.SurveyXML;

public abstract class Transformer {
	protected SurveyXML survey;

	public static final String PHOTOS_DIR = "photos";
	public static final String UNDERLINE_SEPARATOR = "_";
	public static final String JPG_EXTENSION = ".jpg";	
	
	public Transformer(SurveyXML survey) {
		this.survey = survey;
	}
	
	public Transformer(){};
	
	public void setSurvey(SurveyXML survey) {
		this.survey = survey;
	}
	
	public abstract void write(String path);
	
	public abstract byte[] getBytes();

}
