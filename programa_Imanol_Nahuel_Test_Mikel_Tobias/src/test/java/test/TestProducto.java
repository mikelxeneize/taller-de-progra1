package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.tallerDeProgra.capaDeDatos.Mozo;
import com.tallerDeProgra.capaDeDatos.Producto;

class TestProducto {

	@Test
	void testProducto() {
		Producto producto=new Producto("Papas Fritas",1,6,200);
		Assert.assertEquals("Error nombre producto","Papas Fritas",producto.getNombre());
		Assert.assertEquals("Error en precio costo",1,producto.getPrecioCosto());
		Assert.assertEquals("error en precio venta",6,producto.getPrecioVenta());
		Assert.assertEquals("error en Stock",200,producto.getStock());
	}
	
	@Test
	void testSetId() {
		Producto producto=new Producto("Papas Fritas",1,6,200);
		producto.setId(1);
		Assert.assertEquals("Error en el id",1,producto.getId());
	}
	
	@Test
	void testSetNombre() {
		Producto producto=new Producto("Papas Fritas",1,6,200);
		producto.setNombre("Pochoclo");
		Assert.assertEquals("Error en el nombre","Pochoclo",producto.getNombre());
	}
	
	@Test
	void testSetPrecioCosto() {
		Producto producto=new Producto("Papas Fritas",1,6,200);
		producto.setPrecioCosto(4);
		Assert.assertEquals("Error en el precio costo",4,producto.getPrecioCosto());
	}
	
	@Test
	void testSetPrecioVenta() {
		Producto producto=new Producto("Papas Fritas",1,6,200);
		producto.setPrecioVenta(8);
		Assert.assertEquals("Error en el precio venta",8,producto.getPrecioVenta());
	}
	
	@Test
	void testSetStock() {
		Producto producto=new Producto("Papas Fritas",1,6,200);
		producto.setStock(400);
		Assert.assertEquals("Error en el Stock",400,producto.getStock());
	}
}
