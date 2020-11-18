package models;

import java.util.Comparator;

import structures.Node;

public class ProductComparatorOrder implements Comparator<Product>{

	public int compare(Product o1, Product o2) {
		return o1.getCode() < o2.getCode() ? 0:1;
	}
}