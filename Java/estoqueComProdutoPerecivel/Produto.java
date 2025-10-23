package estoqueComProdutoPerecivel;
import java.util.ArrayList;
public class Produto {
	private int cod;
	private String desc;
	private int min;
	private double lucro;
	private double preço_venda;
	private double preço_compra;
	private int quant;
	public ArrayList<Fornecedor> fornecedorers = new ArrayList<>();
	
	
	
	// min = estoque minimo para venda; lucro = porcentagem de lucro;
	public Produto(int cod, String desc, int min, double lucro) {
		this.cod = cod;
		this.desc = desc;
		this.min = min;
		this.lucro = lucro;
		this.preço_compra=0;
		this.preço_venda=0;		
	}
	//sets e getters//
	


	public int getCodigo() {
		return this.cod;
	}
	public String getDescricao() {
		return this.desc;
	}
	public int getMin() {
		return this.min;
	}
	public double getLucro() {
		return this.lucro;
	}
	public double getPreço_venda() {
		return this.preço_venda;
	}
	public double getPreço_compra() {
		return this.preço_compra;
	}

	public void setPreço_compra(double preço_compra) {
		this.preço_compra = preço_compra;
	}

	public void setPreço_venda(double preço_venda) {
		this.preço_venda = preço_venda;
	}
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quat) {
		this.quant = quat;
	}
	public void setFornecedores(Fornecedor F) {
		this.fornecedorers.add(F);
	}
	
	
	
	
	// métodos; //
	
	public void compra(int quant, double val) {
		double attP = ((this.getPreço_compra() * this.getQuant()) + val * quant)/(this.getQuant() + quant);
		this.setPreço_compra(attP);
		double attPV = (this.getPreço_compra() + (this.getPreço_compra()*this.getLucro()));
		this.setPreço_venda(attPV);
		this.quant+=quant;
	}
}
