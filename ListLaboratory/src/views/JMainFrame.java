package views;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import controller.Controller;

public class JMainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMainPanel mainPanel;

	public JMainFrame(ActionListener actionListener) {
		setSize(new Dimension(ConstantsGUI.WIDTH_FRAME, ConstantsGUI.HEIGHT_FRAME));
		setTitle(ConstantsGUI.TITLE_FRAME);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(ConstantsGUI.WIDTH_FRAME, ConstantsGUI.HEIGHT_FRAME));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		initComponents(actionListener);
		setVisible(true);
	}

	private void initComponents(ActionListener actionListener) {
		mainPanel = new JMainPanel(actionListener);
		add(mainPanel);
	}
	
	public void createPanelMain(ActionListener actionListener) {
		mainPanel.createMainFirstPanel(actionListener);
	}
	
	public void createPanelChain(ActionListener actionListener) {
		mainPanel.createPanelChain(actionListener);
	}
	
	public int getSpaceOptionChain() {
		return mainPanel.getSpaceOptionChain();
	}
	
	public void createPanelChainForm(ActionListener actionListener) {
		mainPanel.createPanelChainForm(actionListener);
	}
	
	public String getNameChainForm() {
		return mainPanel.getNameChainForm();
	}
	
	public String getAddressChainForm() {
		return mainPanel.getAddressChainForm();
	}
	
	public void createPanelChainStats(ActionListener actionListener, int totalChainValue) {
		mainPanel.createPanelChainStats(actionListener, totalChainValue);
	}
	
	public void createPanelWarehouse(ActionListener actionListener) {
		mainPanel.createPanelWarehouse(actionListener);
	}
	
	public int getSpaceOptionWarehouse() {
		return mainPanel.getSpaceOptionWarehouse();
	}
	
	public void createPanelProductForm(ActionListener actionListener, String warehouseInfo) {
		mainPanel.createPanelProductForm(actionListener, warehouseInfo);
	}
	
	public String getNameWarehouseField() {
		return mainPanel.getNameWarehouseField();
	}

	public int getCodeProductField() {
		return mainPanel.getCodeProductField();
	}

	public String getNameProductField() {
		return mainPanel.getNameProductField();
	}

	public int getQuantityProductField() {
		return mainPanel.getQuantityProductField();
	}

	public int getValueProductField() {
		return mainPanel.getValueProductField();
	}
	
	public void createPanelProductInfo(ActionListener actionListener, String nameWarehouse) {
		mainPanel.createPanelProductInfo(actionListener, nameWarehouse);
	}
	
	public int getCodeProduct() {
		return mainPanel.getCodeProduct();
	}
	
	public String getNameWarehouseProduct() {
		return mainPanel.getNameWarehouseProduct();
	}
	
	public void setProductInfo(String productInfo) {
		mainPanel.setProductInfo(productInfo);
	}
	
	public void createPanelQuantifiedProduct(ActionListener actionListener, String warehouseName) {
		mainPanel.createPanelQuantifiedProduct(actionListener, warehouseName);
	}

	public void setProductListSpace(String productList) {
		mainPanel.setProductListSpace(productList);
	}

	public String getNameWarehouseQF() {
		return mainPanel.getNameWarehouseQF();
	}
	
	public void setTotalQuantifiedProduct(int quantity) {
		mainPanel.setTotalQuantifiedProduct(quantity);
	}
	
	public void createPanelShowTotalInventary(ActionListener actionListener, String warehouseName) {
		mainPanel.createPanelShowTotalInventary(actionListener, warehouseName);
	}
	
	public String getNameWarehouseSTI() {
		return mainPanel.getNameWarehouseSTI();
	}

	public void setTotalInventaryValue(int quantity) {
		mainPanel.setTotalInventaryValue(quantity);
	}
	
	public void createPanelProductSold(ActionListener actionListener, String warehouseName) {
		mainPanel.createPanelProductSold(actionListener, warehouseName);
	}
	
	public void setProductListSpacePS(String productList) {
		mainPanel.setProductListSpacePS(productList);
	}

	public String getNameWarehousePS() {
		return mainPanel.getNameWarehousePS();
	}

	public int getCodeProductFieldPS() {
		return mainPanel.getCodeProductFieldPS();
	}

	public int getQuantityProductFieldPS() {
		return mainPanel.getQuantityProductFieldPS();
	}

	public void createPanelListProductsPerWarehouse(ActionListener actionListener, String showListWarehouse) {
		mainPanel.createPanelListProductsPerWarehouse(actionListener, showListWarehouse);
	}

	public void setProductPerWarehousePS(String showListProduct) {
		mainPanel.setProductPerWarehousePS(showListProduct);
	}

	public String getNameProductPerWarehousePS() {
		return mainPanel.getNameProductPerWarehousePS();
	}
}