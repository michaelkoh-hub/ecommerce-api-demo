package com.example.ecommerce.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

// Entity - The Java Class / Bean that will be mapped to the Database using the ORM
// ORM - Object (Class, property, methods) Relational (Table, Query)  Mapping

@Entity
public class Product {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    
    private Long id;

    private String name;
    
    private String description;
    
    private double price;
    
    private int quantity;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonBackReference("category-product")
    @JoinColumn(name="category_id") // Foreign key
    private Category category;
	
    // Defining many to many relation
    // There wull be an additional table created, which is called product_tag
    // Inside product_tage, there will to colum-product_id, tag_id -> Pivot table
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(
        name = "product_tag",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags;

    
    // Getters and setters
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Set<Tag> getTags() {
		return tags;
	}
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
    
	
}
