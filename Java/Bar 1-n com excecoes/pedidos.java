package Bar;

import java.util.ArrayList;

public class pedidos {
	ArrayList<conta> Pcontas = new ArrayList<>();
	public int n;
	public int quant;
	
	public pedidos(int n, int q) {
		this.n = n;
		this.quant = q;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}
	
	public void addContaPedido(conta i) {
		this.Pcontas.add(i);
	}
}
