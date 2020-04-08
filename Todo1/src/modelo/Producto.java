package modelo;

public class Producto {
	
	private int productoID;
	private String descripcion;
	private String marca;
	private String modelo;
	private String proveedor;
	private Double costo;
	private Double precio;
	private int stock;
	private int defectuoso;
	
	
	public Producto(int productoID, String descripcion, String marca, String modelo, String proveedor, Double costo,
			Double precio, int stock, int defectuoso) {
		super();
		this.productoID = productoID;
		this.descripcion = descripcion;
		this.marca = marca;
		this.modelo = modelo;
		this.proveedor = proveedor;
		this.costo = costo;
		this.precio = precio;
		this.stock = stock;
		this.defectuoso = defectuoso;
	}
	
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Double getCosto() {
		return costo;
	}
	public void setCosto(Double costo) {
		this.costo = costo;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int getDefectuoso() {
		return defectuoso;
	}

	public void setDefectuoso(int defectuoso) {
		this.defectuoso = defectuoso;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public int getProductoID() {
		return productoID;
	}

	public void setProductoID(int productoID) {
		this.productoID = productoID;
	}
	
	//Metodo para calcular el Stock disponible
	public int calcularStock() {
		return this.stock = this.stock - this.defectuoso;
	}
	
	//Metodo para actualiar el Stock en base a compras a proveedores
	public int actualizarStock(int actualizar) {
		return this.stock = this.stock + actualizar;
	}
	
	//Metodo para descontar venta de productos en Stock
	public int ventaStock(int venta){
		return this.stock = this.stock - venta;
	}
	
}
