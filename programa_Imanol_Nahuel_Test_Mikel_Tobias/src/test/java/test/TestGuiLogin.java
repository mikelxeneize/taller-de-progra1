package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.tallerDeProgra.capaDeNegocios.Sistema;
import com.tallerDeProgra.capaDePresentacion.Controladores.ControladorLogin;

class TestGuiLogin {

    Robot robot;
    ControladorLogin controladorLogin;

    public TestGuiLogin()
    {
        try
        {
            robot = new Robot();
        } catch (AWTException e)
        {
        }
    }
    
    @Test
    public void VacioBotonDisponible()
    {
        robot.delay(TestUtilVentanas.getDelay());
        controladorLogin = new ControladorLogin();
    	robot.delay(0);
    	JTextField nombre = (JTextField) TestUtilVentanas.getComponentForName(controladorLogin.getVista(), "textField_Nombre");
    	JButton ingresar = (JButton) TestUtilVentanas.getComponentForName(controladorLogin.getVista(), "btnIngresar");
        
    	TestUtilVentanas.clickComponent(nombre, robot);
    	TestUtilVentanas.tipeaTexto("", robot);
       
        Assert.assertFalse("El boton de login deberia estar deshablitado", ingresar.isEnabled());
    }
    
    @Test 
     public void NombreUserVacio() {
    	controladorLogin = new ControladorLogin();
    	robot.delay(0);
    	JTextField nombre = (JTextField) TestUtilVentanas.getComponentForName(controladorLogin.getVista(), "textField_Nombre");
    	JTextField password = (JTextField) TestUtilVentanas.getComponentForName(controladorLogin.getVista(), "textField_Contrasenia");
    	JButton ingresar = (JButton) TestUtilVentanas.getComponentForName(controladorLogin.getVista(), "btnIngresar");
    	JLabel cartel = (JLabel)TestUtilVentanas.getComponentForName(controladorLogin.getVista(), "lblUsuarioIncorrecto");
    	JPanel panel_Nombre = (JPanel)TestUtilVentanas.getComponentForName(controladorLogin.getVista(), "panel_Nombre");
    	JLabel aux = (JLabel) panel_Nombre.getComponent(1);
    	
    	TestUtilVentanas.clickComponent(nombre, robot);
    	TestUtilVentanas.tipeaTexto("", robot);
    	TestUtilVentanas.clickComponent(password, robot);
    	TestUtilVentanas.tipeaTexto("", robot);
    	TestUtilVentanas.clickComponent(ingresar, robot);
    	
    	Assert.assertEquals("El Usuario es ta vacio", cartel.getText(),aux.getText());
    }
    
    @Test 
    public void NombreUserInvalido() {
    	controladorLogin = new ControladorLogin();
    	robot.delay(0);
    	JTextField nombre = (JTextField) TestUtilVentanas.getComponentForName(controladorLogin.getVista(), "textField_Nombre");
    	JButton ingresar = (JButton) TestUtilVentanas.getComponentForName(controladorLogin.getVista(), "btnIngresar");
    	JLabel cartel = (JLabel)TestUtilVentanas.getComponentForName(controladorLogin.getVista(), "lblUsuarioIncorrecto");
    	JPanel panel = (JPanel)TestUtilVentanas.getComponentForName(controladorLogin.getVista(), "panel_Nombre");
    	JLabel aux = (JLabel) panel.getComponent(1);
    	
    	TestUtilVentanas.clickComponent(nombre, robot);
    	TestUtilVentanas.tipeaTexto("zzz", robot);
    	TestUtilVentanas.clickComponent(ingresar, robot);
    	
    	Assert.assertEquals("El Usuario es incorrecto", cartel.getText(),aux.getText());
   }
    
   @Test  
    public void PasswordVacio() {
		controladorLogin = new ControladorLogin();
    	robot.delay(0);
    	JTextField nombre = (JTextField) TestUtilVentanas.getComponentForName(controladorLogin.getVista(), "textField_Nombre");
    	JTextField password = (JTextField) TestUtilVentanas.getComponentForName(controladorLogin.getVista(), "textField_Contrasenia");
    	JButton ingresar = (JButton) TestUtilVentanas.getComponentForName(controladorLogin.getVista(), "btnIngresar");
    	JLabel cartel = (JLabel)TestUtilVentanas.getComponentForName(controladorLogin.getVista(), "lblPasswordIncorrecto");
    	JPanel panel = (JPanel)TestUtilVentanas.getComponentForName(controladorLogin.getVista(), "panel_Contrasenia");
    	JLabel aux = (JLabel) panel.getComponent(1);
    	TestUtilVentanas.clickComponent(nombre, robot);
    	TestUtilVentanas.tipeaTexto("K", robot);
    	TestUtilVentanas.clickComponent(password, robot);
    	TestUtilVentanas.tipeaTexto("", robot);
    	TestUtilVentanas.clickComponent(ingresar, robot);
    	
    	Assert.assertEquals("La contraseña esta vacia", cartel.getText(),aux.getText());
   }
   
   /**
 * El user ya tiene que estar cargado para que esta se pueda testear bien
 */
@Test 
   public void PasswordInvalida() {
	controladorLogin = new ControladorLogin();
	Sistema.getInstance().getZonaGestionDePersonal().altaOperarioAdministrador("K","L",true);
	robot.delay(0);
	JTextField nombre = (JTextField) TestUtilVentanas.getComponentForName(controladorLogin.getVista(), "textField_Nombre");
	JTextField password = (JTextField) TestUtilVentanas.getComponentForName(controladorLogin.getVista(), "textField_Contrasenia");
	JButton ingresar = (JButton) TestUtilVentanas.getComponentForName(controladorLogin.getVista(), "btnIngresar");
	JLabel cartel = (JLabel)TestUtilVentanas.getComponentForName(controladorLogin.getVista(), "lblPasswordIncorrecto");
	JPanel panel = (JPanel)TestUtilVentanas.getComponentForName(controladorLogin.getVista(), "panel_Contrasenia");
	JLabel aux = (JLabel) panel.getComponent(1);
	
	TestUtilVentanas.clickComponent(nombre, robot);
	TestUtilVentanas.tipeaTexto("K", robot);
	TestUtilVentanas.clickComponent(password, robot);
	TestUtilVentanas.tipeaTexto("zzzz", robot);
	TestUtilVentanas.clickComponent(ingresar, robot);
	
	Assert.assertEquals("La contraseña es incorrecta", cartel.getText(),aux.getText());
  }    

@Test 
public void DatosCorrectos() {
	controladorLogin = new ControladorLogin();
	Sistema.getInstance().getZonaGestionDePersonal().altaOperarioAdministrador("K","L",true);
	robot.delay(0);
	JTextField nombre = (JTextField) TestUtilVentanas.getComponentForName(controladorLogin.getVista(), "textField_Nombre");
	JTextField password = (JTextField) TestUtilVentanas.getComponentForName(controladorLogin.getVista(), "textField_Contrasenia");
	JButton ingresar = (JButton) TestUtilVentanas.getComponentForName(controladorLogin.getVista(), "btnIngresar");
	JLabel cartel = (JLabel)TestUtilVentanas.getComponentForName(controladorLogin.getVista(), "lblPasswordIncorrecto");
	JPanel panel = (JPanel)TestUtilVentanas.getComponentForName(controladorLogin.getVista(), "panel_Contrasenia");
	JLabel aux = (JLabel) panel.getComponent(1);
	
	TestUtilVentanas.clickComponent(nombre, robot);
	TestUtilVentanas.tipeaTexto("K", robot);
	TestUtilVentanas.clickComponent(password, robot);
	TestUtilVentanas.tipeaTexto("L", robot);
	TestUtilVentanas.clickComponent(ingresar, robot);
	
	 Assert.assertEquals("Deberia coincidir el nombre de usuario con el nombre ingresado", "K",
			 nombre.getText());
}    


}