package estoqueComProdutoPerecivel;

public class ProdutoVencido extends Exception {
		public ProdutoVencido(int n) {
			super("O produto de codigo "+n+" já está vencido!");
		}
}
