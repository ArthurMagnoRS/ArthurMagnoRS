package Bar;

public class ItemInexistente extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ItemInexistente(int i) {
		super("O item de número" + i + "não existe!");
	}

}
