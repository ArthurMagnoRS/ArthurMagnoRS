package Bar;

public class ItemJaCadastrado extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ItemJaCadastrado(int i) {
		super("O item de número"+i+"já está cadastrado!");
	}

}
