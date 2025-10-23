package Bar;

public class ContaAberta extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ContaAberta(conta i) {
	super("Esta conta" +i+ "ja foi aberta!");
	}

}
