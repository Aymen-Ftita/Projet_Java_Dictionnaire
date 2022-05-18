import java.sql.*;
public class Dictionnaire {
	String mot;
	String Text;
	
	public Dictionnaire(ResultSet R) throws SQLException {
		while(R.next()) {
			
			this.Text=R.getString("Traduction");
		}
	}
	
	public Dictionnaire(String mot, String text) {
		
		this.mot = mot;
		Text = text;
	}
	public String getMot() {
		return mot;
	}
	public void setMot(String mot) {
		this.mot = mot;
	}
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}

}
