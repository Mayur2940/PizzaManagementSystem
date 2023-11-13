package com.onlinepizza.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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
	@NotNull(message = "Date and time of order cannot be null")
	private LocalDateTime dateTimeOfOrder;
	
	@NotNull(message = "Quantity cannot be null")
    @Positive(message = "Quantity must be a positive value")
    private Integer quantity;
	
	@NotNull(message = "Total cost cannot be null")
    @Positive(message = "Total cost must be a positive value")
	private Double totalCost;
	
    @OneToMany
    private List<Pizza> pizzaList;
    
    
	@OneToOne
	@Valid
    @NotNull(message = "Customer cannot be null")
	private Customer customer;
	
	@NotNull(message = "Status cannot be null")
	private PizzaStatus status;  //  
	
	

	
	
	

}
