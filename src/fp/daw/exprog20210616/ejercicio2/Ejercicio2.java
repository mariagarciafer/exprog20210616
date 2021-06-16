package fp.daw.exprog20210616.ejercicio2;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Ejercicio2 {

	public static Map<String, Integer> cuentaPares(List<String> palabras) {
		Map<String, Integer> m = new TreeMap<>();
		for (String palabra: palabras) {
			for (int i=0; i<palabra.length()-1; i++) {
				String par = palabra.substring(i, i + 2);
				m.put(par, m.containsKey(par) ? m.get(par) + 1 : 1);
			}
		}
		return m;
	}
	
	
	public static int contarComunes(List<Integer> l1, List<Integer> l2) {
		Set<Integer> aux = new HashSet<>(l1);
		aux.retainAll(l2);
		return aux.size();
	}
	
	public static void main(String[] args) {
		List<String> palabras = List.of("banana", "pera", "melón", "o", "sandía");
		System.out.println(cuentaPares(palabras));
		List<Integer> n1 = List.of(3, 5, 9, 3, 31, 11, 55, 19); 
		List<Integer> n2 = List.of(19, 75, 15, 55, 7, 17, 55, 99, 37);
		System.out.println(contarComunes(n1, n2));
	}
}
