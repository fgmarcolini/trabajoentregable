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
	
	

//	Se debe poder listar todas las
//	facturas de un proveedor especificado. 
	
	public ArrayList<Factura> listarFacturaByProveedor(Proveedor p){
		
		ArrayList<Factura> list = new ArrayList<Factura>();
		
		for(Factura f : this.facturas) {
			if(f.getProveedor().equals(p)) {
				list.add(f);
			}
		}
		
		return list;
	}
	
	

//	Se debe poder listar todas las
//	facturas de un responsable especificado.
	
	public ArrayList<Factura> listarFacturaByResponsable(Responsable r){
		
		ArrayList<Factura> list = new ArrayList<Factura>();
		
		for(Factura f : this.facturas) {
			if(f.getResponsable().equals(r)) {
				list.add(f);
			}
		}
		
		return list;
	}
	
	
//	Se debe poder listar todos los nombres de los
//	proveedores por una determinada Localidad, ordenado de forma ascendente por nombre.
//	Utilizar el stream filter, sorted, map y collect. Filter con el método esDeLocalidad(…), sorted
//	ordenado ascendente por nombre, map tomando el nombre de cada uno de los proveedores.
	
	public ArrayList<String> listarNombresProveedores(Localidad l){

		
		ArrayList<String> list = 
						(ArrayList<String>) this.proveedores.stream()
						.filter(proveedor -> proveedor.esDeLocalidad(l))
						.sorted()
						.map(proveedor -> proveedor.getNombre())
						.collect(Collectors.toList());
		
		return list;
	}
	
//	Se debe poder listar todos los bienes
//	solicitados por los responsables que reside en una Localidad especificada.
	public ArrayList<Bien> listarBienesByLocalidad(Localidad l){
		
		ArrayList<Bien> list = new ArrayList<Bien>();
		
		for(Bien b : this.bienes) {
			if(b.getResponsable().getLocalidad().equalsTo(l)) {
				list.add(b);
			}
		}
		
		return list;
	}
	
	
	
//	Se debe poder listar todos
//	los bienes con un precio mayor a un valor pasado por parámetros.
	public ArrayList<Bien> listarBienesByPrecioMayor(Double precioMayor){
		
		ArrayList<Bien> list = new ArrayList<Bien>();
		
		for(Bien b : this.bienes) {
			if(b.getPrecio() > precioMayor) {
				list.add(b);
			}
		}
		
		return list;
	}
	
	
//	Se debe poder listar
//	todas las facturas con un monto total mayor a un valor pasado por parámetros.
	public ArrayList<Factura> listarFacturasByMontoMayor(Double montoMayor){
		
		ArrayList<Factura> list = new ArrayList<Factura>();
		
		for(Factura f : this.facturas) {
			if(f.getMontoTotal() > montoMayor) {
				list.add(f);
			}
		}
		
		return list;
	}

	
//	Se debe poder listar cadenas de
//	String que debe componer de la siguiente manera: “En la fecha <Fecha>, <NombreProveedor>
//	facturó con un total de $<montoTotal> con <bienes.size()>”. Es decir, se debe poder listar
//	todas las facturas realizadas por un proveedor p, ordenado por fecha de forma Descendente
//	(de nuevo a antiguo) en formato DIA/MES/AÑO, implementar la clase Comparable y
//	ordenarlas con Collection.sort.
	
	public ArrayList<String> listarFactuadasPorProveedor(Proveedor p){
		
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Factura> listFacturas = new ArrayList<Factura>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		
		// todas las facturas realizadas por un proveedor p.
		for(Factura f : this.facturas) {
			if(f.getProveedor().equals(p)) {
				listFacturas.add(f);
			}
		}
		
		Collections.sort(listFacturas);
		
		for(Factura f : listFacturas) {
			list.add("En la fecha " + sdf.format(f.getFecha()) 
					+ ", " + p.getNombre() + " facturó con un total de $" 
					+ f.getMontoTotal() + " con " + f.getBienes().size());
		}
		
		return list;
	}

}
