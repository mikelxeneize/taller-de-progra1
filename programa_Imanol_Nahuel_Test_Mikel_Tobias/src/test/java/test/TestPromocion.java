package test;


import java.util.ArrayList;
import org.junit.Assert;

import org.junit.jupiter.api.Test;

import com.tallerDeProgra.capaDeDatos.Promocion;
import com.tallerDeProgra.capaDeDatos.Producto;



public class TestPromocion {
	
	@Test
	public void testPromocion() {
		
		Producto producto = new Producto("nombre", 0, 0, 0);
		ArrayList<String> diasPromocion = new ArrayList<String>();
		boolean aplicaDosXUno = true;
		boolean aplicaDescXCantMin = true;
		int descXCantMin = 0;
		float descXCantXPrecioUnitario = 0;
		boolean activa = true;

		Promocion promocion = new Promocion(producto, diasPromocion, aplicaDosXUno, 
aplicaDescXCantMin, descXCantMin, descXCantXPrecioUnitario, activa);
		
		Assert.assertEquals("Error en producto", producto, promocion.getProducto());
		Assert.assertEquals("Error en diasPromocion", diasPromocion, promocion.getDiasPromocion());
		Assert.assertEquals("Error en aplicaDosXUno", aplicaDosXUno, promocion.isAplicaDosXUno());
		Assert.assertEquals("Error en aplicaDescXCantMin", aplicaDescXCantMin, promocion.isAplicaDescXCantMin());
		Assert.assertEquals("Error en descXCantMin", descXCantMin, promocion.getDescXCantMin());
		Assert.assertEquals("Error en descXCantXPrecioUnitario", descXCantXPrecioUnitario, promocion.getDescXCantXPrecioUnitario());
		Assert.assertEquals("Error en activa", activa, promocion.isActiva());
	}
	
	
	@Test
	public void testSetProducto() {
		Producto producto = new Producto("nombre", 0, 0, 0);
		Promocion promocion = new Promocion();
		promocion.setProducto(producto);
		Assert.assertEquals("Error en Producto", producto, promocion.getProducto());
	}
	
	@Test
	public void testSetDiasPromocion() {
		ArrayList<String> diasPromocion = new ArrayList<String>();
		diasPromocion.add("Lunes");
		Promocion promocion = new Promocion();
		promocion.setDiasPromocion(diasPromocion);
		Assert.assertEquals("Error en diasPromocion", diasPromocion, promocion.getDiasPromocion());
	}
	
	@Test
	public void testSetAplicaDosXUno() {
		Promocion promocion = new Promocion();
		promocion.setAplicaDosXUno(true);
		Assert.assertEquals("Error en aplicaDosXUno", true, promocion.isAplicaDosXUno());
	}
	
	@Test
	public void testSetAplicaDescXCantMin() {
		Promocion promocion = new Promocion();
		promocion.setAplicaDescXCantMin(true);
		Assert.assertEquals("Error en aplicaDescXCantMin", true, promocion.isAplicaDescXCantMin());
	}
	
	@Test
	public void TestSetDescXCantMin() {
		Promocion promocion = new Promocion();
		promocion.setDescXCantMin(5);
		Assert.assertEquals("Error en descXCantMin", 5, promocion.getDescXCantMin());
	}
	
	@Test
	public void TestSetDescXCantXPrecioUnitario() {
		Promocion promocion = new Promocion();
		promocion.setDescXCantXPrecioUnitario(5);
		Assert.assertEquals("Error en descXCantXPrecioUnitario", 5, promocion.getDescXCantXPrecioUnitario());
	}
	
	@Test
	public void testSetActiva() {
		Promocion promocion = new Promocion();
		promocion.setActiva(true);
		Assert.assertEquals("Error en activa", true, promocion.isActiva());
	}
	
}
