package models;

public class TestWarehouse {

	public static void main(String[] args) {
		Warehouse wh = new Warehouse("Makro", "Cra 2da # 17 - 146");
		wh.checkAddProduct(new Product(10, "Arroz", 20, 1000));
		wh.checkAddProduct(new Product(12, "Leche", 15, 2000));
		wh.checkAddProduct(new Product(15, "Sal", 30, 1200));
		wh.checkAddProduct(new Product(20, "Azucar", 30, 900));
		wh.checkAddProduct(new Product(21, "Lenteja", 25, 1500));
		try {
			wh.registerProductSale(15, 5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("El producto buscado es: " + wh.getProduct(15));
		System.out.println("Cantidad de productos: " + wh.getNumDifferentProduct());
		System.out.println("Lista inicial: " + wh.showListProduct());
		System.out.println("El valor total del inventario del almacen es de: " + wh.getInventaryTotalValue());
		
		try {
			wh.registerProductSale(10, 20);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("El valor total del inventario del almacen es de: " + wh.getInventaryTotalValue());
		wh.rechargeProduct(10, 50);
		System.out.println("Lista Actualizada: " + wh.showListProduct());
		System.out.println("El valor total del inventario del almacen es de: " + wh.getInventaryTotalValue());
	}

}
