package com.mt.example.boot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mt.example.boot.domains.Product;

@Service
public class ProductService {

	private static List<Product> products = new ArrayList<>();

	static {
		products.add(new Product(1, "iPhone", "Phone Device"));
		products.add(new Product(2, "iMac", "Laptop Device"));
		products.add(new Product(3, "Apple TV", "TV Device"));
		products.add(new Product(4, "iPad", "Tablet Device"));
	}

	public List<Product> getProducts() {
		return products;
	}

	public Optional<Product> getProduct(int productId) {
		return products.stream().filter(product -> product.getId() == productId).findAny();
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public void updateProduct(Product product) {
		Optional<Product> productOptional = products.stream().filter(prd -> prd.getId() == product.getId()).findAny();
		if (productOptional.isPresent()) {
			products.remove(product);
		}
		products.add(product);
	}

	public void deleteProduct(int productId) {
		Optional<Product> productOptional = products.stream().filter(prd -> prd.getId() == productId).findAny();
		if (productOptional.isPresent()) {
			products.remove(productOptional.get());
		}
	}
}
