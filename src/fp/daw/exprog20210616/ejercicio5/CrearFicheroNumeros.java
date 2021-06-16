package fp.daw.exprog20210616.ejercicio5;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class CrearFicheroNumeros {

	public static void main(String[] args) throws IOException {
		Random r = new Random();
		
		try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("/home/julio/git/github/fpdistancia/exprog20210616/res/numeros")))) {
			r.ints(900, 50, 590).forEach(n -> {
				try {
					out.writeInt(n);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		}
	}
}
