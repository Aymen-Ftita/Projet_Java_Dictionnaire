import java.sql.*;
public class Manager {
	private Connection conn;
	private Statement stat;
	
	public Manager(Connection Conn) {
		this.conn= Conn;
	}
	
	public ResultSet Recherche_e(String mot) throws SQLException {
		
		stat=conn.createStatement();
		return stat.executeQuery("select `Traduction` from `e` where `Mot`= '"+mot+"'");
	}
	

	public ResultSet Recherche_f(String mot) throws SQLException {
		
		stat=conn.createStatement();
		return stat.executeQuery("select `Traduction` from `f` where `Mot` = '"+mot+"'");
	}
	
	
	public void Delete_e(String mot) throws SQLException {
		
		stat=conn.createStatement();
		stat.executeUpdate("delete from  `e` where `mot` = '"+mot+"' ");
	}
	

	public void Delete_f(String mot) throws SQLException {
		
		stat=conn.createStatement();
		stat.executeUpdate("delete from  `f` where `mot` = '"+mot+"' ");
	}
	
	public void Modifier_e(String mot , String Traduction) throws SQLException {
		
		stat=conn.createStatement();
		stat.executeUpdate("UPDATE `e` SET `Traduction`='"+Traduction+"' WHERE `mot` = '"+mot+"' ");		
	}
	

	public void Modifier_f(String mot , String Traduction) throws SQLException {
		
		stat=conn.createStatement();
		stat.executeUpdate("UPDATE `f` SET `Traduction`='"+Traduction+"' WHERE `mot` = '"+mot+"' ");		
	}
	
	
	public void Inserer_e(String mot , String Traduction) throws SQLException {
		
		stat=conn.createStatement();
		stat.executeUpdate("INSERT INTO `e`(`Mot`, `Traduction`) VALUES ('"+mot+"','"+Traduction+"')");
	}
	
	public void Inserer_f(String mot , String Traduction) throws SQLException {
		
		stat=conn.createStatement();
		stat.executeUpdate("INSERT INTO `f`(`Mot`, `Traduction`) VALUES ('"+mot+"','"+Traduction+"')");
	}
	

}
