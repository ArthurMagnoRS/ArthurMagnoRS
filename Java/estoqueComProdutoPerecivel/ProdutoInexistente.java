package estoqueComProdutoPerecivel;

public class ProdutoInexistente extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4676020803601825448L;
	public ProdutoInexistente (int n) {
		super ("O produto de código "+n+" não existe!");
		
	}

}
