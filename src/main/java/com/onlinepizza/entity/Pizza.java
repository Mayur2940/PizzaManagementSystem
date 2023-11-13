package com.onlinepizza.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pizzaId;
	@OneToOne
	private PizzaType pizzaType;

	@NotBlank(message = "Pizza name cannot be blank")
	private String pizzaName;

	@NotBlank(message = "Pizza description cannot be blank")
	private String pizzaDescription;

	@NotNull(message = "Pizza cost cannot be null")
	@Positive(message = "Pizza cost must be a positive value")
	private Double pizzaCost;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Pizza size cannot be null")
	private PizzaSize pizzaSize;
	/*
	 * @OneToOne // @JoinColumn(name = "pizzaId") private Toppings toppings;
	 */

}
