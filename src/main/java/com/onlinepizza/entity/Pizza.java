package com.onlinepizza.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.onlinepizza.util.PizzaSize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Pizza {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer pizzaId;
	@OneToOne
	private PizzaType pizzaType;
	private String pizzaName;
	private String pizzaDescription;
	// Base Price
	private Double pizzaCost;
	
	@Enumerated(EnumType.STRING)
	private PizzaSize pizzaSize;
	/*
	 * @OneToOne // @JoinColumn(name = "pizzaId") private Toppings toppings;
	 */
	
	
	
	
	

	

	
	
	
	
	

}
