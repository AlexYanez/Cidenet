package modelo;

public class Cliente extends Persona {
	public Cliente(String id, String sexo, String nombre, String direccion, int edad, String ciudad, String telefono) {
		super(id, sexo, nombre, direccion, edad, ciudad, telefono);
		// TODO Auto-generated constructor stub
	}

	private double acumConsumo;
	private int contCompras;
	
	
	public Cliente(String id, String nombre, int edad, String sexo, String direccion, String ciudad, String telefono,
			double acumConsumo, int contCompras) {
		super(id, sexo, nombre, direccion, edad, ciudad, telefono);
		this.acumConsumo = acumConsumo;
		this.contCompras = contCompras;
	}
	
	
	public double getAcumConsumo() {
		return acumConsumo;
	}

	public void setAcumConsumo(double acumConsumo) {
		this.acumConsumo = acumConsumo;
	}

	public int getContCompras() {
		return contCompras;
	}

	public void setContCompras(int contCompras) {
		this.contCompras = contCompras;
	}

	//Metodo para actualizar el acumulador de consumo del cliente
	public void actConsumo(double monto) {
		this.setAcumConsumo(acumConsumo+monto);
	}
	
	//Metodo para actualizar el contador de compras del cliente
	public void actContCompras() {
		this.setContCompras(contCompras++);
	}
	
}

