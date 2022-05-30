package died.guia05.integrador.ubicacion;

public abstract class Ubicacion {
	protected Integer id;
	protected String nombre;

	public abstract boolean equalsTo(Ubicacion otro);

	public String getNombre() {
		return this.nombre;
	}

}
