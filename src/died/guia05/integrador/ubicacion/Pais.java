package died.guia05.integrador.ubicacion;

public class Pais extends Ubicacion{
	private static Integer idTotal=0;
	
	public Pais() {
		// TODO Auto-generated constructor stub
		idTotal++;
	}
	
	public Pais(String nombre) {
		this();
		this.nombre=nombre;
	}

	@Override
	public boolean equalsTo(Ubicacion otro) {
		if (this == otro)
			return true;
		if (otro == null)
			return false;
		if (getClass() != otro.getClass())
			return false;
		Pais otro2 = (Pais) otro;
		if (nombre == null) {
			if (otro2.nombre != null)
				return false;
		} else if (!nombre.equals(otro2.nombre))
			return false;
		return true;
	}
	

}
