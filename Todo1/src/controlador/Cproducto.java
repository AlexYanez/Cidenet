package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import modelo.Configventa;
import modelo.Producto;
import vista.Vproducto;

public class Cproducto {
	
	Producto p[] = {new Producto(0, null, null, null, null, null, null, 0, 0)};
	Vproducto vp = new Vproducto();
	
	public Cproducto(Producto[] p, Vproducto vp) {
		super();
		this.p = p;
		this.vp = vp;	
		this.vp.addRegistrarListener(new registrarProducto());
		this.vp.addGuardarListener(new guardarProducto());
		this.vp.addBuscarListener(new buscarProducto());
		vp.setVisible(true);
	}
	
	// Registrar un producto en el vector
	class registrarProducto implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				if (vp.textCosto.getText().isEmpty() || vp.textStockNew.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos");
				else {
					Configventa cgv = new Configventa(0, 0, 0, 0);
				
					//Esta instrucción calcula el precio del producto de acuerdo a la ganancia fijada
					Double precio = cgv.calcularGanancia(Double.valueOf(vp.textCosto.getText()));
			
					//Instrucciones para guardar valores en memoria
					int x = p.length;
					p[x].setProductoID(x); //Le asigna un ID el producto y será almacenado en la misma posición del vector
					p[x].setDescripcion(vp.textDescripcion.getText());
					p[x].setMarca(vp.mark);
					p[x].setModelo(vp.model);
					p[x].setCosto(Double.valueOf(vp.textCosto.getText()));
					p[x].setPrecio(precio);
					p[x].setProveedor(vp.prov);
					p[x].setDefectuoso(Integer.valueOf(vp.textDefectuso.getText()));
					p[x].setStock(Integer.valueOf(vp.textStockNew.getText()));
				
					JOptionPane.showMessageDialog(null, "Su producto ha sido registrado");
					vp.Limpiar();
				} //endelse
			} catch (Exception error) {
				JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos");
			}
		} //endvoid
	} //endclass
	
	// Guardar datos actualizados de un producto en el vector
		class guardarProducto implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				try {
					if (vp.textProductoID.getText().isEmpty())
						JOptionPane.showMessageDialog(null, "Debe indicar el producto a actualizar");
					else
					{
						//Instrucciones para actualizar valores
						int pos = Integer.valueOf(vp.textProductoID.getText()); //Obtengo la posición donde está almacenado el producto
						p[pos].setDefectuoso(Integer.valueOf(vp.textDefectuso.getText())); //Asigno la cantidad de unidades defectuosas
						p[pos].actualizarStock(Integer.valueOf(vp.textStockNew.getText())); //Actualizo el stock
					
						JOptionPane.showMessageDialog(null, "Su producto ha sido actualizado");
						vp.Limpiar();
					} //end else
				} // end try
				catch (Exception error) {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error, consulte soporte técnico");
				}
			} //endvoid
		} //endclass
		
	
	// Buscar un producto en el vector y extraerlos para la vista
	class buscarProducto implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				//Se valida que hayan datos para buscar
				if (vp.textProductoID.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos");
				else
					//Realiza una búsqueda por todo el vector del producto
					for (int k =0; k < p.length; k++) 
						if (Integer.valueOf(vp.textProductoID.getText()) == p[k].getProductoID()){
							//Si lo encuentra, extrae los valores de memoria para la vista
							vp.textDescripcion.setText(p[k].getDescripcion());
							vp.comboMarca.setSelectedIndex(auxMarca(k));
							vp.comboModelo.setSelectedIndex(auxModelo(k));
							vp.textCosto.setText(String.valueOf(p[k].getCosto()));
							vp.textPrecio.setText(String.valueOf(p[k].getPrecio()));
							vp.comboProveedor.setSelectedIndex(auxProveedor(k));
							vp.textDefectuso.setText(String.valueOf(p[k].getDefectuoso()));
							vp.textStockDisp.setText(String.valueOf(p[k].calcularStock()));
							vp.textStockNew.setText(null);
					}
					//Si llega a la última posición emite un mensaje de no haberlo encontrado
					else if (k==p.length) {
							JOptionPane.showMessageDialog(null, "Producto no encontrado");
							break;
					}
				} //Fin Try
			catch (Exception error){
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error, consulte soporte técnico");
			}
		} //end void
	} //endclass
	
	
//Metodos auxiliares
	// Metodo auxiliar para convertir la ciudad en JcomboBox
	public int auxMarca(int pos) {
		int mark = 0;
		switch (p[pos].getMarca()) {
		case "Adidas":
			mark=0;
			break;
		case "Nike":
			mark=1;
			break;
		case "Tommy":
			mark=2;
			break;
		case "Boss":
			mark=3;
			break;
		}
		return mark;
	}
	// Metodo auxiliar para convertir el modelo en JcomboBox
	public int auxModelo(int pos) {
		int model = 0;
		switch (p[pos].getModelo()) {
		case "T-Spiderman":
			model=0;
			break;
		case "Captain America":
			model=1;
			break;
		case "Ci-Batman":
			model=2;
			break;
		case "T-1000":
			model=3;
			break;
		}
		return model;
	}
	
	// Metodo auxiliar para convertir el Proveedor en JcomboBox
	public int auxProveedor(int pos) {
		int prov = 0;
		switch (p[pos].getProveedor()) {
		case "Modasoft":
			prov=0;
			break;
		case "Medalca":
			prov=1;
			break;
		case "Clothes Import":
			prov=2;
			break;
		case "Superestrella":
			prov=3;
			break;
		}
		return prov;
	}

}
