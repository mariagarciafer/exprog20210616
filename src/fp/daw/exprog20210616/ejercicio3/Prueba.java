package fp.daw.exprog20210616.ejercicio3;

import java.io.IOException;

public class Prueba {

	public static void main(String[] args) throws IOException {
		ParqueMovil pm = new ParqueMovil("/home/julio/git/github/fpdistancia/exprog20210616/res", 2018);
		System.out.println(pm.getTotalProvinciaTipo("Albacete", "CAMIONES"));
		System.out.println(pm.getTotalProvincia("Albacete"));
		System.out.println(pm.getTotalTipo("CAMIONES"));
		System.out.println(pm.getTotal());
		pm.guardar("/home/julio/git/github/fpdistancia/exprog20210616/res/pm" + pm.getAño() + ".dat");
	}

}
