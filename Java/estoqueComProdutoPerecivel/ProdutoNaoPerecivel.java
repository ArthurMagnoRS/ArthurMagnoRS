package estoqueComProdutoPerecivel;

public class ProdutoNaoPerecivel extends Exception
{
	public ProdutoNaoPerecivel(int n) {
		super("O produto de código "+n+" não é perecível");
	}

}
