package pruebasUnitarias;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modelo.Cliente;
import modelo.Configventa;
import modelo.Factura;
import modelo.Producto;

public class Todo1Test {
	Configventa cv = new Configventa(0, 0, 0, 0);
	Cliente c = new Cliente(null, null, 0, null, null, null, null, 0, 0);
	Factura f = new Factura(0, null, 0, null, null);
	Producto p = new Producto(0, null, null, null, null, null, null, 0, 0);
	
	@Before
	public void llenarConfig() {
		cv.setConsumo(10);
		cv.setFidelidad(5);
		cv.setGanancia(30);
		cv.setImpuesto(16);
		c.setAcumConsumo(30000.00);
		p.setStock(10);
		p.setDefectuoso(4);
	}
	
	@Test
	public void testConsumoProm() {
		Double resultado = cv.calcularIva(100.0);
		Double esperado = 16.0;
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testCalcDescuento() {
		Double resultado = cv.calcularDescuento(100, 100000.00);
		Double esperado = 15000.0;
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testCalcGanancia() {
		Double resultado = cv.calcularGanancia(10000);
		Double esperado = 13000.0;
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testActConsumo() {
		c.actConsumo(100.00);
		Double resultado = c.getAcumConsumo();
		Double esperado = 30100.00;
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testCalcMontoPago() {
		Double resultado = f.calcularMontoPago(cv.calcularIva(20000.00), 20000.00);
		Double esperado = 23200.00;
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testCalcPrecioProducto() {
		Double resultado = f.calcularMontoProducto(3, 1000.00);
		Double esperado = 3000.00;
		assertEquals(esperado, resultado);
	}

	@Test
	public void testVentaStock() {
		int resultado = p.ventaStock(2);
		int esperado = 8;
		p.setStock(esperado);
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testActStock() {
		int resultado = p.actualizarStock(10);
		int esperado = 20;
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testCalStock() {
		int resultado = p.calcularStock();
		int esperado = 6;
		assertEquals(esperado, resultado);
	}
		
	
}
