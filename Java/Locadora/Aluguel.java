package Locadora;

public class Aluguel {
	private Veiculo Vv;
	private double alugeu;
	private Cliente cc;
	
	public Aluguel (Veiculo v, Double alug, Cliente c) {
		Vv= v;
		alugeu = alug;
		cc = c;
		
	}

	public Veiculo getVeiculo() {
		return Vv;
	}

	public void setVeiculo(Veiculo v) {
		this.Vv = v;
	}

	public double getAlugeu() {
		return alugeu;
	}

	public void setAlugeu(double alugeu) {
		this.alugeu = alugeu;
	}

	public Cliente getCc() {
		return cc;
	}

	public void setCc(Cliente cc) {
		this.cc = cc;
	}
	

}
