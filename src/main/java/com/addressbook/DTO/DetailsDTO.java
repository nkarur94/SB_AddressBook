package com.addressbook.DTO;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor

public @Data class DetailsDTO {
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "first name is invalid")
	public String firstName;
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "last name is invalid")
	public  String lastName;
	
	@NotBlank(message="address cannot be empty")
	public String address;
	
	@NotBlank(message="city cannot be empty")
	public String city;
	
	@NotBlank(message="state cannot be empty")
	public String state;
	
	
	@Pattern(regexp = "^[0-9]{3}\\s{0,1}[0-9]{3}$", message = "Zip Code Invalid")
	@NotNull(message="zipcode cannot be empty")
	public String zipCode;
	
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "invalid email address")
	public String eMail;
	
	@NotNull
	//@Pattern(regexp = "^[7-9][0-9]{9}$", message = "invalid phone no")
	public List<String> phoneNo;	

}
