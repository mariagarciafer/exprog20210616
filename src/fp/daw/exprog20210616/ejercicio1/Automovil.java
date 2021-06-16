package fp.daw.exprog20210616.ejercicio1;

import java.util.Objects;

public class Automovil implements Comparable<Automovil> {
	
	private String marca;
	private String modelo;
	private String matricula;
	private Integer año;
	private Tipo tipo;
	private Integer potencia;
	
	public Automovil(String marca, String modelo, String matricula, int año, Tipo tipo, int potencia) {
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		this.año = año;
		this.tipo = tipo;
		this.potencia = potencia;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	public Integer getAño() {
		return año;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public Integer getPotencia() {
		return potencia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(año, marca, matricula, modelo, potencia, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Automovil other = (Automovil) obj;
		return año == other.año && Objects.equals(marca, other.marca) && Objects.equals(matricula, other.matricula)
				&& Objects.equals(modelo, other.modelo) && potencia == other.potencia && tipo == other.tipo;
	}

	@Override
	public String toString() {
		return "Automovil [marca=" + marca + ", modelo=" + modelo + ", matricula=" + matricula + ", año=" + año
				+ ", tipo=" + tipo + ", potencia=" + potencia + "]";
	}

	@Override
	public int compareTo(Automovil a) {
		int compare = marca.compareTo(a.marca);
		if (compare == 0) {
			compare = modelo.compareTo(a.modelo);
			if (compare == 0)
				compare = tipo.compareTo(a.tipo);
		}
		return compare;
	}
	
	
	
}
