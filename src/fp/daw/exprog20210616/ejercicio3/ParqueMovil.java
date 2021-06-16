package fp.daw.exprog20210616.ejercicio3;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ParqueMovil {
	
	private int año;
	private int total;
	
	private Map<String, Map<String, Integer>> m = new TreeMap<>();
	
	public ParqueMovil(String ruta, int año) throws IOException {
		this.año = año;
		total = 0;
		try (BufferedReader in = new BufferedReader(new FileReader(ruta + "/pm" + año + ".csv"))) {
			String linea = in.readLine();
			String [] tipos = linea.split(";");
			while ((linea = in.readLine()) != null) {
				String [] datos = linea.split(";");
				Map<String, Integer> p = new HashMap<>();
				for (int i=1; i<datos.length; i++) {
					int n = Integer.valueOf(datos[i]);
					p.put(tipos[i], n);
					total += n;
				}
				m.put(datos[0], p);
			}
		}
	}

	public int getAño() {
		return año;
	}
	
	public int getTotal() {
		return total;
	}
	
	public int getTotalProvinciaTipo(String provincia, String tipo) {
		return m.get(provincia).get(tipo);
	}
	
	public int getTotalProvincia(String provincia) {
		Map<String, Integer> p = m.get(provincia);
		int total = 0;
		for (int n: p.values())
			total += n;
		return total;
	}
	
	public int getTotalTipo(String tipo) {
		int total = 0;
		for (String provincia: m.keySet())
			total += m.get(provincia).get(tipo);
		return total;
	}
	
	public void guardar(String ruta) throws FileNotFoundException, IOException {
		try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(ruta)))) {
			for (Entry<String, Map<String, Integer>> e1: m.entrySet()) {
				out.writeUTF(e1.getKey());
				for (Entry<String, Integer> e2: e1.getValue().entrySet()) {
					out.writeUTF(e2.getKey());
					out.writeInt(e2.getValue());
				}
			}
		}
		
	}
	
}
