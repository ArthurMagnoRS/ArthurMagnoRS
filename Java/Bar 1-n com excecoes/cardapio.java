package Bar;

public class cardapio {
	protected String desc;
	protected int cod;
	protected double val;
	protected int n;
	
	public cardapio(int num, String d, int cod, double valor) {
		this.desc = d;
		this.cod = cod;
		this.val = valor;
		this.n = num;
		
	}

	public int getN() {
		return n;
	}

	public String getDesc() {
		return desc;
	}

	public int getCod() {
		return cod;
	}

	public double getVal() {
		return val;
	}
	
	
}
