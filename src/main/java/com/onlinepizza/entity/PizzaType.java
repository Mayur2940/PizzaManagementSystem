package com.onlinepizza.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PizzaType {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer pizzaTypeId;
	// Veg or Non-Veg
	private String pizzaType;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Toppings> toppings;
	
	
	
	
	
}
