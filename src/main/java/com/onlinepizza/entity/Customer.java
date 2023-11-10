package com.onlinepizza.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Customer extends User {

	private Long customerMobile;
	private String customerName;
	private String customerEmail;
	private String customerAddress;

	
}
