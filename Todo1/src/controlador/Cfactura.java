package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.Cliente;
import modelo.Configventa;
import modelo.Factura;
import modelo.Producto;
import vista.Vfactura;

public class Cfactura {
	
	Factura f[] = {new Factura(0, null, 0, null, 0.0)};
	Vfactura vf = new Vfactura();
	Producto p[] = {new Producto(0, null, null, null, null, null, null, 0, 0)};
	Cliente c[] = {new Cliente(null, null, 0, null, null, null, null, 0, 0)};
	Configventa cv = new Configventa(0, 0, 0, 0);
	
	int pro = 0; //Posición del producto que se tiene
	int cli = 0; //Posición del cliente que se tiene
	int auxID[], auxCant[]; //Vectores auxiliares para almacenar temporalmente el ID del Producto
	DefaultTableModel model; //Declaramos esta variable para manipular la tabla
	
	public Cfactura(Factura[] f, Vfactura vf) {
		super();
		this.f = f;
		this.vf = vf;
		this.vf.addAgregarListener(new agregarProducto());
		this.vf.addBuscarListener(new buscarCliente());
		this.vf.addVerListener(new verProducto());
		this.vf.addQuitarListener(new quitarProducto());
		this.vf.addProcesarListener(new procesarCompra());
		vf.textFacturaID.setText(String.valueOf(f.length)); //Establecemos el valor de la factura por defecto
	}

		// Registrar una Factura en el vector
		class agregarProducto implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				try {
					//Sentencia para verificar que los campos necesarios estén llenos
					if (vf.textProductoID.getText().isEmpty() || vf.textClienteID.getText().isEmpty() || vf.textDescripcion.getText().isEmpty() || vf.cant == 0)
						JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos");
					else
						//Sentencia para verificar que haya stock suficiente
						if (vf.cant > p[pro].getStock())
							JOptionPane.showMessageDialog(null, "No existen suficientes productos, quedan:" + p[pro].getStock());
						//Si todo cumple, el producto se agrega a la tabla
						else {
							Double montoProducto = f[f.length].calcularMontoProducto(vf.cant, p[pro].getPrecio()); //Instrucción para calcular el monto a pagar por producto (Precio * Cantidad)
						
							//Agregar contenido a la Jtable (existe otro método más sofisticado, pero no funcionó)
							vf.tableFactura.setValueAt(vf.cant, vf.i, 0);
							vf.tableFactura.setValueAt(vf.textDescripcion.getText(), vf.i, 1);
							vf.tableFactura.setValueAt(montoProducto, vf.i, 2);
						
							auxID[vf.i] = Integer.valueOf(vf.textProductoID.getText()); //Almacenamos temporalmente el ID del Producto agregado
							auxCant[vf.i] = Integer.valueOf(vf.comboCantidad.getSelectedIndex()); //Almacenamos temporalmente la cantidad de Productos
							vf.i++; //Contador referencia de los campos llenados en la tabla
					
							//Vaciamos los campos para agregar un nuevo producto
							vf.textProductoID.setText(null);
							vf.textDescripcion.setText(null);
					
							cargarValores(); // Muestra los valores númericos en pantalla en tiempo real
						} //endelse
				} catch (Exception error) {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error, consulte a soporte técnico");
				}
			} //endvoid
		} //endclass
		
		// Buscar un cliente
		class buscarCliente implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				try {
					if (vf.textClienteID.getText().isEmpty())
						JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos");
					else
						for (int x =0; x < c.length ; x++)
							if (Integer.valueOf(vf.textProductoID.getText()) == p[x].getProductoID()){
								vf.textNombre.setText(c[x].getNombres()); // Si el cliente está, lo muestra
								cli = x; // Posición del cliente que se tiene
							}
							else
								if (x==c.length) {
									JOptionPane.showMessageDialog(null, "Cliente no encontrado");
									break;
							}
				} catch (Exception error) {
					JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos");
				}
			} //endvoid
		} //endclass
		
		// Buscar un producto
		class verProducto implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				try {
					if (vf.textProductoID.getText().isEmpty())
						JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos");
					else
						for (int k =0; k < p.length ; k++)
							if (Integer.valueOf(vf.textProductoID.getText()) == p[k].getProductoID()){
								vf.textDescripcion.setText(p[k].getDescripcion()); // Si el producto está, lo muestra
								pro = k; // Posición del producto que se tiene
							}
							else
								if (k==p.length) {
									JOptionPane.showMessageDialog(null, "Producto no encontrado");
									break;
								}
			
				} catch (Exception error){
					JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos");
				}
			} //endvoid
		} //endclass
		
		// Instrucciones para remover un elemento de la tabla Factura
		class quitarProducto implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				try {
					model = (DefaultTableModel) vf.tableFactura.getModel();
			        int a = vf.tableFactura.getSelectedRow();
			        //Tomamos la fila seleccionada y validamos
			        if (a<0){ 
			                JOptionPane.showMessageDialog(null, 
			                "Debe seleccionar una fila de la tabla" ); 
			          }
			        else {
			        		// Confirmación para eliminar producto de la tabla
			        	  	int confirmar=JOptionPane.showConfirmDialog(null, "Esta seguro que desea Eliminar el registro? "); 
			        	  	if(JOptionPane.OK_OPTION==confirmar) {
			        	  		model.removeRow(a);
			        	  		vf.i = vf.i-1;		
			        	  		JOptionPane.showMessageDialog(null,"Registro Eliminado" );
			        	  	} 
			        	  cargarValores(); //Actualizamos el monto de los equipo agregados tras remover uno
			        }
				} catch (Exception error) {
					JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos");
				}
			}
		}	
		
		class procesarCompra implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					try {
						//Si no hay valores en la tabla
						if (vf.i == 0)
							JOptionPane.showMessageDialog(null, "No existen productos asignados para la compra");
						else
						{
							String emp = vf.determinarEmpleado(vf.comboEmpleado.getSelectedIndex()); //Extrae el nombre del empleado llamando al metodo de conversión
							String mp = vf.determinarMedPago(vf.comboPago.getSelectedIndex()); //Extrae el nombre del medio de pago llamando al metodo de conversión
						
							//Almacenamos datos de factura en memoria
							f[f.length].setCodFactura(f.length);
							f[f.length].setEmpleado(emp);
							f[f.length].setTipoPago(mp);
							f[f.length].setCantidad((int) Math.round(vf.sumarColumna(0)));
							f[f.length].setTotalpagar(Double.valueOf(vf.textTotal.getText()));
						
							//Almacenamos datos de cliente en memoria
							c[cli].actContCompras();
							c[cli].actConsumo(Double.valueOf(vf.textTotal.getText()));
						
							//Actualizamos datos de Producto en memoria
							for (int q=0; q< vf.i;q++)
							{
								p[auxID[q]].ventaStock(auxCant[q]); // Esta instrucción toma el ID (posición) de cada producto almacenado y le actualiza el stock
							}
													
							JOptionPane.showMessageDialog(null, "Su factura ha sido procesada" + "Su monto a pagar: " + vf.textTotal.getText());
							vf.limpiar();
						}
					}
					catch (Exception error) {
						JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos");
					}
				} //Endvoid
		} //Endclass
		
		// Metodo de apoyo para cargar valores numéricos a la Factura
		public void cargarValores() {
			Double columna = vf.sumarColumna(2); //Calcula los productos agregados
			Double iva = cv.calcularIva(columna); //Calcula el iva (Es independiente del descuento)
			Double acumCompra = c[cli].getAcumConsumo(); //Extae las compras acumuladas del cliente
			int contVisitas = c[cli].getContCompras(); //Extrae las visitas acumuladas del cliente
			Double descuento = cv.calcularDescuento(contVisitas, acumCompra); //Calcula el descuento
			Double subtotal = f[f.length].calcularMontoPago(iva, columna-descuento); // Calcula el monto a pagar
			
			vf.textDescuento.setText(String.valueOf(descuento)); // Muestra el monto del descuento
			vf.textSubTotal.setText(String.valueOf(subtotal)); // Muestra el subtotal en la pantalla
			vf.textIVA.setText(String.valueOf(iva)); // Muestra el IVA en la pantalla
			Double t = f[f.length].calcularMontoPago(cv.calcularIva(columna),columna); // Calcula el monto a pagar
			vf.textTotal.setText(String.valueOf(t)); // Muestra el total a pagar
		}
		
	
}
