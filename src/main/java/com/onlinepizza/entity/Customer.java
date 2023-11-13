package com.onlinepizza.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Customer extends User {

	@NotNull(message = "Mobile number cannot be null")
    private Long customerMobile;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String customerName;

    @Email(message = "Email should be valid")
    private String customerEmail;

    @NotBlank(message = "Address cannot be blank")
    private String customerAddress;


	
}
