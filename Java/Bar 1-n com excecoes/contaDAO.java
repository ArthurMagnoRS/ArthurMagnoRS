package Bar;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;

public class contaDAO {
	
	public void inserir(conta c) {
		int P = 0;
		try {
		   Connection con = Conexao.conectar();
		   Statement stmt = con.createStatement();
		   String comando = "insert into conta (numero, cpf, nome, pagamento, pedidos) "
		   		+ "values (" + c.getNum() + ", " + c.getCpf() + "," + c.getNome() + ", \'" + c.getPagamento() + "\', ";
		   
		   for(pedidos i: c.Cpedidos) {
			   P = i.n;
			   comando = comando + P + ",";
		   }
		   comando = comando + "\')";
		   System.out.println(comando);
		   stmt.execute(comando);
		   stmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public conta pesquisar(int num) {
		try {
		   Connection con = Conexao.conectar();
		   Statement stmt = con.createStatement();
		   String comando = "select * from conta where numero = " + num;
		   System.out.println(comando);
		   ResultSet rs = stmt.executeQuery(comando);
		   conta c = null;
		   if (rs.next()) {
			   int numConta= rs.getInt("numero");
			   int numCpf = rs.getInt("cpf");
			   String nomeConta = rs.getString("nome");
			   c = new conta(numConta, numCpf, nomeConta);
			   
		   }
		   stmt.close();
		   return c;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
    }
}


