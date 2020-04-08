/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Configventa {  
   
	//Inicializamos los valores para hacer pruebas unitarias
    private int impuesto;
    private int fidelidad;
    private int consumo;
    private int ganancia;
    static final double CONSUMO_MIN = 20000; //Tasa de consumo promedio de la tienda
    static final int RANGO_VISITAS = 5; //Tasa facturas emitidas al mes para descuento
    
   
    public Configventa(int impuesto, int fidelidad, int consumo, int ganancia) {
		super();
		this.impuesto = impuesto;
		this.fidelidad = fidelidad;
		this.consumo = consumo;
		this.ganancia = ganancia;
	}
    

	public int getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(int impuesto) {
		this.impuesto = impuesto;
	}

	public int getFidelidad() {
		return fidelidad;
	}

	public void setFidelidad(int fidelidad) {
		this.fidelidad = fidelidad;
	}

	public int getConsumo() {
		return consumo;
	}

	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}

	public int getGanancia() {
		return ganancia;
	}

	public void setGanancia(int ganancia) {
		this.ganancia = ganancia;
	}

	// Metodo para calcular el IVA
	public Double calcularIva(Double monto)
    { 
        double iva;               
        iva = (monto*this.getImpuesto())/100;
        return iva;
    }
	
	
	// Metodo para calcular el descuento al cliente
	public Double calcularDescuento(int visitas, double comprado) {
		double a = 0.0;
		double b = 0.0;
		if (visitas > RANGO_VISITAS) {
			a = (comprado*this.getFidelidad())/100;
		}
		if (comprado > CONSUMO_MIN) {
			b = (comprado*this.getConsumo())/100;
		}
		return a+b;
	}
	
	// Metodo para calcular la ganancia de un producto
	public Double calcularGanancia(double monto) {
		double calc = 0.0;
		calc = monto + (monto*this.getGanancia())/100;
		return calc;
	}
}

