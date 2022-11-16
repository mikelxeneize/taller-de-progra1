	
	package test;
	
	import static org.junit.jupiter.api.Assertions.*;
	
	import java.util.ArrayList;
	import java.util.Date;
	
	import org.junit.Assert;
	import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
	
	import com.tallerDeProgra.capaDeDatos.Comanda;
	import com.tallerDeProgra.capaDeDatos.Mesa;
	import com.tallerDeProgra.capaDeDatos.Mozo;
	import com.tallerDeProgra.capaDeDatos.Operario;
	import com.tallerDeProgra.capaDeDatos.OperarioAdministrador;
	import com.tallerDeProgra.capaDeDatos.Pedido;
	import com.tallerDeProgra.capaDeDatos.Producto;
	import com.tallerDeProgra.capaDeDatos.Promocion;
import com.tallerDeProgra.capaDeDatos.PromocionTemporal;
import com.tallerDeProgra.capaDeNegocios.Sistema;
	import com.tallerDeProgra.enums.Estado;
import com.tallerDeProgra.enums.EstadoComanda;
import com.tallerDeProgra.enums.EstadosMesa;

	import excepciones.CantidadInsuficienteActivosException;
	import excepciones.DatosIncorrectosException;
	import excepciones.DemasiadosMozosDeFrancoException;
	
	class TestPedidosFacturacionYPromociones {
	
		@BeforeEach
		public void setUp() {
			
			try {
				Sistema.getInstance().getZonaConfiguracionDeSistema().altaMesa(3, EstadosMesa.LIBRE.getEstado());
				Sistema.getInstance().getZonaConfiguracionDeSistema().altaMesa(4, EstadosMesa.LIBRE.getEstado());
				Sistema.getInstance().getZonaConfiguracionDeSistema().altaMesa(5, EstadosMesa.LIBRE.getEstado());
				
				Sistema.getInstance().getZonaConfiguracionDeSistema().altaProducto("Producto 1", 10, 20, 300);
				Sistema.getInstance().getZonaConfiguracionDeSistema().altaProducto("Producto 2", 12, 22, 300);
				
				Sistema.getInstance().getZonaGestionDePersonal().altaMozo(2, Estado.ACTIVO.getEstado(), 1000, "Mozo1", 2000, 2, 20);
				Sistema.getInstance().getZonaGestionDePersonal().altaMozo(2, Estado.ACTIVO.getEstado(), 1000, "Mozo2", 2000, 2, 20);
				Sistema.getInstance().getZonaGestionDePersonal().altaMozo(2, Estado.DE_FRANCO.getEstado(), 1000, "Mozo3", 2000, 2, 20);
				Sistema.getInstance().getZonaGestionDePersonal().altaMozo(2, Estado.DE_FRANCO.getEstado(), 1000, "Mozo4", 2000, 2, 20);
				
				Sistema.getInstance().ArrancarDia();
				
				ArrayList<Pedido> pedidos1 = new ArrayList<Pedido>();
				pedidos1.add(new Pedido());
				
				ArrayList<String> diasDePromo = new ArrayList<String>();
				diasDePromo.add("Lunes");
				
				Sistema.getInstance().getZonaPedidosYFacturacion().altaPromocionTemporal("Promo", "formaPago", 20, diasDePromo, true);
				Sistema.getInstance().getZonaPedidosYFacturacion().altaPromocionTemporal("Promo2", "formaPago2", 20, diasDePromo, true);
				Sistema.getInstance().getZonaPedidosYFacturacion().altaPromocionTemporal("Promo2", "formaPago2", 20, diasDePromo, false);
				
				Sistema.getInstance().getZonaPedidosYFacturacion().altaPromocion(Sistema.getInstance().getProductos().get(0), diasDePromo, true, false, 2, 50);
				Sistema.getInstance().getZonaPedidosYFacturacion().altaPromocion(Sistema.getInstance().getProductos().get(0), diasDePromo, true, false, 2, 50);
				Sistema.getInstance().getZonaPedidosYFacturacion().altaPromocion(Sistema.getInstance().getProductos().get(0), diasDePromo, true, false, 2, 50);
				
				Sistema.getInstance().getPromociones().get(2).setActiva(false);
				
				Comanda comanda1 = new Comanda(new Date(), Sistema.getInstance().getMesas().get(1), pedidos1);
				
				Sistema.getInstance().getZonaPedidosYFacturacion().altaComanda(comanda1); 
			
				Sistema.getInstance().getZonaPedidosYFacturacion().altaPedido(comanda1, Sistema.getInstance().getProductos().get(0),2);
			
				
			} catch (DatosIncorrectosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DemasiadosMozosDeFrancoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CantidadInsuficienteActivosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
		@Test
		public void TestAltaComanda_Exitoso() {
			
			ArrayList<Pedido> pedidos1 = new ArrayList<Pedido>();
			pedidos1.add(new Pedido());
			Comanda comanda1 = new Comanda(new Date(), Sistema.getInstance().getMesas().get(0), pedidos1);
			try {
				Sistema.getInstance().getZonaPedidosYFacturacion().altaComanda(comanda1); 
			} catch (DatosIncorrectosException e) {
				Assert.fail("No debio Lanzarse excepcion");
			}
			
			ArrayList<Comanda> comandas = Sistema.getInstance().getComandas();
			
			Assert.assertEquals("Error en comanda", true, comandas.contains(comanda1));
			
		}

		@Test
		public void TestAltaComanda_ComandaNull() {
			
			ArrayList<Pedido> pedidos1 = new ArrayList<Pedido>();
			pedidos1.add(new Pedido());
			Comanda comanda1 = null;
			try {
				Sistema.getInstance().getZonaPedidosYFacturacion().altaComanda(comanda1);
				Assert.fail("Debio Lanzarse excepcion");
			} catch (DatosIncorrectosException e) {
				
			}
			
		}
		@Test
		public void TestAltaComanda_MesaOcupada() {
			ArrayList<Pedido> pedidos1 = new ArrayList<Pedido>();
			pedidos1.add(new Pedido());
			Comanda comanda1 = new Comanda(new Date(), Sistema.getInstance().getMesas().get(1), pedidos1); //el setUp ocupa la mesa pos 2 en array mesas
			try {
				Sistema.getInstance().getZonaPedidosYFacturacion().altaComanda(comanda1);
				Assert.fail("No debio Lanzarse excepcion");
			} catch (DatosIncorrectosException e) {

			}
			
			ArrayList<Comanda> comandas = Sistema.getInstance().getComandas();
			
			Assert.assertEquals("Error en comanda", true, comandas.contains(comanda1));
		
		}
		@Test
		public void TestAltaComanda_SinMesasLibres() {
			ArrayList<Pedido> pedidos1 = new ArrayList<Pedido>();
			pedidos1.add(new Pedido());
			Comanda comanda1 = new Comanda(new Date(), Sistema.getInstance().getMesas().get(0), pedidos1); 
			Comanda comanda2 = new Comanda(new Date(), Sistema.getInstance().getMesas().get(2), pedidos1); 
			try {
				Sistema.getInstance().getZonaPedidosYFacturacion().altaComanda(comanda1);
				Sistema.getInstance().getZonaPedidosYFacturacion().altaComanda(comanda2);
				Sistema.getInstance().getZonaPedidosYFacturacion().altaComanda(comanda2); //aca ya no hay mesas libres
				Assert.fail("Debio Lanzarse excepcion");
			} catch (DatosIncorrectosException e) {
				
			}
			
		}
		@Test
		public void TestAltaComanda_SinPromociones() {
			ArrayList<Pedido> pedidos1 = new ArrayList<Pedido>();
			pedidos1.add(new Pedido());
			Comanda comanda1 = new Comanda(new Date(), Sistema.getInstance().getMesas().get(0), pedidos1); 
			
			
			try {
				Sistema.getInstance().getZonaPedidosYFacturacion().bajaPromocion(Sistema.getInstance().getPromociones().get(0));
				Sistema.getInstance().getZonaPedidosYFacturacion().bajaPromocion(Sistema.getInstance().getPromociones().get(0));
				Sistema.getInstance().getZonaPedidosYFacturacion().bajaPromocionTemporal(Sistema.getInstance().getPromocionesTemporales().get(0));
				Sistema.getInstance().getZonaPedidosYFacturacion().bajaPromocionTemporal(Sistema.getInstance().getPromocionesTemporales().get(0));
				Sistema.getInstance().getZonaPedidosYFacturacion().altaComanda(comanda1);
				Assert.fail("Debio Lanzarse excepcion");
			} catch (DatosIncorrectosException e) {
				
			}
			
			ArrayList<Comanda> comandas = Sistema.getInstance().getComandas();
			
			Assert.assertEquals("Error en comanda", true, comandas.contains(comanda1));
		

		}
		
		@Test
		public void TestBajaComanda_Exitos() {
			
			Comanda comanda1 = Sistema.getInstance().getComandas().get(0);
			try {
				Sistema.getInstance().getZonaPedidosYFacturacion().bajaComanda(comanda1); 
			} catch (DatosIncorrectosException e) {
				Assert.fail("No debio Lanzarse excepcion");
			}
			
			ArrayList<Comanda> comandas = Sistema.getInstance().getComandas();
			
			Assert.assertEquals("Error en comanda", false, comandas.contains(comanda1));
			
		}
		
		
		@Test
		public void TestBajaComanda_ComandaNull() {
			
			Comanda comanda1 = null;
			try {
				Sistema.getInstance().getZonaPedidosYFacturacion().bajaComanda(comanda1);
				Assert.fail("Debio Lanzarse excepcion");
			} catch (DatosIncorrectosException e) {
			
			}
			
			
		}
		@Test
		public void TestAltaPromocion_Exitoso() {
			

			Producto producto = Sistema.getInstance().getProductos().get(0);
			ArrayList<String> diasDePromo = new ArrayList<String>();
			diasDePromo.add("Lunes");
			boolean aplicaDosporuno = true;
			boolean aplicaDescCantidadMinima = false;
			int cantidadMinima = 2;
			float precioUnitario = 20;
			try {
				Sistema.getInstance().getZonaPedidosYFacturacion().altaPromocion(producto, diasDePromo, aplicaDosporuno, aplicaDescCantidadMinima, cantidadMinima, precioUnitario); 
			} catch (DatosIncorrectosException e) {
				Assert.fail("No debio Lanzarse excepcion");
			}
			
		}
		@Test
		public void TestAltaPromocion_ProductoNull() {
			

			Producto producto = null;
			ArrayList<String> diasDePromo = new ArrayList<String>();
			diasDePromo.add("Lunes");
			boolean aplicaDosporuno = true;
			boolean aplicaDescCantidadMinima = false;
			int cantidadMinima = 2;
			float precioUnitario = 20;
			try {
				Sistema.getInstance().getZonaPedidosYFacturacion().altaPromocion(producto, diasDePromo, aplicaDosporuno, aplicaDescCantidadMinima, cantidadMinima, precioUnitario);
				Assert.fail("Debio Lanzarse excepcion");
			} catch (DatosIncorrectosException e) {
				
			}
			
		}
		@Test
		public void TestAltaPromocion_DiasPromoNull() {
			

			Producto producto = Sistema.getInstance().getProductos().get(0);;
			ArrayList<String> diasDePromo = null;
			boolean aplicaDosporuno = true;
			boolean aplicaDescCantidadMinima = false;
			int cantidadMinima = 2;
			float precioUnitario = 20;
			try {
				Sistema.getInstance().getZonaPedidosYFacturacion().altaPromocion(producto, diasDePromo, aplicaDosporuno, aplicaDescCantidadMinima, cantidadMinima, precioUnitario);
				Assert.fail("Debio Lanzarse excepcion");
			} catch (DatosIncorrectosException e) {
				
			}
			
		}
		@Test
		public void TestAltaPromocion_DiasPromoVacio() {
			

			Producto producto = Sistema.getInstance().getProductos().get(0);
			ArrayList<String> diasDePromo = new ArrayList<String>();
			boolean aplicaDosporuno = true;
			boolean aplicaDescCantidadMinima = false;
			int cantidadMinima = 2;
			float precioUnitario = 20;
			try {
				Sistema.getInstance().getZonaPedidosYFacturacion().altaPromocion(producto, diasDePromo, aplicaDosporuno, aplicaDescCantidadMinima, cantidadMinima, precioUnitario);
				Assert.fail("Debio Lanzarse excepcion");
			} catch (DatosIncorrectosException e) {
				
			}
			
		}
		
		@Test
		public void TestBajaPromocion_Exitoso() {
			
			Promocion promocion= Sistema.getInstance().getPromociones().get(0);
			try {
				Sistema.getInstance().getZonaPedidosYFacturacion().bajaPromocion(promocion); 
			} catch (DatosIncorrectosException e) {
				Assert.fail("No debio Lanzarse excepcion");
			}
			
			ArrayList<Promocion> promociones= Sistema.getInstance().getPromociones();
			
			Assert.assertEquals("Error en Promocion", false, promociones.contains(promocion));
			
		}
		
		
		@Test
		public void TestBajaPromocion_PromocionNull() {
			
			Promocion promocion = null;
			try {
				Sistema.getInstance().getZonaPedidosYFacturacion().bajaPromocion(promocion);
				Assert.fail("Debio Lanzarse excepcion");
			} catch (DatosIncorrectosException e) {
				
			}
				
		}
		@Test
		public void TestAltaPedido_Exitoso() {
			Comanda comanda = Sistema.getInstance().getComandas().get(0);
			Producto producto = Sistema.getInstance().getProductos().get(0);
			int cantidad = 2;
			int cantAnterior = comanda.getPedidos().size();
			try {
				Sistema.getInstance().getZonaPedidosYFacturacion().altaPedido(comanda, producto, cantidad);	
			} catch (DatosIncorrectosException e) {
				Assert.fail("No debio Lanzarse excepcion");
			}
			Assert.assertEquals("Error en comanda", cantAnterior, comanda.getPedidos().size());
		}
		@Test
		public void TestAltaPedido_ComandaNull() {
			Comanda comanda = null;
			Producto producto = Sistema.getInstance().getProductos().get(0);
			int cantidad = 2;
			try {
				Sistema.getInstance().getZonaPedidosYFacturacion().altaPedido(comanda, producto, cantidad);
				Assert.fail("Debio Lanzarse excepcion");
			} catch (DatosIncorrectosException e) {
				
			}			
		}
		@Test
		public void TestAltaPedido_ProductoNull() {
			Comanda comanda = Sistema.getInstance().getComandas().get(0);
			Producto producto = null;
			int cantidad = 2;
			try {
				Sistema.getInstance().getZonaPedidosYFacturacion().altaPedido(comanda, producto, cantidad);
				Assert.fail("Debio Lanzarse excepcion");
			} catch (DatosIncorrectosException e) {
				
			}	
		}
		@Test
		public void TestAltaPedido_Cantidad0() {
			Comanda comanda = Sistema.getInstance().getComandas().get(0);
			Producto producto = Sistema.getInstance().getProductos().get(0);
			int cantidad = 0;
			try {
				Sistema.getInstance().getZonaPedidosYFacturacion().altaPedido(comanda, producto, cantidad);
				Assert.fail("Debio Lanzarse excepcion");
			} catch (DatosIncorrectosException e) {
				
			}
		}
		@Test
		public void TestAltaPedido_CantidadMayorQueStock() {
			Comanda comanda = Sistema.getInstance().getComandas().get(0);
			Producto producto = Sistema.getInstance().getProductos().get(0);
			int cantidad = 9999;
			try {
				Sistema.getInstance().getZonaPedidosYFacturacion().altaPedido(comanda, producto, cantidad);
				Assert.fail("Debio Lanzarse excepcion");
			} catch (DatosIncorrectosException e) {
				
			}
		}
		@Test
		public void TestAltaPedido_ComandaFueraDeSistema() {
			Comanda comanda = new Comanda();
			Producto producto = Sistema.getInstance().getProductos().get(0);
			int cantidad = 9999;
			try {
				Sistema.getInstance().getZonaPedidosYFacturacion().altaPedido(comanda, producto, cantidad);
				Assert.fail("Debio Lanzarse excepcion");
			} catch (DatosIncorrectosException e) {
				
			}
		}
		@Test
		public void TestAltaPromocionTemporal_Exitoso(){

			String nombre = "promo 1";
			String formaDePago = "Efectivo";
			int porcentajeDesc = 22;
			ArrayList<String> diasDePromo = new ArrayList<String>();
			diasDePromo.add("Lunes");
			boolean esAcumulable = true;
			
			int tamanioAnterior = Sistema.getInstance().getPromocionesTemporales().size();
			try {
				Sistema.getInstance().getZonaPedidosYFacturacion().altaPromocionTemporal(nombre, formaDePago, porcentajeDesc, diasDePromo, esAcumulable);
			} catch (DatosIncorrectosException e) {
				Assert.fail("No debio Lanzarse excepcion");
			}
			Assert.assertEquals("Error en PromTemporal", tamanioAnterior + 1, Sistema.getInstance().getPromocionesTemporales().size());
		}
		@Test
		public void TestAltaPromocionTemporal_NombreNull(){

			String nombre = null;
			String formaDePago = "Efectivo";
			int porcentajeDesc = 22;
			ArrayList<String> diasDePromo = new ArrayList<String>();
			diasDePromo.add("Lunes");
			boolean esAcumulable = true;
			
			try {
				Sistema.getInstance().getZonaPedidosYFacturacion().altaPromocionTemporal(nombre, formaDePago, porcentajeDesc, diasDePromo, esAcumulable);
				Assert.fail("Debio lanzarse excepcion");
			} catch (DatosIncorrectosException e) {
	
			}
			
		}
		@Test
		public void TestAltaPromocionTemporal_FormaDePagoNull(){

			String nombre = "promo 1";
			String formaDePago = null;
			int porcentajeDesc = 22;
			ArrayList<String> diasDePromo = new ArrayList<String>();
			diasDePromo.add("Lunes");
			boolean esAcumulable = true;
			
			try {
				Sistema.getInstance().getZonaPedidosYFacturacion().altaPromocionTemporal(nombre, formaDePago, porcentajeDesc, diasDePromo, esAcumulable);
				Assert.fail("Debio lanzarse excepcion");
			} catch (DatosIncorrectosException e) {
	
			}
			
		}
		@Test
		public void TestAltaPromocionTemporal_DiasDePromoNull(){

			String nombre = "promo 1";
			String formaDePago = "Efectivo";
			int porcentajeDesc = 22;
			ArrayList<String> diasDePromo = null;
			
			boolean esAcumulable = true;
			
			try {
				Sistema.getInstance().getZonaPedidosYFacturacion().altaPromocionTemporal(nombre, formaDePago, porcentajeDesc, diasDePromo, esAcumulable);
				Assert.fail("Debio lanzarse excepcion");
			} catch (DatosIncorrectosException e) {
	
			}
			
		}
		@Test
		public void TestAltaPromocionTemporal_DiasDePromoVacio(){

			String nombre = "promo 1";
			String formaDePago = "Efectivo";
			int porcentajeDesc = 22;
			ArrayList<String> diasDePromo = new ArrayList<String>();
			
			boolean esAcumulable = true;
			
			try {
				Sistema.getInstance().getZonaPedidosYFacturacion().altaPromocionTemporal(nombre, formaDePago, porcentajeDesc, diasDePromo, esAcumulable);
				Assert.fail("Debio lanzarse excepcion");
			} catch (DatosIncorrectosException e) {
	
			}
			
		}
		
		@Test
		public void TestBajaPromocionTemporal_Exitoso() {
			
			PromocionTemporal promocionTemporal = Sistema.getInstance().getPromocionesTemporales().get(0);
			try {
				Sistema.getInstance().getZonaPedidosYFacturacion().bajaPromocionTemporal(promocionTemporal); 
			} catch (DatosIncorrectosException e) {
				Assert.fail("No debio Lanzarse excepcion");
			}
			
			ArrayList<PromocionTemporal> promocionesTemporales = Sistema.getInstance().getPromocionesTemporales();
			
			Assert.assertEquals("Error en Promocion", false, promocionesTemporales.contains(promocionTemporal));
			
		}
		
		
		@Test
		public void TestBajaPromocion_PromocionTemporalNull() {
			
			PromocionTemporal promocionTemporal= null;
			try {
				Sistema.getInstance().getZonaPedidosYFacturacion().bajaPromocionTemporal(promocionTemporal);
				Assert.fail("Debio Lanzarse excepcion");
			} catch (DatosIncorrectosException e) {
				
			}		
		}
		
		@Test
		public void TestCerrarComanda_Exitoso() {
			
			ArrayList<Comanda> comandas = Sistema.getInstance().getComandas();
			Comanda comanda = comandas.get(0);
			String metodoDePago = "Efectivo";
			try {
				
				Sistema.getInstance().getZonaPedidosYFacturacion().cerrarComanda(comanda, metodoDePago); 
			} catch (DatosIncorrectosException e) {
				Assert.fail("No debio Lanzarse excepcion");
			}
			
			Assert.assertEquals("Error en Promocion", false, comandas.contains(comanda));	
		}
		
		@Test
		public void TestCerrarComanda_ComandaNull() {
			
			Comanda comanda = null;
			
			String metodoDePago = "Efectivo";
			try {
				
				Sistema.getInstance().getZonaPedidosYFacturacion().cerrarComanda(comanda, metodoDePago);
				Assert.fail("Debio Lanzarse la excepcion");
			} catch (DatosIncorrectosException e) {	
			}
				
		}
		
		@Test
		public void TestCerrarComanda_ComandaYaCerrada() {
			
			ArrayList<Comanda> comandas = Sistema.getInstance().getComandas();
			Comanda comanda = comandas.get(0);
			comanda.setEstado(EstadoComanda.CERRADA.getEstado());
			String metodoDePago = "Efectivo";
			try {
				
				Sistema.getInstance().getZonaPedidosYFacturacion().cerrarComanda(comanda, metodoDePago);
				Assert.fail("Debio Lanzarse la excepcion");
			} catch (DatosIncorrectosException e) {	
			}
				
		}
		
}