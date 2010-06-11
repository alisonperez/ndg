package br.org.indt.ndg.error;

public class SurveysHomeNotFoundException extends Throwable {
	private static final long serialVersionUID = 8861331796773212555L;

	public SurveysHomeNotFoundException() {
		super("surveysHome not set in mobisus.properties file");
	}

}
