package automobili;

import java.sql.SQLException;

public class GlavnaKlasa {

	public static void main(String[] args) {

		MetodeJdbc metode = new MetodeJdbc();
		metode.insertUTabelu("automobili", "marke", "peugeot", "Francuska");

	}

}
