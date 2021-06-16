package fp.daw.exprog20210616.ejercicio1;

import java.util.Arrays;

public class Prueba {

	public static void main(String[] args) {
		Automovil [] automoviles = new Automovil[10];
		automoviles[0] = new Automovil("Hyundai", "Kona", "7519LTS", 2021, Tipo.ELECTRICO, 204);
		automoviles[1] = new Automovil("Hyundai", "IONIQ", "5197HTN", 2017, Tipo.HIBRIDO, 141);
		automoviles[2] = new Automovil("Tesla", "Model 3", "3355KXL", 2019, Tipo.ELECTRICO, 306);
		automoviles[3] = new Automovil("Seat", "Leon", "2159DLX", 2005, Tipo.DIESEL, 150);
		automoviles[4] = new Automovil("Seat", "Mii Electric", "5973JST", 2019, Tipo.ELECTRICO, 83);
		automoviles[5] = new Automovil("BMW", "116i", "7731JCL", 2018, Tipo.GASOLINA, 109);
		automoviles[6] = new Automovil("Opel", "Astra", "3113KFC", 2019, Tipo.DIESEL, 105);
		automoviles[7] = new Automovil("Citroen", "C5 Aircross", "9199KZT", 2020, Tipo.HIBRIDO, 224);
		automoviles[8] = new Automovil("Volvo", "V60", "3131KZV", 2020, Tipo.GASOLINA, 197);
		automoviles[9] = new Automovil("Toyota", "C-HR", "1579GLX", 2016, Tipo.HIBRIDO, 122);
		System.out.println(Arrays.toString(automoviles));
		Arrays.sort(automoviles, new AutomovilComparator());
		System.out.println(Arrays.toString(automoviles));
		Arrays.sort(automoviles);
		System.out.println(Arrays.toString(automoviles));
	}

}
