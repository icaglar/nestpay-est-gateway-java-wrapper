package gkhts.payment.exceptions;

public class ConfigurationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ConfigurationException() {

	}

	public ConfigurationException(Throwable cause) {
		super(cause);
	}

	public ConfigurationException(String message) {
		super(message, null);
	}

	public ConfigurationException(String message, Throwable cause) {
		super(message, cause);
	}

}
