package br.org.indt.ndg.error;

public class PropertiesNotFoundException extends Throwable {
	
	private static final long serialVersionUID = 8861331796773212555L;

	public PropertiesNotFoundException(String path) {
		super("Properties File Not Found" + path);
	}

}
