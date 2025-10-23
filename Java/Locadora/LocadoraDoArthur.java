package Locadora;

import java.util.ArrayList;

public class LocadoraDoArthur implements Locadora {
	
	ArrayList<Veiculo> frota = new ArrayList<Veiculo>();
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	ArrayList<Aluguel> veiculoalugado = new ArrayList<Aluguel>();
	ArrayList<Aluguel> veiculosDevolvidos = new ArrayList<Aluguel>();
	@Override
	public void inserir(Veiculo v) {
		Veiculo veiculo = pesquisar(v.getPlaca());
		if (veiculo == null) {
			frota.add(v);
		}		
	}

	@Override
	public void inserir(Cliente c) {
		Cliente cli = pesquisar(c.getCpf());
		if (cli == null) {
			clientes.add(c);
		}		
	}

	@Override
	public Veiculo pesquisar(String placa) {
		for (Veiculo v : frota) {
			if (v.getPlaca() == placa) {
				return v;
			}
		}
		return null;
	}
	
	public Cliente pesquisar(int cpf) {
		for (Cliente c : clientes) {
			if (c.getCpf() == cpf) {
				return c;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Veiculo> pesquisarMoto(int cilindrada) {
		ArrayList<Veiculo> lista = new ArrayList<Veiculo>();
		for (Veiculo v : frota) {
			if (v instanceof Moto m) {
				if (m.getCilindrada() >= cilindrada) {
					lista.add(m);
				}
			}
		}
		return lista;
	}

	@Override
	public ArrayList<Veiculo> pesquisarCarro(int tipoCarro) {
		ArrayList<Veiculo> lista = new ArrayList<Veiculo>();
		for (Veiculo v : frota) {
			if (v instanceof Carro m) {
				if (m.getTipo() == tipoCarro) {
					lista.add(m);
				}
			}
		}
		return lista;
	}

	@Override
	public ArrayList<Veiculo> pesquisarCaminhao(int carga) {
		ArrayList<Veiculo> lista = new ArrayList<Veiculo>();
		for (Veiculo v : frota) {
			if (v instanceof Caminhao m) {
				if (m.getCarga() >= carga) {
					lista.add(m);
				}
			}
		}
		return lista;
	}

	@Override
	public ArrayList<Veiculo> pesquisarOnibus(int passageiros) {
		ArrayList<Veiculo> lista = new ArrayList<Veiculo>();
		for (Veiculo v : frota) {
			if (v instanceof Onibus m) {
				if (m.getPassageiros() >= passageiros) {
					lista.add(m);
				}
			}
		}
		return lista;
	}

	@Override
	public double calcularAluguel(String placa, int dias) {
		for (Veiculo v: frota) {
			if (v.getPlaca() == placa) {
				return v.aluguel(dias);
			}
			
		}
		return 0;
		
	}

	@Override
	public void registrarAluguel(String placa, int dias, Cliente c) {
		double Valuguel = 0;
		Veiculo veiculor = null;
		for (Aluguel i: veiculoalugado) {
			if (i.getVeiculo().placa == placa){
				System.out.print("Veiculo ja alugado!");
				return;
			}
			Valuguel = calcularAluguel(placa, dias);
			veiculor = pesquisar(placa);
			if (veiculor == null)
				return;
			Aluguel alugado = new Aluguel(veiculor, Valuguel, c);
			veiculoalugado.add(alugado);
			
			

			
			
}	
		
		
		
		
		
		 
	}

	@Override
	public void registrarDevolucao(String placa, Cliente c) {
		
		
		if (pesquisar(placa) != null) {
		
		for (Aluguel i: veiculoalugado) {
			if (i.getVeiculo().getPlaca() == placa && i.getCc() == c) {
				veiculosDevolvidos.add(i);
				veiculoalugado.remove(i);
				
				
				
			}
		}
		
		
		}
		else{
			System.out.println("O veículo não está na frota!");
		}
	}

	@Override
	public void depreciarVeiculos(int tipo, double taxaDepreciacao) {
			
		for (Veiculo i: frota) {
			if (tipo ==0) {
				i.diminuirValorBem(taxaDepreciacao);
			}
			else if(tipo == 1) {
				if( i instanceof Moto ) {
					i.diminuirValorBem(taxaDepreciacao);
				}
			}
			else if (tipo == 2) {
				if (i instanceof Carro) {
					i.diminuirValorBem(taxaDepreciacao);
				}
			}
			else if (tipo == 3) {
				if (i instanceof Onibus) {
					i.diminuirValorBem(taxaDepreciacao);
				}
			}
			else if (tipo == 4) {
				if (i instanceof Caminhao) {
					i.diminuirValorBem(taxaDepreciacao);
				}
			}
			else {
				System.out.println("Tipo não existente!");
			}
		}
		
			
		}
		

	

		
	

	@Override
	public void aumentarDiaria(int tipo, double taxaAumento) {
		for (Veiculo i: frota) {
			if (tipo ==0) {
				i.aumentarDiaria(taxaAumento);
			}
			else if(tipo == 1) {
				if( i instanceof Moto ) {
					i.aumentarDiaria(taxaAumento);
				}
			}
			else if (tipo == 2) {
				if (i instanceof Carro) {
					i.aumentarDiaria(taxaAumento);
				}
			}
			else if (tipo == 3) {
				if (i instanceof Onibus) {
					i.aumentarDiaria(taxaAumento);
				}
			}
			else if (tipo == 4) {
				if (i instanceof Caminhao) {
					i.aumentarDiaria(taxaAumento);
				}
			}
			else {
				System.out.println("Tipo não existente!");
			}
		}
		
		
		
		
	}

	@Override
	public double faturamentoTotal(int tipo) {
		double soma = 0;
		for (Aluguel i: veiculosDevolvidos) {
			if (tipo == 0) {
				soma += i.getAlugeu();
			}
			else if (tipo == 1) {
				if (i.getVeiculo() instanceof Moto) {
					soma+=i.getAlugeu();
				}
			}
			else if (tipo == 2) {
				if (i.getVeiculo() instanceof Carro) {
					soma+=i.getAlugeu();
				}
			}
			else if (tipo == 3) {
				if (i.getVeiculo() instanceof Onibus) {
					soma+=i.getAlugeu();
				}
			}
			else if (tipo == 4) {
				if (i.getVeiculo() instanceof Caminhao) {
					soma+=i.getAlugeu();
				}
			}
			else {
				System.out.println("Veículo não encontrado!");
				return 0;
			}
		}
			return soma;
		
		
	}

	@Override
	public int quantidadeTotalDeDiarias(int tipo) {
		int soma = 0;
		for (Aluguel i: veiculosDevolvidos) {
			if (tipo == 0) {
				soma += i.getVeiculo().getValorDiaria();
			}
			else if (tipo == 1) {
				if (i.getVeiculo() instanceof Moto) {
					soma += i.getVeiculo().getValorDiaria();
				}
			}
			else if (tipo == 2) {
				if (i.getVeiculo() instanceof Carro) {
					soma += i.getVeiculo().getValorDiaria();
				}
			}
			else if (tipo == 3) {
				if (i.getVeiculo() instanceof Onibus) {
					soma += i.getVeiculo().getValorDiaria();
				}
			}
			else if (tipo == 4) {
				if (i.getVeiculo() instanceof Caminhao) {
					soma += i.getVeiculo().getValorDiaria();
				}
			}
			else {
				System.out.println("Veículo não encontrado!");
				return 0;
			}
		}
			return soma;
		
		
	}
}
