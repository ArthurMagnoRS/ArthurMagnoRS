package Bar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

public class TesteCardapioDAO {

	@Test
	public void testarInserirRecuperar() throws ClassNotFoundException, SQLException, ItemJaCadastrado, ItemInexistente {
		cardapioDAO dao = new cardapioDAO();
		dao.apagarTodos();
		
		cardapio p1 = new cardapio(1, "vodkar", 2, 10 );
		cardapio p2 = new cardapio(2, "carninhahmmm", 3, 20);
		cardapio p3 = new cardapio(3, "ingresso", 1, 5);
		
		dao.inserirItem(1, "vodkar", 10, 2);
		dao.inserirItem(2, "carninhahmmm", 20, 3);
		dao.inserirItem(3, "ingresso", 5, 1);
		
		try {
			dao.inserirItem(1, "vodkar", 10, 2);
			fail("Não deveria ter cadastrado!");
		} catch (ItemJaCadastrado e) {
			// Correto! Impediu cadastro novamente!
		}
		
		cardapio outra1 = dao.recuperarItem(1);
		assertEquals(outra1.getN(), p1.getN());
		cardapio outra2 = dao.recuperarItem(2);
		assertEquals(outra2.getN(), p2.getN());
		cardapio outra3 = dao.recuperarItem(3);
		assertEquals(outra3.getN(), p3.getN());

		try {
			cardapio outraX = dao.recuperarItem(33);
			fail("Recuperou uma pessoa que nao foi cadastrada");
		} catch (ItemInexistente e) {
			
		}
		
		ArrayList<cardapio> array = dao.recuperarTodos();
		assertEquals(3, array.size());
	}
}
