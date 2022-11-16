package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tallerDeProgra.capaDeDatos.Mesa;
import com.tallerDeProgra.capaDeDatos.Mozo;
import com.tallerDeProgra.capaDeDatos.Operario;
import com.tallerDeProgra.capaDeDatos.OperarioAdministrador;
import com.tallerDeProgra.capaDeDatos.Producto;
import com.tallerDeProgra.capaDeNegocios.Sistema;
import com.tallerDeProgra.enums.Estado;
import com.tallerDeProgra.enums.EstadosMesa;

import excepciones.DatosIncorrectosException;

class TestGestionDePersonal {

	@BeforeEach
	public void setUp() {
		
		try {

			Sistema.getInstance().getZonaGestionDePersonal().altaOperarioAdministrador("nombreAdm1", "passwwW23", true);
			Sistema.getInstance().getZonaGestionDePersonal().altaOperarioAdministrador("nombreAdm2", "passwwW23", true);
			
			Sistema.getInstance().getZonaGestionDePersonal().altaOperario("nombre1", "passwwW23", true);
			Sistema.getInstance().getZonaGestionDePersonal().altaOperario("nombre2", "passwwW23", true);
			
			Sistema.getInstance().getZonaGestionDePersonal().altaMozo(2, Estado.AUSENTE.getEstado(), 1000, "Mozo1", 2000, 2, 20);
			Sistema.getInstance().getZonaGestionDePersonal().altaMozo(2, Estado.AUSENTE.getEstado(), 1000, "Mozo2", 2000, 2, 20);
			
				
		} catch (DatosIncorrectosException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestAltaOperario_Exitoso() {
		
		
		String password = "paaaD1213";
		String nombreDeUsuario = "nombre";
		boolean activo = true;
		try {
			Sistema.getInstance().getZonaGestionDePersonal().altaOperario(nombreDeUsuario, password, activo);
		} catch (DatosIncorrectosException e) {
			Assert.fail("No debio Lanzarse excepcion");
		}
		
		ArrayList<Operario> operarios = Sistema.getInstance().getOperarios();
		
		Assert.assertEquals("Error en nombre", nombreDeUsuario, operarios.get(operarios.size()-1).getNombreDeUsuario());
		
	}
	@Test
	public void TestAltaOperario_UsuarioNUll() {
		String password = "paaaD1213";
		String nombreDeUsuario = null;
		boolean activo = true;
		try {
			Sistema.getInstance().getZonaGestionDePersonal().altaOperario(nombreDeUsuario, password, activo);
			Assert.fail("Debio lanzarse la excepcion");
		} catch (DatosIncorrectosException e) {
			
		}

	}
	@Test
	public void TestAltaOperario_PasswordLargo5() {
		String password = "pD121";
		String nombreDeUsuario = "nombre";
		boolean activo = true;
		try {
			Sistema.getInstance().getZonaGestionDePersonal().altaOperario(nombreDeUsuario, password, activo);
			Assert.fail("Debio lanzarse la excepcion");
		} catch (DatosIncorrectosException e) {
			
		}
		
	}
	@Test
	public void TestAltaOperario_PasswordLargo13() {
		String password = "ASDFQWEaZXCV1";
		String nombreDeUsuario = "nombre";
		boolean activo = false;
		try {
			Sistema.getInstance().getZonaGestionDePersonal().altaOperario(nombreDeUsuario, password, activo);
			Assert.fail("Debio lanzarse la excepcion");
		} catch (DatosIncorrectosException e) {
			
		}
	}
	@Test
	public void TestAltaOperario_PasswordNoMayusc() {
		String password = "aaaaaaa4";
		String nombreDeUsuario = "nombre";
		boolean activo = true;
		try {
			Sistema.getInstance().getZonaGestionDePersonal().altaOperario(nombreDeUsuario, password, activo);
			Assert.fail("Debio lanzarse la excepcion");
		} catch (DatosIncorrectosException e) {
			
		}
	}
	@Test
	public void TestAltaOperario_PasswordNoNum() {
		String password = "Aaaaaaaaa";
		String nombreDeUsuario = "nombre";
		boolean activo = true;
		try {
			Sistema.getInstance().getZonaGestionDePersonal().altaOperario(nombreDeUsuario, password, activo);
			Assert.fail("Debio lanzarse la excepcion");
		} catch (DatosIncorrectosException e) {
			
		}
	}
	@Test
	public void TestAltaOperario_PasswordNull() {
		String password = null;
		String nombreDeUsuario = "nombre";
		boolean activo = true;
		try {
			Sistema.getInstance().getZonaGestionDePersonal().altaOperario(nombreDeUsuario, password, activo);
			Assert.fail("Debio lanzarse la excepcion");
		} catch (DatosIncorrectosException e) {
			
		}
	}
	@Test
	public void TestAltaOperarioAdministrador_Exitoso() {
		String password = "a";
		String nombreDeUsuario = "b";
		boolean activo = true;
		
		Sistema.getInstance().getZonaGestionDePersonal().altaOperarioAdministrador(nombreDeUsuario, password, activo);

		ArrayList<OperarioAdministrador> operariosAdministradores = Sistema.getInstance().getOperariosAdministradores();
		
		Assert.assertEquals("Error en nombre", nombreDeUsuario, operariosAdministradores.get(operariosAdministradores.size()-1).getNombreDeUsuario());
		
	}
	@Test
	public void TestAltaOperarioAdministrador_PasswordVacia() {
		String password = "";
		String nombreDeUsuario = "nombre";
		boolean activo = true;

		Sistema.getInstance().getZonaGestionDePersonal().altaOperarioAdministrador(nombreDeUsuario, password, activo);
		
		ArrayList<OperarioAdministrador> operariosAdministradores = Sistema.getInstance().getOperariosAdministradores();
		
		Assert.assertEquals("Error en nombre", nombreDeUsuario, operariosAdministradores.get(operariosAdministradores.size()-1).getNombreDeUsuario());

	}
	@Test
	public void TestAltaOperarioAdministrador_NombreVacio() {
		String password = "a";
		String nombreDeUsuario = "";
		boolean activo = true;

		Sistema.getInstance().getZonaGestionDePersonal().altaOperarioAdministrador(nombreDeUsuario, password, activo);
		
		ArrayList<OperarioAdministrador> operariosAdministradores = Sistema.getInstance().getOperariosAdministradores();
		
		Assert.assertEquals("Error en nombre", nombreDeUsuario, operariosAdministradores.get(operariosAdministradores.size()-1).getNombreDeUsuario());

	}
	@Test
	public void TestCambiarEstadoMozo_Exitoso() {
		
		Mozo mozo = Sistema.getInstance().getMozos().get(0);

		
		String estado = Estado.DE_FRANCO.getEstado();
		try {
			Sistema.getInstance().getZonaGestionDePersonal().cambiarEstadoMozo(mozo, estado);
			
		} catch (DatosIncorrectosException e) {
			Assert.fail("No debio lanzarse la excepcion");
		}
		
		Assert.assertEquals("Error en nombre", estado, mozo.getEstado());	
	}
	@Test
	public void TestCambiarEstadoMozo_MozoNull() {
		
		Mozo mozo = null;
		
		String estado = Estado.DE_FRANCO.getEstado();
		try {
			Sistema.getInstance().getZonaGestionDePersonal().cambiarEstadoMozo(mozo, estado);
			Assert.fail("Debio lanzarse la excepcion");
		} catch (DatosIncorrectosException e) {
			
		}
			
	}
	@Test
	public void TestCambiarEstadoMozo_EstadoNull() {
		
		Mozo mozo = Sistema.getInstance().getMozos().get(0);
		
		String estado = null;
		try {
			Sistema.getInstance().getZonaGestionDePersonal().cambiarEstadoMozo(mozo, estado);
			Assert.fail("Debio lanzarse la excepcion");
		} catch (DatosIncorrectosException e) {
			
		}
			
	}
	@Test
	public void TestCambiarEstadoMozo_MozoFueraDeSistema() {
		
		Mozo mozo = new Mozo(2,Estado.ACTIVO.getEstado(),1000,"nombre",new Date());
		
		String estado = Estado.DE_FRANCO.getEstado();
		try {
			Sistema.getInstance().getZonaGestionDePersonal().cambiarEstadoMozo(mozo, estado);
			
		} catch (DatosIncorrectosException e) {
			Assert.fail("No debio lanzarse la excepcion");
		}
		
		Assert.assertEquals("Error en nombre", estado, mozo.getEstado());	
	}
	

	@Test
	public void TestAltaMozo_Exitoso() {
		
		int cantHijos = 2;
		String estado = Estado.ACTIVO.getEstado();
		double sueldo = 1000;
		String nombre = "nombre";
		int anioNac = 2000;
		int mesNac = 6;
		int diaNac = 9;

		try {
			Sistema.getInstance().getZonaGestionDePersonal().altaMozo(cantHijos, estado, sueldo, nombre, anioNac, mesNac, diaNac);
		} catch (DatosIncorrectosException e) {
			Assert.fail("No debio Lanzarse excepcion");
		}
		
		ArrayList<Mozo> mozos = Sistema.getInstance().getMozos();
		
		Assert.assertEquals("Error en nombre", nombre, mozos.get(mozos.size()-1).getNombreYApellido());
		
	}
	@Test
	public void TestAltaOperario_cantHijosNegativo1() {
		int cantHijos = -1;
		String estado = Estado.ACTIVO.getEstado();
		double sueldo = 1000;
		String nombre = "nombre";
		int anioNac = 2000;
		int mesNac = 6;
		int diaNac = 9;

		try {
			Sistema.getInstance().getZonaGestionDePersonal().altaMozo(cantHijos, estado, sueldo, nombre, anioNac, mesNac, diaNac);
			Assert.fail("Debio lanzarse excepcion");
		} catch (DatosIncorrectosException e) {
			
		}

	}
	@Test
	public void TestAltaOperario_anioNac2020() {
		int cantHijos = 2;
		String estado = Estado.ACTIVO.getEstado();
		double sueldo = 1000;
		String nombre = "nombre";
		int anioNac = 2020;
		int mesNac = 6;
		int diaNac = 9;

		try {
			Sistema.getInstance().getZonaGestionDePersonal().altaMozo(cantHijos, estado, sueldo, nombre, anioNac, mesNac, diaNac);
			Assert.fail("Debio lanzarse excepcion");
		} catch (DatosIncorrectosException e) {
			
		}

	}
	@Test
	public void TestAltaOperario_nombreNull() {
		int cantHijos = 2;
		String estado = Estado.ACTIVO.getEstado();
		double sueldo = 1000;
		String nombre = null;
		int anioNac = 2020;
		int mesNac = 6;
		int diaNac = 9;

		try {
			Sistema.getInstance().getZonaGestionDePersonal().altaMozo(cantHijos, estado, sueldo, nombre, anioNac, mesNac, diaNac);
			Assert.fail("Debio lanzarse excepcion");
		} catch (DatosIncorrectosException e) {
			
		}

	}
	@Test
	public void TestAltaOperario_EstadoNull() {
		int cantHijos = 2;
		String estado = null;
		double sueldo = 1000;
		String nombre = "nombre";
		int anioNac = 2020;
		int mesNac = 6;
		int diaNac = 9;

		try {
			Sistema.getInstance().getZonaGestionDePersonal().altaMozo(cantHijos, estado, sueldo, nombre, anioNac, mesNac, diaNac);
			Assert.fail("Debio lanzarse excepcion");
		} catch (DatosIncorrectosException e) {
			
		}
	}
	@Test
	public void TestBajaMozo_Exitoso() {
		Mozo mozo = Sistema.getInstance().getMozos().get(0);
		try {
			Sistema.getInstance().getZonaGestionDePersonal().bajaMozo(mozo);
		} catch (DatosIncorrectosException e) {
			Assert.fail("No Debio lanzarse excepcion");
		}
		Assert.assertEquals("Error en nombre", true, Sistema.getInstance().getMozos().contains(mozo));
	}
	@Test
	public void TestBajaMozo_MozoNull() {
		Mozo mozo = null;
		try {
			Sistema.getInstance().getZonaGestionDePersonal().bajaMozo(mozo);
			Assert.fail("Debio lanzarse excepcion");
		} catch (DatosIncorrectosException e) {
		}
	
	}
	@Test
	public void TestModificarOperario_Exitoso() {
		Operario operario = Sistema.getInstance().getOperarios().get(0);
		
		String nombreUsuarioAnterior = operario.getNombreDeUsuario();
		String nombreUsuario = "asdasd";
		String password = "adaDS89";
		boolean activo = false;		

		try {

			Sistema.getInstance().getZonaGestionDePersonal().modificacionOperario(nombreUsuarioAnterior, nombreUsuario, password, activo);
		} catch (DatosIncorrectosException e) {
			Assert.fail("No debio lanzarse excepcion");
		}
		
		Assert.assertEquals("Error en nombreUsuario", nombreUsuario, operario.getNombreDeUsuario());
		Assert.assertEquals("Error en password", password, operario.getPassword());
		
	}
	@Test
	public void TestModificarOperario_passwordNull() {
		Operario operario = Sistema.getInstance().getOperarios().get(0);
		
		String nombreUsuarioAnterior = operario.getNombreDeUsuario();
		String nombreUsuario = "asdasd";
		String password = null;
		boolean activo = false;		

		try {
			Sistema.getInstance().getZonaGestionDePersonal().modificacionOperario(nombreUsuarioAnterior, nombreUsuario, password, activo);
			Assert.fail("Debio lanzarse excepcion");
		} catch (DatosIncorrectosException e) {
			
		}
	}
	@Test
	public void TestModificarOperario_passwordInvalida() {
		Operario operario = Sistema.getInstance().getOperarios().get(0);
		
		String nombreUsuarioAnterior = operario.getNombreDeUsuario();
		String nombreUsuario = "nuevoc";
		String password = "a";
		boolean activo = false;		

		try {
			Sistema.getInstance().getZonaGestionDePersonal().modificacionOperario(nombreUsuarioAnterior, nombreUsuario, password, activo);
			Assert.fail("Debio lanzarse excepcion");
		} catch (DatosIncorrectosException e) {
			
		}		
	}
	@Test
	public void TestModificarOperario_nombreUsuarioNull() {

		Operario operario = Sistema.getInstance().getOperarios().get(0);
		
		String nombreUsuarioAnterior = operario.getNombreDeUsuario();
		String nombreUsuario = null;
		String password = "adaDS89";
		boolean activo = false;		

		try {
			Sistema.getInstance().getZonaGestionDePersonal().modificacionOperario(nombreUsuarioAnterior, nombreUsuario, password, activo);
			Assert.fail("Debio lanzarse excepcion");
		} catch (DatosIncorrectosException e) {
			
		}		
	}
	@Test
	public void TestModificarOperario_nombreUsuarioInexistente() {
		
		String nombreUsuarioAnterior = "noexiste";
		String nombreUsuario = "nuevo";
		String password = "adaDS89";
		boolean activo = false;		

		try {
			Sistema.getInstance().getZonaGestionDePersonal().modificacionOperario(nombreUsuarioAnterior, nombreUsuario, password, activo);
			Assert.fail("Debio lanzarse excepcion");
		} catch (DatosIncorrectosException e) {
			
		}	
	}
	
	}
