package test;


import java.util.ArrayList;
import org.junit.Assert;

import org.junit.jupiter.api.Test;

import com.tallerDeProgra.capaDeDatos.PromocionTemporal;



public class TestPromocionTemporal {
	
	@Test
	public void testPromocionTemporal() {
		
		int id = 0;
		String nombre = "nombre";
		String formaDePago = "forma";
		int porcentajeDescuento = 20;
		ArrayList<String> diasPromocion = new ArrayList<String>();
		boolean activo = true;
		boolean acumulable = true;
		
		PromocionTemporal promocionTemporal = new PromocionTemporal(id, nombre, formaDePago, porcentajeDescuento, diasPromocion, activo, acumulable);
		
		Assert.assertEquals("Error en id", id, promocionTemporal.getId());
		Assert.assertEquals("Error en nombre", nombre, promocionTemporal.getNombre());
		Assert.assertEquals("Error en formaDePago", formaDePago, promocionTemporal.getFormaDePago());
		Assert.assertEquals("Error en porcentajeDescuento", porcentajeDescuento, promocionTemporal.getPorcentajeDescuento());
		Assert.assertEquals("Error en diasPromocion", diasPromocion, promocionTemporal.getDiasPromocion());
		Assert.assertEquals("Error en activo", activo, promocionTemporal.isActivo());
		Assert.assertEquals("Error en acumulable", acumulable, promocionTemporal.isAcumulable());
	
	}
	
	@Test
	public void testSetId() {
		int id = 0;
		String nombre = "nombre";
		String formaDePago = "forma";
		int porcentajeDescuento = 20;
		ArrayList<String> diasPromocion = new ArrayList<String>();
		boolean activo = true;
		boolean acumulable = true;
		
		PromocionTemporal promocionTemporal = new PromocionTemporal();
		promocionTemporal.setId(id);
		
		Assert.assertEquals("Error en id", id, promocionTemporal.getId());
	
	}
	
	@Test
	public void testSetNombre() {

		String nombre = "nombre";
				
		PromocionTemporal promocionTemporal = new PromocionTemporal();
		promocionTemporal.setNombre(nombre);
		
		Assert.assertEquals("Error en nombre", nombre, promocionTemporal.getNombre());
		
	}
	
	@Test
	public void testSetFormaDePago() {
		
		String formaDePago = "forma";
		
		PromocionTemporal promocionTemporal = new PromocionTemporal();
		promocionTemporal.setFormaDePago(formaDePago);
		
		Assert.assertEquals("Error en formaDePago", formaDePago, promocionTemporal.getFormaDePago());
		
	}
	
	@Test
	public void testPorcentajeDescuente() {
		
		int porcentajeDescuento = 20;
		
		PromocionTemporal promocionTemporal = new PromocionTemporal();
		promocionTemporal.setPorcentajeDescuento(porcentajeDescuento);
		
		Assert.assertEquals("Error en porcentajeDescuento", porcentajeDescuento, promocionTemporal.getPorcentajeDescuento());
		
	}
	
	@Test
	public void testSetDiasPromocion() {
		ArrayList<String> diasPromocion = new ArrayList<String>();
		diasPromocion.add("promo 1");
		
		PromocionTemporal promocionTemporal = new PromocionTemporal();
		promocionTemporal.setDiasPromocion(diasPromocion);
		
		Assert.assertEquals("Error en diasPromocion", diasPromocion, promocionTemporal.getDiasPromocion());
		
	}
	
	@Test
	public void testSetActivo() {
		boolean activo = true;
		
		PromocionTemporal promocionTemporal = new PromocionTemporal();
		promocionTemporal.setActivo(activo);
		
		Assert.assertEquals("Error en activo", activo, promocionTemporal.isActivo());
		
	}
	
	@Test
	public void testSetAcumulable() {
		
		boolean acumulable = true;
		
		PromocionTemporal promocionTemporal = new PromocionTemporal();
		promocionTemporal.setAcumulable(acumulable);
		
		Assert.assertEquals("Error en acumulable", acumulable, promocionTemporal.isAcumulable());
	
	}
	

	
}
