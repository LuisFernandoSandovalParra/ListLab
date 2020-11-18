package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import controller.Event;

public class JPanelProductPerWarehouse extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea productListSpace;
	private JTextField nameWarehouseField, codeProductField, quantityProductField;
	

	public JPanelProductPerWarehouse(ActionListener actionListener, String showListWarehouse) {
		setLayout(new BorderLayout());
		initComponents(actionListener, showListWarehouse);
	}

	private void initComponents(ActionListener actionListener, String showListWarehouse) {
		createBackBtnAndTitlePanel(actionListener);
		createGeneralVisorPanel(actionListener, showListWarehouse);
	}
	
	private void createBackBtnAndTitlePanel(ActionListener actionListener) {
		JPanel backBtnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 80, 25));
		backBtnPanel.add(
				new JButtonFormat(actionListener, Event.BTN_BACK_MENU_WAREHOUSE.name(), ConstantsGUI.BACK_TEXT_BTN));

		JLabel title = new JLabel(ConstantsGUI.SUBTITLE_PRODUCT);
		title.setFont(ConstantsGUI.FONT_SUBTITLES);
		backBtnPanel.add(title);

		add(backBtnPanel, BorderLayout.NORTH);
	}

	private void createGeneralVisorPanel(ActionListener actionListener, String warehouseName) {
		JPanel generalVisor = new JPanel(new BorderLayout());
		createVisorWarehouse(generalVisor, warehouseName);
		createVisorProduct(generalVisor);
		createSpaceRegister(actionListener, generalVisor);
		add(generalVisor, BorderLayout.CENTER);
	}

	private void createVisorWarehouse(JPanel generalVisor, String warehouseName) {
		JTextArea warehouseInfo = new JTextArea(warehouseName);
		warehouseInfo.setRows(3);
		warehouseInfo.setOpaque(false);
		warehouseInfo.setEditable(false);
		warehouseInfo.setBorder(null);
		warehouseInfo.setFont(ConstantsGUI.FONT_MENUS);
		JScrollPane scrollPane = new JScrollPane(warehouseInfo);
		scrollPane.setBorder(ConstantsGUI.BORDER_AREA_WAREHOUSES);
		generalVisor.add(scrollPane, BorderLayout.NORTH);
	}

	private void createVisorProduct(JPanel generalVisor) {
		productListSpace = new JTextArea();
		productListSpace.setRows(3);
		productListSpace.setOpaque(false);
		productListSpace.setEditable(false);
		productListSpace.setBorder(null);
		productListSpace.setFont(ConstantsGUI.FONT_MENUS);
		JScrollPane scrollPane = new JScrollPane(productListSpace);
		scrollPane.setBorder(ConstantsGUI.BORDER_AREA_PRODUCTS);
		generalVisor.add(scrollPane, BorderLayout.CENTER);
	}

	private void createSpaceRegister(ActionListener actionListener, JPanel generalVisor) {
		JPanel warehouseNamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
		warehouseNamePanel.setBorder(ConstantsGUI.BORDER_ZONE_NAME);

		nameWarehouseField = new JTextField(18);
		nameWarehouseField.setBorder(BorderFactory.createTitledBorder(null, ConstantsGUI.TEXT_BORDER_JTEXTFIELD_NAME,
				TitledBorder.LEFT, TitledBorder.ABOVE_TOP));
		warehouseNamePanel.add(nameWarehouseField);
		
		JButtonFormat btnShowProducts = new JButtonFormat(actionListener, Event.BTN_SHOW_PRODUCT_WAREHOUSE_PS.name(),
				"Ver");
		warehouseNamePanel.add(btnShowProducts);

		generalVisor.add(warehouseNamePanel, BorderLayout.SOUTH);
	}

	public void setProductListSpace(String productList) {
		productListSpace.setText(productList);
	}

	public String getNameWarehouse() {
		return nameWarehouseField.getText();
	}

	public int getCodeProductField() {
		return Integer.parseInt(codeProductField.getText());
	}

	public int getQuantityProductField() {
		return Integer.parseInt(quantityProductField.getText());
	}

}
