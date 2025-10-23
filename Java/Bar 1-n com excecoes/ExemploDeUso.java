package Bar;

import java.sql.*;

public class ExemploDeUso {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Barr", "root", "thrall");
		Statement st = con.createStatement();
		String comando = "";
		for (int i = 1000; i < 10000; i++) {
			comando = "insert into cardapio values ("+ i + ", "+i+" , "+(i+1)+","+(i+100)+")";
			//System.out.println(comando);
			//insert into cliente values (9999, '1000-1000', 'Cliente9999')
			st.execute(comando);
		}
		comando = "select * from cardapio";
		ResultSet rs = st.executeQuery(comando);
		while (rs.next()) {
			int num = rs.getInt("num");
			int tp  = rs.getInt("tipo");
			double prec = rs.getDouble("preco");
			String nm = rs.getString("nome");
			
			System.out.println("Numero: " + num + ". Tipo: " + tp + ". Nome: " + nm + "Preço: "+ prec + ".");
		}
		st.close();
		con.close();
	}
}