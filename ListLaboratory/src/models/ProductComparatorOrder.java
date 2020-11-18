package models;

import java.util.Comparator;

import structures.Node;

public class ProductComparatorOrder implements Comparator<Product>{

	public int compare(Product o1, Product o2) {
		System.out.println(o1.getCode());
		System.out.println(o2.getCode());
		return o1.getCode() < o2.getCode() ? 0:1;
	}
}