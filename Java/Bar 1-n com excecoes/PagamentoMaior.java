package Bar;

public class PagamentoMaior extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PagamentoMaior() {
		super("O pagamento que está tentando fazer é maior que o extrato da conta respectiva!");
	}

}
