package Bar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class cardapioDAO {

	public void inserirItem(int num, String nm, double preco, int tipo) throws ClassNotFoundException, SQLException, ItemJaCadastrado {
		Connection con = Conexao.conectar();
		String cmd  = "insert into cardapio values ("+"\'"+ nm + "\' , "+ num +" , "+ tipo +" , "+ preco +")";
		Statement st = con.createStatement();
		try {
			cardapio outra = recuperarItem(num);
			throw new ItemJaCadastrado(num);
		} catch (ItemInexistente e) {
			st.execute(cmd);
		}
		st.close();
	}
	
	
	public cardapio recuperarItem(int num) throws ClassNotFoundException, SQLException, ItemInexistente {
		Connection con = Conexao.conectar();
		String cmd = "select * from cardapio where num = " + num;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(cmd);
		cardapio i = null;
		if (rs.next()) {
			i = itemTipo(rs,num);
		} else {
			throw new ItemInexistente(num);
		}
		st.close();
		return i;
	}
	public ArrayList<cardapio> recuperarTodos() throws SQLException, ClassNotFoundException {
		Connection con = Conexao.conectar();
		String cmd = "select * from cardapio";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(cmd);
		cardapio i = null;
		ArrayList<cardapio> todos =  new ArrayList<cardapio>();
		while (rs.next()) {
			if (itemTipo(rs)!= null) {
			i = itemTipo(rs);
			todos.add(i);
			}
		}
		st.close();
		return todos;
	}
	
	public cardapio itemTipo(ResultSet rs) throws SQLException {
		int num = rs.getInt("num");
		String nome = rs.getString("nome");
		double preco = rs.getDouble("preco");
		int tipo = rs.getInt("tipo");
		cardapio i = null;
		if (tipo == 1)
			i = new ingresso(num, nome, tipo, preco);
		if (tipo == 2)
			i = new bebida(num, nome, tipo, preco);
		if (tipo == 3)
			i = new comida(num, nome,tipo, preco);
		
		return i;
	}
	
	public cardapio itemTipo(ResultSet rs,int num) throws SQLException {
		String nome = rs.getString("nome");
		double preco = rs.getDouble("preco");
		int tipo = rs.getInt("tipo");
		cardapio i = null;
		if (tipo == 1)
			i = new ingresso(num, nome,tipo, preco);
		if (tipo == 2)
			i = new bebida(num, nome,tipo, preco);
		if (tipo == 3)
			i = new comida(num, nome,tipo, preco);
		
		return i;
	}
	
	public void apagar(int num) throws SQLException, ClassNotFoundException {
		Connection con = Conexao.conectar();
		String cmd = "delete from cardapio where num = " + num;
		Statement st = con.createStatement();
		st.execute(cmd);
		st.close();
	}
	
	public void apagarTodos() throws SQLException, ClassNotFoundException {
		Connection con = Conexao.conectar();
		String cmd = "delete from cardapio where num > 0 ";
		Statement st = con.createStatement();
		st.execute(cmd);
		st.close();
	}

}
