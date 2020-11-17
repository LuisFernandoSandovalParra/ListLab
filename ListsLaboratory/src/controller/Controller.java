package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.Chain;
import models.Product;
import models.Warehouse;
import views.JMainFrame;

public class Controller implements ActionListener {
	private Chain chain;
	private JMainFrame mainFrame;

	public Controller() {
		chain = new Chain();
		mainFrame = new JMainFrame(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Event.valueOf(e.getActionCommand())) {
		case BTN_CHAIN:
			mainFrame.createPanelChain(this);
			break;
		case BTN_WAREHOUSE:
			mainFrame.createPanelWarehouse(this);
			break;
		case BTN_BACK_MAIN_PANEL:
			mainFrame.createPanelMain(this);
			break;
		case BTN_CHAIN_CONTINUE:
			createChainContinue();
			break;
		case BTN_BACK_MENU_CHAIN:
			mainFrame.createPanelChain(this);
			break;
		case BTN_CHAIN_CREATE:
			createWarehouse();
			break;
		case BTN_WAREHOUSE_CONTINUE:
			createWarehouseContinue();
			break;
		case BTN_BACK_MENU_WAREHOUSE:
			mainFrame.createPanelWarehouse(this);
			break;
		case BTN_CREATE_PRODUCT:
			createProduct();
			break;
		case BTN_SEARCH_PRODUCTO:
			searchProductInfo();
			break;
		case BTN_QUANTIFIED_PRODUCTS:
			showNumDifferentProduct();
			break;
		case BTN_CALCULATE_INVENTARY_VALUE:
			showTotalInvetaryValue();
			break;
		case BTN_SHOW_PRODUCTS_PS:
			showProductsPS();
			break;
		case BTN_REGISTER_SOLD_PRODUCT:
			registerSoldProduct();
			break;
		default:
			break;
		}
	}

	private void createChainContinue() {
		try {
			switch (mainFrame.getSpaceOptionChain()) {
			case 1:
				mainFrame.createPanelChainForm(this);
				break;
			case 2:
//				mainFrame.createPanelChainStats(this, chain.getTotalWarehouseValue());
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcion no valida");
				break;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Digite unicamente numeros");
		}
	}

	private void createWarehouse() {
		if (chain.checkCreationWarehouse(new Warehouse(mainFrame.getNameChainForm(), mainFrame.getAddressChainForm()))) {
			JOptionPane.showMessageDialog(null, "Proceso de creacion exitoso");
			mainFrame.createPanelChain(this);
		} else {
			JOptionPane.showMessageDialog(null, "El almacen ya existe");
			mainFrame.createPanelChain(this);
		}

	}

	private void createWarehouseContinue() {
		try {
			switch (mainFrame.getSpaceOptionWarehouse()) {
			case 1:
				mainFrame.createPanelProductForm(this, chain.showListWarehouse());
				break;
			case 2:
				mainFrame.createPanelProductInfo(this, chain.showListWarehouse());
				break;
			case 3:
				mainFrame.createPanelQuantifiedProduct(this, chain.showListWarehouse());
				break;
			case 4:
				mainFrame.createPanelShowTotalInventary(this, chain.showListWarehouse());
				break;
			case 5:
				mainFrame.createPanelProductSold(this, chain.showListWarehouse());
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcion no valida");
				break;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Digite unicamente numeros");
		}
		
	}

	private void createProduct() {
		try {
			if (chain.checkAddProduct(new Warehouse(mainFrame.getNameWarehouseField()),
					new Product(mainFrame.getCodeProductField(), mainFrame.getNameProductField(),
							mainFrame.getQuantityProductField(), mainFrame.getValueProductField()))) {
				JOptionPane.showMessageDialog(null, "Proceso de creacion exitoso");
				mainFrame.createPanelWarehouse(this);
			} else {
				JOptionPane.showMessageDialog(null, "El Producto ya existe");
				mainFrame.createPanelWarehouse(this);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Digite unicamente numeros");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Proceso de creacion ha fallado");
		}
		
	}

	private void searchProductInfo() {
		try {
			mainFrame
					.setProductInfo(chain.showProduct(mainFrame.getNameWarehouseProduct(), mainFrame.getCodeProduct()));
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "Digite unicamente numeros");
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "El producto buscado no existe");
		}
	}
	
	private void showNumDifferentProduct() {
		try {
			mainFrame.setProductListSpace(chain.showListProduct(mainFrame.getNameWarehouseQF()));
			mainFrame.setTotalQuantifiedProduct(chain.getNumDifferentProduct(mainFrame.getNameWarehouseQF()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Digite el nombre del almacen");
		}
		
	}
	
	private void showTotalInvetaryValue() {
		try {
			mainFrame.setTotalInventaryValue(chain.getTotalInventaryWhValue(mainFrame.getNameWarehouseSTI()));
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "El almacen no existe.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void showProductsPS() {
		try {
			mainFrame.setProductListSpacePS(chain.showListProduct(mainFrame.getNameWarehousePS()));
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "No existen los productos");
		}
	}

	private void registerSoldProduct() {
		try {
			chain.registerProductSale(new Warehouse(mainFrame.getNameWarehousePS()), mainFrame.getCodeProductFieldPS(),
					mainFrame.getQuantityProductFieldPS());
			showProductsPS();
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "El producto no existe");
		} catch (NumberFormatException e2) {
			JOptionPane.showMessageDialog(null, "Digite unicamente numeros.");
		} catch (Exception e3) {
			JOptionPane.showMessageDialog(null, "La cantidad solicitada no esta disponible.");
		}
	}

	public static void main(String[] args) {
		Controller c = new Controller();
		c.chain.checkCreationWarehouse(new Warehouse("Makro", "21357"));
		c.chain.checkCreationWarehouse(new Warehouse("Olimpica", "1232d"));
		c.chain.checkCreationWarehouse(new Warehouse("Carrefour", "543232"));
		c.chain.checkCreationWarehouse(new Warehouse("Metro", "43221"));
		c.chain.checkCreationWarehouse(new Warehouse("Alkosto", "2132s"));
		c.chain.checkCreationWarehouse(new Warehouse("Katronix", "d12sda"));
		c.chain.checkCreationWarehouse(new Warehouse("Viva", "asda"));
		c.chain.checkAddProduct(new Warehouse("makro"), new Product(1, "Arroz", 20, 2000));
		c.chain.checkAddProduct(new Warehouse("makro"), new Product(2, "Sal", 10, 1000));
		c.chain.checkAddProduct(new Warehouse("makro"), new Product(3, "Arbeja", 30, 800));
		c.chain.checkAddProduct(new Warehouse("Olimpica"), new Product(1, "Arroz", 20, 2000));;
		c.chain.checkAddProduct(new Warehouse("Olimpica"), new Product(2, "Sal", 10, 1000));
		c.chain.checkAddProduct(new Warehouse("Olimpica"), new Product(3, "Arbeja", 30, 800));
	}
}