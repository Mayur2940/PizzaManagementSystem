package com.onlinepizza.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
	private String toppingsName;
	private Double price;
//	@OneToOne(mappedBy = "toppings")
//	private Pizza pizza;
	
	
	
	
}
