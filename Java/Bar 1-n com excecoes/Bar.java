package Bar;

import java.util.ArrayList;

public class Bar implements InterfaceBar{
	
	ArrayList<conta> abertas = new ArrayList<>();
	ArrayList<conta> fechadas = new ArrayList<>();
	ArrayList <cardapio> BeC = new ArrayList<>();
	
	
	
	public void abrirConta(int numConta, int cpf, String nomeCliente)
			throws ContaAberta, ContaInexistente, DadosInvalidos {
		for (conta i: abertas) {
			if (i.getNum() == numConta) {
				throw new ContaAberta(i);
			}
		}
		if (numConta<=0 || cpf <= 0 || nomeCliente == null) {
			throw new DadosInvalidos();
		}
		conta C = new conta(numConta, cpf, nomeCliente);
		this.abertas.add(C);
		
		
	}
	
	
	public void addPedido(int numConta, int numItem, int quant)
			throws ContaFechada, ContaInexistente, ItemInexistente, DadosInvalidos {
		cardapio item = null;
		int aux = 0;
		int aux2 = 0;
		for (conta i: fechadas) {
			if (i.getNum() == numConta) {
				throw new ContaFechada(i);
			}
		}
		
		if (numConta<=0 || quant <=0) {
			throw new DadosInvalidos();
		}
		for(cardapio j: BeC) {
			if (j.getN() == numItem) {
				item = j;
				aux=1;
				break;
			}
		}
		if (aux == 0)
			throw new ItemInexistente(numItem);
		
		pedidos P = new pedidos(item.getN(), quant);
		for (conta i: abertas) {
			if (i.getNum() == numConta) {
				i.addPedidoConta(P);
				aux2 = 1;
				break;
			}
		}
		if (aux2 == 0) {
			throw new ContaInexistente();
		}
		
	}
	
	public double valorDaConta(int numConta) throws ContaInexistente {
		double extrato = 0;
		int aux = 0;
		for (conta i: abertas) {
			if (i.getNum() == numConta) {
				if (i.getPagamento()!=null)
					return i.getPagamento().getTotal();
				for (pedidos j: i.Cpedidos) {
					for(cardapio k: BeC) {
						if (j.getN() == k.getN()) {
							if (k.getCod() == 1) {
								extrato+= k.getVal() * j.getQuant();
							}
							else if (k.getCod() == 2) {
								extrato += (k.getVal()*1.1)*j.getQuant();
							}
							else if (k.getCod() == 3) {
								extrato += (k.getVal()*1.15)*j.getQuant();
							}
						}
					}
				}
			}
			aux+=1;
		}
	
		for (conta u: fechadas) {
			if (u.getNum() == numConta) {
				if (u.getPagamento()!=null)
					return u.getPagamento().getTotal();
				for (pedidos j: u.Cpedidos) {
					for(cardapio k: BeC) {
						if (j.getN() == k.getN()) {
							if (k.getCod() == 1) {
								extrato+= k.getVal() * j.getQuant();
							}
							else if (k.getCod() == 2) {
								extrato += (k.getVal()*1.1)*j.getQuant();
							}
							else if (k.getCod() == 3) {
								extrato += (k.getVal()*1.15)*j.getQuant();
							}
			
						}
					}
				}
			}
			aux+=1;
		}
		
		if (aux == (this.abertas.size() + this.fechadas.size())-1) {
			throw new ContaInexistente();
		}
		
			return extrato;
		
		
	}

	
	public double fecharConta(int numConta) throws ContaInexistente {
		double E = 0;
		int aux = 0;
		pagamento pag = null;
		for (conta i: abertas) {
			if (i.getNum() == numConta) {
				E = valorDaConta(i.getNum());
				pag = new pagamento(E);
				i.setPagamento(pag);
				aux = 1;
				this.fechadas.add(i);
				break;
			}
			
		}
		
		if(aux == 0)
			throw new ContaInexistente();
		for (conta j: fechadas) {
			if (j.getNum() == numConta)
				this.abertas.remove(j);
		}
		return E;
	}

	
	public void addCardapio(int nu, String n, double x, int tp) throws ItemJaCadastrado, DadosInvalidos {
		if (nu<=0 || n == null || x<= 0 || tp<=0) {
			throw new DadosInvalidos();
		}
		for (cardapio i: BeC) {
			if (i.getN() == nu) {
				throw new ItemJaCadastrado(nu);
			}
		}
		if (tp == 1) {
			ingresso I = new ingresso(nu,n,tp,x);
			this.BeC.add(I);
			
		}
		else if (tp == 2) {
			bebida B = new bebida(nu, n, tp, x);
			this.BeC.add(B);
		}
		else if(tp == 3) {
			comida C = new comida(nu, n, tp, x);
			this.BeC.add(C);
		}
		
		
	}

	
	public void registrarPagamento(int numConta, double val) throws PagamentoMaior, ContaInexistente, DadosInvalidos {
		int aux = 0;
		double V=0;
		double New = 0;
		if (numConta<=0 || val <= 0) {
			throw new DadosInvalidos();
		}
		for (conta i: fechadas) {
			if (i.getNum() == numConta) {
				if (val>i.getPagamento().getTotal()) {
					throw new PagamentoMaior();
				}
						V = i.getPagamento().getTotal();
						New = V - val;
						pagamento P = new pagamento(New);
						i.setPagamento(P);
						aux = 1;
						
			}
		}
		
		for (conta j: abertas) {
			if (j.getNum() == numConta) {
				if(val>j.getPagamento().getTotal()) {
					throw new PagamentoMaior();
				}
				V = j.getPagamento().getTotal();
				New = V-val;
				pagamento P = new pagamento(New);
				j.setPagamento(P);
				aux = 1;
			}
		}
		if (aux == 0) {
			throw new ContaInexistente();
		}
	}

	
	public ArrayList<Consumo> extratoDeConta(int numConta) throws ContaInexistente {
		int aux = 0;
		ArrayList<Consumo> ext = new ArrayList<>();
		double gorjeta = 0;
		Consumo C = new Consumo();
		for(conta i: abertas) {
			if(i.getNum() == numConta) {
				for(pedidos j: i.Cpedidos) {
					
					for (cardapio k: BeC) {
						if (k.getN() == j.getN()) {
							if(k.getCod() == 1) {
								gorjeta += 0;
							}
							else if (k.getCod()==2) {
								gorjeta += (k.getVal()*0.1)*j.getQuant();
							}
							else if(k.getCod()==3) {
								gorjeta += (k.getVal()*0.15)*j.getQuant();
							}
							
							double val = k.getVal();
							String name = k.getDesc();
							int quant = j.getQuant();
							int num = j.getN();
							C.setNome(name);
							C.setNum(num);
							C.setQuant(quant);
							C.setVal(val);
							ext.add(C);
							aux=1;
							
							
						}
					}
					
				}
			}
		}
		for(conta i: fechadas) {
			if(i.getNum() == numConta) {
				for(pedidos j: i.Cpedidos) {
					
					for (cardapio k: BeC) {
						if (k.getN() == j.getN()) {
							if(k.getCod() == 1) {
								gorjeta += 0;
							}
							else if (k.getCod()==2) {
								gorjeta += (k.getVal()*0.1)*j.getQuant();
							}
							else if(k.getCod()==3) {
								gorjeta += (k.getVal()*0.15)*j.getQuant();
							}
							
							double val = k.getVal();
							String name = k.getDesc();
							int quant = j.getQuant();
							int num = j.getN();
							C.setNome(name);
							C.setNum(num);
							C.setQuant(quant);
							C.setVal(val);
							ext.add(C);
							aux=1;
						}
					}
				}
			}
		}
		
		
		if (aux == 0) {
			throw new ContaInexistente();
		}
		Consumo G = new Consumo();
		G.setNome("Gorjeta");
		G.setVal(gorjeta);
		ext.add(G);
		
		
		
		
		return ext;
	}

}
