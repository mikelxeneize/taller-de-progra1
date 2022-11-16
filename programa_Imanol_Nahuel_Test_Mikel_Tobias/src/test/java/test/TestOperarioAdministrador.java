package test;


import org.junit.Assert;

import org.junit.jupiter.api.Test;

import com.tallerDeProgra.capaDeDatos.OperarioAdministrador;


public class TestOperarioAdministrador {
	
	@Test
	public void testOperarioAdministrador() {
		
		OperarioAdministrador operario = new OperarioAdministrador("user","pasSword1",true);
		
		Assert.assertEquals("Error en nombreDeUsuario", "user", operario.getNombreDeUsuario());
		Assert.assertEquals("Error en password", "pasSword1", operario.getPassword());
		Assert.assertEquals("Error en activo", true, operario.isActivo());
	}	
	
	//No se testean getters y setters ya que son validados y verificados en su clase padre Operario
	
}
