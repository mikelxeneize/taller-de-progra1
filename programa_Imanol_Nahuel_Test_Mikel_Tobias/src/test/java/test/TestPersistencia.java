package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tallerDeProgra.capaDeNegocios.Sistema;

import persistencia.IPersistencia;
import persistencia.Persistencia;
import persistencia.SistemaDTO;
import persistencia.Utils;

class TestPersistencia {
	SistemaDTO sistema;
	IPersistencia persistencia;
	
	public TestPersistencia() {
	}
	
	@Test
	public void testCrearArchivo() throws IOException, ClassNotFoundException {
	try
	{
	sistema = new SistemaDTO();
	persistencia= new Persistencia();
	persistencia.abrirOutput("Sistema.bin");
	System.out.println("Archivo abierto");
	sistema = (SistemaDTO) persistencia.leer();
	persistencia.cerrarOutput();
	File archivo = new File ("Sistema.bin");
	Assert.assertTrue( " Deberia existir  el  archivo  sistema.bin",archivo.exists());

	}
	catch (FileNotFoundException e)
	{
	Assert.fail( "No deberia lanzar excepcion" + e.getMessage() );
	}
	
	}	
	@Test
	public void testArchivoVacio() throws IOException, ClassNotFoundException {
	try
	{
	sistema = new SistemaDTO();
	persistencia= new Persistencia();
	persistencia.abrirOutput("Sistema.bin");
	sistema=(SistemaDTO) persistencia.leer();
	persistencia.cerrarOutput();
	Assert.assertEquals( " Deberia estar vacio",this.sistema,sistema);

	}
	catch (FileNotFoundException e)
	{
	Assert.fail( "No deberia lanzar excepcion" + e.getMessage() );
	}
	}
	
	@Test
	public void testdespersistirArchivo() throws IOException, ClassNotFoundException {
	try
	{
	sistema = new SistemaDTO();
	persistencia= new Persistencia();
	persistencia.abrirOutput("Sistema.bin");
	sistema=(SistemaDTO) persistencia.leer();
	persistencia.cerrarOutput();
	Assert.fail( " No deberia leer");

	}
	catch (FileNotFoundException e)
	{
	Assert.fail( "se deberia enviar siempre");
	}
	}
	
	
}