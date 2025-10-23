package Bar;

import java.util.ArrayList;

public class conta {
	protected int num;
	protected int cpf;
	protected String nome;
	ArrayList<pedidos> Cpedidos = new ArrayList<>();
	pagamento P;
	
	public conta(int n, int c, String no) {
		this.num = n;
		this.cpf = c;
		this.nome = no;
	}
	
	//public void addExtratoConta(Consumo j) {
		//this.extract.add(j);
	//}
	
	public void addPedidoConta(pedidos i) {
		this.Cpedidos.add(i);
	}
	
public pagamento getPagamento() {
	return this.P;
}
	
public void setPagamento(pagamento p) {
	this.P = p;
}

public int getNum() {
	return num;
}

public int getCpf() {
	return cpf;
}

public String getNome() {
	return nome;
	}
}
