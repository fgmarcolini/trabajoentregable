package died.guia05.integrador;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import died.guia05.integrador.bien.Bien;
import died.guia05.integrador.bien.Factura;
import died.guia05.integrador.persona.Proveedor;
import died.guia05.integrador.persona.Responsable;
import died.guia05.integrador.ubicacion.Localidad;

public class Empresa {
	public ArrayList<Responsable> responsables;
	public ArrayList<Proveedor> proveedores;
	public ArrayList<Bien> bienes;
	public ArrayList<Factura> facturas;
	
	public Empresa() {
	};
	
	

//	Se debe poder listar todas las
//	facturas de un proveedor especificado. 
	
	public ArrayList<Responsable> getResponsables() {
		return responsables;
	}



	public ArrayList<Proveedor> getProveedores() {
		return proveedores;
	}



	public ArrayList<Bien> getBienes() {
		return bienes;
	}



	public ArrayList<Factura> getFacturas() {
		return facturas;
	}



	public void setResponsables(ArrayList<Responsable> responsables) {
		this.responsables = responsables;
	}



	public void setProveedores(ArrayList<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}



	public void setBienes(ArrayList<Bien> bienes) {
		this.bienes = bienes;
	}



	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}



	public ArrayList<Factura> listarFacturaByProveedor(Proveedor p){
	
		return new ArrayList<Factura>(
				this.facturas
				.stream()
				.filter(x -> x.getProveedor().equals(p))
				.collect(Collectors.toList())
				);
	
	}
	
	

//	Se debe poder listar todas las
//	facturas de un responsable especificado.
	
	public ArrayList<Factura> listarFacturaByResponsable(Responsable r){
		
		return new ArrayList<Factura>(
					this.facturas
					.stream()
					.filter(x -> x.getResponsable().equals(r))
					.collect(Collectors.toList())
				);
	}
	
	
//	Se debe poder listar todos los nombres de los
//	proveedores por una determinada Localidad, ordenado de forma ascendente por nombre.
//	Utilizar el stream filter, sorted, map y collect. Filter con el m�todo esDeLocalidad(�), sorted
//	ordenado ascendente por nombre, map tomando el nombre de cada uno de los proveedores.
	
	public ArrayList<String> listarNombresProveedores(Localidad l){
		return new ArrayList<String>(
					this.proveedores
					.stream()
					.filter(x -> x.esDeLocalidad(l))
					.sorted()
					.map(x -> x.getNombre())
					.collect(Collectors.toList())
				);
	}
	
//	Se debe poder listar todos los bienes
//	solicitados por los responsables que reside en una Localidad especificada.
	public ArrayList<Bien> listarBienesByLocalidad(Localidad l){
		
		return new ArrayList<Bien>(
				this.bienes
				.stream()
				.filter(x -> x.getResponsable().esDeLocalidad(l))
				.collect(Collectors.toList())
			);
	}
	
	
	
//	Se debe poder listar todos
//	los bienes con un precio mayor a un valor pasado por par�metros.
	public ArrayList<Bien> listarBienesByPrecioMayor(Double precioMayor){

		return new ArrayList<Bien>(
					this.bienes
					.stream()
					.filter(x -> x.getPrecio() > precioMayor)
					.collect(Collectors.toList())
				);		
	}
	
	
//	Se debe poder listar
//	todas las facturas con un monto total mayor a un valor pasado por par�metros.
	public ArrayList<Factura> listarFacturasByMontoMayor(Double montoMayor){
		
		return new ArrayList<Factura>(
				this.facturas
				.stream()
				.filter(x -> x.getMontoTotal() > montoMayor)
				.collect(Collectors.toList())
			);		
	}

	
//	Se debe poder listar cadenas de
//	String que debe componer de la siguiente manera: �En la fecha <Fecha>, <NombreProveedor>
//	factur� con un total de $<montoTotal> con <bienes.size()>�. Es decir, se debe poder listar
//	todas las facturas realizadas por un proveedor p, ordenado por fecha de forma Descendente
//	(de nuevo a antiguo) en formato DIA/MES/A�O, implementar la clase Comparable y
//	ordenarlas con Collection.sort.
	
	public ArrayList<String> listarFactuadasPorProveedor(Proveedor p){
		

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		ArrayList<String> list = new ArrayList<String>();
		
		// todas las facturas realizadas por un proveedor p.
		ArrayList<Factura> listFacturas = new ArrayList<Factura>(
					this.facturas
					.stream()
					.filter(x -> x.getProveedor().equals(p))
					.collect(Collectors.toList())
				);
		
		// Ordenadas por fecha de manera descendente
		Collections.sort(listFacturas);
		
		for(Factura f : listFacturas) {
			list.add("En la fecha " + sdf.format(f.getFecha()) 
					+ ", " + p.getNombre() + " factur� con un total de $" 
					+ f.getMontoTotal() + " con " + f.getBienes().size() + " bienes");
		}
		
		return list;
	}

}
