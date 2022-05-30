package died.guia05.integrador.ubicacion;

public class Localidad extends Ubicacion{
	private static Integer idTotal=0;
	private Provincia provincia;
	
	public Localidad() {
		// TODO Auto-generated constructor stub
		idTotal++;
	}
	
	public Localidad(String nombre, Provincia provincia) {
		this();
		this.nombre=nombre;
		this.provincia=provincia;
	}


	public Provincia getProvincia() {
		return provincia;
	}


	@Override
	public boolean equalsTo(Ubicacion otro) {
		if (this == otro)
			return true;
		if (otro == null)
			return false;
		if (getClass() != otro.getClass())
			return false;
		Localidad otro2 = (Localidad) otro;
		if (nombre == null) {
			if (otro2.nombre != null)
				return false;
		} else if (!nombre.equals(otro2.nombre))
			return false;
		return true;
	}


	

}
