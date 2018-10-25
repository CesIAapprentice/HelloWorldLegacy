package net.java.spring.model;

public class Item {

	private ProductModel product;
	private int quantity;

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Item() {
	}

	public Item(ProductModel product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

}

