package estoqueComProdutoPerecivel;
import java.util.ArrayList;
import java.util.Date;

public class Estoque implements InterfaceEstoque{
	
	protected ArrayList<Produto> produtos;
	protected ArrayList<Produto> produtosM;
	protected ArrayList<Fornecedor> fornecedorerrs;
	protected ArrayList <Date> datas;
	protected ArrayList<String> mov;
	protected ArrayList <Lote> lotes;
	protected ArrayList <Produto> produtosV;
	
	
	protected int QnE = 0;
	protected int QdP;
	protected Date c;
	long C;
	protected Date v;
	long V;
	protected double Venda;
	protected String extrato;
	
	
	
	
	public Estoque() {
		this.produtos = new ArrayList<>();
		this.produtosM = new ArrayList<>();
		this.fornecedorerrs = new ArrayList<>();
		this.datas = new ArrayList<>();
		this.mov = new ArrayList<>();
		this.lotes = new ArrayList<>();
		this.produtosV = new ArrayList<>();
		
	}
	// Quantidade de Produtos no Estoque
	// não é necessario criar um construtor para Estoque, uma vez que é pedido o padrão que é passado com o nome da classe.
	// métodos do Estoque(): 
	public void incluir(Produto p) throws ProdutoJaCadastrado, DadosInvalidos{
			
			if (p == null)
				throw new DadosInvalidos();
			
			if (p.getCodigo()<0 || p.getDescricao() == "" || p.getMin()<=0 || p.getLucro()<0 || p.getDescricao()==null || p.getDescricao() == "   ")
				throw new DadosInvalidos();
			
			for (Produto produto : produtos) { 
				if (p.getCodigo() == produto.getCodigo()) {
					System.out.print("Produto já no estoque!\n");
					throw new ProdutoJaCadastrado(p);
				} 
			}
			
			
			
			
			this.produtos.add(p);
			this.QnE++;
			
	
		}
		
			
				
		
	public void comprar(int cod, int quant, double preco, Date val)  throws ProdutoInexistente, DadosInvalidos, ProdutoNaoPerecivel {
			this.c = new Date();
			this.datas.add(this.c);
			int cont = 0;
			
			
			
			if (preco<0) {
				System.out.print("O valor não é um valor válido!");
				throw new DadosInvalidos();
			}
			if (quant <= 0) {
				System.out.print("A quantidade não é um valor válido!");
				throw new DadosInvalidos();
			}
				
				
				for (Produto i : produtos){
				
					if (cod == i.getCodigo()) {
						
						if (i instanceof ProdutoPerecivel) {
							if (val != null) {
								if (val.getTime()<c.getTime()) {
									throw new DadosInvalidos();
								}
								
								i.compra(quant, preco);
							int dia = c.getDate();
							int mes = c.getMonth()+1;
							int ano = c.getYear()+1900;
							String strdt = dia + "/" + mes + "/" + ano;
							
							mov.add(strdt +". Compra. Valor: " + preco + ". Quant: "+quant+".\n");
							Lote lote = new Lote(quant, val);
							this.lotes.add(lote);
							((ProdutoPerecivel) i).setLote(lote);
							
							
							}
							if (val == null) {
								throw new DadosInvalidos();
							}
							
							
						}
					
						else  {
							if (val == null) {
							i.compra(quant, preco);
							int dia = c.getDate();
							int mes = c.getMonth()+1;
							int ano = c.getYear()+1900;
							String strdt = dia + "/" + mes + "/" + ano;
							mov.add(strdt +". Compra. Valor: " + preco + ". Quant: "+quant+".\n");
							
							
							
							}
							if (val != null) {
								throw new ProdutoNaoPerecivel(cod);
								
								
							}
							
						}
						 
					}
					cont++;
				}
				if (cont == this.produtos.size()-1)
					throw new ProdutoInexistente(cod);
			
			
		}
		
	public double vender(int cod, int quant) throws ProdutoInexistente, ProdutoVencido, DadosInvalidos {
			this.v = new Date();
			this.datas.add(this.v);
			int cont = 0;
			
			if (quant<=0) {
				System.out.print("A quantidade não é um valor válido!");
				throw new DadosInvalidos();
				
			}
			else {
			for (Produto i:produtos) { 
				if (cod == i.getCodigo()) {
					
					if (i instanceof ProdutoPerecivel) {
						for(Lote j: ((ProdutoPerecivel) i).getLote()) {
							if (j.val.getTime()<v.getTime()) {
								throw new ProdutoVencido(cod);
							}
						}
						  
							
						}
					
						
					
					if (quant > i.getQuant()) {
						throw new DadosInvalidos();
						
					}else {
						this.Venda = quant*i.getPreço_venda();
						i.setQuant(i.getQuant()-quant);
						int dia = v.getDate();
						int mes = v.getMonth()+1;
						int ano = v.getYear()+1900;
						String strdt = dia + "/" + mes + "/" + ano;
						
						mov.add(strdt + ". Venda. Valor: " +i.getPreço_venda() + ". Quant: "+quant+".\n");
						
						
					}
				}
				cont++;
			}
			if (cont == this.produtos.size()-1)
				throw new ProdutoInexistente(cod);
			}
			return this.Venda;
		
			
			
	}
		
		
	public int quantidade(int cod) throws ProdutoInexistente {
			for (Produto i: produtos) {
				if (i.getCodigo() == cod) {
					
					QdP = i.getQuant();
					return QdP;
				}
			}
			
			throw new ProdutoInexistente(cod);
		}
		
		public String movimentacao(int cod, Date inicio, Date fim) {
			String extR = "";
			long f = fim.getTime();
			long in = inicio.getTime();
			for (Produto i: produtos) {
				if (i.getCodigo() == cod) { 
					for(int j = 0; j<mov.size();j++) {
						if (in< datas.get(j).getTime() && datas.get(j).getTime()<f)  
							extR += mov.get(j);
					}
				}
				
			}
									
				return extR;
		}
		
			
			
			
		public Produto pesquisar (int cod) throws ProdutoInexistente {
			for (Produto i: produtos) {
				if (i.getCodigo() == cod) {
					return i;
				}
			}
			
			throw new ProdutoInexistente(cod);
		}
			
			
		
		
		public void adicionarFornecedor(int cod, Fornecedor f) {
			for (Produto i: produtos) {
				if (cod == i.getCodigo()) {
					i.setFornecedores(f);
					
				}
			}
		}
		
		public ArrayList<Fornecedor> fornecedores(int cod){
			for (Produto i: produtos) { 
				if (cod == i.getCodigo()) {
					return i.fornecedorers;
			}
			
			}
			return this.fornecedorerrs;
		}
		
		
		
		public ArrayList<Produto> estoqueAbaixoDoMinimo(){
			for (Produto i: produtos) {
				if (i.getQuant()<i.getMin()) {
					this.produtosM.add(i);
				}
			}
				return this.produtosM;
				
		}
		
		
		public double precoDeVenda(int cod) {
			for (Produto i: produtos) {
				if (cod == i.getCodigo()) {
					return i.getPreço_venda();
				}
			}
			return -1;
			
		}
		
		
		public double precoDeCompra(int cod) {
			for (Produto i: produtos) {
				if (cod == i.getCodigo()) {
					return i.getPreço_compra();
				}
			}
			
			return -1;
		}
		
		public ArrayList<Produto> estoqueVencido() {
			this.c = new Date();
				for (Produto i: produtos) {
					if (i instanceof ProdutoPerecivel) {
						 for (Lote j: ((ProdutoPerecivel) i).getLote()) {
							 if (!(j.val.after(c)))
							this.produtosV.add(i);
							 break;
						}
					}
					
					
				}
			
			return this.produtosV;
		}
		
		
		public int quantidadeVencidos(int cod) throws ProdutoInexistente {
			
			throw new ProdutoInexistente(cod);
		}
		
		
		
		
		
	}
