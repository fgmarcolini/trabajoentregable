package died.guia05.integrador.persona;

import java.util.ArrayList;

import died.guia05.integrador.bien.Bien;
import died.guia05.integrador.ubicacion.Localidad;

public class Proveedor extends Persona implements Comparable<Persona> {
	private static Integer idTotal=0;
	private ArrayList<Bien> bienes;
	
	public Proveedor() {
		this.id = Proveedor.idTotal++;
		this.bienes = new ArrayList<Bien>();
	}
	
	// Se puede instanciar un Proveedor que aun no este a cargo de bienes.
	public Proveedor(String nombre, Localidad localidad) {
		this();
		this.nombre=nombre;
		this.localidad=localidad;
	}

	public Proveedor(String nombre, Localidad localidad, ArrayList<Bien> bienes) {
		this();
		this.nombre=nombre;
		this.localidad=localidad;
		this.bienes=bienes;
	}

	@Override
	public int compareTo(Persona o) {
		Proveedor otra = (Proveedor) o;
	
		return this.nombre.compareTo(otra.getNombre());
	}

	public void asignarBienes(ArrayList<Bien> bienes) {
		// TODO Auto-generated method stub
		this.bienes = bienes;
		
	}

	public void asignarBien(Bien bien) {
		// TODO Auto-generated method stub
		this.bienes.add(bien);
	}
	

}
