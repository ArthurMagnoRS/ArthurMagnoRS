package bancoParaTrabalho;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteBanco {

	@Test
	void testarSaquesEDepositos() {
		Banco b = new Banco();
		
		Pessoa p1 = new Pessoa(123, "123");
		Pessoa p2 = new Pessoa(456, "456");

		Conta c1 = new Conta(1, p1);
		Conta c2 = new Conta(2, p2);
		
		b.cadastrar(c1);
		b.cadastrar(c2);
		
		
		b.deposito(1, 101);
		assertEquals(101, b.saldo(1), 0.001);
		b.saque(1, 99, "123");
		assertEquals(2, b.saldo(1), 0.001);
		// casos em que darao errado o deposito:
	
		b.deposito(7, 10);
		equals(null); // conta invalida
		b.deposito(1, -5);
		assertEquals(2, b.saldo(1), 0.001);// valor invalido
	
		//  casos que darao errado em saque:
		
		b.saque(1, 1, "122");
		assertEquals(2, b.saldo(1), 0.001); // senha errada;
		b.saque(1, -5, "123");
		assertEquals(2, b.saldo(1), 0.001);// valor invalido;
		b.saque(6, 1, "123");
		assertEquals(2, b.saldo(1), 0.001);// conta null (nao cadastrada no banco b)
		
		
		// saldo dando errado:
		
		b.saldo(10);
		assertEquals(-9999999, b.saldo(10));
	}

	@Test
	void testarExtrato() {
	Banco b2 = new Banco();
	
	Pessoa p3 = new Pessoa(789, "789");
	Pessoa p4 = new Pessoa(012, "012");
	
	Conta c3 = new Conta(3, p3);
	Conta c4 = new Conta(4, p4);
	
	b2.cadastrar(c3);
	b2.cadastrar(c4);
	
	b2.deposito(3, 120);
	b2.extrato(3);
	assertEquals("" + "Credito: " + 120.0 + ". Saldo: " + b2.saldo(3) + "\n", b2.extrato(3));
	double aux = b2.saldo(3);
	b2.saque(3, 30, "789");
	
	assertEquals("" + "Credito: " + 120.0 + ". Saldo: " + aux + "\n"  + "Debito: " + 30.0 + ". Saldo: " + b2.saldo(3) + "\n", b2.extrato(3));
	
	
	// extrato dando erro:
	b2.saque(10, 10, "1234" );
	assertEquals("", b2.extrato(10));
	
	
	}
	
	@Test
	void testarTransferencias() {
		Banco b3 = new Banco();
		
		Pessoa p5 = new Pessoa(554, "554");
		Pessoa p6 = new Pessoa(665, "665");
		
		Conta c5 = new Conta(5, p5);
		Conta c6 = new Conta(6, p6);
	
		b3.cadastrar(c5);
		b3.cadastrar(c6);
		
		b3.deposito(5, 450);
		b3.transferencia(5, 6, 300, "554");
		assertEquals(150, b3.saldo(5), 0.001);
		assertEquals(300, b3.saldo(6), 0.001);
		
		// teste para um branch de conta.saque:
		
		b3.saque(6, 301, "665");
		assertEquals(300, b3.saldo(6), 0.001);
		
	}
	
	
	// testes para as classes Conta e Pessoa restantes:
	@Test
	void testarPessoaJaComConta() {
		Pessoa p7 = new Pessoa(77, "77");
		Pessoa p8 = new Pessoa(88, "88");

		Conta c7 = new Conta(7, p7);
		assertEquals(p7, c7.getDono());
		c7.setDono(p8);
		assertEquals(p8, c7.getDono());
		p7.setSenha("777");
		p7.setCpf(777);
		assertEquals(777, p7.getCpf());
		p7.setNome("magnones");
		assertEquals("magnones", p7.getNome());
		
	}
	
	
	
	
	
	
}
