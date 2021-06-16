package fp.daw.exprog20210616.ejercicio1;

import java.util.Comparator;

public class AutomovilComparator implements Comparator<Automovil> {

	@Override
	public int compare(Automovil o1, Automovil o2) {
		int compare = o1.getTipo().compareTo(o2.getTipo());
		if (compare == 0)
			compare = o1.getPotencia().compareTo(o2.getPotencia());
		return compare;
	}

}
