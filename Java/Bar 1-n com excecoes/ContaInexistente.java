package Bar;

public class ContaInexistente extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ContaInexistente() {
		super("A conta não existe!");
	}

}
