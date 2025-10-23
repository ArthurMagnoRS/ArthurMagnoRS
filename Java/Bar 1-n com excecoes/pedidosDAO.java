package Bar;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;

public class pedidosDAO {
	
	public void inserirPedido(pedidos P) {
		try {
		   Connection con = Conexao.conectar();
		   Statement stmt = con.createStatement();
		   String comando = "insert into pedidos (numero, quantidade, NumeroDaConta) "
		   		+ "values (" + P.getN() + ", " + P.getQuant()+ "\')";
		   
		  int Num = recuperarConta(P.getN());
		  
		  comando = comando + Num + "\')";
		   
		   System.out.println(comando);
		   stmt.execute(comando);
		   stmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public int recuperarConta(int num) {
		int numero = 0;
		try {
		   Connection con = Conexao.conectar();
		   Statement stmt = con.createStatement();
		   String comando = "select * from conta where pedidos = " + num;
		   System.out.println(comando);
		   ResultSet rs = stmt.executeQuery(comando);
		   if(rs.next()) {
			   int NumConta = rs.getInt("numero");
			   numero = NumConta;
		   }
		   
		   stmt.close();
		   return numero;
		   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
 
	}
}
	
	//acessar a arraylist de pedidos de uma conta, ver se o número de algum pedido bate e colocar a conta aqui.
// criar um pedido e adicionar a arraylist da conta correspondente a este pedido?