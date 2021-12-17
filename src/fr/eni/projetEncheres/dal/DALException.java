package fr.eni.projetEncheres.dal;

public class DALException extends Exception {

	/**
	 *  @author Luka CHOUVILLE
	 */
	private static final long serialVersionUID = 1L;

	public DALException() {
		super();
	}

	public DALException(String message) {
		super(message);
	}

	public DALException(Throwable cause) {
		super(cause);
	}

	public DALException(String message, Throwable cause) {
		super(message, cause);
	}

}
