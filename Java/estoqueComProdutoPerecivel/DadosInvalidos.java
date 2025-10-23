package estoqueComProdutoPerecivel;

public class DadosInvalidos extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6392706840612236368L;
	public DadosInvalidos() {
		super("Os dados inseridos são inválidos!");
	}
}
