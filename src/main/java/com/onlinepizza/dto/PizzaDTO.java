package com.onlinepizza.dto;

import java.util.Objects;

import com.onlinepizza.util.PizzaSize;

public class PizzaDTO {
	private Integer pizzaId;
	private PizzaTypeDTO pizzaType;
	private String pizzaName;
	private String pizzaDescription;
	private Double pizzaCost;
	private PizzaSize pizzaSize;
	
	public PizzaDTO() {}

	public PizzaDTO(Integer pizzaId, PizzaTypeDTO pizzaType, String pizzaName, String pizzaDescription,
			Double pizzaCost, PizzaSize pizzaSize) {
		super();
		this.pizzaId = pizzaId;
		this.pizzaType = pizzaType;
		this.pizzaName = pizzaName;
		this.pizzaDescription = pizzaDescription;
		this.pizzaCost = pizzaCost;
		this.pizzaSize = pizzaSize;
	}

	public Integer getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(Integer pizzaId) {
		this.pizzaId = pizzaId;
	}

	public PizzaTypeDTO getPizzaType() {
		return pizzaType;
	}

	public void setPizzaType(PizzaTypeDTO pizzaType) {
		this.pizzaType = pizzaType;
	}

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	public String getPizzaDescription() {
		return pizzaDescription;
	}

	public void setPizzaDescription(String pizzaDescription) {
		this.pizzaDescription = pizzaDescription;
	}

	public Double getPizzaCost() {
		return pizzaCost;
	}

	public void setPizzaCost(Double pizzaCost) {
		this.pizzaCost = pizzaCost;
	}

	public PizzaSize getPizzaSize() {
		return pizzaSize;
	}

	public void setPizzaSize(PizzaSize pizzaSize) {
		this.pizzaSize = pizzaSize;
	}

	@Override
	public String toString() {
		return "PizzaDTO [pizzaId=" + pizzaId + ", pizzaType=" + pizzaType + ", pizzaName=" + pizzaName
				+ ", pizzaDescription=" + pizzaDescription + ", pizzaCost=" + pizzaCost + ", pizzaSize=" + pizzaSize
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(pizzaCost, pizzaDescription, pizzaId, pizzaName, pizzaSize, pizzaType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PizzaDTO other = (PizzaDTO) obj;
		return Objects.equals(pizzaCost, other.pizzaCost) && Objects.equals(pizzaDescription, other.pizzaDescription)
				&& Objects.equals(pizzaId, other.pizzaId) && Objects.equals(pizzaName, other.pizzaName)
				&& pizzaSize == other.pizzaSize && Objects.equals(pizzaType, other.pizzaType);
	}
	

}
