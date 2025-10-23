package estoqueComProdutoPerecivel;

import java.util.ArrayList;

public class ProdutoPerecivel extends Produto {
	
	protected ArrayList <Lote> lote = new ArrayList<>();
	protected Lote lot;
	
	public ProdutoPerecivel(int cod, String desc, int min, double lucro) {
		super(cod, desc, min, lucro);
		
	}
	
	public void setLote(Lote l) {
		this.lot = l;
		this.lote.add(this.lot);
	}
	
	public ArrayList<Lote> getLote() {
		return this.lote;
	}
	
}
