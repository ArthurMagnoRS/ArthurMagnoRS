package bancoParaTrabalho;

public class Banco {

	private Conta contas[] = new Conta[10];
	private int pos = 0;
	
	public void cadastrar(Conta c) {
		contas[pos++] = c;
	}
	
	public void saque(int num, double val, String senha) {
		Conta c = pesquisa(num);
		if (c != null) {
			c.debito(val, senha);
		}
	}
	
	public void deposito(int num, double val) {
		Conta c = pesquisa(num);
		if (c != null) {
		  c.credito(val);
		}
	}
	
	public String extrato(int num) {
		Conta c = pesquisa(num);
		if (c != null) {
		  return c.getExtrato();
		}
		return "";
	}
	
	public double saldo(int num) {
		Conta c = pesquisa(num);
		if (c != null) {
		  return c.getSaldo();
		}
		return -9999999;
	}
	
	private Conta pesquisa(int num) {
		for (int i = 0; i < pos; i++) {
			if (contas[i].getNumero() == num) {
				return contas[i];
			}
		}
		return null;
	}
	
	public void transferencia(int num1, int num2, double val, String senha) {
		Conta c1 = pesquisa(num1);
		Conta c2 = pesquisa(num2);
		if (c1 != null && c2 != null) {
			if (c1.debito(val, senha)) {
			  c2.credito(val);
			}
		}
	}
}
