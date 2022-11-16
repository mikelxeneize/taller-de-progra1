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
import com.tallerDeProgra.capaDeDatos.Producto;
import com.tallerDeProgra.capaDeNegocios.Sistema;
import com.tallerDeProgra.enums.Estado;
import com.tallerDeProgra.enums.EstadosMesa;

import excepciones.DatosIncorrectosException;

class TestConfiguracionDeSistema {

	@BeforeEach
	public void setUp() {
		
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().altaMesa(3, EstadosMesa.LIBRE.getEstado());
			Sistema.getInstance().getZonaConfiguracionDeSistema().altaMesa(4, EstadosMesa.LIBRE.getEstado());
			
			Sistema.getInstance().getZonaConfiguracionDeSistema().altaProducto("Producto 1", 10, 20, 30);
			Sistema.getInstance().getZonaConfiguracionDeSistema().altaProducto("Producto 2", 10, 20, 30);
			
			Sistema.getInstance().getZonaGestionDePersonal().altaMozo(2, Estado.AUSENTE.getEstado(), 1000, "Mozo1", 2000, 2, 20);
			Sistema.getInstance().getZonaGestionDePersonal().altaMozo(2, Estado.AUSENTE.getEstado(), 1000, "Mozo2", 2000, 2, 20);
			
				
		} catch (DatosIncorrectosException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestAltaMesa_Exitoso() {
		
		int cantComensales = 2;
		String estado = EstadosMesa.LIBRE.getEstado();
		ArrayList<Mesa> mesas =  Sistema.getInstance().getMesas();
		int idMesaAnterior = mesas.get(mesas.size()-1).getId();
		
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().altaMesa(cantComensales, estado);
		} catch (DatosIncorrectosException e) {
			Assert.fail("No debio Lanzarse excepcion");
		}
		Mesa mesa = mesas.get(mesas.size()-1);
		
		Assert.assertEquals("Error en cantComensales", cantComensales, mesa.getCantComensales());
		Assert.assertEquals("Error en estado", cantComensales, mesa.getCantComensales());
		Assert.assertEquals("Error en id", mesa.getId(), idMesaAnterior +1);
	}

	@Test
	public void TestAltaMesa_EstadoNull() {
		int cantComensales = 2;
		String estado = null;
		
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().altaMesa(cantComensales, estado);
			Assert.fail("Debio Lanzarse excepcion, el estado era null");
		} catch (DatosIncorrectosException e) {
			
		}	
	}
	
	@Test
	public void TestAltaMesa_cantComensales1() {
		int cantComensales = 1;
		String estado = EstadosMesa.LIBRE.getEstado();
		
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().altaMesa(cantComensales, estado);
			Assert.fail("Debio Lanzarse excepcion, cantidad de comensales es 1");
		} catch (DatosIncorrectosException e) {
			
		}
	}
	
	@Test
	public void TestModificarMesa_Exitoso() {
		
		Mesa mesa = Sistema.getInstance().getMesas().get(0);
		String estado;
		int cantComensales = 3;
		if (mesa.getEstado() == EstadosMesa.OCUPADA.getEstado())
			estado = EstadosMesa.LIBRE.getEstado();
		else
			estado = EstadosMesa.OCUPADA.getEstado();
		
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().modificarMesa(mesa, cantComensales, estado);
		} catch (DatosIncorrectosException e) {
			Assert.fail("No debio Lanzarse excepcion");
		}
		Assert.assertEquals("Error en cantComensales", cantComensales, mesa.getCantComensales());
		Assert.assertEquals("Error en estado", estado, mesa.getEstado());
	}
	@Test
	public void TestModificarMesa_MesaNull() {
		Mesa mesa = null;
		int cantComensales = 3;
		String estado = EstadosMesa.LIBRE.getEstado();
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().modificarMesa(mesa, cantComensales, estado);
			Assert.fail("Debia Lanzarse excepcion");
		} catch (DatosIncorrectosException e) {

		}
	}
	@Test
	public void TestModificarMesa_EstadoNull() {
		Mesa mesa = new Mesa(10, EstadosMesa.LIBRE.getEstado());
		int cantComensales = 3;
		String estado = null;
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().modificarMesa(mesa, cantComensales, estado);
			Assert.fail("Debia Lanzarse excepcion");
		} catch (DatosIncorrectosException e) {
			
		}
	}
	@Test
	public void TestModificarMesa_FueraDeSistema() {
		Mesa mesa = new Mesa(10, "Estado viejo");
		int cantComensales = 3;
		String estado = null;
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().modificarMesa(mesa, cantComensales, estado);
			Assert.fail("Debia Lanzarse excepcion");
		} catch (DatosIncorrectosException e) {
			
		}
	}
	@Test
	public void TestModificarMesa_cantComensales1() {
		Mesa mesa = new Mesa(10, "Estado viejo");
		int cantComensales = 1;
		String estado = EstadosMesa.LIBRE.getEstado();
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().modificarMesa(mesa, cantComensales, estado);
		} catch (DatosIncorrectosException e) {
			
		}
	}
	@Test
	public void TestEliminarMesa_Exitoso() {
		Mesa mesa = Sistema.getInstance().getMesas().get(0);
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().eliminarMesa(mesa);
		} catch (DatosIncorrectosException e) {
			Assert.fail("No debia lanzarse la excepcion");
		}
		
		Assert.assertEquals("Error en eliminar", false, Sistema.getInstance().getMesas().contains(mesa));
	}
	@Test
	public void TestEliminarMesa_MesaNull() {
		Mesa mesa = null;
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().eliminarMesa(mesa);
			Assert.fail("Debia Lanzarse excepcion");
		} catch (DatosIncorrectosException e) {
	
		}
	}
	@Test
	public void TestAltaProducto_Exitoso() {
		
		float precioCosto = 10;
		String nombre = "Fideos con Pesto";
		float precioVenta = 20;
		int stockInicial = 10;
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().altaProducto(nombre, precioCosto, precioVenta, stockInicial);
		} catch (DatosIncorrectosException e) {
			Assert.fail("No debia lanzarse la excepcion");
		};
		
		Assert.assertEquals("Error en Alta", nombre, Sistema.getInstance().getProductos().get(Sistema.getInstance().getProductos().size() -1).getNombre());
	}
	@Test
	public void TestAltaProducto_precioVenta0() {
		
		float precioCosto = 10;
		String nombre = "Fideos con Pesto";
		float precioVenta = 0;
		int stockInicial = 10;
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().altaProducto(nombre, precioCosto, precioVenta, stockInicial);
			Assert.fail("Debia lanzarse la excepcion");
		} catch (DatosIncorrectosException e) {
			
		};
	}
	@Test
	public void TestAltaProducto_precioCosto0() {
		
		float precioCosto = 0;
		String nombre = "Fideos con Pesto";
		float precioVenta = 20;
		int stockInicial = 10;
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().altaProducto(nombre, precioCosto, precioVenta, stockInicial);
			Assert.fail("Debia lanzarse la excepcion");
		} catch (DatosIncorrectosException e) {
			
		};
	}
	@Test
	public void TestAltaProducto_precioVentaMenorPrecioCosto() {
		
		float precioCosto = 100;
		String nombre = "Fideos con Pesto";
		float precioVenta = 20;
		int stockInicial = 10;
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().altaProducto(nombre, precioCosto, precioVenta, stockInicial);
			Assert.fail("Debia lanzarse la excepcion");
		} catch (DatosIncorrectosException e) {
			
		};
	}
	@Test
	public void TestAltaProducto_nombreNull() {
		
		float precioCosto = 10;
		String nombre = null;
		float precioVenta = 20;
		int stockInicial = 10;
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().altaProducto(nombre, precioCosto, precioVenta, stockInicial);
			Assert.fail("Debia lanzarse la excepcion");
		} catch (DatosIncorrectosException e) {
			
		};
	}
	@Test
	public void TestActualizarProducto_Exitoso() {
		
		Producto producto = Sistema.getInstance().getProductos().get(0);
		int stockViejo = producto.getStock();
		int cantStock = 10;
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().actualizarProducto(producto, cantStock);
		} catch (DatosIncorrectosException e) {
			Assert.fail("No debia lanzarse la excepcion");
		};
		
		Assert.assertEquals("Error en stock", stockViejo + cantStock, producto.getStock());
		
	}
	@Test
	public void TestActualizarProducto_cantStock0() {
		
		Producto producto = Sistema.getInstance().getProductos().get(0);
		int cantStock= 0;
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().actualizarProducto(producto, cantStock);
		} catch (DatosIncorrectosException e) {
			Assert.fail("No debia lanzarse la excepcion");
		};
	}
	@Test
	public void TestActualizarProducto_cantStockNegativo9999() {
		
		Producto producto = Sistema.getInstance().getProductos().get(0);
		int cantStock= -9999;
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().actualizarProducto(producto, cantStock);
		} catch (DatosIncorrectosException e) {
			Assert.fail("No debia lanzarse la excepcion");
		};
	}
	@Test
	public void TestActualizarProducto_ProductoNull() {
		
		Producto producto = null;
		int cantStock= 22;
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().actualizarProducto(producto, cantStock);
			Assert.fail("Debia lanzarse la excepcion");
		} catch (DatosIncorrectosException e) {
			
		};
	}
	@Test
	public void TestActualizarProducto_ProductoFueraDeSistema() {
		
		Producto producto = new Producto("prod", 1, 1, 1);
		int cantStock= 22;
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().actualizarProducto(producto, cantStock);
			Assert.fail("Debia lanzarse la excepcion");
		} catch (DatosIncorrectosException e) {
			
		};
	}
	@Test
	public void TestModificarProducto_Exitoso() {
		
		Producto producto = Sistema.getInstance().getProductos().get(0);
		
		
		int cantStock = 17;
		String nombre = "Fideos de las 2 am";
		float precioCosto = 230;
		float precioVenta = 230;
		
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().modificarProducto(producto.getId(), nombre, precioCosto, precioVenta, cantStock);
		} catch (DatosIncorrectosException e) {
			Assert.fail("No debia lanzarse la excepcion");
		};
		
		Assert.assertEquals("Error en stock", cantStock, producto.getStock());
		Assert.assertEquals("Error en nombre", nombre, producto.getNombre());
		Assert.assertEquals("Error en precioCosto", precioCosto, producto.getPrecioCosto());
		Assert.assertEquals("Error en precioVenta", precioVenta, producto.getPrecioVenta());
	}
	@Test
	public void TestModificarProducto_idNegativo() {
		
		int cantStock = 17;
		String nombre = "Fideos";
		float precioCosto = 230;
		float precioVenta = 240;
		
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().modificarProducto(-999, nombre, precioCosto, precioVenta, cantStock);
			Assert.fail("Debia lanzarse la excepcion");
		} catch (DatosIncorrectosException e) {
			
		};
	} 
	@Test
	public void TestModificarProducto_nombreVacio() {
		
		Producto producto = Sistema.getInstance().getProductos().get(0);
		int cantStock = 17;
		String nombre = "";
		float precioCosto = 230;
		float precioVenta = 231;
		
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().modificarProducto(producto.getId(), nombre, precioCosto, precioVenta, cantStock);
		} catch (DatosIncorrectosException e) {
			Assert.fail("No debia lanzarse la excepcion");
		};
	}
	@Test
	public void TestModificarProducto_cantStockNegativo9999() {
		
		Producto producto = Sistema.getInstance().getProductos().get(0);
		int cantStock = -9999;
		String nombre = "Fideos";
		float precioCosto = 230;
		float precioVenta = 230;
		
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().modificarProducto(producto.getId(), nombre, precioCosto, precioVenta, cantStock);
		} catch (DatosIncorrectosException e) {
			Assert.fail("No debia lanzarse la excepcion");
		};
	}
	@Test
	public void TestModificarProducto_precioCosto0() {
		
		Producto producto = Sistema.getInstance().getProductos().get(0);
		int cantStock = 17;
		String nombre = "Fideos";
		float precioCosto = 0;
		float precioVenta = 230;
		
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().modificarProducto(producto.getId(), nombre, precioCosto, precioVenta, cantStock);
			Assert.fail("Debia lanzarse la excepcion");
		} catch (DatosIncorrectosException e) {
			
		};
	}
	@Test
	public void TestModificarProducto_precioVenta0() {
		
		Producto producto = Sistema.getInstance().getProductos().get(0);
		int cantStock = 17;
		String nombre = "Fideos";
		float precioCosto = 0;
		float precioVenta = 0;
		
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().modificarProducto(producto.getId(), nombre, precioCosto, precioVenta, cantStock);
			Assert.fail("Debia lanzarse la excepcion");
		} catch (DatosIncorrectosException e) {
			
		};
	}
	@Test
	public void TestModificarProducto_precioVentaMenorPrecioCosto() {
		
		Producto producto = Sistema.getInstance().getProductos().get(0);
		int cantStock = 17;
		String nombre = "Fideos";
		float precioCosto = 230;
		float precioVenta = 0;
		
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().modificarProducto(producto.getId(), nombre, precioCosto, precioVenta, cantStock);
			Assert.fail("Debia lanzarse la excepcion");
		} catch (DatosIncorrectosException e) {
			
		};
	}
	@Test
	public void TestEliminarProducto_Exitoso() {
		Producto producto = Sistema.getInstance().getProductos().get(0);
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().eliminarProducto(producto);
		} catch (DatosIncorrectosException e) {
			Assert.fail("No debia lanzarse la excepcion");
		}
		
		Assert.assertEquals("Error en eliminar", false, Sistema.getInstance().getProductos().contains(producto));
	}
	@Test
	public void TestEliminarProducto_ProductoNull() {
		Producto producto = null;
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().eliminarProducto(producto);
			Assert.fail("Debia lanzarse la excepcion");
		} catch (DatosIncorrectosException e) {

		}
	}
	@Test
	public void TestPromedio_Exitoso() {
		Mozo mozo = Sistema.getInstance().getMozos().get(0);
		try {
			float prom = Sistema.getInstance().getZonaConfiguracionDeSistema().promedio(mozo);
		} catch (DatosIncorrectosException e) {
			Assert.fail("No debia lanzarse la excepcion");
		}		
		
	}
	@Test
	public void TestPromedio_MozoNull() {
		Mozo mozo = null;
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().promedio(mozo);
			Assert.fail("Debia lanzarse la excepcion");
		} catch (DatosIncorrectosException e) {
			
		}		
		
	}
	@Test
	public void TestPromedio_MozoFueraDeSistema() {
		Mozo mozo = new Mozo(2, Estado.AUSENTE.getEstado(), 1000, "NyA", new Date());
		try {
			Sistema.getInstance().getZonaConfiguracionDeSistema().promedio(mozo);
			
		} catch (DatosIncorrectosException e) {
			Assert.fail("No debia lanzarse la excepcion");
		}
	}
	
	
}