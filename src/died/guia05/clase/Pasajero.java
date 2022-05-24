package died.guia05.clase;

import java.util.Objects;

public class Pasajero {
	private String nombre;
	private String apellido;
	private String email;
	private Integer nroPasaporte;
	
	public Pasajero(String nombre, String apellido, String email, Integer nroPasaporte) {
		// TODO Auto-generated constructor stub
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.nroPasaporte = nroPasaporte;
	}

	@Override
	public String toString() {
		return "Pasajero [nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", nroPasaporte="
				+ nroPasaporte + "]";
	}

/*
 * 2. método equals
 */
	
	@Override
	public int hashCode() {
		return Objects.hash(email, nroPasaporte);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pasajero other = (Pasajero) obj;
		return Objects.equals(email, other.email) && Objects.equals(nroPasaporte, other.nroPasaporte);
	}

}
