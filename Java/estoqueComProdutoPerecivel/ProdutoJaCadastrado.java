package estoqueComProdutoPerecivel;

public class ProdutoJaCadastrado extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	//private static final long serialVersionUID = -3979634077879563638L;
	public ProdutoJaCadastrado (Produto p) {
		super("O produto "+p+" já está cadastrado!");
	}

}
