package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;

    // Create
    // Add a parameter categoryId so that I can retrieve the category
    // Add a parameter tagIds 
    public Product createProduct(Product product, Long categoryId, List<Long> tagIds) {
    	
    	// when i create a new product, I will get the category from category
    	// and set it to the product
    	product.setCategory(categoryService.get(categoryId));
    	
    	// When i create a new product, I will get the tags from tagIds
    	// and set it to the product
    	// transform it to Set (to ensure no repeated tags)
    	product.setTags(Set.copyOf(tagService.getByIds(tagIds)));
    	
        return productRepository.save(product);
    }

    // Read
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Read by Id
    public Product getProductById(Long id) {
    	 return productRepository.findById(id)
                 .orElseThrow(() -> new RuntimeException("Product not found"));
     }

    // Update
     public Product updateProduct(Long id, Product updatedProduct) {
         Product existing = getProductById(id);
         existing.setName(updatedProduct.getName());
         existing.setPrice(updatedProduct.getPrice());
         existing.setQuantity(updatedProduct.getQuantity());
         return productRepository.save(existing);
     }

     // Delete
     public void deleteProduct(Long id) {
         if (!productRepository.existsById(id)) {
             throw new RuntimeException("Product not found");
         }
         productRepository.deleteById(id);
     }
 }
