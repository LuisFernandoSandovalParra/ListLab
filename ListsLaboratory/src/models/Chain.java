package models;

import java.util.Comparator;

import structures.SimpleList;

public class Chain {
	private SimpleList<Warehouse> warehouseList;

	public Chain() {
		this.warehouseList = new SimpleList<Warehouse>(new Comparator<Warehouse>() {

			@Override
			public int compare(Warehouse w1, Warehouse w2) {
				return w1.getNameWarehouse().compareToIgnoreCase(w2.getNameWarehouse());
			}
		});
	}

	private void createWarehouse(Warehouse warehouse) {
		warehouseList.insert(warehouse);
	}

	public boolean checkCreationWarehouse(Warehouse warehouse) {
		if (warehouseList.exist(warehouse)) {
			return false;
		} else {
			createWarehouse(warehouse);
			return true;
		}
	}

	public int getTotalInventaryWhValue(String warehouseName) throws NullPointerException {
		if (getWarehouse(warehouseName) == null) {
			throw new NullPointerException();
		} else {
			return getWarehouse(warehouseName).getInventaryTotalValue();
		}
	}

	public Warehouse getWarehouse(String warehouseName) {
		return warehouseList.getNode(new Warehouse(warehouseName)).getValue();
	}

	// Metodos fachada.
	public boolean checkAddProduct(Warehouse warehouse, Product product) {
		return warehouseList.getNode(warehouse).getValue().checkAddProduct(product);
	}

	public Product getProduct(Warehouse warehouse, int code) {
		return warehouseList.getNode(warehouse).getValue().getProduct(code);
	}

	public int getNumDifferentProduct(String warehouseName) {
		return warehouseList.getNode(new Warehouse(warehouseName)).getValue().getNumDifferentProduct();
	}

	public void registerProductSale(Warehouse warehouse, int code, int quantity) throws Exception {
		warehouseList.getNode(warehouse).getValue().registerProductSale(code, quantity);
	}

	public String showListWarehouse() {
		return warehouseList.show();
	}

	public String showListProduct(String warehouseName) throws Exception {
		return warehouseList.getNode(new Warehouse(warehouseName)).getValue().showListProduct();
	}

	public String showProduct(String warehouse, int code) throws Exception {
		return warehouseList.getNode(new Warehouse(warehouse)).getValue().getProduct(code).toString();
	}
}