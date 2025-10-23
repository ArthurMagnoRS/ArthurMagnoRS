package Bar;

public class ContaFechada extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ContaFechada(conta i) {
		super("A conta"+ i + "está fechada!");
	}

}
