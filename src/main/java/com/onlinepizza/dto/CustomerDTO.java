package com.onlinepizza.dto;

import java.util.Objects;

public class CustomerDTO extends UserDTO{
	private String customerName;
	private Long customerMobile;
	private String customerEmail;
	private String customerAddress;
	
	public CustomerDTO() {}

	public CustomerDTO(String customerName, Long customerMobile, String customerEmail, String customerAddress) {
		super();
		this.customerName = customerName;
		this.customerMobile = customerMobile;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(Long customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerName=" + customerName + ", customerMobile=" + customerMobile + ", customerEmail="
				+ customerEmail + ", customerAddress=" + customerAddress + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerAddress, customerEmail, customerMobile, customerName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDTO other = (CustomerDTO) obj;
		return Objects.equals(customerAddress, other.customerAddress)
				&& Objects.equals(customerEmail, other.customerEmail)
				&& Objects.equals(customerMobile, other.customerMobile)
				&& Objects.equals(customerName, other.customerName);
	}
	
}
