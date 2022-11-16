package test;


import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;

import org.junit.jupiter.api.Test;

import com.tallerDeProgra.capaDeDatos.Comanda;
import com.tallerDeProgra.capaDeDatos.Mesa;
import com.tallerDeProgra.capaDeDatos.Operario;
import com.tallerDeProgra.capaDeDatos.Pedido;
import com.tallerDeProgra.capaDeDatos.Producto;
import com.tallerDeProgra.enums.EstadoComanda;



public class TestOperario {
	
	@Test
	public void testOperario() {
		
		Operario operario = new Operario("user","pasSword1",true);
		
		Assert.assertEquals("Error en nombreDeUsuario", "user", operario.getNombreDeUsuario());
		Assert.assertEquals("Error en password", "pasSword1", operario.getPassword());
		Assert.assertEquals("Error en activo", true, operario.isActivo());
		
	}
	
	@Test
	public void testSetActivo() {
		Operario operario = new Operario("user","pasSword1",true);
		operario.setActivo(false);
		Assert.assertEquals("Error en activo", false, operario.isActivo());
	}
	
	@Test
	public void testSetPassword() {
		Operario operario = new Operario("user","pasSword1",true);
		operario.setPassword("passWord1");
		Assert.assertEquals("Error en password", "passWord1", operario.getPassword());
	}
	
	@Test
	public void testSetNombreDeUsuario() {
		Operario operario = new Operario("user","pasSword1",true);
		operario.setNombreDeUsuario("pepe");
		Assert.assertEquals("Error en NombreDeUsuario", "pepe", operario.getNombreDeUsuario());
	}
	
		
	
}
