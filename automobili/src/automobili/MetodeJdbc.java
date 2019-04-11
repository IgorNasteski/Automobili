package automobili;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MetodeJdbc {
	
	//metoda za konekciju
	private Connection konektujSe(String nazivBaze) throws SQLException {
		
		final String URL = "jdbc:mysql://localhost:3306/" + nazivBaze + "?useSSL=false";
		final String USER = "root";
		final String PASSWORD = "root";
		System.out.println("Uspesna konekcija.");
		
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	public void insertUTabelu(String nazivBaze, String nazivTabele, String ime, String zemlja) {
		
		Connection konekcija = null;
		PreparedStatement pst = null;
		
		try {
			konekcija = konektujSe(nazivBaze);
			String query = "INSERT INTO " + nazivTabele + " VALUES(null,?,?)";
			pst = konekcija.prepareStatement(query);
			pst.setString(1, ime);
			pst.setString(2, zemlja);
			pst.executeUpdate();
			System.out.println("Uspesno ste uneli korisnika u tabelu!");	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(konekcija != null) {
				try {
					konekcija.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
