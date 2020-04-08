package modelo;

public class Factura {
	
	private int codFactura;
	private String empleado;
	private int cantidad;
	private String tipoPago;
	private Double totalpagar;
	
	public Factura(int codFactura, String empleado, int cantidad, String tipoPago, Double totalpagar) {
		super();
		this.codFactura = codFactura;
		this.empleado = empleado;
		this.cantidad = cantidad;
		this.tipoPago = tipoPago;
		this.totalpagar = totalpagar;
	}

	public int getCodFactura() {
		return codFactura;
	}

	public void setCodFactura(int codFactura) {
		this.codFactura = codFactura;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Double getTotalpagar() {
		return totalpagar;
	}

	public void setTotalpagar(Double totalpagar) {
		this.totalpagar = totalpagar;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public String getEmpleado() {
		return empleado;
	}

	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}
	
	public Double calcularMontoPago(Double iva, Double subtotal){
		this.totalpagar = iva+subtotal;
		return totalpagar;
	}
	
	public Double calcularMontoProducto(int cant, Double precio) {
		return cant*precio;
	}
	

}
