package com.onlinepizza.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "User_table")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	@NotBlank(message = "User must not be blank")
//	@Min(value = 5,message = "Username should be minimum length 5")
	private String userName;
	
	@NotBlank(message = "Password must not be blank")
//	@Min(value = 5,message = "")
	private String password;
	
	@NotNull(message = "Mobile number should be empty" )
//	@Pattern(regexp = "^[0-9]{10}")
	private Long contactNo;
	@NotBlank(message = "Email must not be blank")
	@Email
	private String email;
	
	@NotBlank(message = "City should Not be blank ")
	private String city;
	
	// Admin, Customer
	@NotBlank(message = "UserRoll must not be blank")
	private String userRole;

	
}
