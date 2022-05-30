package died.guia05.integrador.ubicacion;

public class Provincia extends Ubicacion{
	private static Integer idTotal=0;
	private Pais pais;
	
	public Provincia() {
		// TODO Auto-generated constructor stub
		idTotal++;
	}
	
	public Provincia(String nombre, Pais pais) {
		this();
		this.nombre=nombre;
		this.pais=pais;
	}
	
	public Pais getPais() {
		return pais;
	}

	@Override
	public boolean equalsTo(Ubicacion otro) {
		if (this == otro)
			return true;
		if (otro == null)
			return false;
		if (getClass() != otro.getClass())
			return false;
		Provincia otro2 = (Provincia) otro;
		if (nombre == null) {
			if (otro2.nombre != null)
				return false;
		} else if (!nombre.equals(otro2.nombre))
			return false;
		return true;
	}
	
}
