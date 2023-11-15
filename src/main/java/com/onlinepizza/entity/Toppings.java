package com.onlinepizza.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Toppings {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer toppingsId;
	
//	@NotBlank(message = "Toppings name cannot be blank")
	private String toppingsName;
	
//	@NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be a positive value")
	private Double price;
	
//	@OneToOne(mappedBy = "toppings")
//	private Pizza pizza;
	
	
	
	
}
