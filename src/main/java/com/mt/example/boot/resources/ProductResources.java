package com.mt.example.boot.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mt.example.boot.entities.Product;
import com.mt.example.boot.services.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductResources {

	private final ProductService productService;

	@Operation(summary = "Get Products", description = "Get list of products")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Found the products list", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)) }),
			@ApiResponse(responseCode = "404", description = "Products list not found", content = @Content) })
	@GetMapping(value = "/list", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Product> getProducts() {
		return productService.getProducts();
	}

	@GetMapping("/list/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable("productId") int productId) {
		Optional<Product> productOptional = productService.getProduct(productId);
		if (productOptional.isPresent()) {
			return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(Product product) {
		productService.addProduct(product);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateProduct(Product product) {
		productService.updateProduct(product);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteProduct(int productId) {
		productService.deleteProduct(productId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
