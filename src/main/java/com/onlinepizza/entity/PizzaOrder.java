package com.onlinepizza.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;

import com.onlinepizza.util.PizzaStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table 
public class PizzaOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer bookingOrderId;
	
//	@Temporal(TemporalType.DATE)
	@CreatedDate
	@NotBlank(message="")
	private LocalDateTime dateTimeOfOrder;
	
	private Integer quantity;
	
	private Double totalCost;
	
    @OneToMany
    
	private List<Pizza> pizzaList;
	@OneToOne
	@Valid
	private Customer customer;
	
	@NotNull
	private PizzaStatus status;  //  
	
	

	
	
	

}
