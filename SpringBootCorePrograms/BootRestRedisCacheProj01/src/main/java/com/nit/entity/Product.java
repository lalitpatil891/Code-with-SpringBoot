package com.nit.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CACHE_PRODUCT")
@Data // Lombok: Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

	private static final long serialVersionUID = 1L; // for Serializable

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
	private Integer pid; // primary key

	@Column(length = 30) // VARCHAR(30)
	private String pname; // Product name

	private Double price; // Product price

	private Double qty; // Product quantity

}

/** When a class implements Serializable, Java converts its object into a byte
 * stream (for saving into a file, sending over network, caching, etc.).
 * 
 * During this process, Java attaches a unique serialVersionUID to the class.
 * 
 * When you later deserialize (read the object back), Java checks if the
 * serialVersionUID of the class matches the one from the saved object.
 * 
 * If they don’t match, you’ll get an InvalidClassException. */