package models;

import java.util.Comparator;

import structures.DoubleList;

public class Warehouse {
	private DoubleList<Product> inventary;
	private String warehouseName;
	private int inventaryTotalValue;

	public Warehouse(String nameWarehouse, String address) {
		this.inventaryTotalValue = 0;
		this.warehouseName = nameWarehouse;
		this.inventary = new DoubleList<>(new Comparator<Product>() {

			@Override
			public int compare(Product p1, Product p2) {
				return p1.getCode() - p2.getCode();
			}
		});
	}

	public Warehouse(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	private void addProduct(Product product) {
		inventary.insert(product);
		insertTotalInventaryValue(product);
	}

	public boolean checkAddProduct(Product product) {
		if (inventary.exist(product)) {
			return false;
		} else {
			addProduct(product);
			return true;
		}
	}

	// TENER EN CUENTA ESTE METODO DE RECARGAR ALGUN PRODUCTO.
	public void rechargeProduct(int code, int quantity) {
		if (getProduct(code) != null) {
			getProduct(code).setQuantity(getProduct(code).getQuantity() + quantity);
			insertTotalInventaryValue(getProduct(code));
		} else {
			System.out.println("El producto no existe o esta agotado");
		}
	}

	// TENER PENDIENTE ESTE METODO DE SUMAR EL VALOR TOTAL DEL INVENTARIO.
	private void insertTotalInventaryValue(Product product) {
		inventaryTotalValue += product.getUnitValue() * product.getQuantity();
	}

	public Product getProduct(int code) {
		return inventary.getNode(new Product(code)).getValue();
	}
	
	//ESTE METODO OBTIENE LA CANTIDAD DE PRODUCTOS DISTINTOS EN INVENTARIO
	public int getNumDifferentProduct() {
		return inventary.showLength();
	}

	public void registerProductSale(int code, int quantity) throws Exception {
		if(getProduct(code).getQuantity() - quantity < 0) {
			throw new Exception();
		}else {
			this.getProduct(code).setQuantity(getProduct(code).getQuantity() - quantity);
			substractSaleValue(getProduct(code), quantity);
		}
	}

	// ESTE METODO RESTA LA CANTIDAD DE PRODUCTO PARA REGISTRAR UNA VENTA
	private void substractSaleValue(Product product, int quantity) {
		inventaryTotalValue -= product.getUnitValue() * quantity;
	}

	public String showListProduct() {
		return inventary.showForward();
	}

	public String getNameWarehouse() {
		return warehouseName;
	}

	public int getInventaryTotalValue() {
		return inventaryTotalValue;
	}

	@Override
	public String toString() {
		return "Nombre almacen|:  " + warehouseName + "\n";
	}
}